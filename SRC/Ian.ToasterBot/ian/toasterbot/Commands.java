package ian.toasterbot;

//import net.dv8tion.jda.api.entities.Invite.Guild;
import net.dv8tion.jda.api.events.message.;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
    
    //guild means the discord server
    public void onGuildMessageRecieved(Guild event){

        String[] args = event.getMessage().getContentRaw().split(" ");

    }
}
