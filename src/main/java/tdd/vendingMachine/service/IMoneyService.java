package tdd.vendingMachine.service;

import tdd.vendingMachine.service.exception.CoinNotSupportedException;

public interface IMoneyService {
    
    //TODO: enum as dictionary from DB/xml
    public enum SupportedCoins {
        FIVE(5f), TWO(2f), ONE(1f), HALF(0.5f), ONE_FIFTH(0.2f), ONE_TEN(0.1f);
        
        float denomination;
        
        SupportedCoins(float denomination) {
            this.denomination = denomination;
        }
        
        public static SupportedCoins createSupportedCoins(float denomination) throws CoinNotSupportedException {
            for(SupportedCoins coin : SupportedCoins.values()) {
                if(coin.denomination == denomination) {
                    return coin;
                }
            }
            
            throw new CoinNotSupportedException("Denomination = " + denomination + " is not supported");
        }
    }

    SupportedCoins getCoinType(float denomination) throws CoinNotSupportedException;

}