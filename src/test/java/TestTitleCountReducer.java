import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;


public class TestTitleCountReducer {
	ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
	@Before
	public void setUp(){
		TopTitles.TitleCountReduce reducer = new TopTitles.TitleCountReduce();
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
		Configuration conf = reduceDriver.getConfiguration();
		conf.set("stopwords","stopwords.txt");
		conf.set("delimiters","delimiters.txt");
	}
	@Test
	public void testReduceSum() throws IOException{
		reduceDriver.withInput(new Text("student"),Arrays.asList(new IntWritable(1),new IntWritable(1)));
		reduceDriver.withOutput(new Text("student"),new IntWritable(2));
		reduceDriver.runTest();
	}

}
