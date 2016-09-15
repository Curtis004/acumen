package acumen.domain.wifiplug;

public class Token {
    public String token;

    public Token(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}
