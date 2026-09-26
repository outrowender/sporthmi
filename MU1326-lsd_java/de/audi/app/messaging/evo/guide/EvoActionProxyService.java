/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.guide;

import de.audi.app.messaging.core.guide.AbstractActionProxyService;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.guide.IEvoActionProxy;
import de.audi.atip.statemachine.ap.MessagingActionProxy;

public final class EvoActionProxyService
extends AbstractActionProxyService
implements IEvoActionProxy,
MessagingActionProxy {
    public EvoActionProxyService(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public int getActionProxyId() {
        return 8;
    }

    @Override
    public void compositionSpeedThresholdPopupReturn(int n) {
        this.log.log(1078071040, "[EvoActionProxyService#compositionSpeedThresholdPopupReturn]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                IActionProxySubscriber iActionProxySubscriber = iActionProxySubscriberArray[i2];
                if (!(iActionProxySubscriber instanceof IEvoActionProxy)) continue;
                ((IEvoActionProxy)((Object)iActionProxySubscriber)).compositionSpeedThresholdPopupReturn(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EvoActionProxyService#compositionSpeedThresholdPopupReturn]");
            }
        }
    }

    @Override
    public void messagingTransition(int n, int n2) {
        this.log.log(1078071040, "[EvoActionProxyService#messagingTransition] transitionType = %1", (long)n2);
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                IActionProxySubscriber iActionProxySubscriber = iActionProxySubscriberArray[i2];
                if (!(iActionProxySubscriber instanceof IEvoActionProxy)) continue;
                ((IEvoActionProxy)((Object)iActionProxySubscriber)).messagingTransition(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EvoActionProxyService#messagingTransition]");
            }
        }
    }

    @Override
    public void editViewTransition(int n, int n2) {
        this.log.log(1078071040, "[EvoActionProxyService#editViewTransition] transitionType = %1", (long)n2);
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                IActionProxySubscriber iActionProxySubscriber = iActionProxySubscriberArray[i2];
                if (!(iActionProxySubscriber instanceof IEvoActionProxy)) continue;
                ((IEvoActionProxy)((Object)iActionProxySubscriber)).editViewTransition(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EvoActionProxyService#editViewTransition]");
            }
        }
    }
}

