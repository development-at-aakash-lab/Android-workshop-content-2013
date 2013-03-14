package in.mihirgokani.aworkshop.animationdemo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Mihir Gokani
 * @created 26-Feb-2013 12:57:55 AM
 * 
 * This class just holds references to other activities 
 * so that it can show them in a list and start them.
 * 
 * NOTE: No need to go into detail here. Explore other java classes! 
 */
public class MainActivity extends Activity {

    private final LinkedHashMap<String, Class> listItems = new LinkedHashMap<String, Class>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems.put("Canvas Demo 1", CanvasDemo1.class);
        listItems.put("Canvas Demo 2", CanvasDemo2.class);
        listItems.put("Canvas Demo 3a", CanvasDemo3a.class);
        listItems.put("Canvas Demo 3b", CanvasDemo3b.class);
        listItems.put("Canvas Demo 3c", CanvasDemo3c.class);
        listItems.put("Canvas Demo 4a", CanvasDemo4a.class);
        listItems.put("Canvas Demo 4b", CanvasDemo4b.class);
        listItems.put("Canvas Demo 4c", CanvasDemo4c.class);
        listItems.put("Animator Demo 1a", AnimatorDemo1a.class);
        listItems.put("Animator Demo 1b", AnimatorDemo1b.class);
        listItems.put("Animator Demo 1c", AnimatorDemo1c.class);
        listItems.put("Animator Demo 2", AnimatorDemo2.class);
        listItems.put("Animator Demo 3a", AnimatorDemo3a.class);
        listItems.put("Animator Demo 3b", AnimatorDemo3b.class);
        listItems.put("Animator Demo 3c", AnimatorDemo3c.class);

        final ArrayList<String> keys = new ArrayList<String>(listItems.keySet());

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, keys));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                    int position, long id) {
                startActivity(new Intent(MainActivity.this, listItems.get(keys
                        .get(position))));
            }
        });
    }

}
