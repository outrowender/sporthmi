/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.HashMap;
import java.util.Map;

public class UpdatingIconComponent
extends AbstractRemoteHMIComponent {
    Map visibleMap = new HashMap();

    public void init(final LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(570, new AbstractCommandHandler("updating-icon-component"){

            public void indicateCommand(int n, Object object) {
                if (!(object instanceof HMIProperties)) {
                    logChannel.log(10000, new StringBuffer().append("UpdatingIconComponent#indicateCommand() invalid payload: ").append(object).toString());
                    return;
                }
                boolean bl = ((HMIProperties)object).getBoolean("updating");
                String string = ((HMIProperties)object).getString("appContextName");
                String string2 = ((HMIProperties)object).getString("actionData");
                logChannel.log(1000000, "UpdatingIconComponent#indicateCommand(): setting updating-icon %1 for context %2 and source %3", (Object)(bl ? "visible" : "hidden"), (Object)string, (Object)string2);
                UpdatingIconComponent.this.switchIconState(UpdatingIconComponent.this.determineUpdatingVisible(bl, string, string2));
            }
        });
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
            this.logChannel.log(1000000, "UpdatingIconComponent#removeContext context %1 was removed from visibility map", (Object)string);
        } else {
            this.logChannel.log(1000000, "UpdatingIconComponent#removeContext context %1 tried to remove visibility but action forces visiblity");
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
}

