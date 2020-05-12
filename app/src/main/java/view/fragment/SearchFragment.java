package view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kayzek.mushkayalogin.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    //Declaracion de Variables
    private static final int NUM_PAGES = 3;
    private ViewPager mPager;


    public SearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        if (savedInstanceState == null) {
            mPager = (ViewPager) view.findViewById(R.id.container_search);
            adaptersearch pageadapter= new adaptersearch(getFragmentManager());
            pageadapter.addFragment(new Search_Orange(), "Naranja");
            pageadapter.addFragment(new Search_Green(), "Verde");
            pageadapter.addFragment(new Search_Blue(), "Azul");
            mPager.setAdapter(pageadapter);
        }
        showToolbar("Colores", false, view);
        return view;
    }

    private class adaptersearch extends FragmentStatePagerAdapter {
        private final List<Fragment> fragmentos = new ArrayList<>();
        private final List<String> titulos= new ArrayList<>();

        public adaptersearch(androidx.fragment.app.FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int Position){
            return fragmentos.get(Position);
        }

        @Override
        public int getCount(){
            return fragmentos.size();
        }


        public void addFragment(Fragment fragment, String Title)
        {
            fragmentos.add(fragment);
            titulos.add(Title);
        }
        @Override
        public CharSequence getPageTitle(int position)
        {
            return titulos.get(position);
        }
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
