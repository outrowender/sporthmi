/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbEditListener;
import org.dsi.ifc.organizer.DSIAdbInitListener;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.DSIAdbSetupListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.IndexInformation;
import org.dsi.ifc.organizer.ProfileInfo;

public class ADBDSIListener
implements DSIAdbListListener,
DSIAdbEditListener,
DSIAdbUserProfileListener,
DSIAdbSetupListener,
DSIAdbInitListener,
DSIAdbVCardExchangeListener,
ICommandResponseSupplier {
    private CommandListManager cmdListMgr;
    private ADBDSIDefaultListener defaultListener;

    public ADBDSIListener(CommandListManager commandListManager, ADBDSIDefaultListener aDBDSIDefaultListener) {
        this.cmdListMgr = commandListManager;
        this.defaultListener = aDBDSIDefaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.cmdListMgr.getActiveCommandList();
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public LogChannel getLogChannel() {
        return this.cmdListMgr.getLogChannel();
    }

    public void asyncException(final int n, final String string, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).asyncException(n, string, n2);
            }
        });
    }

    public void getViewWindowResult(final int n, final DataSet[] dataSetArray, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).getViewWindowResult(n, dataSetArray, n2);
            }
        });
    }

    public void invalidData(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).invalidData(n);
            }
        });
    }

    public void spellerResult(final int n, final int n2, final DataSet[] dataSetArray, final int n3, final String string, final String string2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).spellerResult(n, n2, dataSetArray, n3, string, string2);
            }
        });
    }

    public void stopSpellerResult(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).stopSpellerResult(n, n2);
            }
        });
    }

    public void updateViewSize(final AdbViewSize adbViewSize, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).updateViewSize(adbViewSize, n);
            }
        });
    }

    public void validateSpellerCharsResult(final int n, final int n2, final String string, final String string2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).validateSpellerCharsResult(n, n2, string, string2);
            }
        });
    }

    public void getSpellerViewWindowResult(final int n, final int n2, final DataSet[] dataSetArray, final int n3) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).getSpellerViewWindowResult(n, n2, dataSetArray, n3);
            }
        });
    }

    public void setListStyleResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).setListStyleResult(n);
            }
        });
    }

    public void getValidHanziCharsWindowResult(final int n, final int n2, final int n3, final String string, final int n4) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).getValidHanziCharsWindowResult(n, n2, n3, string, n4);
            }
        });
    }

    public void updateAlphabeticalIndex(final IndexInformation[] indexInformationArray, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbListListener)dSIListener).updateAlphabeticalIndex(indexInformationArray, n);
            }
        });
    }

    public void changeEntryResult(final int n, final AdbEntry adbEntry) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).changeEntryResult(n, adbEntry);
            }
        });
    }

    public void copyEntryResult(final int n, final AdbEntry adbEntry) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).copyEntryResult(n, adbEntry);
            }
        });
    }

    public void deleteEntriesResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).deleteEntriesResult(n);
            }
        });
    }

    public void getEntriesResult(final int n, final AdbEntry[] adbEntryArray) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).getEntriesResult(n, adbEntryArray);
            }
        });
    }

    public void insertEntryResult(final int n, final AdbEntry adbEntry) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).insertEntryResult(n, adbEntry);
            }
        });
    }

    public void updateNewEntryAvailable(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).updateNewEntryAvailable(bl, n);
            }
        });
    }

    public void updateNewPublicProfileEntryAvailable(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).updateNewPublicProfileEntryAvailable(bl, n);
            }
        });
    }

    public void updateNewPublicProfileTopDestEntryAvailable(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).updateNewPublicProfileTopDestEntryAvailable(bl, n);
            }
        });
    }

    public void updateNewTopDestinationEntryAvailable(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).updateNewTopDestinationEntryAvailable(bl, n);
            }
        });
    }

    public void getEntryDataSetsResult(final int n, final DataSet[] dataSetArray) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).getEntryDataSetsResult(n, dataSetArray);
            }
        });
    }

    public void setSpeedDialResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).setSpeedDialResult(n);
            }
        });
    }

    public void deleteSpeedDialResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).deleteSpeedDialResult(n);
            }
        });
    }

    public void getEntryByReferenceIdResult(final int n, final AdbEntry adbEntry) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).getEntryByReferenceIdResult(n, adbEntry);
            }
        });
    }

    public void updateNewOnlineDestinationEntryAvailable(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbEditListener)dSIListener).updateNewOnlineDestinationEntryAvailable(bl, n);
            }
        });
    }

    public void commonEntryCountResult(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).commonEntryCountResult(n, n2);
            }
        });
    }

    public void deleteProfilesResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).deleteProfilesResult(n);
            }
        });
    }

    public void downloadToProfileResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).downloadToProfileResult(n);
            }
        });
    }

    public void entryMeterResult(final int n, final EntryMeter[] entryMeterArray) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).entryMeterResult(n, entryMeterArray);
            }
        });
    }

    public void newDeviceConnected(final String string) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).newDeviceConnected(string);
            }
        });
    }

    public void restartDownloadResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).restartDownloadResult(n);
            }
        });
    }

    public void setHomeIdResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).setHomeIdResult(n);
            }
        });
    }

    public void setPairingCodeResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).setPairingCodeResult(n);
            }
        });
    }

    public void setProfileNameResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).setProfileNameResult(n);
            }
        });
    }

    public void updateDeviceConnected(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateDeviceConnected(bl, n);
            }
        });
    }

    public void updateDownloadCountMe(final DownloadInfo downloadInfo, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateDownloadCountMe(downloadInfo, n);
            }
        });
    }

    public void updateDownloadCountOpp(final DownloadInfo downloadInfo, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateDownloadCountOpp(downloadInfo, n);
            }
        });
    }

    public void updateDownloadCountSim(final DownloadInfo downloadInfo, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateDownloadCountSim(downloadInfo, n);
            }
        });
    }

    public void updateProfileInfo(final ProfileInfo[] profileInfoArray, final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateProfileInfo(profileInfoArray, n, n2);
            }
        });
    }

    public void profileDeleted(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).profileDeleted(n);
            }
        });
    }

    public void updateDownloadState(final int n, final int n2, final int n3) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateDownloadState(n, n2, n3);
            }
        });
    }

    public void updateDownloadState2ndPhone(final int n, final int n2, final int n3) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateDownloadState2ndPhone(n, n2, n3);
            }
        });
    }

    public void setSOSButtonResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).setSOSButtonResult(n);
            }
        });
    }

    public void updateSOSButton(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbUserProfileListener)dSIListener).updateSOSButton(bl, n);
            }
        });
    }

    public void createBackupFileResult(final int n, final String string) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).createBackupFileResult(n, string);
            }
        });
    }

    public void importBackupFileResult(final int n, final String string) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).importBackupFileResult(n, string);
            }
        });
    }

    public void resetToFactorySettingsResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).resetToFactorySettingsResult(n);
            }
        });
    }

    public void resetTopDestinationResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).resetTopDestinationResult(n);
            }
        });
    }

    public void setLanguageResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).setLanguageResult(n);
            }
        });
    }

    public void setPublicProfileVisibilityResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).setPublicProfileVisibilityResult(n);
            }
        });
    }

    public void setSortOrderResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).setSortOrderResult(n);
            }
        });
    }

    public void updateAdbState(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).updateAdbState(n, n2);
            }
        });
    }

    public void updateSortOrder(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).updateSortOrder(n, n2);
            }
        });
    }

    public void setPictureVisibilityResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).setPictureVisibilityResult(n);
            }
        });
    }

    public void updatePictureVisibility(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).updatePictureVisibility(bl, n);
            }
        });
    }

    public void setContextSpecificVisibilityResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).setContextSpecificVisibilityResult(n);
            }
        });
    }

    public void updateContextSpecificVisibility(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbSetupListener)dSIListener).updateContextSpecificVisibility(bl, n);
            }
        });
    }

    public void setProfileHandlingType(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setProfileHandlingType(n);
            }
        });
    }

    public void setAutoProfileAllocationResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setAutoProfileAllocationResult(n);
            }
        });
    }

    public void setDefaultPublicProfileVisibilityResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setDefaultPublicProfileVisibilityResult(n);
            }
        });
    }

    public void setMaxLocalEntriesResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setMaxLocalEntriesResult(n);
            }
        });
    }

    public void setMaxPhoneEntriesResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setMaxPhoneEntriesResult(n);
            }
        });
    }

    public void setMaxTopDestEntriesResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setMaxTopDestEntriesResult(n);
            }
        });
    }

    public void updateAutoProfileAllocation(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).updateAutoProfileAllocation(bl, n);
            }
        });
    }

    public void updateDefaultPublicProfileVisibility(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).updateDefaultPublicProfileVisibility(bl, n);
            }
        });
    }

    public void updateMaxLocalEntries(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).updateMaxLocalEntries(n, n2);
            }
        });
    }

    public void updateMaxPhoneEntries(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).updateMaxPhoneEntries(n, n2);
            }
        });
    }

    public void updateMaxTopDestEntries(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).updateMaxTopDestEntries(n, n2);
            }
        });
    }

    public void setMaxSpeedDialEntriesResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setMaxSpeedDialEntriesResult(n);
            }
        });
    }

    public void updateMaxSpeedDialEntries(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).updateMaxSpeedDialEntries(n, n2);
            }
        });
    }

    public void setSpeedDialTypeResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setSpeedDialTypeResult(n);
            }
        });
    }

    public void setNumericalSpellerEnabledResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setNumericalSpellerEnabledResult(n);
            }
        });
    }

    public void setDefaultSortOrderResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setDefaultSortOrderResult(n);
            }
        });
    }

    public void setOnlineDestinationEnabledResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setOnlineDestinationEnabledResult(n);
            }
        });
    }

    public void setDefaultSOSButtonResult(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).setDefaultSOSButtonResult(n);
            }
        });
    }

    public void updateDefaultSOSButton(final boolean bl, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbInitListener)dSIListener).updateDefaultSOSButton(bl, n);
            }
        });
    }

    public void importVCardResult(final int n, final int n2, final int n3, final int n4) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).importVCardResult(n, n2, n3, n4);
            }
        });
    }

    public void exportVCardResult(final int n, final int n2, final int n3, final int n4) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).exportVCardResult(n, n2, n3, n4);
            }
        });
    }

    public void exportSpellerVCardResult(final int n, final int n2, final int n3, final int n4, final int n5) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).exportSpellerVCardResult(n, n2, n3, n4, n5);
            }
        });
    }

    public void createVCardResult(final int n, final long[] lArray, final int n2, final String string) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).createVCardResult(n, lArray, n2, string);
            }
        });
    }

    public void parseVCardResult(final int n, final AdbEntry[] adbEntryArray) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).parseVCardResult(n, adbEntryArray);
            }
        });
    }

    public void responseAbort(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).responseAbort(n);
            }
        });
    }

    public void updateImportCount(final DownloadInfo downloadInfo, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).updateImportCount(downloadInfo, n);
            }
        });
    }

    public void updateExportCount(final DownloadInfo downloadInfo, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIAdbVCardExchangeListener)dSIListener).updateExportCount(downloadInfo, n);
            }
        });
    }
}

