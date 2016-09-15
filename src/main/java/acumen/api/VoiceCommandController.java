package acumen.api;

import acumen.domain.acumen.Intent;
import acumen.service.IntentService;
import acumen.service.StateService;
import acumen.service.WifiPlugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "voice")
public class VoiceCommandController {
    @Autowired
    private IntentService intentService;

    @Autowired
    private WifiPlugService wifiPlugService;

    @Autowired
    private StateService stateService;

    @RequestMapping(path = "command", method = RequestMethod.POST)
    public void getCommand(
            @RequestParam(name = "room", required = false, defaultValue = "") String room,
            @RequestBody String said
    ) {
        Intent intent = intentService.determineIntent(room, said);

        boolean processed = wifiPlugService.process(intent);

        if(processed) {
            stateService.update(intent);
        }
    }
}
