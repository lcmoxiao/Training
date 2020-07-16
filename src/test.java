import java.util.concurrent.*;

public class test {

    public static void main(String[] args) {
        FutureTest();
    }

    static void FutureTest() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 666;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        FutureTask<Integer> ft = new FutureTask<>(callable);

        System.out.println(ft.isCancelled());
        System.out.println(ft.isDone());


        executorService.submit(ft);

        try {
            System.out.println(ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(ft.isCancelled());
        System.out.println(ft.isDone());
    }

    void ThreadTest() {
        Thread t = new Thread("我是多线程1") {
            @Override
            public void run() {
                System.out.println("你好你好我是" + getName());
            }
        };
    }


}
