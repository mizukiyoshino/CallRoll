
var menuDao = require('../dao/menuDao.js');

//查询用户菜单
exports.queryByUserId = function(data, callback){
    menuDao.queryByUserId(data, function(err, results){
        if(err){
            callback(true);
            return;
        }
        callback(false, results);
    });
};

//查询角色菜单
exports.queryByRoleId = function(data, callback){
    menuDao.queryByRoleId(data, function(err, results){
        if(err){
            callback(true);
            return;
        }
        callback(false, results);
    });
};

//更新角色菜单
exports.updateByRoleId = function(data, callback){
    menuDao.updateByRoleId(data, function(err, results){
        if(err){
            callback(true);
            return;
        }
        callback(false, results);
    });
};

//查询菜单
exports.query = function(data, callback){
    menuDao.query(data, function(err, results){
        if(err){
            callback(true);
            return;
        }
        callback(false, results);
    });
};

//新增菜单
exports.insert = function(data, callback){
    menuDao.insert(data, function(err){
        if(err){
            callback(true);
            return;
        }
        callback(false);
    });
};

//修改菜单
exports.update = function(data, callback){
    menuDao.update(data, function(err){
        if(err){
            callback(true);
            return;
        }
        callback(false);
    });
};

//修改菜单
exports.delete = function(data, callback){
    menuDao.delete(data, function(err){
        if(err){
            callback(true);
            return;
        }
        callback(false);
    });
};