package com.example.service;

import java.util.List;

import com.example.domain.Track;

public interface TrackService {
	Track saveTrack(Track track);
	List<Track> getAllTracks();
	List<Track> getByTrackId(String trackId);
}
