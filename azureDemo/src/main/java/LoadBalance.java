/**
 *
 * Load Balancer
 *
 * Hao Wang - haow2
 *
 */
public class LoadBalance {

    // Record the number of dc and lg
    private static int num_dc = 0;
    private static int num_lg = 0;
    private static int num_fe = 0;

    // The ratio to control the name to prevent identical name
    private static int step = 1;

    // Stores the information
    private static String res_group = "haowangrg";
    private static String storage_acc = "haowangsa";
    private static String image_dc = "cc15619p23dcv5-osDisk.dc552bc1-518d-451e-b856-c0419a6adcdb.vhd";
    private static String image_lg = "cc15619p23lgv4-osDisk.40d2443e-9f8c-41ce-9826-e0d7792a6c27.vhd";
    private static String image_fe = "cc15619p23fe-osDisk.8d5f0df8-c94d-43e0-8a11-77ba440e0d8f.vhd";

    private static String subscription_id = "";
    private static String tenant_id = "0e5a22ea-a170-469a-9bc9-2a8991cdd49c";
    private static String app_id = "14cd5288-f981-4eea-a90e-77cf9eb058d1";
    private static String app_key = "";
    private static String instance_dc = "Standard_D1_dc";
    private static String instance_lg = "Standard_D1_lg";
    private static String instance_fe = "Standard_A0_fe";
    private static String andrew_id = "haow2";
    private static String submission_id = "";

    public static void main(String args[]) throws Exception {

        // Number of arguments
        if (args.length < 3) {
            System.err.println("Too Few Arguments!");
            return;
        }

        // Configuration
        subscription_id = args[0];
        app_key = args[1];
        submission_id = args[2];

        // Creating Front End Cache
        num_fe += step;
        String[] para_fe = {res_group, storage_acc, image_fe, subscription_id,
                tenant_id, app_id, app_key, instance_fe, ""+ num_fe};
        System.out.println("Begin Creating Front End, No: " + num_fe);
        String dns_fe = AzureVMApiDemo.main(para_fe);
        System.out.println("Successfully Created Front End!");
        System.out.println("The DNS of Front End is: " + dns_fe + "\n");

        // Creating Load Generator
        num_lg += step;
        String[] para_lg = {res_group, storage_acc, image_lg, subscription_id,
                tenant_id, app_id, app_key, instance_lg, ""+ num_lg};
        System.out.println("Begin Creating Load Generator, No: " + num_lg);
        String dns_lg = AzureVMApiDemo.main(para_lg);
        System.out.println("Successfully Created Load Generator!");
        System.out.println("The DNS of LG is: " + dns_lg + "\n");

        // Creating Data Center
        num_dc += step;
        String[] para_dc1 = {res_group, storage_acc, image_dc, subscription_id,
                tenant_id, app_id, app_key, instance_dc, ""+ num_dc};
        System.out.println("Begin Creating Data Center, No: " + num_dc);
        String dns_dc = AzureVMApiDemo.main(para_dc1);
        System.out.println("Successfully Created Data Center!");
        System.out.println("The DNS of DC is: " + dns_dc + "\n");

        num_dc += step;
        String[] para_dc2 = {res_group, storage_acc, image_dc, subscription_id,
                tenant_id, app_id, app_key, instance_dc, ""+ num_dc};
        System.out.println("Begin Creating Data Center, No: " + num_dc);
        dns_dc = AzureVMApiDemo.main(para_dc2);
        System.out.println("Successfully Created Data Center!");
        System.out.println("The DNS of DC is: " + dns_dc + "\n");
//
//        num_dc += step;
//        String[] para_dc3 = {res_group, storage_acc, image_dc, subscription_id,
//                tenant_id, app_id, app_key, instance_dc, ""+ num_dc};
//        System.out.println("Begin Creating Data Center, No: " + num_dc);
//        dns_dc = AzureVMApiDemo.main(para_dc3);
//        System.out.println("Successfully Created Data Center!");
//        System.out.println("The DNS of DC is: " + dns_dc + "\n");
//
//        // Basic Setup
//        basicSetup(dns_lg);
//        Thread.sleep(40000);
//        setupDataCenter(dns_dc, dns_lg, true);
//
//        // Get Test ID
//        String test_id = getTestID(dns_lg);
//        System.out.println("Test_id: " + test_id);
//
//        // Add instances till rps is no smaller than 3000
//        System.out.println("\nNow RPS test begin!");
//        double rps_sum = 0.0;
//        do {
//            // Add Data Center
//            num_dc += step;
//            para_dc[8] = ""+num_dc;
//            dns_dc = AzureVMApiDemo.main(para_dc);
//
//            // Wait to finish adding
//            Thread.sleep(40000);
//            setupDataCenter(dns_dc, dns_lg, false);
//
//            // Get rps_sum
//            rps_sum = getRPSSum(dns_lg, test_id);
//            System.out.println("rps_sum is : " + rps_sum);
//
//            Thread.sleep(60000);
//        } while (rps_sum < 3000);

    }
}
