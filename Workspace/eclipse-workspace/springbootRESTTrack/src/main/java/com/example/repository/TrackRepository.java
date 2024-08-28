package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Track;

public interface TrackRepository extends JpaRepository<Track, String> {
	List<Track> findByTrackId(String trackId);
	List<Track> findByTrackArtist(String trackName);
}
