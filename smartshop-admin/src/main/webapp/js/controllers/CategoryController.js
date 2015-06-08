'use strict';

/**
 * CategoryController
 * 
 * @constructor
 */
var CategoryController = function($scope, $http) {
    $scope.category = {};
    $scope.editMode = false;

    $scope.fetchCatgorysList = function() {
        $http.get('category/categorieslist.json').success(function(categoryList){
            $scope.categories = categoryList;
        });
    };

    $scope.addNewCategory = function(category) {
        $scope.resetError();
        $http.post('category/addCategory', category).success(function() {
            $scope.fetchCatgorysList();
            $scope.category.categoryName = '';
            $scope.category.categoryDescription = '';            
        }).error(function() {
            $scope.setError('Could not add a new category');
        });
    };

    $scope.updateCategory = function(category) {
        $scope.resetError();
        $http.put('category/updateCategory', category).success(function() {
        	 $scope.fetchCatgorysList();
             $scope.category.categoryName = '';
             $scope.category.categoryDescription = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the category');
        });
    };

    $scope.editCategory = function(category) {
        $scope.resetError();
        $scope.category = category;
        $scope.editMode = true;
    };

    $scope.removeCategory = function(id) {
    	$scope.resetError();        
        $http.delete('category/removeCategory/' + id).success(function() {
            $scope.fetchCatgorysList();
        }).error(function() {
            $scope.setError('Could not remove category');
        });        
    };

    $scope.removeAllCategories = function() {
        $scope.resetError();

        $http.delete('category/removeAllCategories').success(function() {
            $scope.fetchCatgorysList()
        }).error(function() {
            $scope.setError('Could not remove all categories');
        });

    };

    $scope.resetCategoryForm = function() {
        $scope.resetError();
        $scope.category = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchCatgorysList();

    $scope.predicate = 'id';
};