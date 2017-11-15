package bl.json;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class QuestionsJSON {
	
	@XmlElement(name="questions")
	private List<QuestionJSON> questions;
	
	
	
	public QuestionsJSON() {
	}
	
	public QuestionsJSON(List<QuestionJSON> questions) {
		this.questions=questions;		
	}
	
	public List<QuestionJSON> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<QuestionJSON> questions) {
		this.questions = questions;
	}	

}
