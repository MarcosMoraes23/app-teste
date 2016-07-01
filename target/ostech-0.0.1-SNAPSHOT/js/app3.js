'use strict';

angular.module('appOS', ['appOS.services', 'appOS.controllers'])
.config(function ($routeProvider, $httpProvider) {
  $routeProvider.when('/servicos', {templateUrl: 'views/pages/servicos-list.html', controller: 'ServicoListCtrl'});
  $routeProvider.when('/servicos/:id', {templateUrl: 'views/pages/servicos-detail.html', controller: 'ServicoDetailCtrl'});
  $routeProvider.when('/servico', {templateUrl: 'views/pages/servicos-new.html', controller: 'ServicoCreationCtrl'});
  $routeProvider.otherwise({redirectTo: '/servicos'});

  /* CORS... */
  /* http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api */
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});
