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

    @Override
    public String toString() {
        return super.getClass().getName();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.adbDSIDefaultListener.asyncException(n, string, n2);
    }

    @Override
    public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.adbDSIDefaultListener.getViewWindowResult(n, dataSetArray, n2);
    }

    @Override
    public void invalidData(int n) {
        this.adbDSIDefaultListener.invalidData(n);
    }

    @Override
    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.adbDSIDefaultListener.spellerResult(n, n2, dataSetArray, n3, string, string2);
    }

    @Override
    public void stopSpellerResult(int n, int n2) {
        this.adbDSIDefaultListener.stopSpellerResult(n, n2);
    }

    @Override
    public void updateViewSize(AdbViewSize adbViewSize, int n) {
        this.adbDSIDefaultListener.updateViewSize(adbViewSize, n);
    }

    @Override
    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        this.adbDSIDefaultListener.validateSpellerCharsResult(n, n2, string, string2);
    }

    @Override
    public void getSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        this.adbDSIDefaultListener.getSpellerViewWindowResult(n, n2, dataSetArray, n3);
    }

    @Override
    public void setListStyleResult(int n) {
        this.adbDSIDefaultListener.setListStyleResult(n);
    }

    @Override
    public void getValidHanziCharsWindowResult(int n, int n2, int n3, String string, int n4) {
        this.adbDSIDefaultListener.getValidHanziCharsWindowResult(n, n2, n3, string, n4);
    }

    @Override
    public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
        this.adbDSIDefaultListener.updateAlphabeticalIndex(indexInformationArray, n);
    }

    @Override
    public void changeEntryResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.changeEntryResult(n, adbEntry);
    }

    @Override
    public void copyEntryResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.copyEntryResult(n, adbEntry);
    }

    @Override
    public void deleteEntriesResult(int n) {
        this.adbDSIDefaultListener.deleteEntriesResult(n);
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.adbDSIDefaultListener.getEntriesResult(n, adbEntryArray);
    }

    @Override
    public void insertEntryResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.insertEntryResult(n, adbEntry);
    }

    @Override
    public void updateNewEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewEntryAvailable(bl, n);
    }

    @Override
    public void updateNewPublicProfileEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewPublicProfileEntryAvailable(bl, n);
    }

    @Override
    public void updateNewPublicProfileTopDestEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewPublicProfileTopDestEntryAvailable(bl, n);
    }

    @Override
    public void updateNewTopDestinationEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewTopDestinationEntryAvailable(bl, n);
    }

    @Override
    public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
        this.adbDSIDefaultListener.getEntryDataSetsResult(n, dataSetArray);
    }

    @Override
    public void setSpeedDialResult(int n) {
        this.adbDSIDefaultListener.setSpeedDialResult(n);
    }

    @Override
    public void deleteSpeedDialResult(int n) {
        this.adbDSIDefaultListener.deleteSpeedDialResult(n);
    }

    @Override
    public void getEntryByReferenceIdResult(int n, AdbEntry adbEntry) {
        this.adbDSIDefaultListener.getEntryByReferenceIdResult(n, adbEntry);
    }

    @Override
    public void updateNewOnlineDestinationEntryAvailable(boolean bl, int n) {
        this.adbDSIDefaultListener.updateNewOnlineDestinationEntryAvailable(bl, n);
    }

    @Override
    public void commonEntryCountResult(int n, int n2) {
        this.adbDSIDefaultListener.commonEntryCountResult(n, n2);
    }

    @Override
    public void deleteProfilesResult(int n) {
        this.adbDSIDefaultListener.deleteProfilesResult(n);
    }

    @Override
    public void downloadToProfileResult(int n) {
        this.adbDSIDefaultListener.downloadToProfileResult(n);
    }

    @Override
    public void entryMeterResult(int n, EntryMeter[] entryMeterArray) {
        this.adbDSIDefaultListener.entryMeterResult(n, entryMeterArray);
    }

    @Override
    public void newDeviceConnected(String string) {
        this.adbDSIDefaultListener.newDeviceConnected(string);
    }

    @Override
    public void restartDownloadResult(int n) {
        this.adbDSIDefaultListener.restartDownloadResult(n);
    }

    @Override
    public void setHomeIdResult(int n) {
        this.adbDSIDefaultListener.setHomeIdResult(n);
    }

    @Override
    public void setPairingCodeResult(int n) {
        this.adbDSIDefaultListener.setPairingCodeResult(n);
    }

    @Override
    public void setProfileNameResult(int n) {
        this.adbDSIDefaultListener.setProfileNameResult(n);
    }

    @Override
    public void updateDeviceConnected(boolean bl, int n) {
        this.adbDSIDefaultListener.updateDeviceConnected(bl, n);
    }

    @Override
    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateDownloadCountMe(downloadInfo, n);
    }

    @Override
    public void updateDownloadCountOpp(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateDownloadCountOpp(downloadInfo, n);
    }

    @Override
    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateDownloadCountSim(downloadInfo, n);
    }

    @Override
    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) {
        this.adbDSIDefaultListener.updateProfileInfo(profileInfoArray, n, n2);
    }

    @Override
    public void profileDeleted(int n) {
        this.adbDSIDefaultListener.profileDeleted(n);
    }

    @Override
    public void updateDownloadState(int n, int n2, int n3) {
        this.adbDSIDefaultListener.updateDownloadState(n, n2, n3);
    }

    @Override
    public void updateDownloadState2ndPhone(int n, int n2, int n3) {
        this.adbDSIDefaultListener.updateDownloadState2ndPhone(n, n2, n3);
    }

    @Override
    public void setSOSButtonResult(int n) {
        this.adbDSIDefaultListener.setSOSButtonResult(n);
    }

    @Override
    public void updateSOSButton(boolean bl, int n) {
        this.adbDSIDefaultListener.updateSOSButton(bl, n);
    }

    @Override
    public void createBackupFileResult(int n, String string) {
        this.adbDSIDefaultListener.createBackupFileResult(n, string);
    }

    @Override
    public void importBackupFileResult(int n, String string) {
        this.adbDSIDefaultListener.importBackupFileResult(n, string);
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        this.adbDSIDefaultListener.resetToFactorySettingsResult(n);
    }

    @Override
    public void resetTopDestinationResult(int n) {
        this.adbDSIDefaultListener.resetTopDestinationResult(n);
    }

    @Override
    public void setLanguageResult(int n) {
        this.adbDSIDefaultListener.setLanguageResult(n);
    }

    @Override
    public void setPublicProfileVisibilityResult(int n) {
        this.adbDSIDefaultListener.setPublicProfileVisibilityResult(n);
    }

    @Override
    public void setSortOrderResult(int n) {
        this.adbDSIDefaultListener.setSortOrderResult(n);
    }

    @Override
    public void updateAdbState(int n, int n2) {
        this.adbDSIDefaultListener.updateAdbState(n, n2);
    }

    @Override
    public void updateSortOrder(int n, int n2) {
        this.adbDSIDefaultListener.updateSortOrder(n, n2);
    }

    @Override
    public void updatePictureVisibility(boolean bl, int n) {
        this.adbDSIDefaultListener.updatePictureVisibility(bl, n);
    }

    @Override
    public void setPictureVisibilityResult(int n) {
        this.adbDSIDefaultListener.setPictureVisibilityResult(n);
    }

    @Override
    public void setContextSpecificVisibilityResult(int n) {
        this.adbDSIDefaultListener.setContextSpecificVisibilityResult(n);
    }

    @Override
    public void updateContextSpecificVisibility(boolean bl, int n) {
        this.adbDSIDefaultListener.updateContextSpecificVisibility(bl, n);
    }

    @Override
    public void setProfileHandlingType(int n) {
        this.adbDSIDefaultListener.setProfileHandlingType(n);
    }

    @Override
    public void setAutoProfileAllocationResult(int n) {
        this.adbDSIDefaultListener.setAutoProfileAllocationResult(n);
    }

    @Override
    public void setDefaultPublicProfileVisibilityResult(int n) {
        this.adbDSIDefaultListener.setDefaultPublicProfileVisibilityResult(n);
    }

    @Override
    public void setMaxLocalEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxLocalEntriesResult(n);
    }

    @Override
    public void setMaxPhoneEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxPhoneEntriesResult(n);
    }

    @Override
    public void setMaxTopDestEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxTopDestEntriesResult(n);
    }

    @Override
    public void updateAutoProfileAllocation(boolean bl, int n) {
        this.adbDSIDefaultListener.updateAutoProfileAllocation(bl, n);
    }

    @Override
    public void updateDefaultPublicProfileVisibility(boolean bl, int n) {
        this.adbDSIDefaultListener.updateDefaultPublicProfileVisibility(bl, n);
    }

    @Override
    public void updateMaxLocalEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxLocalEntries(n, n2);
    }

    @Override
    public void updateMaxPhoneEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxPhoneEntries(n, n2);
    }

    @Override
    public void updateMaxTopDestEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxTopDestEntries(n, n2);
    }

    @Override
    public void setMaxSpeedDialEntriesResult(int n) {
        this.adbDSIDefaultListener.setMaxSpeedDialEntriesResult(n);
    }

    @Override
    public void updateMaxSpeedDialEntries(int n, int n2) {
        this.adbDSIDefaultListener.updateMaxSpeedDialEntries(n, n2);
    }

    @Override
    public void setSpeedDialTypeResult(int n) {
        this.adbDSIDefaultListener.setSpeedDialTypeResult(n);
    }

    @Override
    public void setNumericalSpellerEnabledResult(int n) {
        this.adbDSIDefaultListener.setNumericalSpellerEnabledResult(n);
    }

    @Override
    public void setDefaultSortOrderResult(int n) {
        this.adbDSIDefaultListener.setDefaultSortOrderResult(n);
    }

    @Override
    public void setOnlineDestinationEnabledResult(int n) {
        this.adbDSIDefaultListener.setOnlineDestinationEnabledResult(n);
    }

    @Override
    public void setDefaultSOSButtonResult(int n) {
        this.adbDSIDefaultListener.setDefaultSOSButtonResult(n);
    }

    @Override
    public void updateDefaultSOSButton(boolean bl, int n) {
        this.adbDSIDefaultListener.updateDefaultSOSButton(bl, n);
    }

    @Override
    public void importVCardResult(int n, int n2, int n3, int n4) {
        this.adbDSIDefaultListener.importVCardResult(n, n2, n3, n4);
    }

    @Override
    public void exportVCardResult(int n, int n2, int n3, int n4) {
        this.adbDSIDefaultListener.exportVCardResult(n, n2, n3, n4);
    }

    @Override
    public void exportSpellerVCardResult(int n, int n2, int n3, int n4, int n5) {
        this.adbDSIDefaultListener.exportSpellerVCardResult(n, n2, n3, n4, n5);
    }

    @Override
    public void createVCardResult(int n, long[] lArray, int n2, String string) {
        this.adbDSIDefaultListener.createVCardResult(n, lArray, n2, string);
    }

    @Override
    public void parseVCardResult(int n, AdbEntry[] adbEntryArray) {
        this.adbDSIDefaultListener.parseVCardResult(n, adbEntryArray);
    }

    @Override
    public void responseAbort(int n) {
        this.adbDSIDefaultListener.responseAbort(n);
    }

    @Override
    public void updateImportCount(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateImportCount(downloadInfo, n);
    }

    @Override
    public void updateExportCount(DownloadInfo downloadInfo, int n) {
        this.adbDSIDefaultListener.updateExportCount(downloadInfo, n);
    }
}

