/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dictation.EulaManager$1;
import de.audi.app.messaging.core.dictation.EulaManager$DiagPlugIn;
import de.audi.app.messaging.core.dictation.EulaManager$MyButtonListener;
import de.audi.app.messaging.core.dictation.EulaManager$SettingsManagerObserver;
import de.audi.app.messaging.core.osgi.DsiDescriptor;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class EulaManager
extends AbstractMessagingComponent
implements DSIAdbUserProfileListener,
IDiagProvider {
    private static final Integer PUBLIC_ADB_PROFILE_ID = Util.createInteger(0);
    private final Set eulaAcceptedSet = new TreeSet();
    Integer activeAdbProfileId = PUBLIC_ADB_PROFILE_ID;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;

    public EulaManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public synchronized void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.loadFromPersistence();
        this.setSkipEula();
        this.framework.getHmiServiceApp().getButtonModel(1905402112).setButtonListener(new EulaManager$MyButtonListener(this, null));
        abstractMsgApplication.getSettingsManager().addObserver(new EulaManager$SettingsManagerObserver(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public synchronized void dispose() {
        super.dispose();
        this.eulaAcceptedSet.clear();
        this.setSkipEula();
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = EulaManager.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this, ServiceProperties.createDsiListenerProperties((class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = EulaManager.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName(), 5));
            iServiceRegistry.addTracker(this.createServiceTracker());
            iServiceRegistry.startDsiService(new DsiDescriptor((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = EulaManager.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 5));
        }
        catch (Exception exception) {
            this.log.log(10000, "[EulaManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private synchronized void restoreFactorySettings() {
        this.log.log(-2137614336, "[EulaManager#restoreFactorySettings]");
        this.eulaAcceptedSet.clear();
        this.saveToPersistence();
        this.setSkipEula();
    }

    private synchronized void eulaAccepted() {
        this.log.log(-2137614336, "[EulaManager#eulaAccepted]");
        boolean bl = this.eulaAcceptedSet.add(this.activeAdbProfileId);
        if (bl) {
            this.saveToPersistence();
        }
        this.setSkipEula();
    }

    public synchronized String toString() {
        Buffer buffer = new Buffer();
        buffer.append("EulaManager {activeAdbProfileId = ");
        buffer.append(this.activeAdbProfileId);
        buffer.append(", eulaAcceptedSet = ");
        buffer.append(Collections.toString(this.eulaAcceptedSet));
        buffer.append('}');
        return buffer.toString();
    }

    private synchronized void setSkipEula() {
        boolean bl;
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[EulaManager#setSkipEula] this = %1", (Object)this);
        }
        int n = (bl = this.eulaAcceptedSet.contains(this.activeAdbProfileId)) ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(510).setValue(n);
    }

    private void eulaAcceptButton(int n, int n2) {
        this.log.log(1078071040, "[EulaManager#eulaAcceptButton]");
        this.eulaAccepted();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private synchronized void saveToPersistence() {
        try {
            this.log.log(1078071040, "[EulaManager#saveToPersistence] this = %1", (Object)this);
            TreeSet treeSet = new TreeSet(this.eulaAcceptedSet);
            treeSet.remove(PUBLIC_ADB_PROFILE_ID);
            int[] nArray = new int[treeSet.size()];
            Iterator iterator = treeSet.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                nArray[n] = (Integer)iterator.next();
                ++n;
            }
            IStorageAccess iStorageAccess = this.msgApp.getFramework().getStorageMgr();
            iStorageAccess.setIntArray(1019, 10, nArray);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EulaManager#saveToPersistence]");
        }
    }

    private synchronized void loadFromPersistence() {
        try {
            IStorageAccess iStorageAccess = this.msgApp.getFramework().getStorageMgr();
            int[] nArray = new int[]{};
            int[] nArray2 = iStorageAccess.getIntArray(1019, 10, nArray);
            this.eulaAcceptedSet.clear();
            for (int i2 = 0; i2 < nArray2.length; ++i2) {
                this.eulaAcceptedSet.add(Util.createInteger(nArray2[i2]));
            }
            this.log.log(1078071040, "[EulaManager#loadFromPersistence] this = %1", (Object)this);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EulaManager#loadFromPersistence]");
        }
    }

    private ServiceTracker createServiceTracker() {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = EulaManager.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(5));
        serviceFilterBuilder.endAnd();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        EulaManager$1 eulaManager$1 = new EulaManager$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)eulaManager$1);
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new EulaManager$DiagPlugIn(this)};
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public synchronized void updateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[EulaManager#updateProfileInfo] profileInfo = %1, indexOfActiveProfile = %2, validFlag = %3", (Object)Arrays.toMultiLineString(profileInfoArray), (long)n, (long)n2);
        }
        if (n2 == 1) {
            int n3;
            TreeSet treeSet = new TreeSet();
            for (n3 = 0; n3 < profileInfoArray.length; ++n3) {
                treeSet.add(Util.createInteger(profileInfoArray[n3].getNum()));
            }
            n3 = this.eulaAcceptedSet.retainAll(treeSet) ? 1 : 0;
            if (n3 != 0) {
                this.saveToPersistence();
            }
            this.activeAdbProfileId = Util.createInteger(profileInfoArray[n].getNum());
            this.setSkipEula();
        }
    }

    @Override
    public void updateDeviceConnected(boolean bl, int n) {
    }

    @Override
    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
    }

    @Override
    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
    }

    @Override
    public void updateDownloadCountOpp(DownloadInfo downloadInfo, int n) {
    }

    @Override
    public void newDeviceConnected(String string) {
    }

    @Override
    public void downloadToProfileResult(int n) {
    }

    @Override
    public void restartDownloadResult(int n) {
    }

    @Override
    public synchronized void profileDeleted(int n) {
        this.log.log(1078071040, "[EulaManager#profileDeleted] profileId = %1", (long)n);
        boolean bl = this.eulaAcceptedSet.remove(Util.createInteger(n));
        if (bl) {
            this.saveToPersistence();
            this.setSkipEula();
        }
    }

    @Override
    public void setProfileNameResult(int n) {
    }

    @Override
    public void deleteProfilesResult(int n) {
    }

    @Override
    public void commonEntryCountResult(int n, int n2) {
    }

    @Override
    public void entryMeterResult(int n, EntryMeter[] entryMeterArray) {
    }

    @Override
    public void setPairingCodeResult(int n) {
    }

    @Override
    public void setHomeIdResult(int n) {
    }

    @Override
    public void updateDownloadState(int n, int n2, int n3) {
    }

    @Override
    public void updateDownloadState2ndPhone(int n, int n2, int n3) {
    }

    @Override
    public void setSOSButtonResult(int n) {
    }

    @Override
    public void updateSOSButton(boolean bl, int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$200(EulaManager eulaManager, int n, int n2) {
        eulaManager.eulaAcceptButton(n, n2);
    }

    static /* synthetic */ LogChannel access$300(EulaManager eulaManager) {
        return eulaManager.log;
    }

    static /* synthetic */ LogChannel access$400(EulaManager eulaManager) {
        return eulaManager.log;
    }

    static /* synthetic */ void access$500(EulaManager eulaManager) {
        eulaManager.restoreFactorySettings();
    }
}

