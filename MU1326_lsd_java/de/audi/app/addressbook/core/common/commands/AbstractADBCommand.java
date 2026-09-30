/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.tghu.command.Command;
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

public abstract class AbstractADBCommand
extends Command
implements DSIAdbListListener,
DSIAdbEditListener,
DSIAdbUserProfileListener,
DSIAdbSetupListener,
DSIAdbInitListener,
DSIAdbVCardExchangeListener {
    protected ADBDSIAccess adbDSIAccess;
    protected ADBDSIDefaultListener adbDSIDefaultListener;

    protected AbstractADBCommand(ADBApplication aDBApplication) {
        super(aDBApplication.getLog());
        this.adbDSIAccess = aDBApplication.getADBDSIAccess();
        this.adbDSIDefaultListener = aDBApplication.getADBDSIDefaultListener();
    }

    public String toString() {
        return this.getClass().getName();
    }

    public void asyncException(int n, String string, int n2) {
        this.adbDSIDefaultListener.asyncException(n, string, n2);
    }

    public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.adbDSIDefaultListener.getViewWindowResult(n, dataSetArray, n2);
    }

    public void invalidData(int n) {
        this.adbDSIDefaultListener.invalidData(n);
    }

    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.adbDSIDefaultListener.spellerResult(n, n2, dataSetArray, n3, string, string2);
    }

    public void stopSpellerResult(int n, int n2) {
        this.adbDSIDefaultListener.stopSpellerResult(n, n2);
    }

    public void updateViewSize(AdbViewSize adbViewSize, int n) {
        this.adbDSIDefaultListener.updateViewSize(adbViewSize, n);
    }

    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        this.adbDSIDefaultListener.validateSpellerCharsResult(n, n2, string, string2);
    }

    public void getSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        this.adbDSIDefaultListener.getSpellerViewWindowResult(n, n2, dataSetArray, n3);
    }

    public void setListStyleResult(int n) {
        this.adbDSIDefaultListener.setListStyleResult(n);
    }

    public void getValidHanziCharsWindowResult(int n, int n2, int n3, String string, int n4) {
        this.adbDSIDefaultListener.getValidHanziCharsWindowResult(n, n2, n3, string, n4);
    }

    public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
        this.adbDSIDefaultListener.updateAlphabeticalIndex(indexInformationArray, n);
    }

    public void changeEntryResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.changeEntryResult(n, adbEntry);
    }

    public void copyEntryResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.copyEntryResult(n, adbEntry);
    }

    public void deleteEntriesResult(int n) {
        this.adbDSIDefaultListener.deleteEntriesResult(n);
    }

    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.adbDSIDefaultListener.getEntriesResult(n, adbEntryArray);
    }

    public void insertEntryResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.insertEntryResult(n, adbEntry);
    }

    public void updateNewEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewEntryAvailable(bl, n);
    }

    public void updateNewPublicProfileEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewPublicProfileEntryAvailable(bl, n);
    }

    public void updateNewPublicProfileTopDestEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewPublicProfileTopDestEntryAvailable(bl, n);
    }

    public void updateNewTopDestinationEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewTopDestinationEntryAvailable(bl, n);
    }

    public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
        this.adbDSIDefaultListener.getEntryDataSetsResult(n, dataSetArray);
    }

    public void setSpeedDialResult(int n) {
        this.adbDSIDefaultListener.setSpeedDialResult(n);
    }

    public void deleteSpeedDialResult(int n) {
        this.adbDSIDefaultListener.deleteSpeedDialResult(n);
    }

    public void getEntryByReferenceIdResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.getEntryByReferenceIdResult(n, adbEntry);
    }

    public void updateNewOnlineDestinationEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewOnlineDestinationEntryAvailable(bl, n);
    }

    public void commonEntryCountResult(int n, int n2) {
        this.adbDSIDefaultListener.commonEntryCountResult(n, n2);
    }

    public void deleteProfilesResult(int n) {
        this.adbDSIDefaultListener.deleteProfilesResult(n);
    }

    public void downloadToProfileResult(int n) {
        this.adbDSIDefaultListener.downloadToProfileResult(n);
    }

    public void entryMeterResult(int n, EntryMeter[] entryMeterArray) {
        this.adbDSIDefaultListener.entryMeterResult(n, entryMeterArray);
    }

    public void newDeviceConnected(String string) {
        this.adbDSIDefaultListener.newDeviceConnected(string);
    }

    public void restartDownloadResult(int n) {
        this.adbDSIDefaultListener.restartDownloadResult(n);
    }

    public void setHomeIdResult(int n) {
        this.adbDSIDefaultListener.setHomeIdResult(n);
    }

    public void setPairingCodeResult(int n) {
        this.adbDSIDefaultListener.setPairingCodeResult(n);
    }

    public void setProfileNameResult(int n) {
        this.adbDSIDefaultListener.setProfileNameResult(n);
    }

    public void updateDeviceConnected(boolean bl, int n) {
        this.adbDSIDefaultListener.updateDeviceConnected(bl, n);
    }

    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateDownloadCountMe(downloadInfo, n);
    }

    public void updateDownloadCountOpp(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateDownloadCountOpp(downloadInfo, n);
    }

    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateDownloadCountSim(downloadInfo, n);
    }

    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) {
        this.adbDSIDefaultListener.updateProfileInfo(profileInfoArray, n, n2);
    }

    public void profileDeleted(int n) {
        this.adbDSIDefaultListener.profileDeleted(n);
    }

    public void updateDownloadState(int n, int n2, int n3) {
        this.adbDSIDefaultListener.updateDownloadState(n, n2, n3);
    }

    public void updateDownloadState2ndPhone(int n, int n2, int n3) {
        this.adbDSIDefaultListener.updateDownloadState2ndPhone(n, n2, n3);
    }

    public void setSOSButtonResult(int n) {
        this.adbDSIDefaultListener.setSOSButtonResult(n);
    }

    public void updateSOSButton(boolean bl, int n) {
        this.adbDSIDefaultListener.updateSOSButton(bl, n);
    }

    public void createBackupFileResult(int n, String string) {
        this.adbDSIDefaultListener.createBackupFileResult(n, string);
    }

    public void importBackupFileResult(int n, String string) {
        this.adbDSIDefaultListener.importBackupFileResult(n, string);
    }

    public void resetToFactorySettingsResult(int n) {
        this.adbDSIDefaultListener.resetToFactorySettingsResult(n);
    }

    public void resetTopDestinationResult(int n) {
        this.adbDSIDefaultListener.resetTopDestinationResult(n);
    }

    public void setLanguageResult(int n) {
        this.adbDSIDefaultListener.setLanguageResult(n);
    }

    public void setPublicProfileVisibilityResult(int n) {
        this.adbDSIDefaultListener.setPublicProfileVisibilityResult(n);
    }

    public void setSortOrderResult(int n) {
        this.adbDSIDefaultListener.setSortOrderResult(n);
    }

    public void updateAdbState(int n, int n2) {
        this.adbDSIDefaultListener.updateAdbState(n, n2);
    }

    public void updateSortOrder(int n, int n2) {
        this.adbDSIDefaultListener.updateSortOrder(n, n2);
    }

    public void updatePictureVisibility(boolean bl, int n) {
        this.adbDSIDefaultListener.updatePictureVisibility(bl, n);
    }

    public void setPictureVisibilityResult(int n) {
        this.adbDSIDefaultListener.setPictureVisibilityResult(n);
    }

    public void setContextSpecificVisibilityResult(int n) {
        this.adbDSIDefaultListener.setContextSpecificVisibilityResult(n);
    }

    public void updateContextSpecificVisibility(boolean bl, int n) {
        this.adbDSIDefaultListener.updateContextSpecificVisibility(bl, n);
    }

    public void setProfileHandlingType(int n) {
        this.adbDSIDefaultListener.setProfileHandlingType(n);
    }

    public void setAutoProfileAllocationResult(int n) {
        this.adbDSIDefaultListener.setAutoProfileAllocationResult(n);
    }

    public void setDefaultPublicProfileVisibilityResult(int n) {
        this.adbDSIDefaultListener.setDefaultPublicProfileVisibilityResult(n);
    }

    public void setMaxLocalEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxLocalEntriesResult(n);
    }

    public void setMaxPhoneEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxPhoneEntriesResult(n);
    }

    public void setMaxTopDestEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxTopDestEntriesResult(n);
    }

    public void updateAutoProfileAllocation(boolean bl, int n) {
        this.adbDSIDefaultListener.updateAutoProfileAllocation(bl, n);
    }

    public void updateDefaultPublicProfileVisibility(boolean bl, int n) {
        this.adbDSIDefaultListener.updateDefaultPublicProfileVisibility(bl, n);
    }

    public void updateMaxLocalEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxLocalEntries(n, n2);
    }

    public void updateMaxPhoneEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxPhoneEntries(n, n2);
    }

    public void updateMaxTopDestEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxTopDestEntries(n, n2);
    }

    public void setMaxSpeedDialEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxSpeedDialEntriesResult(n);
    }

    public void updateMaxSpeedDialEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxSpeedDialEntries(n, n2);
    }

    public void setSpeedDialTypeResult(int n) {
        this.adbDSIDefaultListener.setSpeedDialTypeResult(n);
    }

    public void setNumericalSpellerEnabledResult(int n) {
        this.adbDSIDefaultListener.setNumericalSpellerEnabledResult(n);
    }

    public void setDefaultSortOrderResult(int n) {
        this.adbDSIDefaultListener.setDefaultSortOrderResult(n);
    }

    public void setOnlineDestinationEnabledResult(int n) {
        this.adbDSIDefaultListener.setOnlineDestinationEnabledResult(n);
    }

    public void setDefaultSOSButtonResult(int n) {
        this.adbDSIDefaultListener.setDefaultSOSButtonResult(n);
    }

    public void updateDefaultSOSButton(boolean bl, int n) {
        this.adbDSIDefaultListener.updateDefaultSOSButton(bl, n);
    }

    public void importVCardResult(int n, int n2, int n3, int n4) {
        this.adbDSIDefaultListener.importVCardResult(n, n2, n3, n4);
    }

    public void exportVCardResult(int n, int n2, int n3, int n4) {
        this.adbDSIDefaultListener.exportVCardResult(n, n2, n3, n4);
    }

    public void exportSpellerVCardResult(int n, int n2, int n3, int n4, int n5) {
        this.adbDSIDefaultListener.exportSpellerVCardResult(n, n2, n3, n4, n5);
    }

    public void createVCardResult(int n, long[] lArray, int n2, String string) {
        this.adbDSIDefaultListener.createVCardResult(n, lArray, n2, string);
    }

    public void parseVCardResult(int n, AdbEntry[] adbEntryArray) {
        this.adbDSIDefaultListener.parseVCardResult(n, adbEntryArray);
    }

    public void responseAbort(int n) {
        this.adbDSIDefaultListener.responseAbort(n);
    }

    public void updateImportCount(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateImportCount(downloadInfo, n);
    }

    public void updateExportCount(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateExportCount(downloadInfo, n);
    }
}

