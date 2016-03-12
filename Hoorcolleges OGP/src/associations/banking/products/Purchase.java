package associations.banking.products;

import associations.banking.money.MoneyAmount;
import associations.stockMarket.Share;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class of purchases involving ...
 * 
 * @invar Each purchase can have its number of items as number of items. |
 *        canHaveAsNbItems(getNbItems())
 * @invar The highest price of each purchase must be a valid highest price for
 *        any purchase. | isValidHighestPrice(getHighestPrice())
 * @invar The share of each purchase must be a valid share for any purchase. |
 *        isValidShare(getShare())
 *
 * @author ...
 * @version 1.0
 */
public class Purchase {

	/**
	 * Initialize this new purchase with given number of items and given highest
	 * price.
	 * 
	 * @param nbItems
	 *            The number of items for this new purchase.
	 * @param highestPrice
	 *            The highest price for this new purchase.
	 * @effect The number of items of this new purchase is set to the given
	 *         number of items. | setNbItems(nbItems)
	 * @effect The highest price of this new purchase is set to the given
	 *         highest price. | setHighestPrice(highestPrice)
	 */
	@Raw
	public Purchase(int nbItems, MoneyAmount highestPrice, Share share, Wallet wallet)
			throws IllegalArgumentException {
		if (! this.isValidWallet(wallet))
			throw new IllegalArgumentException();
		setNbItems(nbItems);
		setHighestPrice(highestPrice);
		if (! isValidShare(share))
			throw new IllegalArgumentException();
		this.setShare(share);
		share.addAsPurchase(this);
		if (! this.isValidWallet(wallet) || (wallet.getPurchaseOf(share) != null))
			throw new IllegalArgumentException();
		this.setWallet(wallet);
		wallet.addAsPurchase(this);
	}

	/**
	 * Return a boolean indicating whether or not this purchase is terminated.
	 */
	@Basic
	@Raw
	public boolean isTerminated() {
		return this.isTerminated;
	}

	/**
	 * Terminate this purchase.
	 *
	 * @post This purchase is terminated. | new.isTerminated()
	 */
	public void terminate() {
		if (! this.isTerminated){
			Wallet oldWallet = this.getWallet();
			this.setWallet(null);
			oldWallet.removeAsPurchase(this);
			this.isTerminated = true;
		}
	}

	/**
	 * Variable registering whether this person is terminated.
	 */
	private boolean isTerminated;

	/**
	 * Return the number of items of this purchase.
	 */
	@Basic
	@Raw
	public int getNbItems() {
		return this.nbItems;
	}

	/**
	 * Check whether this purchase can have the given number of items as its
	 * number of items.
	 * 
	 * @param nbItems
	 *            The number of items to check.
	 * @return ... | result == ...
	 */
	@Raw
	public boolean canHaveAsNbItems(int nbItems) {
		return true;
	}

	/**
	 * Set the number of items of this purchase to the given number of items.
	 * 
	 * @param nbItems
	 *            The new number of items for this purchase.
	 * @pre This purchase can have the given number of items as its number of
	 *      items. | canHaveAsNbItems(nbItems)
	 * @post The number of items of this purchase is equal to the given number
	 *       of items. | new.getNbItems() == nbItems
	 */
	@Raw
	public void setNbItems(int nbItems) {
		assert canHaveAsNbItems(nbItems);
		this.nbItems = nbItems;
	}

	/**
	 * Variable registering the number of items of this purchase.
	 */
	private int nbItems;

	/**
	 * Return the highest price of this purchase.
	 */
	@Basic
	@Raw
	public MoneyAmount getHighestPrice() {
		return this.highestPrice;
	}

	/**
	 * Check whether the given highest price is a valid highest price for any
	 * purchase.
	 * 
	 * @param highestPrice
	 *            The highest price to check.
	 * @return ... | result == ...
	 */
	public static boolean isValidHighestPrice(MoneyAmount highestPrice) {
		return true;
	}

