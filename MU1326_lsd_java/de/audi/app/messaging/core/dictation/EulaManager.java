/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.DsiDescriptor;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.settings.ISettingsManagerObserver;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
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

    public synchronized void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.loadFromPersistence();
        this.setSkipEula();
        this.framework.getHmiServiceApp().getButtonModel(2200177).setButtonListener(new MyButtonListener());
        abstractMsgApplication.getSettingsManager().addObserver(new SettingsManagerObserver());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    public synchronized void dispose() {
        super.dispose();
        this.eulaAcceptedSet.clear();
        this.setSkipEula();
    }

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
        this.log.log(10000000, "[EulaManager#restoreFactorySettings]");
        this.eulaAcceptedSet.clear();
        this.saveToPersistence();
        this.setSkipEula();
    }

    private synchronized void eulaAccepted() {
        this.log.log(10000000, "[EulaManager#eulaAccepted]");
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
            this.log.log(10000000, "[EulaManager#setSkipEula] this = %1", (Object)this);
        }
        int n = (bl = this.eulaAcceptedSet.contains(this.activeAdbProfileId)) ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(510).setValue(n);
    }

    private void eulaAcceptButton(int n, int n2) {
        this.log.log(1000000, "[EulaManager#eulaAcceptButton]");
        this.eulaAccepted();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private synchronized void saveToPersistence() {
        try {
            this.log.log(1000000, "[EulaManager#saveToPersistence] this = %1", (Object)this);
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
            this.log.log(1000000, "[EulaManager#loadFromPersistence] this = %1", (Object)this);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EulaManager#loadFromPersistence]");
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = EulaManager.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(5));
        serviceFilterBuilder.endAnd();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                DSIAdbUserProfile dSIAdbUserProfile = (DSIAdbUserProfile)object;
                if (dSIAdbUserProfile != null) {
                    dSIAdbUserProfile.setNotification(2, (DSIListener)EulaManager.this);
                }
            }

            public void removeService(ServiceReference serviceReference, Object object) {
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    public void asyncException(int n, String string, int n2) {
    }

    public synchronized void updateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[EulaManager#updateProfileInfo] profileInfo = %1, indexOfActiveProfile = %2, validFlag = %3", (Object)Arrays.toMultiLineString(profileInfoArray), (long)n, (long)n2);
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

    public void updateDeviceConnected(boolean bl, int n) {
    }

    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
    }

    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
    }

    public void updateDownloadCountOpp(DownloadInfo downloadInfo, int n) {
    }

    public void newDeviceConnected(String string) {
    }

    public void downloadToProfileResult(int n) {
    }

    public void restartDownloadResult(int n) {
    }

    public synchronized void profileDeleted(int n) {
        this.log.log(1000000, "[EulaManager#profileDeleted] profileId = %1", (long)n);
        boolean bl = this.eulaAcceptedSet.remove(Util.createInteger(n));
        if (bl) {
            this.saveToPersistence();
            this.setSkipEula();
        }
    }

    public void setProfileNameResult(int n) {
    }

    public void deleteProfilesResult(int n) {
    }

    public void commonEntryCountResult(int n, int n2) {
    }

    public void entryMeterResult(int n, EntryMeter[] entryMeterArray) {
    }

    public void setPairingCodeResult(int n) {
    }

    public void setHomeIdResult(int n) {
    }

    public void updateDownloadState(int n, int n2, int n3) {
    }

    public void updateDownloadState2ndPhone(int n, int n2, int n3) {
    }

    public void setSOSButtonResult(int n) {
    }

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

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public Object getEulaManager() {
            return EulaManager.this;
        }

        public void cmdEulaAccepted() {
            EulaManager.this.eulaAcceptButton(2200177, 0);
        }
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200177) {
                EulaManager.this.eulaAcceptButton(n, n3);
            } else {
                EulaManager.this.log.log(10000, "[EulaManager#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private class SettingsManagerObserver
    implements ISettingsManagerObserver {
        private SettingsManagerObserver() {
        }

        public void indicateResetToFactorySettings() {
            EulaManager.this.log.log(10000000, "[EulaManager#indicateResetToFactorySettings]");
            EulaManager.this.restoreFactorySettings();
        }
    }
}

