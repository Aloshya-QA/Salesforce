package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    private final static Faker FAKER = new Faker();

    public static Account getAccount() {
        return new Account.Builder()
                .withName(FAKER.company().name())
                .withPhone(FAKER.phoneNumber().cellPhone())
                .withRating("Cold")
                .build();
    }

    public static Account getMaxAccount() {
        return new Account.Builder()
                .withName(FAKER.company().name())
                .withPhone(FAKER.phoneNumber().cellPhone())
                .withAccountSite(FAKER.company().url())
                .withEmployees(FAKER.number().digit())
                .withSicCode(FAKER.number().digit())
                .withTickerSymbol(FAKER.currency().code())
                .withFax(FAKER.phoneNumber().cellPhone())
                .withAnnualRevenue(FAKER.number().digit())
                .build();
    }
}