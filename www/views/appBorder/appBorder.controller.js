/**
 * Created by Administrator on 2017/4/8.
 */
angular.module('starter.controllers')
    .controller('AppCtrl',['$scope',function ($scope) {
        angular.element().ready(function () {
            init_func();
        });
    }]);