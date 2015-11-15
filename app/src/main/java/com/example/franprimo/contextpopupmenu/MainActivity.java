package com.example.franprimo.contextpopupmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creo un array con los elementos del listViev
        String[] opcionesLista = {"Fran", "Alba", "Alejandro", "Laia"};
        //Como hay que pasarle una lista, convierto el array en un arraylist
        ArrayList<String> listaMenu = new ArrayList<String>(Arrays.asList(opcionesLista));
        //Le paso los datos al menuadapter
        MenuAdapter adapter = new MenuAdapter(this, listaMenu);
        //Creo y declaro el listViev y le paso el adapter
        final ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        //metodo necesario para poder usar los menus contextuales. Le paso el listView
        registerForContextMenu(lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        //Con este codigo intento obtener el nombre del item seleccionado pero no consigo
        //pasarlo como Header al xml para que aparezca como titulo.
        /*
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menu;

        name = ((TextView) info.targetView).getText().toString();

        menu.setHeaderTitle(name);
        menu.add(0, v.getId(), 0, "Mostrar");
        menu.add(0, v.getId(), 0, "Eliminar");
        */

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    //Con este metodo se que elemento he seleccionado
    public boolean onContextItemSelected(MenuItem item){
        Toast t;

        switch (item.getItemId()){
            case R.id.item1:
                t = Toast.makeText(getBaseContext(), ": Has seleccionado mostrar", Toast.LENGTH_LONG);
                t.show();
                return true;
            case R.id.item2:
                t =  Toast.makeText(getBaseContext(), "Has seleccionado eliminar", Toast.LENGTH_LONG);
                t.show();
                return true;
        }
        return false;
    }
}
