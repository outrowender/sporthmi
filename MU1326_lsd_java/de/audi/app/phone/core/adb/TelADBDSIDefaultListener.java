/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.app.phone.core.adb.TelAddressbookHandlerImpl;
import de.audi.atip.log.LogChannel;

class TelADBDSIDefaultListener
extends ADBDSIDefaultListener {
    final TelAddressbookHandlerImpl adbHandler;

    TelADBDSIDefaultListener(TelAddressbookHandlerImpl telAddressbookHandlerImpl, LogChannel logChannel, ADBStartupHandler aDBStartupHandler, ADBApplication aDBApplication) {
        super(logChannel, aDBStartupHandler, aDBApplication);
        this.adbHandler = telAddressbookHandlerImpl;
    }

    @Override
    public void profileDeleted(int n) {
        this.adbHandler.profileDeleted(n);
    }

    @Override
    public void updateSortOrder(int n, int n2) {
        this.adbHandler.updateSortOrder(n, n2);
    }
}

