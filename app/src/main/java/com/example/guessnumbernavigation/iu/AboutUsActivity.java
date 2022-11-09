package com.example.guessnumbernavigation.iu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumbernavigation.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setName(R.string.AboutUsName)
                .setSubTitle(R.string.AboutUsSubTiTle)
                .setBrief(R.string.AboutUsBrief)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink(R.string.AboutUsGithub)

                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        //addContentView(view, layoutParams);
        setContentView(view);
    }
}