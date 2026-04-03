package com.gianmarco.chordextractor.models;

import java.util.List;

public class UserDTO {

	private String uuid;
	private String username;
	private String email;
	private List<Song> songs;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	public UserDTO() {}
	
	public UserDTO(String uuid, String username, String email, List<Song> songs) {
		super();
		this.uuid = uuid;
		this.username = username;
		this.email = email;
		this.songs = songs;
	}
 
}
