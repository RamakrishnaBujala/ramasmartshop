var SmartShopApp1 = {};

var App = angular.module('SmartShopApp', [ 'SmartShopApp.filters',
		'SmartShopApp.services', 'SmartShopApp.directives' ]);
App.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/products', {
		templateUrl : 'products/layout.html',
		controller : ProductController
	}).when('/cart', {
		templateUrl : 'cart/layout.html',
		controller : ProductController
	}).when('/order', {
		templateUrl : 'order/layout.html',
		controller : ProductController
	}).when('/orderSummary', {
		templateUrl : 'orderSummary/layout.html',
		controller : ProductController
	}).when('/user', {
		templateUrl : 'user/layout.html',
		controller : UserController
	}).when('/track', {
		templateUrl : 'track/layout.html',
		controller : ProductController
	}).otherwise({
		redirectTo : '/products'
	});
} ]);

/**
 * 'use strict';
 * 
 * angular.module('myApp', ['ngRoute']). config(['$routeProvider',
 * function($routeProvider) { $routeProvider.otherwise({redirectTo: '/home'});
 * }]);
 * 
 */
