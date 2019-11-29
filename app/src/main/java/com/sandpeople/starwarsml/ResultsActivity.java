package com.sandpeople.starwarsml;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import static com.sandpeople.starwarsml.SearchActivity.DEV_MODE;

@SuppressWarnings("JavaDoc")
public class ResultsActivity extends AppCompatActivity {

    String predictedCharacter = "";
    TextView resultTextView;
    HashMap<String,String> charToForce = new HashMap<String, String>(){{
        put("Obi-Wan Kenobi", "Rebellion");
        put("Han Solo", "Rebellion");
        put("Lando Calrissian", "Rebellion");
        put("Princess Leia", "Rebellion");
        put("Luke Skywalker", "Rebellion");
        put("C-3PO", "Rebellion");
        put("Darth Vader", "Empire");
        put("Yoda", "Rebellion");
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        resultTextView = findViewById(R.id.result_intro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DEV_MODE) System.out.println("RESUMED RESULTS_ACTIVITY FROM TRANSITION_ACTIVITY");
        predictedCharacter = getIntent().getStringExtra("predictedCharacter");
        
    }

    public void closeThis(View view) {
        if (DEV_MODE) System.out.println("GOING TO MAIN_ACTIVITY FROM RESULTS_ACTIVITY");
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    /**
     * Determines the correct Character and find its display name in the String resources.
     * @param analysisResult
     * @return
     */
    private int getCharacterStringId(String analysisResult) {

        Character character = Character.valueOf(analysisResult);
        switch (character) {
            case BEN:
                return R.string.ben_display_name;
            case HAN:
                return R.string.han_display_name;
            case LANDO:
                return R.string.lando_display_name;
            case LEIA:
                return R.string.leia_display_name;
            case LUKE:
                return R.string.luke_display_name;
            case THREEPIO:
                return R.string.threepio_display_name;
            case VADER:
                return R.string.vader_display_name;
            case YODA:
                return R.string.yoda_display_name;
            default:
                return -1;

        }
    }

    private String getStringResource(int id) {
        return getResources().getString(id);
    }

}
