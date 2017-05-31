package room.lipengfei.com.yourroom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

import room.lipengfei.com.yourroom.fragment.FlatFragment;
import room.lipengfei.com.yourroom.fragment.HomeFragment;
import room.lipengfei.com.yourroom.fragment.HomestayFragment;
import room.lipengfei.com.yourroom.fragment.LodgeFragment;
/*
测试提交的注释代码
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNagivationBar;
    private ArrayList<Fragment> fragments;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        bottomNagivationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNagivationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNagivationBar.addItem(new BottomNavigationItem(R.mipmap.icon_01, "合租/整租"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_02, "公寓"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_03, "民宿"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_04, "驿站"))
                .setFirstSelectedPosition(0)
                .initialise();
        fragments = getFragments();
        setDefaultFragment();
        bottomNagivationBar.setTabSelectedListener(this);

    }


    /** * 设置默认的fragment*/
    private void setDefaultFragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame_main, HomeFragment.newInstance("合租/整租"));
        transaction.commit();
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("合租/整租"));
        fragments.add(FlatFragment.newInstance("公寓"));
        fragments.add(HomestayFragment.newInstance("民宿"));
        fragments.add(LodgeFragment.newInstance("驿站"));
        return fragments;
    }
    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.replace(R.id.frame_main, fragment);
                ft.commit();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
