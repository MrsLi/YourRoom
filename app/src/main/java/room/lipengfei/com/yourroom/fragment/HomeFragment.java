package room.lipengfei.com.yourroom.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import room.lipengfei.com.yourroom.R;
import room.lipengfei.com.yourroom.ViewPagerFragmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.top_imageView)
    ImageView topImageView;

    @InjectView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;

    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    private FragmentManager childFragmentManager;


    public static HomeFragment newInstance(String tabName) {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> mTitles = new ArrayList<>();
        mTitles.add("我要租房");
        mTitles.add("房屋委托");

        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new HomeFirstFragment());
        mFragments.add(new HomeSecondFragment());

        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), mFragments, mTitles);
        viewpager.setAdapter(viewPagerFragmentAdapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
