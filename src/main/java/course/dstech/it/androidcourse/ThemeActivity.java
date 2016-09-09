package course.dstech.it.androidcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThemeActivity extends Activity {

    private int mThemeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.containsKey("theme")) {
            mThemeId = savedInstanceState.getInt("theme");
            this.setTheme(mThemeId);
        }

        setContentView(R.layout.activity_theme);

        Button defaultButton = (Button) findViewById(R.id.defaultButton);
        defaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDefaultTheme();
            }
        });

        Button greenButton = (Button) findViewById(R.id.greenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGreenTheme();
            }
        });

        Button redButton = (Button) findViewById(R.id.redButton);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRedTheme();
            }
        });
    }

    public void setGreenTheme() {
        mThemeId = R.style.AppTheme_Green;
        this.recreate();
    }

    public void setRedTheme() {
        mThemeId = R.style.AppTheme_Red;
        this.recreate();
    }

    public void setDefaultTheme() {
        mThemeId = R.style.AppTheme;
        this.recreate();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", mThemeId);

    }

}
