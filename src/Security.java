import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public abstract class Security implements Comparable<Security>, Valuation{
    protected String mISIN;
    protected String mIssuer;
    protected NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected DecimalFormat twoDP = new DecimalFormat("0.00");

    public Security(String mISIN, String mIssuer) {
        this.mISIN = mISIN;
        this.mIssuer = mIssuer;
    }

    public String getISIN() {
        return mISIN;
    }
    public String getIssuer() {
        return mIssuer;
    }
    public void setIssuer(String mIssuer) {
        this.mIssuer = mIssuer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(mISIN, security.mISIN) && Objects.equals(mIssuer, security.mIssuer);
    }
    @Override
    public int hashCode() {
        return Objects.hash(mISIN, mIssuer);
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
    public int compareTo(Security o) {
        int ISINComp = this.mISIN.compareToIgnoreCase(o.mISIN);
        if (ISINComp != 0)
            return ISINComp;

        return this.mIssuer.compareToIgnoreCase(o.mIssuer);
    }
}
