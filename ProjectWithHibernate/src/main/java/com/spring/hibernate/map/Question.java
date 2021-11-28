package com.spring.hibernate.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;

	private String qstn;

	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQstn() {
		return qstn;
	}

	public void setQstn(String qstn) {
		this.qstn = qstn;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question(int questionId, String qstn, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.qstn = qstn;
		this.answers = answers;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
//	one to one mapping k lie neeche wala code

//	@OneToOne
//	@JoinColumn(name = "a_id")
//	private Answer answer;

//	public Answer getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}

//	public Question(int questionId, String question, Answer answer) {
//		super();
//		this.questionId = questionId;
//		this.question = question;
//		this.answer = answer;
//	}

}
