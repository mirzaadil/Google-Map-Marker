package com.mirzaadil.technicalassessmentwunder.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.mirzaadil.technicalassessmentwunder.R;
import com.mirzaadil.technicalassessmentwunder.fragments.vehicleListFragment;
import com.mirzaadil.technicalassessmentwunder.fragments.vehicleMapFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initView();

    }

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void fragmentCall() {
        fragment = new vehicleListFragment();
        loadFragment(fragment);
    }

    private void initView() {

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentCall();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    //   toolbar.setTitle("Shop");
                    fragment = new vehicleListFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
                    // toolbar.setTitle("My Gifts");
                    fragment = new vehicleMapFragment();
                    loadFragment(fragment);
                    return true;

            }

            return false;
        }
    };

}
