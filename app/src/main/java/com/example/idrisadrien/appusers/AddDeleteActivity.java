package com.example.idrisadrien.appusers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idrisadrien on 19/10/2017.
 */

public class AddDeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delete);

        Intent intentDelete = getIntent();
        Integer printUser = intentDelete.getIntExtra("id", -1);

        if(printUser!=-1){
            Log.d("MyLog", "Print clocked user, and delete/modify buttons");
            TextView add_button = (TextView) findViewById(R.id.add_button);
            TextView delete_button = (TextView) findViewById(R.id.delete_button);
            TextView modify_button = (TextView)findViewById(R.id.modify_button);

            add_button.setVisibility(View.GONE);
            delete_button.setVisibility(View.VISIBLE);
            modify_button.setVisibility(View.VISIBLE);


            EditText nom_text = (EditText)findViewById(R.id.nom_text);
            EditText prenom_text = (EditText)findViewById(R.id.prenom_text);
            RadioButton sexe_button = (RadioButton)findViewById(R.id.sexe_button);


            AutoCompleteTextView job = (AutoCompleteTextView)findViewById(R.id.job);
            Spinner serviceH = (Spinner)findViewById(R.id.serviceH);

            serviceH.setOnItemClickListener((AdapterView.OnItemClickListener) this);
            List<String> categories = new ArrayList<String>();
            categories.add("Cardiologie");
            categories.add("Radiologie");
            categories.add("Pediatrie");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            serviceH.setAdapter(dataAdapter);


            EditText mail_text = (EditText)findViewById(R.id.mail_text);
            EditText tel_text = (EditText)findViewById(R.id.tel_text);
            EditText resume_text = (EditText)findViewById(R.id.resume_text);

            String nom = intentDelete.getStringExtra("nom");
            String prenom= intentDelete.getStringExtra("prenom");
            String sexe = intentDelete.getStringExtra(" ");
            String metier = intentDelete.getStringExtra("metier");
            String service = intentDelete.getStringExtra("service");
            String mail = intentDelete.getStringExtra("mail");
            String tel = intentDelete.getStringExtra("tel");
            String resume = intentDelete.getStringExtra("resume");

            nom_text.setText(nom);
            prenom_text.setText(prenom);
            sexe_button.setText(sexe);
            job.setText(metier);
            serviceH.setText(service);
            mail_text.setText(mail);
            tel_text.setText(tel);
            resume_text.setText(resume);
            // sinon ajout d'un user
        } else {
            Log.d("MyLog","Interface to add user");
            TextView add_button = (TextView)findViewById(R.id.add_button);
            TextView delete_button = (TextView)findViewById(R.id.delete_button);
            TextView modify_button = (TextView)findViewById(R.id.modify_button);

            add_button.setVisibility(View.VISIBLE);
            delete_button.setVisibility(View.GONE);
            modify_button.setVisibility(View.GONE);
        }

    }


    protected void clickOnAdd(View view){
        Log.d("MyLog","Clicked on add");
        EditText nom_text = (EditText)findViewById(R.id.nom_text);
        EditText prenom_text = (EditText)findViewById(R.id.prenom_text);
        RadioButton sexe_button = (RadioButton)findViewById(R.id.sexe_button);
        AutoCompleteTextView job = (AutoCompleteTextView)findViewById(R.id.job);
        Spinner serviceH = (Spinner)findViewById(R.id.serviceH);
        EditText mail_text = (EditText)findViewById(R.id.mail_text);
        EditText tel_text = (EditText)findViewById(R.id.tel_text);
        EditText resume_text = (EditText)findViewById(R.id.resume_text);

        // sending Intent with "add"=true and fields for creation
        Intent intent = new Intent(AddDeleteActivity.this, ListUsersActivity.class);
        intent.putExtra("add",true);
        intent.putExtra("nom",nom_text.getText().toString());
        intent.putExtra("prenom",prenom_text.getText().toString());
        intent.putExtra("sexe",sexe_button.getText().toString());
        intent.putExtra("metier",job.getText().toString());
        intent.putExtra("service",serviceH.getText().toString());
        intent.putExtra("mail",mail_text.getText().toString());
        intent.putExtra("tel", tel_text.getText().toString());
        intent.putExtra("resume",resume_text.getText().toString());
        Log.d("MyLog",nom_text.getText().toString());
        startActivity(intent);
    }

    protected void clickOnDelete(View view){
        Log.d("MyLog","Clicked on delete");
        Intent intentReceived = getIntent();
        Integer idUserToDelete = intentReceived.getIntExtra("id", -1);
        Intent intentToSend = new Intent(AddDeleteActivity.this, ListUsersActivity.class);
        intentToSend.putExtra("delete",true);
        intentToSend.putExtra("id",idUserToDelete);
        startActivity(intentToSend);
    }

    protected void clickOnModify(View view){
        Log.d("MyLog","Clicked on modify");
        EditText nom_text = (EditText)findViewById(R.id.nom_text);
        EditText prenom_text = (EditText)findViewById(R.id.prenom_text);
        RadioButton sexe_button = (RadioButton)findViewById(R.id.sexe_button);
        AutoCompleteTextView job = (AutoCompleteTextView)findViewById(R.id.job);
        Spinner serviceH = (Spinner)findViewById(R.id.serviceH);
        EditText mail_text = (EditText)findViewById(R.id.mail_text);
        EditText tel_text = (EditText)findViewById(R.id.tel_text);
        EditText resume_text = (EditText)findViewById(R.id.resume_text);

        Intent intentReceived = getIntent();
        Integer idUserToModify = intentReceived.getIntExtra("id", -1);
        Intent intentToSend = new Intent(AddDeleteActivity.this, ListUsersActivity.class);
        intentToSend.putExtra("modify",true);
        intentToSend.putExtra("nom",nom_text.getText().toString());
        intentToSend.putExtra("prenom",prenom_text.getText().toString());
        intentToSend.putExtra("sexe",sexe_button.getText().toString());
        intentToSend.putExtra("metier",job.getText().toString());
        intentToSend.putExtra("service",serviceH.getText().toString());
        intentToSend.putExtra("mail",mail_text.getText().toString());
        intentToSend.putExtra("tel", tel_text.getText().toString());
        intentToSend.putExtra("resume",resume_text.getText().toString());
        Log.d("MyLog",nom_text.getText().toString());
        startActivity(intentToSend);


    }

}
