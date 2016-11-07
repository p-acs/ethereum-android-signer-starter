# Ethereum Android Signer

This repository contains a starter to write a signer for the Ethereum Android wallet.

# Integration steps

## Register the Intent filter

Put this filter in the ```AndroidManifest.xml```

      <intent-filter>
        <action android:name="de.petendi.ethereum.android.action.SIGN_TRANSACTION" />
        <category android:name="android.intent.category.DEFAULT" />
      </intent-filter>

## Read the Intent extras

The wallet will send the hexencoded unsigned transaction and  the expected sender of the transaction as Intent extras:

     String transaction = intent.getStringExtra("transaction");
     String sender = intent.getStringExtra("sender");

Example values:

    transaction = "0xef83100000850ba43b740082520894a2a9143a910e641f81715c87a0172c9554bfec44888ac7230489e8000080808080";
    sender = "0x1a86c013a6b2f29e18b4ad75df0c25813a936b69";

## Sign the transaction

Now is your turn :-)

Some ideas:

- integrate a hardware wallet over NFC, Bluetooth and/or USB
- keep the private key on a well protected server, connect to it e.g. via VPN and let the transaction get signed there

At the end you should have the signed hex encoded transaction String.

Signing the above transaction with the expected sender key would result in this output:

    String signedTransaction = 0xf86f83100000850ba43b740082520894a2a9143a910e641f81715c87a0172c9554bfec44888ac7230489e80000801ca02d736b8da41512753a303776517ff259a0c6f9386b1fe2b69f9050e74b6046eba0567d15ae2c9ee28483b0f89b5a49d413888246c61d298bbb6b88cd78cab2dc4f


## Provide the signed transaction back to the wallet

Put the signed transaction as result and close the Activity after marking it with ```RESULT_OK```

    Intent result = new Intent();
    result.putExtra("transaction",signedTransaction);
    setResult(RESULT_OK,result);
    finish();


# Questions/Feedback

Contact us via our Support Portal https://ethereum-android.com



























