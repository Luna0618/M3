package model;

import java.sql.Date;

public class FriendsAddsModel {
    private final String playerID;
    private final String friendID;
    private final String nickname;
    private final Date add_date;

    public FriendsAddsModel(String playerID, String friendID, String nickname, Date add_date) {
        this.add_date = add_date;
        this.friendID = friendID;
        this.playerID = playerID;
        this.nickname = nickname;
    }

    public String getPlayerID() {
        return playerID;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public String getFriendID() {
        return friendID;
    }

    public String getNickname() {
        return nickname;
    }
}
