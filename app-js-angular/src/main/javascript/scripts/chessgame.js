// Creating a module
const chessGame = angular.module('chessgame', ['chessboard']);

// Creating a filter
chessGame.filter('trustAsHtml', ['$sce', function ($sce) {
    return $sce.trustAsHtml;
}]);
