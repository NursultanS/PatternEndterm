
public class Acknowledged implements PackageState
{
    private static Acknowledged instance = new Acknowledged();

    private Acknowledged() {}

    public static Acknowledged instance() {
        return instance;
    }

    public void updateState(DeliveryContext ctx)
    {
        System.out.println("Your package is acknowledged!");
        ctx.setCurrentState(Shipped.instance());
    }
}