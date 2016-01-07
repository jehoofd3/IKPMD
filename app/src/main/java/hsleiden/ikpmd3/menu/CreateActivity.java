package hsleiden.ikpmd3.menu;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import hsleiden.ikpmd3.R;

public class CreateActivity extends TabActivity
{

    private Button addButton;
    private TabHost tabHost;
    private TabHost.TabSpec createTab, deleteTab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //addButton = (Button) findViewById(R.id.addButton);

        // Create the tabhost that will contain the tabs
        tabHost = getTabHost();


        createTab = tabHost.newTabSpec("Create account");
        deleteTab = tabHost.newTabSpec("Delete account");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        createTab.setIndicator("Create account");
        createTab.setContent(new Intent(CreateActivity.this, CreateTabActivity.class));

        deleteTab.setIndicator("Delete account");
        deleteTab.setContent(new Intent(CreateActivity.this, DeleteTabActivity.class));

        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(createTab);
        tabHost.addTab(deleteTab);

    }
}