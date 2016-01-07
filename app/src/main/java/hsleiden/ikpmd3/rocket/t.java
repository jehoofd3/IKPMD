package hsleiden.ikpmd3.rocket;

/**
 * Created by richard on 6-1-16.
 */
public class t {
	private static t ourInstance = new t();

	public static t getInstance() {
		return ourInstance;
	}

	private t() {
	}
}
