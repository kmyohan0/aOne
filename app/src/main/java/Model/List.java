package Model;
import java.util.Calendar;
import java.util.Date;

public class List {

    private Date currentDate, dueDate;
    //private Category  category;
    private String ActivityName;

    public List() {
        currentDate = null;
        dueDate = null;
        ActivityName = "Test is working!";
    }

    public List(Date CurrentDate, String ActivityName) {
        this.ActivityName = ActivityName;
    }

    public List(Date CurrentDate, Date dueDate, String ActivityName) {
        this.currentDate = CurrentDate;
        this.dueDate = dueDate;
        this.ActivityName = ActivityName;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public void setActivityName(String activityName) {
        ActivityName = activityName;
    }
}
