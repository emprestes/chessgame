package chessgame.domain.model

import chessgame.domain.PieceFactory.Companion.createBlackBishop
import chessgame.domain.PieceFactory.Companion.createWhiteBishop
import chessgame.domain.model.BoardPosition.*
import junitx.extensions.EqualsHashCodeTestCase

class BlackBishopFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("BlackBishopFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createBlackBishop(board, A3)

    override fun createNotEqualInstance() = createBlackBishop(board, A6)
}

class WhiteBishopFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("WhiteBishopFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createWhiteBishop(board, H3)

    override fun createNotEqualInstance() = createWhiteBishop(board, H6)
}