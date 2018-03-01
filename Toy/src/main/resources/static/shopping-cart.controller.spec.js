// Be descriptive with titles here. The describe and it titles combined read like a sentence.
describe('Shopping-cart controller', function() {
    var $scope;
    var $rootScope;
    var $controller;
    var ShoppingCartController;
    
    beforeEach(function() {
        angular.module("testapp", ['ngRoute', 'ngMaterial']);

        inject(function(_$rootScope_, _$controller_){
            $rootScope = _$rootScope_;
            $scope = _$rootScope_.$new();
            // $controller = _$controller_;
            ShoppingCartController = $controller('ShoppingCartController', { $scope:$scope });
            
        });
    });
    
    it('has a dummy spec to test 2 + 2', function() {

        expect(2+2).toEqual(4);
    });
    
    it('should calculate the subtotal amount correctly', function() {
        // $controller('ShoppingCartController', { $scope:$scope });
        //$controller("ShoppingCartController", function ($scope, $routeParams, $location, dataservice);

        $scope.shoppingCartItem = [
            {
                "ID":1,
                "toyName":"ToyStory",
                "gender":"Male",
                "age":4,
                "price":100,
                "brand":"CoolKidz",
                "quantity":1000,
                "orderQuantity":20
            },  
            {
                "ID":2,
                "toyName":"Toy2",
                "gender":"Female",
                "age":6,
                "price":150,
                "brand":"SportsFun",
                "quantity":890,
                "orderQuantity":15
            }
        
        ];
        ShoppingCartController.calculateSubTotal();
        expect($scope.subTotal).toEqual(4250);
    });
    
});