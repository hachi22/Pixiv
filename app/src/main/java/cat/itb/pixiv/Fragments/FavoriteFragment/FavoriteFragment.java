package cat.itb.pixiv.Fragments.FavoriteFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterFavFragment;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterRankingIllustrations;
import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;


public class FavoriteFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterFavFragment adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_favorite, container, false);


        recyclerView = v.findViewById(R.id.fav_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<IllustrationClass> options = new FirebaseRecyclerOptions.Builder<IllustrationClass>()
                .setQuery(FireBaseHelper.getReferenceIllustrationsRecommended(), IllustrationClass.class).build();
        adapter = new AdapterFavFragment(options);
        adapter.setContext(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}