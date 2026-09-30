/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.kombi;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.kombi.AbstractHUDComponent;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class HUDComponentEvo
extends AbstractHUDComponent {
    private volatile boolean driverAssistanceVisible;
    private volatile boolean onlySpeedLimiterAndGRA;

    public HUDComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initModels() {
        super.initModels();
        this.getChoiceModel(601127).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(601127).resetListener();
        super.deinitModels();
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected(EVO):", n, n2, true);
        if (n == 601127) {
            this.setDriverAssistanceFlag(n2 == 1);
            this.setHUDContent();
        } else {
            super.itemSelected(n, n2, n3, n4);
        }
    }

    public void updateHUDContent(HUDContent hUDContent, int n) {
        this.getLogChannel().log(1000000, "[HUDComponentEvo#updateHUDContent] content='%1', valid='%2'", (Object)hUDContent, (long)n);
        if (n == 1) {
            boolean bl = hUDContent.acc || hUDContent.gra || hUDContent.hca || hUDContent.speedLimiter || hUDContent.efficiencyAssist;
            this.getChoiceModel(601127).setValue(bl ? 1 : 0);
            super.updateHUDContent(hUDContent, n);
        }
    }

    protected void updateMenuEntryVisibility(HUDViewOptions hUDViewOptions) {
        this.driverAssistanceVisible = this.checkDriverAssistanceVisibility(hUDViewOptions);
        boolean bl = false;
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600098, this.getMenuEntryVisibilityState(hUDViewOptions.getBrightness()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600151, this.getMenuEntryVisibilityState(hUDViewOptions.getRotationAdjustment()));
        if (this.isDropDownVisible(hUDViewOptions)) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600777, this.getVisibilityState(hUDViewOptions.getContent(), true));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600219, this.getVisibilityState(hUDViewOptions.getContent(), false));
        } else if (this.isCheckBoxVisible(hUDViewOptions)) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600777, this.getVisibilityState(hUDViewOptions.getContent(), false));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600219, this.getVisibilityState(hUDViewOptions.getContent(), true));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600777, this.getVisibilityState(hUDViewOptions.getContent(), false));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600219, this.getVisibilityState(hUDViewOptions.getContent(), false));
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600226, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isNightvision()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600220, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isRoadsign()));
        if (this.driverAssistanceVisible) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600378, this.getMenuEntryVisibilityState(hUDViewOptions.getContent()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600222, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600221, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600223, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600225, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600377, 1);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600378, 1);
            if (this.isOnlySpeedLimiterGRA()) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600222, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600221, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().gra));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600223, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600225, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600377, 1);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600222, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isAcc()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600221, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isGra()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600223, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isHca()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600225, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isEfficiencyAssist()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600377, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isSpeedLimiter()));
            }
        }
    }

    private void setOnlySpeedLimiterAndGRA(boolean bl) {
        this.onlySpeedLimiterAndGRA = bl;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600098, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600151, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600222, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600221, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600223, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600219, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600226, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600220, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600225, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600377, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600378, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600777, (short)22);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600098);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600151);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600222);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600221);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600223);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600219);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600226);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600220);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600225);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600377);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600378);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600777);
    }

    public int getID() {
        return 1;
    }

    private boolean checkDriverAssistanceVisibility(HUDViewOptions hUDViewOptions) {
        int n = 0;
        n += hUDViewOptions.getConfiguration().acc ? 1 : 0;
        n += hUDViewOptions.getConfiguration().gra ? 1 : 0;
        n += hUDViewOptions.getConfiguration().hca ? 1 : 0;
        n += hUDViewOptions.getConfiguration().efficiencyAssist ? 1 : 0;
        int n2 = hUDViewOptions.getConfiguration().speedLimiter ? 1 : 0;
        this.setOnlySpeedLimiterAndGRA(false);
        if ((n += n2) <= 1) {
            return false;
        }
        if (n == 2 && hUDViewOptions.getConfiguration().gra && hUDViewOptions.getConfiguration().speedLimiter) {
            this.setOnlySpeedLimiterAndGRA(true);
            return false;
        }
        return true;
    }

    private boolean isDropDownVisible(HUDViewOptions hUDViewOptions) {
        return hUDViewOptions.getConfiguration() != null && hUDViewOptions.getConfiguration().isRgi() && hUDViewOptions.getConfiguration().isNavInfo();
    }

    private boolean isCheckBoxVisible(HUDViewOptions hUDViewOptions) {
        return hUDViewOptions.getConfiguration() != null && hUDViewOptions.getConfiguration().isRgi() && !hUDViewOptions.getConfiguration().isNavInfo();
    }

    private void setDriverAssistanceFlag(boolean bl) {
        this.getLogChannel().log(1000000, "[HUDComponentEvo#setDriverAssistanceFlag] flag='%1', currentContent='%2'", bl, (Object)this.currContent);
        this.currContent.acc = this.currViewOptions.getConfiguration().acc ? bl : false;
        this.currContent.gra = this.currViewOptions.getConfiguration().gra ? bl : false;
        this.currContent.hca = this.currViewOptions.getConfiguration().hca ? bl : false;
        this.currContent.efficiencyAssist = this.currViewOptions.getConfiguration().efficiencyAssist ? bl : false;
        this.currContent.speedLimiter = this.currViewOptions.getConfiguration().speedLimiter ? bl : false;
    }

    private int getVisibilityState(CarViewOption carViewOption, boolean bl) {
        if (bl) {
            return this.getMenuEntryVisibilityState(carViewOption);
        }
        return 1;
    }

    protected boolean isOnlySpeedLimiterGRA() {
        return this.onlySpeedLimiterAndGRA;
    }
}

