package tour;

import java.util.ArrayList;
import java.util.List;

public class PackageTour implements Tour {
    private String packageName;
    private List<Tour> tours;

    public PackageTour(String packageName) {
        this.packageName = packageName;
        this.tours = new ArrayList<>();
    }

    public void addTour(Tour tour) {
        tours.add(tour);
    }

    // ประเด็นที่สำคัญของ composite pattern มี 2 ประเด็น โดยประเด็นที่ (1) คือ
    // ส่วนประกอบ (PackageTour หรือ composite) จะเก็บเป็น list/set ของส่วน supertype (Tour)
    // และนำแต่ละส่วนมาประมวลผลรวมกัน โดยใช้ for-loop อย่างใดอย่างหนึ่ง
    // เช่น ในตัวอย่าง tour นี้ ทำต่างกัน 3 อย่าง คือ
    //   (1.1) นำราคาของแต่ละ tour มารวมกัน แล้วนำผลรวมมาคูณ 90%
    //   (1.2) นำ availableSeats มาหาค่า min เพื่อเป็น availableSeats ของส่วนประกอบ
    //   (1.3) นำ name มา concatenate เพื่อสร้างชื่อที่มีข้อมูลทัวร์ทั้งหมด
    @Override
    public double getPrice() {
        double total = 0;
        for (Tour tour : tours)
            total += tour.getPrice();
        return total*0.9;
    }

    @Override
    public int getAvailableSeats() {
        int min = Integer.MAX_VALUE;
        for (Tour tour : tours) {
            if (min > tour.getAvailableSeats())
                min = tour.getAvailableSeats();
        }
        return min;
    }

    @Override
    public String getName() {
        String name = packageName + "[";
        for (int i = 0; i < tours.size() - 1; i++)
            name += tours.get(i).getName() + ", ";
        name += tours.get(tours.size()-1).getName();
        return name + "]";
    }
}
