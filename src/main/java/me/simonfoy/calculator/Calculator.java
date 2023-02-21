package me.simonfoy.calculator;

import org.bukkit.plugin.java.JavaPlugin;

public final class Calculator extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("calc").setExecutor(new CalculatorCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
