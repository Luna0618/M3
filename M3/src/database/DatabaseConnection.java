//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.ClubModel;
import Model.FriendsAddsModel;
import Model.OwnsTeamsModel;
import Model.PlayersJoinsModel;
import model.ClubModel;
import model.FriendsAddsModel;
import model.OwnsTeamsModel;
import model.PlayersJoinsModel;
import oracle.jdbc.driver.OracleDriver;

public class DatabaseConnection {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private Connection connection = null;

    public DatabaseConnection() {
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException var2) {
            System.out.println("[EXCEPTION] " + var2.getMessage());
        }

    }

    class PlayerIdNameClubName {
        String playerId1;
        String playerName1;
        String clubName1;

        public PlayerIdNameClubName(String pid,String pname,String cname) {
            this.playerId1 = pid;
            this.playerName1 = pname;
            this.clubName1 = cname;
        }
    }

    public void close() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException var2) {
            System.out.println("[EXCEPTION] " + var2.getMessage());
        }

    }

    public void deleteFriend(int friendID,int playerID) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("DELETE FROM Friend_Adds WHERE branch_id = ? " +
                    "AND playerID = ?");
            ps.setInt(1, friendID);
            ps.setInt(2, playerID);
            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println("[WARNING] Friend " + friendID + " does not exist!");
            }

            this.connection.commit();
            ps.close();
        } catch (SQLException var4) {
            System.out.println("[EXCEPTION] " + var4.getMessage());
            this.rollbackConnection();
        }

    }

    public void insertPlayer(PlayersJoinsModel model) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Players_Joins VALUES (?,?,?,?,?,?)");
            ps.setString(1, model.getPlayerID());
            ps.setString(2, model.getPlayer_name());
            ps.setInt(3, model.getRank());
            ps.setInt(4, model.getCurrency());
            ps.setDate(5,model.getJoin_date());
            ps.setString(6,model.getClubID());
            ps.executeUpdate();
            this.connection.commit();
            ps.close();
        } catch (SQLException var3) {
            System.out.println("[EXCEPTION] " + var3.getMessage());
            this.rollbackConnection();
        }

    }
    public void insertClub(ClubModel club) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Club VALUES (?,?,?,?)");
            ps.setString(1, club.getClub_ID());
            ps.setString(2, club.getClub_name());
            ps.setString(3, club.getLeader());
            ps.setInt(4, club.getNumber_of_members());

            ps.executeUpdate();
            this.connection.commit();
            ps.close();
        } catch (SQLException var3) {
            System.out.println("[EXCEPTION] " + var3.getMessage());
            this.rollbackConnection();
        }

    }

    public void insertFriends(FriendsAddsModel f){
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO FriendsAdds VALUES (?,?,?,?)");
            ps.setString(1, f.getFriendID());
            ps.setString(2, f.getNickname());
            ps.setString(3, f.getPlayerID());
            ps.setDate(4, f.getAdd_date());

            ps.executeUpdate();
            this.connection.commit();
            ps.close();
        } catch (SQLException var3) {
            System.out.println("[EXCEPTION] " + var3.getMessage());
            this.rollbackConnection();
        }

    }

    public ArrayList<String> getNameOFCLub() {
        ArrayList result = new ArrayList();

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT club_name FROM Club");
            while(rs.next()) {
                result.add(rs);
            }

            rs.close();
            stmt.close();
        } catch (SQLException var5) {
            System.out.println("[EXCEPTION] " + var5.getMessage());
        }
        return result;
    }

    public OwnsTeamsModel[] getTeamWithPID2007AndAPGreaterThan100() {
        ArrayList<OwnsTeamsModel> result = new ArrayList();

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OwnsTeams WHERE PlayerId = '2007'" +
                    "AND total_AP>100");

            while(rs.next()) {
                OwnsTeamsModel model = new OwnsTeamsModel(
                        rs.getString("PlayerId"),
                        rs.getString("team_name"),
                        rs.getInt("team_AP"),
                        rs.getString("t_leader"));
                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException var5) {
            System.out.println("[EXCEPTION] " + var5.getMessage());
        }

        return result.toArray(new OwnsTeamsModel[result.size()]);
    }

    public PlayerIdNameClubName[] getPlayerIdNameClubName() {
        ArrayList result = new ArrayList();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT PlayerID,player_name,club_name FROM Players_Joins JOIN Club " +
                    "ON Club.leader = Players_Joins.player_name");

            while (rs.next()) {
                PlayerIdNameClubName picn = new PlayerIdNameClubName(rs.getString("PlayerID"),
                        rs.getString("player_name"), rs.getString("club_name"));

                result.add(picn);
            }

            rs.close();
            stmt.close();
        } catch (SQLException var5) {
            System.out.println("[EXCEPTION] " + var5.getMessage());
        }
        return (PlayerIdNameClubName[])result.toArray(new PlayerIdNameClubName[result.size()]);
    }

    public void updateCurrency(String playerid) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Players_Joins SET currency = ? WHERE playerid = ?" +
                    " WHERE playerID = ?");
            ps.setInt(1, 500);
            ps.setString(2, playerid);
            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println("[WARNING] Player " + playerid + " does not exist!");
            }

            this.connection.commit();
            ps.close();
        } catch (SQLException var5) {
            System.out.println("[EXCEPTION] " + var5.getMessage());
            this.rollbackConnection();
        }

    }

    public boolean login(String username, String password) {
        try {
            if (this.connection != null) {
                this.connection.close();
            }

            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:stu", username, password);
            this.connection.setAutoCommit(false);
            System.out.println("\nConnected to Oracle!");
            return true;
        } catch (SQLException var4) {
            System.out.println("[EXCEPTION] " + var4.getMessage());
            return false;
        }
    }

    private void rollbackConnection() {
        try {
            this.connection.rollback();
        } catch (SQLException var2) {
            System.out.println("[EXCEPTION] " + var2.getMessage());
        }

    }

    public void databaseSetup() {
        this.dropClubIfExists();

        try {
            Statement stmt = this.connection.createStatement();
            stmt.executeUpdate("(CREATE TABLE Club (" +
                    "club_Id CHAR(3) NOT NULL," +
                    "club_name VARCHAR(50)," +
                    "leader VARCHAR(50) UNIQUE," +
                    "number_of_members INTEGER," +
                    "PRIMARY KEY (club_Id))");
            stmt.executeUpdate("CREATE TABLE Players_Joins(" +
                    "PlayerId CHAR(4) NOT NULL," +
                    "play_name VARCHAR(50) UNIQUE," +
                    "rank INTEGER," +
                    "currency INTEGER," +
                    "club_Id CHAR(10) NOT NULL," +
                    "join_date DATE," +
                    "PRIMARY KEY (PlayerId, club_Id)," +
                    "FOREIGN KEY (club_Id) REFERENCES Club" +
                    "ON UPDATE CASCADE);");
            stmt.executeUpdate("CREATE TABLE Friend_Adds" +
                    "friendID CHAR(4) NOT NULL," +
                    "nickname VARCHAR(50) UNIQUE," +
                    "PlayerId CHAR(4) NOT NULL," +
                    "add_date DATE," +
                    "PRIMARY KEY (friendID, PlayerId)," +
                    "FOREIGN KEY (PlayerId) REFERENCES Players_Joins ON DELETE CASCADE);");
            stmt.executeUpdate("CREATE TABLE Owns_Teams(\n" +
                    "        PlayerId CHAR(4) NOT NULL,\n" +
                    "        team_name VARCHAR(10),\n" +
                    "        team_AP INTEGER,\n" +
                    "        t_leader VARCHAR(50),\n" +
                    "        PRIMARY KEY (PlayerId, team_name),\n" +
                    "        FOREIGN KEY (PlayerId) REFERENCES Players_Joins,\n" +
                    "        FOREIGN KEY (team_name) REFERENCES Forms_Team);");
            stmt.executeUpdate("CREATE TABLE Fights(" +
                    "        PlayerId CHAR(4) NOT NULL," +
                    "        team_name VARCHAR(50)," +
                    "        enemies_name VARCHAR(50)," +
                    "        result VARCHAR(10)," +
                    "        PRIMARY KEY (team_name, PlayerId, enemies_name)," +
                    "        FOREIGN KEY (team_name) REFERENCES Forms_Team," +
                    "        FOREIGN KEY (enemies_name) REFERENCES Enemies)" +
                    "        FOREIGN KEY (PlayerId) REFERENCES Players_Joins)");

            stmt.executeUpdate("CREATE TABLE Enemies (\n" +
                    "        enemies_name VARCHAR(50),\n" +
                    "        enemy_AP INTEGER,\n" +
                    "        PRIMARY KEY(enemies_name));");
            stmt.close();
        } catch (SQLException var3) {
            System.out.println("[EXCEPTION] " + var3.getMessage());
        }

        ClubModel club1 = new ClubModel("101","Yakuza","Luna",100);
        this.insertClub(club1);
        ClubModel club2 = new ClubModel("102","Bros","Jennie",38);
        this.insertClub(club2);
        ClubModel club3 = new ClubModel("103","Gangster","Blade",77);
        this.insertClub(club3);
        ClubModel club4 = new ClubModel("104","the_best_club","Star",200);
        this.insertClub(club4);
        ClubModel club5 = new ClubModel("105","fake_club","Fake",5);
        this.insertClub(club5);
        FriendsAddsModel fam1 = new FriendsAddsModel("1001","Mommy", "2007",'2020-01-09');
        this.insertFriends(fam1);
        FriendsAddsModel fam2 = new FriendsAddsModel("1002","Daddy","2007", '2020-09-30');
        this.insertFriends(fam2);
        FriendsAddsModel fam3 = new FriendsAddsModel("1003","Bro", "2007",2020-10-21);
        this.insertFriends(fam3);
        FriendsAddsModel fam4 = new FriendsAddsModel("1004","Friend", "2007",2020-10-22);
        this.insertFriends(fam4);
        FriendsAddsModel fam5 = new FriendsAddsModel("1005","Star", "2007",2020-10-23);
        this.insertFriends(fam5);
        PlayersJoinsModel pjm1 = new PlayersJoinsModel("2007","Luna",50,10000,2020-05-23,"101");
        this.insertPlayer(pjm1);
        PlayersJoinsModel pjm2 = new PlayersJoinsModel("2008","Tom",48,9000,2020-07-9,"101");
        this.insertPlayer(pjm2);
        PlayersJoinsModel pjm3 = new PlayersJoinsModel("2009","John",35,20000,2020-10-21,"101");
        this.insertPlayer(pjm3);
        PlayersJoinsModel pjm4 = new PlayersJoinsModel("2010","Happy",60,300,2020-05-23,"101");
        this.insertPlayer(pjm4);
        PlayersJoinsModel pjm5 = new PlayersJoinsModel("2011","Star_2011",30,5000,'2020-09-11',"101");
        this.insertPlayer(pjm5);
    }

    private void dropClubIfExists() {
        try{
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if (rs.getString(1).toLowerCase().equals("branch")) {
                    stmt.execute("DROP TABLE Club");
                    break;
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException var3) {
            System.out.println("[EXCEPTION] " + var3.getMessage());
        }

    }

    private void dropPlayersJoinsIfExists() {
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if (rs.getString(1).toLowerCase().equals("Players_Joins")) {
                    stmt.execute("DROP TABLE Players_Joins");
                    break;
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException var3) {
            System.out.println("[EXCEPTION] " + var3.getMessage());
        }

    }
}