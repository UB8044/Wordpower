package com.example.tugas;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SimpleDateFormat dateFormatter;
    private TextView dateResult;

    Button daftar, back;
    EditText FN, SN, TL, Tgl, Telp, Email, Pass, Pass2;

    private void showDateDialog(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar date = Calendar.getInstance();
                date.set(year, month, dayOfMonth);

                dateResult.setText(dateFormatter.format(date.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateResult = (TextView) findViewById(R.id.editTglLahir);
        Tgl = (EditText) findViewById(R.id.editTglLahir);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateResult = (TextView) findViewById(R.id.editTglLahir);
        Tgl = (EditText) findViewById(R.id.editTglLahir);
        Tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        daftar = findViewById(R.id.btnDaftar);
        back = findViewById(R.id.btnBack);
        FN = findViewById(R.id.editFN);
        SN = findViewById(R.id.editSN);
        TL = findViewById(R.id.editTmptLahir);
        Telp = findViewById(R.id.editTlpn);
        Email = findViewById(R.id.editEmail);
        Pass = findViewById(R.id.editPass);
        Pass2 = findViewById(R.id.editPass2);
        JK = findViewById(R.id.jenisKelamin);
        Agama = findViewById(R.id.agama);

        final Pattern passPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#&.;?])(?=\\S+$).{8,}$");

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_name = FN.getText().toString();
                String second_name = SN.getText().toString();
                String tempat_lahir = TL.getText().toString();
                String tanggal_lahir = dateResult.getText().toString();
                String telepon = Telp.getText().toString();
                String email = Email.getText().toString();
                String password = Pass.getText().toString();
                String password2 = Pass.getText().toString();
                int jKelamin = JK.getCheckedRadioButtonId();
                RadioButton jk = findViewById(jKelamin);

                if (first_name.isEmpty()){
                    FN.setError("Nama Depan Harus Diisi");
                    FN.requestFocus();
                    SN.setError("Nama Belakang Harus Diisi");
                    SN.requestFocus();
                    TL.setError("Tempat Lahir Harus Diisi");
                    TL.requestFocus();
                    Tgl.setError("Tanggal Lahir Harus Diisi");
                    Tgl.requestFocus();
                    Tgl.setError("Tanggal Lahir Harus Diisi");
                    Tgl.requestFocus();
                    Telp.setError("Nomor Telepon Harus Diisi");
                    Telp.requestFocus();
                    Email.setError("Email Harus Diisi");
                    Email.requestFocus();
                    Pass.setError("Password Harus Diisi");
                    Pass.requestFocus();

                } else if (second_name.isEmpty()){
                    SN.setError("Nama Belakang Harus Diisi");
                    SN.requestFocus();
                    TL.setError("Tempat Lahir Harus Diisi");
                    TL.requestFocus();
                    Tgl.setError("Tanggal Lahir Harus Diisi");
                    Tgl.requestFocus();
                    Tgl.setError("Tanggal Lahir Harus Diisi");
                    Tgl.requestFocus();
                    Telp.setError("Nomor Telepon Harus Diisi");
                    Telp.requestFocus();
                    Email.setError("Email Harus Diisi");
                    Email.requestFocus();
                    Pass.setError("Password Harus Diisi");
                    Pass.requestFocus();

                } else if (tempat_lahir.isEmpty()){
                    TL.setError("Tempat Lahir Harus Diisi");
                    TL.requestFocus();
                    Tgl.setError("Tanggal Lahir Harus Diisi");
                    Tgl.requestFocus();
                    Telp.setError("Nomor Telepon Harus Diisi");
                    Telp.requestFocus();
                    Email.setError("Email Harus Diisi");
                    Email.requestFocus();
                    Pass.setError("Password Harus Diisi");
                    Pass.requestFocus();

                } else if (tanggal_lahir.isEmpty()){
                    Tgl.setError("Tanggal Lahir Harus Diisi");
                    Tgl.requestFocus();
                    Telp.setError("Nomor Telepon Harus Diisi");
                    Telp.requestFocus();
                    Email.setError("Email Harus Diisi");
                    Email.requestFocus();
                    Pass.setError("Password Harus Diisi");
                    Pass.requestFocus();

                } else if (telepon.isEmpty()){
                    Telp.setError("Nomor Telepon Harus Diisi");
                    Telp.requestFocus();
                    Email.setError("Email Harus Diisi");
                    Email.requestFocus();
                    Pass.setError("Password Harus Diisi");
                    Pass.requestFocus();

                } else if (email.isEmpty()){
                    Email.setError("Email Harus Diisi");
                    Email.requestFocus();
                    Pass.setError("Password Harus Diisi");
                    Pass.requestFocus();

                } else if (password.isEmpty()){
                    Pass.setError("Password Harus Diisi");
                    Pass.requestFocus();

                }
                else if (!password.matches(String.valueOf(passPattern))) {
                    Pass.setError("Panjang password minimal adalah 8 karakter dengan angka, huruf besar, huruh kecil dan spesial karakter (seperti: @,&amp;,#,?");
                    Pass.requestFocus();

                }
                else if (!password2.equals(password)) {
                    Pass2.setError("Password Harus Sama");
                    Pass2.requestFocus();

                } else {
                    confirm(v);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    public void confirm(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setTitle("Konfirmasi...");
        alertDialogBuilder.setMessage("Apakah data yang anda masukkan sudah benar?");

        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this,"Pendaftaran Selesai",Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    RadioGroup JK, Agama;

    public void radioButtonJK(View v){
        setContentView(R.layout.activity_main);
        boolean cek = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.btnL:
                if (cek){
                    break;
                }
            case R.id.btnP:
                if (cek){
                    break;
                }
        }
    }

    public void radioButtonAgama(View v){
        boolean cek = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.islam:
                if (cek){
                    break;
                }
            case R.id.katolik:
                if (cek){
                    break;
                }
            case R.id.buddha:
                if (cek){
                    break;
                }
            case R.id.other:
                if (cek){
                    break;
                }
            case R.id.kristen:
                if (cek){
                    break;
                }
            case R.id.hindu:
                if (cek){
                    break;
                }
            case R.id.konghucu:
                if (cek){
                    break;
                }
        }
    }
}
