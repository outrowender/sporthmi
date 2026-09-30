/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBConfigUtils;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.AbstractADBHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.app.addressbook.core.common.interapp.PhoneGateway;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.addressbook.core.main.AddressBookDSIDefaultListener;
import de.audi.app.addressbook.core.main.commands.setup.ResetToFactorySettingsCommand;
import de.audi.app.addressbook.core.main.commands.setup.SetLanguageCommand;
import de.audi.app.addressbook.core.main.interapp.AddressBookLocationInputHandler;
import de.audi.app.addressbook.core.main.interapp.MessagingGateway;
import de.audi.app.addressbook.core.main.interapp.NaviGateway;
import de.audi.app.addressbook.core.main.models.AddressBookEntryDetails;
import de.audi.app.addressbook.core.main.models.AddressBookViewListener;
import de.audi.app.addressbook.core.main.models.UserProfileUpdater;
import de.audi.app.addressbook.core.main.tts.AddressBookTTSHandler;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.ProfileInfo;

public abstract class AbstractAddressBookApplication
extends AbstractADBHandler
implements MsgListener {
    private UserProfileUpdater userProfileUpdater = new UserProfileUpdater(this.log, this);
    private NaviGateway naviGateway;
    private PhoneGateway phoneGateway;
    private MessagingGateway messagingGateway;
    private AddressBookLocationInputHandler locationInputHandler;
    private AddressBookTTSHandler ttsHandler;
    private VCardExchangeADBHandler vCardExchangeADBHandler;
    private DispatcherBase jobDispatcher;
    private volatile String currentLanguageCode = null;
    private CombiADBHandler bapCombiADBHandler;

    public AbstractAddressBookApplication(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, iFrameworkAccess.getLogChannel("App.AddressBook.Main"), iFrameworkAccess.getLogChannel("App.AddressBook.Main.CmdList"));
        new AddressBookViewListener(this.log, this);
        this.naviGateway = new NaviGateway(this.log, this);
        this.phoneGateway = new PhoneGateway(this.log, this);
        this.messagingGateway = new MessagingGateway(this.log, this);
        this.locationInputHandler = new AddressBookLocationInputHandler(this, this.log);
        this.jobDispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("App.AddressBook.Main_JobDispatcher", new JobLogger(this.log));
        this.jobDispatcher.start();
        this.ttsHandler = new AddressBookTTSHandler(this.log);
    }

    protected ADBDSIDefaultListener getNewADBDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, ADBApplication aDBApplication) {
        return new AddressBookDSIDefaultListener(logChannel, aDBStartupHandler, this);
    }

    public abstract ADBOrganizerSearch getADBOrganizerSearch();

    public NaviGateway getNaviGateway() {
        return this.naviGateway;
    }

    public PhoneGateway getPhoneGateway() {
        return this.phoneGateway;
    }

    public MessagingGateway getMessagingGateway() {
        return this.messagingGateway;
    }

    public UserProfileUpdater getUserProfileUpdater() {
        return this.userProfileUpdater;
    }

    public abstract AddressBookEntryDetails getSelectedEntryDetails();

    public AddressBookLocationInputHandler getLocationInputHandler() {
        return this.locationInputHandler;
    }

    public void setVCardExchangeADBHandler(VCardExchangeADBHandler vCardExchangeADBHandler) {
        this.vCardExchangeADBHandler = vCardExchangeADBHandler;
    }

    public VCardExchangeADBHandler getVCardExchangeADBHandler() {
        return this.vCardExchangeADBHandler;
    }

    public DispatcherBase getJobDispatcher() {
        return this.jobDispatcher;
    }

    public AddressBookTTSHandler getTTSHandler() {
        return this.ttsHandler;
    }

    public void setCurrentLanguageCode(String string) {
        this.currentLanguageCode = string;
    }

    public int getInitStartupCompleteMask() {
        return 253;
    }

    public void handleInvalidData(int n, boolean bl) {
        this.log.log(1000000, "AbstractAddressBookApplication#handleInvalidData(): reason: %2, reloadMainList: %1", bl, (Object)ADBDbgUtils.dbgInvalidDataReason(n));
        if (bl) {
            this.getADBOrganizerSearch().startSearch();
            this.jumpToMainList();
        }
    }

    public void setAdbReady(boolean bl) {
        this.log.log(10000000, "AbstractAddressBookApplication#setAdbReady(): ready: %1", bl);
        this.getHMIService().getChoiceModel(15).setValue(bl ? 1 : 0);
        this.getHMIService().getChoiceModel(15).setStatus(bl ? 1 : 0);
        if (bl) {
            this.getFramework().getStartupMgr().logStartupEvent("Addressbook available");
            String string = this.currentLanguageCode;
            if (string != null) {
                SetLanguageCommand.createSetLanguageCommand(this, string);
            }
        }
    }

    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n) {
        this.userProfileUpdater.updateActiveProfileModels();
    }

    public void updateDownloadState(int n, int n2) {
        this.userProfileUpdater.updateDownloadState(n, n2);
    }

    public void updateDownloadState2ndPhone(int n, int n2) {
        this.userProfileUpdater.updateDownloadState2ndPhone(n, n2);
    }

    public void updateNewEntryAvailable(boolean bl) {
        this.getHMIService().getChoiceModel(700488).setValue(bl ? 1 : 0);
    }

    public void updateNewPublicProfileEntryAvailable(boolean bl) {
        this.getHMIService().getChoiceModel(700489).setValue(bl ? 1 : 0);
    }

    public void updateViewSizes(AdbViewSize adbViewSize) {
        this.getHMIService().getChoiceModel(13).setValue(adbViewSize.all == 0 ? 0 : 1);
        ProfileInfo profileInfo = this.getAdbStateHandler().getActiveProfileInfo();
        boolean bl = profileInfo == null ? ADBConfigUtils.getDefaultPublicVisibility(this.getFramework()) : profileInfo.isPublicProfileVisibility();
        int n = bl ? adbViewSize.all - adbViewSize.publicProfileEntries : adbViewSize.all;
        this.getUserProfileUpdater().updateCapacityInfo(n, adbViewSize.publicProfileEntries);
    }

    public void processMsg(int n) {
        if (n == 30) {
            this.log.log(1000000, "AbstractAddressBookApplication#processMsg(): RESET_ADDRESSBOOK_SETTINGS");
            ResetToFactorySettingsCommand.createResetToFactorySettingsCommand(this);
            this.vCardExchangeADBHandler.abortImport();
        } else if (n == 31) {
            this.log.log(1000000, "AbstractAddressBookApplication#processMsg(): RESET_ADDRESSBOOK_DELETE_ALL");
            ResetToFactorySettingsCommand.createResetToFactorySettingsCommand(this);
            this.vCardExchangeADBHandler.abortImport();
        }
    }

    public HMIModelApp getListSyncModel() {
        return this.getHMIService().getChoiceModel(700498);
    }

    public void jumpToMainList() {
        this.log.log(10000000, "AbstractAddressBookApplication#jumpToMainList()");
        this.getHMIService().getChoiceModel(700490).setValue(this.getHMIService().getChoiceModel(700490).getValue() == 0 ? 1 : 0);
    }

    public void setAdbMode(int n) {
        this.log.log(10000000, "AbstractAddressBookApplication#setAdbMode(): mode: %1", (Object)ADBDbgUtils.dbgAdbMode(n));
        this.getHMIService().getChoiceModel(17).setValue(n);
    }

    public int getAdbMode() {
        return this.getHMIService().getChoiceModel(17).getValue();
    }

    public abstract void loadMainList(int var1);

    public void setBapCombiADBHandler(CombiADBHandler combiADBHandler) {
        this.bapCombiADBHandler = combiADBHandler;
    }

    public CombiADBHandler getCombiAdbHandler() {
        return this.bapCombiADBHandler;
    }
}

