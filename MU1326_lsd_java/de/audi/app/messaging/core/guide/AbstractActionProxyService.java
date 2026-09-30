/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.guide;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

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

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    public final void parentFolderSelected(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#parentFolderSelected]");
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

    public final void messageCompositionEntered(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#messageCompositionEntered]");
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

    public final void readoutScreensExited(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#readoutScreensExited]");
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

    public final void templateReplacementExited(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#templateSubstitutionExited]");
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

    public final void templateListEntered(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#templateListEntered]");
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

    public final void onlineLicenseCheckEntered(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#onlineLicenseCheckEntered]");
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

    public final void onlineLicenseCheckExited(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#onlineLicenseCheckExited]");
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

    public void officeEnteredFromMainWizard(int n) {
        this.log.log(1000000, "[AbstractActionProxyService#officeEnteredFromMainWizard]");
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

    public void searchableViewTransition(int n, int n2, int n3) {
        this.log.log(1000000, "[AbstractActionProxyService#searchableViewTransition] view = %1, transitionType = %2", (long)n2, (long)n3);
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

    public void detailViewTransition(int n, int n2) {
        this.log.log(1000000, "[AbstractActionProxyService#detailViewTransition] transitionType = %1", (long)n2);
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

    public void messageCompositionTransition(int n, int n2) {
        this.log.log(1000000, "[AbstractActionProxyService#messageCompositionTransition] transitionType = %1", (long)n2);
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

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public void cmdParentFolderSelected() {
            AbstractActionProxyService.this.parentFolderSelected(0);
        }
    }
}

