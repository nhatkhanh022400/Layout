angular.module('user-app', ['ngMaterial'])
.controller('AppCtrl', function($scopes) {
  $scopes.isDisabled = true;
  $scopes.googleUrl = 'http://google.com';
});