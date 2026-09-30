/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.SystemSDISEnv;
import de.audi.atip.agent.IASICall;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.interapp.sdis.ISDISBlockingListener;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlService;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MasterControlASIProvider
extends ASIHMISyncMasterControlAbstractBaseService
implements IASIProvider,
MsgListener,
ISDISBlockingService {
    private static final long HUVERSION_TIMEOUT = 30000L;
    private final SystemSDISEnv env;
    private final ASIHMISyncMasterControlService masterControlService;
    private final List blockingListeners;
    private final List stubs;
    private int currentBlockState = 1;
    private int currentLockState = 1;

    public MasterControlASIProvider(SystemSDISEnv systemSDISEnv, int n) {
        this.env = systemSDISEnv;
        this.masterControlService = new ASIHMISyncMasterControlService(n, this);
        this.blockingListeners = new ArrayList();
        this.stubs = new ArrayList();
        this.initAttributes();
    }

    private final SystemSDISEnv getEnv() {
        return this.env;
    }

    private final LogChannel getLog() {
        return this.getEnv().getLog();
    }

    public final String toString() {
        return "MasterControlASIProvider";
    }

    private final void initAttributes() {
        try {
            this.updateASIVersion("1.1.01");
            this.updateReplyIDs(new short[]{3, 4, 8, 9, 10, 11, 13, 14, 12});
            this.updateRequestIDs(new short[]{0, 1, 2, 5, 6, 7});
            new Timer("SDIS HU Version reader", 30000L, true, new TimerListener(){

                public void fireTimer(Timer timer) {
                    try {
                        MasterControlASIProvider.this.updateHUVersion(MasterControlASIProvider.this.getEnv().getHUSwVersion());
                    }
                    catch (MethodException methodException) {
                        MasterControlASIProvider.this.getLog().log(1000000, "[MasterControlASIProvider.updateHUVersion] unexpected MethodException", (Throwable)methodException);
                    }
                }

                public void cancelTimer(Timer timer) {
                }
            }).start();
            this.distributeVIN();
            this.currentBlockState = this.getEnv().readInt(1010, 10);
            this.currentLockState = this.getEnv().readInt(1010, 20);
            this.setLockState(this.currentLockState);
            this.setBlockState(this.currentBlockState);
        }
        catch (MethodException methodException) {
            this.getLog().log(1000000, "[MasterControlASIProvider.iniAttributes] unexpected MethodException", (Throwable)methodException);
        }
    }

    private final String getVin() {
        if (this.getEnv().getChoiceModel(46).getValue() == 1) {
            String string = null;
            string = this.getEnv().getLabelModel(49).getText();
            this.getLog().log(100000, "[MasterControlASIProvider.getVin] return %1", (Object)string);
            return string;
        }
        this.getLog().log(100000, "[MasterControlASIProvider.getVin] not available yet! return null");
        return null;
    }

    private final void distributeVIN() {
        try {
            String string = this.getVin();
            if (string != null) {
                this.updateVIN(string);
            }
        }
        catch (MethodException methodException) {
            this.getLog().log(1000000, "[MasterControlASIProvider.distributeVIN] unexpected MethodException", (Throwable)methodException);
        }
    }

    public final IService getService() {
        return this.masterControlService;
    }

    public final synchronized void attachStub(IStub iStub) {
        this.getLog().log(1000000, "[MasterControlASIProvider.attachStub] '%1'", (Object)iStub);
        this.stubs.add(iStub);
    }

    public final synchronized void detachStub(IStub iStub) {
        this.getLog().log(1000000, "[MasterControlASIProvider.detachStub] '%1'", (Object)iStub);
        this.stubs.remove(iStub);
    }

    private final synchronized List getStubs() {
        return new ArrayList(this.stubs);
    }

    private final void broadcast(IASICall iASICall) {
        Iterator iterator = this.getStubs().iterator();
        while (iterator.hasNext()) {
            try {
                iASICall.call(((IStub)iterator.next()).getReplyProxyFrontend());
            }
            catch (Exception exception) {
                this.getLog().log(100000, "[MasterControlASIProvider.broadcast] call '%1'failed!", (Object)iASICall, (Throwable)exception);
            }
        }
    }

    public void processMsg(int n) {
        if (84 == n) {
            this.getLog().log(1000000, "[MasterControlASIProvider.processMsg] VIN is available now.");
            this.distributeVIN();
        } else if (85 == n) {
            this.getLog().log(1000000, "[MasterControlASIProvider.processMsg] factory reset was triggered.");
            this.broadcast(new IASICall(){

                public void call(IProxyFrontend iProxyFrontend) throws MethodException {
                    ((ASIHMISyncMasterControlReplyProxy)iProxyFrontend).factoryReset();
                }
            });
        }
    }

    public final void setLockState(int n) {
        try {
            if (n != this.currentLockState) {
                this.getEnv().writeInt(1010, 20, n);
                this.currentLockState = n;
            }
            this.updateLockState(n);
            for (int i2 = 0; i2 < this.blockingListeners.size(); ++i2) {
                ((ISDISBlockingListener)this.blockingListeners.get(i2)).updateLockState(n);
            }
        }
        catch (MethodException methodException) {
            this.getLog().log(1000000, "[MasterControlASIProvider.doUpdateLockState] unexpected MethodException", (Throwable)methodException);
        }
    }

    public final void setBlockState(int n) {
        try {
            if (n != this.currentBlockState) {
                this.getEnv().writeInt(1010, 10, n);
                this.currentBlockState = n;
            }
            this.updateBlockState(n);
            for (int i2 = 0; i2 < this.blockingListeners.size(); ++i2) {
                ((ISDISBlockingListener)this.blockingListeners.get(i2)).updateBlockState(n);
            }
        }
        catch (MethodException methodException) {
            this.getLog().log(1000000, "[MasterControlASIProvider.doUpdateBlockState] unexpected MethodException", (Throwable)methodException);
        }
    }

    public final void enterAppContext(final int n, final String string) {
        this.getLog().log(1000000, "[MasterControlASIProvider.enterAppContext] tell SDIS to enter specific app context");
        this.broadcast(new IASICall(){

            public void call(IProxyFrontend iProxyFrontend) throws MethodException {
                ((ASIHMISyncMasterControlReplyProxy)iProxyFrontend).enterAppContext(n, string);
            }
        });
    }

    public void addBlockingListener(ISDISBlockingListener iSDISBlockingListener) {
        if (!this.blockingListeners.contains(iSDISBlockingListener)) {
            this.blockingListeners.add(iSDISBlockingListener);
            iSDISBlockingListener.updateLockState(this.currentLockState);
            iSDISBlockingListener.updateBlockState(this.currentBlockState);
        }
    }

    public void removeBlockingListener(ISDISBlockingListener iSDISBlockingListener) {
        this.blockingListeners.remove(iSDISBlockingListener);
    }
}

