window.app_dependencies = [];

var app = angular.module('app', app_dependencies);

app.run(function($rootScope) {
    console.log('app.run()')
});

app.service('userService', function() {
    this.checkAuthentication = function() {
        console.log('userService.checkAuthentication()');
    };
});