package hsleiden.ikpmd3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hsleiden.ikpmd3.helpers.DatabaseInfo;

/**
 * Created by jeroen_van_ottelen on 05-01-16.
 */
public class Account
{

    private String id;
    private String name;
    private List<Runs> runs;

    public Account(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNewRun(Runs run)
    {
        runs.add(run);
    }

    public void setAllRuns(List<Runs> runsList)
    {
        this.runs = runsList;
    }

    public List<Runs> getAllRuns()
    {
        return this.runs;
    }

    public String getBestTime()
    {
        ArrayList<String> bestTime = new ArrayList<>();

        for(Runs r: runs)
        {
            bestTime.add(Integer.toString(r.getShots()));
        }
        return Collections.max(bestTime);
    }
}

