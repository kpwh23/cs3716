public class Coach {
private String name;
private String phone;
private String email;
private Team team;
public String getName() {
	return name;
}
public Coach(String name, String phone, String email, Team team) {
	super();
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.team = team;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}
}
