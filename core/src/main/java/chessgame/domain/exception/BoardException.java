package chessgame.domain.exception;

/**
 * Exception of chessboard.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
public class BoardException extends RuntimeException {

    /**
     * BoardException's constructor.
     *
     * @param message Message informed.
     */
    public BoardException(String message) {
        super(message);
    }

    /**
     * BoardException's constructor.
     *
     * @param message Message informed.
     * @param cause   Cause informed.
     */
    public BoardException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * BoardException's constructor.
     *
     * @param cause Cause informed.
     */
    public BoardException(Throwable cause) {
        super(cause);
    }
}
