package com.acme.ethereum.android.signer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String SIGN_INTENT = "de.petendi.ethereum.android.action.SIGN_TRANSACTION";
    private static final String EXTRA_TRANSACTION = "transaction";
    private static final String EXTRA_SENDER = "sender";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(!SIGN_INTENT.equals(intent.getAction())) {
            Toast.makeText(this,"Unknown intent " + intent,Toast.LENGTH_LONG).show();
            finish();
        }
        String transaction = intent.getStringExtra(EXTRA_TRANSACTION);
        String sender = intent.getStringExtra(EXTRA_SENDER);
        Log.d(TAG,"transaction to sign: " + transaction);
        Log.d(TAG,"expected sender: " + sender);
        Toast.makeText(this,"TODO sign me " + transaction,Toast.LENGTH_LONG).show();
    }

    //TODO call this with the hex encoded signed transaction String (0x....)
    private void signingSucceeded(String signedTransaction) {
        Intent result = new Intent();
        result.putExtra(EXTRA_TRANSACTION,signedTransaction);
        setResult(RESULT_OK,result);
        finish();
    }
}
