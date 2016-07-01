/**
 * API para acessar os web services REST dos carros
 */
(function() {
	angular.module('servicoRestService', []);

	servicoRestService = function($http, APP_CONFIG) {
		var urlApi = APP_CONFIG.API_REST + '/servicos';

		function findAll() {
			return $http.get(this.api);
		}

		function save(servico) {
			if(servico.id) {
				console.log(this.api + '/' + servico.id);
				return $http.put(this.api + '/' + servico.id, servico);

			}

			console.log("salvou")
			return $http.post(this.api, servico);
		}

		function find(id) {
			return $http.get(this.api + '/' + id);
		}

		function deleteServico(servico, file) {
			console.log("apagou");
			console.log(this.api + '/' + servico.id);
			return $http.delete(this.api + '/' + servico.id);
		}


		return {
			api: urlApi,
			save: save,
			findAll: findAll,
			find: find,
			delete: deleteServico,
		}
	}
	angular.module('servicoRestService')
		.service('servicoRestService', servicoRestService);
} ());

/**
 *
 */

(function() {
	angular.module('formaRestService', []);

	formaRestService = function($http, APP_CONFIG) {
		var urlApi = APP_CONFIG.API_REST + '/formaspgto';

		function findAll() {
			return $http.get(this.api);
		}

		function save(forma) {
			if(forma.id) {
				console.log(this.api + '/' + forma.id);
				return $http.put(this.api + '/' + forma.id, forma);

			}

			console.log("salvou")
			return $http.post(this.api, forma);
		}

		function find(id) {
			return $http.get(this.api + '/' + id);
		}

		function deleteForma(forma, file) {
			console.log("apagou");
			console.log(this.api + '/' + forma.id);
			return $http.delete(this.api + '/' + forma.id);
		}


		return {
			api: urlApi,
			save: save,
			findAll: findAll,
			find: find,
			delete: deleteForma,
		}
	}
	angular.module('formaRestService')
		.service('formaRestService', formaRestService);
} ());
