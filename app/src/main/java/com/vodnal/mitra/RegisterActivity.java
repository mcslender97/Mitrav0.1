package com.vodnal.mitra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.util.Range;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    //The view objects
    private EditText editTextName, editTextEmail, editTextMobile,
            editTextPassword,editTextRePassword,editTextAddress,editTextAge;

    private Button buttonRegister;

    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //initializing view objects
        editTextName = (EditText) findViewById(R.id.et_name);
        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextPassword = (EditText) findViewById(R.id.et_password);
        editTextRePassword = (EditText) findViewById(R.id.et_repassword);
        editTextMobile = (EditText) findViewById(R.id.editTextMobile);
        editTextAddress = (EditText) findViewById(R.id.et_address);
        buttonRegister = (Button) findViewById(R.id.btn_register);

        // adding validation to the edittexts
        awesomeValidation.addValidation(this, R.id.et_name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.et_email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.et_password, ".{8,}", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.et_repassword, ".{8,}", R.string.passworderror);
        //awesomeValidation.addValidation(this, R.id.editTextMobile, "^\\+(?:[0-9] ?){6,14}[0-9]$", R.string.mobileerror);
        //awesomeValidation.addValidation(this, R.id.et_address, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.addresserror);
        //awesomeValidation.addValidation(this, R.id.editTextAge, Range.extend(12, 60), R.string.invalid_age);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextPassword.getText().toString().equalsIgnoreCase(editTextRePassword.getText().toString())) {
                    if (awesomeValidation.validate()) {
                        callRegister();
                      //  startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"password and confirm password are not matched",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void callRegister(){
        try{
            //getting the user from the response
            //creating a new user object
            RegisterUser user = new RegisterUser(
                    101,
                    editTextName.getText().toString(),
                    editTextEmail.getText().toString(),
                    editTextPassword.getText().toString(),
                    editTextMobile.getText().toString(),
                    editTextAddress.getText().toString(),
                    editTextAge.getText().toString()
            );

            SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
            //starting the profile activity
            Toast.makeText(getApplicationContext(), "Successfully registered the user!", Toast.LENGTH_SHORT).show();
            //go to main screen
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);
                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                //creating a new user object
                                RegisterUser user = new RegisterUser(
                                        userJson.getInt("id"),
                                        userJson.getString("username"),
                                        userJson.getString("email"),
                                        userJson.getString("password"),
                                        userJson.getString("mobileNum"),
                                        userJson.getString("address"),
                                        userJson.getString("age")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", editTextName.getText().toString());
                params.put("email", editTextEmail.getText().toString());
                params.put("password", editTextPassword.getText().toString());
                params.put("mobileNum", editTextMobile.getText().toString());
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

}
