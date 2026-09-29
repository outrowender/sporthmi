/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.Screen;

public interface IModelConnectService {
    default public void modifiyModelReference(Screen screen, boolean bl, boolean bl2) {
    }

    default public void modifiyModelReference(HMIView[] hMIViewArray, int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
    }

    default public void modifyModelReference(HMIView hMIView, boolean bl, boolean bl2) {
    }

    default public void checkForPostConnecting(HMIApplication hMIApplication) {
    }

    default public void clearUnconnectedItems(boolean bl) {
    }
}

