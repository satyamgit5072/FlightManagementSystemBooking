package com.flightmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="passenger_table")
public class Passenger {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerId_sequence_generator")
@SequenceGenerator(name="passengerId_sequence_generator", sequenceName = "passenger_sequence_name", initialValue=1, allocationSize=1)
@NotNull(message="passenger Id should not be empty")
@Column(nullable=false)
private long passengerId;

@NotNull(message="passenger name should not be empty")
private String passengerName;

@NotNull(message="gender should not be empty")
private char gender;

@NotNull(message="passenger age should not be empty")
private int passengerAge;

@NotNull(message="passenger UIN should not be empty")
private long passengerUIN;

public Passenger() {
	super();
}

public Passenger(String passengerName, char gender, int passengerAge, long passengerUIN) {
	super();
	this.passengerName = passengerName;
	this.gender = gender;
	this.passengerAge = passengerAge;
	this.passengerUIN = passengerUIN;
}

public long getPassengerId() {
	return passengerId;
}

public void setPassengerId(long passengerId) {
	this.passengerId = passengerId;
}

public String getPassengerName() {
	return passengerName;
}

public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}

public char getGender() {
	return gender;
}

public void setGender(char gender) {
	this.gender = gender;
}

public int getPassengerAge() {
	return passengerAge;
}

public void setPassengerAge(int passengerAge) {
	this.passengerAge = passengerAge;
}

public long getPassengerUIN() {
	return passengerUIN;
}

public void setPassengerUIN(long passengerUIN) {
	this.passengerUIN = passengerUIN;
}

}
