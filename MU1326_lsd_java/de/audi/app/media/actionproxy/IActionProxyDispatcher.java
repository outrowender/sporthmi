/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.actionproxy;

import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public interface IActionProxyDispatcher {
    public void addActionProxyListener(int var1, int var2, IActionProxyListener var3);

    public void removeActionProxyListener(int var1, IActionProxyListener var2);

    public void notifyActionProxyCall(int var1, int var2, Map var3);

    public LogChannel getLogChannel();
}

