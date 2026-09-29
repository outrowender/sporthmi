/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.fwhmi.DisplayManager;
import org.dsi.ifc.displaymanagement.DisplayContext;

public class DisplayManagerMIB2Standard
extends DisplayManager {
    private static final int STANDARD_CONTEXT_HMI;
    private static final int STANDARD_CONTEXT_HMI_REARVIEW_CAMERA;
    private static final int STANDARD_CONTEXT_HMI_AUX_AV;
    private static final int STANDARD_CONTEXT_HMI_MAP_VIEWER;
    private static final int STANDARD_CONTEXT_HMI_MAP_VIEWER_INTERSECTION;
    private static final int STANDARD_CONTEXT_HMI_MAP_VIEWER_JUNCTION;
    private static final int STANDARD_CONTEXT_AUX_AV_ONLY;
    private static final int STANDARD_NUM_CONTEXTS;
    static int[] mapToInternalContexts;
    static int[] mapToExternalContexts;

    public DisplayManagerMIB2Standard(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    @Override
    protected int getMappedInternalContext(int n) {
        if (n < 0) {
            return n;
        }
        return mapToInternalContexts[n];
    }

    @Override
    protected int getMappedExternalContext(int n) {
        if (n < 0 || n >= mapToExternalContexts.length) {
            return n;
        }
        return mapToExternalContexts[n];
    }

    @Override
    protected void defineContexts() {
        this.dc = new DisplayContext[7];
        this.dc[0] = new DisplayContext(0, new int[]{16});
        this.dc[1] = new DisplayContext(1, new int[]{16, 17});
        this.dc[2] = new DisplayContext(2, new int[]{16, 27});
        this.dc[3] = new DisplayContext(3, new int[]{16, 19});
        this.dc[4] = new DisplayContext(4, new int[]{16, 21, 19});
        this.dc[5] = new DisplayContext(5, new int[]{16, 23, 19});
        this.dc[6] = new DisplayContext(6, new int[]{27});
    }

    @Override
    protected void configureDM() {
    }

    static {
        mapToInternalContexts = new int[79];
        mapToExternalContexts = new int[7];
        DisplayManagerMIB2Standard.mapToInternalContexts[0] = 0;
        DisplayManagerMIB2Standard.mapToInternalContexts[3] = 1;
        DisplayManagerMIB2Standard.mapToInternalContexts[6] = 2;
        DisplayManagerMIB2Standard.mapToInternalContexts[10] = 3;
        DisplayManagerMIB2Standard.mapToInternalContexts[11] = 4;
        DisplayManagerMIB2Standard.mapToInternalContexts[13] = 5;
        DisplayManagerMIB2Standard.mapToInternalContexts[71] = 6;
        DisplayManagerMIB2Standard.mapToExternalContexts[0] = 0;
        DisplayManagerMIB2Standard.mapToExternalContexts[1] = 3;
        DisplayManagerMIB2Standard.mapToExternalContexts[2] = 6;
        DisplayManagerMIB2Standard.mapToExternalContexts[3] = 10;
        DisplayManagerMIB2Standard.mapToExternalContexts[4] = 11;
        DisplayManagerMIB2Standard.mapToExternalContexts[5] = 13;
        DisplayManagerMIB2Standard.mapToExternalContexts[6] = 71;
    }
}

