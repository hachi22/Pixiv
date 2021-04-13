package cat.itb.pixiv.FavFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterFavorites;
import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterRankingIllustrations;
import cat.itb.pixiv.ClassesModels.FavoriteClass;
import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;


public class fav_fragment extends Fragment {
    FirebaseDatabase database;
    DatabaseReference databaseReference,fvrtref,fvrt_lisref;
    Boolean fvrtChecker=false;
    RecyclerView recyclerView;
    ImageView img, favbutton;
    AdapterFavorites adapterFavorites;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fav_fragment, container, false);
        FireBaseHelper.setAllReferences();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUser=user.getUid();
        recyclerView=rootView.findViewById(R.id.fav_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<FavoriteClass> options = new FirebaseRecyclerOptions.Builder<FavoriteClass>()
                .setQuery(FireBaseHelper.getUserCollectionsIllustrations(), FavoriteClass.class).build();
        adapterFavorites = new AdapterFavorites(options);
        adapterFavorites.setContext(getContext());
        recyclerView.setAdapter(adapterFavorites);
        fvrtref=FireBaseHelper.getFavorites();
        fvrt_lisref=FireBaseHelper.getReferenceFavoritesList();
        return rootView;
    }
}