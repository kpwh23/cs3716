

import java.util.Date;

public class Match {
private Team A;
private Team B;
private int scoreA;
private int scoreB;
private Date date;
private String location;

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Match(Team a, Team b, Date date, String location) {
	super();
	A = a;
	B = b;
	this.date = date;
	this.location = location;
}
public Match(Team a, Team b) { //temp constructor for schedule class
	super();
	A = a;
	B = b;
	
}
public Team getA() {
	return A;
}
public void setA(Team a) {
	A = a;
}
public Team getB() {
	return B;
}
public void setB(Team b) {
	B = b;
}
public int getScoreA() {
	return scoreA;
}
public void setScoreA(int scoreA) {
	this.scoreA = scoreA;
}
public int getScoreB() {
	return scoreB;
}
public void setScoreB(int scoreB) {
	this.scoreB = scoreB;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String publishResult(){
	return A.getTeamName()+ ":" +scoreA + B.getTeamName()+ ":" + scoreB ;
}
}
