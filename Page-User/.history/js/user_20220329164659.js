var app = angular.module('user-app', []);
app.controller('abc', function abc($scope) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
});


(function () {
    'use strict';

    angular.module('navBarDemoBasicUsage', ['ngMaterial'])
        .controller('AppCtrl', AppCtrl);

    function AppCtrl($scope) {
        $scope.currentNavItem = 'page1';

        $scope.goto = function (page) {
            $scope.status = "Goto " + page;
        };
    }
})();