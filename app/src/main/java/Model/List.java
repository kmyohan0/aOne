package Model;
import java.util.Calendar;
import java.util.Date;

public class List {
    //private Category  category;
    private String ActivityName, description, Date;

    public List() {
        Date = null;
        ActivityName = "Test is working!";
        description = "Test description";
    }

    public List(String Date, String ActivityName) {
        this.Date = Date;
        this.ActivityName = ActivityName;
    }

    public List(String ActivityName) {
        this.ActivityName = ActivityName;
    }

    public List(String Date, String ActivityName, String description) {
        this.Date = Date;
        this.ActivityName = ActivityName;
        this.description = description;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public void setActivityName(String activityName) {
        ActivityName = activityName;

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
