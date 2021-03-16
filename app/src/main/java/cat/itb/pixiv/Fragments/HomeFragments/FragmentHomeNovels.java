package cat.itb.pixiv.Fragments.HomeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.pixiv.Adapater.NormalAdapters.NAdapterNovelsRecommended;
import cat.itb.pixiv.Adapater.NormalAdapters.NAdaptersRankingNovels;
import cat.itb.pixiv.ClassesModels.ImatgesNovelRanking;
import cat.itb.pixiv.ClassesModels.ImatgesNovelsRecommended;
import cat.itb.pixiv.R;

public class FragmentHomeNovels extends Fragment {

    public static FragmentHomeNovels getInstance() {
        return new FragmentHomeNovels();
    }

    RecyclerView recyclerView;

    NAdaptersRankingNovels nAdaptersRankingNovels;
    NAdapterNovelsRecommended nAdapterNovelsRecommended;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_novels, container, false);


        List<ImatgesNovelRanking> novelRankings = new ArrayList<>();
        novelRankings.add(new ImatgesNovelRanking("The Tale of Genji", "Murasaki Shikibu",
                "Murasaki Shikibu was an author of what most consider to be the world’s first novel", "8000", R.drawable.perro, R.raw.novel1));
        novelRankings.add(new ImatgesNovelRanking("Snow Country", "YasunariKawabata",
                "Nobel Prize winner Yasunari Kawabata is one of Japan’s most beloved and revered novelists", "9000", R.drawable.perro, R.raw.novel2));
        novelRankings.add(new ImatgesNovelRanking("The Silent Cry", "Kenzaburo Oe",
                "Kenzaburo Oe was another of Japan’s Nobel Prize winners", "10000", R.drawable.perro, R.raw.novel3));
        novelRankings.add(new ImatgesNovelRanking("Kirby adventure", "Nintendo",
                "Kirby was created by video game designer Masahiro Sakurai", "2500", R.drawable.perro, R.raw.novel4));
        novelRankings.add(new ImatgesNovelRanking("The Diving Pool", "Yoko Ogawa",
                "From Akutagawa Award-winning author Yoko Ogawa comes a haunting trio of novellas about love", "9000", R.drawable.perro, R.raw.novel5));
        novelRankings.add(new ImatgesNovelRanking("Shomin Sample", "Isekai lover",
                "A boy is kidnapped and taken to a Girl's Academy to be used as an example of a \"commoner\"", "8000", R.drawable.perro, R.raw.novel6));

        List<ImatgesNovelsRecommended> novelsRecommendeds = new ArrayList<>();
        novelsRecommendeds.add(new ImatgesNovelsRecommended("The Former Top 1",
                "After a boy who has been ranked number one is suddenly hacked and loses his rank, he awakens to find that he is inside the game world.", "Kirito", R.raw.novel7, 400));
        novelsRecommendeds.add(new ImatgesNovelsRecommended("Shuumatsu Nani",
                "AAfter humans have gone extinct and five hundred years pass, enemies called Beasts roam the world.", "Azura", R.raw.novel8, 200));
        novelsRecommendeds.add(new ImatgesNovelsRecommended("Noucome",
                "This refreshing light novel and manga follows Kanade Amakusa, a high school boy who has a power called Absolute Choice.", "Shirou", R.raw.novel9, 100));
        novelsRecommendeds.add(new ImatgesNovelsRecommended("No longer human",
                " is considered Dazai's masterpiece and ranks as the second-best selling novel ever in Japan.", "Osamu Dazai", R.raw.novel10, 400));


        recyclerView = rootView.findViewById(R.id.recycler_view_novels_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        nAdaptersRankingNovels = new NAdaptersRankingNovels(novelRankings);
        recyclerView.setAdapter(nAdaptersRankingNovels);

        recyclerView = rootView.findViewById(R.id.recycler_view_novels_recommended);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        nAdapterNovelsRecommended = new NAdapterNovelsRecommended(novelsRecommendeds);
        recyclerView.setAdapter(nAdapterNovelsRecommended);

        return rootView;
    }

}