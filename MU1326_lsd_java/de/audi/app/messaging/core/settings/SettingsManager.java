/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigEmptyListener;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.settings.ActivateStoreSmsOnSentCommand;
import de.audi.app.messaging.core.settings.ISettingsManagerObserver;
import de.audi.app.messaging.core.settings.RestoreFactorySettingsCommand;
import de.audi.app.messaging.core.settings.SetEmailIndicationsCommand;
import de.audi.app.messaging.core.settings.SetPushSmsCommand;
import de.audi.app.messaging.core.settings.SetSmsIndicationsCommand;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.msg.MsgListener;
import java.util.Iterator;

public final class SettingsManager
extends AbstractMessagingComponent {
    private final CopyOnWriteArrayList settingsManagerObservers = new CopyOnWriteArrayList();
    private final CommandResultHandler commandResultHandler = new CommandResultHandler();
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public SettingsManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        MyChoiceListener myChoiceListener = new MyChoiceListener();
        iHMIServiceApp.getChoiceModel(2200114).setChoiceListener(myChoiceListener);
        iHMIServiceApp.getChoiceModel(2200116).setChoiceListener(myChoiceListener);
        iHMIServiceApp.getChoiceModel(2200118).setChoiceListener(myChoiceListener);
        iHMIServiceApp.getChoiceModel(2200132).setChoiceListener(myChoiceListener);
        abstractMsgApplication.getDsiMessagingConfigPrimaryListener().addSubscriber(new MyDsiMessagingConfigListener());
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SettingsManager.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new MyMsgListener(), ServiceProperties.createServiceProperties());
    }

    public void addObserver(ISettingsManagerObserver iSettingsManagerObserver) {
        this.log.log(10000000, "[SettingsManager#addObserver] observer = %2", (Object)iSettingsManagerObserver);
        this.settingsManagerObservers.add(iSettingsManagerObserver);
    }

    private void storeMsgOnSendChoice(int n) {
        this.log.log(1000000, "[SettingsManager#storeMsgOnSendChoice] itemID = %1", (long)n);
        boolean bl = n == 1;
        new ActivateStoreSmsOnSentCommand(this.msgApp, bl).schedule();
    }

    private void pushSmsEnabledChoice(int n) {
        this.log.log(1000000, "[SettingsManager#pushSmsEnabledChoice] itemID = %1", (long)n);
        boolean bl = n == 1;
        new SetPushSmsCommand(this.msgApp, bl).schedule();
    }

    private void smsIndicationsEnabledChoice(int n) {
        this.log.log(1000000, "[SettingsManager#smsIndicationsEnabledChoice] itemID = %1", (long)n);
        boolean bl = n == 1;
        new SetSmsIndicationsCommand(this.msgApp, bl).schedule();
    }

    private void emailIndicationsEnabledChoice(int n) {
        this.log.log(1000000, "[SettingsManager#emailIndicationsEnabledChoice] itemID = %1", (long)n);
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

    private class MyMsgListener
    implements MsgListener {
        private MyMsgListener() {
        }

        public void processMsg(int n) {
            if (n == 35) {
                SettingsManager.this.log.log(1000000, "[SettingsManager#processMsg] message = %1, resetting to factory settings.", (long)n);
                new RestoreFactorySettingsCommand(SettingsManager.this.msgApp, SettingsManager.this.commandResultHandler).schedule();
            }
        }
    }

    private class MyChoiceListener
    extends DefaultChoiceListener {
        private MyChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            switch (n) {
                case 2200114: {
                    SettingsManager.this.storeMsgOnSendChoice(n2);
                    break;
                }
                case 2200116: {
                    SettingsManager.this.pushSmsEnabledChoice(n2);
                    break;
                }
                case 2200118: {
                    SettingsManager.this.smsIndicationsEnabledChoice(n2);
                    break;
                }
                case 2200132: {
                    SettingsManager.this.emailIndicationsEnabledChoice(n2);
                    break;
                }
                default: {
                    SettingsManager.this.log.log(10000, "[SettingsManager#itemSelected] Unexpected modelID = %1", (long)n);
                }
            }
        }
    }

    private final class CommandResultHandler
    implements RestoreFactorySettingsCommand.ResultHandler {
        private CommandResultHandler() {
        }

        public void handleResult(int n) {
            SettingsManager.this.log.log(10000000, "[SettingsManager#handleCommandResult] result = %1", (long)n);
            SettingsManager.this.emitIndicateResetToFactorySettings();
        }
    }

    private class MyDsiMessagingConfigListener
    extends DsiMessagingConfigEmptyListener {
        private MyDsiMessagingConfigListener() {
        }

        public void updateStoreSmsOnSent(boolean bl, int n) {
            SettingsManager.this.log.log(10000000, "[SettingsManager#updateStoreSmsOnSent] store = %1", bl);
            int n2 = bl ? 1 : 0;
            SettingsManager.this.framework.getHmiServiceApp().getChoiceModel(2200114).setValue(n2);
        }

        public void updatePushSms(boolean bl, int n) {
            SettingsManager.this.log.log(10000000, "[SettingsManager#updatePushSms] pushSms = %1", bl);
            int n2 = bl ? 1 : 0;
            SettingsManager.this.framework.getHmiServiceApp().getChoiceModel(2200116).setValue(n2);
        }

        public void updateSmsIndications(boolean bl, int n) {
            SettingsManager.this.log.log(10000000, "[SettingsManager#updateSmsIndications] smsIndications = %1", bl);
            int n2 = bl ? 1 : 0;
            SettingsManager.this.framework.getHmiServiceApp().getChoiceModel(2200118).setValue(n2);
        }

        public void updateEmailIndications(boolean bl, int n) {
            SettingsManager.this.log.log(10000000, "[SettingsManager#updateEmailIndications] emailIndications = %1", bl);
            int n2 = bl ? 1 : 0;
            SettingsManager.this.framework.getHmiServiceApp().getChoiceModel(2200132).setValue(n2);
        }
    }
}

