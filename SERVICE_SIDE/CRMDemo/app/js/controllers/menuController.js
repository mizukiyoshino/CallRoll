/**
 * Created by nanjolno on 2017/5/13.
 */
// var ipNum="222.76.58.141  218.5.44.177";
'use strict';
// console.log(ipNum);
/**
 * 菜单控制
 * @param {[type]} $scope [description]
 * @param {[type]} $http  [description]
 * @param {[type]} $modal [description]
 */

function MenuCtrl ($scope, $http, $modal,constantIP){
    console.log("加载菜单管理...");

    /**
     * 配置ng-grid
     * @type {Object}
     */
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
        console.log(pagedData);
        $scope.myData = pagedData;
        $scope.totalServerItems = data.length;
        if (!$scope.$$phase) {
            $scope.$apply();
        }
    };
    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
        $http({
            method: 'POST',
                    url: 'http://'+constantIP+':8080/shhTest/personnelaction/getAllPersonnelHql'   /*--------/action/menu/query---http://222.76.58.141:8080/shhTest/personnelaction/getAllPersonnel--*/
        }).success(function(largeLoad) {
            console.log(largeLoad);
            var obj = $scope.gridOptions.selectedItems;
            obj.splice(0,obj.length);
            $scope.setPagingData(largeLoad.personnels, page, pageSize); /*---largeLoad*/
            console.log(largeLoad);
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
            {field:'ID', displayName:'学号'},
            {field:'Pname', displayName:'姓名'},
            {field:'Ppassword', displayName:'密码'},
            {field:'pclass', displayName:'班级'},
            {field:'major', displayName:'专业'},
            {field:'role', displayName:'角色'}
        ]

        /*
         columnDefs: [
         {field:'menuId', displayName:'编码'},
         {field:'menuName', displayName:'课程ID'},
         {field:'parentId', displayName:'人员ID'},
         {field:'path', displayName:'状态'},
         {field:'level', displayName:'理由'},
         {field:'menuIcon', displayName:'日期'}
         ]
         * */
    };

    //新增
    $scope.insert = function(){
        $modal.open({
            templateUrl: "/templates/menu/menuModal1.html",
            controller: 'MenuInsertCtrl',
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
            templateUrl: "/templates/menu/menuModal1.html",
            controller: 'MenuUpdateCtrl',
            resolve:{
                grid: function(){ return $scope; }
            }
        });
    };

    //删除
    $scope.delete = function(){
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
            //strJson = strJson+"\""+i.toString()+"\""+":"+"\""+selectedItems[i]["ID"]+"\""+",";
            ids.push(selectedItems[i]["ID"]);/*-------menuId------*/
        }
        //strJson = strJson+"\""+(i)+"\""+":"+"\""+selectedItems[i]["ID"]+"\""+"}";

        //console.log("00000000000");
        //console.log(strJson);
        //console.log("00000000000");
        var json = {};
        for(var i1=0;i1<ids.length;i1++)
        {
            json[i1]=ids[i1];
        }
        JSON.stringify(json);
        console.log(json);

        $http({
            method: 'POST',
            url: 'http://'+constantIP+':8080/shhTest/personnelaction/deletePersonnelByID',    /*--------/action/menu/delete-----*/
            params: {
                "id": json
            }
        }).then(function(results){
            //刷新列表
            console.log(222111111111111111122);

            // $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
            //grid.getPagedDataAsync(grid.pagingOptions.pageSize, grid.pagingOptions.currentPage);
            //$modalInstance.close();
        }).then(function (response) {
            //$scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
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
function MenuInsertCtrl($scope, $modalInstance, $http, grid,constantIP){/*-------------*/
    // var menu = {
    // "menuId":"menu.menuId",
    // "menuName":"menu.menuName",
    // "parentId":"menu.parentId",
    // "level":"menu.level",
    // "menuIcon": "menu.menuIcon"
    // };
    $scope.menu={
        // menuId:1,
        // "menuName":"menu.menuName",
        // "parentId":"menu.parentId",
        // "level":"menu.level",
        // "menuIcon": "menu.menuIcon"
    };
    //$scope.menu.menuName="233";
    console.log($scope.menu);
    // menu={
    //      menuName:"22",
    //      parentId:"22",
    //      level:"22",
    //      menuIcon:"222"
    //  };
    console.log($scope.menu);
    // 下拉框专业
    $scope.largeLoads={
    };
    $scope.countries = new Array();
    $http({
        method: 'POST',
        url: 'http://'+constantIP+':8080/shhTest/ddMajoraction/getAllDdMajor'
    }).success(function(largeLoad) {
        $scope.largeLoads=largeLoad;
        for(var i=0;i<$scope.largeLoads.ddMajors.length;i++){
            $scope.countries[i]={"dname":$scope.largeLoads.ddMajors[i].dname,
                "major":$scope.largeLoads.ddMajors[i].major};
        }
    });
    // 下拉框专业
    // 下拉框角色
    $scope.largeLoads1={
    };
    $scope.countries1 = new Array();
    $http({
        method: 'POST',
        url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/getAllDdRole'
    }).success(function(largeLoad) {
        $scope.largeLoads1=largeLoad;
        for(var i=0;i<$scope.largeLoads1.ddRoles.length;i++){
            $scope.countries1[i]={"dname":$scope.largeLoads1.ddRoles[i].dname,
                "role":$scope.largeLoads1.ddRoles[i].role};
        }
    });
    //下拉框角色
    $scope.ok = function () {
        console.log($scope.menu.Pname);
        console.log($scope.menu.Ppassword);
        console.log($scope.menu.major);
        console.log($scope.menu.role);

        $http({
            method: 'POST',/*-GET--*/
            url: 'http://'+constantIP+':8080/shhTest/personnelaction/createPersonnel',/*------/action/menu/insert-------*/
            data:{
                "id": $scope.menu.ID,
                "pname": $scope.menu.Pname,
                "password": $scope.menu.Ppassword,
                //"dept": "计算机系",
                //"major":"计算机技术",
                //"role":3
                // "id": $scope.menu.ID,
                // "pname": $scope.menu.Pname,
                // "password": $scope.menu.Ppassword,
                "pclass": $scope.menu.pclass,
                "major":$scope.menu.major,
                "role":$scope.menu.role
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            transformRequest: function(data) {
                return $.param(data);
            }// data: $scope.menu*/
        }).success(function(results){
            //刷新列表
            console.log(222111111111111111122);
            //console.log(results.personnel.Pname);
            grid.getPagedDataAsync(grid.pagingOptions.pageSize, grid.pagingOptions.currentPage);
            $modalInstance.close();
        });
    };

    $scope.cancel = function () {
        console.log(111);
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
function MenuUpdateCtrl($scope, $modalInstance, $http, grid,$log,constantIP){/*-------------*/
    
    $http({
        method: 'GET',
        url: 'http://'+constantIP+':8080/shhTest/personnelaction/getPersonnelByID',/*--------/action/menu/query-----*/
        params: {"id": grid.gridOptions.selectedItems[0].ID}/*------menuId--ID-----*//*--需要修改-*/
    }).success(function(results){
        $log.log(results.personnel);
        $scope.menu = {};
        for(var key in results.personnel){
            //$log.log(results.personnel[key]);
            $scope.menu[key] = results.personnel[key];
        }
    });
// 下拉框专业
    $scope.largeLoads={
    };
    $scope.countries = new Array();
    $http({
        method: 'POST',
        url: 'http://'+constantIP+':8080/shhTest/ddMajoraction/getAllDdMajor'
    }).success(function(largeLoad) {
        $scope.largeLoads=largeLoad;
        for(var i=0;i<$scope.largeLoads.ddMajors.length;i++){
            $scope.countries[i]={"dname":$scope.largeLoads.ddMajors[i].dname,
                "major":$scope.largeLoads.ddMajors[i].major};
                 }
    });
    // 下拉框专业
    // 下拉框角色
    $scope.largeLoads1={
    };
    $scope.countries1 = new Array();
    $http({
        method: 'POST',
        url: 'http://'+constantIP+':8080/shhTest/ddRoleaction/getAllDdRole'
    }).success(function(largeLoad) {
        $scope.largeLoads1=largeLoad;
        for(var i=0;i<$scope.largeLoads1.ddRoles.length;i++){
            $scope.countries1[i]={"dname":$scope.largeLoads1.ddRoles[i].dname,
                "role":$scope.largeLoads1.ddRoles[i].role};
        }
    });
    //下拉框角色
    $scope.ok = function () {
        $http({
            method: 'POST',
            url: 'http://'+constantIP+':8080/shhTest/personnelaction/updatePersonnel',/*-------------*/
            data: {
                "id": $scope.menu.ID,
                "pname": $scope.menu.Pname,
                "password": $scope.menu.Ppassword,
                "pclass": $scope.menu.pclass,
                "major":$scope.menu.major,
                "role":$scope.menu.role
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