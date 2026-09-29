/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.combi.bap.app.navi.list.AbstractDestinationsListAdapterFastList;
import de.audi.app.combi.bap.app.navi.list.FavoriteDestinationsListHandler;
import de.audi.app.combi.bap.dsi.fastlist.navi.DSIFastListFavoriteDestinations;
import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListFavoriteDestinations;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public final class FavoriteDestinationsListAdapterFastList
extends AbstractDestinationsListAdapterFastList {
    private final IDSIFastListFavoriteDestinations dsiFastListControllerFavoriteDestinations = new DSIFastListFavoriteDestinations();

    public FavoriteDestinationsListAdapterFastList(FavoriteDestinationsListHandler favoriteDestinationsListHandler) {
        super(favoriteDestinationsListHandler);
    }

    @Override
    public int getDSIListID() {
        return 1;
    }

    @Override
    public void setNotificationLastDestinationsList(boolean bl) {
    }

    @Override
    public void setNotificationFavoriteDestinationsList(boolean bl) {
        this.setPushListNotification(bl);
        if (bl) {
            this.sendCurrentList();
        }
    }

    @Override
    protected void pushCurrentListSize(int n) {
        this.dsiFastListControllerFavoriteDestinations.pushCurrentListSizeFavoriteDestinations(n);
    }

    @Override
    protected void pushList(DataAddress[] dataAddressArray) {
        this.dsiFastListControllerFavoriteDestinations.pushUpdateFavoriteDestinations(dataAddressArray);
    }

    @Override
    public IDSIController getDSIController() {
        return this.dsiFastListControllerFavoriteDestinations;
    }

    @Override
    public void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.dsiFastListControllerFavoriteDestinations.responseGetInitialsNavigation(n, n2, n3, dataInitialsArray);
    }
}

