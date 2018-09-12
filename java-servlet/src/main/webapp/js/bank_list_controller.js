window.app_dependencies.push('ngTable');

app.controller('bankListCtrl', ['$scope', '$http', 'NgTableParams', function($scope, $http, NgTableParams) {
    $http.get("/java-servlet/servlet/bank/list").then(function(response) {
        var obj = response.data;

        console.log('status: ' + obj.status);
        console.log('message: ' + obj.message);

        for (var i = 0; i < obj.data.length; i++) {
            console.log('Bank: ID=' + obj.data[i].id + ', Name=' + obj.data[i].name);
        }

        $scope.tableBanks = new NgTableParams({}, { dataset: obj.data});
    });
}]);