package com.flightmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="passenger_table")
public class Passenger {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerId_sequence_generator")
@SequenceGenerator(name="passengerId_sequence_generator", sequenceName = "passenger_sequence_name", initialValue=1, allocationSize=1)
@NotNull(message="passenger Id should not be empty")
@Column(nullable=false)
private long passengerId;

@NotEmpty(message="passenger name should not be empty")
@Size(min=3,max=30,message="user name must not be in 3 to 30 charachters")
private String passengerName;

@NotNull(message="gender should not be empty")
private char gender;

@NotNull(message="passenger age should not be empty")
@Min(value=1, message="age must be entered and min value is 1")
@Max(value=120, message="age entered must be wrong")
private int passengerAge;

@Min(value=10000000,message="UIN is compulsory and Passenger UIN must be a 8 digit number")
@Max(value=99999999,message="Passenger UIN must be a 8 digit number")
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
