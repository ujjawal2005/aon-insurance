package com.org.aon.to;

public class Customer {

    private String postcode;
    private String occupation;
    private int turnover;

    public Customer(String postcode,String occupation, int turnover) {
        this.postcode = postcode;
        this.occupation = occupation;
        this.turnover = turnover;
    }

    

    public String getPostcode() {
		return postcode;
	}



	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}



	public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public int getTurnover() {
		return turnover;
	}



	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}



	@Override
    public String toString() {
        return "Person: { postcode=\"" + postcode + "\"" + ", occupation=" + occupation + "\"" + ", turnover=" + turnover + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Customer that = (Customer) o;
        return this.turnover == that.turnover && this.occupation.equals(that.occupation) && this.postcode.equals(that.postcode);
    }

    @Override
    public int hashCode() {
        int result = postcode.hashCode() + occupation.hashCode();
        result = 31 * result + turnover;
        return result;
    }
}
