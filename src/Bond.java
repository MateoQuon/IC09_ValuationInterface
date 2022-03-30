import java.util.Objects;

public class Bond extends Security implements Valuation{
    private double mPrincipal;
    private double mCouponRate;
    private double mHoldingPeriod;

    public Bond(String mISIN, String mIssuer, double principal, double couponRate, double holdingPeriod) {
        super(mISIN, mIssuer);
        mPrincipal = principal;
        mCouponRate = couponRate;
        mHoldingPeriod = holdingPeriod;
    }

    public double getPrincipal() {
        return mPrincipal;
    }

    public void setPrincipal(double principal) {
        mPrincipal = principal;
    }

    public double getCouponRate() {
        return mCouponRate;
    }

    public void setCouponRate(double couponRate) {
        mCouponRate = couponRate;
    }

    public double getHoldingPeriod() {
        return mHoldingPeriod;
    }

    public void setHoldingPeriod(double holdingPeriod) {
        mHoldingPeriod = holdingPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bond bond = (Bond) o;
        return Double.compare(bond.mPrincipal, mPrincipal) == 0 && Double.compare(bond.mCouponRate, mCouponRate) == 0 && Double.compare(bond.mHoldingPeriod, mHoldingPeriod) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mPrincipal, mCouponRate, mHoldingPeriod);
    }

    @Override
    public int compareTo(Security o) {
        int superComp = super.compareTo(o);
        if (superComp != 0)
            return superComp;

        if (o instanceof Bond) {
            Bond other = (Bond)o;
            int principalComp = Double.compare(this.mPrincipal, other.mPrincipal);
            if (principalComp != 0)
                return principalComp;
            int couponRateComp = Double.compare(this.mCouponRate, other.mCouponRate);
            if (couponRateComp != 0)
                return couponRateComp;
            int holdingPeriodComp = Double.compare(this.mHoldingPeriod, other.mHoldingPeriod);
            if (holdingPeriodComp != 0)
                return holdingPeriodComp;
        }
        return this.getClass().getCanonicalName().compareTo(o.getClass().getCanonicalName());
    }

    @Override
    public double totalReturn() {
        return 0;
    }

    @Override
    public double percentReturn() {
        return 0;
    }

    @Override
    public String toString() {
        return "Bond [" +
                mISIN + ", " +
                mIssuer +
                ", Principal: " + currency.format(mPrincipal) +
                ", Coupon: " + twoDP.format(mCouponRate) +
                ", Holding: " + mHoldingPeriod +
                ", Total Return: " + currency.format(totalReturn()) +
                ", Percent Return: " + twoDP.format(percentReturn()) + "]";

    }
}
