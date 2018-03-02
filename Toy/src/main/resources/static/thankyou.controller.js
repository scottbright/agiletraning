angular
    .module("myapp")
    .controller("ThankyouController", function ($scope, $routeParams, $location, dataservice) {
        // Using $routeParams
        $scope.dataservice = dataservice;
        $scope.order;
        $scope.getOrderDetail = function () {
            $scope.dataservice.getOrderDetail()
                .then(
                    function (response) {
                        // console.log(response)
                        console.log(response);
                        if(response.data.length > 0){
                            $scope.order = response.data;
                        }
                    },
                    function (err) { 
                        
                    }
                );
        }
        console.log("initialize controller");
      $scope.getOrderDetail();

    });