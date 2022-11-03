public class Shipped implements PackageState
{
    private static Shipped instance = new Shipped();

    private Shipped() {}

    public static Shipped instance() {
        return instance;
    }

    public void updateState(DeliveryContext ctx)
    {
        System.out.println("Your package is shipped!");
        ctx.setCurrentState(InTransition.instance());
    }
}