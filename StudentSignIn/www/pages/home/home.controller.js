(function () {
  'use strict';
  angular.module('starter.controllers')
    .controller('PlaylistsCtrl', ['$scope', '$http',
      function ($scope, $http) {
        $http.get("http://222.76.30.22:8080/shhTest/personnelaction/getAllPersonnelHql")
          .success(function (personnels) {
            //alert(personnels);
            $scope.data = personnels;
          });
      }])
})();
