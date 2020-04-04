package com.hubox.pattern.order;

/**
 * 命令实现。
 * 持有命令执行者，通过调用执行者的方法，完成命令
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/4 17:14
 */
public class DoSomethingCommand implements Command {

    private Receiver receiver;

    public DoSomethingCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doSomething();
    }
}
