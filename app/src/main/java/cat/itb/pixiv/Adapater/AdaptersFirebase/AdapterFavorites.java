package cat.itb.pixiv.Adapater.AdaptersFirebase;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import cat.itb.pixiv.ClassesModels.FavoriteClass;
import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.R;

public class AdapterFavorites extends FirebaseRecyclerAdapter<FavoriteClass,AdapterFavorites.ViewHolderFavorites> {
    private FavoriteClass model;
    private Context context;
    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }
    public AdapterFavorites(@NonNull FirebaseRecyclerOptions<FavoriteClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterFavorites.ViewHolderFavorites holder, int position, @NonNull FavoriteClass model) {

    }

    @NonNull
    @Override
    public AdapterFavorites.ViewHolderFavorites onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public class ViewHolderFavorites extends RecyclerView.ViewHolder {
        ImageView image,favorite;
        public ViewHolderFavorites(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_view_fav_fragment);
            favorite=itemView.findViewById(R.id.img_fav_button);
        }

        public void bind(){

        }
    }
}
