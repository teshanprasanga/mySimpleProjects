package com.example.diary;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.diary.ItemFragment.OnFragmentInteractionListener;
import com.example.diary.dummy.DummyContent;
import com.example.testfragment.R;

public class MainActivity extends Activity implements
		OnFragmentInteractionListener,
		com.example.diary.ProfileFragment.OnFragmentInteractionListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			/*transit to initial screen*/
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();

			fragmentTransaction.replace(R.id.container, new HomeFragment(), "");
			fragmentTransaction.commit();

		}
		/*assign databse values to internal arraylistobject */
		if (DummyContent.ITEMS.size() != 0) {
			DBAdapter db = new DBAdapter(this);
			db.open();
			Cursor c = db.getAllContacts();
			if (c.moveToFirst()) {
				do {
					DummyContent.ITEMS.add(new DummyContent.DiaryItem(c
							.getString(1), c.getString(2), c.getString(3)));
				} while (c.moveToNext());
			}
			db.close();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return super.onCreateOptionsMenu(menu);

	}

	/* tracking android phone back button pressed event */

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.menuprofile) {
			/*loading profile information*/
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();

			fragmentTransaction.replace(R.id.container, new ProfileFragment(),
					"");
			fragmentTransaction.commit();

		}
		if (id == R.id.menusave) {

			/* saving data to the databse */
			try {
				DBAdapter db = new DBAdapter(this);

				// Toast.makeText(getApplicationContext(),String.valueOf(
				// DiaryContent.ITEMS.size()), Toast.LENGTH_LONG).show();
				// ---add diary items
				for (int i = 0; i < DummyContent.ITEMS.size(); i++) {
					db.open();
					long id1 = db.insertContact(DummyContent.ITEMS.get(i).day,
							DummyContent.ITEMS.get(i).entryTime,
							DummyContent.ITEMS.get(i).entryText);

					db.close();
					if (id1 != -1) {
						Toast.makeText(getApplicationContext(),
								"Error on saving databse", Toast.LENGTH_LONG)
								.show();
					} else {
						Toast.makeText(getApplicationContext(),
								"Saving  database", Toast.LENGTH_LONG).show();

					}

				}

			} catch (Exception ex) {

				ex.printStackTrace();
			}

		}
		if (id == R.id.menusaveall) {

			NoOkDialogFragment dialogFragment = NoOkDialogFragment
					.newInstance("Save entries to DB first");
			dialogFragment.show(getFragmentManager(), "dialog");
		}

		return super.onOptionsItemSelected(item);
	}

	public void okCancelPositiveClick() {

		// /Toast.makeText(getApplicationContext(), "jjj", Toast.LENGTH_LONG);

	}

	public void okCancelNegativeClick() {

		// Toast.makeText(getApplicationContext(), "jjj", Toast.LENGTH_LONG);

	}

	public void NoOkPositiveClick() {

		// Toast.makeText(getApplicationContext(), "jjj", Toast.LENGTH_LONG);

	}

	/* catch event of back button pressed and responds though the dialog boxes */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

			NoOkDialogFragment dialogFragment = NoOkDialogFragment
					.newInstance("Save entries to DB first");
			dialogFragment.show(getFragmentManager(), "dialog");

			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	/* exit application without any saving to sql database */
	public void NoOkNeagativeClick() {

		this.finish();

	}

	/* Saving data to sql database on back button pressed */
	public void noOkPositiveClick() {
		/* save to sql database */

		// Toast.makeText(getApplicationContext(),
		// String.valueOf(DummyContent.ITEMS.size()), Toast.LENGTH_LONG);

	}

	public void insertToDatabase() {

		DBAdapter db = new DBAdapter(this);
		// ---add a contact---
		db.open();
		// long id =
		// db.insertContact("Wei-Meng Lee","weimenglee@learn2develop.net");
		// id = db.insertContact("Mary Jackson", "mary@jackson.com");
		db.close();
	}

	@Override
	public void onFragmentInteraction(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFragmentInteraction(Uri uri) {
		// TODO Auto-generated method stub

	}

	/**
	 * A placeholder fragment containing a simple view.
	 */

}
