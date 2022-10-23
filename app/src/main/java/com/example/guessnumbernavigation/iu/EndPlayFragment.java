package com.example.guessnumbernavigation.iu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guessnumbernavigation.R;
import com.example.guessnumbernavigation.data.Juego;
import com.example.guessnumbernavigation.databinding.FragmentEndPlayBinding;


public class EndPlayFragment extends Fragment {

    private static final String TAG = "EndPlayFragment";
    FragmentEndPlayBinding binding;
    private int intentos;
    private int num;
    private int restantes;

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
    public EndPlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding!=null)//Solo cuando existe la vista se guarda su estado
            outState.putParcelable(Juego.KEY,binding.getJuego());
        Log.d(TAG,"EndPlayFragment -> onSaveInstanceState()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Si la vista es null
        //Si existe la vista del fragment
        if (savedInstanceState!=null&&binding!=null) {
            binding.setJuego(savedInstanceState.getParcelable(Juego.KEY));
        }

        Log.d(TAG,"EndPlayFragment -> onViewStateRestored()");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentEndPlayBinding.inflate(inflater);
        binding.btnVolver.setOnClickListener(view -> NavHostFragment.findNavController(this).navigate(R.id.action_endPlayFragment_to_configFragment));
        return binding.getRoot();
   }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Juego juego=getArguments().getParcelable(Juego.KEY);
        intentos=getArguments().getInt("intentos");
        num=getArguments().getInt("número");
        restantes=getArguments().getInt("restantes");
        binding.setJuego(juego);
        Resultado();
    }
    void Resultado()
    {
        String s;
        if (Integer.parseInt(binding.getJuego().getIntentos())==1)
        {
            s=".";
        }
        else
        {s="s.";}

        if (restantes==0)
        {
            String texto1=getString(R.string.End1EJ)+" " + binding.getJuego().getNombre() +" "+
                    getString(R.string.End1NHHEN) + " "+num +" "+ getString(R.string.End1APDHT)+" "+binding.getJuego().getIntentos()+" "+getString(R.string.End1I)+s;
            binding.tvRes.setText(texto1);
        }
        else {
            String texto2=getString(R.string.End1EJ)+" " + binding.getJuego().getNombre() +" "+ getString(R.string.End2HHEN)+" " + num +" "+ getString(R.string.End2E) +" "+ intentos+" "+getString(R.string.End1I)+s;
            binding.tvRes.setText(texto2);
        }
    }
}