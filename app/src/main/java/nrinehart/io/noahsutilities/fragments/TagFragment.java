package nrinehart.io.noahsutilities.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import nrinehart.io.noahsutilities.R;

public class TagFragment extends Fragment{

    Button selectButton;
    TextView curTrack;
    ImageView curImage;
    EditText curArtist;
    EditText curAlbum;
    EditText curNum;
    EditText curYear;
    EditText curGenre;
    EditText curComment;
    EditText curComposer;
    EditText curAlbumArtist;

    public final int PICKFILE_RESULT_CODE = 1;

    public TagFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tag, container, false);

        selectButton = (Button) view.findViewById(R.id.selectsong_button);
        curImage = (ImageView) view.findViewById(R.id.current_image);
        curTrack = (TextView) view.findViewById(R.id.current_song);
        curArtist = (EditText) view.findViewById(R.id.current_artist);
        curAlbum = (EditText) view.findViewById(R.id.current_album);
        curNum = (EditText) view.findViewById(R.id.current_num);
        curYear = (EditText) view.findViewById(R.id.current_year);
        curGenre = (EditText) view.findViewById(R.id.current_genre);
        curComment = (EditText) view.findViewById(R.id.current_comment);
        curComposer = (EditText) view.findViewById(R.id.current_composer);
        curAlbumArtist = (EditText) view.findViewById(R.id.current_albumartist);

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/mpeg");
                startActivityForResult(intent, PICKFILE_RESULT_CODE);
            }
        });



        return view;
    }

}
