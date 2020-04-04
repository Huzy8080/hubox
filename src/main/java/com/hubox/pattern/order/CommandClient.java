package com.hubox.pattern.order;

import cn.hutool.core.thread.ThreadUtil;

/**
 * 请求者
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/4 17:21
 */
public class CommandClient {

    public static void main(String[] args) {
        Command[] commands = new Command[2];
        Receiver receiver = new Receiver("joe");
        DoSomethingCommand command = new DoSomethingCommand(receiver);
        commands[0] = command;
        Receiver receiver2 = new Receiver("ang");
        DoSomethingCommand command2 = new DoSomethingCommand(receiver2);
        commands[1] = command2;
        CommandInvoker invoker = new CommandInvoker(commands);
        invoker.doCommand(0);
        invoker.doCommand(1);
        ThreadUtil.newExecutor();
    }

}
