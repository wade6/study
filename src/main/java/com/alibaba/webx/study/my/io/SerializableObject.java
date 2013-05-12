package com.alibaba.webx.study.my.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *  对象的序列化
 *  ObjectInputStream 和 ObjectOutputStream
 */
public class SerializableObject implements Serializable {

    /**   **/
    private static final long serialVersionUID = 7838592573148334301L;

    private int    num;

    private String name;

    public SerializableObject() {

    }

    public SerializableObject(int num,String name) {
        this.name = name;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) throws Exception{
        SerializableObject object = new SerializableObject(12,"test");
        String src = "/home/huamo/io/serializable.txt";
        File f = FileOperate.createFile(src);
        
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(f));
        oout.writeObject(object);
        
        oout.close();
        
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(f));
        SerializableObject object2 = (SerializableObject) oin.readObject();
        System.out.println("name:"+object2.getName()+" num:"+object2.getNum());
        
    }

}
