angular
    .module("myapp")
    .controller("ShippingController", function ($scope, $routeParams, $location, dataservice) {
        // Using $routeParams
        $scope.productID = $routeParams.param1;
        $scope.dataservice = dataservice;
        
        
       
        $scope.confirm = function () {
            $location.path('/thankyou');
        }
    });