package com.aang23.globaltab;

import java.util.Timer;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.checkerframework.checker.nullness.qual.NonNull;

public class CommandGlobalTab implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {
        String[] args = invocation.arguments();
        CommandSource source = invocation.source();
        if (args.length > 0) {
            if (args[0].equals("restart")) {
                TimerHandler.stop = true;

                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerHandler(),
                        Integer.parseInt((String) ConfigManager.config.get("updatedelay")) * 1000,
                        Integer.parseInt((String) ConfigManager.config.get("updatedelay")) * 1000);

                source.sendMessage(Component.text("Restarted the tab !").color(NamedTextColor.GREEN));
            } else if (args[0].equals("config")) {
                ConfigManager.setupConfig();

                source.sendMessage(Component.text("Reloaded the configuration file !").color(NamedTextColor.GREEN));
            }
        } else
            source.sendMessage(Component.text("Usage : /globaltab restart/config").color(NamedTextColor.RED));
    }
}