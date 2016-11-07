package chessgame.domain.model;

import chessgame.domain.Piece;
import chessgame.domain.Player;
import chessgame.domain.exception.BoardException;

import java.util.TreeMap;

/**
 * Chessboard.
 *
 * @author Prestes, E. M.
 * @see Piece
 * @see Player
 * @since September 2016
 */
public class Board extends TreeMap<BoardPosition, Piece> {

    private final Player whitePlayer;

    private final Player blackPlayer;

    /**
     * Default constructor
     */
    public Board() {
        super();

        this.whitePlayer = new HumanPlayer();
        this.blackPlayer = new HumanPlayer();

        init();
    }

    /**
     * Set up a chess game.
     *
     * @return Board
     */
    private Board init() {
        for (BoardPosition p : BoardPosition.values()) {
            switch (p) {
                case A1:
                case H1:
                    put(whitePlayer, Piece.createWhiteRook(this, p));
                    break;
                case B1:
                case G1:
                    put(whitePlayer, Piece.createWhiteKnight(this, p));
                    break;
                case C1:
                case F1:
                    put(whitePlayer, Piece.createWhiteBishop(this, p));
                    break;
                case D1:
                    put(whitePlayer, Piece.createWhiteQueen(this));
                    break;
                case E1:
                    put(whitePlayer, Piece.createWhiteKing(this));
                    break;
                case A2:
                case B2:
                case C2:
                case D2:
                case E2:
                case F2:
                case G2:
                case H2:
                    put(whitePlayer, Piece.createWhitePawn(this, p));
                    break;
                case A7:
                case B7:
                case C7:
                case D7:
                case E7:
                case F7:
                case G7:
                case H7:
                    put(blackPlayer, Piece.createBlackPawn(this, p));
                    break;
                case A8:
                case H8:
                    put(blackPlayer, Piece.createBlackRook(this, p));
                    break;
                case B8:
                case G8:
                    put(blackPlayer, Piece.createBlackKnight(this, p));
                    break;
                case C8:
                case F8:
                    put(blackPlayer, Piece.createBlackBishop(this, p));
                    break;
                case D8:
                    put(blackPlayer, Piece.createBlackQueen(this));
                    break;
                case E8:
                    put(blackPlayer, Piece.createBlackKing(this));
                    break;
                default:
                    put(p, null);
                    break;
            }
        }

        return this;
    }

    /**
     * Put chess piece of a relevant player on the chessboard.
     *
     * @param player Player informed.
     * @param piece  Piece informed.
     * @return Piece
     */
    private Piece put(Player player, Piece piece) {
        player.add(piece);
        return super.put(piece.getPosition(), piece);
    }

    /** {@inheritDoc} */
    @Override
    public Piece put(BoardPosition key, Piece value) {
        if (size() <= BoardPosition.values().length) {
            return super.put(key, value);
        }

        throw new BoardException("Board created! More positions aren't allow!");
    }
}
