package hsleiden.ikpmd3.Helpers;

public class Artist extends Th {
    private static Artist ourInstance = new Artist();

    public static Artist getInstance()
    {
        return ourInstance;
    }

    private Artist()
    {

    }
}
