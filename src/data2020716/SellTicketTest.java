package data2020716;

import java.util.ArrayList;

public class SellTicketTest {
    public static void main(String[] args) {
        StationManager sm = new StationManager(3);
        sm.startSell();
    }
}

class StationManager {
    static final Object lock = new Object();
    static int ticketsNums = 100;
    ArrayList<Thread> stations = new ArrayList<>();

    StationManager(int nums) {
        for (int i = 0; i < nums; i++) {
            buildNewSellStation();
        }
    }

    public void buildNewSellStation() {
        stations.add(new Thread(new SellTicket()));
    }

    public void startSell() {
        for (var s : stations) {
            s.start();
        }
    }

    private static class SellTicket implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (ticketsNums > 0) {
                        System.out.println("卖出了第" + ticketsNums + "张票");
                        ticketsNums--;
                    } else {
                        break;
                    }
                }
            }
        }
    }

}


