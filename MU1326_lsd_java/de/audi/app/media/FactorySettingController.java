/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

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
    private static final String LOGCLASS = "FactorySettingController";
    private static final int RESET_MODE_MEDIA_SETTINGS_ONLY = 1;
    private static final int RESET_MODE_MEDIA_COMPLETE = 2;
    private static final int RESET_MODE_MEDIA_CUSTOMER_UPDATE = 3;
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
        this.logChannel.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.msgServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = FactorySettingController.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logChannel.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        if (this.msgServiceRegistration != null) {
            this.msgServiceRegistration.unregister();
            this.msgServiceRegistration = null;
        }
    }

    void reset(int n) {
        int n2;
        if (this.resetRunning) {
            this.logChannel.log(100000, "[%1.reset] Reset already in progress!", (Object)LOGCLASS);
            return;
        }
        this.resetRunning = true;
        switch (n) {
            case 1: 
            case 2: {
                n2 = 3;
                if (!this.configuration.isSourceInstalled(6)) break;
                this.logChannel.log(1000000, "[%1.reset] HDD installed.", (Object)LOGCLASS);
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

    public void responseResetFactorySettings(int n, boolean bl) {
        this.logChannel.log(1000000, "[%1.responseResetFactorySettings] mode='%2','%3'.", (Object)LOGCLASS, (Object)new Integer(n), (Object)String.valueOf(bl));
        this.resetRunning = false;
    }

    public void processMsg(int n) {
        switch (n) {
            case 32: {
                this.logChannel.log(1000000, "[%1.processMessage] RESET_MEDIA_ALL.", (Object)LOGCLASS);
                this.reset(2);
                break;
            }
            case 33: {
                this.logChannel.log(1000000, "[%1.processMessage] RESET_MEDIA_SETTINGS.", (Object)LOGCLASS);
                this.reset(1);
                break;
            }
            case 89: {
                this.logChannel.log(1000000, "[%1.processMessage] RESET_MEDIA_REVERT_CUSTOMER_UPDATE.", (Object)LOGCLASS);
                this.reset(3);
                break;
            }
            case 27: {
                this.logChannel.log(1000000, "[%1.processMessage] RESET_TVAV_SETTINGS.", (Object)LOGCLASS);
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

    private void runResetFactorySettings(final int n, final int n2) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (n != 3) {
                    for (int i2 = 0; i2 < 8; ++i2) {
                        IMediaTerminal iMediaTerminal = FactorySettingController.this.terminals[i2];
                        if (iMediaTerminal == null) continue;
                        FactorySettingController.this.logChannel.log(1000000, "[%1.runResetFactorySettings] +++++ Reset terminal '%2' +++++.", (Object)FactorySettingController.LOGCLASS, (Object)iMediaTerminal);
                        try {
                            iMediaTerminal.resetSettings(n == 2 ? 1 : 0);
                            continue;
                        }
                        catch (Exception exception) {
                            FactorySettingController.this.logChannel.log(100000, "[%1.runResetFactorySettings] Error: %2", (Object)FactorySettingController.LOGCLASS, (Throwable)exception);
                        }
                    }
                }
                if (!FactorySettingController.this.dsiBase.requestResetFactorySettings(n2)) {
                    FactorySettingController.this.logChannel.log(1000000, "[%1.runResetFactorySettings] DSI reset fails.", (Object)FactorySettingController.LOGCLASS);
                    FactorySettingController.this.resetRunning = false;
                }
            }
        });
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
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
}

