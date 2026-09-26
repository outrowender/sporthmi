/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;

public interface IDSICarplayTransferObjectFactory {
    default public ResourceRequest createResourceRequest(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public Resource createResource(int n, int n2) {
    }

    default public AppStateRequest createAppStateRequest(int n, boolean bl, int n2) {
    }

    default public AppState createAppState(int n, int n2, int n3) {
    }
}

