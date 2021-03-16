package cat.itb.pixiv.Adapater.NormalAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.pixiv.ClassesModels.ImatgesPixivVision;
import cat.itb.pixiv.R;

public class NAdapterPixivVision extends RecyclerView.Adapter<NAdapterPixivVision.NAViewHolder> {

    private List<ImatgesPixivVision> imagesList;

    public NAdapterPixivVision(List<ImatgesPixivVision> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public NAdapterPixivVision.NAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_manga_pixivision, parent, false);
        return new NAdapterPixivVision.NAViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NAdapterPixivVision.NAViewHolder holder, int position) {
        holder.binData(imagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    class NAViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;

        public NAViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_manga_pixivision);
            textViewTitle = itemView.findViewById(R.id.text_view_manga_pixivvidion);
        }

        public void binData(ImatgesPixivVision imatgesP) {
            textViewTitle.setText(imatgesP.getTitle());
            imageView.setImageResource(imatgesP.getImage());
        }
    }

}