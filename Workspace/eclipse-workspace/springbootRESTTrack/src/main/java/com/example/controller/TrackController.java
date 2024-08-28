package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Track;
import com.example.service.TrackService;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
	private TrackService trackService;
	
	@Autowired
	public TrackController(TrackService trackService) {
		this.trackService=trackService;
	}
	
	@PostMapping("/track")
	public ResponseEntity<?> saveTrack(@RequestBody Track track) {
		return new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.CREATED);
	}
	
	@GetMapping("/tracks")
	public ResponseEntity<?> getAllTracks() {
		return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.FOUND);
	}
	
	@GetMapping("/tracks/{trackId}")
	public ResponseEntity<?> getTrackById(@PathVariable String trackId) {
		return new ResponseEntity<>(trackService.getByTrackId(trackId),HttpStatus.FOUND);
	}
}
