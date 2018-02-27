angular
    .module("myapp")
    .controller("ProductSearchController", function ($scope,$location, dataservice) {
    $scope.ages = ['all', '0','1', '2', '3', '4', '5', '6', '7', '8', '9 and more'];
    $scope.selectedAge = 'all';
    
    $scope.genders = ['all', 'male', 'female'];
    $scope.selectedGender = 'neutral';

    $scope.dataService =  dataservice;

    $scope.toys;
    //activate function

    $scope.search =  function(){
        $scope.dataService.searchProduct($scope.selectedAge, $scope.selectedGender)
            .then(
                function (response){ 
                    $scope.toys = response.data;
                },
                function (err) { }
        );
    }
    $scope.search();

    $scope.gotoProductDetail = function(productId){
        $location.path('/product/' + productId);
    }
    
});