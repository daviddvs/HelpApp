package bl.json;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SolutionJSON {
	@XmlElement
	private int question;
	
	@XmlElement
	private int score;
	
	@XmlElement
	private String date;
	
	public SolutionJSON() {
		
	}
	
	public SolutionJSON(int question, int score, String date) {
		this.question=question;
		this.score=score;
		this.date=date;
	}
	
	public int getQuestion() {
		return this.question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}	

}
