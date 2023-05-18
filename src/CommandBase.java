import java.util.ArrayList;

/**
 * <h1>CommandBase superclass</h1>
 * A command base egy alaposztály minden parancsosztály őseként.
 * Minden parancsosztály konstruktora egységes, átveszik a főprogramtól a két adatszerkezetet, a Driver, és a Vehicle listát.
 * A toString metódust minden al osztály megvalósítja és felülírja a saját azonosító jelével.
 * @see Driver
 * @see Vehicle
 */
public abstract class CommandBase
{
    /**
     * A drivers field egy ArrayList amely driver példányokat tárol.
     */
    ArrayList<Driver> drivers;

    /**
     * A vehicles field egy ArrayList amely vehicle példányokat tárol.
     */
    ArrayList<Vehicle> vehicles;

    /**
     * <h2>Konstruktor</h2>
     * Az összes parancs konstruktoraként szolgáló metódus.
     * Átveszi a főprogramtól a két adatszerkezetet és eltárolja referencia szinten.
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public CommandBase(ArrayList<Driver> d, ArrayList<Vehicle> v)
    {
        drivers = d;vehicles = v;
    }

    /**
     * <h2>Command metódus</h2>
     * A Command metódus az ősosztályban nem rendelkezik funkcionalitással
     * @param args parancs szöveges formában
     */
    public void Command(String args) {}

    /**
     * <h2>toString metódus</h2>
     * A toString metódus nincs használva az ősosztály esetében.
     * @return commandot azonosító betűjel
     */
    @Override
    public String toString() {
        return "CommandBase";}
}
