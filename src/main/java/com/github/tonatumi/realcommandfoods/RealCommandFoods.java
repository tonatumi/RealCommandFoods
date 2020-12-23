package com.github.tonatumi.realcommandfoods;

import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class RealCommandFoods extends JavaPlugin {

    ArrayList<ItemStack> itemdata = new ArrayList<ItemStack>();

    boolean onoff = true;

    public static File file = new File("plugins/RealCommandFoods", "Items.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void showHelp(Player p) {
        p.sendMessage("§e-------§r" + "RCF" + "§e-------§r");
        p.sendMessage("§6§l/rcf list§r:箱のリストを表示");
        p.sendMessage("§6§l/rcf give [Item番号]§r:[Item番号]を与える");
    }

    public void showItemList(Player p){
        p.sendMessage("-----アイテムリスト-----");
        for(int i=0; i<=itemdata.size(); i++){
            p.sendMessage(i+":"+itemdata.get(i).toString());

        }
    }

    public void giveItem(Player p, int args){
        p.getInventory().addItem(itemdata.get(args));

    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("start:RealCommandFoods");
        getCommand("RCF").setExecutor(new RCFCommand(this));
        getServer().getPluginManager().registerEvents(new Events(this), this);
        Object obj = null;
        try {
            obj = new File("plugins/RealCommandFoods/Items.yml");
        }
        catch(IllegalArgumentException exception){
            getLogger().info(exception.getMessage());
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try{
            cfg.save(new File("plugins/RealCommandFoods/Items.yml"));
        }
        catch(IOException exception){
            getLogger().info(exception.getMessage());
        }
        getLogger().info("stop:RealCommandFoods");

    }
}
