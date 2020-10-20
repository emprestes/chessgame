package chessgame.domain.exception;

/**
 * Exception of chess piece.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
public class PieceException extends RuntimeException {

    /**
     * PieceException's constructor.
     *
     * @param message Message informed.
     */
    public PieceException(String message) {
        super(message);
    }

    /**
     * PieceException's constructor.
     *
     * @param message Message informed.
     * @param cause   Cause informed.
     */
    public PieceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * PieceException's constructor.
     *
     * @param cause Cause informed.
     */
    public PieceException(Throwable cause) {
        super(cause);
    }
}
