
public class Delivered implements PackageState
{
    private static Delivered instance  = new Delivered();

    private Delivered() {}

    public static Delivered instance() {
        return instance;
    }
    public void updateState(DeliveryContext ctx)
    {
        System.out.println("Your package is delivered!");
    }
}
