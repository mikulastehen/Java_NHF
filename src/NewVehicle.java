import java.util.ArrayList;


/**
 * <h1>NewVehicle parancsosztály</h1>
 * Az osztály feladata az új járművek hozzáadására kiadott parancsok kezelése.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Vehicle
 * @see Bus
 * @see Tram
 * @see Metro
 */
public class NewVehicle extends CommandBase
{

    /**
     * <h2>Konstruktor</h2>
     * Szabványos módon átveszi az adatbázist
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public NewVehicle(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * Az átvett parancs alapján elvégzi a jármű hozzáadását az adatbázisba.
     * A logika ellenőrzi hogy azonos pályaszámú/rendszámú jármű szerepel e már a listában, mivel a duplikátum nem megengedett.
     * Ha a parancsban szintaxis hiba van, súgót ír ki.
     * A parancs 2. paramétere alapján választja ki a megfelelő jármű konstruktorát, és adja át a paramétereket.
     * @param args parancs szöveges formában
     */
    @Override
    public void Command(String args)
    {
        String[] tomb = args.split(" ");
        if(tomb.length == 1)
        {
            System.out.println("New vehicle - Bus: nv bus <Make> <Model> <fuel type> <acessible> <mass> <door count> <license>\n" +
                    "New vehicle - Tram: nv tram <Make> <Model> <Pantograph> <Control type> <has AC?> <mass> <door count> <license>\n" +
                    "New vehicle - Metro: nv metro <Make> <Model> <AVR type> <wagon number> <mass> <door count> <license>");
            return;
        }
        if(tomb[1].equals("bus"))
        {
            for(Vehicle x : vehicles)
            {
                if(x.getLicense().equals(tomb[8]))
                {
                    System.out.println("HIBA! A megadott rendszám már létezik a nyilvántartásban!");
                    return;
                }
            }
            super.vehicles.add(new Bus(tomb[2], tomb[3], tomb[4], Boolean.parseBoolean(tomb[5]), Integer.parseInt(tomb[6]), Integer.parseInt(tomb[7]), tomb[8]));
            System.out.println("INFO! A jármű felvéve a nyilvántartásba");
        }
        if(tomb[1].equals("tram"))
        {
            for(Vehicle x : vehicles)
            {
                if(x.getLicense().equals(tomb[8]))
                {
                    System.out.println("HIBA! A megadott pályaszám már létezik a nyilvántartásban!");
                    return;
                }
            }
            super.vehicles.add(new Tram(tomb[2], tomb[3], tomb[4], tomb[5], Boolean.parseBoolean(tomb[6]), Integer.parseInt(tomb[7]), Integer.parseInt(tomb[8]), tomb[9]));
            System.out.println("INFO! A jármű felvéve a nyilvántartásba");
        }
        if(tomb[1].equals("metro")) {
            for (Vehicle x : vehicles) {
                if (x.getLicense().equals(tomb[8])) {
                    System.out.println("HIBA! A megadott pályaszám már létezik a nyilvántartásban!");
                    return;
                }
                super.vehicles.add(new Metro(tomb[2], tomb[3], tomb[4], Integer.parseInt(tomb[5]), Integer.parseInt(tomb[6]), Integer.parseInt(tomb[7]), tomb[8]));
            }
        }
    }

    /**
     * <h2>toString metódus</h2>
     * A parancs azonosítására használt metódus
     * @return a parancs betűjele
     */
    @Override
    public String toString() {
        return "nv";
    }
}
