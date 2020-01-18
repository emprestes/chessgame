package chessgame.domain.model

import chessgame.domain.PieceFactory.Companion.createBlackRook
import chessgame.domain.PieceFactory.Companion.createWhiteRook
import chessgame.domain.model.BoardPosition.*
import junitx.extensions.EqualsHashCodeTestCase

class BlackRookFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("BlackRookFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createBlackRook(board, A1)

    override fun createNotEqualInstance() = createBlackRook(board, A8)
}

class WhiteRookFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("WhiteRookFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createWhiteRook(board, H1)

    override fun createNotEqualInstance() = createWhiteRook(board, H8)
}