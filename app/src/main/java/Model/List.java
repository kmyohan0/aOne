package Model;
import java.util.Calendar;
import java.util.Date;

public class List {

    private Date startTime, endTime, date;
    //private Category  category;
    private String ActivityName, description;

    public List() {
        startTime = null;
        endTime = null;
        date = null;
        ActivityName = "Test is working!";
        description = "Test description";
    }

    public List(Date date, String ActivityName) {
        this.date = date;
        this.ActivityName = ActivityName;
    }

    public List(Date startTime, Date endTime, String ActivityName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.ActivityName = ActivityName;
    }

    public List(Date startTime, Date endTime, Date date, String ActivityName, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.ActivityName = ActivityName;
        this.description = description;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public void setActivityName(String activityName) {
        ActivityName = activityName;

    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
