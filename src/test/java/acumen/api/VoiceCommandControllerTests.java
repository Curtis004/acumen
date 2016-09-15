package acumen.api;

import acumen.domain.acumen.Intent;
import acumen.service.IntentService;
import acumen.service.StateService;
import acumen.service.WifiPlugService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoiceCommandControllerTests {
    @InjectMocks
    private VoiceCommandController voiceCommandController;

    @Mock
    private IntentService intentService;

    @Mock
    private WifiPlugService wifiPlugService;

    @Mock
    private StateService stateService;

    @Test
    public void testGetCommandReturnsTrueWithValidRequest() throws Exception {
        String room = "living room";
        String said = "Edwin lamps";

        Intent intent = mock(Intent.class);

        when(
                intentService.determineIntent(room, said)
        ).thenReturn(
                intent
        );

        when(
                wifiPlugService.process(intent)
        ).thenReturn(
                true
        );

        voiceCommandController.getCommand(room, said);

        verify(intentService).determineIntent(room, said);
        verify(wifiPlugService).process(intent);
        verify(stateService).update(intent);
    }
}
