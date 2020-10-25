package chessgame.facade

interface BoardFacade {

    fun initBlackPieces(): Map<String, String>

    fun initWhitePieces(): Map<String, String>
}