package in.at.maven;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
    public String prefix = "-";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String command = args[0];
        if (event.getAuthor().isBot()) return;

        if (command.equalsIgnoreCase(prefix + "test"))
            event.getMessage().reply("This bot is working!").queue();
        else if (command.equalsIgnoreCase(prefix + "embed_test")) {
            EmbedBuilder embed = new EmbedBuilder();
            // title, url
            embed.setTitle("Testing the embed...", "");
            embed.setColor(Color.BLUE);
            embed.setDescription("It's working!");
            // embed section; @param(title,description,inline)
            embed.addField("How's your day today?", "Pretty good.", false);

            // footer
            embed.setFooter("by AJ Uhm");
            event.getChannel().sendMessageEmbeds(embed.build()).queue();
            embed.clear(); // clear the embed after use
        }
    }
}

