app.service('userService', function($cookies) {
    this.session = null;

    this.getSession = function() {
        return this.session;
    };

    this.userIsAuthenticated = function() {
        console.log('userService.userIsAuthenticated()');

        var cookieUserId = $cookies.get('userId');

        console.log('cookieUserId: ' + cookieUserId);

        if (this.session != null) {
            console.log('User is authenticated.');

            return true;
        }

        console.log('User is not authenticated.');

        return false;
    };

    this.registerSession = function(session) {
        console.log('userService.registerSession()');

        $cookies.put('userId', session.userId);

        var cookieUserId = $cookies.get('userId');

        console.log('cookieUserId: ' + cookieUserId);

        this.session = session;
    };

    this.unregisterSession = function() {
        console.log('userService.unregisterSession()');

        $cookies.remove('userId');

        var cookieUserId = $cookies.get('userId');

        console.log('cookieUserId: ' + cookieUserId);

        this.session = null;
    };
});