package birthdaybook;

import java.security.KeyStore.Entry;

public class BirthdayBook {

	private final int MAX_CAPACITY = 10;
	private int noe;// number of entries, index for the next entry to be stored;
	private Entry[] entries;

	public BirthdayBook() {
		entries = new Entry[MAX_CAPACITY];
		noe = 0;
	}

	public int getNumberOfEntries() {
		// Common mistake is simply return entries.length //
		return noe;
	}

	public Entry[] getEntries() {
		// Common mistake is simply return entries //
		Entry[] es = new Entry[noe];
		// common mistake i<entries.length
		for (int i = 0; i < noe; i++) {
			// Entry e = entries[i];
			// es[i] = e other way to do it.
			es[i] = entries[i];
		}
		return es;
	}

	@Override
	public String toString() {
		String toReturn = "There are " + this.getNumberOfEntries() + " entries in the book\n";
		// for ( int i = 0; i < noe; i ++) {
		// toReturn += entries[i].toString();
		// toReturn += "\n";
		// }
		return toReturn;
	}

	@Override
	// 31-35
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		BirthdayBook other = (BirthdayBook) obj;
		boolean isEqual = this.getNumberOfEntries() == other.getNumberOfEntries();
		for (int i = 0; i < this.noe && isEqual; i++) {
			// here we re use the equals method
			// defined in the entry class
			isEqual = this.entries[i].equals(other.entries[i]);
		}
		return isEqual;
	}

	// helper method for nameExists
	private int indexOfName(String name) {
		int index = -1;
		// common mistake that i<entries.length
		for (int i = 0; i < noe; i++) {
			Entry e = entries[i];
			String n = e.getName();
			if (n.equals(name)) {
				return i;
			}
		}

		return index;
	}

	public boolean nameExists(String name) {
		//
		int index = indexOfName(name);
		return index >= 0;

	}


	public BirthDay getBirthday(String name) {
		int index = indexOfName(name);
		if (index >= 0) {
			Entry e = entries[index];
			BirthDay bdOfName = e.getBirthday();
			return bdOfName;
			// another way is
			// return entries[index].getBirthday();
		} else {
			return null;
		}
	}
	// Return an array of persons names each of which is born
	// on this particular birthday

	public String[] getReminders(BirthDay birthday) {
		// Step 1 Figure out how many people were born on 'birthday'
		int numberOfReminders= 0;
		for (int i = 0; i < noe; i++) {
			if (entries[i].getBirthday().equals(birthday)) {
				numberOfReminders++;
			}
		}
		// Step 2: Figure out how many people were born on 'Birthday'
		// and create an array of reminders size
		String[] reminders = new String[numberOfReminders];

		// Step 3: Pass entries array for second time and
		// Store all names that born on birthday
		int j = 0; // position in the reminders array
		for (int i = 0; i < noe; i++) {
			Entry e = entries[i];
			if (e.getBirthday().equals(birthday)) {
				reminders[j] = entries[i].getName();
				j++;
			}
		}
		return reminders;
	}

	public String[] getReminders(int month, int day) {
		// 1st way to do it
		BirthDay bd = new BirthDay(month, day);
		return getReminders(bd);
		// Second way to do it
		// return getReminders(new BirthDay(month, day));
	}

	public void removeEntry(String name) {
		int index = indexOfName(name);
		if (index < 0) {
			// names don't exist
			// nothing to remove
		} else {
			// remove the associated entry for name
			// Step 1: from position index to (noe-2)
			// shift every position to the left by 1
			for (int i = index; i < noe - 1; i++) {
				this.entries[i] = this.entries[i + 1];
			}
			// Step 2: Assign position entries[noe-1] to null
			this.entries[noe - 1] = null;
			// Decrement noe
			this.noe--;
		}
	}

	public void addEntry(String name, BirthDay birthday) {
		int index = indexOfName(name);
		if (index < 0) {// adding entry with some none existing name
			Entry ne = new Entry(name, birthday);
			entries[noe] = ne;
			noe++;
		} else {// adding entry with some existing name
			entries[index].setBirthday(birthday);
		}
	}

	public void addEntry(String name, int month, int day) {
		// have to create the birthday object so that
		// it can store the month, and day
		BirthDay birthday = new BirthDay(month, day);
		// the code below calls the method above.
		this.addEntry(name, birthday);
	}

}
