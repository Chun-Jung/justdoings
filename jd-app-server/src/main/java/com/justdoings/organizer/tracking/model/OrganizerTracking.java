package com.justdoings.organizer.tracking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.justdoings.organizer.model.Organizer;

@Entity
public class OrganizerTracking {

	private Organizer org;
	
	private Integer memSeq;
	
}
