app.controller('mainCtrl', function($scope, $state) {
    console.log('Main controller');

    $state.go('main');
});