	/**
	 * Set the highest price of this purchase to the given highest price.
	 * 
	 * @param highestPrice
	 *            The new highest price for this purchase.
	 * @post The highest price of this purchase is equal to the given highest
	 *       price. | new.getHighestPrice() == highestPrice
	 * @throws IllegalArgumentException
	 *             The given highest price is not a valid highest price for any
	 *             purchase. | ! isValidHighestPrice(highestPrice)
	 */
	@Raw
	public void setHighestPrice(MoneyAmount highestPrice) throws IllegalArgumentException {
		if (!isValidHighestPrice(highestPrice))
			throw new IllegalArgumentException();
		this.highestPrice = highestPrice;
	}

	/**
	 * Variable registering the highest price of this purchase.
	 */
	private MoneyAmount highestPrice;

	/**
	 * Initialize this new purchase with given share.
	 * 
	 * @param share
	 *            The share for this new purchase.
	 * @post If the given share is a valid share for any purchase, the share of
	 *       this new purchase is equal to the given share. Otherwise, the share
	 *       of this new purchase is equal to null. | if (isValidShare(share)) |
	 *       then new.getShare() == share | else new.getShare() == null
	 */
	public Purchase(Share share) {
		if (!isValidShare(share))
			share = null;
		setShare(share);
	}

	/**
	 * Return the share of this purchase.
	 */
	@Basic
	@Raw
	public Share getShare() {
		return this.share;
	}

	/**
	 * Check whether the given share is a valid share for any purchase.
	 * 
	 * @param share
	 *            The share to check.
	 * @return | result ==
	 */
	public static boolean isValidShare(Share share) {
		return false;
	}

	/**
	 * Set the share of this purchase to the given share.
	 * 
	 * @param share
	 *            The new share for this purchase.
	 * @post If the given share is a valid share for any purchase, the share of
	 *       this new purchase is equal to the given share. | if
	 *       (isValidShare(share)) | then new.getShare() == share
	 */
	@Raw
	private void setShare(Share share) {
		if (isValidShare(share))
			this.share = share;
	}

	/**
	 * Variable registering the share of this purchase.
	 */
	private Share share;

	/**
	 * @invar  The wallet of each Purchase must be a valid wallet for any
	 *         Purchase.
	 *       | isValidWallet(getWallet())
	 */

	/**
	 * Initialize this new Purchase with given wallet.
	 * 
	 * @param  wallet
	 *         The wallet for this new Purchase.
	 * @pre    The given wallet must be a valid wallet for any Purchase.
	 *       | isValidWallet(wallet)
	 * @post   The wallet of this new Purchase is equal to the given
	 *         wallet.
	 *       | new.getWallet() == wallet
	 */
	public Purchase(Wallet wallet) {
		this.setWallet(wallet);
	}

	/**
	 * Return the wallet of this Purchase.
	 */
	@Basic @Raw
	public Wallet getWallet() {
		return this.wallet;
	}

	/**
	 * Check whether the given wallet is a valid wallet for
	 * any Purchase.
	 *  
	 * @param  wallet
	 *         The wallet to check.
	 * @return 
	 *       | result == 
	 */
	public boolean isValidWallet(Wallet wallet) {
		if (this.isTerminated())
			return (wallet == null);
		return (wallet != null) && (! wallet.isTerminated());
	}

	/**
	 * Set the wallet of this Purchase to the given wallet.
	 * 
	 * @param  wallet
	 *         The new wallet for this Purchase.
	 * @pre    The given wallet must be a valid wallet for any
	 *         Purchase.
	 *       | isValidWallet(wallet)
	 * @post   The wallet of this Purchase is equal to the given
	 *         wallet.
	 *       | new.getWallet() == wallet
	 */
	@Raw
	private void setWallet(Wallet wallet) {
		assert isValidWallet(wallet);
		this.wallet = wallet;
	}

	/**
	 * Variable registering the wallet of this Purchase.
	 */
	private Wallet wallet;
}
