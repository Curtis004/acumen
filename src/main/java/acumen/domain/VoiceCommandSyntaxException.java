package acumen.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VoiceCommandSyntaxException extends RuntimeException {
    public VoiceCommandSyntaxException(String s) {
        super(s);
    }
}
