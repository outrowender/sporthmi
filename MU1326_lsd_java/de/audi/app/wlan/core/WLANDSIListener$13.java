/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.Node;

class WLANDSIListener$13
extends CommandResponse {
    private final /* synthetic */ Node[] val$nodeList;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ WLANDSIListener this$0;

    WLANDSIListener$13(WLANDSIListener wLANDSIListener, Node[] nodeArray, int n) {
        this.this$0 = wLANDSIListener;
        this.val$nodeList = nodeArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIWLANListener)dSIListener).updateNodeList(this.val$nodeList, this.val$validFlag);
    }
}

