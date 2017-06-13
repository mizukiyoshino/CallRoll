(function () {
  'use strict';
  angular.module('starter.services')
    .service('connService', function ($http) {
        this.getPerson = function ($http) {
          return $http.get('http://222.76.30.22:8080/shhTest/personnelaction/getAllPersonnelHql')
        }
    })
})();
