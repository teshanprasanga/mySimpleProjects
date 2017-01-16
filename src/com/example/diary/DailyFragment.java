package com.example.diary;

import java.util.Calendar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.diary.dummy.DummyContent;
import com.example.testfragment.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class DailyFragment extends Fragment {
	String dayofTheWeek;

	public DailyFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		// EditText dateTime=(EditText)
		// getActivity().findViewById(R.id.txtDateTime);
		// String dtValue = this.getArguments().getString("dayOfTheWeek");
		// dateTime.setText(dtValue);

		return inflater.inflate(R.layout.fragment_monday, container, false);
	}

	public void onStart() {
		super.onStart();
		// Inflate the layout for this fragment

		Calendar cal = Calendar.getInstance();
		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		// 24 hour format
		int hourofday = cal.get(Calendar.HOUR_OF_DAY);
		int dayofyear = cal.get(Calendar.DAY_OF_YEAR);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int dayofmonth = cal.get(Calendar.DAY_OF_MONTH);

		final String currentDateTime = dayofmonth + "/" + month + "/" + year
				+ " " + hourofday + ":" + minute;

		final TextView txtDayOfTheWeek = (TextView) getActivity().findViewById(
				R.id.txtdayoftheweek);
		
		txtDayOfTheWeek.setText(getArguments().getString("dayOfTheWeek")
				+ " current date and time");

		final EditText dateTime = (EditText) getActivity().findViewById(
				R.id.txtDateTime);
		final EditText entryText = (EditText) getActivity().findViewById(
				R.id.txtDiaryEnrty);
		dateTime.setText(currentDateTime);
		// String dtValue = this.getArguments().getString("dayOfTheWeek");
		// dateTime.setText(dtValue);

		final Button btnSave = (Button) getActivity()
				.findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putString("dayOfTheWeek", getArguments().getString("dayOfTheWeek"));
				DummyContent diary = (DummyContent) getArguments()
						.getSerializable("key");

				diary.ITEMS.add(new DummyContent.DiaryItem("Monday", entryText
						.getText().toString(), currentDateTime));

				// d.setDayOftheWeek("Monday");
				// d.setEntryText(entryText.getText().toString());
				// d.setEntryTime(currentDateTime);
				// diary.ITEMS.add(arg0)

				// Toast.makeText(getActivity().getApplicationContext(),
				// diary.getEntryList().get(0).getEntryText(),
				// Toast.LENGTH_LONG).show();

			}
		});

		final Button btnShowAll = (Button) getActivity().findViewById(
				R.id.btnshowall);
		btnShowAll.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ItemFragment listFragment = new ItemFragment();
				// MondayListFragment listFragment=new MondayListFragment();
				Bundle bundle = new Bundle();
				bundle.putString("dayOfTheWeek", getArguments().getString("dayOfTheWeek"));
				listFragment.setArguments(bundle);
				try {
					FragmentManager fragmentManager = getFragmentManager();
					FragmentTransaction fragmentTransaction = fragmentManager
							.beginTransaction();

					fragmentTransaction.replace(R.id.container, listFragment,
							"");
					fragmentTransaction.commit();

					// Toast.makeText(getActivity().getApplicationContext(),
					// "lll",
					// Toast.LENGTH_LONG).show();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		/* move to home frgment on home button click */
		Button btnHome = (Button) getActivity().findViewById(R.id.btnhome_daily);
		btnHome.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

				HomeFragment homeFragment = new HomeFragment();
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager
						.beginTransaction();

				fragmentTransaction.replace(R.id.container, homeFragment,
						"");
				fragmentTransaction.commit();

			}
		});

	}
}
