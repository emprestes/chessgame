package chessgame.domain.model

import chessgame.domain.PieceFactory.Companion.createBlackQueen
import chessgame.domain.PieceFactory.Companion.createWhiteQueen
import junitx.extensions.EqualsHashCodeTestCase

class BlackQueenFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("BlackQueenFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createBlackQueen(board)

    override fun createNotEqualInstance() = createWhiteQueen(board)
}

class WhiteQueenFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("WhiteQueenFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createWhiteQueen(board)

    override fun createNotEqualInstance() = createBlackQueen(board)
}