package enumeration;

public class TestPlanet {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/Planet.ERDE.surfaceGravity();
        for (Planet p : Planet.values())
           System.out.printf("Ihre Masse auf %s(Radius:%.0fm, Masse:%gkg) betraegt %.2fkg  %n",
                             p,p.getRadius(),p.getMass(), p.surfaceWeight(mass));
    }
}
