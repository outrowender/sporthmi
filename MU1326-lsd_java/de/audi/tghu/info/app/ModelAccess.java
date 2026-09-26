/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.info.app.InfoEnv;
import de.esolutions.fw.util.commons.Buffer;

public class ModelAccess {
    private final InfoEnv env;

    ModelAccess(InfoEnv infoEnv) {
        this.env = infoEnv;
    }

    public void setTMCCounterLabelVW(long l, long l2) {
        this.env.getLabelModel(-828307712).setText(Long.toString(l2));
        this.env.getLabelModel(-1230960896).setText(Long.toString(l));
    }

    public void setTMCStatusBar(String string, String string2) {
        Buffer buffer = new Buffer(100);
        buffer.append(string);
        buffer.append(' ');
        buffer.append(string2);
        this.env.getLabelModel(-1532950784).setText(buffer.toString());
    }

    public void setTMCOnRouteAvailable() {
        this.env.getChoiceModel(-509540608).setValue(1);
    }

    public void setTMCOnRouteNotAvailable() {
        this.env.getChoiceModel(-509540608).setValue(0);
    }

    public void setTMCProviderNameLabelVW(String string) {
        this.env.getLabelModel(1453393664).setText(string);
    }

    public void setTMCReceiveDateLabelVW(String string) {
        this.env.getLabelModel(1470170880).setText(string);
    }

    public void setTMCTimestampLabelVW(String string) {
        this.env.getLabelModel(1486948096).setText(string);
    }

    public void returnToOverviewList() {
        int n = this.env.getChoiceModel(-1516173568).getValue() == 0 ? 1 : 0;
        this.env.getChoiceModel(-1516173568).setValue(n);
    }

    public ButtonModelApp getShowInMapButtonModel() {
        return this.env.getButtonModel(-1029634304);
    }

    public void setShowInMapSyncModelWaiting() {
        this.env.getChoiceModel(-1113520384).setStatus(0);
    }

    public void setShowInMapSyncModelOK() {
        this.env.getChoiceModel(-1113520384).setStatus(1);
    }
}

