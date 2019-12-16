//文本类
//做一系列的文本操作
//081417137吴硕

package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TextUtil {

    /**
     * 生成随机验证码
     * @param length 长度
     * @return 随机的验证码
     */
    public static String randomVC(int length){
        String text = "QAZXSWEDCVFRTGBNHYUJMKLOIP7896541203";
        StringBuilder VC = new StringBuilder();
        Random r = new Random();
        int pos;
        for(int i=0;i<length;i++){
            pos = r.nextInt(36);
            VC.append(text.charAt(pos));
        }
        return VC.toString();
    }

    /**
     * 错误提示
     * @param msg 提示
     * @param location 目标
     * @return String
     */
    public static String errText(String msg,String location){
        String script = "<script>alert('%s');location.href='%s'</script>";
        return String.format(script,msg,location);
    }

    /**
     * 毫秒数转日期
     * @param mili 毫秒数
     * @return 日期
     */
    public static String transferLongToDate(long mili){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date(mili);
        return sdf.format(date);
    }

}
