angular
    .module("myapp")
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
        .when('/search', {
            templateUrl: 'search.html',
            controller: 'ProductSearchController'
        })
        .when('/product/:userId/:productId', {
            templateUrl: 'product.html',
            controller: 'ProductdetailController'
        })
        .when('/cart/:userId', {
            templateUrl: 'shopping-cart.html',
            controller: 'ShoppingCartController'
        })
        .when('/shipping/:userId', {
            templateUrl: 'shipping.html',
            controller: 'ShippingController'
        })
        .when('/thankyou/:userId', {
            templateUrl: 'thankyou.html',
            controller: 'ThankyouController'
        })
        .otherwise({
            redirectTo: '/search'
        });
    }]);