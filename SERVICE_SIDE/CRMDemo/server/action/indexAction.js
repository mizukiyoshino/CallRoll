
var express = require('express');
var router = express.Router();

/* GET / page. */
router.get('/', function(req, res, next) {
  if(!req.session.user){
    res.render("login");
    return;
  }
  res.locals.user = req.session.user;
  res.render('index');
});

module.exports = router;