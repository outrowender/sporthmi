/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sds.dictation.DiagDsiOnlineDictation
 *  de.mib.swdiagnosis.sds.dictation.IDiagPlugIn
 *  de.mib.swdiagnosis.sds.dictation.IDiagProvider
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsi.IDsiAccessClient;
import de.audi.app.sdsmanager.dictation.dsi.IDsiAccessProvider;
import de.audi.app.sdsmanager.dictation.osgi.AbstractTrackerCustomizer;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.DsiDescriptor;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceFilterBuilder;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.mib.swdiagnosis.sds.dictation.DiagDsiOnlineDictation;
import de.mib.swdiagnosis.sds.dictation.IDiagPlugIn;
import de.mib.swdiagnosis.sds.dictation.IDiagProvider;
import java.util.Collection;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineDictation;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class DsiOnlineDictationAccess
extends AbstractDictationComponent
implements DSIOnlineDictation,
IDsiAccessProvider,
IDiagProvider {
    static final int DSI_INSTANCE_ID = 0;
    private volatile DSIOnlineDictation dsiOnlineDictation;
    private final Collection dsiAccessClients = new LinkedList();
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineDictation;

    public DsiOnlineDictationAccess(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        dictationComponentManager.getDictationSwDiagnosis().registerDiagProvider((IDiagProvider)this);
    }

    public void dispose() {
        super.dispose();
        try {
            if (this.dsiOnlineDictation != null) {
                this.dsiOnlineDictation.clearNotification(this.dictationComponentManager.getDsiOnlineDictationPrimaryListener());
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "[DsiOnlineDictationAccess#dispose] An error occurred: ", (Throwable)exception);
        }
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
            iServiceRegistry.startDsiService(new DsiDescriptor((class$org$dsi$ifc$online$DSIOnlineDictation == null ? (class$org$dsi$ifc$online$DSIOnlineDictation = DsiOnlineDictationAccess.class$("org.dsi.ifc.online.DSIOnlineDictation")) : class$org$dsi$ifc$online$DSIOnlineDictation).getName(), 0));
        }
        catch (Exception exception) {
            this.log.log(10000, "[DsiOnlineDictationAccess#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private void setDsiOnlineDictation(final DSIOnlineDictation dSIOnlineDictation) {
        this.dictationComponentManager.getDispatcherManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                boolean bl;
                DsiOnlineDictationAccess.this.log.log(10000000, "[DsiOnlineDictationAccess#setDsiOnlineDictation] dsiOnlineDictation = %1", (Object)dSIOnlineDictation);
                DsiOnlineDictationAccess.this.dsiOnlineDictation = dSIOnlineDictation;
                boolean bl2 = bl = dSIOnlineDictation != null;
                if (bl) {
                    dSIOnlineDictation.setNotification(DsiOnlineDictationAccess.this.dictationComponentManager.getDsiOnlineDictationPrimaryListener());
                }
                DsiOnlineDictationAccess.this.updateDsiAccessClients(bl);
            }
        });
    }

    private void updateDsiAccessClients(boolean bl) {
        IDsiAccessClient[] iDsiAccessClientArray = this.getCurrentDsiAccessClients();
        for (int i2 = 0; i2 < iDsiAccessClientArray.length; ++i2) {
            try {
                iDsiAccessClientArray[i2].updateDsiAvailability(bl);
                continue;
            }
            catch (Exception exception) {
                DictationUtil.logException(this.log, exception, "[DsiOnlineDictationAccess#updateDsiAccessClients]");
            }
        }
    }

    private synchronized IDsiAccessClient[] getCurrentDsiAccessClients() {
        Object[] objectArray = new IDsiAccessClient[this.dsiAccessClients.size()];
        this.dsiAccessClients.toArray(objectArray);
        return objectArray;
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$org$dsi$ifc$online$DSIOnlineDictation == null ? (class$org$dsi$ifc$online$DSIOnlineDictation = DsiOnlineDictationAccess.class$("org.dsi.ifc.online.DSIOnlineDictation")) : class$org$dsi$ifc$online$DSIOnlineDictation).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractTrackerCustomizer abstractTrackerCustomizer = new AbstractTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                DsiOnlineDictationAccess.this.setDsiOnlineDictation((DSIOnlineDictation)object);
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                DsiOnlineDictationAccess.this.setDsiOnlineDictation(null);
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractTrackerCustomizer);
    }

    public synchronized void addDsiAccessClient(IDsiAccessClient iDsiAccessClient) {
        this.dsiAccessClients.add(iDsiAccessClient);
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(100000, "[DsiOnlineDictationAccess#setNotification] Not implemented.");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log.log(100000, "[DsiOnlineDictationAccess#setNotification] Not implemented.");
    }

    public void setNotification(DSIListener dSIListener) {
        this.log.log(100000, "[DsiOnlineDictationAccess#setNotification] Not implemented.");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(100000, "[DsiOnlineDictationAccess#clearNotification] Not implemented.");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log.log(100000, "[DsiOnlineDictationAccess#clearNotification] Not implemented.");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log.log(100000, "[DsiOnlineDictationAccess#clearNotification] Not implemented.");
    }

    public void stopDictation() {
        this.log.log(1000000, "[DsiOnlineDictationAccess#stopDictation]");
        this.dsiOnlineDictation.stopDictation();
    }

    public void setFallbackLanguage(String string) {
        this.log.log(1000000, "[DsiOnlineDictationAccess#setFallbackLanguage] languageCode = %1", (Object)string);
        this.dsiOnlineDictation.setFallbackLanguage(string);
    }

    public void setLanguage(String string) {
        this.log.log(1000000, "[DsiOnlineDictationAccess#setLanguage] languageCode = %1", (Object)string);
        this.dsiOnlineDictation.setLanguage(string);
    }

    public void activateDictation() {
        this.log.log(1000000, "[DsiOnlineDictationAccess#activateDictation]");
        this.dsiOnlineDictation.activateDictation();
    }

    public void startDictation(String string, String string2, String string3, String string4) {
        this.log.log(1000000, "[DsiOnlineDictationAccess#startDictation] dictType = %1, serviceName = %2, costumGrammar = %3, userID = %4", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        this.dsiOnlineDictation.startDictation(string, string2, string3, string4);
    }

    public void finishDictation() {
        this.log.log(1000000, "[DsiOnlineDictationAccess#finishDictation]");
        this.dsiOnlineDictation.finishDictation();
    }

    public void rawVoiceDataAvailable(String string, int n) {
        this.log.log(1000000, "[DsiOnlineDictationAccess#rawVoiceDataAvailable] pathToRawAudioData = %1, rawAudioDataFormat = %2", (Object)string, (long)n);
        this.dsiOnlineDictation.rawVoiceDataAvailable(string, n);
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

        public void cmdUseDiagDsiOnlineDictation(boolean bl) {
            DsiOnlineDictationAccess.this.setDsiOnlineDictation((DSIOnlineDictation)new DiagDsiOnlineDictation(DsiOnlineDictationAccess.this.dictationComponentManager, bl));
        }
    }
}

