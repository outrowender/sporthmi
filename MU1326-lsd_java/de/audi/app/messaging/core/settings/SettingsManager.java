/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.settings.ActivateStoreSmsOnSentCommand;
import de.audi.app.messaging.core.settings.ISettingsManagerObserver;
import de.audi.app.messaging.core.settings.SetEmailIndicationsCommand;
import de.audi.app.messaging.core.settings.SetPushSmsCommand;
import de.audi.app.messaging.core.settings.SetSmsIndicationsCommand;
import de.audi.app.messaging.core.settings.SettingsManager$CommandResultHandler;
import de.audi.app.messaging.core.settings.SettingsManager$MyChoiceListener;
import de.audi.app.messaging.core.settings.SettingsManager$MyDsiMessagingConfigListener;
import de.audi.app.messaging.core.settings.SettingsManager$MyMsgListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;

public final class SettingsManager
extends AbstractMessagingComponent {
    private final CopyOnWriteArrayList settingsManagerObservers = new CopyOnWriteArrayList();
    private final SettingsManager$CommandResultHandler commandResultHandler = new SettingsManager$CommandResultHandler(this, null);
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public SettingsManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        SettingsManager$MyChoiceListener settingsManager$MyChoiceListener = new SettingsManager$MyChoiceListener(this, null);
        iHMIServiceApp.getChoiceModel(848437504).setChoiceListener(settingsManager$MyChoiceListener);
        iHMIServiceApp.getChoiceModel(881991936).setChoiceListener(settingsManager$MyChoiceListener);
        iHMIServiceApp.getChoiceModel(915546368).setChoiceListener(settingsManager$MyChoiceListener);
        iHMIServiceApp.getChoiceModel(1150427392).setChoiceListener(settingsManager$MyChoiceListener);
        abstractMsgApplication.getDsiMessagingConfigPrimaryListener().addSubscriber(new SettingsManager$MyDsiMessagingConfigListener(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SettingsManager.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new SettingsManager$MyMsgListener(this, null), ServiceProperties.createServiceProperties());
    }

    public void addObserver(ISettingsManagerObserver iSettingsManagerObserver) {
        this.log.log(-2137614336, "[SettingsManager#addObserver] observer = %2", (Object)iSettingsManagerObserver);
        this.settingsManagerObservers.add(iSettingsManagerObserver);
    }

    private void storeMsgOnSendChoice(int n) {
        this.log.log(1078071040, "[SettingsManager#storeMsgOnSendChoice] itemID = %1", (long)n);
        boolean bl = n == 1;
        new ActivateStoreSmsOnSentCommand(this.msgApp, bl).schedule();
    }

    private void pushSmsEnabledChoice(int n) {
        this.log.log(1078071040, "[SettingsManager#pushSmsEnabledChoice] itemID = %1", (long)n);
        boolean bl = n == 1;
        new SetPushSmsCommand(this.msgApp, bl).schedule();
    }

    private void smsIndicationsEnabledChoice(int n) {
        this.log.log(1078071040, "[SettingsManager#smsIndicationsEnabledChoice] itemID = %1", (long)n);
        boolean bl = n == 1;
        new SetSmsIndicationsCommand(this.msgApp, bl).schedule();
    }

    private void emailIndicationsEnabledChoice(int n) {
        this.log.log(1078071040, "[SettingsManager#emailIndicationsEnabledChoice] itemID = %1", (long)n);
        boolean bl = n == 1;
        new SetEmailIndicationsCommand(this.msgApp, bl).schedule();
    }

    private void emitIndicateResetToFactorySettings() {
        Iterator iterator = this.settingsManagerObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISettingsManagerObserver)iterator.next()).indicateResetToFactorySettings();
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[SettingsManager#emitIndicateResetToFactorySettings]");
            }
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$400(SettingsManager settingsManager, int n) {
        settingsManager.storeMsgOnSendChoice(n);
    }

    static /* synthetic */ void access$500(SettingsManager settingsManager, int n) {
        settingsManager.pushSmsEnabledChoice(n);
    }

    static /* synthetic */ void access$600(SettingsManager settingsManager, int n) {
        settingsManager.smsIndicationsEnabledChoice(n);
    }

    static /* synthetic */ void access$700(SettingsManager settingsManager, int n) {
        settingsManager.emailIndicationsEnabledChoice(n);
    }

    static /* synthetic */ LogChannel access$800(SettingsManager settingsManager) {
        return settingsManager.log;
    }

    static /* synthetic */ LogChannel access$900(SettingsManager settingsManager) {
        return settingsManager.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1000(SettingsManager settingsManager) {
        return settingsManager.msgApp;
    }

    static /* synthetic */ SettingsManager$CommandResultHandler access$1100(SettingsManager settingsManager) {
        return settingsManager.commandResultHandler;
    }

    static /* synthetic */ LogChannel access$1200(SettingsManager settingsManager) {
        return settingsManager.log;
    }

    static /* synthetic */ void access$1300(SettingsManager settingsManager) {
        settingsManager.emitIndicateResetToFactorySettings();
    }

    static /* synthetic */ LogChannel access$1400(SettingsManager settingsManager) {
        return settingsManager.log;
    }

    static /* synthetic */ IFrameworkAccess access$1500(SettingsManager settingsManager) {
        return settingsManager.framework;
    }

    static /* synthetic */ LogChannel access$1600(SettingsManager settingsManager) {
        return settingsManager.log;
    }

    static /* synthetic */ IFrameworkAccess access$1700(SettingsManager settingsManager) {
        return settingsManager.framework;
    }

    static /* synthetic */ LogChannel access$1800(SettingsManager settingsManager) {
        return settingsManager.log;
    }

    static /* synthetic */ IFrameworkAccess access$1900(SettingsManager settingsManager) {
        return settingsManager.framework;
    }

    static /* synthetic */ LogChannel access$2000(SettingsManager settingsManager) {
        return settingsManager.log;
    }

    static /* synthetic */ IFrameworkAccess access$2100(SettingsManager settingsManager) {
        return settingsManager.framework;
    }
}

