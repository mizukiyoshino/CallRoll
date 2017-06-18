
var user = {
    userId : "",    //用户编号
    userName : "",  //用户名
    password : "",  //密码
    email: "",      //邮箱
    query: "SELECT * FROM user WHERE 1=1 ",
    insert: "INSERT INTO user SET ",
    update: "UPDATE user SET ",
    delete: "DELETE FROM user WHERE userId in ",
    pk: "userId"
}

module.exports = user;  