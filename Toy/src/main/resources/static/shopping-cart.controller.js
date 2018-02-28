angular
    .module("myapp")
    .controller("ShoppingCartController", function ($scope, $routeParams, $location, dataservice) {
        // Using $routeParams
        $scope.dataservice = dataservice;
        $scope.shoppingCartItem;
        $scope.quantityList = [];
        $scope.subTotal;
        $scope.getShoppingCartItem = function () {
            $scope.dataservice.getShoppingCartItem()
                .then(
                    function (response) {
                        $scope.shoppingCartItem = response.data;
                        angular.forEach($scope.shoppingCartItem, function (item, key) {
                            item.quantityList = [];

                            for (var i = 1; i < item.quantity && i <= 25; i++) {
                                item.quantityList.push(i);
                            }
                        })
                        $scope.calculateSubTotal();
                        console.log("successs");

                    },
                    function (err) {
                        console.log("error")
                    }
                );
                //console.log("test");
        }
        $scope.getShoppingCartItem();

        $scope.continueShopping = function () {
            $location.path('/search');
        }
        $scope.checkOut = function () {
            $location.path('/shipping');
        }
        $scope.delete = function(index){
            $scope.shoppingCartItem.splice(index,1);
            $scope.calculateSubTotal();
        }
        $scope.calculateSubTotal = function(){
            $scope.subTotal = 0;
            angular.forEach($scope.shoppingCartItem, function (item, key) {
                $scope.subTotal = $scope.subTotal + (item.price * item.orderQuantity);
            })
        }
    });