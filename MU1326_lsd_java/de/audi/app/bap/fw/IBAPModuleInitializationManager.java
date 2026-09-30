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
    public void addInitStateListener(IInitStateListener var1);

    public void updateOperationState();

    public int getBapStackState();

    public int getHMIState();

    public int getInitState();

    public boolean isAppStateDefect();

    public String appStatesToString();

    public void notifyBAPStackStateChanged(int var1);

    public void notifyAppServiceChanged(boolean var1);

    public void notifyHMIStateAcknowledged();

    public void bapReset(BAPEntity var1);
}

