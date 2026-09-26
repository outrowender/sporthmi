/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.HMIViewTextDisplayScreenAccess;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.remotehmi.ArrayUtilities;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

public class HMIViewTextDisplayListener
extends AbstractHMIViewListenerEvo {
    public HMIViewTextDisplayListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo, HMIViewTextDisplayScreenAccess hMIViewTextDisplayScreenAccess) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo, hMIViewTextDisplayScreenAccess);
        hMIViewTextDisplayScreenAccess.switchScreen(false);
        hMIViewTextDisplayScreenAccess.getAction1Button().setButtonListener(this);
        hMIViewTextDisplayScreenAccess.getAction2Button().setButtonListener(this);
        hMIViewTextDisplayScreenAccess.switchScreen(true);
        hMIViewTextDisplayScreenAccess.getAction1Button().setButtonListener(this);
        hMIViewTextDisplayScreenAccess.getAction2Button().setButtonListener(this);
    }

    private final HMIViewTextDisplayScreenAccess getScreenAccess() {
        return (HMIViewTextDisplayScreenAccess)this.screenAccess;
    }

    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        HMIViewTextDisplayScreenAccess hMIViewTextDisplayScreenAccess = this.getScreenAccess();
        this.setTitles(hMIViewTextDisplayScreenAccess.getSubtitleModel(), hMIViewTextDisplayScreenAccess.getBreadCrumbModel(), hMIProperties);
        String string = this.getTextMaxLen("displayText", hMIProperties);
        hMIViewTextDisplayScreenAccess.getMessageModel().setText(string);
        String[] stringArray = hMIProperties.getStringArray("buttonText");
        String string2 = ArrayUtilities.getSafeArrayValue(stringArray, 0);
        hMIViewTextDisplayScreenAccess.getAction1Label().setText(string2);
        hMIViewTextDisplayScreenAccess.getAction1Button().setStatus(string2.length() == 0 ? 0 : 1);
        String string3 = ArrayUtilities.getSafeArrayValue(stringArray, 1);
        hMIViewTextDisplayScreenAccess.getAction2Label().setText(string3);
        hMIViewTextDisplayScreenAccess.getAction2Button().setStatus(string3.length() == 0 ? 0 : 1);
        this.setSelectedIds(hMIProperties.getStringArray("buttonTextId"));
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "HMIViewTextDisplayListener#keyPressed: modelID=%1, keyID=%2.", (long)n, (long)n2);
        super.keyPressed(n, n2, n3);
        HMIViewTextDisplayScreenAccess hMIViewTextDisplayScreenAccess = this.getScreenAccess();
        if (n == hMIViewTextDisplayScreenAccess.getAction1Button().getID()) {
            this.invokeActionItemSelected(0);
        } else if (n == hMIViewTextDisplayScreenAccess.getAction2Button().getID()) {
            this.invokeActionItemSelected(1);
        }
    }

    public int getViewID() {
        return 4000;
    }

    public boolean doLockModelGroup() {
        return true;
    }
}

