package me.minegamersg.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.minegamersg.Main.Main;

public class Chest
{
  public File customYml;
  public FileConfiguration customConfig;
  Main plugin;
  
  public Chest(Main paramMain)
  {
    this.plugin = paramMain;
  }
  
  public void saveCustomConfig()
  {
    try
    {
      this.customConfig.save(this.customYml);
    }
    catch (IOException localIOException)
    {
      Main.getSGAPI().log.warning("[BSG] Cannot load CHEST.yml FILE!");
      Main.getSGAPI().log.warning("[BSG] ERROR: " + localIOException);
    }
  }
  
  public FileConfiguration getCustomConfig()
  {
    return this.customConfig;
  }
  
  public File getCustomFile()
  {
    return this.customYml;
  }
  
  @SuppressWarnings("deprecation")
public void copyDefaults()
  {
    InputStream localInputStream = this.plugin.getResource("chest.yml");
    YamlConfiguration localYamlConfiguration = YamlConfiguration.loadConfiguration(localInputStream);
    
    this.customConfig.setDefaults(localYamlConfiguration);
    
    this.customConfig.options().copyDefaults(true);
    this.customConfig.options().copyDefaults();
  }
  
  public void reloadCustomConfig()
  {
    if (this.customYml == null) {
      this.customYml = new File(this.plugin.getDataFolder(), "chest.yml");
    }
    this.customConfig = YamlConfiguration.loadConfiguration(this.customYml);
    

    InputStream localInputStream = this.plugin.getResource("chest.yml");
    if (localInputStream != null)
    {
      @SuppressWarnings("deprecation")
	YamlConfiguration localYamlConfiguration = YamlConfiguration.loadConfiguration(localInputStream);
      this.customConfig.setDefaults(localYamlConfiguration);
    }
  }
}
