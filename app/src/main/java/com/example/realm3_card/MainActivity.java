package com.example.realm3_card;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<RealmCard> mCards;
    RealmCardAdapter mCardAdapter;
    ListView mListView;
    String test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.listView);
        mCards = new ArrayList<RealmCard>();
        test = "test1";

//        mCards.add(new Card(R.drawable.icon1,getString(R.string.walk_title),
//                getString(R.string.walk_content),getString(R.string.walk_meaning)));

        mCardAdapter = new RealmCardAdapter(this,R.layout.realm_card,mCards);
        mListView.setAdapter(mCardAdapter);

    }
}
