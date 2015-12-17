package hsleiden.ikpmd3.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class creates and handles everything in the database.
 * It's singleton so that you can only have one instance of this class.
 * @author Richard Jongenburger
 */

public class DatabaseReceiver extends SQLiteOpenHelper {

	public static SQLiteDatabase database;
	private static DatabaseReceiver databaseReceiver;
	public static final String DATABASE_NAME = "database.db";
	public static final int DATABASE_VERSION = 1;
	private Context context;

	public DatabaseReceiver(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	public static synchronized DatabaseReceiver getDatabaseReceiver(Context context)
	{
		if(databaseReceiver == null)
		{
			databaseReceiver = new DatabaseReceiver(context);
			database = databaseReceiver.getWritableDatabase();
		}
		return databaseReceiver;
	}

	/**
	 * Create all the tables from the database.
	 * @param db The database in which the tables should be created.
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + DatabaseInfo.Account.TABLE_NAME + " (" +
				DatabaseInfo.Account.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				DatabaseInfo.Account.COLUMN_NAME_NAME + " TEXT );"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.Timer.TABLE_NAME + " (" +
						DatabaseInfo.Timer.COLUMN_NAME_LEVEL + " INTEGER, " +
						DatabaseInfo.Timer.COLUMN_NAME_TIME+ " TEXT ," +
						DatabaseInfo.Timer.COLUMN_NAME_ACCOUNTID + " INTEGER ," +
						"FOREIGN KEY(" + DatabaseInfo.Timer.COLUMN_NAME_ACCOUNTID +") REFERENCES " + DatabaseInfo.Account.TABLE_NAME + " (" + DatabaseInfo.Account.COLUMN_NAME_ID + ") );"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.MapImages.TABLE_NAME + " (" +
						DatabaseInfo.MapImages.COLUMN_NAME_IMAGE_NAME + " TEXT , " +
						DatabaseInfo.MapImages.COLUMN_NAME_IMAGE + " BLOB );"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.MenuImages.TABLE_NAME + " (" +
						DatabaseInfo.MenuImages.COLUMN_NAME_IMAGE_NAME + " TEXT , " +
						DatabaseInfo.MenuImages.COLUMN_NAME_IMAGE + " BLOB );"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.PlayerImages.TABLE_NAME + " (" +
						DatabaseInfo.PlayerImages.COLUMN_NAME_IMAGE_NAME + " TEXT , " +
						DatabaseInfo.PlayerImages.COLUMN_NAME_IMAGE + " BLOB );"
		);

	}

	/**
	 * Used to recreate the database when there is a new version.
	 * @param db The database to be recreated.
	 * @param oldVersion The old version of the database.
	 * @param newVersion The new version the database.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.Account.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.Timer.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.MapImages.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.MenuImages.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.PlayerImages.TABLE_NAME);

		onCreate(db);
	}

	/**
	 * Insert content values into a table from the database.
	 * @param table The name of the database
	 * @param nullColumnHack optional; may be null. SQL doesn't allow inserting a completely empty row without naming at least one column name. (Developer.android.com)
	 * @param values The values that should be inserted.
	 */
	public void insert(String table, String nullColumnHack, ContentValues values){
		database.insert(table, nullColumnHack, values);
	}

	/**
	 * Do a query in the database.
	 * @param table The table to be queried.
	 * @param columns The columns the data should be inserted.
	 * @param selection Filter to declare which row is returned. (WHERE)
	 * @param selectArgs You may include ?'s in selection, which will be replaced by the values from selectionArgs.
	 * @param groupBy Filter to declare how to group rows.
	 * @param having Having of the query.
	 * @param orderBy How to order the rows.
	 * @return A cursor object which is positioned before the first entry.
	 */
	public Cursor query(String table, String[] columns, String selection, String[] selectArgs, String groupBy, String having, String orderBy){
		System.out.println("QUERY: " + selection);
		return database.query(table, columns, selection, selectArgs, groupBy, having, orderBy);
	}


}
