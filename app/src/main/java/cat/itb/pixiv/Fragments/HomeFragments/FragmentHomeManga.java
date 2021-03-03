package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cat.itb.pixiv.MainActivity;
import cat.itb.pixiv.R;

public class FragmentHomeManga extends Fragment {

    public static FragmentHomeManga getInstance(){
        return new FragmentHomeManga();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     return inflater.inflate(R.layout.fragment_home_manga, container, false);
    }


}