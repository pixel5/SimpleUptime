package com.pixel5.simpleuptime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;

import android.util.Log;
import android.widget.RemoteViews;

public class SUActivity extends AppWidgetProvider {
	
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    final int N = appWidgetIds.length;
    Log.i("SimpleUptime",  "Updating widgets " + Arrays.asList(appWidgetIds));
    for (int i = 0; i < N; i++) {
      int appWidgetId = appWidgetIds[i];
      RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
      views.setTextViewText(R.id.uptime, getUptime());
      appWidgetManager.updateAppWidget(appWidgetId, views);
      
    }
  }
  
private String getUptime() {
	// TODO Auto-generated method stub
	String styledUptime = "";
	String html = "";
	try {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        try {
				request.setURI(new URI("http://pixel5.co/uptime/uptime.php"));
			} catch (URISyntaxException e) {  
				return "Error getting Uptime."; }
			

        HttpResponse response = client.execute(request);
        BufferedReader in = new BufferedReader(new InputStreamReader(
        response.getEntity().getContent()));
        StringBuffer phpOutput = new StringBuffer("");
        String line;
        while ((line = in.readLine()) != null) {
            phpOutput.append(line);
        }
        in.close();

        html = phpOutput.toString();
        styledUptime = parseUptime(html);
        
        
        
    } 
    catch (MalformedURLException e) {
    	return "Malformed Exception";
    } 
	catch (IOException e) {
		e.printStackTrace();
		return "IO Exception";
    }
	return styledUptime;
}

private String parseUptime(String html) {
	// TODO Auto-generated method stub
	String styledUptime = html;
	styledUptime = styledUptime.replaceAll("<pre> ","");
	styledUptime = styledUptime.replaceAll("</pre>","");
	
	String[] uptimeArray = styledUptime.split(", ");
	String[] loadAvgSplit = uptimeArray[3].split(": ");
	String finalUptime = uptimeArray[0] + "\n" + "Load Averages: " + loadAvgSplit[1] + ", " + uptimeArray[4] + ", " + uptimeArray[5];
	
	return finalUptime;
}
}