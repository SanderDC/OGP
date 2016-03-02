package associations.banking.products;

import java.util.*;

import associations.stockMarket.Share;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class of wallets involving ...
 * 
 * @invar	...
 * 			| hasProperPurchases()
 *
 * @author  ...
 * @version 1.0
 */
public class Wallet {
	
	/**
	 * Initialize this new wallet.
	 */
	public Wallet() {
		
	}
	
	/**
	 * Return a boolean indicating whether or not this wallet
	 * is terminated.
	 */
	@Basic
	@Raw
	public boolean isTerminated() {
		return this.isTerminated;
	}

	/**
	 * Terminate this wallet.
	 *
	 * @post    This wallet is terminated.
	 *          | new.isTerminated()
	 */
	public void terminate() {
		// To be completed.
		this.isTerminated = true;
	}

	/**
	 * Variable registering whether this wallet is terminated.
	 */
	private boolean isTerminated;
	
	@Basic
	public boolean hasAsPurchase(Purchase purchase){
		return purchases.get(purchase.getShare()) == purchase;
	}
	
	public boolean canHaveAsPurchase(Purchase purchase){
		return (purchase != null) &&purchase.isValidWallet(this);
	}
	
	public Purchase getPurchaseOf(Share share){
		return purchases.get(share);
	}
	
	public boolean hasProperPurchases(){
		for(Purchase purchase: this.purchases.values()){
			if (! this.canHaveAsPurchase(purchase))
				return false;
			if (purchase.getWallet() != this)
				return false;
			if (this.getPurchaseOf(purchase.getShare()) != purchase)
				return false;
		}
		return true;
	}
	
	public void addAsPurchase(@Raw Purchase purchase){
		assert purchase != null;
		assert(purchase.getWallet() == this);
		purchases.put(purchase.getShare(), purchase);		
	}
	
	@Raw
	public void removeAsPurchase(Purchase purchase){
		assert purchase != null;
		assert this.hasAsPurchase(purchase);
		assert purchase.getWallet() == null;
		purchases.remove(purchase.getShare());
	}
	
	private final Map<Share,Purchase> purchases = new HashMap<>();
}
