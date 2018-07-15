// Creating a module
const chessBoard = angular.module('chessboard', []);

// Create a directive
chessBoard.directive('chessBoard', function () {
    return {
        restrict: 'E',
        templateUrl: "../chessboard.html",
        controller: ['$board', function ($board) {
            const controller = this;
            controller.cols = $board.getColumns();
            controller.rows = $board.getRows();

            controller.getPiece = $board.getPiece;
        }],
        controllerAs: 'board'
    };
});

// Creating a service
chessBoard.service('$board', function () {
    const service = this;
    const pieces = [
        { initPos: 'A8', pos: 'A8', symbol: '&#9820;' },
        { initPos: 'B8', pos: 'B8', symbol: '&#9822;' },
        { initPos: 'C8', pos: 'C8', symbol: '&#9821;' },
        { initPos: 'D8', pos: 'D8', symbol: '&#9819;' },
        { initPos: 'E8', pos: 'E8', symbol: '&#9818;' },
        { initPos: 'F8', pos: 'F8', symbol: '&#9821;' },
        { initPos: 'G8', pos: 'G8', symbol: '&#9822;' },
        { initPos: 'H8', pos: 'H8', symbol: '&#9820;' },
        { initPos: 'A7', pos: 'A7', symbol: '&#9823;' },
        { initPos: 'B7', pos: 'B7', symbol: '&#9823;' },
        { initPos: 'C7', pos: 'C7', symbol: '&#9823;' },
        { initPos: 'D7', pos: 'D7', symbol: '&#9823;' },
        { initPos: 'E7', pos: 'E7', symbol: '&#9823;' },
        { initPos: 'F7', pos: 'F7', symbol: '&#9823;' },
        { initPos: 'G7', pos: 'G7', symbol: '&#9823;' },
        { initPos: 'H7', pos: 'H7', symbol: '&#9823;' },
        { initPos: 'A2', pos: 'A2', symbol: '&#9817;' },
        { initPos: 'B2', pos: 'B2', symbol: '&#9817;' },
        { initPos: 'C2', pos: 'C2', symbol: '&#9817;' },
        { initPos: 'D2', pos: 'D2', symbol: '&#9817;' },
        { initPos: 'E2', pos: 'E2', symbol: '&#9817;' },
        { initPos: 'F2', pos: 'F2', symbol: '&#9817;' },
        { initPos: 'G2', pos: 'G2', symbol: '&#9817;' },
        { initPos: 'H2', pos: 'H2', symbol: '&#9817;' },
        { initPos: 'A1', pos: 'A1', symbol: '&#9814;' },
        { initPos: 'B1', pos: 'B1', symbol: '&#9816;' },
        { initPos: 'C1', pos: 'C1', symbol: '&#9815;' },
        { initPos: 'D1', pos: 'D1', symbol: '&#9813;' },
        { initPos: 'E1', pos: 'E1', symbol: '&#9812;' },
        { initPos: 'F1', pos: 'F1', symbol: '&#9815;' },
        { initPos: 'G1', pos: 'G1', symbol: '&#9816;' },
        { initPos: 'H1', pos: 'H1', symbol: '&#9814;' }
    ];

    service.getColumns = () => ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'];
    service.getRows = () => [8, 7, 6, 5, 4, 3, 2, 1];
    service.getPiece = (col, row) => {
        const pos = col + row;

        return pieces
            .filter(piece => piece.pos === pos)
            .reduce((acc, piece) => piece.symbol, '');
    }
});
