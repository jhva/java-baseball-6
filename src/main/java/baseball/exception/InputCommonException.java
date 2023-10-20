package baseball.exception;

public class InputCommonException extends IllegalArgumentException {

    private final String msg;

    public InputCommonException(String msg) {
        this.msg = msg;
    }
}
