angular
    .module("myapp")
    .controller("ThankyouController", function ($scope, $routeParams, $location, dataservice) {
        // Using $routeParams
        $scope.dataservice = dataservice;

        //mock user ID
        var userId = 'chan'; 

        $scope.getOrderDetail = function () {
            $scope.dataservice.getOrderDetail(userId)
                .then(
                    function (response) {
                        $scope.order = response.data;
                    },
                    function (err) { 
                        
                    }
                );
        }
        $scope.getOrderDetail(userId);

    });