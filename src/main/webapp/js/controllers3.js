'use strict';

/* Controllers */

var app = angular.module('appOS.controllers', []);

app.controller('ServicoListCtrl', ['$scope', 'ServicosFactory', 'ServicoFactory', '$location',
  function ($scope, ServicosFactory, ServicoFactory, $location,$window) {

    /* callback for ng-click 'editUser': */
    $scope.editServico = function (servicoId) {
      $location.path('/servicos/' + servicoId);
    };

    /* callback for ng-click 'deleteUser': */
    $scope.deleteServico = function (servicoId) {
		ServicoFactory.delete({ id: servicoId });
	    $scope.servicos = ServicosFactory.query();
    };

    /* callback for ng-click 'createUser': */
    $scope.createNewServico = function () {
      $location.path('/servico');
    };

    $scope.servicos = ServicosFactory.query();
  }]);

app.controller('ServicoDetailCtrl', ['$scope', '$routeParams', 'ServicoFactory', '$location',
  function ($scope, $routeParams, ServicoFactory, $location) {

    /* callback for ng-click 'updateUser': */
    $scope.updateServico = function () {
      ServicoFactory.update($scope.servico);
      $location.path('/servicos-list');
    };

    /* callback for ng-click 'cancel': */
    $scope.cancel = function () {
      $location.path('/servicos-list');
    };

    $scope.servico = ServicoFactory.show({id: $routeParams.id});
  }]);

app.controller('ServicoCreationCtrl', ['$scope', 'ServicosFactory', '$location',
  function ($scope, ServicosFactory, $location) {

    /* callback for ng-click 'createNewUser': */
    $scope.createNewServico = function () {
      ServicosFactory.create($scope.servico);
      $location.path('/servicos-list');
    }
  }]);
