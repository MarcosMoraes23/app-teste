'use strict';

var services = angular.module('appOS.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

services.factory('ServicosFactory', function ($resource) {
    return $resource(baseUrl + '/servicos', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('ServicoFactory', function ($resource) {
    return $resource(baseUrl + '/servicos/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});
