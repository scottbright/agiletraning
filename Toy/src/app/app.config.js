angular
    .module("myapp")
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
        .when('/search', {
            templateUrl: 'search.html',
            controller: 'ProductSearchController'
        })
        .when('/product/:productId', {
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
        .when('/thankyou', {
            templateUrl: 'thankyou.html',
            controller: 'ThankyouController'
        })
        .otherwise({
            redirectTo: '/search'
        });
    }]);