package chessgame.domain.model

class Bishop(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color) {

    override fun getAvailablePositions(): Set<BoardPosition> = collectDiagonals(position)
}