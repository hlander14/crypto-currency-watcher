package by.myself.crypto.exception_handling;

public class NoSuchCryptoException extends RuntimeException {
    public NoSuchCryptoException() {
    }

    public NoSuchCryptoException(String message) {
        super(message);
    }

    public NoSuchCryptoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCryptoException(Throwable cause) {
        super(cause);
    }

    public NoSuchCryptoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
