/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBStateHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;

public interface ADBApplication {
    public int getInitStartupCompleteMask();

    public IFrameworkAccess getFramework();

    public ADBDSIAccess getADBDSIAccess();

    public LogChannel getLog();

    public CommandListManager getCommandListManager();

    public ADBDSIListener getADBDSIListener();

    public ADBDSIDefaultListener getADBDSIDefaultListener();

    public void handleInvalidData(int var1, boolean var2);

    public ADBStateHandler getAdbStateHandler();

    public ADBOrganizerSearch getADBOrganizerSearch();

    public void setFocusedEntryId(long var1);

    public long getFocusedEntryId();

    public void setFocusedEntryType(int var1);

    public int getFocusedEntryType();

    public int getAdbMode();

    public void entrySelected(ADBSearch var1, ADBSearchListRow var2, int var3, int var4);

    public void detailsSelected(ADBEntryDetailsListRow var1, int var2, int var3);
}

