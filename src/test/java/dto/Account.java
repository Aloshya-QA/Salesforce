package dto;

public class Account {

    private final String name, phone, rating, fax, website, accountNumber,
                        accountSite, tickerSymbol, employees, annualRevenue,
                        sicCode, billingCity, billingStateProvince, slaSerialNumber;


    private Account(Builder builder) {
        this.name = builder.name;
        this.phone = builder.phone;
        this.rating = builder.rating;
        this.fax = builder.fax;
        this.website = builder.website;
        this.accountNumber = builder.accountNumber;
        this.accountSite = builder.accountSite;
        this.tickerSymbol = builder.tickerSymbol;
        this.employees = builder.employees;
        this.annualRevenue = builder.annualRevenue;
        this.sicCode = builder.sicCode;
        this.billingCity = builder.billingCity;
        this.billingStateProvince = builder.billingStateProvince;
        this.slaSerialNumber = builder.slaSerialNumber;
    }

    public String getFax() {
        return fax;
    }

    public String getWebsite() {
        return website;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountSite() {
        return accountSite;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public String getEmployees() {
        return employees;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public String getSicCode() {
        return sicCode;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getBillingStateProvince() {
        return billingStateProvince;
    }

    public String getSlaSerialNumber() {
        return slaSerialNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getRating() {
        return rating;
    }

    public static class Builder {
        private String name, phone, rating, fax, website, accountNumber,
                accountSite, tickerSymbol, employees, annualRevenue,
                sicCode, billingCity, billingStateProvince, slaSerialNumber;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withFax(String fax) {
            this.fax = fax;
            return this;
        }

        public Builder withWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder withAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder withAccountSite(String accountSite) {
            this.accountSite = accountSite;
            return this;
        }

        public Builder withTickerSymbol(String tickerSymbol) {
            this.tickerSymbol = tickerSymbol;
            return this;
        }

        public Builder withEmployees(String employees) {
            this.employees = employees;
            return this;
        }

        public Builder withAnnualRevenue(String annualRevenue) {
            this.annualRevenue = annualRevenue;
            return this;
        }

        public Builder withSicCode(String sicCode) {
            this.sicCode = sicCode;
            return this;
        }

        public Builder withBillingStateProvince(String billingStateProvince) {
            this.billingStateProvince = billingStateProvince;
            return this;
        }

        public Builder withSlaSerialNumber(String slaSerialNumber) {
            this.slaSerialNumber = slaSerialNumber;
            return this;
        }

        public Builder withRating(String rating) {
            this.rating = rating;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}