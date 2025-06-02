package wrappers;

public enum AccountField {
    ACCOUNT_NAME("Account Name"),
    ACCOUNT_NUMBER("Account Number"),
    ACCOUNT_SITE("Account Site"),
    ANNUAL_REVENUE("Annual Revenue"),
    SIC_CODE("SIC Code"),
    EMPLOYEES("Employees"),
    TICKER_SYMBOL("Ticker Symbol"),
    WEBSITE("Website"),
    FAX("Fax"),
    PHONE("Phone"),
    BILLING_CITY("Billing City"),
    BILLING_STATE_PROVINCE("Billing State/Province"),
    BILLING_ZIP_POSTAL_CODE("Billing Zip/Postal Code"),
    BILLING_COUNTRY("Billing Country"),
    SHIPPING_CITY("Shipping City"),
    SHIPPING_STATE_PROVINCE("Shipping State/Province"),
    SHIPPING_ZIP_POSTAL_CODE("Shipping Zip/Postal Code"),
    SHIPPING_COUNTRY("Shipping Country"),
    NUMBER_OF_LOCATIONS("Number of Locations"),
    SLA_SERIAL_NUMBER("SLA Serial Number");

    private final String label;

    AccountField(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}