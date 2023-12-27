package me.minegamersg.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.minegamersg.Main.Main;

public class ChestSystem
{
  Main plugin;
  
  public ChestSystem(Main paramMain)
  {
    this.plugin = paramMain;
  }
  
  @SuppressWarnings("deprecation")
public ItemStack toItem(String paramString)
  {
    ItemStack localItemStack = null;
    ItemMeta localItemMeta = null;
    
    String[] arrayOfString1 = paramString.split(" ");
    String[] arrayOfString2 = arrayOfString1[0].split(":");
    String[] arrayOfString3 = null;
    String[] arrayOfString4 = null;
    Integer localInteger = Integer.valueOf(1);
    if (arrayOfString1.length > 1) {
      localInteger = Integer.valueOf(Integer.parseInt(arrayOfString1[1]));
    }
    if (arrayOfString1.length > 2)
    {
      if (arrayOfString1[2].contains("enchant")) {
        arrayOfString3 = arrayOfString1[2].split(":");
      }
      if (arrayOfString1[2].contains("name")) {
        arrayOfString4 = arrayOfString1[2].split(":");
      }
    }
    if (arrayOfString1.length > 3)
    {
      if (arrayOfString1[3].contains("enchant")) {
        arrayOfString3 = arrayOfString1[3].split(":");
      }
      if (arrayOfString1[3].contains("name")) {
        arrayOfString4 = arrayOfString1[3].split(":");
      }
    }
    if (arrayOfString2.length > 1) {
      localItemStack = new ItemStack(Integer.parseInt(arrayOfString2[0]), localInteger.intValue(), (short)0, Byte.valueOf((byte)Integer.parseInt(arrayOfString2[1])));
    } else if (arrayOfString2.length > 0) {
      localItemStack = new ItemStack(Integer.parseInt(arrayOfString2[0]), localInteger.intValue());
    }
    if ((arrayOfString3 != null) && (arrayOfString3.length > 1)) {
      if (arrayOfString3.length > 2) {
        localItemStack.addUnsafeEnchantment(Enchantment.getByName(arrayOfString3[1]), Integer.parseInt(arrayOfString3[2]));
      } else {
        localItemStack.addUnsafeEnchantment(Enchantment.getByName(arrayOfString3[1]), 1);
      }
    }
    if ((arrayOfString4 != null) && (arrayOfString4.length > 1))
    {
      localItemMeta = localItemStack.getItemMeta();
      localItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', arrayOfString4[1].replaceAll("_", " ")));
      localItemStack.setItemMeta(localItemMeta);
    }
    return localItemStack;
  }
  
  public Integer getType()
  {
    if (this.plugin.chest.getCustomConfig().getBoolean("Random-Only.enable")) {
      return Integer.valueOf(0);
    }
    if (this.plugin.chest.getCustomConfig().getBoolean("Custom-Chests.enable")) {
      return Integer.valueOf(1);
    }
    return Integer.valueOf(0);
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
public void fillTier1(Inventory paramInventory)
  {
    ArrayList localArrayList = new ArrayList();
    List<String> localList = null;
    int i = new Random().nextInt(this.plugin.chest.getCustomConfig().getInt("Max-Items-Per-Chest") - this.plugin.chest.getCustomConfig().getInt("Min-Items-Per-Chest") + 1) + this.plugin.chest.getCustomConfig().getInt("Min-Items-Per-Chest");
    int j = 0;
    for (int k = 0; k < paramInventory.getSize(); k++) {
      localArrayList.add(Integer.valueOf(k));
    }
    Collections.shuffle(localArrayList);
    if (getType().intValue() == 0)
    {
      if (this.plugin.chest.getCustomConfig().getStringList("Random-Only.list-of-items").size() >= i) {
        localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Random-Only.list-of-items"), i);
      } else {
        localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Random-Only.list-of-items"), this.plugin.chest.getCustomConfig().getStringList("Random-Only.list-of-items").size());
      }
    }
    else if (this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier1-items").size() >= i) {
      localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier1-items"), i);
    } else {
      localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier1-items"), this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier1-items").size());
    }
    for (String str : localList)
    {
      paramInventory.setItem(((Integer)localArrayList.get(j)).intValue(), toItem(str));
      j++;
    }
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
public void fillTier2(Inventory paramInventory, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    List<String> localList = null;
    int i = new Random().nextInt(this.plugin.chest.getCustomConfig().getInt("Max-Items-Per-Chest") - this.plugin.chest.getCustomConfig().getInt("Min-Items-Per-Chest") + 1) + this.plugin.chest.getCustomConfig().getInt("Min-Items-Per-Chest");
    int j = 0;
    for (int k = 0; k < paramInventory.getSize(); k++) {
      localArrayList.add(Integer.valueOf(k));
    }
    Collections.shuffle(localArrayList);
    if (paramBoolean)
    {
      if (this.plugin.chest.getCustomConfig().getStringList("Enderchest-As-Tier2.tier2-items").size() >= i) {
        localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Enderchest-As-Tier2.tier2-items"), i);
      } else {
        localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Enderchest-As-Tier2.tier2-items"), this.plugin.chest.getCustomConfig().getStringList("Enderchest-As-Tier2.tier2-items").size());
      }
    }
    else if (this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier2-items").size() >= i) {
      localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier2-items"), i);
    } else {
      localList = pickRandomItem(this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier2-items"), this.plugin.chest.getCustomConfig().getStringList("Custom-Chests.tier2-items").size());
    }
    for (String str : localList)
    {
      paramInventory.setItem(((Integer)localArrayList.get(j)).intValue(), toItem(str));
      j++;
    }
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
private List<String> pickRandomItem(List<String> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Object localObject = new ArrayList(paramInt);
    for (Iterator localIterator = paramList.iterator(); localIterator.hasNext();)
    {
      localObject = (String)localIterator.next();
      localArrayList.add(localObject);
    }
    Collections.shuffle(localArrayList);
    
    //TODO Object localObject = new ArrayList(paramInt);
    for (int i = 0; i < paramInt; i++) {
      ((List)localObject).add((String)localArrayList.get(i));
    }
    return (List<String>) localObject;
  }
}
