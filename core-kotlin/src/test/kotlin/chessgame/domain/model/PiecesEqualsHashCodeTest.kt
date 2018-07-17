package chessgame.domain.model

import chessgame.domain.model.BoardPosition.A1
import chessgame.domain.model.BoardPosition.A8
import chessgame.domain.model.PieceColor.BLACK
import chessgame.domain.model.PieceColor.WHITE
import junitx.extensions.EqualsHashCodeTestCase

class KingEqualsHashCodeTest : EqualsHashCodeTestCase("KingEqualsHashCodeTest") {

    override fun createInstance() = King(Board(), BLACK, A1)

    override fun createNotEqualInstance() = King(Board(), WHITE, A8)
}

class QueenEqualsHashCodeTest : EqualsHashCodeTestCase("QueenEqualsHashCodeTest") {

    override fun createInstance() = Queen(Board(), BLACK, A1)

    override fun createNotEqualInstance() = Queen(Board(), WHITE, A8)
}

class BishopEqualsHashCodeTest : EqualsHashCodeTestCase("BishopEqualsHashCodeTest") {

    override fun createInstance() = Bishop(Board(), BLACK, A1)

    override fun createNotEqualInstance() = Bishop(Board(), WHITE, A8)
}

class KnightEqualsHashCodeTest : EqualsHashCodeTestCase("KnightEqualsHashCodeTest") {

    override fun createInstance() = Knight(Board(), BLACK, A1)

    override fun createNotEqualInstance() = Knight(Board(), WHITE, A8)
}

class RookEqualsHashCodeTest : EqualsHashCodeTestCase("RookEqualsHashCodeTest") {

    override fun createInstance() = Rook(Board(), BLACK, A1)

    override fun createNotEqualInstance() = Rook(Board(), WHITE, A8)
}

class PawnEqualsHashCodeTest : EqualsHashCodeTestCase("PawnEqualsHashCodeTest") {

    override fun createInstance() = Pawn(Board(), BLACK, A1)

    override fun createNotEqualInstance() = Pawn(Board(), WHITE, A8)
}