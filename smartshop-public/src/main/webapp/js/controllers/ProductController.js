'use strict';

/**
 * ProductController
 * 
 * @constructor
 */
var ProductController = function($scope, $http, $rootScope, $location) {
	$scope.fetchProducts = true;
	$scope.userLoggedin = false;
	$scope.fetchCategories = true;
	$scope.showBillingDetails = false;
	$scope.orderDetails = null;
	var orderInfo = null;
	$scope.orderTxnId = null;
	$scope.fetchProductsList = function() {
		$http.get('products/productlist.json').success(function(productList) {
			$scope.products = productList;
			$scope.loadItems();
			$scope.fetchProducts = false;
		});
	};

	$scope.fetchCategoriesList = function() {
		$http.get('products/categorylist.json').success(function(categoryList) {
			$scope.categories = categoryList;
			$scope.fetchCategories = false;
		});
	};

	$scope.getProductbyCategory = function(categoryId) {
		$http.post('products/getProductsByCategoryId.json/' + categoryId)
				.success(function(productList) {
					$scope.tableParams.reload();
					$scope.products = productList;
				});
	};

	if ($scope.fetchCategories) {
		$scope.fetchCategoriesList();
	}

	if ($scope.fetchProducts) {

		$scope.fetchProductsList();
	}

	// this.cartName = cartName;
	this.clearCart = false;
	$scope.items = [];

	$scope.addItem = function(id, name, price, quantity) {

		if (quantity != 0) {
			// update quantity for existing item
			var found = false;
			// alert(this.items.length);
			for (var i = 0; i < this.items.length && !found; i++) {
				var item = this.items[i];
				if (item.id == id) {
					found = true;
					item.quantity = this.toNumber(item.quantity + quantity);
					if (item.quantity <= 0) {
						this.items.splice(i, 1);
					}
				}
			}

			// new item, add now
			if (!found) {
				var item = new cartItem(id, name, price, quantity);
				this.items.push(item);
			}
			// save changes
			$scope.saveItems();
		}
	};

	$scope.saveItems = function() {
		if (localStorage != null && JSON != null) {
			localStorage[this.cartName + "_items"] = JSON.stringify(this.items);
		}
	};

	$scope.loadItems = function() {
		var items = localStorage != null ? localStorage[this.cartName
				+ "_items"] : null;
		if (items != null && JSON != null) {
			try {
				var items = JSON.parse(items);
				for (var i = 0; i < items.length; i++) {
					var item = items[i];
					if (item.id != null && item.name != null
							&& item.price != null && item.quantity != null) {
						item = new cartItem(item.id, item.name, item.price,
								item.quantity);
						this.items.push(item);
					}
				}
			} catch (err) {
				// ignore errors while loading...
			}
		}
	};

	// get the total price for all items currently in the cart
	$scope.getTotalPrice = function(id) {
		var total = 0;
		for (var i = 0; i < this.items.length; i++) {
			var item = this.items[i];
			if (id == null || item.id == id) {
				total += this.toNumber(item.quantity * item.price);
			}
		}
		return total;
	};

	// get the total price for all items currently in the cart
	$scope.getTotalCount = function(id) {
		// alert("hi");
		var count = 0;
		for (var i = 0; i < this.items.length; i++) {
			var item = this.items[i];
			if (id == null || item.id == id) {
				count += this.toNumber(item.quantity);
			}
		}
		return count;
	};

	$scope.clearItems = function() {
		this.items = [];
		$scope.saveItems();
	}

	function cartItem(id, name, price, quantity) {
		this.id = id;
		this.name = name;
		this.price = price * 1;
		this.quantity = quantity * 1;
	}

	$scope.toNumber = function(value) {
		value = value * 1;
		return isNaN(value) ? 0 : value;
	}

	$scope.loadShippingDetails = function() {
		if ($rootScope.userName != '') {
			// $scope.order.userId = $rootScope.userDetails.userId;
			$scope.showBillingDetails = true;
			$scope.orderInfoToUser = false;
		} else {
			$location.path("/user");
		}
	}

	// invalidate the user session
	$scope.invalidateUser = function() {
		clearItems();
		$rootScope.userLoggedin = false;
		$location.path("/user");
	};

	// confirm the order details here.
	$scope.confirmOrder = function(orderDetails) {
		$scope.orderDetails = new orderHelper($scope.items, $rootScope.userId,
				orderDetails.orderShippingAddress,
				orderDetails.orderShippingCity, orderDetails.orderShippingPin)
		$http.post('order/confirmOrderDetails', $scope.orderDetails).success(
				function(orderDetails) {
					$scope.orderTxnId = orderDetails.orderTxnId;
					orderInfo = new orderInfoToUser(orderDetails);
					$scope.clearItems();
					$scope.showBillingDetails = false;
					$scope.orderInfoToUser = true;
					$scope.cartItemDetails = false;
				});
	};

	// preparing order info
	function orderHelper(selectedItems, userId, orderShippingAddress,
			orderShippingCity, orderShippingPin) {
		this.itemDetails = selectedItems;
		this.userId = userId;
		this.orderShippingAddress = orderShippingAddress;
		this.orderShippingCity = orderShippingCity;
		this.orderShippingPin = orderShippingPin;
	}

	// Order info result from the service
	function orderInfoToUser(orderInfoFromBackend) {
		this.orderTxnId = orderInfoFromBackend.orderTxnId;
		this.orderShippingAddress = orderInfoFromBackend.orderShippingAddress;
		this.orderShippingCity = orderInfoFromBackend.orderShippingCity;
		this.orderShippingPin = orderInfoFromBackend.orderShippingPin;
	}

	// get order details
	$scope.getOrderDetails = function(txnId) {
		$http
				.post('track/getOrderDetails/' + txnId)
				.success(
						function(orderDetails) {
							$scope.txnId = '';
							$scope.error = false;
							if (orderDetails.orderTxnId != null) {
								$scope.orderInfo = orderDetails;
							} else {
								alert("error");
								$scope
										.setError('No such order Id, provide vaild one..');
							}
						});
	}

	$scope.setError = function(message) {
		$scope.error = true;
		$scope.errorMessage = message;
	};
};