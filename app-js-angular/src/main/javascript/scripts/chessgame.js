// Creating a module
var app = angular.module('chessgame', [ 'chessboard' ]);

// Creating a filter
app.filter('trustAsHtml', ['$sce', function ($sce) {
    return function(value) {
        return $sce.trustAsHtml(value);
    };
}]);
