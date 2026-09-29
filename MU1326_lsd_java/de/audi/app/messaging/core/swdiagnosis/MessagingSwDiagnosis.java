/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.swdiagnosis;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.swdiagnosis.MessagingSwDiagnosis$1;
import de.audi.app.messaging.core.util.Classes;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MessagingSwDiagnosis
extends AbstractSwDiagnosis
implements IMessagingComponent {
    private static final boolean AUGMENT_METHOD_NAMES;
    private static final String AUGMENTATION_SEPARATOR;
    private final BundleContext bundleContext;
    private final LogChannel log;
    private final Collection diagProviders = new ArrayList();
    private final Map keyToPlugInMap = new HashMap();
    private final Map commandToPlugInMap = new HashMap();
    private boolean hasPlugIns = false;
    private final IdentityHashMap swDiagnosisManagerIdentityMap = new IdentityHashMap();
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public MessagingSwDiagnosis(MessagingBundleContext messagingBundleContext) {
        this.bundleContext = messagingBundleContext.getBundleContext();
        this.log = messagingBundleContext.getFramework().getLogChannel("App.Messaging.Main");
    }

    @Override
    public void addComponent(IMessagingComponent iMessagingComponent) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingSwDiagnosis#connect] An error occurred: ", (Throwable)exception);
        }
    }

    @Override
    public void disconnect() {
    }

    @Override
    public int getId() {
        return 22;
    }

    @Override
    public String getName() {
        return "AppMessaging";
    }

    @Override
    public synchronized String[] getKeys() {
        Object[] objectArray = new String[this.keyToPlugInMap.keySet().size()];
        return (String[])this.keyToPlugInMap.keySet().toArray(objectArray);
    }

    @Override
    public synchronized Object getValue(String string) {
        if (!this.keyToPlugInMap.containsKey(string)) {
            throw new IllegalArgumentException(new StringBuffer().append("Undefined key: ").append(string).toString());
        }
        String string2 = MessagingSwDiagnosis.augmentedToRawMethodName(string);
        return this.getValue(this.keyToPlugInMap.get(string), string2);
    }

    @Override
    public synchronized String[] getCommands() {
        Object[] objectArray = new String[this.commandToPlugInMap.keySet().size()];
        return (String[])this.commandToPlugInMap.keySet().toArray(objectArray);
    }

    @Override
    public synchronized Object processNewCommand(String string, Object object) {
        if (!this.commandToPlugInMap.containsKey(string)) {
            throw new IllegalArgumentException(new StringBuffer().append("Undefined command: ").append(string).toString());
        }
        String string2 = MessagingSwDiagnosis.augmentedToRawMethodName(string);
        return this.processNewCommand(this.commandToPlugInMap.get(string), string2, object);
    }

    public synchronized void registerDiagProvider(IDiagProvider iDiagProvider) {
        this.diagProviders.add(iDiagProvider);
    }

    private synchronized void addDiagPlugins() {
        Iterator iterator = this.diagProviders.iterator();
        while (iterator.hasNext()) {
            IDiagProvider iDiagProvider = (IDiagProvider)iterator.next();
            IDiagPlugIn[] iDiagPlugInArray = iDiagProvider.createDiagPlugIns();
            for (int i2 = 0; i2 < iDiagPlugInArray.length; ++i2) {
                this.addDiagPlugIn(iDiagPlugInArray[i2]);
            }
        }
        this.hasPlugIns = true;
    }

    private synchronized void removeDiagPlugins() {
        this.keyToPlugInMap.clear();
        this.commandToPlugInMap.clear();
        this.hasPlugIns = false;
    }

    private synchronized void addDiagPlugIn(IDiagPlugIn iDiagPlugIn) {
        String[] stringArray;
        String string;
        String string2 = Classes.getShortClassName(super.getClass());
        String[] stringArray2 = this.getKeys(super.getClass());
        if (stringArray2.length > 0) {
            for (int i2 = 0; i2 < stringArray2.length; ++i2) {
                String string3 = stringArray2[i2];
                string = MessagingSwDiagnosis.rawToAugmentedMethodName(string3, string2);
                if (this.keyToPlugInMap.containsKey(string)) {
                    String string4 = this.keyToPlugInMap.get(string).getClass().getName();
                    Buffer buffer = new Buffer();
                    buffer.append("Cannot add duplicate key \"");
                    buffer.append(string);
                    buffer.append("\" for ");
                    buffer.append(string2);
                    buffer.append(". A key of the same name has already been added by ");
                    buffer.append(string4);
                    buffer.append('.');
                    throw new IllegalArgumentException(buffer.toString());
                }
                this.keyToPlugInMap.put(string, iDiagPlugIn);
            }
        }
        if ((stringArray = this.getCommands(super.getClass())).length > 0) {
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                string = stringArray[i3];
                String string5 = MessagingSwDiagnosis.rawToAugmentedMethodName(string, string2);
                if (this.commandToPlugInMap.containsKey(string5)) {
                    String string6 = this.commandToPlugInMap.get(string5).getClass().getName();
                    Buffer buffer = new Buffer();
                    buffer.append("Cannot add duplicate command \"");
                    buffer.append(string5);
                    buffer.append("\" for ");
                    buffer.append(string2);
                    buffer.append(". A command of the same name has already been added by ");
                    buffer.append(string6);
                    buffer.append('.');
                    throw new IllegalArgumentException(buffer.toString());
                }
                this.commandToPlugInMap.put(string5, iDiagPlugIn);
            }
        }
    }

    private static String rawToAugmentedMethodName(String string, String string2) {
        return new StringBuffer().append(string).append(" -> ").append(string2).toString();
    }

    private static String augmentedToRawMethodName(String string) {
        int n = string.indexOf(" -> ");
        return string.substring(0, n);
    }

    public synchronized void addSwDiagnosisManager(SwDiagnosisManager swDiagnosisManager) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[MessagingSwDiagnosis#addSwDiagnosisManager] swDiagnosisManager = %1 ", (Object)new StringBuffer().append(super.getClass().getName()).append("@").append(System.identityHashCode(swDiagnosisManager)).toString());
        }
        if (!this.hasPlugIns) {
            this.addDiagPlugins();
        }
        swDiagnosisManager.addDiagGateway(this);
        this.swDiagnosisManagerIdentityMap.put(swDiagnosisManager, swDiagnosisManager);
    }

    public synchronized void removeSwDiagnosisManager(SwDiagnosisManager swDiagnosisManager) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[MessagingSwDiagnosis#removeSwDiagnosisManager] swDiagnosisManager = %1 ", (Object)new StringBuffer().append(super.getClass().getName()).append("@").append(System.identityHashCode(swDiagnosisManager)).toString());
        }
        this.swDiagnosisManagerIdentityMap.remove(swDiagnosisManager);
        swDiagnosisManager.removeDiagGateway(this);
        if (this.swDiagnosisManagerIdentityMap.isEmpty()) {
            this.removeDiagPlugins();
        }
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = MessagingSwDiagnosis.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName());
        Filter filter = this.bundleContext.createFilter(string);
        MessagingSwDiagnosis$1 messagingSwDiagnosis$1 = new MessagingSwDiagnosis$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)messagingSwDiagnosis$1);
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

