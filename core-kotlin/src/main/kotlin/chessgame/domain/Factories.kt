package chessgame.domain

import chessgame.domain.model.*
import chessgame.domain.model.BoardPosition.*
import chessgame.domain.model.PieceColor.BLACK
import chessgame.domain.model.PieceColor.WHITE

class PieceFactory {

    companion object {

        fun createBlackKing(board: Board) = create(board, E8, BLACK, King::class.java)

        fun createBlackQueen(board: Board) = createBlackQueen(board, D8)

        fun createBlackQueen(board: Board, position: BoardPosition) = create(board, position, BLACK, Queen::class.java)

        fun createBlackBishop(board: Board, position: BoardPosition) = create(board, position, BLACK, Queen::class.java)

        fun createBlackKnight(board: Board, position: BoardPosition) = create(board, position, BLACK, Knight::class.java)

        fun createBlackRook(board: Board, position: BoardPosition) = create(board, position, BLACK, Rook::class.java)

        fun createBlackPawn(board: Board, position: BoardPosition) = create(board, position, BLACK, Pawn::class.java)

        fun createWhiteKing(board: Board) = create(board, E1, WHITE, King::class.java)

        fun createWhiteQueen(board: Board) = createWhiteQueen(board, D1)

        fun createWhiteQueen(board: Board, position: BoardPosition) = create(board, position, WHITE, Queen::class.java)

        fun createWhiteBishop(board: Board, position: BoardPosition) = create(board, position, WHITE, Queen::class.java)

        fun createWhiteKnight(board: Board, position: BoardPosition) = create(board, position, WHITE, Knight::class.java)

        fun createWhiteRook(board: Board, position: BoardPosition) = create(board, position, WHITE, Rook::class.java)

        fun createWhitePawn(board: Board, position: BoardPosition) = create(board, position, WHITE, Pawn::class.java)

        fun createQueen(piece: Promotion) = create(piece.board, piece.position, piece.color, Queen::class.java)

        fun createKnight(piece: Promotion) = create(piece.board, piece.position, piece.color, Knight::class.java)

        fun createBishop(piece: Promotion) = create(piece.board, piece.position, piece.color, Bishop::class.java)

        fun createRook(piece: Promotion) = create(piece.board, piece.position, piece.color, Rook::class.java)

        @Throws(PieceException::class)
        private fun create(board: Board, position: BoardPosition, color: PieceColor, _class: Class<out Piece>): Piece {
            try {
                return _class.getConstructor(Board::class.java, PieceColor::class.java, BoardPosition::class.java)
                        .newInstance(board, color, position)
            } catch (cause: ReflectiveOperationException) {
                throw PieceException(cause)
            }
        }
    }
}