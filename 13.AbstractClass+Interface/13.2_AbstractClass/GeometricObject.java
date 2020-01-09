import java.util.Date;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/08 14:15
 * @project JavaTutorial_2
 * @Description 程序清单 13-1 抽象类
 */

/**
 * 这个是所有几何图形的抽象类
 * 当你在实例化一个它的子类的时候，会先调用其父类，也就是该抽象类的构造方法
 * 从而实例化父类中的数据域
 * */
public abstract class GeometricObject {

    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /** 创建一个默认的 GEO 对象*/
    protected GeometricObject() {
        dateCreated = new Date();
    }

    /** 创建一个带有填充颜色的对象 */
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
    }

    /** 返回颜色*/
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "创建GeometricObject对象 {" + "color='" + color + '\'' + ", filled=" + filled + ", dateCreated=" + dateCreated + '}';
    }

    /** 设置抽象方法 getArea*/
    public abstract double getArea();

    /**
     * 设置获取周长的抽象方法 getPerimeter
     */
    public abstract double getPerimeter();
}
