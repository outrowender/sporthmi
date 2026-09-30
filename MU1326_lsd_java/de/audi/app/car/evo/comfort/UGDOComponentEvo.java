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

    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addPopupStateListener(this.getLearningPopupID(), this.popupHandler);
        this.getApplication().getScreenStateDispatcher().addPopupStateListener(this.getSyncPopupID(), this.popupHandler);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(50, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(51, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(52, this);
    }

    public void deinit() {
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(50, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(51, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(52, this);
        this.getApplication().getScreenStateDispatcher().removePopupStateListener(this.getLearningPopupID(), this.popupHandler);
        this.getApplication().getScreenStateDispatcher().removePopupStateListener(this.getSyncPopupID(), this.popupHandler);
        super.deinit();
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600077, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600078, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600079, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600080, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600081, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(6001, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(6002, (short)25);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(6003, (short)25);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600077);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600078);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600079);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600080);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600081);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(6001);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(6002);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(6003);
    }

    protected void updateMenuEntryVisibility(UGDOViewOptions uGDOViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600081, this.getMenuEntryVisibilityState(uGDOViewOptions.getDeleteButton()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(6003, this.getMenuEntryVisibilityState(uGDOViewOptions.getVersionData()));
        switch (uGDOViewOptions.getConfiguration().getAvailableHardkeys()) {
            case 0: {
                this.getLogChannel().log(10000000, "UGDO availableHardkeys: 0, hide all learning buttons");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600078, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600079, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600080, 1);
                break;
            }
            case 1: {
                this.getLogChannel().log(10000000, "UGDO availableHardkeys: 1, show first learning button, hide buttons 2,3");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600078, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600079, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600080, 1);
                break;
            }
            case 2: {
                this.getLogChannel().log(10000000, "UGDO availableHardkeys: 2, show button1 and button2, hide button3");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600078, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600079, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600080, 1);
                break;
            }
            case 3: {
                this.getLogChannel().log(10000000, "UGDO availableHardkeys: 3, show all buttons");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600078, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600079, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600080, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                break;
            }
            default: {
                this.getLogChannel().log(10000000, "UGDO availableHardkeys error case (>3 || <0), evaluate viewoption.getLearning");
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600078, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600079, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600080, this.getMenuEntryVisibilityState(uGDOViewOptions.getLearning()));
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

    protected int getLearningPopupID() {
        return 600003;
    }

    protected int getSyncPopupID() {
        return 600004;
    }

    protected int getStandbyPopupID() {
        return 6;
    }

    public int getID() {
        return 28;
    }

    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(1000000, "[UGDOComponentEvo#actionProxyCallPerformed] methodID='%1'", (long)n);
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
                this.getLogChannel().log(100000, "[UGDOComponentEvo#actionProxyCallPerformed] methodID '%1' not supported", (long)n);
            }
        }
    }

    public int getCurrentVisiblePopupPrio() {
        return this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopupPriority(0);
    }

    public int getCurrentVisiblePopupId() {
        return this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopup(0);
    }

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

