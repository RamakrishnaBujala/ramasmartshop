/**
 * HomeController
 * 
 * @constructor
 */
var HomeController = function($scope, $http) {
	
    $scope.fetchProductsList = function() {
        $http.get('home').success(function(productList){            
        });
    };
    
    $scope.searchProduct1 = function(){
    	alert("hello");
    };
}

/*function slideShowController($scope, $timeout) {
	var slidesInSlideshow = 4;
	var slidesTimeIntervalInMs = 3000;

	$scope.slideshow = 1;
	var slideTimer = $timeout(function interval() {
		$scope.slideshow = ($scope.slideshow % slidesInSlideshow) + 1;
		slideTimer = $timeout(interval, slidesTimeIntervalInMs);
	}, slidesTimeIntervalInMs);
}*/
