package data2020714;

interface TypeC {
    void work();
}

public class PhoneTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.turnOn();
        phone.useTypeC(new EarPhone());
        phone.useTypeC(new Charger());
        phone.turnOff();
    }
}

class Phone {
    public void turnOn() {
        System.out.println("开机");
    }

    public void turnOff() {
        System.out.println("关机");
    }

    public void useTypeC(TypeC typeC) {
        typeC.work();
    }
}

class EarPhone implements TypeC {
    @Override
    public void work() {
        System.out.println("正在听歌");
    }
}

class Charger implements TypeC {
    @Override
    public void work() {
        System.out.println("正在充电");
    }
}