var mysql = require('mysql');
var config = require('./config');
 
var mysqlPool = mysql.createPool(config.mysql_dev);

exports.mysqlPool = mysqlPool;