package cn.edu.cqut.cat.se.nemu.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {

    public static String  getMd5(String username,String password){
        Md5Hash md5Hash = new Md5Hash(password,username,1000);
        return md5Hash.toString();
    }

    public static void main(String[] args) {
        System.out.println(cn.edu.cqut.cat.se.nemu.util.Md5Util.getMd5("admin","123"));
    }

}
