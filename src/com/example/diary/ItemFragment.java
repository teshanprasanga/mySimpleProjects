package com.example.diary;

import java.io.Serializable;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diary.dummy.DummyContent;
import com.example.testfragment.R;

/**
 * A fragment representing a list of Items.
 * <p />
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ItemFragment extends ListFragment implements
		OnFragmentInteractionListener {

	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;

	private OnFragmentInteractionListener mListener;

	// TODO: Rename and change types of parameters
	public static ItemFragment newInstance(String param1, String param2) {
		ItemFragment fragment = new ItemFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}

		// TODO: Change Adapter to display your content
		// setListAdapter(new
		// ArrayAdapter<DummyContent.DiaryItem>(getActivity(),
		// android.R.layout.simple_list_item_1, android.R.id.text1,
		// DummyContent.ITEMS));
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnFragmentInteractionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		if (null != mListener) {
			// Notify the active callbacks interface (the activity, if the
			// fragment is attached to one) that an item has been selected.
			mListener
					.onFragmentInteraction(DummyContent.ITEMS.get(position).day);
		}
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		public void onFragmentInteraction(String id);
	}

	public void onStart() {
		super.onStart();

		// final Button btnReturnMonday = (Button) getActivity().findViewById(
		// R.id.btn);
		// btnReturnMonday.setOnClickListener(new View.OnClickListener() {
		// public void onClick(View v) {
		// Bundle bundle = new Bundle();
		// bundle.putString("dayOfTheWeek",
		// btnDay.getText().toString());
		// bundle.putSerializable("key", (Serializable) new
		// DummyContent());

		// DailyFragment dailyFragment = new DailyFragment();
		// dailyFragment.setArguments(bundle);

		// FragmentManager fragmentManager = getFragmentManager();
		// FragmentTransaction fragmentTransaction = fragmentManager
		// .beginTransaction();

		// fragmentTransaction.show(new DailyFragment());
		// fragmentTransaction.commit();

		// });

	}

	@Override
	public void onFragmentInteraction(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		Button btnReturn = new Button(getActivity());
		btnReturn.setText("Return to "
				+ getArguments().getString("dayOfTheWeek") + " Diary");
		
		btnReturn.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();

				
				 bundle.putString("dayOfTheWeek", getArguments().getString("dayOfTheWeek"));
			
				DailyFragment dailyFragment = new DailyFragment();
				dailyFragment.setArguments(bundle);
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager
						.beginTransaction();

				fragmentTransaction.replace(R.id.container, dailyFragment, "");
				fragmentTransaction.commit();
			}
		});

		getListView().addFooterView(btnReturn);

		setListAdapter(new ArrayAdapter<DummyContent.DiaryItem>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1,
				DummyContent.ITEMS));
	}
}
