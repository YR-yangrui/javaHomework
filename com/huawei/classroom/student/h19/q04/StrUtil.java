package com.huawei.classroom.student.h19.q04;

public class StrUtil {
    public Object removeDulpicatedChar(String s) {
        String res = "";
        while(!s.equals("")){
            res = res + s.charAt(0);
            s = s.replace("" + (s.charAt(0)),"");
        }
        return res;
    }
}
