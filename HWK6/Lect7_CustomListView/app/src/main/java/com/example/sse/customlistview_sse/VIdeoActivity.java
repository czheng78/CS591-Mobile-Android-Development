package com.example.sse.customlistview_sse;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VIdeoActivity extends Activity {

    VideoView videoV;
    MediaController md;
    private static final String VIDEO_SAMPLE = "khan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoV = (VideoView) findViewById(R.id.videoV);
        md = new MediaController(this);
    }

    private Uri getMedia(String mediaName) {
        return Uri.parse("android.resource://" + getPackageName() +
                "/raw/" + mediaName);
    }

    private void initializePlayer () {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        videoV.setVideoURI(videoUri);
        videoV.start();
    }

    @Override
    protected void onStart() {
        super.onStart();

        initializePlayer();
    }


//    public void videoPlay (View v) {
//        Log.i("Hi", "videoV");
//        String videoUrl = "android.resource://com.example.sse.customlistview_sse/"+R.raw.khan;
//        Uri uri = Uri.parse(videoUrl);
//        videoV.setVideoURI(uri);
//        videoV.setMediaController(md);
//        md.setAnchorView(videoV);
//
//        videoV.start();
//    }

}
