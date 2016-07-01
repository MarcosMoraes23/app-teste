(function() {
	angular.module('servicoControllers', ['servicoRestService', 'servicoService']);


	function servicoFiltroController($scope, ngDialog, servicoRestService, servicoService) {
		$scope.servicoService = servicoService;
		$scope.findservicoBydescricao = function () {
			if($scope.descricao) {
				var $promise = servicoRestService.searchByDescricao($scope.descricao);
				$promise.success(function(response, status) {
					if(status == 204) {
						$scope.servicoService.servicos = null;
					}
					servicoService.set(response);
					$scope.servicoService = servicoService;
				});
				return;
			}
			var $promise = servicoRestService.findAll();
			$promise.success(function(response) {
				$scope.servicoService.servicos = response;
			});
		};
	}

	angular.module('servicoControllers').controller('servicoListController', servicoListController);

	function servicoListController($scope, ngDialog, servicoRestService, servicoService) {
		$scope.servicoService = servicoService;
		$scope.tab = 0;

		$scope.deletarServico = function(servico) {
			$scope.servico = servico;
			ngDialog.open({
				template: 'servicos/modal.confirm.html',
				scope: $scope,
				showClose: false,
				closeByEscape: false,
				closeByDocument : false
			});
		}

		$scope.confirmDeletar = function() {
			servicoRestService.delete($scope.servico).success(function() {
				ngDialog.closeAll();
				ngDialog.open({
					template:'\
						<p>Serviço deletado com sucesso!!</p>\
		                <div class="ngdialog-buttons">\
		                    <button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="closeThisDialog(0)">OK</button>\
		                    \</div>',
		            plain: true
				});
				$scope.servico = null;
				carregarServicos();
			});
		}

		$scope.openModalEditar = function(servico) {
			ngDialog.open({
				template: 'servicos/modal.form.html',
				showClose: true,
		        closeByDocument: false,
		        closeByEscape: false,
		        controller: 'servicoEditController',
		        resolve: {
		            servico: function() {
		                return servico;
		            }
		        }
			});
		}

		$scope.sort = function(keyname){
			$scope.sortKey = keyname;   //set the sortKey to the param passed
			$scope.reverse = !$scope.reverse; //if true make it false and vice versa
		}

		var carregarServicos = function() {
			var $promise = servicoRestService.findAll();
			$promise.success(function(response) {
				$scope.servicoService.servicos = response;
			});
		}
		carregarServicos();
	}
	angular
		.module('servicoControllers')
		.controller('servicoNewController', servicoNewController);
	function servicoNewController($scope, $window, ngDialog, servicoRestService) {
		$scope.servico = {};
		$scope.openModalCadasro = function() {
			ngDialog.open({
				template: 'servicos/modal.form.html',
				scope: $scope,
				showClose: false,
		        closeByDocument: false,
		        closeByEscape: false
			});
		}


	    $scope.salvar = function (servico) {
	    	var $promise = servicoRestService.save(servico);
    		$promise.success(function() {
    			$scope.progress = false;
					humane.log("Serviço Cadastrado com Sucesso!!");
					setTimeout(function() { $window.location.reload(); }, 1000);
    		});
	    };
	}
	angular.module('servicoControllers')
		.controller('servicoEditController', servicoEditController);

	function servicoEditController($scope, $window, ngDialog, servicoRestService, servico) {
			$scope.servico = servico;
	    $scope.salvar = function (servico) {

	    	var $promise = servicoRestService.save(servico);
    		$promise.success(function() {
    			$scope.progress = false;
					humane.log("Serviço Atualizado com Sucesso!!");
    		});
	    };
	}

} ());

//controller forma de pagamento

(function() {
	angular.module('formaControllers', ['formaRestService', 'formaService']);


	angular.module('formaControllers').controller('formaListController', formaListController);

	function formaListController($scope, ngDialog, formaRestService, formaService) {
		$scope.formaService = formaService;
		$scope.tab = 0;

		$scope.deletarForma = function(forma) {
			$scope.forma = forma;
			ngDialog.open({
				template: 'formas/modal.confirm.html',
				scope: $scope,
				showClose: false,
				closeByEscape: false,
				closeByDocument : false
			});
		}

		$scope.confirmDeletar = function() {
			formaRestService.delete($scope.forma).success(function() {
				ngDialog.closeAll();
				ngDialog.open({
					template:'\
						<p>Forma de Pagamento deletado com sucesso!!</p>\
		                <div class="ngdialog-buttons">\
		                    <button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="closeThisDialog(0)">OK</button>\
		                    \</div>',
		            plain: true
				});
				$scope.forma = null;
				carregarFormas();
			});
		}

		$scope.openModalEditar = function(forma) {
			ngDialog.open({
				template: 'formas/modal.form.html',
				showClose: true,
		        closeByDocument: false,
		        closeByEscape: false,
		        controller: 'formaEditController',
		        resolve: {
		            forma: function() {
		                return forma;
		            }
		        }
			});
		}

		$scope.sort = function(keyname){
			$scope.sortKey = keyname;   //set the sortKey to the param passed
			$scope.reverse = !$scope.reverse; //if true make it false and vice versa
		}

		var carregarFormas = function() {
			var $promise = formaRestService.findAll();
			$promise.success(function(response) {
				$scope.formaService.formas = response;
			});
		}
		carregarFormas();
	}
	angular
		.module('formaControllers')
		.controller('formaNewController', formaNewController);
	function formaNewController($scope, $window, ngDialog, formaRestService) {
		$scope.forma = {};
		$scope.openModalCadasro = function() {
			ngDialog.open({
				template: 'formas/modal.form.html',
				scope: $scope,
				showClose: false,
		        closeByDocument: false,
		        closeByEscape: false
			});
		}


	    $scope.salvar = function (forma) {
	    	var $promise = formaRestService.save(forma);
    		$promise.success(function() {
    			$scope.progress = false;
					humane.log("Forma de Pagamento Cadastrada com Sucesso!!");
					setTimeout(function() { $window.location.reload(); }, 1000);
    		});
	    };
	}
	angular.module('formaControllers')
		.controller('formaEditController', formaEditController);

	function formaEditController($scope, $window, ngDialog, formaRestService, forma) {
			$scope.forma = forma;
	    $scope.salvar = function (forma) {

	    	var $promise = formaRestService.save(forma);
    		$promise.success(function() {
    			$scope.progress = false;
					humane.log("Forma de Pagamento Atualizada com Sucesso!!");
    		});
	    };
	}


} ());
