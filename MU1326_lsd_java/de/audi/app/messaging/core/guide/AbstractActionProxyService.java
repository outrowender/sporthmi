/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.guide;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.guide.AbstractActionProxyService$DiagPlugIn;
import de.audi.app.messaging.core.guide.IActionProxyService;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.guide.ICoreActionProxy;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Logs;
import java.util.Collection;
import java.util.LinkedList;

public abstract class AbstractActionProxyService
extends AbstractMessagingComponent
implements IActionProxyService,
ICoreActionProxy,
IDiagProvider {
    private final Collection subscribers = new LinkedList();
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    public AbstractActionProxyService(MessagingBundleContext messagingBundleContext, String string) {
        super(messagingBundleContext, string);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AbstractActionProxyService.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)this, ServiceProperties.createActionProxyServiceProperties(this.getActionProxyId()));
    }

    public final synchronized void addSubscriber(IActionProxySubscriber iActionProxySubscriber) {
        this.subscribers.add(iActionProxySubscriber);
    }

    protected final synchronized IActionProxySubscriber[] getCurrentSubscribers() {
        Object[] objectArray = new IActionProxySubscriber[this.subscribers.size()];
        this.subscribers.toArray(objectArray);
        return objectArray;
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new AbstractActionProxyService$DiagPlugIn(this)};
    }

    @Override
    public final void parentFolderSelected(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#parentFolderSelected]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].parentFolderSelected(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#parentFolderSelected]");
            }
        }
    }

    @Override
    public final void messageCompositionEntered(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#messageCompositionEntered]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].messageCompositionEntered(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#messageCompositionEntered]");
            }
        }
    }

    @Override
    public final void readoutScreensExited(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#readoutScreensExited]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].readoutScreensExited(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#readoutScreensExited]");
            }
        }
    }

    @Override
    public final void templateReplacementExited(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#templateSubstitutionExited]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].templateReplacementExited(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#templateSubstitutionExited]");
            }
        }
    }

    @Override
    public final void templateListEntered(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#templateListEntered]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].templateListEntered(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#templateListEntered]");
            }
        }
    }

    @Override
    public final void onlineLicenseCheckEntered(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#onlineLicenseCheckEntered]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].onlineLicenseCheckEntered(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#onlineLicenseCheckEntered]");
            }
        }
    }

    @Override
    public final void onlineLicenseCheckExited(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#onlineLicenseCheckExited]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].onlineLicenseCheckExited(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#onlineLicenseCheckExited]");
            }
        }
    }

    @Override
    public void officeEnteredFromMainWizard(int n) {
        this.log.log(1078071040, "[AbstractActionProxyService#officeEnteredFromMainWizard]");
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].officeEnteredFromMainWizard(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#officeEnteredFromMainWizard]");
            }
        }
    }

    @Override
    public void searchableViewTransition(int n, int n2, int n3) {
        this.log.log(1078071040, "[AbstractActionProxyService#searchableViewTransition] view = %1, transitionType = %2", (long)n2, (long)n3);
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].searchableViewTransition(n, n2, n3);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#searchableViewTransition]");
            }
        }
    }

    @Override
    public void detailViewTransition(int n, int n2) {
        this.log.log(1078071040, "[AbstractActionProxyService#detailViewTransition] transitionType = %1", (long)n2);
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].detailViewTransition(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#detailViewTransition]");
            }
        }
    }

    @Override
    public void messageCompositionTransition(int n, int n2) {
        this.log.log(1078071040, "[AbstractActionProxyService#messageCompositionTransition] transitionType = %1", (long)n2);
        IActionProxySubscriber[] iActionProxySubscriberArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < iActionProxySubscriberArray.length; ++i2) {
            try {
                iActionProxySubscriberArray[i2].messageCompositionTransition(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AbstractActionProxyService#messageCompositionTransition]");
            }
        }
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

