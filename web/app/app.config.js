angular
    .module("myapp")
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
        .when('/search', {
            templateUrl: 'search.html',
            controller: 'ProductSearchController'
        })
        .when('/product/:param1', {
            templateUrl: 'product.html',
            controller: 'ProductdetailController'
        })
        .otherwise({
            redirectTo: '/search'
        });
    }]);