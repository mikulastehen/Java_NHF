import java.util.ArrayList;

public class AddVehicle extends CommandBase
{

    public AddVehicle(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args)
    {
        String[] tomb = args.split(" ");
        if(tomb.length == 1)
        {
            System.out.println("A helyes formátum: nv <Type> <Make> <Model> <fuel type> <accessible> <mass> <door count> <license>");
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

    @Override
    public String toString() {
        return "nv";
    }
}
