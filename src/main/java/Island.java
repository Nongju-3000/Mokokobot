import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class Island extends ListenerAdapter{
    public void onMessageReceived(MessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equalsIgnoreCase("모험섬") && !event.getMember().getUser().isBot()){
            ArrayList island = new ArrayList();
            ArrayList reward = new ArrayList();
            try{
                String URL = "https://loawa.com/";
                Connection conn = Jsoup.connect(java.net.URLDecoder.decode(URL,"UTF-8"));
                Document html = conn.get();
                Elements island_elements = html.getElementsByClass("img-fluid rounded-top");
                Elements reward_elements = html.getElementsByClass("img-fluid rounded-bottom");
                for(Element element : island_elements){
                    // event.getChannel().sendMessage(element.attr("alt")+"\n").queue();
                    island.add(element.attr("alt"));
                }
                for(Element element : reward_elements){
                    reward.add(element.attr("alt"));
                }
                event.getChannel().sendMessage("오늘의 섬은 뭘까용!").queue();
                for(int i = 0;i<3;i++) {
                    String misland;
                    String mreward;
                    misland = (String) island.get(i);
                    mreward = (String) reward.get(i);
                    misland = misland.replace("-","");
                    mreward = mreward.replace("-","");
                    event.getChannel().sendMessage("``"+misland+"`` - ``"+mreward+"``").queue();
                }
            } catch (Exception e) {
                event.getChannel().sendMessage("오늘의 모험섬은... 오류섬 입니다!").queue();
            }
        }

        if(messageSent[0].equalsIgnoreCase("쌀섬") || messageSent[0].equalsIgnoreCase("골드섬") && !event.getMember().getUser().isBot()){
            ArrayList island = new ArrayList();
            ArrayList reward = new ArrayList();
            boolean isreal = false;
            try{
                String URL = "https://loawa.com/";
                Connection conn = Jsoup.connect(java.net.URLDecoder.decode(URL,"UTF-8"));
                Document html = conn.get();
                Elements island_elements = html.getElementsByClass("img-fluid rounded-top");
                Elements reward_elements = html.getElementsByClass("img-fluid rounded-bottom");
                for(Element element : island_elements){
                    // event.getChannel().sendMessage(element.attr("alt")+"\n").queue();
                    island.add(element.attr("alt"));
                }
                for(Element element : reward_elements){
                    reward.add(element.attr("alt"));
                }
                for(int i = 0;i<3;i++) {
                    String misland;
                    String mreward;
                    misland = (String) island.get(i);
                    mreward = (String) reward.get(i);
                    misland = misland.replace("-","");
                    mreward = mreward.replace("-","");
                    if(mreward.equals("골드")){
                        event.getChannel().sendMessage("오늘의 "+messageSent[0]+"은 ``"+ misland +"`` 입니다!").queue();
                        isreal = true;
                    }
                }
                if(!isreal){
                    event.getChannel().sendMessage("오늘은 "+messageSent[0]+"이 없네요!").queue();
                }
            } catch (Exception e) {
                event.getChannel().sendMessage("오늘의 모험섬은... 오류섬 입니다!").queue();
            }
        }

        if(messageSent[0].equalsIgnoreCase("카드섬") && !event.getMember().getUser().isBot()){
            ArrayList island = new ArrayList();
            ArrayList reward = new ArrayList();
            boolean isreal = false;
            try{
                String URL = "https://loawa.com/";
                Connection conn = Jsoup.connect(java.net.URLDecoder.decode(URL,"UTF-8"));
                Document html = conn.get();
                Elements island_elements = html.getElementsByClass("img-fluid rounded-top");
                Elements reward_elements = html.getElementsByClass("img-fluid rounded-bottom");
                for(Element element : island_elements){
                    // event.getChannel().sendMessage(element.attr("alt")+"\n").queue();
                    island.add(element.attr("alt"));
                }
                for(Element element : reward_elements){
                    reward.add(element.attr("alt"));
                }
                for(int i = 0;i<3;i++) {
                    String misland;
                    String mreward;
                    misland = (String) island.get(i);
                    mreward = (String) reward.get(i);
                    misland = misland.replace("-","");
                    mreward = mreward.replace("-","");
                    if(mreward.equals("카드")){
                        event.getChannel().sendMessage("오늘의 "+messageSent[0]+"은 ``"+ misland +"`` 입니다!").queue();
                        isreal = true;
                    }
                }
                if(!isreal){
                    event.getChannel().sendMessage("오늘은 "+messageSent[0]+"이 없네요!").queue();
                }
            } catch (Exception e) {
                event.getChannel().sendMessage("오늘의 모험섬은... 오류섬 입니다!").queue();
            }
        }

        if(messageSent[0].equalsIgnoreCase("주화섬") && !event.getMember().getUser().isBot()){
            ArrayList island = new ArrayList();
            ArrayList reward = new ArrayList();
            boolean isreal = false;
            try{
                String URL = "https://loawa.com/";
                Connection conn = Jsoup.connect(java.net.URLDecoder.decode(URL,"UTF-8"));
                Document html = conn.get();
                Elements island_elements = html.getElementsByClass("img-fluid rounded-top");
                Elements reward_elements = html.getElementsByClass("img-fluid rounded-bottom");
                for(Element element : island_elements){
                    // event.getChannel().sendMessage(element.attr("alt")+"\n").queue();
                    island.add(element.attr("alt"));
                }
                for(Element element : reward_elements){
                    reward.add(element.attr("alt"));
                }
                for(int i = 0;i<3;i++) {
                    String misland;
                    String mreward;
                    misland = (String) island.get(i);
                    mreward = (String) reward.get(i);
                    misland = misland.replace("-","");
                    mreward = mreward.replace("-","");
                    if(mreward.equals("주화")){
                        event.getChannel().sendMessage("오늘의 "+messageSent[0]+"은 ``"+ misland +"`` 입니다!").queue();
                        isreal = true;
                    }
                }
                if(!isreal){
                    event.getChannel().sendMessage("오늘은 "+messageSent[0]+"이 없네요!").queue();
                }
            } catch (Exception e) {
                event.getChannel().sendMessage("오늘의 모험섬은... 오류섬 입니다!").queue();
            }
        }

        if(messageSent[0].equalsIgnoreCase("실링섬") && !event.getMember().getUser().isBot()){
            ArrayList island = new ArrayList();
            ArrayList reward = new ArrayList();
            boolean isreal = false;
            try{
                String URL = "https://loawa.com/";
                Connection conn = Jsoup.connect(java.net.URLDecoder.decode(URL,"UTF-8"));
                Document html = conn.get();
                Elements island_elements = html.getElementsByClass("img-fluid rounded-top");
                Elements reward_elements = html.getElementsByClass("img-fluid rounded-bottom");
                for(Element element : island_elements){
                    // event.getChannel().sendMessage(element.attr("alt")+"\n").queue();
                    island.add(element.attr("alt"));
                }
                for(Element element : reward_elements){
                    reward.add(element.attr("alt"));
                }
                for(int i = 0;i<3;i++) {
                    String misland;
                    String mreward;
                    misland = (String) island.get(i);
                    mreward = (String) reward.get(i);
                    misland = misland.replace("-","");
                    mreward = mreward.replace("-","");
                    if(mreward.equals("실링")){
                        event.getChannel().sendMessage("오늘의 "+messageSent[0]+"은 ``"+ misland +"`` 입니다!").queue();
                        isreal = true;
                    }
                }
                if(!isreal){
                    event.getChannel().sendMessage("오늘은 "+messageSent[0]+"이 없네요!").queue();
                }
            } catch (Exception e) {
                event.getChannel().sendMessage("오늘의 모험섬은... 오류섬 입니다!").queue();
            }
        }
    }
}
