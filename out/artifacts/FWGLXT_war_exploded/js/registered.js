
/**
 * 表单回调函数，判断表单输入是否合法
 * @returns {boolean} 是否合法
 */
function check() {
    var userName = document.f1.userName.value;
    var passwd = document.f1.passwd.value;
    var repasswd = document.f1.repasswd.value;
    var trueName = document.f1.trueName.value;
    var tel = document.f1.tel.value;
    var email = document.f1.email.value;
    var vc = document.f1.vc.value;
    if(userName === ""){
        window.alert("请输入用户名!");
        return false;
    }
    if(passwd === ""){
        window.alert("请输入密码!");
        return false;
    }
    if(repasswd === ""){
        window.alert("请输入密码!");
        return false;
    }
    if(repasswd !== passwd){
        window.alert("两次密码不一致!");
        return false;
    }
    if(trueName === ""){
        window.alert("请输入姓名!");
        return false;
    }
    if(tel === ""){
        window.alert("请输入电话!");
        return false;
    }
    if(email === ""){
        window.alert("请输入邮箱!");
        return false;
    }
    if(vc === ""){
        window.alert("请输入验证码!");
        return false;
    }

    var re_user = /^[a-zA-Z]+[0-9a-zA-Z]*/;


    //验证用户名
    if(userName.length<6 || userName.length>16){
        window.alert("用户名长度错误!");
        return false;
    }
    if(!re_user.test(userName)){
        window.alert("用户名不合法!");
        return false;
    }

    //验证手机号
    if(!isTel(tel)){
        window.alert("手机号不合法!");
        return false;
    }

    //验证邮箱
    if(!isEmail(email)){
        window.alert("邮箱不合法!");
        return false;
    }

    return true;
}

/**
 * 验证是否为手机号
 * @param tel
 * @returns {boolean}
 */
function isTel(tel) {
    var re_tel = /0?(13|14|15|17|18|19)[0-9]{9}/;
    return re_tel.test(tel);
}

/**
 * 验证是否为邮箱
 * @param email
 * @returns {boolean}
 */
function isEmail(email) {
    var re_email = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
    return re_email.test(email);
}