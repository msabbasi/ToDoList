package ca.ualberta.cs.msabbasi_notes;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date taskDate;
	private String taskBody;
	
	public Task() {
		super();
	}

	public Task(Date taskDate, String taskBody) {
		this.taskDate = taskDate;
		this.taskBody = taskBody;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskBody() {
		return taskBody;
	}

	public void setTaskBody(String taskBody) {
		this.taskBody = taskBody;
	}

	@Override
	public String toString() {
		return taskBody;
	}
}
