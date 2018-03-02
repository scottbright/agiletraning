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

                            for (var i = 1; i <= item.amountInStock && i <= 25; i++) {
                                item.quantityList.push(i);
                            }
                        })
                        $scope.calculateSubTotal($scope.shoppingCartItem);
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
            // $location.path('/shipping');thankyou
            $location.path('/thankyou');
        }
        $scope.delete = function(index){
            // $scope.shoppingCartItem.splice(index,1);
            $scope.shoppingCartItem[index].orderQuantity = 0;
            $scope.calculateSubTotal($scope.shoppingCartItem);
        }
        $scope.calculateSubTotal = function(cartItem){
            $scope.subTotal = 0;
            angular.forEach(cartItem, function (item, key) {
                $scope.subTotal = $scope.subTotal + (item.price * item.orderQuantity);
            })
        }
    });