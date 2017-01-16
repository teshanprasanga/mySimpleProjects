
package com.example.diary;

import com.example.testfragment.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.content.DialogInterface;


public class NoOkDialogFragment extends DialogFragment {
	static NoOkDialogFragment newInstance(String title) {
		NoOkDialogFragment fragment = new NoOkDialogFragment();
		Bundle args = new Bundle();
		args.putString("title", title);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		String title = getArguments().getString("title");
		return new AlertDialog.Builder(getActivity())
				.setIcon(R.drawable.ic_launcher).setTitle(title)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						((MainActivity) getActivity()).noOkPositiveClick();
					}
				}).setNegativeButton("No",
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
					int whichButton) {
					((MainActivity)
					getActivity()).NoOkNeagativeClick();}}).create();

	}

}

