package com.hubox.demo.netty.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * 关于ByteBuf的使用例子
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/6 20:16
 */
public class ByteBufExamples {

    public static final ByteBuf BUF = Unpooled.copiedBuffer("Netty in action rocks!", CharsetUtil.UTF_8);

    public static void main(String[] args) {
        ByteBufReadWrite();
    }

    /**
     * read*() 和 write*() 会改变索引
     **/
    public static void ByteBufReadWrite() {
        System.out.println((char) BUF.readByte());
        int readerIndex = BUF.readerIndex();
        int writerIndex = BUF.writerIndex();
        BUF.writeByte('?');
        assert readerIndex == BUF.readerIndex();
        assert writerIndex != BUF.writerIndex();
    }


}
