package model;


public class ClubModel {
    private final String club_ID;
    private final String club_name;
    private final String leader;
    private final int number_of_members;

    public ClubModel(String id, String name, String leader, int number_of_members){
        this.club_ID = id;
        this.club_name = name;
        this.leader = leader;
        this.number_of_members = number_of_members;
    }

    public String getClub_ID() {
        return club_ID;
    }

    public String getClub_name() {
        return club_name;
    }

    public String getLeader() {
        return leader;
    }

    public int getNumber_of_members() {
        return number_of_members;
    }
}
