package herokuapp.automation.exception;

public class HerokuappException extends RuntimeException {

    public HerokuappException(String msg) {
        super(msg);
    }

    public HerokuappException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
