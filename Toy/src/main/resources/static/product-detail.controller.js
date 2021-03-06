angular
    .module("myapp")
    .controller("ProductdetailController", function ($scope, $routeParams, $location, dataservice) {
        // Using $routeParams
        $scope.productID = $routeParams.productId;
        $scope.dataservice = dataservice;
        $scope.toyDetail;
        $scope.quantityList = [];
        $scope.selectedQuantity = 1;
        $scope.getProductDetail = function () {
            $scope.dataservice.getProductDetailbyId($scope.productID)
                .then(
                    function (response) {
                        $scope.toyDetail = response.data;
                        for(var i=1;i<=$scope.toyDetail.amountInStock && i<=25;i++){
                            $scope.quantityList.push(i);
                        }
                    },
                    function (err) { 
                        console.log(err);
                    }
                );
        }
        $scope.getProductDetail();
        $scope.changeSelectedQuantity = function(quantity){
            $scope.selectedQuantity = quantity;
        }
        $scope.console = function(){
            console.log($scope.selectedQuantity);
        }
        $scope.addToCart = function () {
            
            //call API to push product to cart
            dataservice.addProductToCart(+$scope.productID, $scope.selectedQuantity)
                .then(
                    function (response) {
                        console.log(response);
                        $location.path('/cart');
                    },
                    function (err) { 
                        console.log(err);
                    }
                );
        }

        $scope.back = function () {
            $location.path('/search');
        }
    });