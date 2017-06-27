
(function(){
  'use strict';
  angular.module('starter.controllers')
    .controller('LoginCtrl',['$scope','$state','$ionicPopup',function($scope,$state,$ionicPopup){
      $scope.loginData={username:'',password:''};
    $scope.login=function(){
      //匹配后台数据
      if($scope.loginData.username=='admin'&&$scope.loginData.password=='12345'){
        $state.go("app.home");
      }
      else{
        $ionicPopup.alert({
          title:'友情提示',
          template:'您输入的用户名或密码有误',
          okText:'确定',
          okType:'button-energized'
        });
      };
    };
      $scope.togo=function(){
        $state.go("register");
      }
    }]);
})();
