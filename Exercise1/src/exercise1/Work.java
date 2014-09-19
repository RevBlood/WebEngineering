package exercise1;

public abstract class Work {

	private String WorkName;
	
	public Work(String Work) {
		this.WorkName = Work;
	}
	
	
	public String getWorkName(){
		return WorkName;
	}
	
	public void setWorkName(String WorkName) {
		this.WorkName = WorkName;
	}
	

	
}
