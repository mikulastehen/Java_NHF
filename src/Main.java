import java.util.*;

/**
 * <h1>Jármű kezelő és nyilvántartó rendszer</h1>
 * <h2>Main osztály</h2>
 * A program feladata egy jármű nyilvántartó rendszer amely 3 típust tud kezelni: buszokat, villamosokat, és metrókat. A járműveknek különböző és egységes tulajdonságaik is vannak.
 * A járművek hozzárendelhetőek vezetőkhöz, és így további műveletek hajthatóak végre.
 * A main metódus fő feladata az indításkor az adatok betöltése, illetve leállításkor az adatok mentése. Az egész rendszer adatkezelése két ArrayList segítségével történik, ezek tárolják a járműveket és a vezetőket.
 * Mivel a program parancsokkal működik, szökséges volt a parancsosztályok megvalósítása, és így a parancsok betöltése egy listába. Ez a művelet mindig statikusan megtörténik.
 */
public class Main {
    /**
     * <h2>Main metódus</h2>
     * A program futásának kezdőpontja. Betöltéskor betölti és létrehozza az adatszerkezeteket, betölti a parancsokat, majd várja a felhasználói parancsokat.
     * A felhasználói parancsokat a parancsok szó és betűkód utáni azonosítása után a megfelelő parancsosztálynak továbbítja amelyek a háttérlogikát megvalósítják.
     * A program minden parancs lefuttatása után elmenti az adatbázist.
     * @param args nincs!!
     */
    public static void main(String[] args)
    {
        ArrayList[] load = FileManager.Load();
        ArrayList<Driver> vezetok = load[0];
        ArrayList<Vehicle> jarmuvek = load[1];

        ArrayList<CommandBase> commands = new ArrayList<>();
        commands.add(new NewVehicle(vezetok, jarmuvek));
        commands.add(new AddDriver(vezetok, jarmuvek));
        commands.add(new SetLicense(vezetok, jarmuvek));
        commands.add(new RemoveLicense(vezetok, jarmuvek));
        commands.add(new SetVehicle(vezetok, jarmuvek));
        commands.add(new Dock(vezetok, jarmuvek));
        commands.add(new SendOnRoute(vezetok, jarmuvek));
        commands.add(new CallBack(vezetok, jarmuvek));
        commands.add(new Checkup(vezetok, jarmuvek));
        commands.add(new ListVehicleData(vezetok, jarmuvek));
        commands.add(new RemoveDriver(vezetok, jarmuvek));
        commands.add(new RemoveVehicle(vezetok, jarmuvek));

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            String be = sc.nextLine();
            if(be.equals("exit")) {break;}
            for(CommandBase x : commands)
            {
                if(x.toString().equals(be.split(" ")[0]))
                {
                    x.Command(be);
                    FileManager.Save(vezetok, jarmuvek);
                }
            }
        }
    }
}