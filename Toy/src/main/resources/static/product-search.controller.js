angular
    .module("myapp")
    .controller("ProductSearchController", function ($scope,$location, dataservice) {
    $scope.ages = ['all', '0','1', '2', '3', '4', '5', '6', '7', '8', '9+'];
    $scope.selectedAge = 'all';
    
    $scope.genders = ['all', 'male', 'female'];
    $scope.selectedGender = 'all';

    $scope.dataService =  dataservice;

    $scope.toys;
    //activate function

    $scope.search =  function(){
        $scope.dataService.searchProduct($scope.selectedAge, $scope.selectedGender)
            .then(
                function (response){ 
                    $scope.toys = response.data.ToyLists;
                },
                function (err) { 
                    console.log(err);
                }
        );
    }
    $scope.search();
    $scope.console = function(){
        console.log($scope.selectedGender);
    }
    $scope.gotoProductDetail = function(productId){
        $location.path('/product/' + productId);
    }
    
});