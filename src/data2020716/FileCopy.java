package data2020716;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Copy{
    void copyFile1() throws IOException;
    void copyFile2() throws IOException;
}

public class FileCopy implements Copy{

    public static void main(String[] args) throws IOException {

        TimeCountProxy timeCountProxy = new TimeCountProxy();
        timeCountProxy.setTarget(new FileCopy());
        Copy copy = (Copy) timeCountProxy.getProxy();
        copy.copyFile1();
        copy.copyFile2();

    }

    @Override
    public void copyFile1() throws IOException {
        File file = new File("d://a.txt");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream("d://b.txt");
        int len;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
        }
        inputStream.close();
        outputStream.close();
    }

    @Override
    public void copyFile2() throws IOException {

        File file = new File("d://a.txt");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream("d://c.txt");
        int len;
        byte[] buf = new byte[1024];
        while ((len = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }
        inputStream.close();
        outputStream.close();
    }


}

class TimeCountProxy implements InvocationHandler {

    Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        System.out.println("time consumed:" + (start - System.currentTimeMillis()));
        return result;
    }
}