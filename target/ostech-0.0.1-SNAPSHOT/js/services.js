(function() {

	angular.module('servicoService', []);

	function servico() {
		// lista de carros
		var servicos = [];

		function setServicos(servicos) {
			this.servicos = servicos;
		}

		function getServicos() {
			return this.servicos;
		}

		return {
			servicos: servicos,
			set : setServicos,
			get : getServicos
		}
	}

	angular.module('servicoService').factory('servicoService', servico);
}());

(function() {

	angular.module('formaService', []);

	function forma() {
		// lista de carros
		var formas = [];

		function setFormas(formas) {
			this.formas = formas;
		}

		function getFormas() {
			return this.formas;
		}

		return {
			formas: formas,
			set : setFormas,
			get : getFormas
		}
	}

	angular.module('formaService').factory('formaService', forma);
}());
