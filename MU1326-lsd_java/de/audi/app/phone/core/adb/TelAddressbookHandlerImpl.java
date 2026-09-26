/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.AbstractADBHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.phone.core.adb.TelADBDSIDefaultListener;
import de.audi.app.phone.core.adb.TelADBHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.organizer.ProfileInfo;

class TelAddressbookHandlerImpl
extends AbstractADBHandler {
    final TelADBHandler adbComponent;

    TelAddressbookHandlerImpl(TelADBHandler telADBHandler, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, LogChannel logChannel2) {
        super(iFrameworkAccess, logChannel, logChannel2);
        this.adbComponent = telADBHandler;
    }

    @Override
    public int getInitStartupCompleteMask() {
        return 229;
    }

    @Override
    public void handleInvalidData(int n, boolean bl) {
        this.adbComponent.handleInvalidData(n, bl);
    }

    @Override
    public void setAdbReady(boolean bl) {
        this.log.log(1078071040, "[TelAddressbookHandlerImpl#setAdbReady] ready=%1", bl);
        this.adbComponent.setAdbReady(bl);
    }

    @Override
    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n) {
        this.log.log(1078071040, "[TelAddressbookHandlerImpl#updateProfileInfo] profileInfo=%1, indexOfActiveProfile=%2", (Object)Converter.array2String(profileInfoArray), (long)n);
        if (profileInfoArray != null) {
            if (n >= 0 && n < profileInfoArray.length) {
                ProfileInfo profileInfo = profileInfoArray[n];
                this.adbComponent.updateActiveProfile(profileInfo);
            } else {
                this.log.log(-1601830656, "[TelAddressbookHandlerImpl#updateProfileInfo] invalid index %1", (long)n);
            }
        } else {
            this.log.log(-1601830656, "[TelAddressbookHandlerImpl#updateProfileInfo] profileInfo is null!");
        }
    }

    @Override
    protected ADBDSIDefaultListener getNewADBDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, ADBApplication aDBApplication) {
        return new TelADBDSIDefaultListener(this, logChannel, aDBStartupHandler, aDBApplication);
    }

    void profileDeleted(int n) {
        this.log.log(1078071040, "[TelAddressbookHandlerImpl#profileDeleted] profileId=%1", (long)n);
        this.adbComponent.profileDeleted(n);
    }

    void updateSortOrder(int n, int n2) {
        this.log.log(1078071040, "[TelAddressbookHandlerImpl#updateSortOrder] sortOrder=%1, validFlag=%2", (long)n, (long)n2);
        this.adbComponent.updateSortOrder(n, n2);
    }

    @Override
    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
        this.log.log(1078071040, "TelAddressbookHandlerImpl#entrySelected(): adbSearch %1", (Object)aDBSearch);
        this.adbComponent.entrySelected(aDBSearch, aDBSearchListRow, n, n2);
    }

    @Override
    public ADBOrganizerSearch getADBOrganizerSearch() {
        return this.adbComponent.getOrganizerSearch();
    }

    @Override
    public void detailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
        this.log.log(1078071040, "TelAddressbookHandlerImpl#detailsSelected(): entryDetailsRow %1", (Object)aDBEntryDetailsListRow);
        this.adbComponent.detailsSelected(aDBEntryDetailsListRow, n, n2);
    }
}

