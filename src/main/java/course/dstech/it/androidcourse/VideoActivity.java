package course.dstech.it.androidcourse;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);

        final MediaController controller = new MediaController(this);

        surfaceView = (VideoView) findViewById(R.id.surfaceView);
        surfaceView.setMediaController(controller);

        Uri uri = Uri.parse("http://sandbox.stickyadstv.com/html5-sdk/samples/BigBuck.m4v");
        surfaceView.setVideoURI(uri);
        surfaceView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        
    }

    @Override
    protected void onPause() {
        super.onPause();
        surfaceView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        surfaceView.resume();
    }
}
