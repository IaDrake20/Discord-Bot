import net.dv8tion.jda.core.JDA;


public class ToasterBot {

    public static JDA jda;

    public static void main(String[]args){

        jda = new JDABuilder(AccountType.BOT).setToken(hi).buildAsync();
    }
}
