
function check(){
    var userName = document.form_login.userName.value;
    var passwd = document.form_login.passwd.value;

    if(userName === ""){
        window.alert("请输入账号!");
        return false;
    }
    if(passwd === ""){
        window.alert("请输入密码!");
        return false;
    }

    return true;

}