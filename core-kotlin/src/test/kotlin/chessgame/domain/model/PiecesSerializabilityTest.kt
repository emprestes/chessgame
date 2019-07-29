package chessgame.domain.model

import chessgame.domain.model.BoardPosition.*
import chessgame.domain.model.PieceColor.BLACK
import chessgame.domain.model.PieceColor.WHITE
import junitx.extensions.SerializabilityTestCase

class KingSerializabilityTest : SerializabilityTestCase("KingSerializabilityTest") {

    override fun createInstance() = King(Board(), BLACK).moveTo(A1)
}

class QueenSerializabilityTest : SerializabilityTestCase("QueenSerializabilityTest") {

    override fun createInstance() = Queen(Board(), WHITE).moveTo(B1)
}

class BishopSerializabilityTest : SerializabilityTestCase("BishopSerializabilityTest") {

    override fun createInstance() = Bishop(Board(), BLACK).moveTo(C1)
}

class KnightSerializabilityTest : SerializabilityTestCase("KnightSerializabilityTest") {

    override fun createInstance() = Knight(Board(), WHITE).moveTo(D1)
}

class RookSerializabilityTest : SerializabilityTestCase("RookSerializabilityTest") {

    override fun createInstance() = Rook(Board(), BLACK).moveTo(E1)
}

class PawnSerializabilityTest : SerializabilityTestCase("PawnSerializabilityTest") {

    override fun createInstance() = Pawn(Board(), WHITE).moveTo(F1)
}