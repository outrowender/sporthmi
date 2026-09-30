/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.atip.log.LogChannel;
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

public class ADBDSIDefaultListener
implements DSIAdbListListener,
DSIAdbEditListener,
DSIAdbUserProfileListener,
DSIAdbSetupListener,
DSIAdbInitListener,
DSIAdbVCardExchangeListener {
    protected LogChannel log;
    private ADBStartupHandler adbStartupHandler;
    private ADBApplication appAdr;

    public ADBDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, ADBApplication aDBApplication) {
        this.log = logChannel;
        this.adbStartupHandler = aDBStartupHandler;
        this.appAdr = aDBApplication;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "ADBDSIDefaultListener#asyncException(): errorMsg: %1, errorCode: %2, requestType: %3", (Object)string, (long)n, (long)n2);
    }

    public void updateViewSize(AdbViewSize adbViewSize, int n) {
        this.log.log(ADBDbgUtils.getLLInfo(n), "ADBDSIDefaultListener#updateViewSize(): %1, validFlag: %2", (Object)adbViewSize, (Object)ADBDbgUtils.dbgValidFlag(n));
        if (n != 1) {
            return;
        }
        this.appAdr.getAdbStateHandler().setViewSize(adbViewSize);
    }

    public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
        this.log.log(ADBDbgUtils.getLLInfo(n), "ADBDSIDefaultListener#updateAlphabeticalIndex(): validFlag: %1", (Object)ADBDbgUtils.dbgValidFlag(n));
        if (n != 1 || this.appAdr.getADBOrganizerSearch() == null) {
            return;
        }
        this.appAdr.getADBOrganizerSearch().updateAlphabeticalIndex(indexInformationArray);
    }

    public void invalidData(int n) {
        this.appAdr.handleInvalidData(n, true);
    }

    public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.log.log(10000, "ADBDSIDefaultListener#getViewWindowResult(): no default handling for view results available.");
    }

    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.log.log(10000, "ADBDSIDefaultListener#spellerResult(): no default handling for speller results available.");
    }

    public void stopSpellerResult(int n, int n2) {
        this.log.log(10000, "ADBDSIDefaultListener#stopSpellerResult(): no default handling for stop speller results available.");
    }

    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        this.log.log(10000, "ADBDSIDefaultListener#validateSpellerCharsResult(): no default handling for validate speller chars results available.");
    }

    public void getSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        this.log.log(10000, "ADBDSIDefaultListener#getSpellerViewWindowResult(): no default handling for getSpellerViewWindowResults available.");
    }

    public void setListStyleResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setListStyleResult(): no default handling for setListStyleResults available.");
    }

    public void getValidHanziCharsWindowResult(int n, int n2, int n3, String string, int n4) {
        this.log.log(10000, "ADBDSIDefaultListener#getValidHanziCharsWindowResult(): no default handling for getValidHanziCharsWindowResults available.");
    }

    public void updateNewEntryAvailable(boolean bl, int n) {
        this.log.log(ADBDbgUtils.getLLDbg(n), "ADBDSIDefaultListener#updateNewEntryAvailable(): newEntryAvailable: %1, validFlag: %2", bl, (Object)ADBDbgUtils.dbgValidFlag(n));
        if (n == 1) {
            this.appAdr.getAdbStateHandler().setNewEntryAvailable(bl);
        }
    }

    public void updateNewPublicProfileEntryAvailable(boolean bl, int n) {
        this.log.log(ADBDbgUtils.getLLDbg(n), "ADBDSIDefaultListener#updateNewPublicProfileEntryAvailable(): newPublicProfileEntryAvailable: %1, validFlag: %2", bl, (Object)ADBDbgUtils.dbgValidFlag(n));
        if (n == 1) {
            this.appAdr.getAdbStateHandler().setNewPublicProfileEntryAvailable(bl);
        }
    }

    public void updateNewTopDestinationEntryAvailable(boolean bl, int n) {
        this.log.log(ADBDbgUtils.getLLDbg(n), "ADBDSIDefaultListener#updateNewTopDestinationEntryAvailable(): newTopDestinationEntryAvailable: %1, validFlag: %2", bl, (Object)ADBDbgUtils.dbgValidFlag(n));
        if (n == 1) {
            this.appAdr.getAdbStateHandler().setNewTopDestEntryAvailable(bl);
        }
    }

    public void updateNewPublicProfileTopDestEntryAvailable(boolean bl, int n) {
        this.log.log(ADBDbgUtils.getLLDbg(n), "ADBDSIDefaultListener#updateNewPublicProfileTopDestEntryAvailable(): newPublicProfileTopDestEntryAvailable: %1, validFlag: %2", bl, (Object)ADBDbgUtils.dbgValidFlag(n));
        if (n == 1) {
            this.appAdr.getAdbStateHandler().setNewPublicProfileTopDestEntryAvailable(bl);
        }
    }

    public void updateNewOnlineDestinationEntryAvailable(boolean bl, int n) {
    }

    public void changeEntryResult(int n, AdbEntry adbEntry) {
        this.log.log(10000, "ADBDSIDefaultListener#changeEntryResult(): no default handling for change entry results available.");
    }

    public void copyEntryResult(int n, AdbEntry adbEntry) {
        this.log.log(10000, "ADBDSIDefaultListener#copyEntryResult(): no default handling for copy entry results available.");
    }

    public void deleteEntriesResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#deleteEntriesResult(): no default handling for delete entry results available.");
    }

    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.log.log(10000, "ADBDSIDefaultListener#getEntriesResult(): no default handling for get entries results available.");
    }

    public void insertEntryResult(int n, AdbEntry adbEntry) {
        this.log.log(10000, "ADBDSIDefaultListener#insertEntryResult(): no default handling for insert entry results available.");
    }

    public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
        this.log.log(10000, "ADBDSIDefaultListener#getEntryDataSetsResult(): no default handling for get entry datasets results available.");
    }

    public void setSpeedDialResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setSpeedDialResult(): no default handling for set speed dial results availble.");
    }

    public void deleteSpeedDialResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#deleteSpeedDialResult(): no default handling for delete speed dial results available.");
    }

    public void getEntryByReferenceIdResult(int n, AdbEntry adbEntry) {
        this.log.log(10000, "ADBDSIDefaultListener#getEntryByReferenceIdResult(): no default handling for get entry by reference id results available.");
    }

    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) {
        this.log.log(ADBDbgUtils.getLLDbg(n2), "ADBDSIDefaultListener#updateProfileInfo(): profileInfo: %1, indexOfActiveProfile: %2, validFlag: %3", (Object)ADBDbgUtils.dbg(profileInfoArray), (Object)String.valueOf(n), (Object)ADBDbgUtils.dbgValidFlag(n2));
        if (n2 != 1) {
            return;
        }
        this.log.log(1000000, "ADBDSIDefaultListener#updateProfileInfo(): %1", (Object)ADBDbgUtils.dbg(profileInfoArray, n));
        this.appAdr.getAdbStateHandler().setProfileInfo(profileInfoArray, n);
        this.adbStartupHandler.updateStartupState(4);
    }

    public void updateDownloadState(int n, int n2, int n3) {
        this.log.log(ADBDbgUtils.getLLDbg(n3), "ADBDSIDefaultListener#updateDownloadState(): downloadState: %1, failureReason: %2, validFlag: %3", (Object)ADBDbgUtils.dbgDownloadState(n), (Object)ADBDbgUtils.dbgFailureReason(n2), (Object)ADBDbgUtils.dbgValidFlag(n3));
        if (n3 != 1) {
            return;
        }
        this.appAdr.getAdbStateHandler().setDownloadState(n, n2);
    }

    public void updateDownloadState2ndPhone(int n, int n2, int n3) {
        this.log.log(ADBDbgUtils.getLLDbg(n3), "ADBDSIDefaultListener#updateDownloadState2ndPhone(): downloadState2ndPhone: %1, failureReason: %2, validFlag: %3", (Object)ADBDbgUtils.dbgDownloadState(n), (Object)ADBDbgUtils.dbgFailureReason(n2), (Object)ADBDbgUtils.dbgValidFlag(n3));
        if (n3 != 1) {
            return;
        }
        this.appAdr.getAdbStateHandler().setDownloadState2ndPhone(n, n2);
    }

    public void newDeviceConnected(String string) {
    }

    public void updateDeviceConnected(boolean bl, int n) {
    }

    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
    }

    public void updateDownloadCountOpp(DownloadInfo downloadInfo, int n) {
    }

    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
    }

    public void profileDeleted(int n) {
    }

    public void commonEntryCountResult(int n, int n2) {
        this.log.log(10000, "ADBDSIDefaultListener#commonEntryCountResult(): no default handling for commonEntryCountResult available.");
    }

    public void deleteProfilesResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#deleteProfilesResult(): no default handling for deleteProfilesResult available.");
    }

    public void downloadToProfileResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#downloadToProfileResult(): no default handling for downloadToProfileResult available.");
    }

    public void entryMeterResult(int n, EntryMeter[] entryMeterArray) {
        this.log.log(10000, "ADBDSIDefaultListener#entryMeterResult(): no default handling for entryMeterResult available.");
    }

    public void restartDownloadResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#restartDownloadResult(): no default handling for restartDownloadResult available.");
    }

    public void setHomeIdResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setHomeIdResult(): no default handling for setHomeIdResult available.");
    }

    public void setPairingCodeResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setPairingCodeResult(): no default handling for setPairingCodeResult available.");
    }

    public void setProfileNameResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setProfileNameResult(): no default handling for setProfileNameResult available.");
    }

    public void setSOSButtonResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setSOSButtonResult(): no default handling for setSOSButtonResult available.");
    }

    public void updateSOSButton(boolean bl, int n) {
    }

    public void updateAdbState(int n, int n2) {
        this.log.log(ADBDbgUtils.getLLDbg(n2), "ADBDSIDefaultListener#updateAdbState(): %1, %2", (Object)ADBDbgUtils.dbgAdbState(n), (Object)ADBDbgUtils.dbgValidFlag(n2));
        if (n2 == 1) {
            if (n == 1) {
                this.adbStartupHandler.updateStartupState(16);
            } else if (n == 2) {
                this.adbStartupHandler.updateStartupState(32);
            } else {
                this.log.log(10000, "ADBDSIDefaultListener#updateAdbState(): received unhandled/unknown adbState: %1", (Object)ADBDbgUtils.dbgAdbState(n));
            }
        }
    }

    public void updateSortOrder(int n, int n2) {
    }

    public void updateContextSpecificVisibility(boolean bl, int n) {
    }

    public void updatePictureVisibility(boolean bl, int n) {
    }

    public void createBackupFileResult(int n, String string) {
        this.log.log(10000, "ADBDSIDefaultListener#createBackupFileResult(): no default handling for createBackupFileResult available.");
    }

    public void importBackupFileResult(int n, String string) {
        this.log.log(10000, "ADBDSIDefaultListener#importBackupFileResult(): no default handling for importBackupFileResult available.");
    }

    public void resetToFactorySettingsResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#resetToFactorySettingsResult(): no default handling for resetToFactorySettingsResult available.");
    }

    public void resetTopDestinationResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#resetTopDestinationResult(): no default handling for resetTopDestinationResult available.");
    }

    public void setLanguageResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setLanguageResult(): no default handling for setLanguageResult available.");
    }

    public void setPublicProfileVisibilityResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setPublicProfileVisibilityResult(): no default handling for setPublicProfileVisibilityResult available.");
    }

    public void setSortOrderResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setSortOrderResult(): no default handling for setSortOrderResult available.");
    }

    public void setPictureVisibilityResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setPictureVisibilityResult(): no default handling for setPictureVisibilityResult available.");
    }

    public void setContextSpecificVisibilityResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setContextSpecificVisibilityResult(): no default handling for setContextSpecificVisibilityResult available.");
    }

    public void updateAutoProfileAllocation(boolean bl, int n) {
    }

    public void setProfileHandlingType(int n) {
    }

    public void updateDefaultPublicProfileVisibility(boolean bl, int n) {
    }

    public void updateMaxLocalEntries(int n, int n2) {
    }

    public void updateMaxPhoneEntries(int n, int n2) {
    }

    public void updateMaxTopDestEntries(int n, int n2) {
    }

    public void setAutoProfileAllocationResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setAutoProfileAllocationResult(): no default handling for setAutoProfileAllocationResult available.");
    }

    public void setDefaultPublicProfileVisibilityResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setDefaultPublicProfileVisibilityResult(): no default handling for setDefaultPublicProfileVisibilityResult available.");
    }

    public void setMaxLocalEntriesResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setMaxLocalEntriesResult(): no default handling for setMaxLocalEntriesResult available.");
    }

    public void setMaxPhoneEntriesResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setMaxPhoneEntriesResult(): no default handling for setMaxPhoneEntriesResult available.");
    }

    public void setMaxTopDestEntriesResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setMaxTopDestEntriesResult(): no default handling for setMaxTopDestEntriesResult available.");
    }

    public void setDefaultSortOrderResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setDefaultSortOrderResult(): no default handling for setDefaultSortOrderResult available.");
    }

    public void setMaxSpeedDialEntriesResult(int n) {
    }

    public void updateMaxSpeedDialEntries(int n, int n2) {
    }

    public void setSpeedDialTypeResult(int n) {
    }

    public void setNumericalSpellerEnabledResult(int n) {
    }

    public void setOnlineDestinationEnabledResult(int n) {
    }

    public void setDefaultSOSButtonResult(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#setDefaultSOSButtonResult(): no default handling for setDefaultSOSButtonResult available.");
    }

    public void updateDefaultSOSButton(boolean bl, int n) {
    }

    public void importVCardResult(int n, int n2, int n3, int n4) {
        this.log.log(10000, "ADBDSIDefaultListener#importVCardResult(): no default handling available for importVCardResults!");
    }

    public void exportVCardResult(int n, int n2, int n3, int n4) {
        this.log.log(10000, "ADBDSIDefaultListener#exportVCardResult(): no default handling available for exportVCardResults!");
    }

    public void exportSpellerVCardResult(int n, int n2, int n3, int n4, int n5) {
        this.log.log(10000, "ADBDSIDefaultListener#exportSpellerVCardResult(): no default handling available for exportSpellerVCardResults!");
    }

    public void createVCardResult(int n, long[] lArray, int n2, String string) {
        this.log.log(10000, "ADBDSIDefaultListener#createVCardResult(): no default handling available for createVCardResults!");
    }

    public void parseVCardResult(int n, AdbEntry[] adbEntryArray) {
        this.log.log(10000, "ADBDSIDefaultListener#parseVCardResult(): no default handling available for parseVCardResults!");
    }

    public void responseAbort(int n) {
        this.log.log(10000, "ADBDSIDefaultListener#responseAbort(): no default handling available for responseAbort!");
    }

    public void updateImportCount(DownloadInfo downloadInfo, int n) {
    }

    public void updateExportCount(DownloadInfo downloadInfo, int n) {
    }
}

