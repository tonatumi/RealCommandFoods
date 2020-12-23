package com.github.tonatumi.realcommandfoods;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class Events implements Listener{
    RealCommandFoods RCF;
    public Events(RealCommandFoods RCF){
        this.RCF = RCF;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        ItemInfo iteminfo = new ItemInfo();
        Player p = e.getPlayer();
        boolean flag = false;
        ItemStack item = p.getInventory().getItemInMainHand();

        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR){
            for (ItemStack a : RCF.itemdata){
                if(item.getType() == a.getType()){
                    if(item.getItemMeta() == null || item.getItemMeta().toString().equalsIgnoreCase(a.getItemMeta().toString()));
                    flag = true;
                    e.setCancelled(true);
                    break;
                }
            }
        }

        if(flag){

            p.chat(iteminfo.contentsCommands.get(item));
        }


    }


}
