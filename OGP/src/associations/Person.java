package associations;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * A class of persons involving a gender and a marital status.
 * 
 * @invar Each person can have its gender as gender. 
 *        | canHaveAsGender(this.getGender())
 * @invar The spouse of each person must be a valid spouse for any person.
 *        | isValidSpouse(this.getSpouse()) &&
 *        | (this.getSpouse() == null) ||
 *        |		this == (this.getSpouse().getSpouse())
 * 
 * @author bachelor ingenieur et al.
 * @version 1.0
 */
public class Person {


	/**
	 * Initialize this new person with given gender.
	 * 
	 * @param gender
	 *            The gender for this new person.
	 * @post The gender of this new person is equal to the given gender. |
	 *       new.getGender() == gender
	 * @throws IllegalArgumentException
	 *             This new person cannot have the given gender as its gender. |
	 *             ! canHaveAsGender(this.getGender())
	 */
	public Person(Gender gender) throws IllegalArgumentException {
		if (!canHaveAsGender(gender))
			throw new IllegalArgumentException();
		this.gender = gender;
	}
	
	public void terminate(){
		this.divorce();
		this.terminated = true;
	}
	
	public boolean isTerminated(){
		return this.terminated ;
	}
	
	private boolean terminated = false;

	/**
	 * Return the gender of this person.
	 */
	@Basic
	@Raw
	@Immutable
	public Gender getGender() {
		return this.gender;
	}

	/**
	 * Check whether this person can have the given gender as its gender.
	 * 
	 * @param gender
	 *            The gender to check.
	 * @return | result == (gender == Gender.MALE) || (gender == Gender.FEMALE)
	 */
	@Raw
	public boolean canHaveAsGender(Gender gender) {
		return ((gender == Gender.MALE) || (gender == Gender.FEMALE));
	}

	/**
	 * Variable registering the gender of this person.
	 */
	private final Gender gender;

	/**
	 * @invar The spouse of each person must be a valid spouse for any person. |
	 *        isValidSpouse(getSpouse())
	 */

	/**
	 * Initialize this new person with given spouse.
	 * 
	 * @param spouse
	 *            The spouse for this new person.
	 * @pre The given spouse must be a valid spouse for any person. |
	 *      isValidSpouse(spouse)
	 * @post The spouse of this new person is equal to the given spouse. |
	 *       new.getSpouse() == spouse
	 */
//	public Person(Person spouse) {
//		this.setSpouse(spouse);
//	}

	/**
	 * Return the spouse of this person.
	 */
	@Basic
	@Raw
	public Person getSpouse() {
		return this.spouse;
	}

	/**
	 * Check whether the given spouse is a valid spouse for any person.
	 * 
	 * @param spouse
	 *            The spouse to check.
	 * @return | result ==
	 */
	public boolean isValidSpouse(Person spouse) {
		if (spouse == null)
			return true;
		if (this.isTerminated())
			return spouse == null;
		if (spouse.isTerminated())
			return false;
		return (!(this.getGender() == spouse.getGender()));
	}
	
	public boolean isMarried(){
		return (this.getSpouse() != null);
	}
	
	/**
	 * 
	 * @param spouse
	 * @post	...
	 * 			| (new this).getSpouse() == spouse
	 * @post	...
	 * 			| (new spouse).getSpouse() == this
	 * @throws	NullPointerException
	 * 			...
	 * 			| spouse == null
	 * @throws	IllegalArgumentException
	 * 			...
	 * 			| ! isValidSpouse(spouse)
	 * @throws	IllegalStateException
	 * 			...
	 * 			| (this.isMarreid()) || (spouse.isMarried())
	 */
	public void marry(Person spouse) throws IllegalArgumentException, IllegalStateException{
		if (! isValidSpouse(spouse))
			throw new IllegalArgumentException();
		if (this.isMarried() || spouse.isMarried())
			throw new IllegalStateException();
		this.setSpouse(spouse);
		spouse.setSpouse(this);
	}
	
	/**
	 * Divorces the persons in question
	 * @post	...
	 * 			| ! (new this).isMarried()
	 * @post	...
	 * 			| if this.isMarried()
	 * 			| then ! (new this.getSpouse()).isMarried()
	 */
	public void divorce(){
		Person spouse = this.getSpouse();
		if (spouse == null)
			return;
		else {
			this.setSpouse(null);
			spouse.setSpouse(null);
		}
	}
	
	/**
	 * Set the spouse of this person to the given spouse.
	 * 
	 * @param spouse
	 *            The new spouse for this person.
	 * @pre The given spouse must be a valid spouse for any person. |
	 *      isValidSpouse(spouse)
	 * @post The spouse of this person is equal to the given spouse. |
	 *       new.getSpouse() == spouse
	 */
	@Raw
	private void setSpouse(@Raw Person spouse) {
		assert isValidSpouse(spouse);
		this.spouse = spouse;
	}

	/**
	 * Variable registering the spouse of this person.
	 */
	private Person spouse;
}
