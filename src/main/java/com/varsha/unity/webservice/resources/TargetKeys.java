package com.varsha.unity.webservice.resources;

public class TargetKeys {
	
	    int number;
	    String keyword;
	    
	    public TargetKeys() { }
	    
	    public TargetKeys(int number, String keyword){
	    	this.number=number;
	    	this.keyword=keyword;
	    }

	    @Override
		public String toString() {
			return "TargetKeys [number=" + number + ", keyword=" + keyword + "]";
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		} 
}