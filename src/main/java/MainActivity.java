import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class MainActivity {
    public static void main(String[] arguments) throws Exception
    {
        String token = null;
        Path path = Paths.get("./Token.txt");
        try {
            token = Files.readString(path);
        } catch (IOException e){
            System.out.print("txt file read Error!");
            e.printStackTrace();
        }
        JDA api = JDABuilder.createDefault(token).build();
        api.setAutoReconnect(true);
        api.addEventListener(new HelloEvent());
        api.addEventListener(new Sasage());
        api.addEventListener(new Island());
    }
}
