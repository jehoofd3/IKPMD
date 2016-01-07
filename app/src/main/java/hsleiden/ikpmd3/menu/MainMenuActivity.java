package hsleiden.ikpmd3.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hsleiden.ikpmd3.R;

public class MainMenuActivity extends Activity
{

    private Button startButton, statisticsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        startButton = (Button) findViewById(R.id.startButton);
        statisticsButton = (Button) findViewById(R.id.statisticsButton);

    }

    public void startListener(View view)
    {
        startActivity(new Intent(MainMenuActivity.this, AccountActivity.class));
    }

    public void statisticsListener(View view)
    {
        startActivity(new Intent(this, StatisticsActivity.class));
    }

}
