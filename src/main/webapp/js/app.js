
(function() {

	angular.module('appOS',
	[ 'ngRoute',
	  'ngDialog',
		'servicoControllers',
		'formaControllers',
		'appOS.directives',
		'angularUtils.directives.dirPagination',
		'ngAnimate'
	]);

	angular.module('appOS').constant("APP_CONFIG", {
		"API_REST" : "http://ostech-ondevsolutions.rhcloud.com"
	});

	function Config($routeProvider) {
		$routeProvider
		.when('/', {
			templateUrl : 'exemplo.html'
		})
		.when('/servicos', {
			controller : 'servicoListController',
			templateUrl : 'servicos/list.html'
		})
		.when('/formaspgto', {
			controller : 'formaListController',
			templateUrl : 'formas/list.html'
		}).otherwise({
			redirectTo : '/'
		});
	}

	angular.module('appOS').config(Config);
}());
