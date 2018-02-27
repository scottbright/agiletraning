angular
    .module("myapp")
    .controller("ThankyouController", function ($scope, $routeParams, $location, dataservice) {
        // Using $routeParams
        $scope.productID = $routeParams.param1;
        $scope.dataservice = dataservice;
        $scope.toyDetail;
        $scope.quantityList = [];
        $scope.selectedQuantity = 1;
        $scope.getProductDetail = function () {
            $scope.dataservice.getProductDetailbyId($scope.productID)
                .then(
                    function (response) {
                        $scope.toyDetail = response.data;
                        for(var i=1;i<$scope.toyDetail && i<=25;i++){
                            $scope.quantityList.push(i);
                        }
                    },
                    function (err) { 
                        
                    }
                );
        }
        $scope.getProductDetail();
        $scope.addToCart = function () {
            $location.path('/cart');
        }

        $scope.back = function () {
            $location.path('/search');
        }
    });