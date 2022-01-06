

public class ToasterBot {

    public static JDA jda;

    public static void main(String[]args){

        jda = new JDABuilder(AccountType.BOT).setToken(ODg4MDUwNTE4ODUxNzMxNDY2.YUNDfg.N1szM9_qdKF6yPmtxYbX4c_kjus).buildAsync();
    }
    
    public class CommandName implements ServerCommand {
    
        @Override
        public void performCommand(Member member, TextChannel channel, Message message) {
    
            channel.sendMessage("template command");
    
        }
    }
}
