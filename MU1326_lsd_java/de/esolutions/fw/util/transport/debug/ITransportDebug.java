/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.debug;

public interface ITransportDebug {
    public static final int TX_FLAG = 1;
    public static final int RX_FLAG = 2;
    public static final int INSIDE_FLAG = 4;
    public static final int ENTER_FLAG = 8;
    public static final int LEAVE_FLAG = 16;
    public static final int ERROR_FLAG = 32;
    public static final int SYSCALL_FLAG = 256;
    public static final int PACKET_FLAG = 512;
    public static final int QUEUE_FLAG = 1024;
    public static final int APP_FLAG = 2048;
    public static final int CALLBACK_FLAG = 4096;
    public static final int RX_ENTER_SYSCALL = 266;
    public static final int RX_LEAVE_SYSCALL = 274;
    public static final int RX_ERROR_SYSCALL = 290;
    public static final int TX_ENTER_SYSCALL = 265;
    public static final int TX_LEAVE_SYSCALL = 273;
    public static final int TX_ERROR_SYSCALL = 289;
    public static final int RX_ENTER_PACKET = 522;
    public static final int RX_INSIDE_PACKET = 518;
    public static final int RX_LEAVE_PACKET = 530;
    public static final int RX_ERROR_PACKET = 546;
    public static final int TX_ENTER_PACKET = 521;
    public static final int TX_INSIDE_PACKET = 517;
    public static final int TX_LEAVE_PACKET = 529;
    public static final int TX_ERROR_PACKET = 545;
    public static final int RX_ENTER_QUEUE = 1034;
    public static final int RX_LEAVE_QUEUE = 1042;
    public static final int RX_ERROR_QUEUE = 1058;
    public static final int TX_ENTER_QUEUE = 1033;
    public static final int TX_LEAVE_QUEUE = 1041;
    public static final int TX_ERROR_QUEUE = 1057;
    public static final int RX_ENTER_APP = 2058;
    public static final int RX_INSIDE_APP = 2054;
    public static final int RX_LEAVE_APP = 2066;
    public static final int RX_ERROR_APP = 2082;
    public static final int TX_ENTER_APP = 2057;
    public static final int TX_INSIDE_APP = 2053;
    public static final int TX_LEAVE_APP = 2065;
    public static final int TX_ERROR_APP = 2081;
    public static final int RX_ENTER_CALLBACK = 4106;
    public static final int RX_INSIDE_CALLBACK = 4102;
    public static final int RX_LEAVE_CALLBACK = 4114;
    public static final int RX_ERROR_CALLBACK = 4130;
    public static final int TX_ENTER_CALLBACK = 4105;
    public static final int TX_INSIDE_CALLBACK = 4101;
    public static final int TX_LEAVE_CALLBACK = 4113;
    public static final int TX_ERROR_CALLBACK = 4129;

    public void log(long var1, int var3, int var4, Object var5);
}

