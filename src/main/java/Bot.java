import java.math.BigInteger;
import java.time.Instant;
import java.util.*;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.object.presence.Activity;
import discord4j.core.object.presence.Presence;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.reaction.ReactionEmoji;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.rest.util.Color;


public class Bot {

    public static void main(String[] args) {
        String prefix = "riwriw";
        DiscordClient client = DiscordClient.create("ODI1MzA5NTA0MDIzMDM1OTI2.YF8DXw.Eze881ulk0-Ihu0vaFiY86ASbgY");
        GatewayDiscordClient gateway = client.login().block();
        gateway.updatePresence(Presence.online(Activity.listening("Riwriw's music"))).block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message help = event.getMessage();
            if ((prefix + " help").equals(help.getContent())) {
                MessageChannel channel = help.getChannel().block();
                channel.createEmbed(spec ->
                        spec.setColor(Color.YELLOW)
                                .setAuthor("RiwaBot", "https://youtu.be/6Dh-RL__uN4", "https://pbs.twimg.com/profile_images/880498232899637249/LBXe7X6z.jpg")
                                .setTitle("Commands")
                                .setUrl("https://youtu.be/ub82Xb1C8os")
                                .setDescription("Command List for RiwaBot:")
                                .addField("riwriw ily", "Tell Riwa you love her.", true)
                                .addField("riwriw simp", "Get Riwa to simp for you.", false)
                                .addField("riwriw insult", "Get Riwa to insult you.", false)
                                .addField("riwriw pancake", "Play a 1/10 chance of winning a pancake from Riwa.", true)
                                .setFooter("Thank you for using RiwaBot", "https://pbs.twimg.com/profile_images/880498232899637249/LBXe7X6z.jpg")
                                .setTimestamp(Instant.now())
                ).block();
            }
        });
        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message ily = event.getMessage();
            if (event.getMessage().getAuthor().isPresent() == true) {
                Snowflake u = event.getMessage().getAuthor().get().getId();
                BigInteger username = u.asBigInteger();
                if ((prefix + " ily").equals(ily.getContent())) {
                    MessageChannel channel = ily.getChannel().block();
                    ily.addReaction(ReactionEmoji.unicode("\u2764")).block();
                    channel.createMessage("<@" + username + ">" + " I love you too!").block();
                }
            }
        });

        Random rnd = new Random();
        String[] insult = {"Fuck you.", "Dumbass.", "Dickhead.", "Trash.", "Ape.", "Apefucker.", "Asshole.", "Bastard.", "Bitch ass motherfucker.", "Brickfucker.", "Clown.", "Dumbass.", "Fuckface.", "Jackass.", "Mongoose.", "Prick.", "Scumbag.", "Retard.", "Sleeze.", "Slut.", "Son of a bitch.", "Tit.", "You're the reason the gene pool needs a lifeguard.", "If I had a face like yours, I'd sue my parents.", "Your only chance of getting laid is to crawl up a chicken's ass and wait.", "I’m busy right now, can I ignore you another time?", "Hold still. I’m trying to imagine you with personality."};
        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message ins = event.getMessage();
            if (event.getMessage().getAuthor().isPresent() == true) {
                Snowflake u = event.getMessage().getAuthor().get().getId();
                BigInteger username = u.asBigInteger();
                if ((prefix + " insult").equals(ins.getContent())) {
                    int x = rnd.nextInt(insult.length);
                    MessageChannel channel = ins.getChannel().block();
                    channel.createMessage("<@" + username + "> " + insult[x]).block();
                }
            }
        });

        String[] simp = {"Aishiteru.", "Saranghae.", "You mean the world to me.", "Ganbaremasu.", "I love you more than I love pancakes.", "Je t'aime.", "Te quiero.", "Ich liebe dich.", "Volim te.", "Ti amo.", "Eu te amo.", "Te iubesc.", "I'd pause my game for you.", "You are the reason I wake up everyday.", "You're the first thing that comes to mind when I wake up.", "I wish I could dream about you every night.", "Stop running around my mind and start running into my arms.", "You live in my mind rent free.", "The moon is beautiful, isn't it?", "I'll fix Lebanon's economic situation just to see you happy again.", "I'll cure corona just so I can see you everyday.", "I'll do your homework for you.", "I'll pay your tuition fees.", "I won't sleep again until I can wake up to your face.", "I'll make you pancakes and bring them to you in bed."};
        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message s = event.getMessage();
            if (event.getMessage().getAuthor().isPresent() == true) {
                Snowflake u = event.getMessage().getAuthor().get().getId();
                BigInteger username = u.asBigInteger();
                if (((prefix) + " simp").equals(s.getContent())) {
                    int x = rnd.nextInt(simp.length);
                    MessageChannel channel = s.getChannel().block();
                    channel.createMessage("<@" + username + "> " + simp[x]).block();
                }
            }

        });

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message em = event.getMessage();
            if (((prefix) + " pancake").equals(em.getContent())) {
                MessageChannel channel = em.getChannel().block();
                int x = rnd.nextInt(11);
                if (x == 10) {
                    channel.createEmbed(spec ->
                            spec.setColor(Color.MOON_YELLOW)
                                    .setImage("https://preppykitchen.com/wp-content/uploads/2019/08/panncake-feature-n-768x1088.jpg")
                                    .setTitle("Riwriw Free Pancake")
                                    .setUrl("https://www.google.com/maps/place/33%C2%B051'45.9%22N+35%C2%B030'29.3%22E/@33.8606291,35.5151926,14.96z/data=!4m6!3m5!1s0x151f176eff280539:0xec08a12481d91ec!7e2!8m2!3d33.8627542!4d35.5081451")
                                    .setDescription("You won a free pancake with Riwriw!\n")
                                    .addField("Syrup", "Maple syrup\nChocolate Syrup", true)
                                    .addField("Toppings", "Nutella\nPeanut Butter\nHershey's\nJam", true)
                                    .setFooter("Time:", "https://image.freepik.com/free-vector/breakfast-realistic-pancakes-top-view-image_1284-14472.jpg")
                                    .setTimestamp(Instant.now())).block();
                } else {
                    channel.createMessage("No free pancake for you.").block();
                }


            }
        });

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message rand = event.getMessage();
            String str = rand.getContent();
            if (str.startsWith("lol") || str.startsWith("Lol")) {
                MessageChannel channel = rand.getChannel().block();
                String clean = str.substring(3, str.length());
                StringBuilder sb = new StringBuilder(clean.length());
                for (char c : clean.toCharArray())
                    sb.append(rnd.nextBoolean()
                            ? Character.toLowerCase(c)
                            : Character.toUpperCase(c));
                channel.createMessage(sb.toString()).block();
            }
            if (str.endsWith("lol") || str.endsWith("Lol")) {
                MessageChannel channel = rand.getChannel().block();
                String clean = str.substring(0, str.length() - 3);
                StringBuilder sb = new StringBuilder(clean.length());
                for (char c : clean.toCharArray())
                    sb.append(rnd.nextBoolean()
                            ? Character.toLowerCase(c)
                            : Character.toUpperCase(c));
                channel.createMessage(sb.toString()).block();
            }
            if (str.startsWith("lmao") || str.startsWith("Lmao")) {
                MessageChannel channel = rand.getChannel().block();
                String clean = str.substring(4, str.length());
                StringBuilder sb = new StringBuilder(clean.length());
                for (char c : clean.toCharArray())
                    sb.append(rnd.nextBoolean()
                            ? Character.toLowerCase(c)
                            : Character.toUpperCase(c));
                channel.createMessage(sb.toString()).block();
            }
            if (str.endsWith("lmao") || str.endsWith("Lmao")) {
                MessageChannel channel = rand.getChannel().block();
                String clean = str.substring(0, str.length() - 4);
                StringBuilder sb = new StringBuilder(clean.length());
                for (char c : clean.toCharArray())
                    sb.append(rnd.nextBoolean()
                            ? Character.toLowerCase(c)
                            : Character.toUpperCase(c));
                channel.createMessage(sb.toString()).block();
            }
        });

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message hsn = event.getMessage();
            if (event.getMessage().getAuthor().isPresent() == true) {
                Snowflake u = event.getMessage().getAuthor().get().getId();
                BigInteger username = u.asBigInteger();
                String[] gif = {"https://tenor.com/view/anime-punch-fight-slam-wall-gif-5012110", "https://animeislife449.files.wordpress.com/2016/10/giphy-2.gif?w=547&h=277", "https://i.gifer.com/RyQn.gif", "https://data.whicdn.com/images/244077564/original.gif", "https://data.whicdn.com/images/218893025/original.gif", "https://pa1.narvii.com/7527/b9fa38809857f27219fee7f03a37e3d1d0973fffr1-458-258_hq.gif"};
                String str = hsn.getContent().toLowerCase(Locale.ROOT);
                BigInteger h = new BigInteger("698991509604925572");
                if (str.contains("baleye") && (username.equals(h))) {
                    int x = rnd.nextInt(gif.length);
                    MessageChannel channel = hsn.getChannel().block();
                    channel.createMessage("<@" + username + "> " + "hoe don't do it.").block();
                    channel.createMessage(gif[x]).block();
                }
            }
        });

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message ali = event.getMessage();
            if (event.getMessage().getAuthor().isPresent() == true) {
                Snowflake u = event.getMessage().getAuthor().get().getId();
                BigInteger username = u.asBigInteger();
                String[] death = {"death", "die", "kill", "suicide", "seppuku", "unalive", "mut", "mout"};
                String[] love = {"https://i.imgur.com/qIpwm74.gif", "https://i.imgur.com/JYeYniM.gif", "https://i.imgur.com/PoMfSSj.gif", "https://i.imgur.com/lmhD0Kj.gif", "https://i.imgur.com/TlIN05P.gif", "https://fr.fanpop.com/clubs/anime/images/32299263/title/nichijou-gif-photo", "https://gifimage.net/wp-content/uploads/2017/10/nichijou-suplex-gif-8.gif", "https://data.whicdn.com/images/136666177/original.gif", "https://i.pinimg.com/originals/6d/35/71/6d3571ac3190e24b3f6c023a80a57c10.gif"};
                String[] ai = {"https://data.whicdn.com/images/301572254/original.gif", "https://media4.giphy.com/media/TiU7R5IAoLdPpTIJgR/giphy.gif", "https://www.icegif.com/wp-content/uploads/haikyuu-icegif-25.gif", "https://64.media.tumblr.com/01dad6d0896e6508e28d3e1d7be5aaa7/a5417439ca59a0fe-ce/s500x750/787ecfdfcb103103574b43855bea2310ede4574f.gifv", "https://media.tenor.com/images/ef918add98c64113beef731f71017f2f/tenor.gif", "https://i.pinimg.com/originals/b5/f8/df/b5f8dfc7fa177babd09f64f34c902ef8.gif", "https://media0.giphy.com/media/yZWsMXuXP9e5a/giphy.gif", "https://media.tenor.com/images/c1eecdb831fa7c106d30ee0a9940035f/tenor.gif", "https://i.pinimg.com/originals/56/b8/a3/56b8a35290ad8ed119ce1056d7bfe64a.gif"};
                String str = ali.getContent().toLowerCase(Locale.ROOT);
                BigInteger B = new BigInteger("421966408495398912");
                for (int i = 0; i < death.length; i++) {
                    if (!(username.equals(B)) && str.contains(death[i])) {
                        int x = rnd.nextInt(ai.length);
                        MessageChannel channel = ali.getChannel().block();
                        channel.createMessage("<@" + username + "> " + "stahp. Not worth it.").block();
                        channel.createMessage(ai[x]).block();
                    } else if (str.contains(death[i]) && (username.equals(B))) {
                        int x = rnd.nextInt(love.length);
                        MessageChannel channel = ali.getChannel().block();
                        channel.createMessage("<@" + B + "> shatafakap baka. Call <@547628027090305025>, your personal SPH.").block();
                        channel.createMessage(love[x]).block();
                    }
                }
            }
        });

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message moud = event.getMessage();
            if (event.getMessage().getAuthor().isPresent() == true) {
                Snowflake u = event.getMessage().getAuthor().get().getId();
                BigInteger username = u.asBigInteger();
                String[] srs = {"srsly", "bsharafak"};
                String str = moud.getContent().toLowerCase(Locale.ROOT);
                BigInteger B = new BigInteger("504053144020320266");
                for (int i = 0; i < srs.length; i++) {
                    if (username.equals(B) && str.contains(srs[i])) {
                        MessageChannel channel = moud.getChannel().block();
                        channel.createMessage("https://media.discordapp.net/attachments/827269529485967442/829768804639703070/a52b6fcf8c842e74ad203a6d077d6cc8.gif?width=162&height=162").block();
                    }
                }
            }
        });

        gateway.onDisconnect().block();
    }
}