package cat.itb.pixiv.Adapater.NormalAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.pixiv.ClassesModels.ImatgesNovelsRecommended;
import cat.itb.pixiv.R;

public class NAdapterNovelsRecommended extends RecyclerView.Adapter<NAdapterNovelsRecommended.NAViewHolder> {

    private List<ImatgesNovelsRecommended> imagesList;

    public NAdapterNovelsRecommended(List<ImatgesNovelsRecommended> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public NAdapterNovelsRecommended.NAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_novels_recommended, parent, false);
        return new NAdapterNovelsRecommended.NAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NAdapterNovelsRecommended.NAViewHolder holder, int position) {
        holder.binData(imagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    class NAViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewimage, imageViewlike;
        TextView textViewTitle, textViewDescription, textViewNumlikes, textViewUser;

        public NAViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewimage = itemView.findViewById(R.id.image_view_novels_recommended);
            imageViewlike = itemView.findViewById(R.id.image_view_novels_recommended_like);
            textViewTitle = itemView.findViewById(R.id.text_view_novels_recommended_title);
            textViewDescription = itemView.findViewById(R.id.text_view_novels_recommended_description);
            textViewNumlikes = itemView.findViewById(R.id.text_view_novels_recommended_numlikes);
            textViewUser = itemView.findViewById(R.id.text_view_novels_recommended_user);
        }

        public void binData(ImatgesNovelsRecommended imatgesP) {

            final boolean[] heart = {false};
            imageViewlike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (heart[0]) {
                        imageViewlike.setImageResource(R.drawable.likeheartwhite);
                    } else imageViewlike.setImageResource(R.drawable.likeheartred);
                    heart[0] = !heart[0];
                }
            });
            imageViewimage.setImageResource(imatgesP.getImage());
            textViewTitle.setText(imatgesP.getTitle());
            textViewDescription.setText(imatgesP.getDescription());
            textViewUser.setText(imatgesP.getUser());
            textViewNumlikes.setText(String.valueOf(imatgesP.getNumlikes()));
        }
    }

}
