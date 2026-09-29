/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbEditListener;
import org.dsi.ifc.organizer.DSIAdbInit;
import org.dsi.ifc.organizer.DSIAdbInitListener;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbSetupListener;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;

public class ADBDSIAccess {
    private LogChannel log;
    private ADBStartupHandler adbStartupHandler;
    private DSIAdbList dsiAdbList;
    private DSIAdbEdit dsiAdbEdit;
    private DSIAdbUserProfile dsiAdbUserProfile;
    private DSIAdbSetup dsiAdbSetup;
    private DSIAdbInit dsiAdbInit;
    private DSIAdbVCardExchange dsiAdbVCardExchange;

    public ADBDSIAccess(LogChannel logChannel, ADBStartupHandler aDBStartupHandler) {
        this.log = logChannel;
        this.adbStartupHandler = aDBStartupHandler;
    }

    public void setDSIAdbList(DSIAdbList dSIAdbList, DSIAdbListListener dSIAdbListListener) {
        this.log.log(-2137614336, "ADBDSIAccess#setDSIAdbList(): got dsiAdbList: %1", (Object)dSIAdbList);
        this.dsiAdbList = dSIAdbList;
        try {
            dSIAdbList.setNotification(dSIAdbListListener);
        }
        catch (Exception exception) {
            this.log.log(10000, "ADBDSIAccess#setDSIAdbList(): Exception occured: %1", (Throwable)exception);
        }
        this.adbStartupHandler.updateStartupState(1);
    }

    public void clearDSIAdbList(DSIAdbListListener dSIAdbListListener) {
        this.log.log(-2137614336, "ADBDSIAccess#clearDSIAdbList()");
        if (this.dsiAdbList != null) {
            this.dsiAdbList.clearNotification(dSIAdbListListener);
            this.dsiAdbList = null;
        }
    }

    public void setDSIAdbEdit(DSIAdbEdit dSIAdbEdit, DSIAdbEditListener dSIAdbEditListener) {
        this.log.log(-2137614336, "ADBDSIAccess#setDSIAdbEdit(): got dsiAdbEdit: %1", (Object)dSIAdbEdit);
        this.dsiAdbEdit = dSIAdbEdit;
        try {
            dSIAdbEdit.setNotification(dSIAdbEditListener);
        }
        catch (Exception exception) {
            this.log.log(10000, "ADBDSIAccess#setDSIAdbEdit(): Exception occured: %1", (Throwable)exception);
        }
        this.adbStartupHandler.updateStartupState(64);
    }

