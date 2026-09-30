/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

public interface MenuHKReturnBehavior {
    public static final int IGNORE_HK_RETURN = 0;
    public static final int NOTIFY_APPLICATION = 1;
    public static final int JUMP_TO_START_OF_MENU = 2;
    public static final int JUMP_TO_START_OF_LIST = 3;
    public static final int JUMP_ITEM_BEFORE_LIST = 4;
}

