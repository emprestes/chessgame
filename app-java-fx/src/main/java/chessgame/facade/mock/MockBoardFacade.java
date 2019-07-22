package chessgame.facade.mock;

import chessgame.facade.BoardFacade;
import chessgame.facade.PieceFacade;

import java.util.LinkedHashMap;
import java.util.Map;

public class MockBoardFacade implements BoardFacade {

    @Override
    public Map<String, PieceFacade> initBlackPieces() {
        final Map<String, PieceFacade> map = new LinkedHashMap<>();

        map.put("A8", () -> "\u265C");
        map.put("B8", () -> "\u265E");
        map.put("C8", () -> "\u265D");
        map.put("D8", () -> "\u265B");
        map.put("E8", () -> "\u265A");
        map.put("F8", () -> "\u265D");
        map.put("G8", () -> "\u265E");
        map.put("H8", () -> "\u265C");
        map.put("A7", () -> "\u265F");
        map.put("B7", () -> "\u265F");
        map.put("C7", () -> "\u265F");
        map.put("D7", () -> "\u265F");
        map.put("E7", () -> "\u265F");
        map.put("F7", () -> "\u265F");
        map.put("G7", () -> "\u265F");
        map.put("H7", () -> "\u265F");

        return map;
    }

    @Override
    public Map<String, PieceFacade> initWhitePieces() {
        final Map<String, PieceFacade> map = new LinkedHashMap<>();

        map.put("A1", () -> "\u2656");
        map.put("B1", () -> "\u2658");
        map.put("C1", () -> "\u2657");
        map.put("D1", () -> "\u2655");
        map.put("E1", () -> "\u2654");
        map.put("F1", () -> "\u2657");
        map.put("G1", () -> "\u2658");
        map.put("H1", () -> "\u2656");
        map.put("A2", () -> "\u2659");
        map.put("B2", () -> "\u2659");
        map.put("C2", () -> "\u2659");
        map.put("D2", () -> "\u2659");
        map.put("E2", () -> "\u2659");
        map.put("F2", () -> "\u2659");
        map.put("G2", () -> "\u2659");
        map.put("H2", () -> "\u2659");

        return map;
    }
}
