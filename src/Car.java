public class Car implements Comparable<Car>{
    private String name;
    private double mpg;
    private int cylinders;
    private double displacement, horsepower, weight, acceleration;
    private int model;
    private String origin;

    public Car(String n, double mp, int c, double d, double h, double w,double a, int mo, String o)  {
        name = n;
        mpg = mp;
        cylinders = c;
        displacement= d;
        horsepower = h;
        weight = w;
        acceleration = a;
        model = mo;
        origin = o;

    }

    public String toString(){
        return name + " MPG: " + mpg;
    }

    public int compareTo(Car other) {
        Double one = this.mpg;
        Double two = other.mpg;
        return (-one.compareTo(two) == 0) ? this.name.compareTo(other.name) : -one.compareTo(two);
        /*int difference = -one.compareTo(two);
        if(difference != 0)
            return difference;
        else
            return this.name.compareTo(other.name);*/
    }


}
