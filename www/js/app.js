/**
 * Created by Administrator on 2017/4/8.
 */
angular.module('starter', ['ui.router','starter.controllers'])

    .config(function($stateProvider, $urlRouterProvider) {
        $stateProvider

            .state('app', {
                url: '/app',
                abstract: true,
                templateUrl: 'views/appBorder/appBorder.html',
                controller: 'AppCtrl'
            })

            .state('app.form', {
                url: '/form',
                views: {
                    'mainContainer': {
                        templateUrl: 'views/layout/form.html'//,
                        //controller: 'PlaylistCtrl'
                    }
                }
            });
        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/app/form');
    });