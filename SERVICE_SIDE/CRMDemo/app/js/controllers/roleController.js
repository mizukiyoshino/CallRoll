
'use strict';
/**
 * 菜单控制
 * @param {[type]} $scope [description]
 * @param {[type]} $http  [description]
 * @param {[type]} $modal [description]
 */

function RoleCtrl ($scope, $http, $modal,constantIP){
    console.log("加载角色管理..."+constantIP);

    $scope.filterOptions = {
        filterText: "",
        useExternalFilter: true
    };
    $scope.totalServerItems = 0;
    $scope.pagingOptions = {
        pageSizes: [10, 50, 100],
        pageSize: 10,
        currentPage: 1
    };
    $scope.setPagingData = function(data, page, pageSize){

        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
        console.log(".................."+pagedData);
        $scope.myData = pagedData;
        $scope.totalServerItems = data.length;
        if (!$scope.$$phase) {
            $scope.$apply();
        }
    };
    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
        $http({
            method: 'POST',
            url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/getAllDdRole'
        }).success(function(largeLoad) {
            console.log(largeLoad);
            var obj = $scope.gridOptions.selectedItems;
            obj.splice(0,obj.length);
            $scope.setPagingData(largeLoad.ddRoles, page, pageSize);
        });
    };

    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);

    $scope.$watch('pagingOptions', function (newVal, oldVal) {
        if (newVal !== oldVal || newVal.currentPage !== oldVal.currentPage) {
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    $scope.$watch('filterOptions', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);

    $scope.gridOptions = {
        data: 'myData',
        i18n:'zh-cn',
        enablePaging: true,
        showFooter: true,
        showSelectionCheckbox: true,
        totalServerItems: 'totalServerItems',
        pagingOptions: $scope.pagingOptions,
        filterOptions: $scope.filterOptions,
        selectedItems: [],
        columnDefs: [
            {field:'dname', displayName:'名称'},
            {field:'role', displayName:'值'}
        ]
    };

    //新增
    $scope.insert = function(){
        $modal.open({
            templateUrl: "/templates/role/roleModal.html",
            controller: 'RoleInsertCtrl2',
            resolve: {
                grid: function(){ return $scope; }
            }
        });
    };

    //更新
    $scope.update = function(){
        var selectedItems = $scope.gridOptions.selectedItems;
        if(selectedItems.length != 1){
            alert("请选择一条记录");
            return;
        }
        $modal.open({
            templateUrl: "/templates/role/roleModal.html",
            controller: 'RoleUpdateCtrl1',
            resolve:{
                grid: function(){ return $scope; }
            }
        });
    };

    //删除
    $scope.delete = function(){
        console.log("jijijijijijijijijijijijij");
        var selectedItems = $scope.gridOptions.selectedItems;
        if(selectedItems.length == 0){
            alert("请至少选择一条记录");
            return;
        }
        if(!confirm("删除是不可恢复的，你确认要删除吗？")){
            return;
        }
        var selectedItems = $scope.gridOptions.selectedItems;
        var ids = [];

        //var strJson="{";

        for(var i = 0; i < selectedItems.length; i++){
            ids.push(selectedItems[i]["dname"]);
            // 直接传值，服务器是取名字
        }
        var json = {};
        for(var i1=0;i1<ids.length;i1++)
        {
            json[i1]=ids[i1];
        }
        JSON.stringify(json);
        $http({
            method: 'POST',
            url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/deleteDdRoleByName',
            params: {
                "dname": json
            }
        }).then(function(results){
            //刷新列表
            console.log(json);
        }).then(function (response) {
            var grid = $scope;
            grid.getPagedDataAsync(grid.pagingOptions.pageSize, grid.pagingOptions.currentPage);
        });
    };
}

/**
 * 菜单新增控制
 * @param {[type]} $scope         [description]
 * @param {[type]} $modalInstance [description]
 * @param {[type]} $http          [description]
 * @param {[type]} grid           [description]
 */
function RoleInsertCtrl1($scope, $modalInstance, $http, grid,constantIP){
    console.log("0000000000000000000000000");
    $scope.roles={};
    $scope.ok = function () {
        $http({
            method: 'POST',/*-GET--*/
            url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/createDdRole',
            data:{
                "dname": $scope.roles.dname,
                "role": $scope.roles.role
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function(data) {
                return $.param(data);
            }
        }).success(function(results){
            //刷新列表

            grid.getPagedDataAsync(grid.pagingOptions.pageSize, grid.pagingOptions.currentPage);
            $modalInstance.close();
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}

function RoleInsertCtrl2($scope, $modalInstance, $http, grid,constantIP){
    console.log("0000000000000000000000000");
    $scope.roles={};
    $scope.ok = function () {
        $http({
            method: 'POST',/*-GET--*/
            url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/createDdRole',
            data:{
                "dname": $scope.roles.dname,
                "role": $scope.roles.role
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function(data) {
                return $.param(data);
            }
        }).success(function(results){
            //刷新列表

            grid.getPagedDataAsync(grid.pagingOptions.pageSize, grid.pagingOptions.currentPage);
            $modalInstance.close();
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}
/**
 * 菜单更新控制
 * @param {[type]} $scope         [description]
 * @param {[type]} $modalInstance [description]
 * @param {[type]} $http          [description]
 * @param {[type]} grid           [description]
 */


function RoleUpdateCtrl1($scope, $modalInstance, $http, grid, $log, constantIP){
   // $scope.roles = {};
   // $scope.roles.dname = "11111";
    console.log("iiiiiiiiiiiiiiiiiiiiii");
    console.log("这是，更新入口");
    var oldrolename = "";
    console.log("iiiiiiiiiiiiiiiiiiiiii");
    $http({
        method: 'GET',
        url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/getDdRoleStateByName',
        params: {"dname": grid.gridOptions.selectedItems[0].dname}
    }).success(function(results){
        console.log("iiiiiiiiiiiiiiiiiiiiii");
        $log.log(results.ddRole);
        oldrolename = results.ddRole.dname;
        $scope.roles = {};
        for(var key in results.ddRole){
            $scope.roles[key] = results.ddRole[key];
            console.log(key);
        }
    });

    $scope.ok = function () {
        $http({
            method: 'POST',
            url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/updateDdRoleStateByName',
            data: {
                "oldname":oldrolename,
                "dname": $scope.roles.dname,
                "role": $scope.roles.role
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function(data) {
                return $.param(data);
            }
        }).success(function(results){
            //刷新列表
            $log.log(results.state);
            grid.getPagedDataAsync(grid.pagingOptions.pageSize, grid.pagingOptions.currentPage);
            $modalInstance.close();
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}

function RoleUpdateCtrl($scope, $modalInstance, $http, grid, $log, constantIP){
    console.log("这是，更新入口");
    var oldrolename = "";
    console.log("iiiiiiiiiiiiiiiiiiiiii");
    $http({
        method: 'GET',
        url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/getDdRoleStateByName',
        params: {"dname": grid.gridOptions.selectedItems[0].dname}
    }).success(function(results){
        console.log("iiiiiiiiiiiiiiiiiiiiii");
        $log.log(results.ddRole);
        oldrolename = results.ddRole.dname;
        $scope.roles = {};
        for(var key in results.ddRole){
            $scope.roles[key] = roles.ddRole[key];
            console.log(key);
        }
    });

    $scope.ok = function () {
        $http({
            method: 'POST',
            url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/updateDdRoleStateByName',
            data: {
                "oldname":oldrolename,
                "dname": $scope.roles.dname,
                "role": $scope.roles.role
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function(data) {
                return $.param(data);
            }
        }).success(function(results){
            //刷新列表
            $log.log(results.state);
            grid.getPagedDataAsync(grid.pagingOptions.pageSize, grid.pagingOptions.currentPage);
            $modalInstance.close();
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}