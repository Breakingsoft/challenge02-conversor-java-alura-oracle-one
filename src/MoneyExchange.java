// Lista tipos de cambios
public enum MoneyExchange {
	
    CRC("Colón Costarricense", "crc"),
    USD("Dolar Estadounidense", "usd"),
    EUR("Euro", "eur"),
    GBP("Libra Esterlina", "gbp"),
    JPY("Yen Japonés", "jpy"),
    KRW("Won Surcoreano", "krw");

    private final String name;
    private final String reference;

    private MoneyExchange(String name, String reference) {
        this.name = name;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }
    
}