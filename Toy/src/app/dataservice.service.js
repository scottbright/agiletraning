angular
    .module("myapp")
    .factory("dataservice", function ($http) {
        var dataservice = {
            searchProduct: searchProduct,
            getProductDetailbyId: getProductDetailbyId,
            getShoppingCartItem:getShoppingCartItem
        };

        return dataservice;

        function searchProduct(age, gender){
            //var url = '';
            var urlToJsonFile = './content/json/toys.json';
            var promise = $http.get(urlToJsonFile);
            return promise;
        }

        function getProductDetailbyId(id){
            // var url = '';
            var urlToJsonFile = './content/json/toy-1.json';
            
            var promise = $http.get(urlToJsonFile);
            return promise;
        }
        
        function getShoppingCartItem(){
            // var url = '';
            var urlToJsonFile = './content/json/shopping-cart.json';
            var promise = $http.get(urlToJsonFile);
            return promise;
        }
});