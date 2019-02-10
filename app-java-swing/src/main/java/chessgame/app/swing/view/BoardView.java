package chessgame.app.swing.view;

import chessgame.app.swing.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.TransferHandler;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Chessboard view.
 *
 * @author Prestes, E. M.
 * @see View
 * @see GridLayout
 * @since October 2016
 */
public class BoardView extends View {

    private static final Border SELECTED = BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN);
    private static final Border NORMAL = BorderFactory.createEtchedBorder();
    private static final Logger LOG = LoggerFactory.getLogger(BoardView.class);

    /**
     * Constructor composing by columns and rows informed.
     *
     * @param cols Columns
     * @param rows Rows
     */
    public BoardView(String[] cols, Integer[] rows) {
        super(new GridLayout(cols.length, rows.length));

        init(cols, rows);
    }

    /**
     * Behaviour to initialize view.
     *
     * @param cols Columns on the board
     * @param rows Rows on the board
     */
    private void init(String[] cols, Integer[] rows) {
        JTextPane block;
        Color b, w, color;
        String pos;

        b = new Color(209, 139, 71);
        w = new Color(255, 206, 158);

        for (int row = rows.length - 1; row >= 0; row--) {
            for (int col = 0; col < cols.length; col++) {
                block = new JTextPane();
                pos = cols[col] + rows[row];
                block.setName(pos);
                block.setToolTipText(pos);
                block.setContentType("text/html");
                block.setEditable(Boolean.FALSE);
                block.setDragEnabled(Boolean.TRUE);
                block.setTransferHandler(new PieceTransferHandler());
                block.setDropTarget(new PositionDropTarget());
                block.addMouseListener(new PieceMouseAdapter());
                block.setBorder(NORMAL);
                color = (row % 2 != 0 && col % 2 != 0) || (row % 2 == 0 && col % 2 == 0) ? b : w;
                block.setBackground(color);
                block.setSelectionColor(color);
                add(block);
            }
        }
    }

    /**
     * Adding Piece's symbol on specific position.
     *
     * @param pos   Position
     * @param piece Piece's symbol
     */
    public void add(String pos, final String piece) {
        Arrays.stream(getComponents())
                .filter(block -> block instanceof JTextPane)
                .map(block -> (JTextPane) block)
                .filter(block -> block.getName().equals(pos))
                .filter(block -> !block.getText().isEmpty())
                .findFirst()
                .ifPresent(found -> found.setText(String.format(
                        "<html><head><style>.piece {font-size: 35px;}</style></head><body class='piece'><center>%s</center</body></html>", piece)));
    }

    private class PieceMouseAdapter extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            JComponent block = (JComponent) e.getSource();
            Border border = block.getBorder();

            if (SELECTED.equals(border)) {
                block.setBorder(NORMAL);
            } else {
                block.setBorder(SELECTED);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ((JEditorPane) e.getSource()).selectAll();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ((JEditorPane) e.getSource()).select(0, 0);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JEditorPane c = (JEditorPane) e.getSource();
            String p = c.getText();
            if (!p.isEmpty()) {
                TransferHandler th = c.getTransferHandler();
                th.exportAsDrag(c, e, TransferHandler.MOVE);
                c.setText("");
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            ((JTextPane) e.getSource()).setLocation(e.getPoint());
        }
    }

    private class PieceTransferable implements Transferable {

        private final Object piece;

        private PieceTransferable(String piece) {
            super();
            this.piece = piece;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{DataFlavor.allHtmlFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return DataFlavor.allHtmlFlavor.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (isDataFlavorSupported(flavor)) {
                return piece;
            }

            throw new UnsupportedFlavorException(flavor);
        }
    }

    private class PieceTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            if (c instanceof JEditorPane) {
                return new PieceTransferable(((JEditorPane) c).getText());
            }

            return super.createTransferable(c);
        }
    }

    private class PositionDropTarget extends DropTarget {

        private final Pattern piecePattern = Pattern.compile("&[#]\\d{1,4};");

        void setText(String value) {
            value = value == null ? "" : value;
            ((JTextPane) getComponent()).setText(value);
        }

        String getName() {
            return getComponent().getName();
        }

        @Override
        public synchronized void drop(DropTargetDropEvent event) {
            try {
                PositionDropTarget drop = (PositionDropTarget) event.getSource();
                Transferable transferable = event.getTransferable();
                String piece = (String) transferable.getTransferData(DataFlavor.allHtmlFlavor);
                Matcher matcher = piecePattern.matcher(piece);

                event.acceptDrop(DnDConstants.ACTION_MOVE);

                if (matcher.find()) {
                    drop.setText(piece);
                    piece = matcher.group();
                    event.dropComplete(Boolean.TRUE);
                }

                LOG.debug(String.format("%s %s", piece, drop.getName()));
            } catch (Exception cause) {
                LOG.error("Problem moving piece", cause);
            }
        }
    }
}
