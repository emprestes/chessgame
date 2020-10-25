package chessgame.facade.mock

import chessgame.facade.BoardFacade

class MockBoardFacade: BoardFacade {

    override fun initBlackPieces(): Map<String, String> = mapOf(
            "A8" to "\u265C",
            "B8" to "\u265E",
            "C8" to "\u265D",
            "D8" to "\u265B",
            "E8" to "\u265A",
            "F8" to "\u265D",
            "G8" to "\u265E",
            "H8" to "\u265C",
            "A7" to "\u265F",
            "B7" to "\u265F",
            "C7" to "\u265F",
            "D7" to "\u265F",
            "E7" to "\u265F",
            "F7" to "\u265F",
            "G7" to "\u265F",
            "H7" to "\u265F")

    override fun initWhitePieces(): Map<String, String> = mapOf(
            "A1" to "\u2656",
            "B1" to "\u2658",
            "C1" to "\u2657",
            "D1" to "\u2655",
            "E1" to "\u2654",
            "F1" to "\u2657",
            "G1" to "\u2658",
            "H1" to "\u2656",
            "A2" to "\u2659",
            "B2" to "\u2659",
            "C2" to "\u2659",
            "D2" to "\u2659",
            "E2" to "\u2659",
            "F2" to "\u2659",
            "G2" to "\u2659",
            "H2" to "\u2659")
}
