package com.ixiaoma.modify.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ixiaoma.modify.R;

/**
 * Created by xiaoma on 2017/2/24.
 */

public class TabDFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);
        TextView mContent = (TextView) view.findViewById(R.id.tv_content);
        mContent.setText("第四个Tab");
        return view;
    }
}
