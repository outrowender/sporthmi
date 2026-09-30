/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.atip.msg.MsgListener;

public interface IMessageDispatcher {
    public void init();

    public void deinit();

    public void addMessageListener(int var1, MsgListener var2);

    public void removeMessageListener(int var1, MsgListener var2);
}

