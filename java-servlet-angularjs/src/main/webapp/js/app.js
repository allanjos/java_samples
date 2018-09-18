var app = angular.module('app', ['ui.router', 'ngTable']);

app.config(function($stateProvider) {
  var mainState = {
    name: 'main',
    url: '/',
    templateUrl: '/java-servlet/pages/index.html'
  };

  var helloState = {
    name: 'bank_list',
    url: '/bank/list',
    templateUrl: '/java-servlet/pages/bank/list/index.html'
  };

  var aboutState = {
    name: 'bank_new',
    url: '/bank/new',
    templateUrl: '/java-servlet/pages/bank/new/index.html'
  };

  var userLoginState = {
    name: 'user_login',
    url: '/user/login',
    templateUrl: '/java-servlet/pages/user/login/index.html'
  };

  $stateProvider.state(mainState);
  $stateProvider.state(helloState);
  $stateProvider.state(aboutState);
  $stateProvider.state(userLoginState);
});

app.controller('indexCtrl', function($scope, $state) {
  console.log('Index controller');

  //$state.go('main');
});
