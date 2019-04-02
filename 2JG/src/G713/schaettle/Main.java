package G713.schaettle;

/**
 * Testklasse der Klasse Produkt
 * @author Zoleta Allysha Amber, Sch�ttle Georg
 * @version 16-02-19
 */
public class Main {
    public static void main(String[] args) {
        Produkt p1 = new Produkt(9876543210L, "Mappe rot", "eine dünne rote Mappe", 2.50);
        System.out.println("Produkt: " + p1);
        Produkt p2 = new Produkt(9876543210L, "Mappe rot", "eine dünne rote Mappe", 2.50);
        System.out.println("Vergleich: " + p1.equals(p2));

        RabattProdukt rp1 = new RabattProdukt(9876543210L, "Mappe rot", "eine dünne rote Mappe", 1.25,  50);
        System.out.println("Rabbatt Produkt: " + rp1);
        RabattProdukt rp2 = new RabattProdukt(9876543210L, "Mappe rot", "eine dünne rote Mappe", 1.25, 50);
        System.out.println("Vergleich: " + rp1.equals(rp2));

        Produkt p3 = new Produkt(987654310L, "Mappe gelb", "eine dünne gelbe Mappe", 2.99);
        System.out.println("Produkt: " + p3);
        Produkt p4 = new Produkt(9876543210L, "Mappe gelb", "eine dünne gelbe Mappe", 2.50);
        System.out.println("Vergleich: " + p3.equals(p4));

        RabattProdukt rp3 = new RabattProdukt(76543210L, "Mappe gelb", "eine dünne gelb Mappe", 1.99,  50);
        System.out.println("Rabbatt Produkt: " + rp3);
        RabattProdukt rp4 = new RabattProdukt(9876543210L, "Mappe gelb", "eine gelbe rote Mappe", 1.25, 50);
        System.out.println("Vergleich: " + rp3.equals(rp4));
    }


}