    public void clearDSIAdbEdit(DSIAdbEditListener dSIAdbEditListener) {
        this.log.log(-2137614336, "ADBDSIAccess#clearDSIAdbEdit()");
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.clearNotification(dSIAdbEditListener);
            this.dsiAdbEdit = null;
        }
    }

    public void setDSIAdbUserProfile(DSIAdbUserProfile dSIAdbUserProfile, DSIAdbUserProfileListener dSIAdbUserProfileListener) {
        this.log.log(-2137614336, "ADBDSIAccess#setDSIAdbUserProfile(): got dsiAdbUserProfile: %1", (Object)dSIAdbUserProfile);
        this.dsiAdbUserProfile = dSIAdbUserProfile;
        try {
            dSIAdbUserProfile.setNotification(dSIAdbUserProfileListener);
        }
        catch (Exception exception) {
            this.log.log(10000, "ADBDSIAccess#setDSIAdbUserProfile(): Exception occured: %1", (Throwable)exception);
        }
    }

    public void clearDSIAdbUserProfile(DSIAdbUserProfileListener dSIAdbUserProfileListener) {
        this.log.log(-2137614336, "ADBDSIAccess#clearDSIAdbUserProfile()");
        if (this.dsiAdbUserProfile != null) {
            this.dsiAdbUserProfile.clearNotification(dSIAdbUserProfileListener);
            this.dsiAdbUserProfile = null;
        }
    }

    public void setDSIAdbSetup(DSIAdbSetup dSIAdbSetup, DSIAdbSetupListener dSIAdbSetupListener) {
        this.log.log(-2137614336, "ADBDSIAccess#setDSIAdbSetup(): got dsiAdbSetup: %1", (Object)dSIAdbSetup);
        this.dsiAdbSetup = dSIAdbSetup;
        try {
            dSIAdbSetup.setNotification(dSIAdbSetupListener);
        }
        catch (Exception exception) {
            this.log.log(10000, "ADBDSIAccess#setDSIAdbSetup(): Exception occured: %1", (Throwable)exception);
        }
        this.adbStartupHandler.updateStartupState(128);
    }

    public void clearDSIAdbSetup(DSIAdbSetupListener dSIAdbSetupListener) {
        this.log.log(-2137614336, "ADBDSIAccess#clearDSIAdbSetup()");
        if (this.dsiAdbSetup != null) {
            this.dsiAdbSetup.clearNotification(dSIAdbSetupListener);
            this.dsiAdbSetup = null;
        }
    }

    public void setDSIAdbInit(DSIAdbInit dSIAdbInit, DSIAdbInitListener dSIAdbInitListener) {
        this.log.log(-2137614336, "ADBDSIAccess#setDSIAdbInit(): got dsiAdbInit: %1", (Object)dSIAdbInit);
        this.dsiAdbInit = dSIAdbInit;
        try {
            dSIAdbInit.setNotification(dSIAdbInitListener);
        }
        catch (Exception exception) {
            this.log.log(10000, "ADBDSIAccess#setDSIAdbInit(): Exception occured: %1", (Throwable)exception);
        }
        this.adbStartupHandler.updateStartupState(8);
    }

    public void clearDSIAdbInit(DSIAdbInitListener dSIAdbInitListener) {
        this.log.log(-2137614336, "ADBDSIAccess#clearDSIAdbInit()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.clearNotification(dSIAdbInitListener);
            this.dsiAdbInit = null;
        }
    }

    public void setDSIAdbVCardExchange(DSIAdbVCardExchange dSIAdbVCardExchange, DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener) {
        this.log.log(-2137614336, "ADBDSIAccess#setDSIAdbVCardExchange(): got dsiAdbVCardExchange: %1", (Object)dSIAdbVCardExchange);
        this.dsiAdbVCardExchange = dSIAdbVCardExchange;
        try {
            dSIAdbVCardExchange.setNotification(dSIAdbVCardExchangeListener);
        }
        catch (Exception exception) {
            this.log.log(10000, "ADBDSIAccess#setDSIAdbVCardExchange(): Exception occured: %1", (Throwable)exception);
        }
        this.adbStartupHandler.updateStartupState(256);
    }

    public void clearDSIAdbVCardExchange(DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener) {
        this.log.log(-2137614336, "ADBDSIAccess#clearDSIAdbVCardExchange()");
        if (this.dsiAdbVCardExchange != null) {
            this.dsiAdbVCardExchange.clearNotification(dSIAdbVCardExchangeListener);
            this.dsiAdbVCardExchange = null;
        }
    }

    public boolean getViewWindow(long l, int n, int n2, int n3) {
        Buffer buffer = new Buffer("entryId: ").append(l).append(", movement: ").append(ADBDbgUtils.dbgMovement(n)).append(", viewType: ").append(ADBDbgUtils.dbgViewType(n2)).append(", windowSize: ").append(n3);
        this.log.log(-2137614336, "ADBDSIAccess#getViewWindow(): %1", (Object)buffer);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.getViewWindow(l, n, n2, n3);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#getViewWindow(): dsiADBList is null!");
        return false;
    }

    public boolean getSpellerViewWindow(int n, long l, int n2, int n3, int n4) {
        Buffer buffer = new Buffer("spellerhandle: ").append(n).append(", entryId: ").append(l).append(", movement: ").append(ADBDbgUtils.dbgMovement(n2)).append(", viewType: ").append(ADBDbgUtils.dbgViewType(n3)).append(", windowSize: ").append(n4);
        this.log.log(-2137614336, "ADBDSIAccess#getSpellerViewWindow(): %1", (Object)buffer);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.getSpellerViewWindow(n, l, n2, n3, n4);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#getSpellerViewWindow(): dsiAdbList is null!");
        return false;
    }

    public boolean startSpeller(int n, int n2, int n3) {
        this.log.log(-2137614336, "ADBDSIAccess#startSpeller(): viewType: %1, listSize: %2, searchMode: %3", (long)n, (long)n2, (long)n3);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.startSpeller(n, n2, n3);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#startSpeller(): dsiAdbList is null!");
        return false;
    }

    public boolean stopSpeller(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#stopSpeller(): spellerHandle: %1", (long)n);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.stopSpeller(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#stopSpeller(): disAdbList is null!");
        return false;
    }

    public boolean addSpellerChars(int n, String string) {
        this.log.log(-2137614336, "ADBDSIAccess#addSpellerChars(): spellerHandle: %2, characters: %1", (Object)string, (long)n);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.addSpellerChars(n, string);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#addSpellerChars(): disAdbList is null!");
        return false;
    }

    public boolean removeSpellerChar(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#removeSpellerChar(): spellerHandle: %1", (long)n);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.removeSpellerChar(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#removeSpellerChar(): dsiAdbList is null!");
        return false;
    }

    public boolean validateSpellerChars(int n, String string) {
        this.log.log(-2137614336, "ADBDSIAccess#validateSpellerChars(): spellerHandle: %2, charactes: %1", (Object)string, (long)n);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.validateSpellerChars(n, string);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#validateSpellerChars(): dsiAdbList is null!");
        return false;
    }

    public boolean setListStyle(int n, int n2, int n3) {
        this.log.log(-2137614336, "ADBDSIAccess#setListStyle(): filter: %1, line1: %2, line2: %3", (long)n, (long)n2, (long)n3);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.setListStyle(n, n2, n3);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setListStyle(): dsiAdbList is null!");
        return false;
    }

    public boolean addSpellerStroke(int n, String string) {
        this.log.log(-2137614336, "ADBDSIAccess#addSpellerStroke(): spellerHandle: %2, stroke: %1", (Object)string, (long)n);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.addSpellerStroke(n, string);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#addSpellerStroke(): dsiAdbList is null!");
        return false;
    }

    public boolean getValidHanziCharsWindow(int n, int n2, int n3) {
        this.log.log(-2137614336, "ADBDSIAccess#getValidHanziCharsWindow(): spellerHandle: %1, offset: %2, windowSize: %3", (long)n, (long)n2, (long)n3);
        if (this.dsiAdbList != null) {
            this.dsiAdbList.getValidHanziCharsWindow(n, n2, n3);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#getValidHanziCharsWindow(): dsiAdbList is null!");
        return false;
    }

    public boolean getEntries(long[] lArray, int n, int n2) {
        this.log.log(-2137614336, "ADBDSIAccess#getEntries(): entryIdList: %1, viewType: %2, listMode: %3", (Object)ADBDbgUtils.dbg(lArray), (long)n, (long)n2);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.getEntries(lArray, n, n2);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#getEntries(): dsiAdbEdit is null!");
        return false;
    }

    public boolean deleteEntries(long[] lArray, int n, int n2) {
        this.log.log(-2137614336, "ADBDSIAccess#deleteEntries(): entryIdList: %1, viewType: %2, listMode: %3", (Object)ADBDbgUtils.dbg(lArray), (long)n, (long)n2);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.deleteEntries(lArray, n, n2);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#deleteEntries(): dsiAdbEdit is null!");
        return false;
    }

    public boolean insertEntry(AdbEntry adbEntry, int n) {
        this.log.log(-2137614336, "ADBDSIAccess#insertEntry(): entry: %1, profileNum: %2", (Object)adbEntry, (long)n);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.insertEntry(adbEntry, n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#insertEntry(): dsiAdbEdit is null!");
        return false;
    }

    public boolean changeEntry(AdbEntry adbEntry, int n) {
        this.log.log(-2137614336, "ADBDSIAccess#changeEntry(): entry: %1, profileNum: %2", (Object)adbEntry, (long)n);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.changeEntry(adbEntry, n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#changeEntry(): dsiAdbEdit is null!");
        return false;
    }

    public boolean getEntryDataSets(long[] lArray, int n, int n2) {
        this.log.log(-2137614336, "ADBDSIAccess#getEntryDataSets(): entryIdList: %1, viewType: %2, listMode: %3", (Object)lArray, (long)n, (long)n2);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.getEntryDataSets(lArray, n, n2);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#getEntryDataSets(): disAdbEdit is null!");
        return false;
    }

    public boolean getEntryByReferenceId(String string) {
        this.log.log(-2137614336, "ADBDSIAccess#getEntryByReferenceId(): referenceId: %1", (Object)string);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.getEntryByReferenceId(string);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#getEntryByReferenceId(): dsiAdbEdit is null!");
        return false;
    }

    public boolean deleteSpeedDial(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#deleteSpeedDial(): speedDialKey: %1", (long)n);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.deleteSpeedDial(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#deleteSpeedDial(): dsiAdbEdit is null!");
        return false;
    }

    public boolean setSpeedDial(AdbEntry adbEntry) {
        this.log.log(-2137614336, "ADBDSIAccess#setSpeedDial(): speedDialEntry: %1", (Object)adbEntry);
        if (this.dsiAdbEdit != null) {
            this.dsiAdbEdit.setSpeedDial(adbEntry);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setSpeedDial(): dsiAdbEdit is null!");
        return false;
    }

    public boolean restartDownload() {
        this.log.log(-2137614336, "ADBDSIAccess#restartDownload()");
        if (this.dsiAdbUserProfile != null) {
            this.dsiAdbUserProfile.restartDownload();
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#restartDownload(): dsiAdbUserProfile is null!");
        return false;
    }

    public boolean entryMeter() {
        this.log.log(-2137614336, "ADBDSIAccess#entryMeter()");
        if (this.dsiAdbUserProfile != null) {
            this.dsiAdbUserProfile.entryMeter();
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#entryMeter(): dsiAdbUserProfile is null!");
        return false;
    }

    public boolean deleteProfiles(int[] nArray) {
        this.log.log(-2137614336, "ADBDSIAccess#deleteProfiles(): profileNums: %1", (Object)nArray);
        if (this.dsiAdbUserProfile != null) {
            this.dsiAdbUserProfile.deleteProfiles(nArray);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#deleteProfiles(): dsiAdbUserProfile is null!");
        return false;
    }

    public boolean setHomeId(long l) {
        this.log.log(-2137614336, "ADBDSIAccess#setHomeId(): entryId: %1", l);
        if (this.dsiAdbUserProfile != null) {
            this.dsiAdbUserProfile.setHomeId(l);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setHomeId(): dsiAdbUserProfile is null!");
        return false;
    }

    public boolean setSortOrder(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#setSortOrder(): sortOrder: %1", (long)n);
        if (this.dsiAdbSetup != null) {
            this.dsiAdbSetup.setSortOrder(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setSortOrder(): dsiAdbSetup is null!");
        return false;
    }

    public boolean setLanguage(String string) {
        this.log.log(-2137614336, "ADBDSIAccess#setLanguage()");
        if (this.dsiAdbSetup != null) {
            this.dsiAdbSetup.setLanguage(string);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setLanguage(): dsiAdbSetup is null!");
        return false;
    }

    public boolean resetToFactorySettings() {
        this.log.log(-2137614336, "ADBDSIAccess#resetToFactorySettings()");
        if (this.dsiAdbSetup != null) {
            this.dsiAdbSetup.resetToFactorySettings();
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#resetToFactorySettings(): dsiAdbSetup is null!");
        return false;
    }

    public boolean resetTopDestination() {
        this.log.log(-2137614336, "ADBDSIAccess#resetTopDestination()");
        if (this.dsiAdbSetup != null) {
            this.dsiAdbSetup.resetTopDestination();
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#resetTopDestination(): dsiAdbSetup is null!");
        return false;
    }

    public boolean setPublicProfileVisibility(boolean bl) {
        this.log.log(-2137614336, "ADBDSIAccess#setPublicProfileVisibility()");
        if (this.dsiAdbSetup != null) {
            this.dsiAdbSetup.setPublicProfileVisibility(bl);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setPublicProfileVisibility(): dsiAdbSetup is null!");
        return false;
    }

    public boolean setContextSpecificVisibility(boolean bl) {
        this.log.log(-2137614336, "ADBDSIAccess#setContextSpecificVisibility()");
        if (this.dsiAdbSetup != null) {
            this.dsiAdbSetup.setContextSpecificVisibility(bl);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setContextSpecificVisibility(): dsiAdbSetup is null!");
        return false;
    }

    public boolean setAutoProfileAllocation(boolean bl) {
        this.log.log(-2137614336, "ADBDSIAccess#setAutoProfileAllocation()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.setAutoProfileAllocation(bl);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setAutoProfileAllocation(): dsiAdbInit is null!");
        return false;
    }

    public boolean setDefaultPublicProfileVisibility(boolean bl) {
        this.log.log(-2137614336, "ADBDSIAccess#setDefaultPublicProfileVisibility( %1 )", bl);
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.setDefaultPublicProfileVisibility(bl);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setDefaultPublicProfileVisibility(): dsiAdbInit is null!");
        return false;
    }

    public boolean setDefaultSortOrder(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#setDefaultSortOrder()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.setDefaultSortOrder(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setDefaultSortOrder(): dsiAdbInit is null!");
        return false;
    }

    public boolean setMaxPhoneEntries(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#setMaxPhoneEntries()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.setMaxPhoneEntries(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setMaxPhoneEntries(): dsiAdbInit is null!");
        return false;
    }

    public boolean setMaxLocalEntries(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#setMaxLocalEntries()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.setMaxLocalEntries(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setMaxLocalEntries(): dsiAdbInit is null!");
        return false;
    }

    public boolean finalizeConfiguration() {
        this.log.log(-2137614336, "ADBDSIAccess#finalizeConfiguration()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.finalizeConfiguration();
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#finalizeConfiguration(): dsiAdbInit is null!");
        return false;
    }

    public boolean setSpeedDialType(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#setSpeedDialType()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.setSpeedDialType(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setSpeedDialType(): dsiAdbInit is null!");
        return false;
    }

    public boolean setMaxSpeedDialEntries(int n) {
        this.log.log(-2137614336, "ADBDSIAccess#setMaxSpeedDialEntries()");
        if (this.dsiAdbInit != null) {
            this.dsiAdbInit.setMaxSpeedDialEntries(n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#setMaxSpeedDialEntries(): dsiAdbInit is null!");
        return false;
    }

    public boolean exportVCard(int n, String string, long[] lArray, int n2) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer("sourceView: ").append(ADBDbgUtils.dbgViewType(n)).append(", destMountPoint: ").append(string).append(", entryIdList: ").append(ADBDbgUtils.dbg(lArray)).append(", listMode: ").append(n2);
            this.log.log(1078071040, "ADBDSIAccess#exportVCard(): %1", (Object)buffer);
        }
        if (this.dsiAdbVCardExchange != null) {
            this.dsiAdbVCardExchange.exportVCard(n, string, lArray, n2);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#exportVCard(): dsiAdbVCardExchange is null!");
        return false;
    }

    public boolean exportSpellerVCard(int n, int n2, String string, long[] lArray, int n3) {
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer("spellerHandle: ").append(n).append(", sourceView: ").append(ADBDbgUtils.dbgViewType(n2)).append(", destMountPoint: ").append(string).append(", entryIdList: ").append(ADBDbgUtils.dbg(lArray)).append(", listMode: ").append(n3);
            this.log.log(-2137614336, "ADBDSIAccess#exportSpellerVCard(): %1", (Object)buffer);
        }
        if (this.dsiAdbVCardExchange != null) {
            this.dsiAdbVCardExchange.exportSpellerVCard(n, n2, string, lArray, n3);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#exportSpellerVCard(): dsiAdbVCardExchange is null!");
        return false;
    }

    public boolean importVCard(ResourceLocator[] resourceLocatorArray, int n) {
        this.log.log(-2137614336, "ADBDSIAccess#importVCard(): resourceLocators: %1, destinationProfile: %2", (Object)resourceLocatorArray, (long)n);
        if (this.dsiAdbVCardExchange != null) {
            this.dsiAdbVCardExchange.importVCard(resourceLocatorArray, n);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#importVCard(): dsiAdbVCardExchange is null!");
        return false;
    }

    public boolean createVCard(int n, long[] lArray, int n2) {
        this.log.log(-2137614336, "ADBDSIAccess#createVCard(): sourceView: %2, entryIdList: %1, listMode: %3", (Object)lArray, (long)n, (long)n2);
        if (this.dsiAdbVCardExchange != null) {
            this.dsiAdbVCardExchange.createVCard(n, lArray, n2);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#createVCard(): dsiAdbVCardExchange is null!");
        return false;
    }

    public boolean parseVCard(String string) {
        this.log.log(-2137614336, "ADBDSIAccess#parseVCard(): fullPathToVCards: %1", (Object)string);
        if (this.dsiAdbVCardExchange != null) {
            this.dsiAdbVCardExchange.parseVCard(string);
            return true;
        }
        this.log.log(10000, "ADBDSIAccess#parseVCard(): dsiAdbVCardExchange is null!");
        return false;
    }
}

