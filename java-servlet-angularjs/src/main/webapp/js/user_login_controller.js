app.controller('userLoginCtrl', function($scope, $http) {
    $scope.status = '';

    $scope.login = function() {
        console.log('login()');

        $scope.status = 'Saving information...';

        var data = {
            name: $scope.username,
            password: $scope.password
        };

        var config = {
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        };

        $http.post('/java-servlet/servlet/login', data, config).then(
            function(response) {
                console.log('HTTP post success');

                var obj = response.data;

                console.log('status: ' + obj.status);
                console.log('message: ' + obj.message);

                if (obj.status == 0) {
                    $scope.status = 'User is authenticated.';
                }
                else {
                    $scope.status = 'Error on user authentication.';
                }
            },
            function(response) {
                console.log('HTTP post error');

                $scope.status = 'Error on user authentication (HTTP error).';
            }
        );
    };
});