package ian.toasterbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotStartUp {
 
    public static void main(String[]args) throws LoginException{

        //remember to remove the token before pushing to Github and to add it back after
        JDABuilder jda = JDABuilder.createDefault("ODg4MDUwNTE4ODUxNzMxNDY2.YUNDfg.ojIJq6-9-8h-zRv1ni5Q0C-UrSY");
        jda.setActivity(Activity.listening("Children of the Omnissiah"));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.addEventListeners(new Commands());
        jda.build();
    }
}
