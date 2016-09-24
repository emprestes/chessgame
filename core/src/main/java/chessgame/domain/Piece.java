package chessgame.domain;

import chessgame.domain.model.Board;
import chessgame.domain.model.BoardPosition;
import chessgame.domain.model.PieceColor;

import java.io.Serializable;
import java.util.Set;

public interface Piece extends Serializable {

    Board getBoard();

    PieceColor getColor();

    Piece setColor(PieceColor color);

    boolean canCapture(String position);

    boolean canMove(String position);

    Piece move(String position);

    Set<BoardPosition> getAvailablePosition();
}
