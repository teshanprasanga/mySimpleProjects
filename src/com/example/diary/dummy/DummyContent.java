package com.example.diary.dummy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*holding the content for items list, the internal object to store data*/
public class DummyContent implements Serializable {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DiaryItem> ITEMS = new ArrayList<DiaryItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DiaryItem> ITEM_MAP = new HashMap<String, DiaryItem>();

	static {
		// Add 3 sample items.
		// addItem(new DiaryItem("1", "Item 1",""));
		// addItem(new DiaryItem("2", "Item 2",""));
		// addItem(new DiaryItem("3", "Item 3",""));
	}

	public static void addItem(DiaryItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.day, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DiaryItem {
		public String day;
		public String entryText;
		public String entryTime;

		public DiaryItem(String day, String entryText, String entryTime) {
			this.day = day;
			this.entryText = entryText;
			this.entryTime = entryTime;
		}

		@Override
		public String toString() {
			return entryTime + "\n" + entryText;
		}
	}
}
