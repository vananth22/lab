package org.ananth.learning.mapper;

import java.io.IOException;

import org.ananth.learning.datatypes.RelationshipObject;
import org.ananth.learning.util.KeySortBuilder;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;




public class MutualFriend {
	
	public static class MutualMapper extends Mapper<LongWritable, Text, Text, RelationshipObject> {
		
		private final Long positiveCount = new Long("1");
		private final Long negativeCount = new Long("-1");		
		
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			
			String line = value.toString();
			String extractText[] = line.split(" ");
			if (extractText == null || extractText.length < 2)
				return;

			String friendKey = extractText[0].trim();
			String friendsList[] = extractText[1].split(",");
			
			for (String friend : friendsList) {
				
				context.write(new KeySortBuilder(friendKey, friend).build(),
								this.getRelationshipObject(Boolean.FALSE));
			}
			
			for (String friend : friendsList) {

				for (String suggestion : friendsList) {
					
					if(!friend.equalsIgnoreCase(suggestion)) {
					
						context.write(
								new KeySortBuilder(friend, suggestion).build(),
								this.getRelationshipObject(Boolean.TRUE));
					}

				}

			}
		}
		
		
		private final RelationshipObject getRelationshipObject(final Boolean type) {
			
			final RelationshipObject relationshipObject = new RelationshipObject();		
			if(type) {
				relationshipObject.setCount(positiveCount);
				relationshipObject.setIsAlreadyFriends(Boolean.FALSE);
			} else {
				relationshipObject.setCount(negativeCount);
				relationshipObject.setIsAlreadyFriends(Boolean.TRUE);
			}
			
			return relationshipObject;
		}
		
		
	}
	
	
	public static class MutualReducer extends Reducer<Text, RelationshipObject, Text, IntWritable> {
		
		public void reduce(Text key, Iterable<RelationshipObject> values,
				Context context) throws IOException, InterruptedException {

			int sum = 0;
			int count = 0;

			for (RelationshipObject relationship : values) {
				
				
				if (relationship == null) {
					return;
				}
			
				if (relationship.getIsAlreadyFriends().booleanValue()) {
					count += 1;
					break;
				}

				sum += 1;
			}
			if(count == 0) {
				context.write(key, new IntWritable(sum));
			}

		}
		
		
	}

}
