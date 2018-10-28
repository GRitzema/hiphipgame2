package game;

/**
 * Riddle.java
 * 
 * Class to represent the monsters' and sphinxes' riddles.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class Riddle {

	/**
	 * The riddle's question.
	 */
	private String question;
	
	/**
	 * The riddle's answer.
	 */
	private String answer;
	
	/**
	 * Constructor.
	 * @param question: the riddle's question.
	 * @param answer: the riddle's answer.
	 */
	public Riddle(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	/**
	 * Getter method for the riddle's question.
	 * @return the question.
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Setter method for the riddle's question.
	 * @param question: the riddle's question.
	 * POSTCONDITION: the riddle's question is now changed.
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Getter method for the riddle's answer.
	 * @return the answer.
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Setter method for the riddle's answer.
	 * @param question: the riddle's answer.
	 * POSTCONDITION: the riddle's answer is now changed.
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}		
}
