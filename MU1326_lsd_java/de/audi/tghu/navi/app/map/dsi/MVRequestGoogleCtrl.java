/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.MVResponseGoogleCtrl;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.Rect;

public class MVRequestGoogleCtrl
extends MVRequestControl
implements DSIMapViewerGoogleCtrl {
    private DSIMapViewerGoogleCtrl mDSIGoogleCtrl;

    public MVRequestGoogleCtrl(int n, LogChannel logChannel, LogChannel logChannel2) {
        super(n, logChannel, logChannel2);
        MVResponseGoogleCtrl mVResponseGoogleCtrl = new MVResponseGoogleCtrl(n, logChannel2);
        this.setResponser(mVResponseGoogleCtrl);
    }

    protected final boolean isDSIGoogleCtrlAvailable() {
        return this.mDSIGoogleCtrl != null;
    }

    @Override
    protected void cleanup() {
        if (this.mDSIGoogleCtrl != null) {
            try {
                this.mDSIGoogleCtrl.clearNotification(this.getMVResponseGoogleCtrl());
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MVRequestGoogleCtrl#cleanup(): ERROR = %1", (Object)exception.getMessage());
            }
        }
        super.cleanup();
    }

    public void bind(DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl) {
        if (dSIMapViewerGoogleCtrl == null) {
            this.cleanupResponserAttributeNotifications();
        }
        this.mDSIGoogleCtrl = dSIMapViewerGoogleCtrl;
        if (this.getMap() != null) {
            this.getMap().initDSI();
        } else {
            this.getLogger().log(-1601830656, "MVRequestGoogleCtrl#bind() - It (id = %1) is not bound to a map.", (long)this.getID());
        }
    }

    @Override
    public boolean isReady() {
        boolean bl = super.isReady();
        boolean bl2 = this.mDSIGoogleCtrl != null;
        return bl && bl2;
    }

    @Override
    public boolean isOperable() {
        boolean bl = super.isOperable();
        boolean bl2 = true;
        return bl && bl2;
    }

    public MVResponseGoogleCtrl getMVResponseGoogleCtrl() {
        return (MVResponseGoogleCtrl)this.getResponser();
    }

    @Override
    public void loadKml(String[] stringArray) {
        if (!this.isDSIGoogleCtrlAvailable()) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#loadKml() - DSIGoogleCtrl not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestGoogleCtrl#loadKml(%1)", (Object)stringArray);
            this.mDSIGoogleCtrl.loadKml(stringArray);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#loadKml(): ERROR");
        }
    }

    @Override
    public void requestClearCache() {
        if (!this.isDSIGoogleCtrlAvailable()) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#requestClearCache() - DSIGoogleCtrl not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestGoogleCtrl#requestClearCache");
            this.mDSIGoogleCtrl.requestClearCache();
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#requestClearCache(): ERROR");
        }
    }

    @Override
    public void setConnectionInformation(int n) {
        if (!this.isDSIGoogleCtrlAvailable()) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setConnectionInformation() - DSIGoogleCtrl not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestGoogleCtrl#setConnectionInformation(%1)", (long)n);
            this.mDSIGoogleCtrl.setConnectionInformation(n);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setConnectionInformation(): ERROR");
        }
    }

    @Override
    public void setLanguage(String string) {
        if (!this.isDSIGoogleCtrlAvailable()) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setLanguage() - DSIGoogleCtrl not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestGoogleCtrl#setLanguage(%1)", (Object)string);
            this.mDSIGoogleCtrl.setLanguage(string);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setLanguage(): ERROR");
        }
    }

    @Override
    public void setLayerVisibility(int[] nArray) {
        if (!this.isDSIGoogleCtrlAvailable()) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setLayerVisibility() - DSIGoogleCtrl not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestGoogleCtrl#setLayerVisibility: %1", (Object)nArray);
            this.mDSIGoogleCtrl.setLayerVisibility(nArray);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setLayerVisibility(): ERROR");
        }
    }

    @Override
    public void resetMemberVariables() {
        super.resetMemberVariables();
        this.getLogger().log(-2137614336, "MVRequestGoogleCtrl#resetMemberVariables() ");
    }

    public void setNotificationForGE(int[] nArray, DSIListener dSIListener) {
        if (!this.isDSIGoogleCtrlAvailable()) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setNotificationForGE() - DSIGoogleCtrl not available!");
            return;
        }
        try {
            this.getLogger().log(-2137614336, "MVRequestGoogleCtrl#setNotificationForGE() - attributes: %1", (Object)nArray);
            this.mDSIGoogleCtrl.setNotification(nArray, dSIListener);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#setNotificationForGE(): ERROR");
        }
    }

    @Override
    public void setCopyrightPosition(Rect rect, int n, int n2) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        super.clearNotification(dSIListener);
        if (!this.isDSIGoogleCtrlAvailable()) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#clearNotification() - DSIGoogleCtrl not available!");
            return;
        }
        try {
            this.mDSIGoogleCtrl.clearNotification(dSIListener);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "MVRequestGoogleCtrl#clearNotification(): %1", (Object)exception.getMessage());
        }
    }
}

