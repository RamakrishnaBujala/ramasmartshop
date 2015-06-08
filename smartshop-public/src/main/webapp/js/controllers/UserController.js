var UserController = function($scope, $http, $rootScope, $location, $window) {	
	$rootScope.userLoggedin = false;
	$rootScope.userName = '';
	$rootScope.userId = '';
	$rootScope.userDetails = null;
	$scope.isRegistrationRequired = false;
	$rootScope.orderTxnId = null;
	$scope.checkUserLogin = function(user) {
		// $scope.resetError();
		$http
				.post('user/checkUserLogin', user)
				.success(
						function(userDetails) {
							if (userDetails.userName != null) {								
								$scope.error = false;								
								$scope.errorMessage = '';
								$rootScope.userLoggedin = true;
								isRegistrationRequired = false;
								$window.sessionStorage.setItem("userName", userDetails.userName)
								$window.sessionStorage.setItem("userId", userDetails.userId)
								$scope.getUserNamerfromCookie();
								$location.path("/products");
							} else {
								$scope
										.setError('Invalid credentials, please login with valid credentials..');
								$location.path("/user");
							}

						});
	}

	$scope.registerNewUser = function(user) {
		$http.post('user/registerNewUser', user).success(function() {
			$scope.isRegistrationRequired = false;
			$scope.user.userEmail = '';
			$scope.user.userPassword = '';
			$scope.error = false;
		}).error(function() {
			$scope.setError('Could not register the User');
		});
	};

	$scope.setError = function(message) {
		$scope.error = true;
		$scope.errorMessage = message;
	};

	$scope.isUserLoggedIn = function() {
		if ($rootScope.userName != null) {
			return true;
		} else {
			return false;
		}
	}
	$scope.showRegistration = function() {
		$scope.isRegistrationRequired = true;
	}

	//invalidate the user session
	$scope.invalidateUser = function() {
		$window.sessionStorage.setItem("userName",'');
		$window.sessionStorage.setItem("userId",'');
		$rootScope.userLoggedin = false;
		$location.path("/user");
	}

	$scope.checkUserEmailBeforeRegister = function(user) {
		$http
				.post('user/isUserEmailExists', user)
				.success(
						function(emailAlredayExist) {
							if (emailAlredayExist == "false") {
								$scope.error = false;
								$scope.registerNewUser(user);
							} else {
								$scope
										.setError('User Email already exist, plesae choose other.');
							}

						});
	}
	
	$scope.getUserNamerfromCookie = function() {		
		$rootScope.userName = $window.sessionStorage.getItem("userName");
		$rootScope.userId = $window.sessionStorage.getItem("userId");
	}
	
	//make sure user logged in or not.
	$scope.getUserNamerfromCookie();
}
