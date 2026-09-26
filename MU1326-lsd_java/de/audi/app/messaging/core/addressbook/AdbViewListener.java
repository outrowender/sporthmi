/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.messaging.core.addressbook.AdbViewListener$MyBaseListModelListener;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;

final class AdbViewListener
extends AbstractMessagingComponent {
    private final IHMIServiceApp hmiService;

    AdbViewListener(MessagingBundleContext messagingBundleContext, String string) {
        super(messagingBundleContext, string);
        this.hmiService = this.framework.getHmiServiceApp();
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.hmiService.getBaseListModel(-57532160).setListener(new AdbViewListener$MyBaseListModelListener(this, null));
    }

    private boolean prepareRouteGuidance(AdbEntry adbEntry, int n) {
        this.log.log(1078071040, "[MsgADBViewListener#prepareRouteGuidance]");
        boolean bl = false;
        NaviADBService naviADBService = this.msgApp.getMessagingAdbHandler().getADBNaviService();
        if (naviADBService == null) {
            this.log.log(-1601830656, "[MsgADBViewListener#prepareRouteGuidance] ADBNaviService not available.");
        } else if (adbEntry != null) {
            byte[] byArray = adbEntry.getAddressData()[n == 2 ? 0 : 1].getNavLocation();
            String string = adbEntry.getCombinedName();
            naviADBService.setDestination(byArray, string);
            bl = true;
        } else {
            this.log.log(-1601830656, "[MsgADBViewListener#prepareRouteGuidance] adbEntry is NULL.");
        }
        return bl;
    }

    static /* synthetic */ LogChannel access$100(AdbViewListener adbViewListener) {
        return adbViewListener.log;
    }

    static /* synthetic */ AbstractMsgApplication access$200(AdbViewListener adbViewListener) {
        return adbViewListener.msgApp;
    }

    static /* synthetic */ boolean access$300(AdbViewListener adbViewListener, AdbEntry adbEntry, int n) {
        return adbViewListener.prepareRouteGuidance(adbEntry, n);
    }

    static /* synthetic */ IHMIServiceApp access$400(AdbViewListener adbViewListener) {
        return adbViewListener.hmiService;
    }
}

