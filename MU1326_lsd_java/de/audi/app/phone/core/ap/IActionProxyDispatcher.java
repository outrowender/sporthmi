/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.ap;

import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public interface IActionProxyDispatcher {
    public void init();

    public void deinit();

    public void addActionProxyListener(int var1, IActionProxyListener var2);

    public void removeActionProxyListener(int var1, IActionProxyListener var2);

    public void notifyActionProxyCall(int var1, Map var2);

    public LogChannel getAPLogChannel();
}

