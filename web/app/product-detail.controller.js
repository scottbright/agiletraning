angular
    .module("myapp")
    .controller("ProductdetailController", function ($scope, $routeParams, $location) {
    // Using $routeParams
    $scope.productID = $routeParams.param1;
});