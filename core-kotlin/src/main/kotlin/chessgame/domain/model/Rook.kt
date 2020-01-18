package chessgame.domain.model

import chessgame.domain.SpecialMovement

class Rook(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color), SpecialMovement {

    override fun getAvailablePositions(): Set<BoardPosition> {
        val availablePositions = mutableSetOf<BoardPosition>()

        collectColumns(position, availablePositions)
        collectRows(position, availablePositions)

        return availablePositions
    }
}