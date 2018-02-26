var module = angular.module("myapp", ['ngRoute', 'ngMaterial']);
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
module.controller("SearchController", function ($scope) {
    $scope.ages = ['all', '1', '2', '3', '4', '5', '6', '7', '8', '9 and more'];
    $scope.selectedAge = 'all';

    $scope.genders = ['neutral', 'male', 'female'];
    $scope.selectedGender = 'neutral';

    $scope.toys = [
        {
            ID:1,
            toyName:"Toy1",
            gender:"Male",
            age:4,
            price:100,
            brand:"CoolKidz",
            quantity:1000
        },
        {
            ID:2,
            toyName:"Toy2",
            gender:"Female",
            age:6,
            price:150,
            brand:"SportsFun",
            quantity:890
        }

    ];
});
module.controller("ProductController", function ($scope, $routeParams, $location) {
    // Using $routeParams
    $scope.productID = $routeParams.param1;
});

//var app = angular.module("myapp", ['ngRoute']);
//app.config(function($routeProvider) {
//    $routeProvider
//    .when("/", {
//        template : "<h1>Main</h1><p>Click on the links to change this content</p>"
//    })
//    .when("/banana", {
//        template : "<h1>Banana</h1><p>Bananas contain around 75% water.</p>"
//    })
//    .when("/tomato", {
//        template : "<h1>Tomato</h1><p>Tomatoes contain around 95% water.</p>"
//    });
//});
//app.controller("londonCtrl", function ($scope) {
//    $scope.msg = "I love London";
//});
//app.controller("parisCtrl", function ($scope) {
//    $scope.msg = "I love Paris";
//});