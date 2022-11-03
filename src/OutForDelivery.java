public class OutForDelivery implements PackageState
{

    private static OutForDelivery instance = new OutForDelivery();

    private OutForDelivery() {}

    public static OutForDelivery instance() {
        return instance;
    }

    public void updateState(DeliveryContext ctx)
    {
        System.out.println("Your package is out of delivery!");
        ctx.setCurrentState(Delivered.instance());
    }
}
