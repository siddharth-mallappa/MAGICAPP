package com.example.dashboard;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.chaos.view.PinView;

public class bathroomPopup extends AppCompatDialogFragment {
    private PinView pinview;
    int button_id = mirrorsAvailable.id;


    private ExampleDialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.password_popup, null);
        view.setBackgroundColor(212133);
        builder.setView(view)
                .setTitle("Password")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String password= pinview.getText().toString();
                        Log.d("inside", "setpositive button");
                        if(button_id==1)
                            listener.bathroomPass(password);
                        else if(button_id ==2)
                            listener.bedroomPass(password);
                        else if(button_id==3)
                            listener.officePass(password);

                    }
                });
        pinview = view.findViewById(R.id.pinView);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener =(ExampleDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "Must implement ExampleDialogListener");
        }

    }

    public interface ExampleDialogListener{
        void bathroomPass(String password);
        void bedroomPass(String password);
        void officePass(String password);

    }
}
