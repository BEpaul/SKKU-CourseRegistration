
public class BA extends Student{
	// major : business administration
	int sumBA;
	int remCredit;
	int useCredit;
		
	public BA(int sumBA, int useCredit, int remCredit) {
		super();
		this.sumBA = sumBA;
		this.remCredit = remCredit;
		this.useCredit = useCredit;
	}

	@Override
	public int calculateCredit() {
		remCredit = sumBA - useCredit;
		
		return remCredit;
	}
}
