package cat.itb.pixiv.Fragments.onClickImage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import cat.itb.pixiv.ClassesModels.IllustrationClass;
import cat.itb.pixiv.ClassesModels.MangaClass;
import cat.itb.pixiv.ClassesModels.User;
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.Fragments.HomeFragment;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeManga;
import cat.itb.pixiv.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentOCManga extends Fragment {
    ImageView image;
    CircleImageView userimage;
    TextView title,username,description;
    MaterialButton back;
    FloatingActionButton favbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_o_c_manga, container, false);
        image=v.findViewById(R.id.manga_oc_Image);
        userimage=v.findViewById(R.id.manga_oc_ProfileImage);
        title=v.findViewById(R.id.manga_text_view_oc_tittle);
        username=v.findViewById(R.id.manga_text_view_oc_username);
        description=v.findViewById(R.id.manga_text_view_oc_description);
        back = v.findViewById(R.id.backManga);
        favbutton=v.findViewById(R.id.floatingActionButton_manga);
        Bundle arguments=getArguments();
        MangaClass manga =arguments.getParcelable("mangaRecomended");
        if(manga!=null){
            setManga(manga);
        }else if(manga==null){
            manga=arguments.getParcelable("mangaranking");
            setManga(manga);
        }
        MangaClass finalManga = manga;
        User user = FireBaseHelper.getThisUser();
        String mangaId = finalManga.getKey();
        if (user.isFaved(mangaId)) {
            favbutton.setImageResource(R.drawable.likeheartred);

        } else {
            favbutton.setImageResource(R.drawable.likeheartwhite);

        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            }
        });

        favbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFaved(mangaId)) {
                    favbutton.setImageResource(R.drawable.likeheartwhite);
                    user.removeFavorite(mangaId);
                } else {
                    favbutton.setImageResource(R.drawable.likeheartred);
                    user.addFavorite(mangaId);
                }
                FireBaseHelper.updateDatabase(finalManga);
                FireBaseHelper.updateDatabase(user);
            }
        });

        return v;
    }

    private void setManga(MangaClass manga){
        Picasso.with(getActivity()).load(manga.getMangaImgUrl()).into(image);
         //Picasso.with(getActivity()).load(manga.getUserImgUrl()).into(userimage);
        username.setText(manga.getUserName());
        title.setText(manga.getTitle());
        description.setText(manga.getDescription());
    }
}