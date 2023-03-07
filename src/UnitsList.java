// Lista de unidades te temperaturas
public enum UnitsList {
	
    CELSIUS("Celsios"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");

    private String unit;

    private UnitsList(String name) {
        this.unit = name;
    }

    public String getName() {
        return unit;
    }
}
