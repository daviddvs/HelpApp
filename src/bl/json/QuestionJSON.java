package bl.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuestionJSON {
	@XmlElement
	private int idQuestion;
	
	@XmlElement
	private byte answer;
	
	@XmlElement
	private String appField;
	
	@XmlElement
	private String opt1;

	@XmlElement
	private String opt2;

	@XmlElement
	private String opt3;

	@XmlElement
	private String opt4;

	@XmlElement
	private int weight1;

	@XmlElement
	private int weight2;

	@XmlElement
	private int weight3;

	@XmlElement
	private int weight4;

	@XmlElement
	private String wording;
	
	public QuestionJSON() {
		
	}
	
	public QuestionJSON(int idQuestion, byte answer, String appField, String opt1, String opt2, String opt3, String opt4, 
			int weight1, int weight2, int weight3, int weight4, String wording ) {
		this.idQuestion=idQuestion;
		this.answer=answer;
		this.appField=appField;
		this.opt1=opt1;
		this.opt2=opt2;
		this.opt3=opt3;
		this.opt4=opt4;
		this.weight1=weight1;
		this.weight2=weight2;
		this.weight3=weight3;
		this.weight4=weight4;
		this.wording=wording;
	}
	
	public int getIdQuestion() {
		return this.idQuestion;
	}
	public void seIdQuestion(int idQuestion) {
		this.idQuestion=idQuestion;
	}
	public byte getAnswer() {
		return this.answer;
	}
	public void setAnswer(byte answer) {
		this.answer=answer;
	}
	public String getAppField() {
		return this.appField;
	}
	public void setAppfiel(String appField) {
		this.appField=appField;
	}
	public String getOpt1() {
		return this.opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1=opt1;
	}
	public String getOpt2() {
		return this.opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2=opt2;
	}
	public String getOpt3() {
		return this.opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3=opt3;
	}
	public String getOpt4() {
		return this.opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4=opt4;
	}
	public int getWeight1() {
		return this.weight1;
	}
	public void setWeight1(int weight1) {
		this.weight1=weight1;
	}
	public int getWeight2() {
		return this.weight2;
	}
	public void setWeight2(int weight2) {
		this.weight2=weight2;
	}
	public int getWeight3() {
		return this.weight3;
	}
	public void setWeight3(int weight3) {
		this.weight3=weight3;
	}
	public int getWeight4() {
		return this.weight4;
	}
	public void setWeight4(int weight4) {
		this.weight4=weight4;
	}
	public void setWording(String wording) {
		this.wording=wording;
	}
	public String getWording() {
		return this.wording;
	}
/*
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
	}*/

}
