package au.radsoft.openastext;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.text.Html;
import android.os.Bundle;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;

public class OpenAsText extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        Intent origIntent = getIntent();
		
        Intent newIntent = new Intent(origIntent.getAction());
        //if (origIntent.getCategories() != null)
        //{
            //for (String category : origIntent.getCategories())
                //newIntent.addCategory(category);
        //}
		newIntent.setDataAndType(origIntent.getData(), "text/plain");
        newIntent.setFlags(origIntent.getFlags());
        if (origIntent.getExtras() != null)
            newIntent.putExtras(origIntent.getExtras());
        
        try
        {
            startActivity(newIntent);
            finish();
        }
        catch (android.content.ActivityNotFoundException e)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, android.R.style.Theme_DeviceDefault));
            builder.setTitle(R.string.app_name);
            //builder.setMessage(R.string.no_text_editor_message);
            builder.setMessage(Html.fromHtml(getResources().getString(R.string.no_text_editor_message)));
            //builder.setIcon(R.drawable.text);
            builder.setPositiveButton(android.R.string.ok, null); // TODO should callback call finish?
            AlertDialog d = builder.create();
            d.show();
            ((TextView) d.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}

