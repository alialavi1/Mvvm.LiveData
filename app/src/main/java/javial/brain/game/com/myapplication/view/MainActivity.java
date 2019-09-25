package javial.brain.game.com.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import javial.brain.game.com.myapplication.R;
import javial.brain.game.com.myapplication.databinding.ActivityMainBinding;
import javial.brain.game.com.myapplication.viewmodel.UserViewMOdel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserViewMOdel userViewMOdel = new UserViewMOdel(this);
        activityMainBinding.setUser(userViewMOdel);

    }
}
