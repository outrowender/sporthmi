/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.I18NTextComponent$1;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess$IRemoteHMIDSIListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class I18NTextComponent
extends AbstractRemoteHMIComponent
implements RemoteHMIDSIAccess$IRemoteHMIDSIListener,
ITextConstantsConverter {
    public static int REMOTEHMI_TEXT = 1;
    private boolean dsiReady = false;
    private RemoteHMIAction pendingAction = null;
    private final Map currentTexts = new HashMap();
    private Field[] fields;

    public I18NTextComponent(Field[] fieldArray) {
        this.fields = fieldArray;
    }

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.remoteHmiService.addCommandHandler(249689349, new I18NTextComponent$1(this, "i18n-ready"));
    }

    @Override
    public void remoteHmiDsiReady() {
        this.dsiReady = true;
        if (this.pendingAction != null) {
            this.remoteHmiService.invokeAction(this.pendingAction);
            this.pendingAction = null;
        } else {
            this.refresh();
        }
    }

    public void refresh() {
        RemoteHMIAction remoteHMIAction = this.generateFields(this.getFrameworkAccess().getHMIService());
        if (remoteHMIAction == null) {
            return;
        }
        if (this.dsiReady) {
            this.remoteHmiService.invokeAction(remoteHMIAction);
        } else {
            this.pendingAction = remoteHMIAction;
        }
    }

    private RemoteHMIAction generateFields(HMIService hMIService) {
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(-124151808);
        this.currentTexts.clear();
        if (this.fields != null && this.fields.length > 0) {
            for (Field field : this.fields) {
                String string = field.getName();
                try {
                    Object object;
                    int n = field.getType().isArray() ? (((int[])(object = (int[])field.get(null))).length == 1 ? object[0] : -1) : field.getInt(null);
                    object = hMIService.getText(n);
                    remoteHMIAction.getParameters().putString(string, (String)object);
                    this.currentTexts.put(string, object);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    this.logChannel.log(10000, "I18NTextComponent#generateFields(): IllegalArgumentException %1 for field %2", (Object)illegalArgumentException, (Object)field.getName());
                    return null;
                }
                catch (IllegalAccessException illegalAccessException) {
                    this.logChannel.log(10000, "I18NTextComponent#generateFields(): IllegalAccessException %1 for field %2", (Object)illegalAccessException, (Object)field.getName());
                    return null;
                }
            }
            return remoteHMIAction;
        }
        return null;
    }

    @Override
    public String getText(String string) {
        String string2 = "";
        string2 = (String)this.currentTexts.get(string);
        if (string2 == null || string2.length() == 0) {
            return new StringBuffer().append("Text constant '").append(string).append("' could not be replaced!").toString();
        }
        return string2;
    }
}

