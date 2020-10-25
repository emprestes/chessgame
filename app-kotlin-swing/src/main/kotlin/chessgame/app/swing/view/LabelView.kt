package chessgame.app.swing.view

import chessgame.app.swing.View
import java.awt.BorderLayout
import java.awt.BorderLayout.EAST
import java.awt.BorderLayout.WEST
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.LayoutManager
import javax.swing.BorderFactory.createEtchedBorder
import javax.swing.JLabel
import javax.swing.SwingConstants.CENTER
import javax.swing.border.Border

class LabelView private constructor(layout: LayoutManager): View(layout) {

    private constructor(): this(BorderLayout())

    private constructor(rows: Int, cols: Int): this(GridLayout(rows, cols))

    companion object {

        fun createCols(items: Array<String>): LabelView {
            val view = LabelView()
            val d = Dimension(14, 0)
            val b = createEtchedBorder()
            var labels = LabelView(1, items.size)
            labels = create(labels, false, items)
            view.add(createLabel(d, b), WEST)
            view.add(labels, CENTER)
            view.add(createLabel(d, b), EAST)
            return view
        }

        private fun createLabel(d: Dimension, b: Border): JLabel = with(JLabel()) {
            minimumSize = d
            preferredSize = d
            maximumSize = d
            border = b

            this
        }

        fun createRows(items: Array<String>): LabelView {
            val view = LabelView(items.size, 1)
            return create(view, true, items)
        }

        private fun create(view: LabelView, invert: Boolean, items: Array<String>): LabelView {
            var row: JLabel
            var i = if (invert) items.size - 1 else 0

            while (if (invert) i >= 0 else i < items.size) {
                row = JLabel(items[i], CENTER)
                row.border = createEtchedBorder()
                view.add(row)
                if (invert) {
                    i--
                } else {
                    i++
                }
            }

            return view
        }
    }
}
