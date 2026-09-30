/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.telephoneng.CallStackEntry;

public interface ITelIntellicallHandler {
    public void callAccepted();

    public void callDialed();

    public void eCallDialed();

    public void conferenceEstablished();

    public void dtmfEntrySelected();

    public void dialNumber(String var1, int var2);

    public void dialNumber(String var1, int var2, ITelDSIResponseListener var3);

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9, int var10);

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9, int var10, ITelDSIResponseListener var11);

    public void dialNumberFromCallStackEntry(CallStackEntry var1, int var2);

    public void dialNumberFromCallStackEntry(CallStackEntry var1, int var2, ITelDSIResponseListener var3);

    public void dialNumberFromADBEntry(AdbEntry var1, int var2, int var3);

    public void dialNumberFromADBEntry(AdbEntry var1, int var2, int var3, ITelDSIResponseListener var4);
}

