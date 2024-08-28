package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Track;
import com.example.repository.TrackRepository;

@Service
public abstract class TrackServiceImpl implements TrackService {
	private final TrackRepository trackRepository;
	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository) {
		this.trackRepository=trackRepository;
	}
	@Override
	public Track saveTrack(Track track) {
		return trackRepository.save(track);
	}
	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}
	@Override
	public List<Track> getByTrackId(String trackId) {
		return trackRepository.findByTrackId(trackId);
	}
	

}
