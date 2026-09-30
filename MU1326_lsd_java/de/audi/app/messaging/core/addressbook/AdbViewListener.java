/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.messaging.core.addressbook.NavigationLocationListRow;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviADBService;
import org.dsi.ifc.organizer.AdbEntry;

final class AdbViewListener
extends AbstractMessagingComponent {
    private final IHMIServiceApp hmiService;

    AdbViewListener(MessagingBundleContext messagingBundleContext, String string) {
        super(messagingBundleContext, string);
        this.hmiService = this.framework.getHmiServiceApp();
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.hmiService.getBaseListModel(2200316).setListener(new MyBaseListModelListener());
    }

    private boolean prepareRouteGuidance(AdbEntry adbEntry, int n) {
        this.log.log(1000000, "[MsgADBViewListener#prepareRouteGuidance]");
        boolean bl = false;
        NaviADBService naviADBService = this.msgApp.getMessagingAdbHandler().getADBNaviService();
        if (naviADBService == null) {
            this.log.log(100000, "[MsgADBViewListener#prepareRouteGuidance] ADBNaviService not available.");
        } else if (adbEntry != null) {
            byte[] byArray = adbEntry.getAddressData()[n == 2 ? 0 : 1].getNavLocation();
            String string = adbEntry.getCombinedName();
            naviADBService.setDestination(byArray, string);
            bl = true;
        } else {
            this.log.log(100000, "[MsgADBViewListener#prepareRouteGuidance] adbEntry is NULL.");
        }
        return bl;
    }

    private class MyBaseListModelListener
    extends DefaultBaseListModelListener {
        private MyBaseListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            AdbViewListener.this.log.log(1000000, "MsgADBViewListener#itemSelected(): modelID = %1", (long)n);
            AdbEntry adbEntry = AdbViewListener.this.msgApp.getMessageOptionsManager().getAdbEntry();
            boolean bl = AdbViewListener.this.prepareRouteGuidance(adbEntry, ((NavigationLocationListRow)evoListRow).getType());
            if (bl) {
                AdbViewListener.this.hmiService.getModelApp(n).fireEvent(n4);
            }
        }
    }
}

