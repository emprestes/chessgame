import Optional from 'optional-js'

const columns = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'];

const BoardPosition = [
    valueOf(1, 1), valueOf(1, 2), valueOf(1, 3), valueOf(1, 4),
    valueOf(1, 5), valueOf(1, 6), valueOf(1, 7), valueOf(1, 8),
    valueOf(2, 1), valueOf(2, 2), valueOf(2, 3), valueOf(2, 4),
    valueOf(2, 5), valueOf(2, 6), valueOf(2, 7), valueOf(2, 8),
    valueOf(3, 1), valueOf(3, 2), valueOf(3, 3), valueOf(3, 4),
    valueOf(3, 5), valueOf(3, 6), valueOf(3, 7), valueOf(3, 8),
    valueOf(4, 1), valueOf(4, 2), valueOf(4, 3), valueOf(4, 4),
    valueOf(4, 5), valueOf(4, 6), valueOf(4, 7), valueOf(4, 8),
    valueOf(5, 1), valueOf(5, 2), valueOf(5, 3), valueOf(5, 4),
    valueOf(5, 5), valueOf(5, 6), valueOf(5, 7), valueOf(5, 8),
    valueOf(6, 1), valueOf(6, 2), valueOf(6, 3), valueOf(6, 4),
    valueOf(6, 5), valueOf(6, 6), valueOf(6, 7), valueOf(6, 8),
    valueOf(7, 1), valueOf(7, 2), valueOf(7, 3), valueOf(7, 4),
    valueOf(7, 5), valueOf(7, 6), valueOf(7, 7), valueOf(7, 8),
    valueOf(8, 1), valueOf(8, 2), valueOf(8, 3), valueOf(8, 4),
    valueOf(8, 5), valueOf(8, 6), valueOf(8, 7), valueOf(8, 8)
];

const get = (_column, _row) => BoardPosition.find(({column, row}) => _column === column && _row === row);

function isFirstColumn() {
    return this.column === 1;
}

function nonFirstColumn() {
    return !isFirstColumn();
}

function isLastColumn() {
    return this.column === 8;
}

function nonLastColumn() {
    return !isLastColumn();
}

function isFirstRow() {
    return this.row === 1;
}

function nonFirstRow() {
    return !isFirstRow();
}

function isLastRow() {
    return this.row === 8;
}

function nonLastRow() {
    return !isLastRow();
}

function nonEquals(position) {
    return this !== position;
}

function nextColumn() {
    return Optional.of(this)
        .filter(position => position.isLastColumn())
        .orElse(get(this.column + 1, this.row));
}

function previousColumn() {
    return get(this.column - 1, this.row);
}

function nextRow() {
    const column = this.column;
    const row = this.row;
    return Optional.of(this)
        .filter(position => position.isLastRow())
        .orElse(get(column, row + 1));
}

function previousRow() {
    return get(this.column, this.row - 1);
}

function diagonalLeftUp() {
    return this.previousColumn().nextRow();
}

function diagonalLeftDown() {
    return this.previousColumn().previousRow();
}

function diagonalRightUp() {
    return this.nextColumn().nextRow();
}

function diagonalRightDown() {
    return this.nextColumn().previousRow();
}

const valueOf = (column, row) => {
    return {
        label: `${columns[column - 1]}${row}`,
        value: undefined,
        column, row,
        isFirstColumn,
        nonFirstColumn,
        isLastColumn,
        nonLastColumn,
        isFirstRow,
        nonFirstRow,
        isLastRow,
        nonLastRow,
        nextColumn,
        previousColumn,
        nextRow,
        previousRow,
        diagonalLeftUp,
        diagonalLeftDown,
        diagonalRightUp,
        diagonalRightDown
    }
};

export default BoardPosition