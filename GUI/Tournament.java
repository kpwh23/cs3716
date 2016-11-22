

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Tournament implements Serializable{
private TournamentType type;
private String location, name;
private Date deadline;
private ArrayList<Team> teams;

public Tournament(String name, String location, Date deadline) {
	super();
	this.name = name;
	this.location = location;
	this.deadline = deadline;
	this.teams = new ArrayList<Team>();
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public TournamentType getType() {
	return type;
}
public void setType(TournamentType type) {
	this.type = type;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Date getDeadline() {
	return deadline;
}
public void setDeadline(Date deadline) {
	this.deadline = deadline;
}
public ArrayList<Team> getTeams() {
	return teams;
}
public void setTeams(ArrayList<Team> teams) {
	this.teams = teams;
} 
//Change publish for whatever the system needs
public void publishDeadline(){
	System.out.println("deadline" + deadline);
}

public void register(Team x){
	this.teams.add(x);
}
}