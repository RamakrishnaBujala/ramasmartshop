/**
 * ProductController
 * 
 * @constructor
 */
var HomeController = function($scope, $http) {

	$scope.fetchProductsList = function() {
		$http.get('home').success(function(productList) {
		});
	};

	$scope.login = function() {
		alert("hello");
		ModalService.showModal({
			templateUrl : 'user/layout.html',
			controller : "UserController"
		}).then(function(modal) {
			modal.element.modal();
			modal.close.then(function(result) {
				$scope.message = "You said " + result;
			});
		});
	};
	
	$scope.fetchCategoriesList = function() {
		$http.get('products/categorylist.json').success(function(categoryList) {
			$scope.categories = categoryList;			
		});
	};
	
	$scope.getProductbyCategory = function(categoryId) {		
		$http.post('products/getProductsByCategoryId.json/' + categoryId).success(
				function(productList) {
					alert(productList);
					$scope.products = productList;
				});
	};
	
	$scope.fetchCategoriesList();
};

/*
 * function slideShowController($scope, $timeout) { var slidesInSlideshow = 4;
 * var slidesTimeIntervalInMs = 3000;
 * 
 * $scope.slideshow = 1; var slideTimer = $timeout(function interval() {
 * $scope.slideshow = ($scope.slideshow % slidesInSlideshow) + 1; slideTimer =
 * $timeout(interval, slidesTimeIntervalInMs); }, slidesTimeIntervalInMs); }
 */
