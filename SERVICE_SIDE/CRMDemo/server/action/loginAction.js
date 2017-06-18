
var express = require('express');
var userService = require('../service/userService.js');
var router = express.Router();

//登录操作
router.post("/login", function(req, res){
    // var data = {email:"chenhao@node.com", password: "123456"};
     var data = {email:"yuanbingjie@qq.com", password: "123456"};
    userService.query(data, function(err, results){
        // if(err || results.length == 0){
        //     res.redirect("/login.html");
        //     return;
         //}
        req.session.user = "chenhao@node.com";
        res.redirect("/");
    });
});

//登出操作
router.post("/logout", function(req, res){
    delete req.session.user;
    res.json({msg: "登出成功"});
});

module.exports = router;