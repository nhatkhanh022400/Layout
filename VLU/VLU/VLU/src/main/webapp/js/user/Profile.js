var app = angular.module('user-app', []);

function getAPICompleteCourse(APIJSON) {
    app.controller('abc', function abc($scope) {
        $scope.insides = APIJSON;
    });
}

function getAPIOtherCourse(APIJSON) {
    app.controller('abcd', function abcd($scope) {
        $scope.test = {};
        $scope.outsides = APIJSON;
    });
}