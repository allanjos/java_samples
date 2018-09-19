app.controller('mainCtrl', function($scope, $state, menuService) {
    console.log('Main controller');

    menuService.update();

    $state.go('main');
});