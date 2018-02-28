angular
    .module("myapp")
    .controller("ShippingController", function ($scope, $routeParams, $location, dataservice) {
        // Using $routeParams
        $scope.productID = $routeParams.param1;
        $scope.dataservice = dataservice;
        $scope.shippingAddress = {
            firstName:"",
            lastName:"",
            address1:"",
            address2:"",
            city:"",
            province:"",
            postCode:"",
            mobileNumber:""
        }
        $scope.provinceList;
        $scope.getProvince = function () {
            $scope.dataservice.getProvince()
                .then(
                    function (response) {
                        $scope.provinceList = response.data;
                    },
                    function (err) { 
                        
                    }
                );
        }
        $scope.getProvince();
        $scope.confirm = function () {
            $location.path('/thankyou/');
        }
    });