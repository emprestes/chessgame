package chessgame.domain.model

import chessgame.domain.PieceFactory.Companion.createBlackPawn
import chessgame.domain.PieceFactory.Companion.createWhitePawn
import chessgame.domain.model.BoardPosition.*
import junitx.extensions.EqualsHashCodeTestCase

class BlackPawnFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("BlackPawnFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createBlackPawn(board, B1)

    override fun createNotEqualInstance() = createBlackPawn(board, B8)
}

class WhitePawnFactoryEqualsHashCodeTest : EqualsHashCodeTestCase("WhitePawnFactoryEqualsHashCodeTest") {

    private val board: Board = Board()

    override fun createInstance() = createWhitePawn(board, G1)

    override fun createNotEqualInstance() = createWhitePawn(board, G8)
}