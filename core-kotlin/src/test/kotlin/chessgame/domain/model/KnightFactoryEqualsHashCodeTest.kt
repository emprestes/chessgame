package chessgame.domain.model

import chessgame.domain.PieceFactory.Companion.createBlackKnight
import chessgame.domain.PieceFactory.Companion.createWhiteKnight
import chessgame.domain.model.BoardPosition.*
import junitx.extensions.EqualsHashCodeTestCase

class BlackKnightFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("BlackKnightFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createBlackKnight(board, A2)

    override fun createNotEqualInstance() = createBlackKnight(board, A7)
}

class WhiteKnightFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("WhiteKnightFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createWhiteKnight(board, H2)

    override fun createNotEqualInstance() = createWhiteKnight(board, H7)
}