/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.handler.AbstractOperatorCallHandler;

public class OperatorCallFactorySettingController
implements MsgListener {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private final AbstractOperatorCallHandler operatorCallHandler;
    private final boolean isPoiCallCoded;
    private final boolean isConciergeCallCoded;

    public OperatorCallFactorySettingController(AbstractOperatorCallHandler abstractOperatorCallHandler, boolean bl, boolean bl2) {
        this.operatorCallHandler = abstractOperatorCallHandler;
        this.isPoiCallCoded = bl;
        this.isConciergeCallCoded = bl2;
    }

    @Override
    public void processMsg(int n) {
        if (n == 23) {
            this.logChannel.log(1078071040, "OperatorCallFactorySettingController#processMsg: reset to factory settings of navigation and online memory called");
            if (this.isPoiCallCoded) {
                this.operatorCallHandler.resetFactorySettings(2);
            } else {
                this.logChannel.log(-2137614336, "OperatorCallFactorySettingController#processMsg: no settings resetted");
            }
        } else if (n == 28) {
            this.logChannel.log(1078071040, "OperatorCallFactorySettingController#processMsg: reset to factory settings of telephone called");
            if (this.isConciergeCallCoded) {
                this.operatorCallHandler.resetFactorySettings(1);
            } else {
                this.logChannel.log(-2137614336, "OperatorCallFactorySettingController#processMsg: no settings resetted");
            }
        }
    }
}

