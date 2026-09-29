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
        this.cmdListMgr = new CommandListManager(new StringBuffer().append(super.getClass().getName()).append("_CommandListManager").toString(), this.framework, this.cmdListLog, null, null);
        this.cmdListMgr.start();
        this.adbDSIListener = new ADBDSIListener(this.cmdListMgr, this.adbDSIDefaultListener);
        this.adbStateHandler = this.getNewADBStateHandler(this.log);
    }

    public void destroy() {
        this.log.log(1078071040, "AbstractADBHandler#destroy()");
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

    @Override
    public void setFocusedEntryId(long l) {
        this.focusedEntryId = l;
    }

    @Override
    public long getFocusedEntryId() {
        return this.focusedEntryId;
    }

    @Override
    public void setFocusedEntryType(int n) {
        this.focusedEntryType = n;
    }

    @Override
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

    @Override
    public ADBOrganizerSearch getADBOrganizerSearch() {
        return null;
    }

    @Override
    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    @Override
    public ADBDSIAccess getADBDSIAccess() {
        return this.adbDSIAccess;
    }

    @Override
    public LogChannel getLog() {
        return this.log;
    }

    @Override
    public CommandListManager getCommandListManager() {
        return this.cmdListMgr;
    }

    @Override
    public ADBDSIListener getADBDSIListener() {
        return this.adbDSIListener;
    }

    @Override
    public ADBDSIDefaultListener getADBDSIDefaultListener() {
        return this.adbDSIDefaultListener;
    }

    @Override
    public ADBStateHandler getAdbStateHandler() {
        return this.adbStateHandler;
    }

    @Override
    public int getAdbMode() {
        return 0;
    }

    @Override
    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
    }

    @Override
    public void detailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
    }

    @Override
    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n) {
    }

    @Override
    public void updateDownloadState(int n, int n2) {
    }

    @Override
    public void updateDownloadState2ndPhone(int n, int n2) {
    }

    @Override
    public void updateNewEntryAvailable(boolean bl) {
    }

    @Override
    public void updateNewPublicProfileEntryAvailable(boolean bl) {
    }

    @Override
    public void updateNewTopDestEntryAvailable(boolean bl) {
    }

    @Override
    public void updateNewPublicProfileTopDestEntryAvailable(boolean bl) {
    }

    @Override
    public void updateViewSizes(AdbViewSize adbViewSize) {
    }
}

