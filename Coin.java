public abstract class Coin {
    public abstract double getValue();
    public abstract String getName();

    public String getpluralName() {
        if (getValue() > 0.01)
            return getName() + "s";
        else
            return getName().substring(0, 4) + "ies";
    }
}
