package com.example.guessnumbernavigation.iu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guessnumbernavigation.R;
import com.example.guessnumbernavigation.data.Juego;
import com.example.guessnumbernavigation.databinding.FragmentConfigBinding;
import com.example.guessnumbernavigation.databinding.FragmentPlayBinding;


public class PlayFragment extends Fragment {
    static  final String TAG="PlayFragment";
    private FragmentPlayBinding binding;
    private int restantes;
    int intentosh;
    int num;
    int numP;
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"PlayFragment -> onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }

    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Juego juego=getArguments().getParcelable(Juego.KEY);
        binding.setJuego(juego);
        num=(int)(Math.random()*100+1);
        int intentos =  Integer.parseInt(binding.getJuego().getIntentos());
        restantes=intentos;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= FragmentPlayBinding.inflate(inflater);

        binding.btnProbar.setOnClickListener(view -> {
            if(Probar()) {
                NavHostFragment.findNavController(this).navigate(R.id.action_playFragment_to_endPlayFragment, Final());
            } });
        return binding.getRoot();

    }
    public void setDataJuego(Juego juego){

        binding.setJuego(juego);

    }
    public boolean Probar(){
        restantes-=1;
        intentosh+=1;
        try {

            numP=Integer.parseInt(binding.etNum.getText().toString());

        }
        catch (Exception e)
        {
            binding.tvAyuda.setText(R.string.PlayIN);restantes+=1;
            intentosh-=1;
        }
        if (restantes==0||num==numP){
            return true;
        }
        if (numP<num)
        {
            binding.tvAyuda.setText(R.string.Play1NIM);

        }
        if (numP>num)
        {
            binding.tvAyuda.setText(R.string.Play2ENIEM);

        }
        binding.etNum.setText("");
        return  false;
    }
    public Bundle Final(){
        Bundle bundle=new Bundle();
        bundle.putParcelable("juego",binding.getJuego());
        bundle.putInt("número",num);
        bundle.putInt("intentos",intentosh);
        bundle.putInt("restantes",restantes);
        return bundle;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding!=null)//Solo cuando existe la vista se guarda su estado
            outState.putParcelable(Juego.KEY,binding.getJuego());
        Log.d(TAG,"PlayFragment -> onSaveInstanceState()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Si la vista es null
        //Si existe la vista del fragment
        if (savedInstanceState!=null&&binding!=null) {
            binding.setJuego(savedInstanceState.getParcelable(Juego.KEY));
        }

        Log.d(TAG,"PlayFragment -> onViewStateRestored()");
    }
}