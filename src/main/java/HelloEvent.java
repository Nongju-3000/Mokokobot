import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class HelloEvent extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equalsIgnoreCase("추첨") && !event.getMember().getUser().isBot()) {
            ArrayList object = new ArrayList();
            try {
                for (int i = 2; i < messageSent.length; i++) {
                    object.add(messageSent[i]);
                }
                Collections.shuffle(object);
                if(Integer.parseInt(messageSent[1]) > object.size() || Integer.parseInt(messageSent[1])<=0){
                    throw new Exception();
                }
                for (int i = 0; i < Integer.parseInt(messageSent[1]); i++) {
                    event.getChannel().sendMessage(object.get(i) + " ").queue();
                }
                event.getChannel().sendMessage("당첨!").queue();
            } catch (Exception e)
            {
                event.getChannel().sendMessage("올바르지 않은 형식입니다!\n추첨 2 실리안 아만 카마인 과 같은 형식으로 입력해주세요!").queue();
            }
        }

        try {
            if (messageSent[0].equalsIgnoreCase("달리는모코코야") && messageSent[1].equalsIgnoreCase("도와줘") && !event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("예아! 부르셨습니까?").queue();
                event.getChannel().sendMessage("추첨 기능을 이용하려면 ``추첨`` ``뽑을개수`` ``항목1`` ``항목2`` ``항목3`` 같은 형식으로 입력하십쇼\n" +
                        "사사게 검색 기능을 이용하려면 ``사사게`` ``키워드`` 형식으로 입력하십쇼\n" +
                        "경매 최적가 기능을 이용하려면 ``경매`` ``파티원수`` ``아이템 거래소 가격`` 형식으로 입력하십쇼\n" +
                        "모험섬이 알고싶으면 ``모험섬`` 이라고 치십쇼\n" +
                        "그럼 전 이만 가보겠습니다~").queue();
            }
            else if (messageSent[0].equalsIgnoreCase("달리는모코코야") && !event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("왜? 혹시 도움이 필요하면 ``달리는모코코야 도와줘`` 라고 입력해!").queue();
            }
        } catch (Exception e){}

        if(messageSent[0].equalsIgnoreCase("경매") && !event.getMember().getUser().isBot()){
            float price;
            int good_price;
            int member;
            try{
                member = Integer.parseInt(messageSent[1]);
                price = Float.parseFloat(messageSent[2]);
                if(price <0){
                    throw new Exception();
                }
                if(member == 4){
                    good_price = (int) (price * 0.71);
                    if(good_price < 50){
                        event.getChannel().sendMessage("https://i.ytimg.com/vi/mINzmG4Hugc/maxresdefault.jpg").queue();
                    }
                    else{
                        event.getChannel().sendMessage("거래소 가격 ``"+ (int) price + "``골드 의 ``" + member + "`` 인 파티 입찰 최적가는 ``"+ good_price +"``골드 입니다!").queue();
                    }
                }

                else if(member == 8){
                    good_price = (int) (price * 0.83);
                    if(good_price < 50){
                        event.getChannel().sendMessage("https://i.ytimg.com/vi/mINzmG4Hugc/maxresdefault.jpg").queue();
                        event.getChannel().sendMessage("입찰 못하는 대신 이 골드를 드리겠습니다.").queue();
                    }
                    else {
                        event.getChannel().sendMessage("거래소 가격 ``" + (int) price + "``골드 의 ``" + member + "`` 인 파티 입찰 최적가는 ``" + good_price + "``골드 입니다!").queue();
                    }
                }

                else if(member == 16){
                    good_price = (int) (price * 0.89);
                    if(good_price < 50){
                        event.getChannel().sendMessage("https://i.ytimg.com/vi/mINzmG4Hugc/maxresdefault.jpg").queue();
                        event.getChannel().sendMessage("입찰 못하는 대신 이 골드를 드리겠습니다.").queue();
                    }
                    else {
                        event.getChannel().sendMessage("거래소 가격 ``" + (int) price + "``골드 의 ``" + member + "`` 인 파티 입찰 최적가는 ``" + good_price + "``골드 입니다!").queue();
                    }
                }

                else{
                    event.getChannel().sendMessage(member +"명이서 가는 레이드도 있어요?").queue();
                }

            } catch (Exception e){
                event.getChannel().sendMessage("뭐라 씨부리노 똑바로 쓰라").queue();
            }
        }

        if(Integer.parseInt(messageSent[0]) > 0 && !event.getMember().getUser().isBot()){
            float price;
            int good_price;
            try{
                price = Float.parseFloat(messageSent[0]);
                good_price = (int) (price * 0.71);
                if(good_price < 50){
                    event.getChannel().sendMessage("https://i.ytimg.com/vi/mINzmG4Hugc/maxresdefault.jpg").queue();
                    event.getChannel().sendMessage("입찰 못하는 대신 이 골드를 드리겠습니다.").queue();
                    throw new Exception();
                }
                else {
                    event.getChannel().sendMessage("거래소 가격 ``" + (int) price + "``골드 의 ``4`` 인 파티 입찰 최적가는 ``" + good_price + "``골드 입니다!").queue();
                }
                good_price = (int) (price * 0.83);
                event.getChannel().sendMessage("거래소 가격 ``"+ (int) price + "``골드 의 ``8`` 인 파티 입찰 최적가는 ``"+ good_price +"``골드 입니다!").queue();
            } catch (Exception e){ }
        }
    }
}
