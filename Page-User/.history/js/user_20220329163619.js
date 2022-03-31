var app = angular.module('user-app', []);
app.controller('abc', function($scope) {
  $scope.firstName= "John";
  $scope.lastName= "Doe";
});