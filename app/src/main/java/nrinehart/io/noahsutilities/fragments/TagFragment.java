package nrinehart.io.noahsutilities.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;

import nrinehart.io.noahsutilities.R;

public class TagFragment extends Fragment{

    Button selectButton;
    ImageButton playButton;
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
    Button saveButton;

    public final int READ_REQUEST_CODE = 42;

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
        playButton = (ImageButton) view.findViewById(R.id.play_button);
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
        saveButton = (Button) view.findViewById(R.id.save_button);



        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*//song.start();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/mpeg");
                startActivityForResult(intent, READ_REQUEST_CODE);
                MediaPlayer mp=MediaPlayer.create(getActivity(), R.raw.sandstorm);
                mp.start();*/


                /*AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.bullseye);
                if (afd != null) {
                    MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                    mmr.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    String track = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(), track, Toast.LENGTH_SHORT);
                    toast.show();
                }*/

                Uri path = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.bullseye);
                MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                mmr.setDataSource(getActivity().getApplicationContext(), path);
                String track = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), track, Toast.LENGTH_SHORT);
                toast.show();












            }
        });



        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData){

        if (requestCode == READ_REQUEST_CODE &&  resultCode == Activity.RESULT_OK){

            /*AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.bullseye);
            if (afd != null) {
                MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                mmr.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                String track = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), track, Toast.LENGTH_SHORT);
                toast.show();
            }*/


            Uri uri = null;
            if(resultData != null){
                uri = resultData.getData();
                Log.i("TagFragment", "URI: "+ uri.toString());
            }

        }
    }
    @Override
    public void onPause() {
        super.onPause();
       // song.stop();
        //song.release();
    }





}
