package com.example.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "track")
public class Track {
	@Id
	@Column(name = "trackId")
	private String trackId;
	@Column(name="trackName")
	private String trackName;
	@Column(name="trackComments")
	private String trackComments;
	@Column(name="tackRating")
	private String trackRating;
	@Column(name="trackArtist")
	private String trackArtist;
	public Track(String trackId, String trackName, String trackComments, String trackRating, String trackArtist) {
		this.trackId = trackId;
		this.trackName = trackName;
		this.trackComments = trackComments;
		this.trackRating = trackRating;
		this.trackArtist = trackArtist;
	}
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getTrackComments() {
		return trackComments;
	}
	public void setTrackComments(String trackComments) {
		this.trackComments = trackComments;
	}
	public String getTrackRating() {
		return trackRating;
	}
	public void setTrackRating(String trackRating) {
		this.trackRating = trackRating;
	}
	public String getTrackArtist() {
		return trackArtist;
	}
	public void setTrackArtist(String trackArtist) {
		this.trackArtist = trackArtist;
	}
	
	
}
