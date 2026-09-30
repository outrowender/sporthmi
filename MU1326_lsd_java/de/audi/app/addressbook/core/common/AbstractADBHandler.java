/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.ADBStateHandler;
import de.audi.app.addressbook.core.common.ADBStateListener;
import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.ProfileInfo;

public abstract class AbstractADBHandler
implements ADBApplication,
ADBStateListener {
    protected LogChannel log;
    protected LogChannel cmdListLog;
    protected IFrameworkAccess framework;
    private ADBDSIAccess adbDSIAccess;
    private CommandListManager cmdListMgr;
    private ADBDSIListener adbDSIListener;
    private ADBDSIDefaultListener adbDSIDefaultListener;
    protected AdbEntry currentEntry;
    protected volatile long focusedEntryId = 0L;
    protected volatile int focusedEntryType;
    private ADBStateHandler adbStateHandler;

    public AbstractADBHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, LogChannel logChannel2) {
        this.framework = iFrameworkAccess;
        this.log = logChannel;
        this.cmdListLog = logChannel2;
    }

    public void init() {
        ADBStartupHandler aDBStartupHandler = new ADBStartupHandler(this.log, this);
        this.adbDSIAccess = new ADBDSIAccess(this.log, aDBStartupHandler);
        this.adbDSIDefaultListener = this.getNewADBDSIDefaultListener(this.log, aDBStartupHandler, this);
        this.cmdListMgr = new CommandListManager(this.getClass().getName() + "_CommandListManager", this.framework, this.cmdListLog, null, null);
        this.cmdListMgr.start();
        this.adbDSIListener = new ADBDSIListener(this.cmdListMgr, this.adbDSIDefaultListener);
        this.adbStateHandler = this.getNewADBStateHandler(this.log);
    }

    public void destroy() {
        this.log.log(1000000, "AbstractADBHandler#destroy()");
        this.adbDSIAccess = null;
        this.adbDSIDefaultListener = null;
        this.adbDSIListener = null;
        this.cmdListMgr.destroy();
        this.cmdListMgr = null;
    }

    public void setCurrentEntry(AdbEntry adbEntry) {
        this.currentEntry = adbEntry;
    }

    public AdbEntry getCurrentEntry() {
        return this.currentEntry;
    }

    public void setFocusedEntryId(long l) {
        this.focusedEntryId = l;
    }

    public long getFocusedEntryId() {
        return this.focusedEntryId;
    }

    public void setFocusedEntryType(int n) {
        this.focusedEntryType = n;
    }

    public int getFocusedEntryType() {
        return this.focusedEntryType;
    }

    protected ADBDSIDefaultListener getNewADBDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, ADBApplication aDBApplication) {
        return new ADBDSIDefaultListener(logChannel, aDBStartupHandler, aDBApplication);
    }

    private ADBStateHandler getNewADBStateHandler(LogChannel logChannel) {
        return new ADBStateHandler(this, logChannel);
    }

    public IHMIServiceApp getHMIService() {
        return this.framework.getHmiServiceApp();
    }

    public ADBOrganizerSearch getADBOrganizerSearch() {
        return null;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public ADBDSIAccess getADBDSIAccess() {
        return this.adbDSIAccess;
    }

    public LogChannel getLog() {
        return this.log;
    }

    public CommandListManager getCommandListManager() {
        return this.cmdListMgr;
    }

    public ADBDSIListener getADBDSIListener() {
        return this.adbDSIListener;
    }

    public ADBDSIDefaultListener getADBDSIDefaultListener() {
        return this.adbDSIDefaultListener;
    }

    public ADBStateHandler getAdbStateHandler() {
        return this.adbStateHandler;
    }

    public int getAdbMode() {
        return 0;
    }

    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
    }

    public void detailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
    }

    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n) {
    }

    public void updateDownloadState(int n, int n2) {
    }

    public void updateDownloadState2ndPhone(int n, int n2) {
    }

    public void updateNewEntryAvailable(boolean bl) {
    }

    public void updateNewPublicProfileEntryAvailable(boolean bl) {
    }

    public void updateNewTopDestEntryAvailable(boolean bl) {
    }

    public void updateNewPublicProfileTopDestEntryAvailable(boolean bl) {
    }

    public void updateViewSizes(AdbViewSize adbViewSize) {
    }
}

