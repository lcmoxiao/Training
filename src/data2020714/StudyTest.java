package data2020714;


public class StudyTest {

    public static void main(String[] args) {
        StudyTest st = new StudyTest();
        st.test();
    }

    void test() {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("a1 b " + a1.show(b));// A A   b向上塑形
        System.out.println("a1 c " + a1.show(c));// A A   c向上塑形
        System.out.println("a1 d " + a1.show(d));// A D
        System.out.println("a2 b " + a2.show(b));// B A   有可用成员方法，且成员方法被子类B覆盖，故执行B类的show(A obj)
        System.out.println("a2 c " + a2.show(c));// 同上
        System.out.println("a2 d " + a2.show(d));// 有可执行方法没被覆盖
        System.out.println("b b " + b.show(b));
        System.out.println("b c " + b.show(c));
        System.out.println("b d " + b.show(d));
    }
}

class A {

    public String show(A obj) {
        return ("A A");
    }

    public String show(D obj) {
        return ("A D");
    }
}

class B extends A {
    public String show(B obj) {
        return ("B B");
    }

    public String show(A obj) {
        return ("B A");
    }
}

class C extends B {
}

class D extends B {
}