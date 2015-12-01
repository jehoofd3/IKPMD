package hsleiden.ikpmd3.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseReceiver extends SQLiteOpenHelper {

	public static SQLiteDatabase sqLiteDatabase;
	private static DatabaseReceiver databaseReceiver;
	public static final String dbName = "database.db";
	public static final int dbVersion = 1;

	public DatabaseReceiver(Context context) {
		super(context, dbName, null, dbVersion);
	}

	public static synchronized DatabaseReceiver getDatabaseReceiver(Context context)
	{
		if(databaseReceiver == null)
		{
			databaseReceiver = new DatabaseReceiver(context);
			sqLiteDatabase = databaseReceiver.getWritableDatabase();
		}
		return databaseReceiver;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + DatabaseInfo.AccountTable.ACCOUNT + " (" +
				DatabaseInfo.AccountColumn.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				DatabaseInfo.AccountColumn.NAME + " TEXT"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.TimerTable.TIMER + " (" +
						DatabaseInfo.TimerColumn.LEVEL + "INTEGER, " +
						DatabaseInfo.TimerColumn.TIME+ " TEXT"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.MapImageTable.MAPIMAGES + " (" +
						DatabaseInfo.ImageColumn.IMAGENAME + "TEXT PRIMARY KEY" +
						DatabaseInfo.ImageColumn.IMAGE + "BLOB"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.MenuImageTable.MENUIMAGES + " (" +
						DatabaseInfo.ImageColumn.IMAGENAME + "TEXT PRIMARY KEY" +
						DatabaseInfo.ImageColumn.IMAGE + "BLOB"
		);

		db.execSQL("CREATE TABLE " + DatabaseInfo.PlayerImageTable.PLAYERIMAGES + " (" +
						DatabaseInfo.ImageColumn.IMAGENAME + "TEXT PRIMARY KEY" +
						DatabaseInfo.ImageColumn.IMAGE + "BLOB"
		);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.CourseTables.COURSE);
		onCreate(db);
	}

	public DatabaseReceiver(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
	}

	@Override
	public DatabaseReceiver(Context context, String name, SQLiteDatabase.CursorFactory factory, int version ){
		super(context,name,factory, version);
	}

	@Override
	public void insert(String table, String nullColumnHack, ContentValues values){
		mSQLDB.insert(table, nullColumnHack, values);
	}
	@Override
	public Cursor query(String table, String[] columns, String selection, String[] selectArgs, String groupBy, String having, String orderBy){
		return mSQLDB.query(table, columns, selection, selectArgs, groupBy, having, orderBy);
	}


}
