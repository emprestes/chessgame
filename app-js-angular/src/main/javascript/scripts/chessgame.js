var app = angular.module('chessgame', [ 'chessboard' ]);

app.filter('trustAsHtml', ['$sce', function ($sce) {
    return function(value) {
        return $sce.trustAsHtml(value);
    };
}]);
