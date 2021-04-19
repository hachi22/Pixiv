package cat.itb.pixiv.Adapater.AdaptersFirebase;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.ClassesModels.User;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.Fragments.onClickImage.FragmentOCIllustrations;
import cat.itb.pixiv.R;

public class AdapterFavFragment extends FirebaseRecyclerAdapter<IllustrationClass, ViewHolderIllustrationsRecommended> {
    private Context context;

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    public AdapterFavFragment(@NonNull FirebaseRecyclerOptions<IllustrationClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolderIllustrationsRecommended holder, int position, @NonNull final IllustrationClass model) {
        System.out.println(model.getKey());
        User user = FireBaseHelper.getThisUser();
        if (user == null) {
            return;
        }
        if(user.isFaved(model.getKey()))
        holder.bind(model,getContext());
    }

    @NonNull
    @Override
    public ViewHolderIllustrationsRecommended onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderIllustrationsRecommended(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_recommended,parent,false));
    }


}
