import java.io.IOException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTopTitleMapper {
	MapDriver<Text, Text, NullWritable, TopTitles.TextArrayWritable> mapDriver;

	@Before
	public void setUp() {
		TopTitles.TopTitlesMap mapper = new TopTitles.TopTitlesMap();
		mapDriver = MapDriver.newMapDriver(mapper);
		Configuration conf = mapDriver.getConfiguration();
		conf.set("N", "2");
	}

	@Test
	public void processRecord() throws IOException {
		mapDriver.withInput(new Text("student"), new Text("2"));
		mapDriver.withInput(new Text("professor"), new Text("2"));
		mapDriver.withInput(new Text("school"), new Text("1"));
		mapDriver.withInput(new Text("answer"), new Text("3"));
		List<Pair<NullWritable, TopTitles.TextArrayWritable>> result = mapDriver
				.run();
		assertEquals(new Text("(2, student)"), (Text) result.get(0).getSecond()
				.get()[0]);
		assertEquals(new Text("(3, answer)"), (Text) result.get(0).getSecond()
				.get()[1]);

	}

}
