/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.AbstractADBHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.messaging.core.addressbook.AdbModelUpdater;
import de.audi.app.messaging.core.addressbook.AdbViewListener;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.component.MessagingComponentCollection;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.NaviADBService;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MessagingAdbHandler
extends AbstractADBHandler
implements IMessagingComponent {
    private final IFrameworkAccess framework;
    private final BundleContext bundleContext;
    private final MessagingComponentCollection subcomponents = new MessagingComponentCollection();
    private volatile AbstractMsgApplication msgApp;
    private final AdbModelUpdater adbModelUpdater;
    private volatile NaviADBService adbNaviService;
    private int adbMode;
    private volatile boolean isAdbReady = false;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviADBService;

    public MessagingAdbHandler(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext.getFramework(), messagingBundleContext.getFramework().getLogChannel("App.Messaging.Main"), messagingBundleContext.getFramework().getLogChannel("App.Messaging.Adb.CmdList"));
        this.framework = messagingBundleContext.getFramework();
        this.bundleContext = messagingBundleContext.getBundleContext();
        this.adbModelUpdater = new AdbModelUpdater(messagingBundleContext, "App.Messaging.Main");
        this.subcomponents.add(this.adbModelUpdater);
        this.subcomponents.add(new AdbViewListener(messagingBundleContext, "App.Messaging.Main"));
    }

    public void addComponent(IMessagingComponent iMessagingComponent) {
        this.subcomponents.add(iMessagingComponent);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        this.init();
        this.msgApp = abstractMsgApplication;
        this.subcomponents.initAll(abstractMsgApplication);
    }

    public void dispose() {
        this.subcomponents.disposeAll();
        try {
            this.getADBDSIAccess().clearDSIAdbEdit(this.getADBDSIListener());
            this.getADBDSIAccess().clearDSIAdbInit(this.getADBDSIListener());
            this.getADBDSIAccess().clearDSIAdbList(this.getADBDSIListener());
            this.getADBDSIAccess().clearDSIAdbSetup(this.getADBDSIListener());
            this.getADBDSIAccess().clearDSIAdbUserProfile(this.getADBDSIListener());
            this.getADBDSIAccess().clearDSIAdbVCardExchange(this.getADBDSIListener());
            this.destroy();
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingAdbHandler#dispose] An error occurred: ", (Throwable)exception);
        }
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            this.subcomponents.connectAll(iServiceRegistry);
            iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MessagingAdbHandler.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.getADBDSIListener(), ServiceProperties.createDsiListenerProperties((class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener).getName(), 5));
            iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MessagingAdbHandler.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.getADBDSIListener(), ServiceProperties.createDsiListenerProperties((class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName(), 5));
            iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MessagingAdbHandler.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.getADBDSIListener(), ServiceProperties.createDsiListenerProperties((class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName(), 5));
            iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = MessagingAdbHandler.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.getADBDSIListener(), ServiceProperties.createDsiListenerProperties((class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName(), 5));
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingAdbHandler#connect] An error occurred: ", (Throwable)exception);
        }
    }

    public void disconnect() {
        try {
            this.subcomponents.disconnectAll();
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingAdbHandler#disconnect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginOr();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(5));
        serviceFilterBuilder.endAnd();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(5));
        serviceFilterBuilder.endAnd();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(5));
        serviceFilterBuilder.endAnd();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = MessagingAdbHandler.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(5));
        serviceFilterBuilder.endAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$NaviADBService == null ? (class$de$audi$atip$interapp$NaviADBService = MessagingAdbHandler.class$("de.audi.atip.interapp.NaviADBService")) : class$de$audi$atip$interapp$NaviADBService).getName());
        serviceFilterBuilder.endOr();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                if (object instanceof DSIAdbEdit) {
                    ADBDSIAccess aDBDSIAccess = MessagingAdbHandler.this.getADBDSIAccess();
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    aDBDSIAccess.setDSIAdbEdit((DSIAdbEdit)object, aDBDSIListener);
                } else if (object instanceof DSIAdbList) {
                    ADBDSIAccess aDBDSIAccess = MessagingAdbHandler.this.getADBDSIAccess();
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    aDBDSIAccess.setDSIAdbList((DSIAdbList)object, aDBDSIListener);
                } else if (object instanceof DSIAdbUserProfile) {
                    ADBDSIAccess aDBDSIAccess = MessagingAdbHandler.this.getADBDSIAccess();
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    aDBDSIAccess.setDSIAdbUserProfile((DSIAdbUserProfile)object, aDBDSIListener);
                } else if (object instanceof DSIAdbSetup) {
                    ADBDSIAccess aDBDSIAccess = MessagingAdbHandler.this.getADBDSIAccess();
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    aDBDSIAccess.setDSIAdbSetup((DSIAdbSetup)object, aDBDSIListener);
                } else {
                    MessagingAdbHandler.this.setADBNaviService((NaviADBService)object);
                }
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                if (object instanceof DSIAdbEdit) {
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    MessagingAdbHandler.this.getADBDSIAccess().clearDSIAdbEdit(aDBDSIListener);
                } else if (object instanceof DSIAdbList) {
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    MessagingAdbHandler.this.getADBDSIAccess().clearDSIAdbList(aDBDSIListener);
                } else if (object instanceof DSIAdbUserProfile) {
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    MessagingAdbHandler.this.getADBDSIAccess().clearDSIAdbUserProfile(aDBDSIListener);
                } else if (object instanceof DSIAdbSetup) {
                    ADBDSIListener aDBDSIListener = MessagingAdbHandler.this.getADBDSIListener();
                    MessagingAdbHandler.this.getADBDSIAccess().clearDSIAdbSetup(aDBDSIListener);
                } else {
                    MessagingAdbHandler.this.setADBNaviService(null);
                }
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    public AdbModelUpdater getModelUpdater() {
        return this.adbModelUpdater;
    }

    public int getAdbMode() {
        return this.adbMode;
    }

    public void setAdbMode(int n) {
        this.adbMode = n;
    }

    public NaviADBService getADBNaviService() {
        return this.adbNaviService;
    }

    public void setADBNaviService(NaviADBService naviADBService) {
        this.adbNaviService = naviADBService;
    }

    public boolean isAdbReady() {
        return this.isAdbReady;
    }

    public int getInitStartupCompleteMask() {
        return 229;
    }

    public ADBOrganizerSearch getADBOrganizerSearch() {
        return this.msgApp.getOrganizerSearch();
    }

    public void handleInvalidData(int n, boolean bl) {
        this.log.log(1000000, "MessagingAdbHandler#handleInvalidData(): reason: %2, reloadMainList: %1", bl, (Object)ADBDbgUtils.dbgInvalidDataReason(n));
        if (bl) {
            this.msgApp.getOrganizerSearch().refreshFromStart();
        }
    }

    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
        this.log.log(1000000, "MessagingAdbHandler#entrySelected(): \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
        this.msgApp.getOrganizerSearch().entrySelected(aDBSearch, aDBSearchListRow, this.getAdbMode(), n, n2);
    }

    public void detailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
        this.log.log(1000000, "[MessagingAdbHandler#detailsSelected] listRow = %1", (Object)aDBEntryDetailsListRow);
        String string = "";
        switch (aDBEntryDetailsListRow.getDataType()) {
            case 0: {
                string = aDBEntryDetailsListRow.getEntry().phoneData[aDBEntryDetailsListRow.getDataIndex()].number;
                break;
            }
            case 2: {
                string = aDBEntryDetailsListRow.getEntry().emailData[aDBEntryDetailsListRow.getDataIndex()].emailAddr;
                break;
            }
        }
        MatchedAddress matchedAddress = new MatchedAddress(string, aDBEntryDetailsListRow.getCombinedName(), aDBEntryDetailsListRow.getEntryId(), aDBEntryDetailsListRow.getContactPicture());
        this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
        this.msgApp.getOrganizerSearch().getSpellerModel().clear();
        this.framework.getHMIService().getModel(n).fireEvent(n2);
    }

    public void setAdbReady(boolean bl) {
        this.log.log(1000000, "MessagingAdbHandler#setAdbReady(): ready: %1", bl);
        this.isAdbReady = bl;
        if (bl) {
            this.msgApp.getOrganizerSearch().startSearch();
        }
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200154).setValue(n);
    }

    public void updateNewEntryAvailable(boolean bl) {
        this.log.log(1000000, "MessagingAdbHandler#updateNewEntryAvailable(): available: %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200153).setValue(n);
    }

    public void updateViewSizes(AdbViewSize adbViewSize) {
        boolean bl = adbViewSize.phone == 0;
        this.log.log(1000000, "MessagingAdbHandler#updateViewSizes(): adbPhoneViewEmpty: %1", bl);
    }

    public int getCurrentViewType() {
        return this.msgApp.getAccountManager().isEmailMode() ? 16 : 1;
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

