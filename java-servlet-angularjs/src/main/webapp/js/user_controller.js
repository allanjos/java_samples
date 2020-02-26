app.controller('userLoginCtrl', function($scope, $http, $state, $cookies, userService) {
    console.log('userLoginCtrl');

    $scope.status = '';

    $scope.login = function() {
        console.log('login()');

        $scope.status = 'Requesting user login...';

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

                console.log('response: ' + JSON.stringify(obj));
                console.log('status: ' + obj.status);
                console.log('message: ' + obj.message);
                console.log('data: ' + JSON.stringify(obj.data));

                var userSession = obj.data;

                if (!userSession) {
                    $scope.status = 'Invalid user session';
                }

                console.log('User session:');
                console.log('ID: ' + JSON.stringify(userSession.id));
                console.log('User ID: ' + JSON.stringify(userSession.userId));
                console.log('startDate: ' + JSON.stringify(userSession.startDate));

                if (obj.status == 0) {
                    userService.registerSession(userSession);

                    $scope.status = 'User is authenticated.';

                    console.log('Going to main page');

                    $state.go("main");
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

app.controller('userLogoutCtrl', function($scope, $http, $state, userService) {
    console.log('userLogoutCtrl');

    $scope.logout = function() {
        console.log('logout()');

        if (userService.getSession() == null) {
            console.log('User has not a authenticated session.');

            userService.unregisterSession();

            return;
        }

        $scope.status = 'Requesting user logout...';

        var data = {
            userId: userService.getSession().userId
        };

        var config = {
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        };

        $http.post('/java-servlet/servlet/logout', data, config).then(
            function(response) {
                console.log('HTTP post success');

                var obj = response.data;

                console.log('response: ' + JSON.stringify(obj));
                console.log('status: ' + obj.status);
                console.log('message: ' + obj.message);
                console.log('data: ' + JSON.stringify(obj.data));

                if (obj.status == 0) {
                    $scope.status = 'User is logged out.';

                    //console.log('Going to main page');

                    //$state.go("main");
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

        userService.unregisterSession();
    };

    $scope.logout();
});