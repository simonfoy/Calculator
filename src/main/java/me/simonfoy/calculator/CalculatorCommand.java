package me.simonfoy.calculator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CalculatorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("calc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length != 3) {
                    player.sendMessage("Usage: /calc <number1> <operator> <number2>");
                    return true;
                }
                double num1 = Double.parseDouble(args[0]);
                String operator = args[1];
                double num2 = Double.parseDouble(args[2]);
                double result = 0;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            player.sendMessage("Error: division by zero");
                            return true;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        player.sendMessage("Invalid operator: " + operator);
                        return true;
                }
                player.sendMessage(num1 + " " + operator + " " + num2 + " = " + result);
            } else {
                sender.sendMessage("This command can only be executed by a player.");
            }
            return true;
        }
        return false;
    }
}
