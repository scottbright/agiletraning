var module = angular.module("myApp", ['ngRoute']);
module.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/search', {
        templateUrl: 'search.html',
        controller: 'SearchController'
    })
    .when('/product/:param1', {
        templateUrl: 'product.html',
        controller: 'ProductController'
    })
    .otherwise({
        redirectTo: '/search'
    });
}]);
module.controller("ProductController", function ($scope, $routeParams, $location) {
    // Using $routeParams
    $scope.productID = $routeParams.param1;
});