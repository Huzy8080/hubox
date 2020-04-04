package com.hubox.pattern.order;

/**
 * 持有命令的某个容器
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/4 17:19
 */
public class CommandInvoker {

    private Command[] commands = new Command[2];

    public CommandInvoker(Command[] commands) {
        this.commands = commands;
    }

    public void doCommand(int index) {
        commands[index].execute();
    }
}
