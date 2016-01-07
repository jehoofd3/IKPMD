package hsleiden.ikpmd3.model;

import hsleiden.ikpmd3.helpers.DatabaseInfo;

/**
 * Created by jeroen_van_ottelen on 07-01-16.
 */
public class Runs
{
    private int account_id;
    private int level;
    private int rocket_kills;

    public Runs(int level, int rocket_kills, int account_id)
    {
        this.level = level;
        this.rocket_kills = rocket_kills;
        this.account_id = account_id;
    }

    public int getAccount_id()
    {
        return account_id;
    }

    public void setAccount_id(int account_id)
    {
        this.account_id = account_id;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getShots()
    {
        return rocket_kills;
    }

    public void setShots(int rocket_kills)
    {
        this.rocket_kills = rocket_kills;
    }
}