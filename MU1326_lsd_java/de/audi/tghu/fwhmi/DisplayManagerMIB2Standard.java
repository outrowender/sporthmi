/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.fwhmi.DisplayManager;
import org.dsi.ifc.displaymanagement.DisplayContext;

public class DisplayManagerMIB2Standard
extends DisplayManager {
    private static final int STANDARD_CONTEXT_HMI = 0;
    private static final int STANDARD_CONTEXT_HMI_REARVIEW_CAMERA = 1;
    private static final int STANDARD_CONTEXT_HMI_AUX_AV = 2;
    private static final int STANDARD_CONTEXT_HMI_MAP_VIEWER = 3;
    private static final int STANDARD_CONTEXT_HMI_MAP_VIEWER_INTERSECTION = 4;
    private static final int STANDARD_CONTEXT_HMI_MAP_VIEWER_JUNCTION = 5;
    private static final int STANDARD_CONTEXT_AUX_AV_ONLY = 6;
    private static final int STANDARD_NUM_CONTEXTS = 7;
    static int[] mapToInternalContexts = new int[79];
    static int[] mapToExternalContexts = new int[7];

    public DisplayManagerMIB2Standard(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    protected int getMappedInternalContext(int n) {
        if (n < 0) {
            return n;
        }
        return mapToInternalContexts[n];
    }

    protected int getMappedExternalContext(int n) {
        if (n < 0 || n >= mapToExternalContexts.length) {
            return n;
        }
        return mapToExternalContexts[n];
    }

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

    protected void configureDM() {
    }

    static {
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

