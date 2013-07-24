package org.ananth.learning.mapper;



import org.ananth.learning.datatypes.RelationshipObject;
import org.ananth.learning.mapper.MutualFriend.MutualMapper;
import org.ananth.learning.mapper.MutualFriend.MutualReducer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;



public class MutualfriendsDriver extends Configured implements Tool{ 

	/**
	 * @param args  
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		ToolRunner.run(new MutualfriendsDriver(), null);
	}    
     
	@Override
	public int run(String[] arg0) throws Exception {
		Configuration conf = getConf();
		conf.set("fs.default.name", "file:///");
		conf.set("mapred.job.tracker", "local");
		conf.set("fs.file.impl", "org.ananth.learning.fs.WindowsLocalFileSystem");
		conf.set("io.serializations","org.apache.hadoop.io.serializer.JavaSerialization," 
	            + "org.apache.hadoop.io.serializer.WritableSerialization");
		
		Job job = new Job(conf,"Mutal Friends");	
		
		job.setJarByClass(MutualfriendsDriver.class);
		job.setMapperClass(MutualMapper.class);
		job.setReducerClass(MutualReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(RelationshipObject.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.addInputPath(job, new Path("input"));
		FileOutputFormat.setOutputPath(job, new Path("output"));
		job.waitForCompletion(Boolean.TRUE);
		return 0;
	}

}
