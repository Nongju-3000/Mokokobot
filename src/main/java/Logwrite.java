import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logwrite extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        String message = String.valueOf(event.getMessage());
        String server = String.valueOf(event.getGuild());
        String channel = String.valueOf(event.getChannel());
        String user = String.valueOf(event.getMember().getUser());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt",true))) {
            bw.write(server + "|" + channel + "|" + user + "| " +message);
            bw.newLine();
            bw.flush();
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
