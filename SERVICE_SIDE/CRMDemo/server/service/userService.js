
var userDao = require('../dao/userDao.js');

//查询用户
exports.query = function(data, callback){
    userDao.query(data, function(err, results){
        if(err){
            callback(true);
            return;
        }
        callback(false, results);
    });
};

//新增用户
exports.insert = function(data, callback){
    userDao.insert(data, function(err){
        if(err){
            callback(true);
            return;
        }
        callback(false);
    });
};

//修改用户
exports.update = function(data, callback){
    userDao.update(data, function(err){
        if(err){
            callback(true);
            return;
        }
        callback(false);
    });
};

//修改用户
exports.delete = function(data, callback){
    userDao.delete(data, function(err){
        if(err){
            callback(true);
            return;
        }
        callback(false);
    });
};