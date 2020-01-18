package chessgame.domain.model

import chessgame.domain.PieceFactory.Companion.createBlackKing
import chessgame.domain.PieceFactory.Companion.createWhiteKing
import junitx.extensions.EqualsHashCodeTestCase

class BlackKingFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("BlackKingFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createBlackKing(board)

    override fun createNotEqualInstance() = createWhiteKing(board)
}

class WhiteKingFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("WhiteKingFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createWhiteKing(board)

    override fun createNotEqualInstance() = createBlackKing(board)
}