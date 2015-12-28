package hsleiden.ikpmd3.helpers;

import android.provider.BaseColumns;

/**
 * This class is used to hold all the table names and column names.
 * @author Richard Jongenburger
 */

public final class DatabaseInfo {
	// To prevent someone from accidentally instantiating the contract class,
	// give it an empty constructor.
	public DatabaseInfo() {}

	public static abstract class Account implements BaseColumns {
		public static final String TABLE_NAME = "account";
		public static final String COLUMN_NAME_ID = "id";
		public static final String COLUMN_NAME_NAME = "name";
	}

	public static abstract class Timer implements BaseColumns {
		public static final String TABLE_NAME = "timer";
		public static final String COLUMN_NAME_LEVEL = "level";
		public static final String COLUMN_NAME_TIME = "time";
		public static final String COLUMN_NAME_ACCOUNTID = "account_id";

	}
}
