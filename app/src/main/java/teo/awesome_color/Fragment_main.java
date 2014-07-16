package teo.awesome_color;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;


public class Fragment_main extends Fragment {


    public static int RED=0;
    public static int GREEN=0;
    public static int BLUE=0;

    public static float hsv[]={0,0,0};

    TextView tvCHangeText,tvHue,tvSaturation,tvValue;
    SeekBar seekBarRed,seekBarGreen,seekBarBlue;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, null);

        tvCHangeText=(TextView)view.findViewById(R.id.tvChangeText);
        tvHue=(TextView)view.findViewById(R.id.tvHue);
        tvSaturation=(TextView)view.findViewById(R.id.tvSaturation);
        tvValue=(TextView)view.findViewById(R.id.tvValue);
        seekBarRed=(SeekBar)view.findViewById(R.id.seekBarRed);
        seekBarGreen=(SeekBar)view.findViewById(R.id.seekBarGreen);
        seekBarBlue=(SeekBar)view.findViewById(R.id.seekBarBlue);

        tvHue.setText("Hue:\t");
        tvSaturation.setText("Saturation:\t");
        tvValue.setText("Value:\t");


        SeekBar.OnSeekBarChangeListener seekBarListener=new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                switch (seekBar.getId()){
                    case R.id.seekBarRed:
                        RED=Integer.valueOf(seekBar.getProgress());
                        break;
                    case R.id.seekBarGreen:
                        GREEN=Integer.valueOf(seekBar.getProgress());
                        break;
                    case R.id.seekBarBlue:
                        BLUE=Integer.valueOf(seekBar.getProgress());
                        break;
                }
                tvCHangeText.setTextColor(Color.rgb(RED,GREEN,BLUE));
                Color.RGBToHSV(RED, GREEN, BLUE, hsv);
                tvHue.setText("Hue:\t" + String.valueOf(hsv[0]));
                tvSaturation.setText("Saturation:\t"+String.valueOf(hsv[1]));
                tvValue.setText("Value:\t"+String.valueOf(hsv[2]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        seekBarGreen.setOnSeekBarChangeListener(seekBarListener);
        seekBarBlue.setOnSeekBarChangeListener(seekBarListener);
        seekBarRed.setOnSeekBarChangeListener(seekBarListener);
        return view;

    }
}
