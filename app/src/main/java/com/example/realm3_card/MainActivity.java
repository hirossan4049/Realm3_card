package com.example.realm3_card;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity {
    List<RealmCard> mCards;
    RealmCardAdapter mCardAdapter;
    ListView mListView;
    String test;
    public Realm realm;
    EditText number_edit;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.listView);
        number_edit = (EditText)findViewById(R.id.number_edit);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        mCards = new ArrayList<RealmCard>();
        test = "test1";

        realm = Realm.getDefaultInstance();
//        mCards = realm.(RealmCard.copyFrom)
//       mCards = realm.copyFromRealm(realm.where(RealmCard.class).findAll());

//        mCards.add(new Card(R.drawable.icon1,getString(R.string.walk_title),
//                getString(R.string.walk_content),getString(R.string.walk_meaning)));

        mCardAdapter = new RealmCardAdapter(this,R.layout.realm_card,mCards);
        mListView.setAdapter(mCardAdapter);

    }

    @Override
    public void button(View v){
        final Realm realm = Realm.getDefaultInstance();  // Realmをインスタンス化
        final Friend friend = new Friend();  // Friendテーブルをインスタンス化
        friend.setName(args.getString("name"));
        friend.setAddress(args.getString("address"));
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealmOrUpdate(friend);  // PrimaryKeyに設定した値が既に存在していれば更新し、無ければ新規登録
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();  // データベース操作が終了する時には必ずclose()させる事！
                Toast.makeText(getContext(), args.getString("name") + "さんを登録しました", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); // Fragmentを閉じる
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                realm.close();  // データベース操作が終了する時には必ずclose()させる事！
                Toast.makeText(getContext(), "登録に失敗しました", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
