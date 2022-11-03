public class InTransition implements PackageState
{
    private static InTransition instance = new InTransition();

    private InTransition() {}

    public static InTransition instance() {
        return instance;
    }

    public void updateState(DeliveryContext ctx)
    {
        System.out.println("Your package is in transition!");
        ctx.setCurrentState(OutForDelivery.instance());
    }
}
