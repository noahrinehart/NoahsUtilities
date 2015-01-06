package nrinehart.io.noahsutilities.fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import nrinehart.io.noahsutilities.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment {

    ImageButton moneyButton;

    public MoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_money, container, false);



        moneyButton = (ImageButton)view.findViewById(R.id.money_button);
        moneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mplayer = MediaPlayer.create(getActivity(), R.raw.money);
                mplayer.start();
            }
        });

        return view;
    }


    @Override
    public void onDestroy(){
        super.onDestroy();

    }

}
