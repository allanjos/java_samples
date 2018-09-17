app.controller('bankNewCtrl', function($scope, $http) {
    $scope.status = '';

    $scope.bankSave = function() {
        console.log('bankSave()');

        $scope.status = 'Saving information...';

        var data = {
            name: $scope.name
        };

        var config = {
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        };

        $http.post('/java-servlet/servlet/bank/new', data, config).then(
            function(response) {
                console.log('HTTP post success');

                var obj = response.data;

                console.log('status: ' + obj.status);
                console.log('message: ' + obj.message);

                if (obj.status == 0) {
                    $scope.status = 'Bank is registrated.';

                    $scope.name = '';
                }
                else {
                    $scope.status = 'Error on bank registration.';
                }
            },
            function(response) {
                console.log('HTTP post error');

                $scope.status = 'Error on bank registration (HTTP error).';
            }
        );
    };
});