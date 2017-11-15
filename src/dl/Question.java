package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Question database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q"),
@NamedQuery(name="Question.findAppField", query="SELECT q FROM Question q WHERE q.appField= :appField")
})
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idQuestion;

	private byte answer;

	private String appField;

	private String opt1;

	private String opt2;

	private String opt3;

	private String opt4;

	private int weight1;

	private int weight2;

	private int weight3;

	private int weight4;

	private String wording;

	public Question() {
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public byte getAnswer() {
		return this.answer;
	}

	public void setAnswer(byte answer) {
		this.answer = answer;
	}

	public String getAppField() {
		return this.appField;
	}

	public void setAppField(String appField) {
		this.appField = appField;
	}

	public String getOpt1() {
		return this.opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return this.opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return this.opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return this.opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public int getWeight1() {
		return this.weight1;
	}

	public void setWeight1(int weight1) {
		this.weight1 = weight1;
	}

	public int getWeight2() {
		return this.weight2;
	}

	public void setWeight2(int weight2) {
		this.weight2 = weight2;
	}

	public int getWeight3() {
		return this.weight3;
	}

	public void setWeight3(int weight3) {
		this.weight3 = weight3;
	}

	public int getWeight4() {
		return this.weight4;
	}

	public void setWeight4(int weight4) {
		this.weight4 = weight4;
	}

	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

}