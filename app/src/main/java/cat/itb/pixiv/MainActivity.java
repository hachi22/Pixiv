package cat.itb.pixiv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cat.itb.pixiv.LoginFragments.FragmentFirst;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FragmentFirst())
                .commit();
    }

}
