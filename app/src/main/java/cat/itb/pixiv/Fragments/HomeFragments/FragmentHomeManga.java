package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterPixivVision;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterRankingIM;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdaptersMangaRecommended;
import cat.itb.pixiv.ClassesModels.ImatgesIllusMangaRanking;
import cat.itb.pixiv.ClassesModels.ImatgesMangaRecommended;
import cat.itb.pixiv.ClassesModels.ImatgesPixivVision;
import cat.itb.pixiv.R;

public class FragmentHomeManga extends Fragment {

    public static FragmentHomeManga getInstance() {
        return new FragmentHomeManga();
    }

    RecyclerView recyclerView;

    NAdapterRankingIM nAdapterRankingIM;
    NAdapterPixivVision nAdapterPixivVision;
    NAdaptersMangaRecommended nAdaptersMangaRecommended;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_manga, container, false);

        List<ImatgesIllusMangaRanking> rankinglist = new ArrayList<>();
        rankinglist.add(new ImatgesIllusMangaRanking("FGO", "Katarina", R.drawable.perro, R.raw.manga1));
        rankinglist.add(new ImatgesIllusMangaRanking("FGO", "Ereshikigal", R.drawable.perro, R.raw.manga2));
        rankinglist.add(new ImatgesIllusMangaRanking("FGO", "Ishtar", R.drawable.perro, R.raw.manga3));
        rankinglist.add(new ImatgesIllusMangaRanking("Gotoubun no Hanayome", "Bolulu", R.drawable.perro, R.raw.manga4));
        rankinglist.add(new ImatgesIllusMangaRanking("FGO", "Persona", R.drawable.perro, R.raw.manga5));

        List<ImatgesPixivVision> pixivVisionslist = new ArrayList<>();
        pixivVisionslist.add(new ImatgesPixivVision("Me, A Genius? I Was Reborn Into Another World And I Think They've Got The Wrong Idea!", R.raw.manga6));
        pixivVisionslist.add(new ImatgesPixivVision("WATARU!!! The Hot-Blooded Fighting Teen & His Epic Adventures After Stopping A Truck With His Bare Hands!", R.raw.manga7));
        pixivVisionslist.add(new ImatgesPixivVision("Do You Love Your Mom And Her Two-Hit Multi-Target Attacks?", R.raw.manga8));
        pixivVisionslist.add(new ImatgesPixivVision("The Hero And His Elf Bride Open A Pizza Parlor In Another World", R.raw.manga9));
        pixivVisionslist.add(new ImatgesPixivVision("Reborn As A Vending Machine, I Now Wander The Dungeon", R.raw.manga10));

        List<ImatgesMangaRecommended> mangaRecommendeds = new ArrayList<>();
        mangaRecommendeds.add(new ImatgesMangaRecommended("Fate", "work inspired in king arthur books", R.raw.manga11, 20));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Horimiya", "Tada Banri is lost at a law school ", R.raw.manga12, 2560));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Toradora", "This manga focuses on Ryuuji ", R.raw.manga13, 2000));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Oregairu", "Oregairu is one of the best romcom", R.raw.manga14, 1230));
        mangaRecommendeds.add(new ImatgesMangaRecommended("Nisekoi", "This anime focuses on Raku Ichijou", R.raw.manga15, 40));


        recyclerView = rootView.findViewById(R.id.recycler_view_manga_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        nAdapterRankingIM = new NAdapterRankingIM(rankinglist);
        recyclerView.setAdapter(nAdapterRankingIM);


        recyclerView = rootView.findViewById(R.id.recycler_view_manga_pixi_vision);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        nAdapterPixivVision = new NAdapterPixivVision(pixivVisionslist);
        recyclerView.setAdapter(nAdapterPixivVision);


        recyclerView = rootView.findViewById(R.id.recycler_view_manga_mangas);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        nAdaptersMangaRecommended = new NAdaptersMangaRecommended(mangaRecommendeds);
        recyclerView.setAdapter(nAdaptersMangaRecommended);

        return rootView;
    }


}