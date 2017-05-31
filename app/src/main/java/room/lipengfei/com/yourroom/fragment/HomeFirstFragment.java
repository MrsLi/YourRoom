package room.lipengfei.com.yourroom.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import room.lipengfei.com.yourroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFirstFragment extends Fragment {


    public HomeFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_first, container, false);
    }

}
