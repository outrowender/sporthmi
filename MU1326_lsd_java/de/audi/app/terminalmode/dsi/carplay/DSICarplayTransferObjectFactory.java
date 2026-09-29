/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.carplay.DSICarplayTransferObjectFactory$1;
import de.audi.app.terminalmode.dsi.carplay.IDSICarplayTransferObjectFactory;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;

public class DSICarplayTransferObjectFactory
implements IDSICarplayTransferObjectFactory {
    @Override
    public ResourceRequest createResourceRequest(int n, int n2, int n3, int n4, int n5, int n6) {
        return new DSICarplayTransferObjectFactory$1(this, n, n2, n3, n4, n5, n6);
    }

    @Override
    public Resource createResource(int n, int n2) {
        return new Resource(n, n2);
    }

    @Override
    public AppStateRequest createAppStateRequest(int n, boolean bl, int n2) {
        return new AppStateRequest(n, bl, n2);
    }

    @Override
    public AppState createAppState(int n, int n2, int n3) {
        return new AppState(n, n2, n3);
    }
}

