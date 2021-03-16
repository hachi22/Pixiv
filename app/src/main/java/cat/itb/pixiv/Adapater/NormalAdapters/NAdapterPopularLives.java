package cat.itb.pixiv.Adapater.NormalAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.pixiv.ClassesModels.ImatgesPopularLives;
import cat.itb.pixiv.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class NAdapterPopularLives extends RecyclerView.Adapter<NAdapterPopularLives.NAViewHolder> {

    private List<ImatgesPopularLives> imagesList;

    public NAdapterPopularLives(List<ImatgesPopularLives> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public NAdapterPopularLives.NAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_popular_lives, parent, false);
        return new NAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NAdapterPopularLives.NAViewHolder holder, int position) {
        holder.binData(imagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    class NAViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewViews;
        CircleImageView userImage;

        public NAViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_illustrations_popular_lives);
            textViewTitle = itemView.findViewById(R.id.text_view_illustrations_name_popular_lives);
            textViewViews = itemView.findViewById(R.id.text_view_illustrations_views_popular_lives);
            userImage = itemView.findViewById(R.id.popular_lives_user);
        }

        public void binData(ImatgesPopularLives imatgesP) {
            imageView.setImageResource(imatgesP.getImage());
            userImage.setImageResource(imatgesP.getImageUser());
            textViewTitle.setText(imatgesP.getUser());
            textViewViews.setText(String.valueOf(imatgesP.getNumViews()));
        }
    }

}
