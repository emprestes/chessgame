package chessgame.domain.model

import java.util.stream.Collectors.toSet


class King(board: Board, color: PieceColor) : AbstractPiece(board, color) {

    override fun getAvailablePositions(): Set<BoardPosition> = setOf(
            position!!.nextRow(), position!!.previousRow(),
            position!!.nextColumn(), position!!.previousColumn(),
            position!!.diagonalLeftDown(), position!!.diagonalLeftUp(),
            position!!.diagonalRightDown(), position!!.diagonalRightUp()).stream()
            .filter { position!!.nonEquals(it) }
            .filter { isEmptyBoardPosition(it) }
            .collect(toSet())
}