package model;

public class FormsTeamsModel {
 private final String team_name;
 private final int capability;

 public FormsTeamsModel(String team_name, int capability) {
  this.team_name = team_name;
  this.capability = capability;

 }

 public int getCapability() {
  return capability;
 }

 public String getTeam_name() {
  return team_name;
 }
}
