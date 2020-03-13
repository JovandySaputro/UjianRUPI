package com.example.ujianrupi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private Context mContext;
    SessionPreferences session;
    private TextView email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        mContext = getContext();
        session = new SessionPreferences(mContext);
        email = v.findViewById(R.id.etEmail);
        email.setText( session.getValue(SessionPreferences.KEY_EMAIL));
        return v;
    }
}
