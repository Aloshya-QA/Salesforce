package dto;

public class Account {

    private final String name;
    private final String phone;
    private final String rating;

    private Account(Builder builder) {
        this.name = builder.name;
        this.phone = builder.phone;
        this.rating = builder.rating;
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
        private String name;
        private String phone;
        private String rating;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
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