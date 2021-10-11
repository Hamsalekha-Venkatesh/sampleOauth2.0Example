package com.hamsa.hystrixdashboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spring {
    String ticker;
    boolean isAllowedToSell;
    double bidPrice;
    double askPrice;
    String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spring that = (Spring) o;
        return isAllowedToSell == that.isAllowedToSell &&
                Double.compare(that.bidPrice, bidPrice) == 0 &&
                Double.compare(that.askPrice, askPrice) == 0 &&
                Objects.equals(ticker, that.ticker) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, isAllowedToSell, bidPrice, askPrice, description);
    }
}