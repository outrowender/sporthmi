/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.FactorySettingController$1;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.configuration.IMediaConfiguration;
import de.audi.app.media.content.IContent;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaFactoryResetListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class FactorySettingController
implements IMediaFactoryResetListener,
MsgListener {
    private static final String LOGCLASS;
    private static final int RESET_MODE_MEDIA_SETTINGS_ONLY;
    private static final int RESET_MODE_MEDIA_COMPLETE;
    private static final int RESET_MODE_MEDIA_CUSTOMER_UPDATE;
    private final IMediaDSIBaseController dsiBase;
    private final LogChannel logChannel;
    private final IServiceManager serviceManager;
    private final IMediaConfiguration configuration;
    private final IMediaTerminal[] terminals;
    private final DispatcherBase dispatcher;
    private volatile boolean resetRunning = false;
    private volatile ServiceRegistration msgServiceRegistration;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public FactorySettingController(LogChannel logChannel, IMediaDSIBaseController iMediaDSIBaseController, IServiceManager iServiceManager, IMediaConfiguration iMediaConfiguration, IMediaTerminal[] iMediaTerminalArray, DispatcherBase dispatcherBase) {
        this.logChannel = logChannel;
        this.dsiBase = iMediaDSIBaseController;
        this.terminals = iMediaTerminalArray;
        this.serviceManager = iServiceManager;
        this.configuration = iMediaConfiguration;
        this.dispatcher = dispatcherBase;
    }

    public void init() {
        this.logChannel.log(1078071040, "[%1.init]", (Object)"FactorySettingController");
        this.msgServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = FactorySettingController.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logChannel.log(1078071040, "[%1.deinit]", (Object)"FactorySettingController");
        if (this.msgServiceRegistration != null) {
            this.msgServiceRegistration.unregister();
            this.msgServiceRegistration = null;
        }
    }

    void reset(int n) {
        int n2;
        if (this.resetRunning) {
            this.logChannel.log(-1601830656, "[%1.reset] Reset already in progress!", (Object)"FactorySettingController");
            return;
        }
        this.resetRunning = true;
        switch (n) {
            case 1: 
            case 2: {
                n2 = 3;
                if (!this.configuration.isSourceInstalled(6)) break;
                this.logChannel.log(1078071040, "[%1.reset] HDD installed.", (Object)"FactorySettingController");
                if (n != 2) break;
                n2 |= 4;
                break;
            }
            case 3: {
                n2 = 8;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        this.runResetFactorySettings(n, n2);
    }

    @Override
    public void responseResetFactorySettings(int n, boolean bl) {
        this.logChannel.log(1078071040, "[%1.responseResetFactorySettings] mode='%2','%3'.", (Object)"FactorySettingController", (Object)new Integer(n), (Object)String.valueOf(bl));
        this.resetRunning = false;
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 32: {
                this.logChannel.log(1078071040, "[%1.processMessage] RESET_MEDIA_ALL.", (Object)"FactorySettingController");
                this.reset(2);
                break;
            }
            case 33: {
                this.logChannel.log(1078071040, "[%1.processMessage] RESET_MEDIA_SETTINGS.", (Object)"FactorySettingController");
                this.reset(1);
                break;
            }
            case 89: {
                this.logChannel.log(1078071040, "[%1.processMessage] RESET_MEDIA_REVERT_CUSTOMER_UPDATE.", (Object)"FactorySettingController");
                this.reset(3);
                break;
            }
            case 27: {
                this.logChannel.log(1078071040, "[%1.processMessage] RESET_TVAV_SETTINGS.", (Object)"FactorySettingController");
                for (int i2 = 0; i2 < this.terminals.length; ++i2) {
                    IContent iContent;
                    IMediaTerminal iMediaTerminal = this.terminals[i2];
                    if (iMediaTerminal == null) continue;
                    IContent iContent2 = iMediaTerminal.getContentManager().getContent(3);
                    if (iContent2 != null) {
                        iContent2.resetSettings();
                    }
                    if ((iContent = iMediaTerminal.getContentManager().getContent(4)) == null) continue;
                    iContent.resetSettings();
                }
                break;
            }
        }
    }

    private void runResetFactorySettings(int n, int n2) {
        this.dispatcher.execute(new FactorySettingController$1(this, n, n2));
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("FactorySettingController").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IMediaTerminal[] access$000(FactorySettingController factorySettingController) {
        return factorySettingController.terminals;
    }

    static /* synthetic */ LogChannel access$100(FactorySettingController factorySettingController) {
        return factorySettingController.logChannel;
    }

    static /* synthetic */ IMediaDSIBaseController access$200(FactorySettingController factorySettingController) {
        return factorySettingController.dsiBase;
    }

    static /* synthetic */ boolean access$302(FactorySettingController factorySettingController, boolean bl) {
        factorySettingController.resetRunning = bl;
        return factorySettingController.resetRunning;
    }
}

