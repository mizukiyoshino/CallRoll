/**
 * Created by nanjolno on 2017/6/16.
 */


'use strict';
/**
 * 菜单控制
 * @param {[type]} $scope [description]
 * @param {[type]} $http  [description]
 * @param {[type]} $modal [description]
 */

function LoginCtrl($scope,$http,constantIP, res){
    console.log("进入");
    $scope.qqqq = function () {
        console.log("登录按钮");
        $scope.log={};
        $http({
            method: 'POST',
            url: 'http://'+constantIP+':8080/shhTest/personnelaction/CheckPersonnel',
            data:{
                "id": $scope.log.ID,//$scope.log.ID,
                "password": $scope.log.Password//$scope.log.Password
            },
            // headers: {
            //     'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            // },
            // transformRequest: function(data) {
            //     return $.param(data);
            // }// data: $scope.menu*/
        }).success(function(largeLoad) {
            console.log("成功");
            console.log(largeLoad.state);
            $scope.remind="";
            if(largeLoad.state==0)
            { res.redirect("/") ;}
        });
    }
}
