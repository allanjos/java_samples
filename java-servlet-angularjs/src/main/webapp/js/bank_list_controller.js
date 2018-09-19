app.controller('bankListCtrl', ['$scope', '$http', '$state', 'NgTableParams', function($scope, $http, $state, NgTableParams) {
    $scope.newBankDialogRequest = function() {
        $state.go('bank_new');
    };

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