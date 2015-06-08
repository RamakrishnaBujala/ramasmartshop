'use strict';

/**
 * ProductController
 * 
 * @constructor
 */
var ProductController = function($scope, $http, $rootScope, $location) {
    $scope.fetchProductsList = function() {		
    	if($rootScope.userLoggedin){
    		$http.get('products/productlist.json').success(function(productList){
                $scope.products = productList;
            });
    	}
        
    };

    $scope.addNewProduct = function(newProduct) {
    	// alert(categoryId);
        $http.post('products/addProduct', newProduct).success(function() {
        	$scope.resetError();            
            $scope.fetchProductsList();            
            $scope.product.productName = '';
            $scope.product.prodcutDesc = '';
            $scope.product.productPrice = '';            
        }).error(function() {
            $scope.setError('Could not Add the Product');
        });
    };
    
    
    $scope.updateProduct = function(editProduct) {
        $scope.resetError();
        $http.post('products/updateProduct', editProduct).success(function() {
        	 $scope.resetError();
         	 $scope.fetchProductsList();
             $scope.product.productName = '';
             $scope.product.prodcutDesc = '';
             $scope.product.productPrice = '';
             $scope.editMode = false;
             $scope.showCategory = false;
        }).error(function() {
            $scope.setError('Could not update the Product');
        });
    };

    $scope.removeProduct = function(id) {
    	$scope.resetError();        
        $http.delete('products/removeProduct/' + id).success(function() {
              $scope.fetchProductsList();
        }).error(function() {
            $scope.setError('Could not Delete the Product');
        });
    };

    $scope.removeAllProdcutss = function() {
        $http.delete('products/removeAllProducts').success(function() {
            $scope.fetchProductsList();
        });

    };
    
    $scope.fetchCategoriesList = function() {
    	if($rootScope.userLoggedin){
		$http.get('products/categorylist.json').success(function(categoryList) {
			$scope.categories = categoryList;
			$scope.fetchCategories = false;
		});
    	}
	};

	$scope.getProductbyCategory = function(categoryId) {
		$http.post('products/getProductsByCategoryId.json/' + categoryId)
				.success(function(productList) {
					$scope.tableParams.reload();
					$scope.products = productList;
				});
	};
	
	 $scope.editProductForm = function(product) {
		 // alert(product);
        $scope.resetError();
        $scope.product = product;
        $scope.editMode = true;
        $scope.showCategory = true;
    };
    
    $scope.resetProductForm = function() {
        $scope.resetError();
        $scope.product = {};
        $scope.editMode = false;
        $scope.showCategory=false;
    };
	    
	$scope.resetError = function() {
	     $scope.error = false;
	     $scope.errorMessage = '';
	};

	$scope.setError = function(message) {
	   $scope.error = true;
	   $scope.errorMessage = message;
	};
	
	
	
		$scope.fetchCategoriesList();
			
		$scope.fetchProductsList();
		
	$scope.isValidUser = function(){
		// alert("hi");
		if(adminName=="test"){
			return false;
		}
	}
	
	
	$scope.resetUserForm = function(){
		$scope.userName='';
		$scope.userPassword='';
		
	}
	
};