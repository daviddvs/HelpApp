package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Solution database table.
 * 
 */
@Entity
@NamedQuery(name="Solution.findAll", query="SELECT s FROM Solution s")
public class Solution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSolution;

	private String date;

	private int score;

	//uni-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="question")
	private Question questionBean;

	public Solution() {
	}

	public int getIdSolution() {
		return this.idSolution;
	}

	public void setIdSolution(int idSolution) {
		this.idSolution = idSolution;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Question getQuestionBean() {
		return this.questionBean;
	}

	public void setQuestionBean(Question questionBean) {
		this.questionBean = questionBean;
	}

}