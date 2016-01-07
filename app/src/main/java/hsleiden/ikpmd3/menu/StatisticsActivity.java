package hsleiden.ikpmd3.menu;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;

import java.util.ArrayList;
import java.util.List;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.helpers.DatabaseReceiver;
import hsleiden.ikpmd3.model.Account;

public class StatisticsActivity extends Activity implements AdapterView.OnItemSelectedListener
{

    private BarChart chart;
    private BarData barData;

    private Spinner accountSpinner, runSpinner;
    private ArrayList<Account> accounts;
    private ArrayList<String> accountString;
    private ArrayAdapter<Account> adapter;

    private DatabaseReceiver db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        db = DatabaseReceiver.getDatabaseReceiver(this);
        accounts = db.getAllAccounts();

        for(Account a: accounts)
        {
            a.setAllRuns(db.getAllRuns(a));
        }

        chart = (BarChart) findViewById(R.id.chart);

        barData = new BarData();
        chart.setData(barData);

        chart.setDescription("# the best score of player");


        accountSpinner = (Spinner) findViewById(R.id.accountSpinner);

        // Spinner click listener
        accountSpinner.setOnItemSelectedListener(this);

        accountString = new ArrayList<>();
        for(Account a: accounts)
        {
            accountString.add(a.getName());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, accountString);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        accountSpinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
    }

    public void onNothingSelected(AdapterView<?> arg0)
    {
        // TODO Auto-generated method stub
    }

    public void setRunSpinnerData(Account account)
    {

    }


}
