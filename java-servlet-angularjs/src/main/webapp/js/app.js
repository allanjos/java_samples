var app = angular.module('app', ['ui.router', 'ngTable']);

app.config(function($stateProvider) {
  var helloState = {
    name: 'bank_list',
    url: '/bank/list',
    templateUrl: '/java-servlet/bank/list/index.html'
  };

  var aboutState = {
    name: 'bank_new',
    url: '/bank/new',
    templateUrl: '/java-servlet/bank/new/index.html'
  };

  $stateProvider.state(helloState);
  $stateProvider.state(aboutState);
});
