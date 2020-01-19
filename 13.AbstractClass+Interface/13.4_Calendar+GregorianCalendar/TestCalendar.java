import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/10 11:08
 * @project JavaTutorial_2
 * @Description
 */
public class TestCalendar {

    public static void main(String[] args) {
        // 构造一个当前的时间日历
        Calendar calendar = new GregorianCalendar();

        System.out.println("当前的时间：" + new Date());
        System.out.println("年： " + calendar.get(Calendar.YEAR));
        System.out.println("月： " + calendar.get(Calendar.MONTH));
        System.out.println("日： " + calendar.get(Calendar.DATE));
        System.out.println("Hour of the day： " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Hour： " + calendar.get(Calendar.HOUR));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("Second: " + calendar.get(Calendar.SECOND));
        System.out.println("Day of year: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Day of the month: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day of the week: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Week of the month:" + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Week of the year:" + calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Set the first day of the month: " + calendar.get(Calendar.DAY_OF_MONTH));
        // 对当前日历时间进行计算操作，比如当前DAY OF MONTH减去5天
        calendar.add(calendar.get(Calendar.DAY_OF_MONTH), -5);
        System.out.println("After the calculation: " + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH));

        // 构造一个特定的时间
        Calendar calendar1 = new GregorianCalendar(2020, 7, 30);
        String[] dayNameOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};
        System.out.println("Aug 30, 2020 is a " + dayNameOfWeek[calendar1.get(Calendar.DAY_OF_WEEK)]);
    }
}
