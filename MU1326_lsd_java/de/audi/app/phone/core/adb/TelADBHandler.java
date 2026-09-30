/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.adb.ITelADBGetADBEntryListener;
import de.audi.app.phone.core.adb.ITelADBGetSpeedDialListFavoritesListener;
import de.audi.app.phone.core.adb.ITelADBHandler;
import de.audi.app.phone.core.adb.ITelADBHandlerListener;
import de.audi.app.phone.core.adb.TelADBDeleteAllSpeedDialFavoritesCommand;
import de.audi.app.phone.core.adb.TelADBDeleteSpecificSpeedDialFavoritesCommand;
import de.audi.app.phone.core.adb.TelADBDeleteSpeedDialFavoriteCommand;
import de.audi.app.phone.core.adb.TelADBGetEntryCommand;
import de.audi.app.phone.core.adb.TelADBGetSpeedDialFavoritesListCommand;
import de.audi.app.phone.core.adb.TelADBSetSpeedDialFavoriteCommand;
import de.audi.app.phone.core.adb.TelAddressbookHandlerImpl;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.ProfileInfo;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelADBHandler
extends AbstractPhoneComponent
implements ITelADBHandler,
ServiceTrackerCustomizer {
    private final TelAddressbookHandlerImpl adbHandler;
    private ADBOrganizerSearch organizerSearch;
    private volatile DSIActivator dsiAdbEditActivator;
    private volatile DSIActivator dsiAdbListActivator;
    private volatile DSIActivator dsiAdbUserProfileActivator;
    private volatile DSIActivator dsiAdbSetupActivator;
    private volatile PhoneServiceTracker adbHmiAppServiceTracker;
    private volatile ADBHMIAppService adbHmiAppService;
    private final List listeners;
    private final Object listenerMutex = new Object();
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBHMIAppService;

    public TelADBHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.listeners = new ArrayList();
        this.adbHandler = new TelAddressbookHandlerImpl(this, iTelApplication.getFrameworkAccess(), this.log, iTelApplication.getFrameworkAccess().getLogChannel("App.Phone.ADB.CL"));
    }

    private void initADBDSIs() {
        this.dsiAdbEditActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), (class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener).getName(), new Integer(1), this.adbHandler.getADBDSIListener(), new TelDSIClientDSIADBEdit());
        this.dsiAdbListActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), (class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName(), new Integer(1), this.adbHandler.getADBDSIListener(), new TelDSIClientDSIADBList());
        this.dsiAdbUserProfileActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName(), new Integer(1), this.adbHandler.getADBDSIListener(), new TelDSIClientDSIADBUserProfile());
        this.dsiAdbSetupActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), (class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = TelADBHandler.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName(), new Integer(1), this.adbHandler.getADBDSIListener(), new TelDSIClientDSIADBSetup());
        this.dsiAdbEditActivator.start(this.getApplication().getBundleContext());
        this.dsiAdbListActivator.start(this.getApplication().getBundleContext());
        this.dsiAdbUserProfileActivator.start(this.getApplication().getBundleContext());
        this.dsiAdbSetupActivator.start(this.getApplication().getBundleContext());
    }

    public void init() {
        this.adbHandler.init();
        this.initADBDSIs();
        this.adbHmiAppServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$ADBHMIAppService == null ? (class$de$audi$atip$interapp$ADBHMIAppService = TelADBHandler.class$("de.audi.atip.interapp.ADBHMIAppService")) : class$de$audi$atip$interapp$ADBHMIAppService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.adbHmiAppServiceTracker.openTracker();
    }

    public void deinit() {
        this.dsiAdbEditActivator.stop(this.getApplication().getBundleContext());
        this.dsiAdbListActivator.stop(this.getApplication().getBundleContext());
        this.dsiAdbUserProfileActivator.stop(this.getApplication().getBundleContext());
        this.dsiAdbSetupActivator.stop(this.getApplication().getBundleContext());
        this.adbHandler.destroy();
        if (this.adbHmiAppServiceTracker != null) {
            this.adbHmiAppServiceTracker.closeTracker();
            this.adbHmiAppServiceTracker = null;
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "TelADBHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "TelADBHandler#addingService service is null");
            return null;
        }
        if (object instanceof ADBHMIAppService) {
            this.adbHmiAppService = (ADBHMIAppService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "TelADBHandler#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "TelADBHandler#removedService service is null");
            return;
        }
        if (object instanceof ADBHMIAppService) {
            this.adbHmiAppService = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerListener(ITelADBHandlerListener iTelADBHandlerListener) {
        Object object = this.listenerMutex;
        synchronized (object) {
            this.listeners.add(iTelADBHandlerListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(ITelADBHandlerListener iTelADBHandlerListener) {
        Object object = this.listenerMutex;
        synchronized (object) {
            this.listeners.remove(iTelADBHandlerListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ITelADBHandlerListener[] getTelADBHandlerListenersCopy() {
        Object object = this.listenerMutex;
        synchronized (object) {
            return (ITelADBHandlerListener[])this.listeners.toArray(new ITelADBHandlerListener[this.listeners.size()]);
        }
    }

    void updateActiveProfile(ProfileInfo profileInfo) {
        ITelADBHandlerListener[] iTelADBHandlerListenerArray = this.getTelADBHandlerListenersCopy();
        for (int i2 = 0; i2 < iTelADBHandlerListenerArray.length; ++i2) {
            iTelADBHandlerListenerArray[i2].updateActiveProfile(profileInfo);
        }
    }

    void profileDeleted(int n) {
        ITelADBHandlerListener[] iTelADBHandlerListenerArray = this.getTelADBHandlerListenersCopy();
        for (int i2 = 0; i2 < iTelADBHandlerListenerArray.length; ++i2) {
            iTelADBHandlerListenerArray[i2].profileDeleted(n);
        }
    }

    void updateSortOrder(int n, int n2) {
        ITelADBHandlerListener[] iTelADBHandlerListenerArray = this.getTelADBHandlerListenersCopy();
        for (int i2 = 0; i2 < iTelADBHandlerListenerArray.length; ++i2) {
            iTelADBHandlerListenerArray[i2].updateSortOrder(n, n2);
        }
    }

    public void getADBEntry(long l, ITelADBGetADBEntryListener iTelADBGetADBEntryListener) {
        TelADBGetEntryCommand.createGetEntryCommand(this.adbHandler, l, iTelADBGetADBEntryListener);
    }

    public void getADBSpeedDialFavoritesList(ITelADBGetSpeedDialListFavoritesListener iTelADBGetSpeedDialListFavoritesListener) {
        TelADBGetSpeedDialFavoritesListCommand.createTelADBGetSpeedDialFavoritesListCommand(this.adbHandler, iTelADBGetSpeedDialListFavoritesListener);
    }

    public void setFavoriteSpeedDial(String string, int n, int n2, String string2, String string3, String string4, String string5, ResourceLocator resourceLocator) {
        TelADBSetSpeedDialFavoriteCommand.createTelADBSetSpeedDialFavoriteCommand(this.adbHandler, string, n, n2, string2, string3, string4, string5, resourceLocator);
    }

    public void deleteFavoriteSpeedDial(int n) {
        TelADBDeleteSpeedDialFavoriteCommand.createTelADBDeleteSpeedDialFavoriteCommand(this.adbHandler, n);
    }

    public void deleteAllFavoriteSpeedDials() {
        TelADBDeleteAllSpeedDialFavoritesCommand.createTelADBDeleteAllSpeedDialFavoriteCommand(this.adbHandler);
    }

    public void deleteSpecificFavoriteSpeedDials(long[] lArray) {
        TelADBDeleteSpecificSpeedDialFavoritesCommand.createTelADBDeleteSpecificSpeedDialFavoriteCommand(this.adbHandler, lArray);
    }

    public void showEntryDetails(long l) {
        ADBHMIAppService aDBHMIAppService = this.adbHmiAppService;
        if (aDBHMIAppService != null) {
            this.log.log(1000000, "[TelADBHandler#showEntryDetails] entryId=%1, viewType=ALL", l);
            aDBHMIAppService.showEntryDetails(l, 0);
        } else {
            this.log.log(100000, "[TelADBHandler#showEntryDetails] adbService is null --> NOP!");
        }
    }

    public void showSpeedDialEntryDetails(long l) {
        ADBHMIAppService aDBHMIAppService = this.adbHmiAppService;
        if (aDBHMIAppService != null) {
            this.log.log(1000000, "[TelADBHandler#showSpeedDialEntryDetails] entryId=%1", l);
            aDBHMIAppService.showSpeedDialEntryDetails(l, 0);
        } else {
            this.log.log(100000, "[TelADBHandler#showSpeedDialEntryDetails] adbService is null --> NOP!");
        }
    }

    public int getADBSpeedDialEntriesMaxNumber() {
        return this.getApplication().getFrameworkAccess().getSysConst(4425);
    }

    public ADBApplication getAdbApplication() {
        return this.adbHandler;
    }

    public ADBOrganizerSearch getOrganizerSearch() {
        return this.organizerSearch;
    }

    public void setOrganizerSearch(ADBOrganizerSearch aDBOrganizerSearch) {
        this.organizerSearch = aDBOrganizerSearch;
    }

    void setAdbReady(boolean bl) {
        ITelADBHandlerListener[] iTelADBHandlerListenerArray = this.getTelADBHandlerListenersCopy();
        for (int i2 = 0; i2 < iTelADBHandlerListenerArray.length; ++i2) {
            iTelADBHandlerListenerArray[i2].setAdbReady(bl);
        }
    }

    public void handleInvalidData(int n, boolean bl) {
        ITelADBHandlerListener[] iTelADBHandlerListenerArray = this.getTelADBHandlerListenersCopy();
        for (int i2 = 0; i2 < iTelADBHandlerListenerArray.length; ++i2) {
            iTelADBHandlerListenerArray[i2].handleInvalidData(n, bl);
        }
    }

    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
        ITelADBHandlerListener[] iTelADBHandlerListenerArray = this.getTelADBHandlerListenersCopy();
        for (int i2 = 0; i2 < iTelADBHandlerListenerArray.length; ++i2) {
            iTelADBHandlerListenerArray[i2].onEntrySelected(aDBSearch, aDBSearchListRow, n, n2);
        }
    }

    public void detailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
        ITelADBHandlerListener[] iTelADBHandlerListenerArray = this.getTelADBHandlerListenersCopy();
        for (int i2 = 0; i2 < iTelADBHandlerListenerArray.length; ++i2) {
            iTelADBHandlerListenerArray[i2].onDetailsSelected(aDBEntryDetailsListRow, n, n2);
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

    private class TelDSIClientDSIADBEdit
    implements IDSIClient {
        private TelDSIClientDSIADBEdit() {
        }

        public void setDSI(DSIBase dSIBase) {
            ADBDSIAccess aDBDSIAccess;
            TelADBHandler.this.log.log(1000000, "[TelADBHandler.TelDSIClientDSIADBEdit#setDSI] dsi=%1", (Object)dSIBase);
            ADBDSIAccess aDBDSIAccess2 = aDBDSIAccess = TelADBHandler.this.adbHandler != null ? TelADBHandler.this.adbHandler.getADBDSIAccess() : null;
            if (aDBDSIAccess != null) {
                if (dSIBase != null) {
                    aDBDSIAccess.setDSIAdbEdit((DSIAdbEdit)dSIBase, TelADBHandler.this.adbHandler.getADBDSIListener());
                } else {
                    aDBDSIAccess.clearDSIAdbEdit(TelADBHandler.this.adbHandler.getADBDSIListener());
                }
            }
        }

        public int[] getAutoNotifications() {
            return new int[0];
        }
    }

    private class TelDSIClientDSIADBList
    implements IDSIClient {
        private TelDSIClientDSIADBList() {
        }

        public void setDSI(DSIBase dSIBase) {
            ADBDSIAccess aDBDSIAccess;
            TelADBHandler.this.log.log(1000000, "[TelADBHandler.TelDSIClientDSIADBList#setDSI] dsi=%1", (Object)dSIBase);
            ADBDSIAccess aDBDSIAccess2 = aDBDSIAccess = TelADBHandler.this.adbHandler != null ? TelADBHandler.this.adbHandler.getADBDSIAccess() : null;
            if (aDBDSIAccess != null) {
                if (dSIBase != null) {
                    aDBDSIAccess.setDSIAdbList((DSIAdbList)dSIBase, TelADBHandler.this.adbHandler.getADBDSIListener());
                } else {
                    aDBDSIAccess.clearDSIAdbList(TelADBHandler.this.adbHandler.getADBDSIListener());
                }
            }
        }

        public int[] getAutoNotifications() {
            return new int[0];
        }
    }

    private class TelDSIClientDSIADBSetup
    implements IDSIClient {
        private TelDSIClientDSIADBSetup() {
        }

        public void setDSI(DSIBase dSIBase) {
            ADBDSIAccess aDBDSIAccess;
            TelADBHandler.this.log.log(1000000, "[TelADBHandler.TelDSIClientDSIADBSetup#setDSI] dsi=%1", (Object)dSIBase);
            ADBDSIAccess aDBDSIAccess2 = aDBDSIAccess = TelADBHandler.this.adbHandler != null ? TelADBHandler.this.adbHandler.getADBDSIAccess() : null;
            if (aDBDSIAccess != null) {
                if (dSIBase != null) {
                    aDBDSIAccess.setDSIAdbSetup((DSIAdbSetup)dSIBase, TelADBHandler.this.adbHandler.getADBDSIListener());
                } else {
                    aDBDSIAccess.clearDSIAdbSetup(TelADBHandler.this.adbHandler.getADBDSIListener());
                }
            }
        }

        public int[] getAutoNotifications() {
            return new int[0];
        }
    }

    private class TelDSIClientDSIADBUserProfile
    implements IDSIClient {
        private TelDSIClientDSIADBUserProfile() {
        }

        public void setDSI(DSIBase dSIBase) {
            ADBDSIAccess aDBDSIAccess;
            TelADBHandler.this.log.log(1000000, "[TelADBHandler.TelDSIClientDSIADBUserProfile#setDSI] dsi=%1", (Object)dSIBase);
            ADBDSIAccess aDBDSIAccess2 = aDBDSIAccess = TelADBHandler.this.adbHandler != null ? TelADBHandler.this.adbHandler.getADBDSIAccess() : null;
            if (aDBDSIAccess != null) {
                if (dSIBase != null) {
                    aDBDSIAccess.setDSIAdbUserProfile((DSIAdbUserProfile)dSIBase, TelADBHandler.this.adbHandler.getADBDSIListener());
                } else {
                    aDBDSIAccess.clearDSIAdbUserProfile(TelADBHandler.this.adbHandler.getADBDSIListener());
                }
            }
        }

        public int[] getAutoNotifications() {
            return new int[0];
        }
    }
}

