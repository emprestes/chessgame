package chessgame.domain.factory;

import chessgame.domain.Piece;
import chessgame.domain.exception.PieceException;
import chessgame.domain.model.BlackBishop;
import chessgame.domain.model.BlackKing;
import chessgame.domain.model.BlackKnight;
import chessgame.domain.model.BlackPawn;
import chessgame.domain.model.BlackQueen;
import chessgame.domain.model.BlackRook;
import chessgame.domain.model.Board;
import chessgame.domain.model.BoardPosition;
import chessgame.domain.model.WhiteBishop;
import chessgame.domain.model.WhiteKing;
import chessgame.domain.model.WhiteKnight;
import chessgame.domain.model.WhitePawn;
import chessgame.domain.model.WhiteQueen;
import chessgame.domain.model.WhiteRook;

import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.D8;
import static chessgame.domain.model.BoardPosition.E1;
import static chessgame.domain.model.BoardPosition.E8;

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
        return create(board, E8, BlackKing.class);
    }

    /**
     * Create a new instance of black queen.
     *
     * @param board Board informed.
     * @return Queen
     */
    public static Piece createBlackQueen(Board board) {
        return create(board, D8, BlackQueen.class);
    }

    /**
     * Create a new instance of black bishop.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Bishop
     */
    public static Piece createBlackBishop(Board board, BoardPosition position) {
        return create(board, position, BlackBishop.class);
    }

    /**
     * Create a new instance of black knight.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Knight
     */
    public static Piece createBlackKnight(Board board, BoardPosition position) {
        return create(board, position, BlackKnight.class);
    }

    /**
     * Create a new instance of black rook.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Rook
     */
    public static Piece createBlackRook(Board board, BoardPosition position) {
        return create(board, position, BlackRook.class);
    }

    /**
     * Create a new instance of black pawn.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Pawn
     */
    public static Piece createBlackPawn(Board board, BoardPosition position) {
        return create(board, position, BlackPawn.class);
    }

    /**
     * Create a new instance of white king.
     *
     * @param board Board informed.
     * @return King
     */
    public static Piece createWhiteKing(Board board) {
        return create(board, E1, WhiteKing.class);
    }

    /**
     * Create a new instance of white queen.
     *
     * @param board Board informed.
     * @return Queen
     */
    public static Piece createWhiteQueen(Board board) {
        return create(board, D1, WhiteQueen.class);
    }

    /**
     * Create a new instance of white bishop.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Bishop
     */
    public static Piece createWhiteBishop(Board board, BoardPosition position) {
        return create(board, position, WhiteBishop.class);
    }

    /**
     * Create a new instance of white knight.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Knight
     */
    public static Piece createWhiteKnight(Board board, BoardPosition position) {
        return create(board, position, WhiteKnight.class);
    }

    /**
     * Create a new instance of white rook.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Rook
     */
    public static Piece createWhiteRook(Board board, BoardPosition position) {
        return create(board, position, WhiteRook.class);
    }

    /**
     * Create a new instance of white pawn.
     *
     * @param board    Board informed.
     * @param position Position informed.
     * @return Pawn
     */
    public static Piece createWhitePawn(Board board, BoardPosition position) {
        return create(board, position, WhitePawn.class);
    }

    /**
     * @param board    Board informed.
     * @param position Board position informed.
     * @param classs   Piece class informed.
     * @return Piece Piece instance
     * @throws PieceException Throw this exception in a cause of instantiation problems.
     * @see Board
     * @see BoardPosition
     * @see Piece
     */
    private static Piece create(Board board, BoardPosition position, Class<? extends Piece> classs)
            throws PieceException {
        try {
            Piece piece = classs.getConstructor(Board.class)
                    .newInstance(board)
                    .moveTo(position);
            board.put(position, piece);
            return piece;
        } catch (ReflectiveOperationException cause) {
            throw new PieceException(cause);
        }
    }
}
