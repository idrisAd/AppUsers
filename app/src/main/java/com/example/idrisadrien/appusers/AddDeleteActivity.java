package com.example.idrisadrien.appusers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idrisadrien on 19/10/2017.
 */

public class AddDeleteActivity extends AppCompatActivity {

    String[] metiers={"Cardiologue","Radiologue","Infirmier(e)","Urgentiste"};
    private String adMail;
    private String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delete);

        Intent intentDelete = getIntent();
        Integer printUser = intentDelete.getIntExtra("id", -1);

        if(printUser!=-1){
            Log.d("MyLog", "Print clocked user, delete/modify buttons, mail/call buttons");

            TextView add_button = (TextView) findViewById(R.id.add_button);
            TextView delete_button = (TextView) findViewById(R.id.delete_button);
            TextView modify_button = (TextView)findViewById(R.id.modify_button);
            TextView sendMail_button = (TextView)findViewById(R.id.sendMail);
            TextView call_button = (TextView) findViewById(R.id.callButton);

            add_button.setVisibility(View.GONE);
            delete_button.setVisibility(View.VISIBLE);
            modify_button.setVisibility(View.VISIBLE);
            sendMail_button.setVisibility(View.VISIBLE);
            call_button.setVisibility(View.VISIBLE);


            // Editing the form to add a user
            EditText nom_text = (EditText)findViewById(R.id.nom_text);
            EditText prenom_text = (EditText)findViewById(R.id.prenom_text);
            RadioGroup sexe_button = (RadioGroup) findViewById(R.id.sexe_button);
            RadioButton gender_checked = (RadioButton)findViewById(sexe_button.getCheckedRadioButtonId());
            String genderVal = gender_checked.getText().toString();
            // Auto Complete Text
            AutoCompleteTextView job = (AutoCompleteTextView)findViewById(R.id.job);
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,metiers);
            job.setAdapter(adapter);
            job.setThreshold(1);
            // Spinner
            List<String> categories = new ArrayList<String>();
            categories.add("Cardiologie");
            categories.add("Radiologie");
            categories.add("Pediatrie");
            categories.add("Chirurgie");
            Spinner serviceH = (Spinner) findViewById(R.id.serviceH);
            ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,categories);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            serviceH.setAdapter(adapter1);

            final EditText mail_text = (EditText)findViewById(R.id.mail_text);
            final EditText tel_text = (EditText)findViewById(R.id.tel_text);
            EditText resume_text = (EditText)findViewById(R.id.resume_text);


            Button sendMail = (Button)findViewById(R.id.sendMail);
            sendMail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("MyLog","Click on Send Mail");
                    adMail = mail_text.getText().toString();

                    Uri uri = Uri.parse("mailto:" + adMail);
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra("mail body",-1);
                    startActivity(intent);
                }
            });

            Button call = (Button)findViewById(R.id.callButton);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("MyLog","Click on Call");
                    numero = tel_text.getText().toString();

                    Uri telephone = Uri.parse("tel:" + numero);
                    Intent call_intent = new Intent(Intent.ACTION_DIAL, telephone);
                    startActivity(call_intent);
                }
            });


            String nom = intentDelete.getStringExtra("nom");
            String prenom= intentDelete.getStringExtra("prenom");
            String sexe = intentDelete.getStringExtra("sexe");
            String metier = intentDelete.getStringExtra("metier");
            String service = intentDelete.getStringExtra("service");
            String mail = intentDelete.getStringExtra("mail");
            String tel = intentDelete.getStringExtra("tel");
            String resume = intentDelete.getStringExtra("resume");

            nom_text.setText(nom);
            prenom_text.setText(prenom);
            gender_checked.setText(genderVal);
            job.setText(metier);
            //serviceH.setText();
            mail_text.setText(mail);
            tel_text.setText(tel);
            resume_text.setText(resume);


            // Interface to add user
        } else {
            Log.d("MyLog","Interface to add user");
            TextView add_button = (TextView)findViewById(R.id.add_button);
            TextView delete_button = (TextView)findViewById(R.id.delete_button);
            TextView modify_button = (TextView)findViewById(R.id.modify_button);
            TextView sendMail_button = (TextView)findViewById(R.id.sendMail);
            TextView call_button = (TextView) findViewById(R.id.callButton);

            add_button.setVisibility(View.VISIBLE);
            delete_button.setVisibility(View.GONE);
            modify_button.setVisibility(View.GONE);
            sendMail_button.setVisibility(View.GONE);
            call_button.setVisibility(View.GONE);

        }

    }


    protected void clickOnAdd(View view){
        Log.d("MyLog","Clicked on add");
        EditText nom_text = (EditText)findViewById(R.id.nom_text);
        EditText prenom_text = (EditText)findViewById(R.id.prenom_text);

        RadioGroup sexe_button = (RadioGroup) findViewById(R.id.sexe_button);
        RadioButton gender_checked = (RadioButton)findViewById(sexe_button.getCheckedRadioButtonId());

        AutoCompleteTextView job = (AutoCompleteTextView)findViewById(R.id.job);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,metiers);
        job.setAdapter(adapter);
        job.setThreshold(1);

        List<String> categories = new ArrayList<String>();
        categories.add("Cardiologie");
        categories.add("Radiologie");
        categories.add("Pediatrie");
        categories.add("Chirurgie");

        Spinner serviceH = (Spinner) findViewById(R.id.serviceH);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,categories);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceH.setAdapter(adapter1);


        EditText mail_text = (EditText)findViewById(R.id.mail_text);
        EditText tel_text = (EditText)findViewById(R.id.tel_text);
        EditText resume_text = (EditText)findViewById(R.id.resume_text);

        Intent intent = new Intent(AddDeleteActivity.this, ListUsersActivity.class);
        intent.putExtra("add",true);
        intent.putExtra("nom",nom_text.getText().toString());
        intent.putExtra("prenom",prenom_text.getText().toString());
        intent.putExtra("sexe",gender_checked.getText().toString());
        intent.putExtra("metier",job.getText().toString());
        intent.putExtra("service",serviceH.getSelectedItem().toString());
        intent.putExtra("mail",mail_text.getText().toString());
        intent.putExtra("tel", tel_text.getText().toString());
        intent.putExtra("resume",resume_text.getText().toString());
        Log.d("MyLog",nom_text.getText().toString());
        startActivity(intent);
    }

    protected void clickOnDelete(View view){

        // Verification delete
        AlertDialog.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        Log.d("MyLog","Clicked on delete");
        builder.setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete

                        Intent intentReceived = getIntent();
                        Integer idUserToDelete = intentReceived.getIntExtra("id", -1);
                        Intent intentToSend = new Intent(AddDeleteActivity.this, ListUsersActivity.class);
                        intentToSend.putExtra("delete",true);
                        intentToSend.putExtra("id",idUserToDelete);
                        startActivity(intentToSend);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        Log.d("MyLog","DialogBox appear");




    }

    protected void clickOnModify(View view){
        Log.d("MyLog","Clicked on modify");
        EditText nom_text = (EditText)findViewById(R.id.nom_text);
        EditText prenom_text = (EditText)findViewById(R.id.prenom_text);

        RadioGroup sexe_button = (RadioGroup) findViewById(R.id.sexe_button);
        RadioButton gender_checked = (RadioButton)findViewById(sexe_button.getCheckedRadioButtonId());
        String genderVal = gender_checked.getText().toString();

        AutoCompleteTextView job = (AutoCompleteTextView)findViewById(R.id.job);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,metiers);
        job.setAdapter(adapter);
        job.setThreshold(1);

        List<String> categories = new ArrayList<String>();
        categories.add("Cardiologie");
        categories.add("Radiologie");
        categories.add("Pediatrie");
        categories.add("Chirurgie");

        Spinner serviceH = (Spinner) findViewById(R.id.serviceH);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,categories);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceH.setAdapter(adapter1);



        EditText mail_text = (EditText)findViewById(R.id.mail_text);
        EditText tel_text = (EditText)findViewById(R.id.tel_text);
        EditText resume_text = (EditText)findViewById(R.id.resume_text);

        Intent intentReceived = getIntent();
        Integer idUserToModify = intentReceived.getIntExtra("id", -1);
        // sending Intent with "modify"=true, id and fields for update
        Intent intentToSend = new Intent(AddDeleteActivity.this, ListUsersActivity.class);
        intentToSend.putExtra("modify",true);
        intentToSend.putExtra("id", idUserToModify);
        intentToSend.putExtra("nom",nom_text.getText().toString());
        intentToSend.putExtra("prenom",prenom_text.getText().toString());
        intentToSend.putExtra("sexe",gender_checked.getText().toString());
        intentToSend.putExtra("metier",job.getText().toString());
        intentToSend.putExtra("service",serviceH.getSelectedItem().toString());
        intentToSend.putExtra("mail",mail_text.getText().toString());
        intentToSend.putExtra("tel", tel_text.getText().toString());
        intentToSend.putExtra("resume",resume_text.getText().toString());
        Log.d("MyLog",nom_text.getText().toString());
        startActivity(intentToSend);


    }



}
