package com.example.idrisadrien.appusers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by idrisadrien on 19/10/2017.
 */

public class ListUsersActivity extends AppCompatActivity{

    private UserDataSource userDataSource = new UserDataSource(this);
    private UserDAO userDAO = userDataSource.newUserDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        Intent intentAddOrDelete = getIntent();

        Boolean addIntent = intentAddOrDelete.getBooleanExtra("add",false);
        Boolean deleteIntent = intentAddOrDelete.getBooleanExtra("delete",false);
        Boolean modifyIntent = intentAddOrDelete.getBooleanExtra("modify", false);

        if(addIntent){
            Log.d("MyLog","Adding someone");
            String nom = intentAddOrDelete.getStringExtra("nom");
            String prenom= intentAddOrDelete.getStringExtra("prenom");
            String sexe = intentAddOrDelete.getStringExtra(" ");
            String metier = intentAddOrDelete.getStringExtra("metier");
            String service = intentAddOrDelete.getStringExtra("service");
            String mail = intentAddOrDelete.getStringExtra("mail");
            String tel = intentAddOrDelete.getStringExtra("tel");
            String resume = intentAddOrDelete.getStringExtra("resume");
            this.userDAO.create(new User((Integer) null, nom, prenom, sexe, metier, service, mail, tel, resume));
        }
        if(deleteIntent){
            Log.d("MyLog","Deleting someone");
            Integer idUserToDelete = intentAddOrDelete.getIntExtra("id",-1);
            this.userDAO.delete(new User(idUserToDelete,null,null,null,null,null,null,null,null));
        }
        if(modifyIntent){
            Log.d("MyLog","Modifying someone");
            Integer id = intentAddOrDelete.getIntExtra("id",-1);
            String nom = intentAddOrDelete.getStringExtra("nom");
            String prenom= intentAddOrDelete.getStringExtra("prenom");
            String sexe = intentAddOrDelete.getStringExtra(" ");
            String metier = intentAddOrDelete.getStringExtra("metier");
            String service = intentAddOrDelete.getStringExtra("service");
            String mail = intentAddOrDelete.getStringExtra("mail");
            String tel = intentAddOrDelete.getStringExtra("tel");
            String resume = intentAddOrDelete.getStringExtra("resume");
            this.userDAO.upDate(new User(id,nom,prenom,sexe,metier,service,mail,tel,resume));
        }
        this.printListUsers();
    }

    private void printListUsers(){
        List<User> newUsers = this.userDAO.readAll();

        ListView listUsers = (ListView) findViewById(R.id.list_users);
        final ArrayAdapter<User> adapter = new ArrayAdapter<User>(ListUsersActivity.this,
                android.R.layout.simple_list_item_1, newUsers);
        listUsers.setAdapter(adapter);

        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User item = adapter.getItem(position);
                Log.d("MyLog","Clicked on someone : " + item.toString());
                Intent intent = new Intent(ListUsersActivity.this, AddDeleteActivity.class);
                intent.putExtra("id",item.getId().toString());
                intent.putExtra("nom",item.getId().toString());
                intent.putExtra("prenom",item.getId().toString());
                intent.putExtra("sexe",item.getId().toString());
                intent.putExtra("metier",item.getId().toString());
                intent.putExtra("service",item.getId().toString());
                intent.putExtra("mail",item.getId().toString());
                intent.putExtra("tel", item.getId().toString());
                intent.putExtra("resume",item.getId().toString());
                startActivity(intent);
            }
        });
    }

    protected void buttonAddUser(View view){
        Log.d("MyLog","Clicked on add");
            Intent intent = new Intent(ListUsersActivity.this, AddDeleteActivity.class);
            intent.putExtra("id",-1);
            startActivity(intent);

    }

}
