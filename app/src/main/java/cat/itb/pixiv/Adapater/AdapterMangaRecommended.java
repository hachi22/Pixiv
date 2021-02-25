package cat.itb.pixiv.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import cat.itb.pixiv.ClassesModels.ImatgesP;
import cat.itb.pixiv.R;

public class AdapterMangaRecommended extends FirebaseRecyclerAdapter<ImatgesP, AdapterMangaRecommended.ViewHolderMangaRecommended> {

    private ImatgesP model;
    private Context context;

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    public AdapterMangaRecommended(@NonNull FirebaseRecyclerOptions<ImatgesP> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterMangaRecommended.ViewHolderMangaRecommended holder, int position, @NonNull ImatgesP model) {
        this.model = model;
        holder.bind();
    }

    @NonNull
    @Override
    public AdapterMangaRecommended.ViewHolderMangaRecommended onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterMangaRecommended.ViewHolderMangaRecommended(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_manga_recommended,parent,false));
    }

    class ViewHolderMangaRecommended extends RecyclerView.ViewHolder {

        ImageView imageViewimage, imageViewlike;
        TextView textViewTitle, textViewDescription, textViewNumlikes;

        public ViewHolderMangaRecommended(@NonNull View itemView) {
            super(itemView);

            imageViewimage = itemView.findViewById(R.id.image_view_manga_recommended);
            imageViewlike = itemView.findViewById(R.id.image_view_manga_recommended_like);
            textViewTitle = itemView.findViewById(R.id.text_view_manga_recommended_title);
            textViewDescription = itemView.findViewById(R.id.text_view_manga_recommended_description);
            textViewNumlikes = itemView.findViewById(R.id.text_view_manga_recommended_numlikes);

        }

        public void bind(){
            Picasso.with(getContext()).load(model.getImage()).into(imageViewimage);
            final boolean[] heart = {false};
            imageViewlike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(heart[0]){
                        imageViewlike.setImageResource(R.drawable.likeheartwhite);
                    }else imageViewlike.setImageResource(R.drawable.likeheartred);
                    heart[0] = !heart[0];
                }
            });

            textViewTitle.setText(model.getTitle());
            textViewDescription.setText(model.getDescription());
            textViewNumlikes.setText(model.getNumLikes());
        }
    }
}