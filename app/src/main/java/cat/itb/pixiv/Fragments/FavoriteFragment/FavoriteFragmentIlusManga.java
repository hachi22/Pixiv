package cat.itb.pixiv.Fragments.FavoriteFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cat.itb.pixiv.Adapater.AdaptersFirebase.AdapterFavFragment;
import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.ClassesModels.User;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.R;


public class FavoriteFragmentIlusManga extends Fragment {
    RecyclerView recyclerView;
    AdapterFavFragment adapter;
    public static List<IllustrationClass> ilus=new ArrayList<>();
    DatabaseReference dbref;
    public static FavoriteFragmentIlusManga getInstance(){
        return new FavoriteFragmentIlusManga();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_favorite_ilus_manga, container, false);
        recyclerView = v.findViewById(R.id.fav_recycler);
        dbref=FireBaseHelper.getReferenceIllustrationsRecommended();
        adapter=new AdapterFavFragment(ilus);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = FireBaseHelper.getThisUser();
                IllustrationClass value;
                for (DataSnapshot ilustration:snapshot.getChildren()){
                    value=ilustration.getValue(IllustrationClass.class);
                    if(user.isFaved(value.getKey())){
                        ilus.add(value);
                    }

                    System.out.println(ilustration.getValue(IllustrationClass.class).getTitle());
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return v;
    }


}