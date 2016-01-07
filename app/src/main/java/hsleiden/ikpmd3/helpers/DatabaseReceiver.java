package hsleiden.ikpmd3.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

import hsleiden.ikpmd3.model.Account;
import hsleiden.ikpmd3.model.Runs;

/**
 * This class creates and handles everything in the database.
 * It's singleton so that you can only have one instance of this class.
 * @author Richard Jongenburger
 */

public class DatabaseReceiver extends SQLiteOpenHelper {

	public static SQLiteDatabase database;
	private static DatabaseReceiver databaseReceiver;
	public static final String DATABASE_NAME = "database.db";
	public static final int DATABASE_VERSION = 3;
	private Context context;

	private DatabaseReceiver(Context context)
	{
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

		db.execSQL("CREATE TABLE " + DatabaseInfo.Runs.TABLE_NAME + " (" +
						DatabaseInfo.Runs.COLUMN_NAME_LEVEL + " INTEGER, " +
						DatabaseInfo.Runs.COLUMN_NAME_ROCKETKILLS + " INTEGER ," +
						DatabaseInfo.Runs.COLUMN_NAME_ACCOUNTID + " INTEGER ," +
						"FOREIGN KEY(" + DatabaseInfo.Runs.COLUMN_NAME_ACCOUNTID + ") REFERENCES " + DatabaseInfo.Account.TABLE_NAME + " (" + DatabaseInfo.Account.COLUMN_NAME_ID + ") );"
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
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.Runs.TABLE_NAME);
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
	 * @param table The table name to compile the query against.
	 * @param columns A list of which columns to return. Passing null will return all columns, which is discouraged to prevent reading data from storage that isn't going to be used.
	 * @param selection A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given table.
	 * @param selectArgs You may include ?s in selection, which will be replaced by the values from selectionArgs, in order that they appear in the selection. The values will be bound as Strings.
	 * @param groupBy A filter declaring how to group rows, formatted as an SQL GROUP BY clause (excluding the GROUP BY itself). Passing null will cause the rows to not be grouped.
	 * @param having A filter declare which row groups to include in the cursor, if row grouping is being used,
	 *               formatted as an SQL HAVING clause (excluding the HAVING itself). Passing null will cause all row groups to be included, and is required when row grouping is not being used.
	 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered.
	 * @return A cursor object which is positioned before the first entry.
	 */
	public Cursor query(String table, String[] columns, String selection, String[] selectArgs, String groupBy, String having, String orderBy){
		return database.query(table, columns, selection, selectArgs, groupBy, having, orderBy);
	}

	public ArrayList<Account> getAllAccounts()
	{
		ArrayList<Account> accountModels = new ArrayList<>();

		Cursor c = query("account", null, null, null, null, null, null);

		while(c.moveToNext())
		{
			Account account = new Account(c.getString(0), c.getString(1));

			accountModels.add(account);
		}

		return accountModels;
	}

	public void insertAccount(String name)
	{
		ContentValues cv = new ContentValues();
		cv.put(DatabaseInfo.Account.COLUMN_NAME_NAME, name);

		insert("account", null, cv);
	}

	public void deleteAccount(Account account)
	{
		String id = account.getId();
		database.delete(DatabaseInfo.Account.TABLE_NAME, DatabaseInfo.Account.COLUMN_NAME_ID + "='" + id + "'", null);
	}

	public ArrayList<Runs> getAllRuns(Account account)
	{
		ArrayList<Runs> runsModels = new ArrayList<>();

		Cursor c = query("runs", null, DatabaseInfo.Runs.COLUMN_NAME_ACCOUNTID + "='" + account.getId() + "'", null, null, null, null);

		while(c.moveToNext())
		{
			Runs runs = new Runs(c.getInt(0), c.getInt(1), c.getInt(2));

			runsModels.add(runs);
		}

		return runsModels;
	}

	public void insertRun(Account account, int level, int rocket_kills)
	{
		ContentValues cv = new ContentValues();
		cv.put(DatabaseInfo.Runs.COLUMN_NAME_LEVEL, level);
		cv.put(DatabaseInfo.Runs.COLUMN_NAME_ROCKETKILLS, rocket_kills);
		cv.put(DatabaseInfo.Runs.COLUMN_NAME_ACCOUNTID, account.getId());

		insert("runs", null, cv);
	}

}
