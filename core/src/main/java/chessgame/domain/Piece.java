package chessgame.domain;

import chessgame.domain.model.Board;
import chessgame.domain.model.BoardPosition;
import chessgame.domain.model.King;
import chessgame.domain.model.Knight;
import chessgame.domain.model.Pawn;
import chessgame.domain.model.PieceColor;
import chessgame.domain.model.Queen;
import chessgame.domain.model.Rook;

import java.io.Serializable;
import java.util.Set;

import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.D8;
import static chessgame.domain.model.BoardPosition.E1;
import static chessgame.domain.model.BoardPosition.E8;
import static chessgame.domain.model.PieceColor.BLACK;
import static chessgame.domain.model.PieceColor.WHITE;

/**
 * Interface of chess piece with available behaviours to use into a match.
 *
 * @author Prestes, E. M.
 * @see Serializable
 * @since September 2016
 */
public interface Piece extends Serializable {

    /**
     * Create a new instance of black king.
     *
     * @param board Board informed.
     * @return King
     */
    static Piece createBlackKing(Board board) {
        return PieceFactory.create(board, E8, BLACK, King.class);
    }

    /**
     * Create a new instance of black queen.
     *
     * @param board Board informed.
     * @return Queen
     */
    static Piece createBlackQueen(Board board) {
        return PieceFactory.create(board, D8, BLACK, Queen.class);
    }

    /**
     * Create a new instance of black bishop.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Bishop
     */
    static Piece createBlackBishop(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, BLACK, Queen.class);
    }

    /**
     * Create a new instance of black knight.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Knight
     */
    static Piece createBlackKnight(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, BLACK, Knight.class);
    }

    /**
     * Create a new instance of black rook.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Rook
     */
    static Piece createBlackRook(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, BLACK, Rook.class);
    }

    /**
     * Create a new instance of black pawn.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Pawn
     */
    static Piece createBlackPawn(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, BLACK, Pawn.class);
    }

    /**
     * Create a new instance of white king.
     *
     * @param board Board informed.
     *
     * @return King
     */
    static Piece createWhiteKing(Board board) {
        return PieceFactory.create(board, E1, WHITE, King.class);
    }

    /**
     * Create a new instance of white queen.
     *
     * @param board Board informed.
     *
     * @return Queen
     */
    static Piece createWhiteQueen(Board board) {
        return PieceFactory.create(board, D1, WHITE, Queen.class);
    }

    /**
     * Create a new instance of white bishop.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Bishop
     */
    static Piece createWhiteBishop(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, WHITE, Queen.class);
    }

    /**
     * Create a new instance of white knight.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Knight
     */
    static Piece createWhiteKnight(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, WHITE, Knight.class);
    }

    /**
     * Create a new instance of white rook.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Rook
     */
    static Piece createWhiteRook(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, WHITE, Rook.class);
    }

    /**
     * Create a new instance of white pawn.
     *
     * @param board Board informed.
     * @param position Position informed.
     *
     * @return Pawn
     */
    static Piece createWhitePawn(Board board, BoardPosition position) {
        return PieceFactory.create(board, position, WHITE, Pawn.class);
    }

    /**
     * Recovery current board.
     *
     * @return Board
     */
    Board getBoard();

    /**
     * Recovery current color of chess piece.
     *
     * @return PieceColor
     */
    PieceColor getColor();

    /**
     * Recovery current position of chess piece.
     *
     * @return BoardPosition
     */
    BoardPosition getPosition();

    /**
     * Set a new position to a chess piece.
     *
     * @param position New position
     *
     * @return Piece
     */
    Piece setPosition(BoardPosition position);

    /**
     * Recovery available positions of a piece.
     *
     * @return Set
     */
    Set<BoardPosition> getAvailablePositions();
}
