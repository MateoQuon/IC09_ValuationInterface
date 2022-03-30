import java.util.Objects;

public class CommonStock extends Security implements  Valuation{
    private int mShares;
    private double mPurchasePrice;
    private double mCurrentPrice;

    public CommonStock(String mISIN, String mIssuer, int shares, double purchasePrice, double currentPrice) {
        super(mISIN, mIssuer);
        mShares = shares;
        mPurchasePrice = purchasePrice;
        mCurrentPrice = currentPrice;
    }

    public int getShares() {
        return mShares;
    }

    public void setShares(int shares) {
        mShares = shares;
    }

    public double getPurchasePrice() {
        return mPurchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        mPurchasePrice = purchasePrice;
    }

    public double getCurrentPrice() {
        return mCurrentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        mCurrentPrice = currentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommonStock that = (CommonStock) o;
        return mShares == that.mShares && Double.compare(that.mPurchasePrice, mPurchasePrice) == 0 && Double.compare(that.mCurrentPrice, mCurrentPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mShares, mPurchasePrice, mCurrentPrice);
    }

    @Override
    public double totalReturn() {
        return (mCurrentPrice - mPurchasePrice)*mShares;
    }

    @Override
    public double percentReturn() {
        return mCurrentPrice-mPurchasePrice/mPurchasePrice * 100.0;
    }

    @Override
    public int compareTo(Security o) {
        int superComp = super.compareTo(o);
        if (superComp != 0)
            return superComp;

        if (o instanceof CommonStock) {
            CommonStock other = (CommonStock)o;
            int sharesComp = this.mShares - other.mShares;
            if (sharesComp != 0)
                return sharesComp;
            int purchasePriceComp = Double.compare(this.mPurchasePrice, other.mPurchasePrice);
            if (purchasePriceComp != 0)
                return purchasePriceComp;
            int currentPriceComp = Double.compare(this.mCurrentPrice, other.mCurrentPrice);
            if (currentPriceComp != 0)
                return currentPriceComp;
        }
        return this.getClass().getCanonicalName().compareTo(o.getClass().getCanonicalName());
    }

    @Override
    public String toString() {

        return "CommonStock [" +
                mISIN + ", " +
                mIssuer +
                ", Purchase: " + currency.format(mPurchasePrice) +
                ", Current: " + currency.format(mCurrentPrice) +
                ", Shares: " + mShares +
                ", Total Return: " + currency.format(totalReturn()) +
                ", Percent Return: " + twoDP.format(percentReturn()) + "%]";
    }
}
