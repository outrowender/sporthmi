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
    default public int getInitStartupCompleteMask() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public ADBDSIAccess getADBDSIAccess() {
    }

    default public LogChannel getLog() {
    }

    default public CommandListManager getCommandListManager() {
    }

    default public ADBDSIListener getADBDSIListener() {
    }

    default public ADBDSIDefaultListener getADBDSIDefaultListener() {
    }

    default public void handleInvalidData(int n, boolean bl) {
    }

    default public ADBStateHandler getAdbStateHandler() {
    }

    default public ADBOrganizerSearch getADBOrganizerSearch() {
    }

    default public void setFocusedEntryId(long l) {
    }

    default public long getFocusedEntryId() {
    }

    default public void setFocusedEntryType(int n) {
    }

    default public int getFocusedEntryType() {
    }

    default public int getAdbMode() {
    }

    default public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
    }

    default public void detailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
    }
}

