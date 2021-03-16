package cat.itb.pixiv.Adapater.NormalAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.pixiv.ClassesModels.ImatgesIllustrationsRecommended;
import cat.itb.pixiv.R;

public class NAdapterIllustrationsRecommended extends RecyclerView.Adapter<NAdapterIllustrationsRecommended.NAViewHolder> {

    private List<ImatgesIllustrationsRecommended> imagesList;

    public NAdapterIllustrationsRecommended(List<ImatgesIllustrationsRecommended> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public NAdapterIllustrationsRecommended.NAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_illustrations_recommended, parent, false);
        return new NAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NAdapterIllustrationsRecommended.NAViewHolder holder, int position) {
        holder.binData(imagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    class NAViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewimage, imageViewLike, proves;

        public NAViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewimage = itemView.findViewById(R.id.image_view_illustrations_recommended);
            imageViewLike = itemView.findViewById(R.id.image_view_illustrations_recommended_like);
        }

        public void binData(ImatgesIllustrationsRecommended imatgesP) {
            final boolean[] heart = {false};
            imageViewimage.setImageResource(imatgesP.getImage());
            imageViewLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (heart[0]) {
                        imageViewLike.setImageResource(R.drawable.likeheartwhite);
                    } else imageViewLike.setImageResource(R.drawable.likeheartred);
                    heart[0] = !heart[0];
                }
            });
        }
    }

}
