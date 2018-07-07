var cartApp = angular.module("cartApp", []);
cartApp.controller("cartCtrl", function ($scope, $http) {
		
	$scope.refreshCart = function() {
		$http.get("/MusicStore/rest/cart/"+$scope.cartId).success(function(data) {
			$scope.cart = data;
		});
	};
	
	$scope.clearCart = function() {
		$http.delete("/MusicStore/rest/cart/emptyCart/"+$scope.cartId).success(function(data){
			$scope.refreshCart()
		});
	};
	
	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function(productId) {
		$http.put("/MusicStore/rest/cart/addCartItem/"+productId).success(function() {
			alert("Product successfully added to the cart.");
		});
	};
	
	$scope.removeFromCart = function(productId) {
		$http.put("/MusicStore/rest/cart/removeCartItem/"+productId).success(function(data) {
			$scope.refreshCart();
		});
	};

	$scope.calcGrandTotal = function() {
		var grandTotal = 0;
		for(var i=0; i<$scope.cart.cartItems.length;i++){
			grandTotal+=$scope.cart.cartItems[i].totalPrice;
		}
		return grandTotal;
	}
});

/* var cartApp = angular.module("cartApp", []);
cartApp.controller("cartCtrl", function ($scope, $http) {
		
	$scope.refreshCart = function(cartId) {
		$http.get("/MusicStore/rest/cart/"+$scope.cartId).success(function(data) {
			$scope.cart = data;
		});
	};
	
	$scope.clearCart = function() {
		$http.delete("/MusicStore/rest/cart/"+$scope.cartId).success($scope.refreshCart($scope.cartId));
	};
	
	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function(productId) {
		$http.put("/MusicStore/rest/cart/add/"+productId).success(function(data) {
			$scope.refreshCart($http.get("/MusicStore/rest/cart/cartId"));
			alert("Product successfully added to the cart.");
		});
	};
	
	$scope.removeFromCart = function(productId) {
		$http.put("/MusicStore/rest/cart/remove/"+productId).success(function(data) {
			$scope.refreshCart($http.get("/MusicStore/rest/cart/"+productId));
		});
	};
}); */