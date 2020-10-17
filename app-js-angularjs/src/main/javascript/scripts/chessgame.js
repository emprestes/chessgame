angular.module('chessgame', ['chessboard'])
    .filter('trustAsHtml', ['$sce', ($sce) => $sce.trustAsHtml]);
