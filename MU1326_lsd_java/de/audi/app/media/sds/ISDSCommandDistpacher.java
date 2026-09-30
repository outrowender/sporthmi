/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.ISDSCommandListener;
import java.util.Map;

public interface ISDSCommandDistpacher {
    public void addCommandListener(int var1, ISDSCommandListener var2);

    public void removeCommandListener(int var1, ISDSCommandListener var2);

    public Object notifyCommand(int var1, int var2, Map var3);
}

