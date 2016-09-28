package chessgame.domain;

import chessgame.domain.exception.PieceException;
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
 * Chess game piece with available behaviours to use into a game.
 *
 * @author Prestes, E. M.
 * @see Serializable
 * @since September 2016
 */
public interface Piece extends Serializable {

    Board getBoard();

    PieceColor getColor();

    BoardPosition getPosition();

    Piece setPosition(BoardPosition position);

    /**
     * Recovering available positions of a piece.
     *
     * @return Set
     */
    Set<BoardPosition> getAvailablePositions();

    default Piece createBlackKing(Board board) throws PieceException {
        return PieceFactory.create(board, E8, BLACK, King.class);
    }

    default Piece createBlackQueen(Board board) throws PieceException {
        return PieceFactory.create(board, D8, BLACK, Queen.class);
    }

    default Piece createBlackBishop(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, BLACK, Queen.class);
    }

    default Piece createBlackKnight(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, BLACK, Knight.class);
    }

    default Piece createBlackRook(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, BLACK, Rook.class);
    }

    default Piece createBlackPawn(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, BLACK, Pawn.class);
    }

    default Piece createWhiteKing(Board board) throws PieceException {
        return PieceFactory.create(board, E1, WHITE, King.class);
    }

    default Piece createWhiteQueen(Board board) throws PieceException {
        return PieceFactory.create(board, D1, WHITE, Queen.class);
    }

    default Piece createWhiteBishop(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, WHITE, Queen.class);
    }

    default Piece createWhiteKnight(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, WHITE, Knight.class);
    }

    default Piece createWhiteRook(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, WHITE, Rook.class);
    }

    default Piece createWhitePawn(Board board, BoardPosition position) throws PieceException {
        return PieceFactory.create(board, position, WHITE, Pawn.class);
    }
}
