import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class MainActivity {
    public static void main(String[] arguments) throws Exception
    {
        String token;
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Token :");
        token = scan.next();*/
        token = "OTQzNTI0Mzk1NzE5MjA5MDIx.Yg0TkQ.v66yaucA-mPm3DMy9RanaHHR_J0";
        JDA api = JDABuilder.createDefault(token).build();
        api.setAutoReconnect(true);
        api.addEventListener(new HelloEvent());
        api.addEventListener(new Sasage());
        api.addEventListener(new Island());
    }
}
