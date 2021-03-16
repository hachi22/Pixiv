package cat.itb.pixiv.Adapater.NormalAdapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.pixiv.ClassesModels.ImatgesNovelRanking;
import cat.itb.pixiv.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class NAdaptersRankingNovels extends RecyclerView.Adapter<NAdaptersRankingNovels.NAViewHolder> {

    private List<ImatgesNovelRanking> imagesList;

    public NAdaptersRankingNovels(List<ImatgesNovelRanking> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public NAdaptersRankingNovels.NAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_novels_ranking, parent, false);
        return new NAdaptersRankingNovels.NAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NAdaptersRankingNovels.NAViewHolder holder, int position) {
        holder.binData(imagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    class NAViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewimage, imageViewlike;
        TextView textViewTitle, textViewDescription, textViewUser, textViewCharacters;
        CircleImageView userImage;

        public NAViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewimage = itemView.findViewById(R.id.image_view_novels_ranking);
            imageViewlike = itemView.findViewById(R.id.heart_novel_ranking);
            textViewTitle = itemView.findViewById(R.id.text_view_novels_rankings_title);
            textViewCharacters = itemView.findViewById(R.id.novel_characters);
            textViewDescription = itemView.findViewById(R.id.text_view_novels_rankings_description);
            userImage = itemView.findViewById(R.id.image_user_novels);
            textViewUser = itemView.findViewById(R.id.text_view_novels_rankings_user);
        }

        @SuppressLint("SetTextI18n")
        public void binData(ImatgesNovelRanking imatgesP) {

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

            textViewCharacters.setText(imatgesP.getCharacters() + "characters");
            textViewDescription.setText(imatgesP.getDescription());
            userImage.setImageResource(imatgesP.getImageUser());
            textViewUser.setText(imatgesP.getUser());
        }
    }

}

