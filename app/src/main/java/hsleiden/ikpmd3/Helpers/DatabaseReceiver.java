package hsleiden.ikpmd3.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

import hsleiden.ikpmd3.R;

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

	// Makes a new database when the database changes.
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.Account.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.Timer.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.MapImages.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.MenuImages.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+ DatabaseInfo.PlayerImages.TABLE_NAME);

		onCreate(db);
	}

	public DatabaseReceiver(Context context, String name, SQLiteDatabase.CursorFactory factory, int version ){
		super(context, name, factory, version);
	}

	public void insert(String table, String nullColumnHack, ContentValues values){
		database.insert(table, nullColumnHack, values);
	}

	public Cursor query(String table, String[] columns, String selection, String[] selectArgs, String groupBy, String having, String orderBy){
		return database.query(table, columns, selection, selectArgs, groupBy, having, orderBy);
	}

	public void insertImage(String fileName, String table)
	{
		Bitmap image = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(fileName , "drawable", context.getPackageName()));
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);

		byte[] img;
		img = byteArrayOutputStream.toByteArray();
		ContentValues contentValues = new ContentValues();
		contentValues.put("image_name", fileName);
		contentValues.put("image", img);
		insert(table, null, contentValues);
	}

	//READ METHODS
	public Bitmap getMapImage(String imageName)
	{

	}


}
