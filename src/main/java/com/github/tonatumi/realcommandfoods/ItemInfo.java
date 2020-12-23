package com.github.tonatumi.realcommandfoods;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemInfo {
    RealCommandFoods plugin = new RealCommandFoods();
    HashMap<ItemStack,String> contentsCommands = new HashMap<ItemStack,String>();

    public void setContentsCommands(String args){
        for(String cfgdata : YamlConfiguration.loadConfiguration(plugin.file).getStringList("plugins/RealCommandFoods/Items.yml")){
            ArrayList<String> commandList = new ArrayList<String>();
            int commandLineIndex;
            String commandLine;
            commandList.add(commandLine.substring());
            int itemNameIndex = cfgdata.indexOf("MCItemName:");
            String itemName = cfgdata.substring(itemNameIndex+1);
            contentsCommands.put(,commandList);

        }
    }
}
