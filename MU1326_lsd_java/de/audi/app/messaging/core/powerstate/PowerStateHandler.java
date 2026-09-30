/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.powerstate;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.atip.power.DefaultPowerEventListener;

public class PowerStateHandler
extends AbstractMessagingComponent {
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public PowerStateHandler(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = PowerStateHandler.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)new MyPowerEventListener(), ServiceProperties.createServiceProperties());
    }

    private void saveCompositionBuffer() {
        this.log.log(10000000, "[PowerStateHandler#saveCompositionBuffer]");
        this.msgApp.getNewMessage().getSaveDraftController().saveDraftIfJustified(true);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class MyPowerEventListener
    extends DefaultPowerEventListener {
        private MyPowerEventListener() {
        }

        public void notifyPowerListenerOnEnterState(int n, int n2) {
            PowerStateHandler.this.log.log(1000000, "[PowerStateHandler#notifyPowerListenerOnEnterState] event = %1", (long)n);
            if (n == 2 || n == 3) {
                PowerStateHandler.this.saveCompositionBuffer();
            }
        }
    }
}

