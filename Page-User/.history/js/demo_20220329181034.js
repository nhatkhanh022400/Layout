var app = angular.module('user-app', ['ngMaterial'])
app.controller('AppCtrl', function($scopes) {
  $scopes.isDisabled = true;
  $scopes.googleUrl = 'http://google.com';
});