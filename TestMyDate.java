public class TestMyDate {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(); 
        MyDate date2 = new MyDate(34355555133101L);

        System.out.println("date1:");
        System.out.println("Year: " + date1.getYear());
        System.out.println("Month: " + date1.getMonth());
        System.out.println("Day: " + date1.getDay());

        System.out.println();

        System.out.println("date2:");
        System.out.println("Year: " + date2.getYear());
        System.out.println("Month: " + date2.getMonth());
        System.out.println("Day: " + date2.getDay());
    }
}