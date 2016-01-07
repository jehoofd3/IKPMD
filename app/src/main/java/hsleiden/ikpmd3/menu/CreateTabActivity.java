package hsleiden.ikpmd3.menu;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.helpers.DatabaseReceiver;

public class CreateTabActivity extends Activity
{

    private Button addButton;
    private EditText name;
    private DatabaseReceiver db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tab);

        db = DatabaseReceiver.getDatabaseReceiver(this);

        addButton = (Button) findViewById(R.id.addButton);
        name = (EditText) findViewById(R.id.editText);

    }

    public void addListener(View view)
    {
        db.insertAccount(name.getText().toString());
        succesMessage(name.getText().toString());
    }

    public void succesMessage(String name)
    {

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Account created");
        alertDialog.setMessage("Name: " + name);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();

    }

}
