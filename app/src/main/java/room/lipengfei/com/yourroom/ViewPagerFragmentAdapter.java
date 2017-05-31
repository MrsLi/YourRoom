package room.lipengfei.com.yourroom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by a1 on 2017/5/25.
 */

public class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public ViewPagerFragmentAdapter(FragmentManager fm,List<Fragment> mFragments,List<String> mTitles) {
        super(fm);
        this.mFragments =mFragments;
        this.mTitles =mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
