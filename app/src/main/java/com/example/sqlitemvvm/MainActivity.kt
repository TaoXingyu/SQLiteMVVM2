package com.example.sqlitemvvm

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: SQLiteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(SQLiteViewModel::class.java)
    }

    //method for saving records in database
    fun saveRecord(view: View){

        val status = viewModel.save(this, u_id, u_name, u_email)
        //val databaseHandler: DatabaseHandler= DatabaseHandler(this)

            //val status = databaseHandler.addEmployee(EmpModelClass(Integer.parseInt(id), name, email))
            if(status > -1){
                Toast.makeText(this,"record save",Toast.LENGTH_LONG).show()
                u_id.text.clear()
                u_name.text.clear()
                u_email.text.clear()
            }
        else{
            Toast.makeText(this,"id or name or email cannot be blank",Toast.LENGTH_LONG).show()
        }

    }

    //method for read records from database in ListView
    fun viewRecord(view: View){
       viewModel.view(this, listView)
    }

    //method for updating records based on user id
    fun updateRecord(view: View){
        viewModel.update(this, listView)
    }

    //method for deleting records based on id
    fun deleteRecord(view: View) {
        viewModel.delete(this,listView)

    }
}

