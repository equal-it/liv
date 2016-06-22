package Properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteFilterProp {

		public static void main(String[] args) {
			try {
				Properties properties = new Properties();
				properties.setProperty("kevin", "kesselfliker");
				properties.setProperty("leber", "straﬂe");
				properties.setProperty("berlin", "berlin");

				File file = new File("test.properties");
				FileOutputStream fileOut = new FileOutputStream(file);
				properties.store(fileOut, "iche");
				fileOut.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();


		}
	}
}
