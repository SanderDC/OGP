package associations.stockMarket;

import java.util.*;

import associations.banking.money.MoneyAmount;
import associations.banking.products.Purchase;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class of shares involving a current price, ...
 * 
 * @invar  The current price of each share must be a valid current price for any
 *         share.
 *         | isValidCurrentPrice(getCurrentPrice())
 *
 * @author  ...
 * @version 1.0
 */
public class Share {

	/**
	 * Initialize this new share with given current price.
	 * 
	 * @param  currentPrice
	 *         The current price for this new share.
	 * @post   If the given current price is a valid current price for any
	 *         share, the current price of this new share is equal
	 *         to the given current price. Otherwise, the current price of this
	 *         new share is equal to MoneyAmount.ZERO.
	 *       | if (isValidCurrentPrice(currentPrice))
	 *       |   then new.getCurrentPrice() == currentPrice
	 *       |   else new.getCurrentPrice() == MoneyAmount.ZERO
	 */
	@Raw
	public Share(MoneyAmount currentPrice) {
		if (!isValidCurrentPrice(currentPrice))
			currentPrice = MoneyAmount.ZERO;
		setCurrentPrice(currentPrice);
	}
	
	/**
	 * Return a boolean indicating whether or not this share
	 * is terminated.
	 */
	@Basic
	@Raw
	public boolean isTerminated() {
		return this.isTerminated;
	}

	/**
	 * Terminate this share.
	 *
	 * @post    This share is terminated.
	 *          | new.isTerminated()
	 */
	public void terminate() {
		// To be completed.
		this.isTerminated = true;
	}

	/**
	 * Variable registering whether this person is terminated.
	 */
	private boolean isTerminated;

	/**
	 * Return the current price of this share.
	 */
	@Basic
	@Raw
	public MoneyAmount getCurrentPrice() {
		return new MoneyAmount(this.currentPrice.getAmountInCents(), this.currentPrice.getCurrency());
	}

	/**
	 * Check whether the given current price is a valid current price for
	 * any share.
	 *  
	 * @param  currentPrice
	 *         The current price to check.
	 * @return ...
	 *         | result == ...  
	 */
	public static boolean isValidCurrentPrice(MoneyAmount currentPrice) {
		return true;
	}

	/**
	 * Set the current price of this share to the given current price.
	 * 
	 * @param  currentPrice
	 *         The new current price for this share.
	 * @post   If the given current price is a valid current price for any
	 *         share, the current price of this share is equal
	 *         to the given current price.
	 *         | if (isValidCurrentPrice(currentPrice))
	 *         |   then new.getCurrentPrice() == currentPrice
	 */
	@Raw
	public void setCurrentPrice(MoneyAmount currentPrice) {
		if (isValidCurrentPrice(currentPrice))
			this.currentPrice = new MoneyAmount(currentPrice.getAmountInCents(), currentPrice.getCurrency());
	}

	/**
	 * Variable registering the current price of this share.
	 */
	private MoneyAmount currentPrice;
	
	@Basic
	public Purchase getPurchaseAt(int index) throws IndexOutOfBoundsException{
		return purchases.get(index);		
	}
	
	public boolean canHaveAsPurchaseAt(Purchase purchase, int index){
		return false;
	}
	
	@Basic
	public int getNbPurchases(){
		return purchases.size();
	}
	
	public void addAsPurchase(Purchase purchase){
		assert (purchase != null) && (purchase.getShare() == this);
		purchases.add(purchase);
	}
	
	public void removeAsPurchase(Purchase purchase){
		
	}
	
	private final List<Purchase> purchases = new ArrayList<>();

}
