package com.app.DatabaseSample;
import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CheckData extends ListActivity  {     
	TextView selection;
	public int idToModify; 
	DataManipulator dm;

	List<String[]> list = new ArrayList<String[]>();
	List<String[]> names2 =null ;
	String[] stg1;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check);
		  dm = new DataManipulator(this);
	      names2 = dm.selectAll();

		stg1=new String[names2.size()]; 

		int x=0;
		String stg;

		for (String[] name : names2) {
			stg = name[1]+" - "+name[2]+ " - "+name[3]+" - "+name[4];

			stg1[x]=stg;
			x++;
		}


		ArrayAdapter<String> adapter = new ArrayAdapter<String>(   
				this,android.R.layout.simple_list_item_1,   
				stg1);
        this.setListAdapter(adapter);
		selection=(TextView)findViewById(R.id.selection);

	}      

	public void onListItemClick(ListView parent, View v, int position, long id) {
		selection.setText(stg1[position]);
	}


}
