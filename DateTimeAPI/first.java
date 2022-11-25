import java.time.*;
/**
 * first
 */
public class first {

    public static void main(String[] args) {
        //deprecated
    //    java.util.Date utilDate = new java.util.Date();
    //    System.out.println(utilDate);

    //    long hour = utilDate.getHours();
    //    System.out.println(hour);

    //    long time = utilDate.getTime();
    //    System.out.println(time);

    //    java.sql.Date sqlDate = new java.sql.Date(hour);
    //    System.out.println(sqlDate);

       LocalDate date = LocalDate.now();
       LocalTime time = LocalTime.now();
       LocalDateTime ldt = LocalDateTime.now();
       System.out.println(date);
       System.out.println(time);
       System.out.println(ldt);

       LocalDate dt = LocalDate.of(1984, 2, 18);
       System.out.println(dt);
    }
}