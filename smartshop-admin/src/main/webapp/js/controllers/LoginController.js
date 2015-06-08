var LoginController = function($scope, $http, $rootScope, $location) {	
	$rootScope.userLoggedin = false;
	$scope.checkAdminLogin = function(user)
	{
        // $scope.resetError();
        $http.post('user/checkAdminUser', user).success(function(userDetails) {        	
        	if(userDetails.userName !=  null)
        	{
        		$scope.error = false;
        		$scope.errorMessage = '';        		
        		$rootScope.userLoggedin =  true;        		
            	$location.path( "/category" );
        	}else{
        		$scope.setError('Invalid credentials, please login with valid credentials..');
        		$location.path( "/user" );
        	}
        	
        });
	}
};