angular
    .module("myapp")
    .factory("dataservice", function ($http) {
        var dataservice = {
            searchProduct: searchProduct,
            getProductDetailbyId: getProductDetailbyId,
            getShoppingCartItem: getShoppingCartItem,
            getProvince: getProvince,
            getOrderDetail: getOrderDetail
        };
        var urlDev = 'https://crossorigin.me/http://128.199.190.215:8080';
        var urlProd = 'https://crossorigin.me/http://188.166.211.237:8080';

        return dataservice;

        function searchProduct(age, gender) {
            //var urlToJsonFile = './content/json/toys.json';
            var url = urlDev + '/api/v1/toyList?gender=' + gender + '&age=' + age;
            //var url = urlDev + '/api/v1';
            var promise = $http.get(url);
            return promise;
        }

        function getProductDetailbyId(productId) {
            //var url = urlDev + '/api/v1/toy/' + productId;
            var urlToJsonFile = './content/json/toy-1.json';

            var promise = $http.get(urlToJsonFile);
            return promise;
        }

        function addProductToCart(productId, quantity) {
            //var url = urlDev + '/api/v1/cart';
            var input = {
                "id": productId,
                "orderAmount": quantity
            }
            var promise = $http.post(url, input);
            return promise;
        }


        function getShoppingCartItem() {
            // var url = '';
            var urlToJsonFile = './content/json/shopping-cart.json';
            var promise = $http.get(urlToJsonFile);
            return promise;
        }

        function getProvince() {
            // var url = '';
            var urlToJsonFile = './content/json/province.json';
            var promise = $http.get(urlToJsonFile);
            return promise;
        }

        function getOrderDetail(userId) {
            // var url = '';
            var urlToJsonFile = './content/json/orderdetail.json';
            var promise = $http.get(urlToJsonFile);
            return promise;            
        }
    });