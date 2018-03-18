package main.homework.vo;

import javax.persistence.Embeddable;

@Embeddable
public class StudentCard {
	private String seriesId;
	private String numberId;
	public StudentCard(String seriesId, String numId) {
		super();
		this.seriesId = seriesId;
		this.numberId = numId;
	}
	public StudentCard() {
		super();
	}
	@Override
	public String toString() {
		return "StudentCard [seriesId=" + seriesId + ", numId=" + numberId + "]";
	}
	public String getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}
	public String getNumId() {
		return numberId;
	}
	public void setNumId(String numId) {
		this.numberId = numId;
	}
	
}
