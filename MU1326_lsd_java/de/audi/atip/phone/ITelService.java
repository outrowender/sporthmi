/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.phone.ITelServiceListener;
import org.dsi.ifc.global.ResourceLocator;

public interface ITelService {
    public void dialNumber(String var1, ITelServiceListener var2, boolean var3);

    public void dialNumberFromADBEntry(String var1, String var2, short var3, short var4, long var5, ResourceLocator var7, int var8, int var9, ITelServiceListener var10, boolean var11);

    public void prepareDialing(String var1, ITelServiceListener var2);

    public void prepareDialing(String var1, String var2, short var3, short var4, long var5, ResourceLocator var7, int var8, int var9, ITelServiceListener var10);

    public void dialNumber(ITelCallSession var1, boolean var2);
}

