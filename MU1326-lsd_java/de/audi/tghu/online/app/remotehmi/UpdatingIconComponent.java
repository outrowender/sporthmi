/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.UpdatingIconComponent$1;
import java.util.HashMap;
import java.util.Map;

public class UpdatingIconComponent
extends AbstractRemoteHMIComponent {
    Map visibleMap = new HashMap();

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(570, new UpdatingIconComponent$1(this, "updating-icon-component", logChannel));
    }

    private boolean determineUpdatingVisible(boolean bl, String string, String string2) {
        boolean bl2 = "updateView".equals(string2);
        if (!bl) {
            this.removeContext(string, bl2);
        } else {
            this.addContext(string, bl2);
        }
        return this.isIconVisibleInCurrentContext();
    }

    private void addContext(String string, boolean bl) {
        if (!bl) {
            this.visibleMap.put(string, new Integer(1));
            return;
        }
        boolean bl2 = this.visibleMap.containsKey(string);
        if (!bl2) {
            this.visibleMap.put(string, null);
        }
    }

    private void removeContext(String string, boolean bl) {
        boolean bl2 = this.visibleMap.containsKey(string);
        if (!bl2) {
            return;
        }
        Object object = this.visibleMap.get(string);
        if (object == null || !bl) {
            this.visibleMap.remove(string);
            this.logChannel.log(1078071040, "UpdatingIconComponent#removeContext context %1 was removed from visibility map", (Object)string);
        } else {
            this.logChannel.log(1078071040, "UpdatingIconComponent#removeContext context %1 tried to remove visibility but action forces visiblity");
        }
    }

    private void switchIconState(boolean bl) {
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getModelBankAccess().getChoiceModel(OnlineModelBankAccess.getUpdatingIconChoiceId());
        choiceModelApp.setValue(bl ? 1 : 0);
    }

    private boolean isIconVisibleInCurrentContext() {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext != null) {
            String string = remoteHMIContext.getContextName();
            return this.visibleMap.containsKey(string);
        }
        return this.visibleMap.size() > 0;
    }

    public void refresh() {
        this.switchIconState(this.isIconVisibleInCurrentContext());
    }

    public void removeContext(String string) {
        this.visibleMap.remove(string);
    }

    static /* synthetic */ boolean access$000(UpdatingIconComponent updatingIconComponent, boolean bl, String string, String string2) {
        return updatingIconComponent.determineUpdatingVisible(bl, string, string2);
    }

    static /* synthetic */ void access$100(UpdatingIconComponent updatingIconComponent, boolean bl) {
        updatingIconComponent.switchIconState(bl);
    }
}

