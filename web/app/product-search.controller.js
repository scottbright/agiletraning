angular
    .module("myapp")
    .controller("ProductSearchController", function ($scope) {
    $scope.ages = ['all', '1', '2', '3', '4', '5', '6', '7', '8', '9 and more'];
    $scope.selectedAge = 'all';

    $scope.genders = ['neutral', 'male', 'female'];
    $scope.selectedGender = 'neutral';

    $scope.toys = [
        {
            ID:1,
            toyName:"Toy1",
            gender:"Male",
            age:4,
            price:100,
            brand:"CoolKidz",
            quantity:1000
        },
        {
            ID:2,
            toyName:"Toy2",
            gender:"Female",
            age:6,
            price:150,
            brand:"SportsFun",
            quantity:890
        }

    ];
});