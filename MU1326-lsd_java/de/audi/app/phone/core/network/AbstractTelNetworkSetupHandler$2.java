/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.network;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import org.dsi.ifc.telephoneng.NetworkProvider;

class AbstractTelNetworkSetupHandler$2
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ AbstractTelNetworkSetupHandler this$0;

    AbstractTelNetworkSetupHandler$2(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        this.this$0 = abstractTelNetworkSetupHandler;
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n, int n2) {
        AbstractTelNetworkSetupHandler.access$900(this.this$0).log(1078071040, "[AbstractTelNetworkSetupHandler.requestNetworkSearch().new TelDefaultDSIResponseListener() {...}#responseNetworkSearch]");
        if (networkProviderArray == null || networkProviderArray.length == 0 || n != 0) {
            AbstractTelNetworkSetupHandler.access$1000(this.this$0).log(-1601830656, "[AbstractTelNetworkSetupHandler#responseNetworkSearch] Error or no network providers given, displaying TEL_SETUP_NET_STATUS2!");
            this.this$0.setUIRegMode();
            AbstractTelNetworkSetupHandler.access$400(this.this$0).setError(-1);
            return;
        }
        AbstractTelNetworkSetupHandler.access$1102(this.this$0, networkProviderArray);
        AbstractTelNetworkSetupHandler.access$1200(this.this$0);
        this.invalidateNetworkList();
        AbstractTelNetworkSetupHandler.access$400(this.this$0).setAvaible();
    }

    private void invalidateNetworkList() {
        ListModelApp listModelApp = AbstractTelNetworkSetupHandler.access$1300(this.this$0, this.this$0.modelIDNetworkSelectionList());
        listModelApp.clear();
        listModelApp.setMaxColumns(3);
        listModelApp.setMaxRows(AbstractTelNetworkSetupHandler.access$1100(this.this$0).length);
        for (int i2 = 0; i2 < AbstractTelNetworkSetupHandler.access$1100(this.this$0).length; ++i2) {
            NetworkProvider networkProvider = AbstractTelNetworkSetupHandler.access$1100(this.this$0)[i2];
            AbstractTelNetworkSetupHandler.access$1400(this.this$0).log(-1601830656, "[AbstractTelNetworkSetupHandler#processNetworkProviders] Provider: '%1'", (Object)networkProvider);
            ListCell[] listCellArray = new ListCell[]{TextListCell.create(AbstractTelNetworkSetupHandler.access$1700(this.this$0, AbstractTelNetworkSetupHandler.access$1500(this.this$0).getFrameworkAccess(), AbstractTelNetworkSetupHandler.access$1600(this.this$0).getTextFactory(), networkProvider.getTelLongProviderName())), this.createIntegerCellForTelProviderState(networkProvider.getTelProviderState()), IntegerListCell.create(i2)};
            listModelApp.addRow(listCellArray);
        }
    }

    private ListCell createIntegerCellForTelProviderState(int n) {
        return IntegerListCell.create(AbstractTelNetworkSetupHandler.access$1800().get(n));
    }

    @Override
    public void responseAbortNetworkSearch(int n, int n2) {
        AbstractTelNetworkSetupHandler.access$1900(this.this$0).log(1078071040, "[AbstractTelNetworkSetupHandler.requestNetworkSearch().new TelDefaultDSIResponseListener() {...}#responseAbortNetworkSearch] result=%1", (long)n);
        if (n == 0) {
            this.this$0.setUIRegMode();
            AbstractTelNetworkSetupHandler.access$2000(this.this$0).fireEvent(n2);
            AbstractTelNetworkSetupHandler.access$400(this.this$0).setAvaible();
            AbstractTelNetworkSetupHandler.access$2100(this.this$0).setAvaible();
        }
    }
}

