

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;


public class TestTitleCountMapper {
	MapDriver<Object, Text, Text, IntWritable> mapDriver;
	@Before
	public void setUp(){
		TopTitles.TitleCountMap mapper = new TopTitles.TitleCountMap();
		mapDriver = MapDriver.newMapDriver(mapper);
		Configuration conf = mapDriver.getConfiguration();
		conf.set("stopwords","stopwords.txt");
		conf.set("delimiters","delimiters.txt");
	}
	@Test
	public void processValidRecord() throws IOException{
		Text value = new Text("Sea_of_dust");
		mapDriver.withInput(new LongWritable(),value);
		mapDriver.withOutput(new Text("sea"),new  IntWritable(1));
		mapDriver.withOutput(new Text("dust"),new  IntWritable(1));
		mapDriver.runTest();
	}
}
