package br.opensource.game.chessgame.app.controller;

import android.os.Bundle;

import br.opensource.game.chessgame.app.R;
import br.opensource.game.chessgame.app.api.Activity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_view);
    }
}
