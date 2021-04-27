package cat.itb.pixiv.Fragments.onClickImage;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
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
import cat.itb.pixiv.FireBase.FireBaseHelper;
import cat.itb.pixiv.Fragments.HomeFragment;
import cat.itb.pixiv.Fragments.HomeFragments.FragmentHomeIllustrations;
import cat.itb.pixiv.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentOCIllustrations extends Fragment {
    ImageView image;
    CircleImageView userimage;
    TextView username,title;
    MaterialButton backIllus;
    MaterialButton followButton;
    boolean following;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_o_c_illustrations, container, false);

        image=v.findViewById(R.id.illustratrion_oc_Image);
        userimage=v.findViewById(R.id.illustration_oc_ProfileImage);
        username=v.findViewById(R.id.illustration_text_view_oc_username);
        title=v.findViewById(R.id.illustration_text_view_oc_tittle);
        backIllus = v.findViewById(R.id.backIllustration);
        followButton = v.findViewById(R.id.followButtonIllustration);

        Bundle arguments=getArguments();
        IllustrationClass ilus=arguments.getParcelable("illustrationRecommended");

        if(ilus!=null){
            setViews(ilus);
        }else if(ilus==null){
          ilus=arguments.getParcelable(  "illustrationRanking");
          setViews(ilus);
        }

        backIllus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            }
        });

        followButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                following = !following;
                if(following){
                    followButton.setText("following");
                    FireBaseHelper.subirUserFollow(username.getText().toString());
                }else{
                    followButton.setText("follow");
                    FireBaseHelper.eliminarUserFollow(username.getText().toString());
                }

            }
        });
        return v;
    }



    @SuppressLint("SetTextI18n")
    private void setViews(IllustrationClass ilustration) {


        boolean noe = FireBaseHelper.comprobarFollowing(ilustration.getUserName())[0];

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                if(noe){
                    followButton.setText("following");
                    following = true;
                }else{
                    followButton.setText("follow");
                    following = false;
                }

                Picasso.with(getActivity()).load(ilustration.getIllustrationImgUrl()).into(image);
                Picasso.with(getActivity()).load(ilustration.getUserImgUrl()).into(userimage);
                username.setText(ilustration.getUserName());
                title.setText(ilustration.getTitle());

            }
        }, 200);

        System.out.println(noe);


    }
}