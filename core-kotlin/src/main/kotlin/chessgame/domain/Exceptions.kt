package chessgame.domain

class BoardException(override var message: String) : Exception(message)

class PieceException(override var cause: Throwable) : Exception(cause)
