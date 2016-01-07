package hsleiden.ikpmd3.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.helpers.DatabaseReceiver;
import hsleiden.ikpmd3.model.Account;

public class DeleteTabActivity extends Activity
{
    private Button deleteButton;
    private ListView accountList;

    private ArrayAdapter adapter;
    private List<Account> accounts;
    private List<String> accName;
    private Account selectedAccount;

    private DatabaseReceiver db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_tab);

        db = DatabaseReceiver.getDatabaseReceiver(this);

        deleteButton = (Button) findViewById(R.id.deleteButton);
        accounts = db.getAllAccounts();

        accountList = (ListView) findViewById(R.id.accountList);
        accountList.setClickable(true);
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

    public void deleteButtonListener(View view)
    {
        if(selectedAccount != null)
        {
            db.deleteAccount(selectedAccount);
            refreshData();
        } else {
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

    public void refreshData()
    {
        accounts = db.getAllAccounts();

        accName = new ArrayList<>();
        for(Account a: accounts)
        {
            accName.add(a.getName());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, accName);
        accountList.setAdapter(adapter);
    }

}
