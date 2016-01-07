package hsleiden.ikpmd3.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.boot.MainActivity;
import hsleiden.ikpmd3.helpers.DatabaseReceiver;
import hsleiden.ikpmd3.model.Account;

public class AccountActivity extends Activity
{

    private ListView accountList;
    private ArrayAdapter adapter;

    // List moet van objecten account (player) bestaan.
    private List<Account> accounts;
    private List<String> accName;
    private Account selectedAccount;

    private DatabaseReceiver db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        db = DatabaseReceiver.getDatabaseReceiver(this);

        accounts = new ArrayList<>();
        accounts = db.getAllAccounts();

        accountList = (ListView) findViewById(R.id.accountList);
        accountList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                for (int i = 0; i < accountList.getChildCount(); i++)
                {
                    if(position == i)
                    {
                        accountList.getChildAt(i).setBackgroundColor(Color.argb(100, 7, 124, 180));
                    }else
                    {
                        accountList.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                selectedAccount = accounts.get(position);
            }
        });

        accName = new ArrayList<>();
        for(Account a: accounts)
        {
            accName.add(a.getName());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, accName);
        accountList.setAdapter(adapter);
    }

    public void startListener(View view)
    {
        if(selectedAccount != null) {
            startActivity(new Intent(AccountActivity.this, MainActivity.class));
        } else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("No account selected");
            alertDialog.setMessage("Please select an account");

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            alertDialog.show();
        }
    }

    public void newButtonListener(View view)
    {
        startActivity(new Intent(AccountActivity.this, CreateActivity.class));
    }

}
