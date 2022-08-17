package tour;

import java.util.ArrayList;
import java.util.List;

public class ExampleRun {
    public static void main(String[] args) {
        List<Tour> allTours = new ArrayList<>();

        SingleTour floatingMarket = new SingleTour("Floating Market", 1000, 10);
        SingleTour chinaTown = new SingleTour("Chinatown", 500, 5);
        SingleTour watPrakaew = new SingleTour("Wat Prakaew", 800, 10);
        SingleTour watPho = new SingleTour("Wat Pho", 700, 8);
        SingleTour jatujakMarket = new SingleTour("Jatujak Market", 500, 10);

        PackageTour templePackage = new PackageTour("Temple Package");
        templePackage.addTour(watPrakaew);
        templePackage.addTour(watPho);

        PackageTour rattanakosinPackage = new PackageTour("Rattanakosin Package");
        rattanakosinPackage.addTour(chinaTown);
        rattanakosinPackage.addTour(templePackage);

        allTours.add(floatingMarket);
        allTours.add(chinaTown);
        allTours.add(watPrakaew);
        allTours.add(watPho);
        allTours.add(jatujakMarket);

        allTours.add(templePackage);
        allTours.add(rattanakosinPackage);

        // ประเด็นที่สำคัญของ composite pattern มี 2 ประเด็น โดยประเด็นที่ (2) คือ
        // เราประมวลผลส่วนเดี่ยว (SingleTour) กับส่วนประกอบ (PackageTour หรือ composite)
        // ด้วย interface เดียวกัน
        for (Tour tour : allTours) {
            System.out.println(tour.getName());
            System.out.println("  price: " + tour.getPrice());
            System.out.println("  seats: " + tour.getAvailableSeats());
        }
    }
}
