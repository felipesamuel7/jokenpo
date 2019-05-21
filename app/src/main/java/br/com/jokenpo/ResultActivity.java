package br.com.jokenpo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {

    ImageView imgUser, imgCpu, imgEmoji;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imgUser = findViewById(R.id.imgUser);
        imgCpu = findViewById(R.id.imgCpu);
        imgEmoji = findViewById(R.id.imgEmoji);

        tvResult = findViewById(R.id.tvResult);

        Intent intent = getIntent();
        int userOption = intent.getIntExtra(MainActivity.USER_OPTION, 0);
        Shuffle(userOption);
    }

    private void Shuffle(int userOption) {
        int cpuOption = (int)(Math.random()*((3-1)+1))+1;

        switch (userOption){
            case GameOptionEnum.PEDRA:
                if (cpuOption == GameOptionEnum.PEDRA){
                    imgUser.setImageResource(R.drawable.pedra);
                    imgCpu.setImageResource(R.drawable.pedra);
                    imgEmoji.setImageResource(R.drawable.empate);
                    tvResult.setText("Empate!");
                } else if (cpuOption == GameOptionEnum.PAPEL){
                    imgUser.setImageResource(R.drawable.pedra_pb);
                    imgCpu.setImageResource(R.drawable.papel);
                    imgEmoji.setImageResource(GetEmoji(false));
                    tvResult.setText("Você perdeu!");
                } else {
                    imgUser.setImageResource(R.drawable.pedra);
                    imgCpu.setImageResource(R.drawable.tesoura_pb);
                    imgEmoji.setImageResource(GetEmoji(true));
                    tvResult.setText("Você venceu!");
                }

                break;

            case GameOptionEnum.PAPEL:
                if (cpuOption == GameOptionEnum.PEDRA){
                    imgUser.setImageResource(R.drawable.papel);
                    imgCpu.setImageResource(R.drawable.pedra_pb);
                    imgEmoji.setImageResource(GetEmoji(true));
                    tvResult.setText("Você venceu!");
                } else if (cpuOption == GameOptionEnum.PAPEL){
                    imgUser.setImageResource(R.drawable.papel);
                    imgCpu.setImageResource(R.drawable.papel);
                    imgEmoji.setImageResource(R.drawable.empate);
                    tvResult.setText("Empate!");
                } else {
                    imgUser.setImageResource(R.drawable.papel_pb);
                    imgCpu.setImageResource(R.drawable.tesoura);
                    imgEmoji.setImageResource(GetEmoji(false));
                    tvResult.setText("Você perdeu!");
                }

                break;

            case GameOptionEnum.TESOURA:
                if (cpuOption == GameOptionEnum.PEDRA){
                    imgUser.setImageResource(R.drawable.tesoura_pb);
                    imgCpu.setImageResource(R.drawable.pedra);
                    imgEmoji.setImageResource(GetEmoji(false));
                    tvResult.setText("Você perdeu!");
                } else if (cpuOption == GameOptionEnum.PAPEL){
                    imgUser.setImageResource(R.drawable.tesoura);
                    imgCpu.setImageResource(R.drawable.papel_pb);
                    imgEmoji.setImageResource(GetEmoji(true));
                    tvResult.setText("Você venceu!");
                } else {
                    imgUser.setImageResource(R.drawable.tesoura);
                    imgCpu.setImageResource(R.drawable.tesoura);
                    imgEmoji.setImageResource(R.drawable.empate);
                    tvResult.setText("Empate!");
                }

                break;
        }
    }

    private int GetEmoji (boolean victory){
        if (victory){
            int emoji = (int)(Math.random()*((5-1)+1))+1;
            switch (emoji){
                case 1:
                    return R.drawable.ganhou1;
                case 2:
                    return R.drawable.ganhou2;
                case 3:
                    return R.drawable.ganhou3;
                case 4:
                    return R.drawable.ganhou4;
                case 5:
                    return R.drawable.ganhou5;
                default:
                    return R.drawable.ganhou1;
            }
        } else {
            int emoji = (int)(Math.random()*((5-1)+1))+1;
            switch (emoji){
                case 1:
                    return R.drawable.perdeu1;
                case 2:
                    return R.drawable.perdeu2;
                case 3:
                    return R.drawable.perdeu3;
                case 4:
                    return R.drawable.perdeu4;
                case 5:
                    return R.drawable.perdeu5;
                default:
                    return R.drawable.perdeu1;
            }
        }
    }

}
