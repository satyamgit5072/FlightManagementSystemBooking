package com.flightmanagement.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Schedule {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = {CascadeType.MERGE})
    private Airport sourceAirport;

    @OneToOne(cascade = {CascadeType.MERGE})
    private Airport destinationAirport;

//    @NotNull(message="Date should be in dd/mm/yyyy")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
//    private Date arrivalTime;

//    @NotNull(message= "Date should be in dd/mm/yyyy")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
//    private Date departureTime;
    
    private LocalDateTime departureTime;
    
	private LocalDateTime arrivalTime;

    public Schedule() {
    }

    public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

}
