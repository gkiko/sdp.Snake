import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

public class StatTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		try {
			PrintWriter f = new PrintWriter("top5.txt");
			f.println("name1 5");
			f.println("name2 4");
			f.println("name3 3");
			f.println("name4 2");
			f.flush();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		File f = new File("top5.txt");
		f.delete();
	}

	@Test
	public void testGetTop5NotNull() {
		ArrayList<String> s = Stat.getTop5List();
		assertNotNull(s);
	}

	@Test
	public void testGetTop5ValidateSize() {
		ArrayList<String> s = Stat.getTop5List();
		assertTrue(s.size() == 5);
	}
	
	@Test
	public void testGetTop5ValidateValues() {
		ArrayList<String> s = Stat.getTop5List();
		assertTrue(s.get(0).equals("name1 5"));
		assertTrue(s.get(1).equals("name2 4"));
		assertTrue(s.get(2).equals("name3 3"));
		assertTrue(s.get(3).equals("name4 2"));
		assertTrue(s.get(4).equals("empty 0"));
	}
	
	
	@Test
	public void testSaveAddTo5th(){
		Stat.save(1, "name11");
		ArrayList<String> s = Stat.getTop5List();
		assertTrue(s.get(0).equals("name1 5"));
		assertTrue(s.get(1).equals("name2 4"));
		assertTrue(s.get(2).equals("name3 3"));
		assertTrue(s.get(3).equals("name4 2"));
		assertTrue(s.get(4).equals("name11 1"));
	}
	
	@Test
	public void testSaveAddTo3th(){
		Stat.save(3, "name11");
		ArrayList<String> s = Stat.getTop5List();
		assertTrue(s.get(0).equals("name1 5"));
		assertTrue(s.get(1).equals("name2 4"));
		assertTrue(s.get(2).equals("name3 3"));
		assertTrue(s.get(3).equals("name11 3"));
		assertTrue(s.get(4).equals("name4 2"));
	}

	@Test
	public void testSaveAddTo1th(){
		Stat.save(11, "name11");
		ArrayList<String> s = Stat.getTop5List();
		assertTrue(s.get(0).equals("name11 11"));
		assertTrue(s.get(1).equals("name1 5"));
		assertTrue(s.get(2).equals("name2 4"));
		assertTrue(s.get(3).equals("name3 3"));
		assertTrue(s.get(4).equals("name4 2"));
	}

	@Test
	public void testSaveDoNotAdd(){
		Stat.save(0, "name11");
		ArrayList<String> s = Stat.getTop5List();
		assertTrue(s.get(0).equals("name1 5"));
		assertTrue(s.get(1).equals("name2 4"));
		assertTrue(s.get(2).equals("name3 3"));
		assertTrue(s.get(3).equals("name4 2"));
		assertTrue(s.get(4).equals("empty 0"));
	}

	
}
