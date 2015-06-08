/**
 * SalesInfoController
 * @constructor
 */
var SalesInfoController = function($scope, $http) {
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
};