package org.techtown.woorim;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private String userID;
    private String userPassword;
    private String userEmail;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



       final EditText idText = (EditText)findViewById(R.id.idText);
       final EditText passwordText = (EditText)findViewById(R.id.passwordText);
       final EditText emailText = (EditText)findViewById(R.id.emailText);
       final Button validateButton = (Button)findViewById(R.id.validateButton);





       validateButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               userID = idText.getText().toString();
               if(validate){
                   return;
               }
               if (userID.equals("")) {        //아무것도 적지 않고 중복체크 버튼을 누른 경우
                   AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                   dialog = builder.setMessage("아이디는 빈 칸일 수 없습니다.")
                           .setPositiveButton("확인", null)
                           .create();
                   dialog.show();
                   return;
               }

               Response.Listener<String> responseListener = new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {       //response 매개변수
                        try{
                           JSONObject jsonResponse = new JSONObject(response);            //jsonResponse 변수에 response 값 할당
                           boolean success = jsonResponse.getBoolean("success");
                           if(success){
                               AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                               dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
                                       .setPositiveButton("확인", null)
                                       .create();
                               dialog.show();
                               idText.setEnabled(false);          //아이디입력창 비활성화
                               validate = true;                   //중복없음, 사용가능
                               idText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                               validateButton.setBackgroundColor(getResources().getColor(R.color.colorGray));
                           }
                           else{
                               AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                               dialog = builder.setMessage("사용할 수 없는 아이디입니다.")
                                       .setNegativeButton("확인", null)
                                       .create();
                               dialog.show();
                           }
                       }
                       catch (Exception e){
                           e.printStackTrace();
                       }
                   }
               };
               ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);       //???
               RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
               queue.add(validateRequest);
           }
       });




       Button registerButton = (Button)findViewById(R.id.registerButton);



       registerButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               userID = idText.getText().toString();
               userPassword = passwordText.getText().toString();
               userEmail = emailText.getText().toString();
               if(!validate){                                                                                 //중복체크가 완료되지 않은 경우
                   AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                   dialog = builder.setMessage("먼저 중복 체크를 해주세요.")
                           .setNegativeButton("확인", null)
                           .create();
                   dialog.show();
                   return;
               }
               if (userID.equals("") || userPassword.equals("") || userEmail.equals("")){                    //아이디, 비번, 이메일 중 한개라도 빈칸인 경우
                   AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                   dialog = builder.setMessage("빈 칸 없이 입력해 주세요")
                           .setNegativeButton("확인", null)
                           .create();
                   dialog.show();
                   return;
               }
               Response.Listener<String> responseListener = new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       try{
                           JSONObject jsonResponse = new JSONObject(response);
                           boolean success = jsonResponse.getBoolean("success");
                           if(success){
                               AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);

                               dialog = builder.setMessage("회원 등록에 성공했습니다.")
                                       .setPositiveButton("확인", null)
                                       .create();
                               dialog.show();
                               finish();
                           }
                           else{
                               AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                               dialog = builder.setMessage("회원 등록에 실패했습니다.")
                                       .setNegativeButton("확인", null)
                                       .create();
                               dialog.show();
                           }
                       }
                       catch (Exception e){
                           e.printStackTrace();
                       }
                   }


               };
               RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userEmail, responseListener);
               RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
               queue.add(registerRequest);
           }
       });

    }


    protected  void onStop(){
        super.onStop();
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }
    }
}
