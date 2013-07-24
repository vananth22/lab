package org.ananth.learning.datatypes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.WritableComparable;

/**
 * This is the relational Object which will hold the status of each friends
 * 
 * @author Ananth
 * 
 */

public class RelationshipObject implements
		WritableComparable<RelationshipObject>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long count;
	private Boolean isAlreadyFriends;
	
	public RelationshipObject() {
		super();
	}
   
	

	public void readFields(DataInput arg0) throws IOException {
		System.out.println(arg0.readBoolean());
		this.count = arg0.readLong();
		this.isAlreadyFriends = arg0.readBoolean();
		
		/*this.count.readFields(arg0);
		this.isAlreadyFriends.readFields(arg0); */

	}

	public void write(DataOutput output) throws IOException {
		output.writeLong(count);
		output.writeBoolean(isAlreadyFriends);
		
	
	}

	public int compareTo(RelationshipObject object) {
		int cmp = count.compareTo(object.count);
		if (cmp != 0) {
			return cmp;
		}
		return isAlreadyFriends.compareTo(object.isAlreadyFriends);

	}

	

	public Long getCount() {
		return count;
	}



	public void setCount(Long count) {
		this.count = count;
	}



	public Boolean getIsAlreadyFriends() {
		return isAlreadyFriends;
	}



	public void setIsAlreadyFriends(Boolean isAlreadyFriends) {
		this.isAlreadyFriends = isAlreadyFriends;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime
				* result
				+ ((isAlreadyFriends == null) ? 0 : isAlreadyFriends.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelationshipObject other = (RelationshipObject) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (isAlreadyFriends == null) {
			if (other.isAlreadyFriends != null)
				return false;
		} else if (!isAlreadyFriends.equals(other.isAlreadyFriends))
			return false;
		return true;
	}

}
