public class Main {
    public static void main(String[] args)
    {
        Driver asd = new Driver("Joska");
        Driver rzz = new Driver("Pista");

        rzz.SetNewLicense('B');
        rzz.RemoveLicenses('B');
        Vehicle fdg = new Bus(1500, 3, "Mercedes", "G2", "FLR-254", "Diesel", true);
        rzz.SetVehicle(fdg);
        fdg.SendOnDrive();
        System.out.println(rzz);
        System.out.println("Hello world!");
    }
}