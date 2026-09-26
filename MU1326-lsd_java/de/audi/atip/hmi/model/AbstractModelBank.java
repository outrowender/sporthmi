/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIModelBank;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.TerminalModelContainer;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.log.NullLogChannel;

public abstract class AbstractModelBank
implements HMIModelBank {
    private static final long DEFAULT_SYNC_TIMEOUT;
    private static final String LOG_CH_EVENT;
    private static final String LOG_CH_MODELS;
    private static HMIService hmiService;
    private static LogChannel eventLogChannel;
    private static LogChannel modelLogChannel;
    private static LogChannelFactory logChannelFactory;
    protected HMIModel[] models;
    protected int[] modelIDs;
    protected final int moduleID;
    private final int modelCount;
    private volatile boolean registered = false;
    private final Object sync = new Object();

    protected AbstractModelBank(int n, int n2, int n3) {
        this.moduleID = n;
        this.models = new HMIModel[n2];
        this.modelCount = n3;
    }

    @Override
    public final int getId() {
        return this.moduleID;
    }

    @Override
    public int[] getAllModelIds() {
        int[] nArray = new int[this.modelCount];
        int n = 0;
        int n2 = 0;
        for (n = 0; n < this.models.length; ++n) {
            HMIModel hMIModel = this.models[n];
            if (hMIModel == null) continue;
            nArray[n2] = hMIModel instanceof TerminalModelContainer ? ((TerminalModelContainer)hMIModel).getModelID() : hMIModel.getID();
            ++n2;
        }
        return nArray;
    }

    public static LogChannel getEventLogChannel() {
        return eventLogChannel;
    }

    public static LogChannel getModelLogChannel() {
        return modelLogChannel;
    }

    public static LogChannel getLogChannel(String string) {
        return logChannelFactory.getLogChannel(string);
    }

    public static void setHMIservice(HMIService hMIService) {
        hmiService = hMIService;
    }

    public static HMIService getHMIservice() {
        return hmiService;
    }

    public static void initLogging(LogChannelFactory logChannelFactory) {
        AbstractModelBank.logChannelFactory = logChannelFactory;
        eventLogChannel = logChannelFactory.getLogChannel("Fw.ATIPEvent");
        modelLogChannel = logChannelFactory.getLogChannel("Fw.Models.Misc");
    }

    @Override
    public final HMIModel getModel(int n) {
        return this.getModel(0, n);
    }

    @Override
    public final HMIModel getModel(int n, int n2) {
        int n3 = this.getModelIndex(n2);
        if (n3 == -1) {
            return null;
        }
        this.createModel(n3);
        HMIModel hMIModel = this.models[n3];
        if (hMIModel instanceof TerminalModelContainer) {
            hMIModel = ((TerminalModelContainer)hMIModel).getModel(n, this);
        }
        return hMIModel;
    }

    @Override
    public final HMIModel[] getModels() {
        int[] nArray = this.getAllModelIds();
        HMIModel[] hMIModelArray = new HMIModel[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            hMIModelArray[i2] = this.getModel(nArray[i2]);
        }
        return hMIModelArray;
    }

    @Override
    public void resetAllModelListeners() {
        for (int i2 = 0; i2 < this.models.length; ++i2) {
            if (this.models[i2] == null) continue;
            this.models[i2].resetListener();
        }
    }

    protected abstract void createModel(int n) {
    }

    protected int getModelIndex(int n) {
        int n2 = n / -1601830656;
        if (n2 != this.moduleID) {
            throw new IllegalArgumentException(new StringBuffer().append(super.getClass().getName()).append("(m").append(this.moduleID).append(") does not provide models for module ").append(n2).toString());
        }
        int n3 = n % -1601830656;
        if (n3 >= this.models.length) {
            return -1;
        }
        return n3;
    }

    public final ChoiceModelApp getChoiceModel(int n) {
        HMIModel hMIModel = this.getModel(0, n);
        if (hMIModel instanceof ChoiceModelApp) {
            return (ChoiceModelApp)((Object)hMIModel);
        }
        throw new ClassCastException(new StringBuffer().append("model with id=").append(n).append(" is not ChoiceModelApp model").toString());
    }

    public final ButtonModelApp getButtonModel(int n) {
        HMIModel hMIModel = this.getModel(0, n);
        if (hMIModel instanceof ButtonModelApp) {
            return (ButtonModelApp)((Object)hMIModel);
        }
        throw new ClassCastException(new StringBuffer().append("model with id=").append(n).append(" is not ButtonModelApp model").toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void isRegistered(boolean bl) {
        Object object = this.sync;
        synchronized (object) {
            modelLogChannel.log(1078071040, "ModelBank[%1]: isRegistered(%2)", (long)this.moduleID, (long)(bl ? 1 : 0));
            this.registered = bl;
            this.sync.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void waitForRegistration(IFrameworkAccess iFrameworkAccess) {
        modelLogChannel.log(1078071040, "ModelBank[%1]: waitForRegistration()", (long)this.moduleID);
        Object object = this.sync;
        synchronized (object) {
            long l = iFrameworkAccess.getMonotonicTime();
            for (long i2 = Long.getLong("BUNDLE_START_TIMEOUT", 0) + 0; !this.registered && i2 > 0L; i2 -= iFrameworkAccess.getMonotonicTime() - l) {
                try {
                    this.sync.wait(i2);
                    continue;
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            modelLogChannel.log(-1601830656, "ModelBank[%2]: waitForRegistration(): %1", (Object)(this.registered ? "was registered" : "timed out"), (long)this.moduleID);
            if (!this.registered) {
                iFrameworkAccess.getStartupMgr().logStartupEvent(new StringBuffer().append("ModelBank[").append(this.moduleID).append("]: waitForRegistration() timed out!").toString());
            }
        }
    }

    static {
        modelLogChannel = NullLogChannel.getInstance();
    }
}

