package com.hubox.pattern.decorator;

import com.hubox.util.Args;
import lombok.Data;

/**
 * 装饰器实现
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/4 22:12
 */
@Data
public class DiffDecorator implements DecoratorComponent {
    private DecoratorComponent component;

    @Override
    public void show() {
        System.out.println("diff-->");
        if (Args.notNull(component)) component.show();
    }
}
