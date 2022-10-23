package com.example.guessnumbernavigation.iu;

import android.content.Context;
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


public class ConfigFragment extends Fragment {

   private FragmentConfigBinding binding;
    static  final String TAG="ConfigFragment";
    //Se declara una interfaz con los métodos que ofrece este fragment (contrato)
   /* interface OnSetDataMessage {
        void onSetDataMessage(Message message);
    }*/
    public ConfigFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"ConfigFragment -> onCreate");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
       /* try {
            listener=((OnSetDataMessage) context);
        }
        catch (ClassCastException e){throw new ClassCastException(context.toString()+": Debes implementar la interfaz OnSetDataMessage");}
*/
    }

    @Override
    public void onStart() {
        super.onStart();
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
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"ConfigFragment ->OnDestroy()");
        binding=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentConfigBinding.inflate(inflater);
        binding.setJuego(new Juego());

        binding.btJugar.setOnClickListener(view ->{
            if(Comprobar()){
            Bundle bundle=new Bundle();
            bundle.putParcelable(Juego.KEY,binding.getJuego());
            NavHostFragment.findNavController(this).navigate(R.id.action_configFragment_to_playFragment,bundle);}

        });
        return binding.getRoot();
    }
    public boolean Comprobar()
    {
        try {
            return Integer.parseInt(binding.etIntentos.getText().toString()) > 0 && binding.etPlayer.getText().toString().length() > 0;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding!=null)//Solo cuando existe la vista se guarda su estado
            outState.putParcelable(Juego.KEY,binding.getJuego());
        Log.d(TAG,"ConfigFragment -> onSaveInstanceState()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Si la vista es null
        //Si existe la vista del fragment
        if (savedInstanceState!=null&&binding!=null) {
            binding.setJuego(savedInstanceState.getParcelable(Juego.KEY));
        }

        Log.d(TAG,"ConfigFragment -> onViewStateRestored()");
    }
}