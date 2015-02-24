package dayplan.desktop.ui.model;

import java.util.Date;

/**
 * @author vmuravlev
 */
public class Task {
    private String title;
    private TaskStatus status;
    private Date dueDate;

    public Task() {
    }

    public Task(String title) {
        this.title = title;
        this.status = TaskStatus.UNCOMPLETE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}