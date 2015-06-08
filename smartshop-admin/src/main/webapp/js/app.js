var SmartShopApp1 = {};

var App = angular.module('SmartShopApp', [ 'SmartShopApp.filters',
		'SmartShopApp.services', 'SmartShopApp.directives' ]);
App.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/user', {
		templateUrl : 'user/layout.html',
		controller : LoginController
	}).when('/category', {
		templateUrl : 'category/layout.html',
		controller : CategoryController
	}).when('/products', {
		templateUrl : 'products/layout.html',
		controller : ProductController
	}).when('/order', {
		templateUrl : 'order/layout.html',
		controller : SalesInfoController
	}).otherwise({
		redirectTo : '/user'
	});
} ]);