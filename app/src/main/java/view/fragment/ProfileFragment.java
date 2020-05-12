package view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.kayzek.mushkayalogin.R;
import com.kayzek.mushkayalogin.adapter.PictureAdapterReclyclerView;
import com.kayzek.mushkayalogin.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar(" ", false, view);
        RecyclerView pictureRecycler = (RecyclerView)  view.findViewById(R.id.picture_profile_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterReclyclerView pictureAdapterRecyclerView =
                new PictureAdapterReclyclerView (buildPictures() , R.layout.cardview_picture, getActivity());
        pictureRecycler.setAdapter(pictureAdapterRecyclerView);

        CircleImageView circleImage = (CircleImageView) view.findViewById(R.id.profile_image);
        Glide.with(this).load("https://assets.cdnelnuevodiario.com/cache/70/83/7083a662286bf5e73e29072cf1ec04a4.jpg")
                .into(circleImage);


        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://img.freepik.com/vector-gratis/paisaje-montanas-ilustracion-minimalista-plana_71609-1272.jpg?size=626&ext=jpg",
                "Carlos Calero", "1 Semana","10 Me Gusta"));
        pictures.add(new Picture("https://image.freepik.com/vector-gratis/paisaje-nocturno-minimalista-pinos-estrellas-fugaces_104785-99.jpg",
                "Isaac Llanes", "3 Dias","6 Me Gusta"));
        pictures.add(new Picture("https://image.freepik.com/vector-gratis/paisaje-minimalista-desierto_23-2148269225.jpg",
                "Sandra Llanes", "1 Dia","18 Me Gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
