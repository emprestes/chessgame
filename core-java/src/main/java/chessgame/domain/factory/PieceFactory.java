package chessgame.domain.factory;

import chessgame.domain.Piece;
import chessgame.domain.exception.PieceException;
import chessgame.domain.model.Bishop;
import chessgame.domain.model.Board;
import chessgame.domain.model.BoardPosition;
import chessgame.domain.model.King;
import chessgame.domain.model.Knight;
import chessgame.domain.model.Pawn;
import chessgame.domain.model.PieceColor;
import chessgame.domain.model.Queen;
import chessgame.domain.model.Rook;

import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.D8;
import static chessgame.domain.model.BoardPosition.E1;
import static chessgame.domain.model.BoardPosition.E8;
import static chessgame.domain.model.PieceColor.BLACK;
import static chessgame.domain.model.PieceColor.WHITE;

/**
 * Factory to create chess pieces.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
public final class PieceFactory {

    /**
     * Private default constructor.
     */
    private PieceFactory() {
        super();
    }

    /**
     * Create a new instance of black king.
     *
     * @param board Board informed.
     * @return King
     */
    public static Piece createBlackKing(Board board) {
        return create(board, E8, BLACK, King.class);
    }

    /**
     * Create a new instance of black queen.
     *
     * @param board Board informed.
     * @return Queen
     */
    public static Piece createBlackQueen(Board board) {
        return create(board, D8, BLACK, Queen.class);
    }

    /**
     * Create a new instance of black bishop.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Bishop
     */
    public static Piece createBlackBishop(Board board, BoardPosition position) {
        return create(board, position, BLACK, Bishop.class);
    }

    /**
     * Create a new instance of black knight.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Knight
     */
    public static Piece createBlackKnight(Board board, BoardPosition position) {
        return create(board, position, BLACK, Knight.class);
    }

    /**
     * Create a new instance of black rook.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Rook
     */
    public static Piece createBlackRook(Board board, BoardPosition position) {
        return create(board, position, BLACK, Rook.class);
    }

    /**
     * Create a new instance of black pawn.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Pawn
     */
    public static Piece createBlackPawn(Board board, BoardPosition position) {
        return create(board, position, BLACK, Pawn.class);
    }

    /**
     * Create a new instance of white king.
     *
     * @param board Board informed.
     * @return King
     */
    public static Piece createWhiteKing(Board board) {
        return create(board, E1, WHITE, King.class);
    }

    /**
     * Create a new instance of white queen.
     *
     * @param board Board informed.
     * @return Queen
     */
    public static Piece createWhiteQueen(Board board) {
        return create(board, D1, WHITE, Queen.class);
    }

    /**
     * Create a new instance of white bishop.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Bishop
     */
    public static Piece createWhiteBishop(Board board, BoardPosition position) {
        return create(board, position, WHITE, Bishop.class);
    }

    /**
     * Create a new instance of white knight.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Knight
     */
    public static Piece createWhiteKnight(Board board, BoardPosition position) {
        return create(board, position, WHITE, Knight.class);
    }

    /**
     * Create a new instance of white rook.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Rook
     */
    public static Piece createWhiteRook(Board board, BoardPosition position) {
        return create(board, position, WHITE, Rook.class);
    }

    /**
     * Create a new instance of white pawn.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Pawn
     */
    public static Piece createWhitePawn(Board board, BoardPosition position) {
        return create(board, position, WHITE, Pawn.class);
    }

    /**
     * @param board    Board informed.
     * @param position Board position informed.
     * @param color    Piece color informed.
     * @param classs   Piece class informed.
     * @return Piece
     * @throws PieceException Throw this exception in a cause of instantiation problems.
     * @see Board
     * @see BoardPosition
     * @see PieceColor
     * @see Piece
     */
    private static Piece create(Board board, BoardPosition position, PieceColor color, Class<? extends Piece> classs)
            throws PieceException {
        try {
            Piece piece = classs.getConstructor(Board.class, PieceColor.class)
                    .newInstance(board, color)
                    .moveTo(position);
            board.put(position, piece);
            return piece;
        } catch (ReflectiveOperationException cause) {
            throw new PieceException(cause);
        }
    }
}
