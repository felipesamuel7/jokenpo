package br.com.jokenpo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String USER_OPTION = "USER_OPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendPedra(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(USER_OPTION, GameOptionEnum.PEDRA);
        startActivity(intent);
    }

    public void sendPapel(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(USER_OPTION, GameOptionEnum.PAPEL);
        startActivity(intent);
    }

    public void sendTesoura(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(USER_OPTION, GameOptionEnum.TESOURA);
        startActivity(intent);
    }
}
