/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.powerstate;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.powerstate.PowerStateHandler$MyPowerEventListener;
import de.audi.atip.log.LogChannel;

public class PowerStateHandler
extends AbstractMessagingComponent {
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public PowerStateHandler(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = PowerStateHandler.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)new PowerStateHandler$MyPowerEventListener(this, null), ServiceProperties.createServiceProperties());
    }

    private void saveCompositionBuffer() {
        this.log.log(-2137614336, "[PowerStateHandler#saveCompositionBuffer]");
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

    static /* synthetic */ LogChannel access$100(PowerStateHandler powerStateHandler) {
        return powerStateHandler.log;
    }

    static /* synthetic */ void access$200(PowerStateHandler powerStateHandler) {
        powerStateHandler.saveCompositionBuffer();
    }
}

