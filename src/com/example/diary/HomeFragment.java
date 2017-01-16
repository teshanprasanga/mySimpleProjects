package com.example.diary;

import java.io.Serializable;

import com.example.diary.dummy.DummyContent;
import com.example.testfragment.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
/*initail hone screen of the system where 5 buttons for days of the week*/
public class HomeFragment extends Fragment {

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container,
				false);

		return rootView;
	}

	public void onStart() {
		super.onStart();
		 Button btnMonday = (Button) getActivity().findViewById(
				R.id.btnmonday);
		 Button btnTuesday = (Button) getActivity().findViewById(
				R.id.btntuesday);
		 Button btnWednesday = (Button) getActivity().findViewById(
				R.id.btnWednesday);
		 Button btnThursday = (Button) getActivity().findViewById(
				R.id.btnthursday);
		 Button btnFriday = (Button) getActivity().findViewById(
				R.id.btnfriday);
		
		btnMonday.setOnClickListener(onClickListener);
		btnTuesday.setOnClickListener(onClickListener);
		btnWednesday.setOnClickListener(onClickListener);
		btnThursday.setOnClickListener(onClickListener);
		btnFriday.setOnClickListener(onClickListener);
		
				
	}
	private Button.OnClickListener onClickListener = new Button.OnClickListener(){
		public void onClick(View v) {
			Bundle bundle = new Bundle();
			bundle.putString("dayOfTheWeek", ((Button)getActivity().findViewById( v.getId())).getText().toString());
			bundle.putSerializable("key", (Serializable) new DummyContent());
					
			
			DailyFragment dailyFragment = new DailyFragment();
			dailyFragment.setArguments(bundle);

			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();

			fragmentTransaction.replace(R.id.container, dailyFragment, "");
			fragmentTransaction.commit();

		}
	};
}
