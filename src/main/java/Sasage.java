import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URLEncoder;


public class Sasage extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equalsIgnoreCase("사사게") && !event.getMember().getUser().isBot()){
            try{
                String object = URLEncoder.encode(messageSent[1], "UTF-8");
                String URL = "https://www.inven.co.kr/board/lostark/5355?query=list&p=1&sterm=&name=subjcont&keyword=" + object;
                Connection conn = Jsoup.connect(URL);
                Document html = conn.get();
                // System.out.println(html.toString());
                Elements urlelements = html.getElementsByClass("subject-link");
                if(urlelements.size() <= 1){
                    event.getChannel().sendMessage("사사게 검색 결과가 없습니다!").queue();
                }
                else {
                    event.getChannel().sendMessage("총 " + (urlelements.size() - 1) + "건의 검색 결과가 있습니다!\n최근 4개 글을 표시할게요.").queue();
                    int i = 0;
                    for (Element element : urlelements) {
                        if(i > 0 && i < 5) {
                            event.getChannel().sendMessage(element.attr("href")).queue();
                        }
                        // System.out.println(element.attr("href"));
                        i++;
                    }
                }

            } catch (Exception e){
                event.getChannel().sendMessage("에러다 씨불롬아!").queue();
            }
        }
    }
}
