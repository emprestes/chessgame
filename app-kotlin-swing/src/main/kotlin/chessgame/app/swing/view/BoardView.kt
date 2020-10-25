package chessgame.app.swing.view

import chessgame.app.swing.View
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import java.awt.Color
import java.awt.Color.GREEN
import java.awt.GridLayout
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.DataFlavor.allHtmlFlavor
import java.awt.datatransfer.Transferable
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.dnd.DnDConstants
import java.awt.dnd.DropTarget
import java.awt.dnd.DropTargetDropEvent
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.*
import java.util.regex.Pattern
import javax.swing.BorderFactory.createEtchedBorder
import javax.swing.BorderFactory.createSoftBevelBorder
import javax.swing.JComponent
import javax.swing.JEditorPane
import javax.swing.JTextPane
import javax.swing.TransferHandler
import javax.swing.TransferHandler.MOVE
import javax.swing.border.BevelBorder.RAISED
import javax.swing.border.Border


class BoardView(cols: Array<String>, rows: Array<String>) : View(GridLayout(cols.size, rows.size)) {

    companion object {
        private val SELECTED: Border = createSoftBevelBorder(RAISED, GREEN, GREEN)
        private val NORMAL: Border = createEtchedBorder()
        private val LOG: Logger = getLogger(BoardView::class.java)
    }

    init {
        init(cols, rows)
    }

    private fun init(cols: Array<String>, rows: Array<String>) {
        val black = Color(209, 139, 71)
        val white = Color(255, 206, 158)
        var color: Color
        var pos: String

        for (row in rows.indices.reversed()) {
            for (col in cols.indices) {
                val blockView = JTextPane()

                with(blockView) {
                    pos = cols[col] + rows[row]
                    name = pos
                    toolTipText = pos
                    contentType = "text/html"
                    isEditable = java.lang.Boolean.FALSE
                    dragEnabled = java.lang.Boolean.TRUE
                    transferHandler = PieceTransferHandler()
                    dropTarget = PositionDropTarget()
                    addMouseListener(PieceMouseAdapter())
                    border = NORMAL
                    color = if (row % 2 != 0 && col % 2 != 0 || row % 2 == 0 && col % 2 == 0) black else white
                    background = color
                    selectionColor = color

                }

                add(blockView)
            }
        }
    }

    fun add(pos: String?, piece: String) {
        val pieceView = ("<html>"
                + "<head><style>.piece {font-size: 35px;}</style></head>"
                + "<body class='piece'>"
                + "<center>"
                + piece
                + "</center>"
                + "</body>"
                + "</html>")

        Arrays.stream(components)
                .filter { block -> block is JTextPane }
                .map { block -> block as JTextPane }
                .filter { block -> block.name == pos }
                .filter { block -> !block.text.isEmpty }
                .findFirst()
                .ifPresent { found -> found.text = pieceView }
    }

    private class PieceMouseAdapter : MouseAdapter() {

        override fun mouseDragged(e: MouseEvent) {
            with (e.source as JComponent) {
                border = if (SELECTED == border) NORMAL else SELECTED
            }
        }

        override fun mouseEntered(e: MouseEvent) {
            with(e.source as JEditorPane) {
                selectAll()
            }
        }

        override fun mouseExited(e: MouseEvent) {
            with(e.source as JEditorPane) {
                select(0, 0)
            }
        }

        override fun mousePressed(e: MouseEvent) {
            with(e.source as JEditorPane) {
                if (!text.isEmpty) {
                    transferHandler.exportAsDrag(this, e, MOVE)
                    text = ""
                }
            }
        }

        override fun mouseMoved(e: MouseEvent) {
            with(e.source as JTextPane) {
                location = e.point
            }
        }
    }

    private class PieceTransferable(private val piece: String) : Transferable {

        override fun getTransferDataFlavors(): Array<DataFlavor> = arrayOf(allHtmlFlavor)

        override fun isDataFlavorSupported(flavor: DataFlavor): Boolean = allHtmlFlavor.equals(flavor)

        @Throws(UnsupportedFlavorException::class)
        override fun getTransferData(flavor: DataFlavor): Any =
                if (isDataFlavorSupported(flavor))
                    piece
                else
                    throw UnsupportedFlavorException(flavor)
    }

    private class PieceTransferHandler : TransferHandler() {

        override fun getSourceActions(c: JComponent): Int = MOVE

        override fun createTransferable(c: JComponent): Transferable? =
                if (c is JEditorPane)
                    PieceTransferable(c.text)
                else
                    super.createTransferable(c)
    }

    private class PositionDropTarget : DropTarget() {

        private val piecePattern = Pattern.compile("&[#]\\d{1,4};")

        fun setText(value: String?) {
            with(component as JTextPane) {
                text = value ?: ""
            }
        }

        val name: String
            get() = component.name

        @Synchronized
        override fun drop(event: DropTargetDropEvent) {
            try {
                val drop = event.source as PositionDropTarget
                val transferable = event.transferable
                var piece = transferable.getTransferData(allHtmlFlavor) as String
                val matcher = piecePattern.matcher(piece)
                event.acceptDrop(DnDConstants.ACTION_MOVE)
                if (matcher.find()) {
                    drop.setText(piece)
                    piece = matcher.group()
                    event.dropComplete(java.lang.Boolean.TRUE)
                }
                LOG.debug("{} {}", piece, drop.name)
            } catch (cause: Exception) {
                LOG.error("Problem moving piece", cause)
            }
        }
    }
}
