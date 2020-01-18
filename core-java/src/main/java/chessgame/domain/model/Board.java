package chessgame.domain.model;

import chessgame.domain.Piece;
import chessgame.domain.Player;
import chessgame.domain.exception.BoardException;
import chessgame.domain.factory.PieceFactory;

import java.util.Arrays;
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
    }

    void init() {
        Arrays.stream(BoardPosition.values())
                .forEach(position -> put(position, null));
    }

    /**
     * Set up a chess game.
     */
    void start() {
        for (BoardPosition position : BoardPosition.values()) {
            switch (position) {
                case A1:
                case H1:
                    put(whitePlayer, PieceFactory.createWhiteRook(this, position));
                    break;
                case B1:
                case G1:
                    put(whitePlayer, PieceFactory.createWhiteKnight(this, position));
                    break;
                case C1:
                case F1:
                    put(whitePlayer, PieceFactory.createWhiteBishop(this, position));
                    break;
                case D1:
                    put(whitePlayer, PieceFactory.createWhiteQueen(this));
                    break;
                case E1:
                    put(whitePlayer, PieceFactory.createWhiteKing(this));
                    break;
                case A2:
                case B2:
                case C2:
                case D2:
                case E2:
                case F2:
                case G2:
                case H2:
                    put(whitePlayer, PieceFactory.createWhitePawn(this, position));
                    break;
                case A7:
                case B7:
                case C7:
                case D7:
                case E7:
                case F7:
                case G7:
                case H7:
                    put(blackPlayer, PieceFactory.createBlackPawn(this, position));
                    break;
                case A8:
                case H8:
                    put(blackPlayer, PieceFactory.createBlackRook(this, position));
                    break;
                case B8:
                case G8:
                    put(blackPlayer, PieceFactory.createBlackKnight(this, position));
                    break;
                case C8:
                case F8:
                    put(blackPlayer, PieceFactory.createBlackBishop(this, position));
                    break;
                case D8:
                    put(blackPlayer, PieceFactory.createBlackQueen(this));
                    break;
                case E8:
                    put(blackPlayer, PieceFactory.createBlackKing(this));
                    break;
                default:
                    put(position, null);
                    break;
            }
        }
    }

    Piece get(String key) {
        return super.get(BoardPosition.valueOf(key));
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
            if (value != null) {
                super.put(value.getPosition(), null);
                ((AbstractPiece) value).setPosition(key);
            }
            return super.put(key, value);
        }

        throw new BoardException("Board created! More positions aren't allowed!");
    }
}
