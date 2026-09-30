/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;

public interface IDSICarplayTransferObjectFactory {
    public ResourceRequest createResourceRequest(int var1, int var2, int var3, int var4, int var5, int var6);

    public Resource createResource(int var1, int var2);

    public AppStateRequest createAppStateRequest(int var1, boolean var2, int var3);

    public AppState createAppState(int var1, int var2, int var3);
}

