package amrutraibagi.DataDrivenFromExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TestSample {

	public static void main(String[] args) throws IOException {
		dataDriven d=new dataDriven();
		ArrayList<String> data=d.getData("Demo", "Delete Profile");
		Iterator value=data.iterator();
		value.next();
		while(value.hasNext()) {
			System.out.println(value.next());
		}

	}

}
