package DataStructures;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TimeBlock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372221617279470664L;
	private SimpleStringProperty timeBlockName = new SimpleStringProperty();
	private LocalDate currentDate;
	private DayOfWeek day;
	private int hour;
	private int minute;
	private String timeInString;
	private String filePath;
	private int videoPlace = 0;

	private ObservableList<FileBlock> fileList = FXCollections.observableArrayList();

	public ObservableList<FileBlock> getFileList() {
		return fileList;
	}

	public void setFileList(ObservableList<FileBlock> fileList) {
		this.fileList = fileList;
	}

	private void initCurrentTime(boolean currentTime) {
		timeBlockName.set("Current Time Block");
		LocalDate today = LocalDate.now();
		day = today.getDayOfWeek();
		hour = LocalDateTime.now().getHour();
		minute = LocalDateTime.now().getMinute();
		timeInString = hour + ":" + minute;
		filePath = "";
	}

	public TimeBlock(boolean isCurrentTime) {
		initCurrentTime(isCurrentTime);
	}

	public TimeBlock(DayOfWeek day, int hour, int minute) {
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		timeInString = hour + ":" + minute;
		timeBlockName.set(day.toString() + " | " + timeInString);
		filePath = "";
	}

	public String getTimeBlockName() {
		return timeBlockName.get();
	}

	public void setTimeBlockName(String timeBlockName) {
		this.timeBlockName.set(timeBlockName);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getTimeInString() {
		return timeInString;
	}

	public void setTimeInString(String timeInString) {
		this.timeInString = timeInString;
	}

	public int getVideoPlace() {
		return videoPlace;
	}

	public void setVideoPlace(int videoPlace) {
		if (videoPlace >= this.fileList.size() || videoPlace < 0) {
			this.videoPlace = 0;
		} else {
			this.videoPlace = videoPlace;
		}
	}

}
