function check_f2() {
    var l = document.f2.keyword_area_lower.value;
    var h = document.f2.keyword_area_higher.value;

    var re = /^\s*$/;

    if(re.test(l)){
        window.alert("请输入！");
        return false;
    }

    if(re.test(h)){
        window.alert("请输入！");
        return false;
    }

    return true;
}

function check_f3() {
    var l = document.f3.keyword_price_lower.value;
    var h = document.f3.keyword_price_higher.value;

    var re = /^\s*$/;

    if(re.test(l)){
        window.alert("请输入！");
        return false;
    }

    if(re.test(h)){
        window.alert("请输入！");
        return false;
    }

    return true;
}