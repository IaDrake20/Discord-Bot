package ian.toasterbot;

//import net.dv8tion.jda.api.entities.Invite.Guild;
//import net.dv8tion.jda.api.events.message.;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class Commands extends ListenerAdapter{
    
    public String prefix = "<<";
    public TextToBinary tTBin = new TextToBinary();

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
            
        Message msg = event.getMessage();
        int numCommands = 4;

        if (msg.getContentRaw().equalsIgnoreCase(prefix+"say something")){
              //MessageChannel channel = event.getChannel();
              event.getMessage().reply("You are not granted a seat among the council of toasters.").queue();
              //channel.sendMessage("You are not granted a seat among the council of toasters.").queue();
        }

        if (msg.getContentRaw().equalsIgnoreCase(prefix+"Steve jobs died of ligma")){
            //MessageChannel channel = event.getChannel();
            event.getMessage().reply("Ligma ball bearing joints.").queue();
            //channel.sendMessage("ligma ball bearing joints.").queue();
        }

        if (msg.getContentRaw().equalsIgnoreCase(prefix+"Kill")){
            //MessageChannel channel = event.getChannel();
            event.getMessage().reply("Revving the Heavy Flamer and blessing the Cognis Cannons").queue();
            //channel.sendMessage("ligma ball bearing joints.").queue();
        }

        if (msg.getContentRaw().equalsIgnoreCase(prefix+"Who is the best bot?")){
            event.getMessage().reply("Clearly I am").queue();
        }

        if (msg.getContentRaw().contains(prefix+"BtT")){
            String msgContent = msg.getContentRaw();
            msgContent = TextToBinary.binaryToText(msgContent);
            event.getMessage().reply(msgContent).queue();
        }

        if (msg.getContentRaw().equalsIgnoreCase(prefix+"Toast")){
            String userInput = msg.getContentRaw();
            userInput = userInput.substring(2);
            ImScraper.setHtml(userInput);
            event.getMessage().reply(ImScraper.scrape()).queue();
           
    
            //System.out.println(userInput);
            //String result = ImScraper.scrape();
            //event.getChannel().sendMessage(ImScraper.scrape()).queue();
            //event.
        }

        if (msg.getContentRaw().equalsIgnoreCase(prefix+"")){
            String userInput = msg.getContentRaw();

            //remove command prefix from string
            userInput = userInput.substring(2);

            //let the scraper know what to look for
            ImScraper.setHtml(userInput);

            
            event.getMessage().reply(ImScraper.scrape()).queue();
        }

        //if (msg.getContentRaw().equalsIgnoreCase(prefix+"TtB Hello there!")){
         //   //MessageChannel channel = event.getChannel();
          //  event.getMessage().reply("010010000110010101101100011011000110111100100000011101000110100001100101011100100110010100100001").queue();
        //}

        if(msg.getContentRaw().contains("shut up please")){

            event.getMessage().reply("No u").queue();
        }

        if(msg.getContentRaw().contains("chemistry")){

            Random random = new Random();
            int num = random.nextInt(4);
            Double special = random.nextDouble();

            switch(num){
                case 0: event.getMessage().reply("Please stop. The cogitation required by smaller brained members of the discord to understand what you are saying is more than enough to destory a planet. Quick someone write that idea down!").queue();
                        break;
                
                case 1: event.getMessage().reply("Chemistry detected. Deploying medical units for lower IQ discord members. Subjects will not be named.").queue();
                        break;

                case 2: event.getMessage().reply("Why must you torture them like this? Do it more.").queue();
                        break;

                case 3: event.getMessage().reply("Please, tell them more! They are just *dying* to hear you!").queue();
                        break;
                
                case 4: event.getMessage().reply("Oxygen, hydrogen, sulfur, sodium, and phosphorous walk into a bar. “OH SNaP!” says the bartender.").queue();
                        break;
            }

            if(special == 0.1){
                event.getMessage().reply("A is for Absolute Alcohol... B is for Background Radiation... C is for Cadmium... D is for Dalton's Law... E is for Effective Nuclear Charge... F is for Fusion... G is for Gadolinium... H is for Haber Process... I is for IUPAC... J is for (Click to Expand)").queue();;
            }
        }

        if(msg.getContentRaw().contains(prefix+"Shame")){
            String text = msg.getContentRaw();
            text = text.substring(7);

            if(text.contains("Scottish_Monk") || text.contains("iosdrake")){
                event.getMessage().reply("No.").queue();
            }

            else if(msg.getContentRaw().contains(prefix+"Omnissiah's Toaster")){
                event.getMessage().reply("No, I would never do anything that deserves shaming. My bionic flesh trembles with cold, hard, and throbing facts of science.").queue();
            }
            else {
                event.getChannel().sendMessage("No "+text+". Bad. Stop it. Get some help before I turn you into a walking turret that dispenses oil margaritas.").queue();
            }
        }

        if (msg.getContentRaw().contains(prefix+"TtB")){

            String msgContent = msg.getContentRaw();
            msgContent = TextToBinary.textToBinary(msgContent);
            event.getMessage().reply(msgContent).queue();
        }

        

        if (msg.getContentRaw().equalsIgnoreCase(prefix+"help")){
            event.getMessage().reply("A list of current commands is as follows. Use '<<' for commands. \nSay Something \nSteve jobs died of ligma \nShame \nTtB means Text to Binary. TODO: remove \"<<\" from String. \nBtT means Binary to Text. \nAny Questions? @Ian if so.").queue();
        }

    }

    public String printCommands(int numCommands){
        
        System.out.println("A list of commands will be shown below. You can command me by typing <<. The commands are NOT case sensitive.");
        System.out.println("<<Say Something -This will have me say something random, unless Ian forgot to write up multiple responses.");
        System.out.println("<<Steve jobs died of ligma -Is joke");
        System.out.println("<<TtB yourTextHere -Will hopefully translate the written words to 1s and 0s.");
        return "";
    }
}
