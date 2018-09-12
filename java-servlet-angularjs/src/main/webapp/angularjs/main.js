app.directive('w3TestDirective', function() {
    return {
        template: '[<b>Template</b> <font color="blue">content]'
    }
});

app.controller('namesCtrl', function($scope) {
    $scope.names = [{name: "João", country: "Brasil"}, {name: "Jennifer", country: "USA"}, {name: "Linus", country: "Finlandia"}];
});