package common;

public class Score {
	private final String competitorName;
	private final String discipline;
	private final int result;

	public Score(String competitorName, String discipline, int result) {
		this.competitorName = competitorName;
		this.discipline = discipline;
		this.result = result;
	}

	public String getCompetitorName() {
		return competitorName;
	}

	public String getDiscipline() {
		return discipline;
	}

	public double getResult() {
		return result;
	}

}
