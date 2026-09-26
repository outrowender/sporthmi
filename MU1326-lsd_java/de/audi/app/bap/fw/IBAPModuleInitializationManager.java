/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.dsi.IDSIServiceStateListener;
import de.audi.app.bap.fw.IInitStateListener;
import de.audi.atip.base.ComponentStateListener;
import de.audi.atip.msg.MsgListener;
import de.vw.mib.bap.datatypes.BAPEntity;

public interface IBAPModuleInitializationManager
extends ComponentStateListener,
IDSIServiceStateListener,
MsgListener {
    default public void addInitStateListener(IInitStateListener iInitStateListener) {
    }

    default public void updateOperationState() {
    }

    default public int getBapStackState() {
    }

    default public int getHMIState() {
    }

    default public int getInitState() {
    }

    default public boolean isAppStateDefect() {
    }

    default public String appStatesToString() {
    }

    default public void notifyBAPStackStateChanged(int n) {
    }

    default public void notifyAppServiceChanged(boolean bl) {
    }

    default public void notifyHMIStateAcknowledged() {
    }

    default public void bapReset(BAPEntity bAPEntity) {
    }
}

