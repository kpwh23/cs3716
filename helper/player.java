package volleyballTournament;

public class player {
private String name;
private String phone;
private String email;
private String stats;
public player(String name, String phone, String email, String stats) {
	super();
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.stats = stats;
}
public String getName() {
	return name;
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
public String getStats() {
	return stats;
}
public void setStats(String stats) {
	this.stats = stats;
}
}