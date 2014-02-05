// @author Andrew Gulla (100395486)
package ca.uoit.AndrewGulla.mycalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

//Only activated once error message string has been passed through to this class. 
//Brings up dialog allowing the user to 'continue' upon click
public class DivideByZero{
	public DivideByZero(Activity activity, String notification){
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setMessage(notification).setCancelable(false).setPositiveButton("Continue", new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int id) {
				dialog.dismiss();
			}
		});
		
		AlertDialog error = builder.create();
		error.show();
	}	
}