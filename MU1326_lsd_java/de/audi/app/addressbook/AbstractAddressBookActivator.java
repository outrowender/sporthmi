/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.addressbook.AddressBookDiag
 */
package de.audi.app.addressbook;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.AddressBookHMIApplication;
import de.audi.app.addressbook.core.main.interapp.AddressBookHMIAppServiceImpl;
import de.audi.app.addressbook.core.main.sds.ADBSDSHandler;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.ADBSDSServiceListener;
import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook;
import de.audi.atip.interapp.phone.ITelPresetService;
import de.audi.atip.interapp.phone.ITelServiceADB;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.filebrowser.IFileBrowserManager;
import de.mib.swdiagnosis.addressbook.AddressBookDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbInit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractAddressBookActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    protected LogChannel log;
    protected AbstractAddressBookApplication appAdr;
    private VCardExchangeADBHandler vCardExchangeADBHandler;
    private CombiADBHandler bapCombiADBHandler;
    private ADBSDSHandler adbSDSHandler;
    private ServiceTracker serviceTracker;
    private AddressBookDiag adbDiag;
    private AddressBookHMIAppServiceImpl addressBookHMIAppServiceImpl;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchange;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviADBService;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceADB;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelPresetService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBSDSServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;
    static /* synthetic */ Class class$de$audi$tghu$filebrowser$IFileBrowserManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingService;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBHMIAppService;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBSDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInitListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$AbstractAddressBookApplication;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.framework.getLogChannel("App.AddressBook.Main");
        this.log.log(1078071040, "AbstractAddressBookActivator#start(): bundleContext: %1", (Object)bundleContext);
        this.appAdr = this.createAddressBookApplication(this.framework);
        this.appAdr.init();
        this.vCardExchangeADBHandler = new VCardExchangeADBHandler(this.framework);
        this.vCardExchangeADBHandler.init();
        this.appAdr.setVCardExchangeADBHandler(this.vCardExchangeADBHandler);
        this.bapCombiADBHandler = new CombiADBHandler(this.framework);
        this.bapCombiADBHandler.init();
        this.appAdr.setBapCombiADBHandler(this.bapCombiADBHandler);
        this.adbSDSHandler = new ADBSDSHandler(this.appAdr, this.appAdr.getLog());
        String[] stringArray = new String[]{(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), (class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit).getName(), (class$org$dsi$ifc$organizer$DSIAdbVCardExchange == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchange = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbVCardExchange")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchange).getName(), (class$de$audi$atip$interapp$NaviADBService == null ? (class$de$audi$atip$interapp$NaviADBService = AbstractAddressBookActivator.class$("de.audi.atip.interapp.NaviADBService")) : class$de$audi$atip$interapp$NaviADBService).getName(), (class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = AbstractAddressBookActivator.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName(), (class$de$audi$atip$interapp$phone$ITelServiceADB == null ? (class$de$audi$atip$interapp$phone$ITelServiceADB = AbstractAddressBookActivator.class$("de.audi.atip.interapp.phone.ITelServiceADB")) : class$de$audi$atip$interapp$phone$ITelServiceADB).getName(), (class$de$audi$atip$interapp$phone$ITelPresetService == null ? (class$de$audi$atip$interapp$phone$ITelPresetService = AbstractAddressBookActivator.class$("de.audi.atip.interapp.phone.ITelPresetService")) : class$de$audi$atip$interapp$phone$ITelPresetService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractAddressBookActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook = AbstractAddressBookActivator.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook).getName(), (class$de$audi$atip$interapp$ADBSDSServiceListener == null ? (class$de$audi$atip$interapp$ADBSDSServiceListener = AbstractAddressBookActivator.class$("de.audi.atip.interapp.ADBSDSServiceListener")) : class$de$audi$atip$interapp$ADBSDSServiceListener).getName(), (class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = AbstractAddressBookActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (class$de$audi$tghu$filebrowser$IFileBrowserManager == null ? (class$de$audi$tghu$filebrowser$IFileBrowserManager = AbstractAddressBookActivator.class$("de.audi.tghu.filebrowser.IFileBrowserManager")) : class$de$audi$tghu$filebrowser$IFileBrowserManager).getName(), (class$de$audi$atip$interapp$IMessagingService == null ? (class$de$audi$atip$interapp$IMessagingService = AbstractAddressBookActivator.class$("de.audi.atip.interapp.IMessagingService")) : class$de$audi$atip$interapp$IMessagingService).getName()};
        this.serviceTracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
        this.registerServices();
        this.startDSIServices();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.appAdr.getLog().log(1078071040, "AbstractAddressBookActivator#stop(): bundleContext: %1", (Object)bundleContext);
        if (this.serviceTracker != null) {
            this.serviceTracker.close();
        }
        this.cleanupDSIComponents();
        this.cleanupApplicationComponents();
        super.stop(bundleContext);
    }

    protected abstract AbstractAddressBookApplication createAddressBookApplication(IFrameworkAccess iFrameworkAccess) {
    }

    protected void registerServices() {
        Hashtable hashtable = AbstractAddressBookActivator.createServiceProperties();
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        hashtable.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
        this.registerService(new String[]{(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractAddressBookActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractAddressBookActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName()}, (Object)new AddressBookHMIApplication(this.appAdr), (Dictionary)hashtable);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractAddressBookActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.appAdr, (Dictionary)AbstractAddressBookActivator.createServiceProperties());
        this.addressBookHMIAppServiceImpl = new AddressBookHMIAppServiceImpl(this.appAdr, this.appAdr.getLog());
        this.registerService((class$de$audi$atip$interapp$ADBHMIAppService == null ? (class$de$audi$atip$interapp$ADBHMIAppService = AbstractAddressBookActivator.class$("de.audi.atip.interapp.ADBHMIAppService")) : class$de$audi$atip$interapp$ADBHMIAppService).getName(), (Object)this.addressBookHMIAppServiceImpl, (Dictionary)AbstractAddressBookActivator.createServiceProperties("AddressBookInterHMIAppService"));
        this.registerService((class$de$audi$atip$interapp$ADBSDSService == null ? (class$de$audi$atip$interapp$ADBSDSService = AbstractAddressBookActivator.class$("de.audi.atip.interapp.ADBSDSService")) : class$de$audi$atip$interapp$ADBSDSService).getName(), (Object)this.adbSDSHandler, (Dictionary)AbstractAddressBookActivator.createServiceProperties("AddressBookInterHMIAppService"));
        this.registerService((class$de$audi$atip$interapp$media$IMediaServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaServiceListener = AbstractAddressBookActivator.class$("de.audi.atip.interapp.media.IMediaServiceListener")) : class$de$audi$atip$interapp$media$IMediaServiceListener).getName(), (Object)this.vCardExchangeADBHandler.getMediaHandler(), (Dictionary)AbstractAddressBookActivator.createServiceProperties());
        hashtable = AbstractAddressBookActivator.createServiceProperties();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_ADB);
        this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractAddressBookActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)this.appAdr.getTTSHandler(), (Dictionary)hashtable);
        String string = (class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractAddressBookActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName();
        this.registerService(string, (Object)this.appAdr.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener).getName(), 0));
        this.registerService(string, (Object)this.appAdr.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName(), 0));
        this.registerService(string, (Object)this.appAdr.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName(), 0));
        this.registerService(string, (Object)this.appAdr.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName(), 0));
        this.registerService(string, (Object)this.appAdr.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbInitListener == null ? (class$org$dsi$ifc$organizer$DSIAdbInitListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbInitListener")) : class$org$dsi$ifc$organizer$DSIAdbInitListener).getName(), 0));
        this.registerService(string, (Object)this.vCardExchangeADBHandler.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName(), 4));
        this.registerService(string, (Object)this.vCardExchangeADBHandler.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName(), 4));
        this.registerService(string, (Object)this.vCardExchangeADBHandler.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName(), 4));
        this.registerService(string, (Object)this.vCardExchangeADBHandler.getADBDSIListener(), (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener).getName(), 0));
        if (this.framework.getKombiProtocol() == 2) {
            ADBDSIListener aDBDSIListener = this.bapCombiADBHandler.getADBDSIListener();
            this.registerService(string, (Object)aDBDSIListener, (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName(), 3));
            this.registerService(string, (Object)aDBDSIListener, (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener).getName(), 3));
            this.registerService(string, (Object)aDBDSIListener, (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName(), 3));
            this.registerService(string, (Object)aDBDSIListener, (Dictionary)AbstractAddressBookActivator.createDSIListenerProperties((class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName(), 3));
            this.registerService((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener = AbstractAddressBookActivator.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBookListener")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener).getName(), (Object)this.bapCombiADBHandler.getCombiService(), null);
        }
    }

    private void startDSIServices() {
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 1);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 1);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 1);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 1);
        if (this.framework.getSysConst(459) == 1) {
            this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 2);
            this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 2);
            this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 2);
            this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 2);
        }
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 4);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 4);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 4);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbVCardExchange == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchange = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbVCardExchange")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchange).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 3);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 3);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 3);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 3);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 5);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 5);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 5);
        this.framework.startDSIService((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractAddressBookActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 5);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.log.log(-2137614336, "AbstractAddressBookActivator#addingService(): serviceReference: %1", (Object)serviceReference);
        if (this.bundleContext == null) {
            this.log.log(-2137614336, "AbstractAddressBookActivator#addingService(): bundleContext is null, bundle probably has been stopped -> NOP");
            return null;
        }
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof NaviADBService) {
            this.appAdr.getNaviGateway().setNaviService((NaviADBService)object);
            return object;
        }
        if (object instanceof ITelService) {
            this.appAdr.getPhoneGateway().setPhoneService((ITelService)object);
            return object;
        }
        if (object instanceof ITelServiceADB) {
            this.appAdr.getPhoneGateway().setPhoneAdbService((ITelServiceADB)object);
            return object;
        }
        if (object instanceof ITelPresetService) {
            this.appAdr.getPhoneGateway().setPhonePresetService((ITelPresetService)object);
            return object;
        }
        if (object instanceof CombiBAPServiceAddressBook) {
            this.bapCombiADBHandler.getCombiService().setCombiService((CombiBAPServiceAddressBook)object);
            return object;
        }
        if (object instanceof ADBSDSServiceListener) {
            this.adbSDSHandler.setSDSServiceListener((ADBSDSServiceListener)object);
            return object;
        }
        if (object instanceof TTSService && TTSService.CLIENT_ID_ADB.equals(serviceReference.getProperty("TTS_CLIENT_ID"))) {
            this.appAdr.getTTSHandler().setTTSService((TTSSingleSpeakService)object);
            return object;
        }
        if (object instanceof IFileBrowserManager) {
            this.vCardExchangeADBHandler.setFileBrowserManager((IFileBrowserManager)object);
            return object;
        }
        if (object instanceof IMessagingService) {
            this.appAdr.getMessagingGateway().setMessagingService((IMessagingService)object);
            return object;
        }
        if (object instanceof SwDiagnosisManager) {
            this.adbDiag = new AddressBookDiag(this.appAdr, this.vCardExchangeADBHandler, this.addressBookHMIAppServiceImpl);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.adbDiag);
            return object;
        }
        int n = this.getInstanceId(serviceReference);
        boolean bl = this.addMainAdbDsiServices(object, n);
        if (bl) {
            return object;
        }
        bl = this.addVCardExchangeDsiServices(object, n);
        if (bl) {
            return object;
        }
        bl = this.addCombiDsiServices(object, n);
        if (bl) {
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private boolean addMainAdbDsiServices(Object object, int n) {
        if (object instanceof DSIAdbEdit && n == 0) {
            this.appAdr.getADBDSIAccess().setDSIAdbEdit((DSIAdbEdit)object, this.appAdr.getADBDSIListener());
            return true;
        }
        if (object instanceof DSIAdbList && n == 0) {
            this.appAdr.getADBDSIAccess().setDSIAdbList((DSIAdbList)object, this.appAdr.getADBDSIListener());
            return true;
        }
        if (object instanceof DSIAdbUserProfile && n == 0) {
            this.appAdr.getADBDSIAccess().setDSIAdbUserProfile((DSIAdbUserProfile)object, this.appAdr.getADBDSIListener());
            return true;
        }
        if (object instanceof DSIAdbSetup && n == 0) {
            this.appAdr.getADBDSIAccess().setDSIAdbSetup((DSIAdbSetup)object, this.appAdr.getADBDSIListener());
            return true;
        }
        if (object instanceof DSIAdbInit && n == 0) {
            this.appAdr.getADBDSIAccess().setDSIAdbInit((DSIAdbInit)object, this.appAdr.getADBDSIListener());
            return true;
        }
        return false;
    }

    private boolean addVCardExchangeDsiServices(Object object, int n) {
        if (object instanceof DSIAdbList && n == 4) {
            this.vCardExchangeADBHandler.getADBDSIAccess().setDSIAdbList((DSIAdbList)object, this.vCardExchangeADBHandler.getADBDSIListener());
            return true;
        }
        if (object instanceof DSIAdbUserProfile && n == 4) {
            this.vCardExchangeADBHandler.getADBDSIAccess().setDSIAdbUserProfile((DSIAdbUserProfile)object, this.vCardExchangeADBHandler.getADBDSIListener());
            return true;
        }
        if (object instanceof DSIAdbSetup && n == 4) {
            this.vCardExchangeADBHandler.getADBDSIAccess().setDSIAdbSetup((DSIAdbSetup)object, this.vCardExchangeADBHandler.getADBDSIListener());
            return true;
        }
        if (object instanceof DSIAdbVCardExchange && n == 0) {
            this.vCardExchangeADBHandler.getADBDSIAccess().setDSIAdbVCardExchange((DSIAdbVCardExchange)object, this.vCardExchangeADBHandler.getADBDSIListener());
            return true;
        }
        return false;
    }

    protected boolean addCombiDsiServices(Object object, int n) {
        ADBDSIAccess aDBDSIAccess = this.bapCombiADBHandler.getADBDSIAccess();
        ADBDSIListener aDBDSIListener = this.bapCombiADBHandler.getADBDSIListener();
        if (object instanceof DSIAdbList && n == 3) {
            aDBDSIAccess.setDSIAdbList((DSIAdbList)object, aDBDSIListener);
            return true;
        }
        if (object instanceof DSIAdbEdit && n == 3) {
            aDBDSIAccess.setDSIAdbEdit((DSIAdbEdit)object, aDBDSIListener);
            return true;
        }
        if (object instanceof DSIAdbUserProfile && n == 3) {
            aDBDSIAccess.setDSIAdbUserProfile((DSIAdbUserProfile)object, aDBDSIListener);
            return true;
        }
        if (object instanceof DSIAdbSetup && n == 3) {
            aDBDSIAccess.setDSIAdbSetup((DSIAdbSetup)object, aDBDSIListener);
            return true;
        }
        return false;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(-2137614336, "AbstractAddressBookActivator#removedService(): sr: %1, svc: %2, bundleContext: %3", (Object)serviceReference, object, (Object)this.bundleContext);
        if (this.bundleContext != null) {
            if (this.removedDSIService(serviceReference, object)) {
                return;
            }
            this.bundleContext.ungetService(serviceReference);
            if (object instanceof ITelService) {
                this.appAdr.getPhoneGateway().releasePhoneService();
                return;
            }
            if (object instanceof ITelServiceADB) {
                this.appAdr.getPhoneGateway().releasePhoneAdbService();
                return;
            }
            if (object instanceof ITelPresetService) {
                this.appAdr.getPhoneGateway().releasePhonePresetService();
                return;
            }
            if (object instanceof NaviADBService) {
                this.appAdr.getNaviGateway().setNaviService(null);
                return;
            }
            if (object instanceof CombiBAPServiceAddressBook) {
                this.bapCombiADBHandler.getCombiService().setCombiService(null);
                return;
            }
            if (object instanceof ADBSDSServiceListener) {
                this.adbSDSHandler.setSDSServiceListener(null);
                return;
            }
            if (object instanceof TTSService) {
                this.appAdr.getTTSHandler().setTTSService(null);
                return;
            }
            if (object instanceof IFileBrowserManager) {
                this.vCardExchangeADBHandler.setFileBrowserManager(null);
                return;
            }
            if (object instanceof IMessagingService) {
                this.appAdr.getMessagingGateway().releaseMessagingService();
                return;
            }
            if (object instanceof SwDiagnosisManager) {
                ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)this.adbDiag);
                return;
            }
        }
    }

    private boolean removedDSIAdbInit(Object object, int n) {
        return object instanceof DSIAdbInit && n == 0;
    }

    private boolean removedDSIAdbEdit(Object object, int n) {
        return object instanceof DSIAdbEdit && (n == 0 || n == 3);
    }

    private boolean removedDSIAdbList(Object object, int n) {
        return object instanceof DSIAdbList && (n == 0 || n == 3 || n == 4);
    }

    private boolean removedDSIAdbSetup(Object object, int n) {
        return object instanceof DSIAdbSetup && (n == 0 || n == 3 || n == 4);
    }

    private boolean removedDSIAdbUserProfile(Object object, int n) {
        return object instanceof DSIAdbUserProfile && (n == 0 || n == 3 || n == 4);
    }

    private boolean removedDSIAdbVCardExchange(Object object, int n) {
        return object instanceof DSIAdbVCardExchange && n == 0;
    }

    private boolean removedDSIService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null || object == null) {
            return false;
        }
        int n = this.getInstanceId(serviceReference);
        if (this.removedDSIAdbInit(object, n) || this.removedDSIAdbEdit(object, n) || this.removedDSIAdbList(object, n) || this.removedDSIAdbSetup(object, n) || this.removedDSIAdbUserProfile(object, n) || this.removedDSIAdbVCardExchange(object, n)) {
            this.bundleContext.ungetService(serviceReference);
            return true;
        }
        return false;
    }

    protected static Hashtable createServiceProperties() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", (class$de$audi$app$addressbook$core$main$AbstractAddressBookApplication == null ? (class$de$audi$app$addressbook$core$main$AbstractAddressBookApplication = AbstractAddressBookActivator.class$("de.audi.app.addressbook.core.main.AbstractAddressBookApplication")) : class$de$audi$app$addressbook$core$main$AbstractAddressBookApplication).getName());
        hashtable.put("moduleID", new Integer(7));
        return hashtable;
    }

    protected static Hashtable createActionProxyServiceProperties(int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(n));
        return hashtable;
    }

    private static Hashtable createServiceProperties(String string) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", string);
        hashtable.put("moduleID", new Integer(7));
        return hashtable;
    }

    protected static Hashtable createDSIListenerProperties(String string, int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", string);
        hashtable.put("DEVICE_INSTANCE", new Integer(n));
        return hashtable;
    }

    private int getInstanceId(ServiceReference serviceReference) {
        Object object = serviceReference.getProperty("DEVICE_INSTANCE");
        if (object instanceof Integer) {
            return (Integer)object;
        }
        return -1;
    }

    private void cleanupDSIComponents() {
        this.log.log(1078071040, "AbstractAddressBookActivator#cleanupDSIComponents(): setting all DSI references to null.");
        this.appAdr.getADBDSIAccess().clearDSIAdbInit(this.appAdr.getADBDSIListener());
        this.appAdr.getADBDSIAccess().clearDSIAdbList(this.appAdr.getADBDSIListener());
        this.appAdr.getADBDSIAccess().clearDSIAdbUserProfile(this.appAdr.getADBDSIListener());
        this.appAdr.getADBDSIAccess().clearDSIAdbSetup(this.appAdr.getADBDSIListener());
        this.appAdr.getADBDSIAccess().clearDSIAdbEdit(this.appAdr.getADBDSIListener());
        this.appAdr.getADBDSIAccess().clearDSIAdbVCardExchange(this.appAdr.getADBDSIListener());
    }

    private void cleanupApplicationComponents() {
        this.adbSDSHandler = null;
        if (this.bapCombiADBHandler != null) {
            this.bapCombiADBHandler.getAdbStateHandler().setAdbReady(false);
            this.bapCombiADBHandler.destroy();
            this.bapCombiADBHandler = null;
        }
        if (this.vCardExchangeADBHandler != null) {
            this.vCardExchangeADBHandler.getAdbStateHandler().setAdbReady(false);
            this.vCardExchangeADBHandler.destroy();
            this.vCardExchangeADBHandler = null;
        }
        if (this.appAdr != null) {
            this.appAdr.setBapCombiADBHandler(null);
            this.appAdr.getAdbStateHandler().setAdbReady(false);
            this.appAdr.destroy();
            this.appAdr = null;
        }
        this.log.log(1078071040, "AbstractAddressBookActivator#cleanupApplicationComponents(): application components have been set to null.");
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

