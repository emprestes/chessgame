package chessgame.domain.model

class Queen(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color) {

    override fun getAvailablePositions(): Set<BoardPosition> {
        val availablePositions = mutableSetOf<BoardPosition>()

        collectColumns(position, availablePositions)
        collectRows(position, availablePositions)
        collectDiagonals(position, availablePositions)

        return availablePositions
    }
}