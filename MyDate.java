import java.util.GregorianCalendar;

public class MyDate {
    private int year;
    private int month; // 0 = January
    private int day;

    // Makes a date for today
    public MyDate() {
        setDate(System.currentTimeMillis());
    }

    // Makes a date from milliseconds
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // Makes a date from year, month, day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Gets the year
    public int getYear() {
        return year;
    }

    // Gets the month
    public int getMonth() {
        return month;
    }

    // Gets the day
    public int getDay() {
        return day;
    }

    // Changes the date using milliseconds
    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);

        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
