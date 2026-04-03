package com.gianmarco.chordextractor.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, updatable = false)
	private String uuid;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private short duration;
	
	@Column(nullable = false)
	private short bpm;
	
	@Column(nullable = false)
	private String url;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private User generatedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public User getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(User generatedBy) {
		this.generatedBy = generatedBy;
	}

	public Song() {}
	
	public Song(String title, short duration, short bpm, String url, User generatedBy) {
		super();
		this.title = title;
		this.duration = duration;
		this.bpm = bpm;
		this.url = url;
		this.generatedBy = generatedBy;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", uuid=" + uuid + ", title=" + title + ", duration=" + duration + ", bpm=" + bpm
				+ ", url=" + url + ", generatedBy=" + generatedBy + "]";
	}

}
