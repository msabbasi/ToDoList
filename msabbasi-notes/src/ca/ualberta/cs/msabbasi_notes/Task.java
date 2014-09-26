package ca.ualberta.cs.msabbasi_notes;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date taskDate;
	private String taskBody;
	private boolean checked;
	private boolean selected;
	
	public Task() {
		super();
		this.checked = false;
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
		if (this.checked == true){
			return "\u2713 " + taskBody;
		}
		else {
			return taskBody;
		}
	}

	public void setTaskBody(String taskBody) {
		this.taskBody = taskBody;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		  this.selected = selected;
	}
	
	@Override
	public String toString() {
		return getTaskBody();
	}

}
