
public class CS extends Student{
	// major : computer science 
	int sumCS;
	int useCredit;
	int remCredit;
	

	
	public CS(int sumCS, int useCredit, int remCredit) {
		super();
		this.sumCS = sumCS;
		this.useCredit = useCredit;
		this.remCredit = remCredit;
	}


	@Override
	public int calculateCredit() {
		remCredit = sumCS - useCredit;
		
		return remCredit;
	}
	
}
