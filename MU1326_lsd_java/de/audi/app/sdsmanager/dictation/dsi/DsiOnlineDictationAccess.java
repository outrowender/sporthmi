/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sds.dictation.IDiagPlugIn
 *  de.mib.swdiagnosis.sds.dictation.IDiagProvider
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess$1;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess$2;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess$DiagPlugIn;
import de.audi.app.sdsmanager.dictation.dsi.IDsiAccessClient;
import de.audi.app.sdsmanager.dictation.dsi.IDsiAccessProvider;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.DsiDescriptor;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceFilterBuilder;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.sds.dictation.IDiagPlugIn;
import de.mib.swdiagnosis.sds.dictation.IDiagProvider;
import java.util.Collection;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineDictation;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class DsiOnlineDictationAccess
extends AbstractDictationComponent
implements DSIOnlineDictation,
IDsiAccessProvider,
IDiagProvider {
    static final int DSI_INSTANCE_ID;
    private volatile DSIOnlineDictation dsiOnlineDictation;
    private final Collection dsiAccessClients = new LinkedList();
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineDictation;

    public DsiOnlineDictationAccess(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        dictationComponentManager.getDictationSwDiagnosis().registerDiagProvider((IDiagProvider)this);
    }

    @Override
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

    @Override
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

    private void setDsiOnlineDictation(DSIOnlineDictation dSIOnlineDictation) {
        this.dictationComponentManager.getDispatcherManager().getInternalTaskDispatcher().execute(new DsiOnlineDictationAccess$1(this, dSIOnlineDictation));
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

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$org$dsi$ifc$online$DSIOnlineDictation == null ? (class$org$dsi$ifc$online$DSIOnlineDictation = DsiOnlineDictationAccess.class$("org.dsi.ifc.online.DSIOnlineDictation")) : class$org$dsi$ifc$online$DSIOnlineDictation).getName());
        Filter filter = this.bundleContext.createFilter(string);
        DsiOnlineDictationAccess$2 dsiOnlineDictationAccess$2 = new DsiOnlineDictationAccess$2(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)dsiOnlineDictationAccess$2);
    }

    @Override
    public synchronized void addDsiAccessClient(IDsiAccessClient iDsiAccessClient) {
        this.dsiAccessClients.add(iDsiAccessClient);
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiOnlineDictationAccess$DiagPlugIn(this)};
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiOnlineDictationAccess#setNotification] Not implemented.");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiOnlineDictationAccess#setNotification] Not implemented.");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiOnlineDictationAccess#setNotification] Not implemented.");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiOnlineDictationAccess#clearNotification] Not implemented.");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiOnlineDictationAccess#clearNotification] Not implemented.");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiOnlineDictationAccess#clearNotification] Not implemented.");
    }

    @Override
    public void stopDictation() {
        this.log.log(1078071040, "[DsiOnlineDictationAccess#stopDictation]");
        this.dsiOnlineDictation.stopDictation();
    }

    @Override
    public void setFallbackLanguage(String string) {
        this.log.log(1078071040, "[DsiOnlineDictationAccess#setFallbackLanguage] languageCode = %1", (Object)string);
        this.dsiOnlineDictation.setFallbackLanguage(string);
    }

    @Override
    public void setLanguage(String string) {
        this.log.log(1078071040, "[DsiOnlineDictationAccess#setLanguage] languageCode = %1", (Object)string);
        this.dsiOnlineDictation.setLanguage(string);
    }

    @Override
    public void activateDictation() {
        this.log.log(1078071040, "[DsiOnlineDictationAccess#activateDictation]");
        this.dsiOnlineDictation.activateDictation();
    }

    @Override
    public void startDictation(String string, String string2, String string3, String string4) {
        this.log.log(1078071040, "[DsiOnlineDictationAccess#startDictation] dictType = %1, serviceName = %2, costumGrammar = %3, userID = %4", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        this.dsiOnlineDictation.startDictation(string, string2, string3, string4);
    }

    @Override
    public void finishDictation() {
        this.log.log(1078071040, "[DsiOnlineDictationAccess#finishDictation]");
        this.dsiOnlineDictation.finishDictation();
    }

    @Override
    public void rawVoiceDataAvailable(String string, int n) {
        this.log.log(1078071040, "[DsiOnlineDictationAccess#rawVoiceDataAvailable] pathToRawAudioData = %1, rawAudioDataFormat = %2", (Object)string, (long)n);
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

    static /* synthetic */ LogChannel access$000(DsiOnlineDictationAccess dsiOnlineDictationAccess) {
        return dsiOnlineDictationAccess.log;
    }

    static /* synthetic */ DSIOnlineDictation access$102(DsiOnlineDictationAccess dsiOnlineDictationAccess, DSIOnlineDictation dSIOnlineDictation) {
        dsiOnlineDictationAccess.dsiOnlineDictation = dSIOnlineDictation;
        return dsiOnlineDictationAccess.dsiOnlineDictation;
    }

    static /* synthetic */ DictationComponentManager access$200(DsiOnlineDictationAccess dsiOnlineDictationAccess) {
        return dsiOnlineDictationAccess.dictationComponentManager;
    }

    static /* synthetic */ void access$300(DsiOnlineDictationAccess dsiOnlineDictationAccess, boolean bl) {
        dsiOnlineDictationAccess.updateDsiAccessClients(bl);
    }

    static /* synthetic */ void access$400(DsiOnlineDictationAccess dsiOnlineDictationAccess, DSIOnlineDictation dSIOnlineDictation) {
        dsiOnlineDictationAccess.setDsiOnlineDictation(dSIOnlineDictation);
    }

    static /* synthetic */ DictationComponentManager access$500(DsiOnlineDictationAccess dsiOnlineDictationAccess) {
        return dsiOnlineDictationAccess.dictationComponentManager;
    }
}

