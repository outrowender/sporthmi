/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.SDISConnectionStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemSDISEnv {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final List sdisListenerList = new ArrayList();
    private volatile boolean isSdisConnected;

    SystemSDISEnv(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("App.System.SDIS");
    }

    private final IFrameworkAccess getFramework() {
        return this.framework;
    }

    final LogChannel getLog() {
        return this.log;
    }

    final int getSysConst(int n) {
        return this.framework.getSysConst(n);
    }

    private final IStorageAccess getStorageMgr() {
        return this.getFramework().getStorageMgr();
    }

    final boolean isSDISEnabled() {
        return this.getFramework().isSDISEnabled();
    }

    final long getMonotonicTime() {
        return this.getFramework().getMonotonicTime();
    }

    final String getHUSwVersion() {
        byte[] byArray;
        String string = null;
        string = this.getFramework().isSimulator() ? "WinTV" : (this.getFramework().getStartupMgr().isRebootToDownload() ? "UNDEF" : ((byArray = this.getStorageMgr().getByteArray(553765890, 401, new byte[0])).length > 10 ? new String(byArray) : this.getStorageMgr().getString(553765890, 401, "UNDEF")));
        this.getLog().log(-1601830656, "[MasterControlASIProvider.getHUSwVersion] returns %1", (Object)string);
        return string;
    }

    final int readInt(int n, int n2) {
        return this.getStorageMgr().getInt(n, n2, 0);
    }

    final void writeInt(int n, int n2, int n3) {
        this.getStorageMgr().setInt(n, n2, n3);
    }

    public final ChoiceModelApp getChoiceModel(int n) {
        return this.getFramework().getHMIService().getChoiceModel(n);
    }

    public final LabelModelApp getLabelModel(int n) {
        return this.getFramework().getHMIService().getLabelModel(n);
    }

    public final void sendMessage(int n) {
        this.getFramework().getMsgDistrib().sendMessage(n);
    }

    public synchronized void addSDISConnectionStateListener(SDISConnectionStateListener sDISConnectionStateListener) {
        if (sDISConnectionStateListener != null) {
            this.sdisListenerList.add(sDISConnectionStateListener);
            sDISConnectionStateListener.updateSdisConnected(this.isSdisConnected);
        }
    }

    public synchronized void removeSDISConnectionStateListener(Object object) {
        this.sdisListenerList.remove(object);
    }

    public synchronized void setSdisConnected(boolean bl) {
        this.isSdisConnected = bl;
        Iterator iterator = this.sdisListenerList.iterator();
        while (iterator.hasNext()) {
            ((SDISConnectionStateListener)iterator.next()).updateSdisConnected(bl);
        }
    }
}

