package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    private final static Faker FAKER = new Faker();

    public static Account getAccount() {
        return new Account.AccountBuilder()
                .phone(FAKER.phoneNumber().cellPhone())
                .rating("Cold")
                .build();
    }

    public static Account getMaxAccount() {
        return new Account.AccountBuilder()
                .name(FAKER.company().name())
                .phone(FAKER.phoneNumber().cellPhone())
                .accountSite(FAKER.company().url())
                .employees(FAKER.number().digit())
                .sicCode(FAKER.number().digit())
                .tickerSymbol(FAKER.currency().code())
                .fax(FAKER.phoneNumber().cellPhone())
                .annualRevenue(FAKER.number().digit())
                .build();
    }
}