package Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instagramclone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
     EditText Fullname;
     EditText Email;
     EditText Pass;
     EditText Mobile_no;
     EditText Birth;
     Button   Register;
     TextView Reglogin;

     FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        Register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validate()) {
                    //upload the data to the database
                    String Email_id = Email.getText().toString().trim();
                    String Password = Pass.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(Email_id, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(register.this, " Registeration Successful ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, MainActivity.class));
                            } else {
                                Toast.makeText(register.this, " Registeration Failed ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        Reglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this, MainActivity.class));
            }
        });
    }

    private void setupUIViews() {

        Fullname = findViewById(R.id.fullname);
        Email = findViewById(R.id.email_id);
        Pass = findViewById(R.id.password);
        Birth = findViewById(R.id.dob);
        Mobile_no = findViewById(R.id.mobile);
        Register = findViewById(R.id.submit);
        Reglogin = findViewById(R.id.reglogin);
    }

    private Boolean Validate() {
        Boolean result = false;
        String Name = Fullname.getText().toString();
        String Password = Pass.getText().toString();
        String Email_id = Email.getText().toString();
        String Mobile = Mobile_no.getText().toString();

        if (Name.isEmpty() || Password.isEmpty() || Email_id.isEmpty() || Mobile.isEmpty()) {
            Toast.makeText(this, "Please Enter All The Details ", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }
}