/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.combi.bap.app.navi.list.AbstractDestinationsListAdapterFastList;
import de.audi.app.combi.bap.app.navi.list.LastDestinationsListHandler;
import de.audi.app.combi.bap.dsi.fastlist.navi.DSIFastListLastDestinations;
import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListLastDestinations;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public final class LastDestinationsListAdapterFastList
extends AbstractDestinationsListAdapterFastList {
    private final IDSIFastListLastDestinations dsiFastListControllerLastDestinations = new DSIFastListLastDestinations();

    public LastDestinationsListAdapterFastList(LastDestinationsListHandler lastDestinationsListHandler) {
        super(lastDestinationsListHandler);
    }

    @Override
    public int getDSIListID() {
        return 2;
    }

    @Override
    public void setNotificationLastDestinationsList(boolean bl) {
        this.setPushListNotification(bl);
        if (bl) {
            this.sendCurrentList();
        }
    }

    @Override
    public void setNotificationFavoriteDestinationsList(boolean bl) {
    }

    @Override
    protected void pushCurrentListSize(int n) {
        this.dsiFastListControllerLastDestinations.pushCurrentListSizeLastDestinations(n);
    }

    @Override
    protected void pushList(DataAddress[] dataAddressArray) {
        this.dsiFastListControllerLastDestinations.pushLastDestinations(dataAddressArray);
    }

    @Override
    public IDSIController getDSIController() {
        return this.dsiFastListControllerLastDestinations;
    }

    @Override
    public void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.dsiFastListControllerLastDestinations.responseGetInitialsNavigation(n, n2, n3, dataInitialsArray);
    }
}

