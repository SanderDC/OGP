import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * A class of oil tanks
 * 
 * @invar 	...
 * 			| isValidContent(this.getContent(),this.getCapacity())
 * @invar	...
 * 			| isValidCapacity(this.getCapacity())
 * 
 * @author Sander
 *
 */
public class OilTank {
	
	/**
	 * 
	 * @param content
	 * @param capacity
	 * @pre		...
	 * 			| isValidContent(content,capacity)
	 * @pre 	...
	 * 			| isValidCapacity(capacity)
	 * @post 	...
	 * 			| new.getCapacity() == capacity
	 * @post	...
	 * 			| new.getContent == content
	 */
	public OilTank(int content, int capacity){
		assert isValidCapacity(capacity);
		this.capacity = capacity;
		this.setContent(content); //setContent heeft zelf al preconditie dus assert moet hier niet meer
	}
	
	/**
	 * Returns the amount of oil in this oil tank
	 * @return
	 */
	@Basic
	public int getContent(){
		return this.content;
	}
	
	/**
	 * 
	 * @param content
	 * @pre 	...
	 * 			| isValidContent(content, this.getCapacity())
	 * @post	...
	 * 			| new.getContent() == content
	 */
	public void setContent(int content){
		assert isValidContent(content, this.getCapacity());
		this.content = content;
	}
	
	/**
	 * confer isValidCapacity
	 * @param content
	 * @return	...
	 * 			| result == (content >= 0) && (content <= capacity)
	 */
	public static boolean isValidContent(int content, int capacity){
		return (content >= 0) && (content <= capacity);
	}
	
	private int content;
	
	@Basic @Immutable
	public int getCapacity(){
		return this.capacity;
	}
	
	/**
	 * 
	 * @param capacity
	 * @return	...
	 * 			| if (capacity > 0)
	 * 			| 	then result == true
	 * 			|	else result == false
	 */
	public static boolean isValidCapacity(int capacity){
		return (capacity > 0);
	}
	
	private final int capacity;
	
	/**
	 * Fills this tank completely
	 * @post	...
	 * 			|new.getContent() == this.getCapacity()
	 */
	public void fillTank(){
		this.setContent(this.getCapacity());
	}
	
	/**
	 * Adds the specified amount of oil to the tank
	 * @pre		...
	 * 			| amount > 0
	 * @pre		...
	 * 			| isValidContent(this.getContent() + amount, this.getCapacity) //(wordt gecheckt bij setContent dus hier geen assert
	 * @post	...
	 * 			| new.getContent() == this.getContent() + amount
	 * @effect	...
	 * 			| this.setContent(this.getContent()+amount) (2de pre en post vallen hierdoor weg)
	 */
	public void fillTank(int amount){
		assert amount > 0;
		this.setContent(this.getContent() + amount);
	}
	
	/**
	 * 
	 * @param amounts
	 * @pre		...
	 * 			| amounts != null
	 * @pre		...
	 * 			| for each amount in amounts:
	 * 			|	amount > 0
	 * @pre		...
	 * 			| isValidContent(this.getContent() + sum(amounts), this.getCapacity()
	 * @post	...
	 * 			| new.getContent() = this.getContent() + sum(amounts)
	 */
	public void fillTank(int... amounts){
		assert amounts != null;
		for (int amount:amounts){
			this.fillTank(amount);
		}
	}

}
