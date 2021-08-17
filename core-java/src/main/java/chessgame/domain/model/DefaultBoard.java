package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import chessgame.domain.Player;
import chessgame.domain.exception.BoardException;

import java.util.Arrays;
import java.util.TreeMap;

import static chessgame.domain.model.PieceFactory.createBlackBishop;
import static chessgame.domain.model.PieceFactory.createBlackKing;
import static chessgame.domain.model.PieceFactory.createBlackKnight;
import static chessgame.domain.model.PieceFactory.createBlackPawn;
import static chessgame.domain.model.PieceFactory.createBlackQueen;
import static chessgame.domain.model.PieceFactory.createBlackRook;
import static chessgame.domain.model.PieceFactory.createWhiteBishop;
import static chessgame.domain.model.PieceFactory.createWhiteKing;
import static chessgame.domain.model.PieceFactory.createWhiteKnight;
import static chessgame.domain.model.PieceFactory.createWhitePawn;
import static chessgame.domain.model.PieceFactory.createWhiteQueen;
import static chessgame.domain.model.PieceFactory.createWhiteRook;

/**
 * Chessboard.
 *
 * @author Prestes, E. M.
 * @see Piece
 * @see Player
 * @since September 2016
 */
public class DefaultBoard extends TreeMap<BoardPosition, Piece> implements Board {

    private final Player whitePlayer;

    private final Player blackPlayer;

    /**
     * Default constructor
     */
    DefaultBoard() {
        super();

        this.whitePlayer = new HumanPlayer();
        this.blackPlayer = new HumanPlayer();
    }

    @Override
    public void init() {
        Arrays.stream(BoardPosition.values())
                .forEach(position -> put(position, null));
    }

    /**
     * Set up a chess game.
     */
    @Override
    public void start() {
        for (BoardPosition position : BoardPosition.values()) {
            switch (position) {
                case A1, H1 -> put(whitePlayer, createWhiteRook(this, position));
                case B1, G1 -> put(whitePlayer, createWhiteKnight(this, position));
                case C1, F1 -> put(whitePlayer, createWhiteBishop(this, position));
                case D1 -> put(whitePlayer, createWhiteQueen(this));
                case E1 -> put(whitePlayer, createWhiteKing(this));
                case A2, B2, C2, D2, E2, F2, G2, H2 -> put(whitePlayer, createWhitePawn(this, position));
                case A7, B7, C7, D7, E7, F7, G7, H7 -> put(blackPlayer, createBlackPawn(this, position));
                case A8, H8 -> put(blackPlayer, createBlackRook(this, position));
                case B8, G8 -> put(blackPlayer, createBlackKnight(this, position));
                case C8, F8 -> put(blackPlayer, createBlackBishop(this, position));
                case D8 -> put(blackPlayer, createBlackQueen(this));
                case E8 -> put(blackPlayer, createBlackKing(this));
                default -> put(position, null);
            }
        }
    }

    @Override
    public Piece get(BoardPosition key) {
        return super.get(key);
    }

    @Override
    public Piece get(String key) {
        return get(BoardPosition.valueOf(key));
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

    /**
     * {@inheritDoc}
     */
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
