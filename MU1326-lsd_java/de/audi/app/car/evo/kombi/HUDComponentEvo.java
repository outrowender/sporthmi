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

    @Override
    protected void initModels() {
        super.initModels();
        this.getChoiceModel(657197312).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(657197312).resetListener();
        super.deinitModels();
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected(EVO):", n, n2, true);
        if (n == 657197312) {
            this.setDriverAssistanceFlag(n2 == 1);
            this.setHUDContent();
        } else {
            super.itemSelected(n, n2, n3, n4);
        }
    }

    @Override
    public void updateHUDContent(HUDContent hUDContent, int n) {
        this.getLogChannel().log(1078071040, "[HUDComponentEvo#updateHUDContent] content='%1', valid='%2'", (Object)hUDContent, (long)n);
        if (n == 1) {
            boolean bl = hUDContent.acc || hUDContent.gra || hUDContent.hca || hUDContent.speedLimiter || hUDContent.efficiencyAssist;
            this.getChoiceModel(657197312).setValue(bl ? 1 : 0);
            super.updateHUDContent(hUDContent, n);
        }
    }

    @Override
    protected void updateMenuEntryVisibility(HUDViewOptions hUDViewOptions) {
        this.driverAssistanceVisible = this.checkDriverAssistanceVisibility(hUDViewOptions);
        boolean bl = false;
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(573049088, this.getMenuEntryVisibilityState(hUDViewOptions.getBrightness()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1462241536, this.getMenuEntryVisibilityState(hUDViewOptions.getRotationAdjustment()));
        if (this.isDropDownVisible(hUDViewOptions)) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-919992064, this.getVisibilityState(hUDViewOptions.getContent(), true));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1691875072, this.getVisibilityState(hUDViewOptions.getContent(), false));
        } else if (this.isCheckBoxVisible(hUDViewOptions)) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-919992064, this.getVisibilityState(hUDViewOptions.getContent(), false));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1691875072, this.getVisibilityState(hUDViewOptions.getContent(), true));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-919992064, this.getVisibilityState(hUDViewOptions.getContent(), false));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1691875072, this.getVisibilityState(hUDViewOptions.getContent(), false));
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1574434560, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isNightvision()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1675097856, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isRoadsign()));
        if (this.driverAssistanceVisible) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(975767808, this.getMenuEntryVisibilityState(hUDViewOptions.getContent()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1641543424, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1658320640, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1624766208, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1591211776, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(958990592, 1);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(975767808, 1);
            if (this.isOnlySpeedLimiterGRA()) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1641543424, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1658320640, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().gra));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1624766208, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1591211776, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(958990592, 1);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1641543424, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isAcc()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1658320640, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isGra()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1624766208, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isHca()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1591211776, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isEfficiencyAssist()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(958990592, this.getVisibilityState(hUDViewOptions.getContent(), hUDViewOptions.getConfiguration().isSpeedLimiter()));
            }
        }
    }

    private void setOnlySpeedLimiterAndGRA(boolean bl) {
        this.onlySpeedLimiterAndGRA = bl;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(573049088, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1462241536, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1641543424, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1658320640, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1624766208, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1691875072, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1574434560, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1675097856, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1591211776, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(958990592, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(975767808, (short)22);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-919992064, (short)22);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(573049088);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1462241536);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1641543424);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1658320640);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1624766208);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1691875072);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1574434560);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1675097856);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1591211776);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(958990592);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(975767808);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-919992064);
    }

    @Override
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
        this.getLogChannel().log(1078071040, "[HUDComponentEvo#setDriverAssistanceFlag] flag='%1', currentContent='%2'", bl, (Object)this.currContent);
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

    @Override
    protected boolean isOnlySpeedLimiterGRA() {
        return this.onlySpeedLimiterAndGRA;
    }
}

