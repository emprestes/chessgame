package chessgame.facade;

import java.util.Map;

public interface BoardFacade {

    Map<String, PieceFacade> initBlackPieces();

    Map<String, PieceFacade> initWhitePieces();
}
