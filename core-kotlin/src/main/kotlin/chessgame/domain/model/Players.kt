package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.Player
import java.util.*

class HumanPlayer : Player {

    private val pieces = TreeSet<Piece>()

    override fun add(piece: Piece): Player {
        pieces.add(piece)
        return this
    }
}
