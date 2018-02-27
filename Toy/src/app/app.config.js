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
        .when('/cart', {
            templateUrl: 'shopping-cart.html',
            controller: 'ShoppingCartController'
        })
        .when('/shipping', {
            templateUrl: 'shipping.html',
            controller: 'ShippingController'
        })
        .otherwise({
            redirectTo: '/search'
        });
    }]);