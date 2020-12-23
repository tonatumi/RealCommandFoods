package com.github.tonatumi.realcommandfoods;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RCFCommand implements CommandExecutor{

    private final RealCommandFoods plugin;

    public RCFCommand(RealCommandFoods plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //コマンドの送り主が実際のプレイヤーではないときの処理
        if (!(sender instanceof Player)) {
            return true;
        }


        Player p = (Player) sender;
        if(plugin.onoff){

             //RCFのとき
             if (label.equalsIgnoreCase("RCF") && args.length == 0) {
            //コマンドヘルプを表示
            plugin.showHelp(p);
            return true;
             }

             //rcf [引数]のとき
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    plugin.showItemList(p);
                    return true;
                }

            }

            if (args[0].equalsIgnoreCase("give")) {
                if (args.length == 2 || args.length >=3 ) {
                    p.sendMessage("コマンドが間違っています");
                    return false;
                } else {
                    plugin.giveItem(p, Integer.parseInt(args[1]));
                    return true;
                }
            }
            //コマンドが間違っているとき
            plugin.showHelp(p);
            return true;
        } else {
            return false;
        }


    }


}


