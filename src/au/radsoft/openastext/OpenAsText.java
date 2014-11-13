package au.radsoft.openastext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class OpenAsText extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        Intent origIntent = getIntent();
		
        Intent newIntent = new Intent(origIntent.getAction());
        if (origIntent.getCategories() != null)
        {
            //for (String category : origIntent.getCategories())
                //newIntent.addCategory(category);
        }
		newIntent.setDataAndType(origIntent.getData(), "text/plain");
        newIntent.setFlags(origIntent.getFlags());
        if (origIntent.getExtras() != null)
            newIntent.putExtras(origIntent.getExtras());
        
        startActivity(newIntent);
		finish();
    }
}

