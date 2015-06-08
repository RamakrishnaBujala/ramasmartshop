'use strict';

/**
 * SalesInfoController
 * 
 * @constructor
 */
var SalesInfoController = function($scope, $http) {
    $scope.orders = {};
    $scope.editMode = false;

    $scope.fetchOrdersList = function() {
        $http.get('order/orderlist.json').success(function(orderList){
            $scope.orders = orderList;
        });
    };
    
    $scope.updateOrder = function(order) {
    	$scope.resetError();
        $http.put('order/updateOrder', order).success(function() {
        	 $scope.fetchOrdersList();            
        }).error(function() {
            $scope.setError('Could not update the order');
        });
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchOrdersList();   
};