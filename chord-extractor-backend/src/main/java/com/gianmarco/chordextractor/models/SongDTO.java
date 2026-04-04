package com.gianmarco.chordextractor.models;

public class SongDTO {

	private String uuid;
	private String title;
	private short duration;
	private short bpm;
	private String url;
	private String generatedBy;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public short getDuration() {
		return duration;
	}
	public void setDuration(short duration) {
		this.duration = duration;
	}
	public short getBpm() {
		return bpm;
	}
	public void setBpm(short bpm) {
		this.bpm = bpm;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGeneratedBy() {
		return generatedBy;
	}
	public void setGeneratedBy(String generatedByUuid) {
		this.generatedBy = generatedByUuid;
	}
	
	public SongDTO() {}
	
	public SongDTO(String uuid, String title, short duration, short bpm, String url, String generateBy) {
		super();
		this.uuid = uuid;
		this.title = title;
		this.duration = duration;
		this.bpm = bpm;
		this.url = url;
		this.generatedBy = generateBy;
	}
 
}
