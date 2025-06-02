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

    public static Account getAccountOnlyWithName() {
        return new Account.Builder()
                .withName(FAKER.company().name())
                .build();
    }
}