//文本类
//做一系列的文本操作
//081417137吴硕

package util;

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



}
