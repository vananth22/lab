package org.ananth.learning.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class CliqueMR {
	
	
	public static class CliqueMapper extends Mapper<LongWritable, Text, Text, Text> {
		
		
		
	}
	
	
	public static class CliqueReducer extends Reducer<Text, Text, Text, IntWritable> {
		
		
		
	}
	

}
