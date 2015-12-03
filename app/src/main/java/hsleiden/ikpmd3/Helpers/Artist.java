package hsleiden.ikpmd3.Helpers;

public class Artist {
    private static Artist ourInstance = new Artist();

    public static Artist getInstance()
    {
        return ourInstance;
    }

    private Artist()
    {

    }
}
