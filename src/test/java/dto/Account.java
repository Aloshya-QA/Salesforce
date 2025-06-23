package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Account {

    private final String name, phone, rating, fax, website, accountNumber,
                        accountSite, tickerSymbol, employees, annualRevenue,
                        sicCode, billingCity, billingStateProvince, slaSerialNumber;

}