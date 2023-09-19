package com.example.exercice5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*private TextView txt;
    private Button btn;*/

    WebView w;
    WebViewClient webc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*txt = new TextView(this);
        txt.setText("vivre Teccart... les profs sont extraordinaires");
        //setContentView(txt);
        registerForContextMenu(txt);

        btn = new Button(this);
        btn.setText("Pop up me");
        btn.setLayoutParams(new ViewGroup.LayoutParams(200,200));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);
                MenuInflater m = popupMenu.getMenuInflater();
                m.inflate(R.menu.popmenu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.item1:
                                Log.i("test", "onMenuItemClick: 1");
                                return true;
                            case R.id.item2:
                                Log.i("test", "onMenuItemClick: 2");
                                return true;
                        }
                        return true;
                    }
                });
            }
        });

        setContentView(btn);*/

        w = (WebView) findViewById(R.id.web);
        w.getSettings().setJavaScriptEnabled(true);
        webc = new WebViewClient();
        w.setWebViewClient(webc);
        w.loadUrl("https://github.com/");

    }

    //Overrride la methode onCreateOptionMenu pour creer un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
       /* MenuItem mi1 = menu.add(Menu.NONE,Menu.FIRST,0,"VB.NET");
        MenuItem mi2 = menu.add(Menu.NONE,Menu.FIRST +1 ,1,"C#");
        MenuItem mi3 = menu.add(Menu.NONE,Menu.FIRST +2,2,"JAVA");
        MenuItem mi4 = menu.add(Menu.NONE,Menu.FIRST +3,3,"PHP");
        MenuItem mi5 = menu.add(Menu.NONE,Menu.FIRST+4,4,"ASP.NET");
        MenuItem mi7 = menu.add(Menu.NONE,Menu.FIRST+5,5,"Play musique");
        MenuItem mi6 = menu.add(Menu.NONE,Menu.FIRST+6,6,"Fermer l'application");*/

        MenuInflater minf = getMenuInflater();
        minf.inflate(R.menu.menu,menu);

        MenuItem toto = menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"TOTO");
        MenuItem titi = menu.add(Menu.NONE,Menu.FIRST + 1 ,Menu.NONE,"TITI");
        SubMenu tata = menu.addSubMenu("TATA");//ajouter un sous menu au menu tata
        tata.add("sous-menu-1");//ajouter
        SubMenu tutu = menu.addSubMenu("TUTU");
        tutu.add("sous-menu-2");

        return true;
    }

    //override la methode onOptionItemSelected pour creer les evenements lors du click sur les item
    //dans le menu
   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
       /* Intent i;
        switch (item.getItemId())
        {
            case Menu.FIRST:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/"));
                startActivity(i);
                return true;
            case Menu.FIRST + 1:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://translate.google.com/"));
                startActivity(i);
                return true;
            case Menu.FIRST + 2:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/"));
                startActivity(i);
                return true;
            case Menu.FIRST + 3:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            case Menu.FIRST + 4:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            case Menu.FIRST + 5:
                //je programme apres pour ecouter de la musique
                return true;
            case Menu.FIRST + 6:
                System.exit(0);
                return true;
        }
        return true;
    }*/

    //override la methode oncreateContextMenu pour creer un menu contextuelle lors du click sur la un context 3sec
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Mon premier menu contextuelle");
        menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"Item 1");
        menu.add(Menu.NONE,Menu.FIRST + 1,Menu.NONE,"Item 2").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            //pour ajouter un evenement onclicklistnner a un item du menu
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                //setIntent(this,//AutreActivite.class);
                Log.i("test", "sa marche: ");
                return false;
            }
        });

        menu.add(Menu.NONE,Menu.FIRST + 2,Menu.NONE,"Item 3");

        menu.setGroupCheckable(1,true,true);
    }

}