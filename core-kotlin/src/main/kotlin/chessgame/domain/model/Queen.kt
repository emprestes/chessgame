package chessgame.domain.model

class Queen(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color) {

    override fun getAvailablePositions(): Set<BoardPosition> {
        val availablePositions = mutableSetOf<BoardPosition>()

        with(availablePositions) {
            addAll(collectColumns(position))
            addAll(collectRows(position))
            addAll(collectDiagonals(position))
        }

        return availablePositions
    }
}