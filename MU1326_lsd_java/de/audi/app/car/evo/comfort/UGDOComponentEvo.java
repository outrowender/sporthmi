/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.comfort;

import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.AbstractUGDOComponent;
import java.util.Map;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.UGDOViewOptions;

public class UGDOComponentEvo
extends AbstractUGDOComponent
implements IActionProxyListener {
    public UGDOComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addPopupStateListener(this.getLearningPopupID(), this.popupHandler);
        this.getApplication().getScreenStateDispatcher().addPopupStateListener(this.getSyncPopupID(), this.popupHandler);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(50, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(51, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(52, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(50, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(51, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(52, this);
        this.getApplication().getScreenStateDispatcher().removePopupStateListener(this.getLearningPopupID(), this.popupHandler);
        this.getApplication().getScreenStateDispatcher().removePopupStateListener(this.getSyncPopupID(), this.popupHandler);
        super.deinit();
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(220727552, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(237504768, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(254281984, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(271059200, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(287836416, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(6001, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(6002, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(6003, (short)25);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(220727552);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(237504768);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(254281984);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(271059200);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(287836416);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(6001);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(6002);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(6003);
    }

    @Override
    protected void updateMenuEntryVisibility(UGDOViewOptions uGDOViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(287836416, this.getMenuEntryVisibilityState(uGDOViewOptions.getDeleteButton()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(6003, this.getMenuEntryVisibilityState(uGDOViewOptions.getVersionData()));
        switch (uGDOViewOptions.getConfiguration().getAvailableHardkeys()) {
            case 0: {
                this.getLogChannel().log(-2137614336, "UGDO availableHardkeys: 0, hide all learning buttons");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(237504768, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(254281984, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(271059200, 1);
                break;
            }
            case 1: {
                this.getLogChannel().log(-2137614336, "UGDO availableHardkeys: 1, show first learning button, hide buttons 2,3");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(237504768, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(254281984, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(271059200, 1);
                break;
            }
            case 2: {
                this.getLogChannel().log(-2137614336, "UGDO availableHardkeys: 2, show button1 and button2, hide button3");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(237504768, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(254281984, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(271059200, 1);
                break;
            }
            case 3: {
                this.getLogChannel().log(-2137614336, "UGDO availableHardkeys: 3, show all buttons");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(237504768, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(254281984, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(271059200, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                break;
            }
            default: {
                this.getLogChannel().log(-2137614336, "UGDO availableHardkeys error case (>3 || <0), evaluate viewoption.getLearning");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(237504768, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(254281984, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(271059200, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
            }
        }
        if (uGDOViewOptions.getConfiguration().getSpecialFeatures().isDefaultMode()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(6001, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(6001, 1);
        }
        if (uGDOViewOptions.getConfiguration().getSpecialFeatures().isFixkitMode()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(6002, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(6002, 1);
        }
    }

    @Override
    protected int getLearningPopupID() {
        return -1020851968;
    }

    @Override
    protected int getSyncPopupID() {
        return -1004074752;
    }

    @Override
    protected int getStandbyPopupID() {
        return 6;
    }

    @Override
    public int getID() {
        return 28;
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(1078071040, "[UGDOComponentEvo#actionProxyCallPerformed] methodID='%1'", (long)n);
        switch (n) {
            case 50: {
                this.abortUGDOLearning();
                break;
            }
            case 51: {
                this.restartUGDOLearning();
                break;
            }
            case 52: {
                this.setUGDOSync();
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[UGDOComponentEvo#actionProxyCallPerformed] methodID '%1' not supported", (long)n);
            }
        }
    }

    @Override
    public int getCurrentVisiblePopupPrio() {
        return this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopupPriority(0);
    }

    public int getCurrentVisiblePopupId() {
        return this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopup(0);
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

