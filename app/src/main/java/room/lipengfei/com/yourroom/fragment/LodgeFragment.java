package room.lipengfei.com.yourroom.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import room.lipengfei.com.yourroom.R;

/**
 * A simple {@link Fragment} subclass.
 * 客栈
 */
public class LodgeFragment extends Fragment {


    public static LodgeFragment newInstance(String tabName) {

        Bundle args = new Bundle();

        LodgeFragment fragment = new LodgeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lodge, container, false);
    }

}
