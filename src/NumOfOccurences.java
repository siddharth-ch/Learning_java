import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class NumOfOccurences {

    public static void main(String[] args) {
	String[] s = { "abc", "xyz", "abc", "xyz", "abc", "ert" };
	oneMethod(s);
    }

    private static Set sort(Set<Entry<String, Integer>> set) {
	TreeSet<Entry<String, Integer>> set2 = new TreeSet<Entry<String, Integer>>(
		new Comparator<Entry<String, Integer>>() {
		    @Override
		    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			int i = o1.getValue().compareTo(o2.getValue());
			return -i;
		    }
		});

	set2.addAll(set);
	return set2;
    }

    private static void oneMethod(String[] s) {
	Set<String> set = new HashSet<String>(Arrays.asList(s));
	HashMap<String, Integer> map = new HashMap<String, Integer>(set.size());
	int i = 0;
	for (String st : s) {
	    if (set.contains(st)) {
		i = (map.get(st) == null) ? 0 : (Integer) map.get(st);
		map.put(st, ++i);
	    }
	}
	System.out.println(map.toString());
	set = sort(map.entrySet());
	System.out.println(set.toString());

    }
}
