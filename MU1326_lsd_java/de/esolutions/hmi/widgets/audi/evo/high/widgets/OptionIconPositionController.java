/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IDrawerListener;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.IOptionIconPositionController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;

public class OptionIconPositionController
extends AbstractWidgetController
implements IDrawerListener,
IOptionIconPositionController {
    private static final int POSITION_COORDINATE_Y = 1;
    private static final int POSITION_COORDINATE_X = 0;
    private static final int RCTA_CRITICAL = 1;
    private static final int RCTA_VERTICAL_OFFSET = -156;
    private int[] defaultPosition = new int[]{0, 0};
    private int[][] positions = null;
    private int[][] positionsRTL = null;
    private boolean leftRCTAActive = false;
    private boolean useDynamicPosition = false;
    private int xDynamic;
    private int yDynamic;
    private boolean isActive;

    public void connected(InitializationContext initializationContext) {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo;
        super.connected(initializationContext);
        if (this.terminal != null && (iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager()) != null) {
            iDrawerFocusManagerEvo.addDrawerListener(this);
        }
        this.isActive = true;
    }

    public void disconnecting() {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo;
        if (this.terminal != null && (iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager()) != null) {
            iDrawerFocusManagerEvo.removeDrawerListener(this);
        }
        super.disconnecting();
        if (this.isActive) {
            sideBarLogChannel.log(10000000, "OptionIconPositionController#disconnecting Predisconnecting did not happen.");
        }
        this.isActive = false;
    }

    public void predisconnecting() {
        ScreenChangeAnimationItem screenChangeAnimationItem;
        super.predisconnecting();
        if (this.terminal != null && (screenChangeAnimationItem = this.terminal.getDrawerFocusManager()) != null) {
            screenChangeAnimationItem.removeDrawerListener(this);
        }
        this.isActive = false;
        screenChangeAnimationItem = this.getDrawerIcon();
        if (screenChangeAnimationItem == null) {
            return;
        }
        int[] nArray = this.defaultPosition;
        screenChangeAnimationItem.setX(nArray[0]);
        screenChangeAnimationItem.setY(nArray[1]);
    }

    private DrawerIcon getDrawerIcon() {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo;
        if (this.terminal != null && (iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager()) != null && (DrawerController)iDrawerFocusManagerEvo.getOptionDrawer() != null) {
            logDrawerFocusMain.log(10000000, "OptionIconPositionController#getDrawerIcon optionDrawer: %1", (Object)((DrawerController)iDrawerFocusManagerEvo.getOptionDrawer()));
            return ((DrawerController)iDrawerFocusManagerEvo.getOptionDrawer()).getDrawerIcon();
        }
        return null;
    }

    public IRenderer getRenderer() {
        return null;
    }

    public void optionDrawerActivated(IScreenData iScreenData, Screen screen, IDrawerControllerEvo iDrawerControllerEvo) {
        this.updatePosition();
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updatePositionFromChoiceModel(modelUpdateEvent);
    }

    public void setDefaultPosition(int n, int n2) {
        this.defaultPosition = new int[]{n, n2};
    }

    public void setDrawerIconPosition(int n, int n2) {
        ScreenChangeAnimationItem screenChangeAnimationItem;
        if (this.terminal != null && (screenChangeAnimationItem = this.terminal.getDrawerFocusManager()) != null) {
            if (sideBarLogChannel.isDebug()) {
                sideBarLogChannel.log(10000000, "OptionIconPositionController#setDrawerIconPosition hash = %3, (x, y) = (%1, %2)", (long)n, (long)n2, (long)this.hashCode());
            }
            screenChangeAnimationItem.setOptionIconOffset(n, n2);
        }
        if ((screenChangeAnimationItem = this.getDrawerIcon()) != null) {
            screenChangeAnimationItem.setX(n);
            screenChangeAnimationItem.setY(n2);
        }
    }

    public void setPositions(int[][] nArray) {
        this.positions = nArray;
    }

    public void setPositionsRTL(int[][] nArray) {
        this.positionsRTL = nArray;
    }

    public int[][] getPositionsRTL() {
        return this.positionsRTL;
    }

    public boolean isUseDynamicPosition() {
        return this.useDynamicPosition;
    }

    public void setUseDynamicPosition(boolean bl) {
        this.useDynamicPosition = bl;
    }

    public void setDynamicPosition(int n, int n2) {
        this.xDynamic = n;
        this.yDynamic = n2;
        this.updatePosition();
    }

    private void updatePosition() {
        if (this.useDynamicPosition) {
            if (this.isActive) {
                this.setDrawerIconPosition(this.xDynamic, this.yDynamic);
            } else {
                sideBarLogChannel.log(10000000, "OptionIconPositionController#updatePosition hash = %1 tries to set position when not active.", (long)this.hashCode());
            }
        } else {
            this.updatePositionFromChoiceModel(null);
        }
    }

    private void updatePositionFromChoiceModel(ModelUpdateEvent modelUpdateEvent) {
        if (!this.isConnected() || !(this.model instanceof ChoiceModelGUI)) {
            return;
        }
        DrawerIcon drawerIcon = this.getDrawerIcon();
        if (drawerIcon == null) {
            return;
        }
        if (modelUpdateEvent != null && modelUpdateEvent.getModelId() == 2100199) {
            this.leftRCTAActive = modelUpdateEvent.getClientData1() == 1;
        }
        int[][] nArray = null;
        boolean bl = false;
        if (framework != null && framework.getLanguageMgr() != null && framework.getLanguageMgr().isLeftToRightOrientation()) {
            nArray = this.positions;
        } else {
            nArray = this.positionsRTL;
            bl = true;
        }
        int n = ((ChoiceModelGUI)this.model).getValue();
        int[] nArray2 = null;
        if (nArray != null && n >= 0 && n < nArray.length) {
            logDrawerFocusMain.log(10000000, "OptionIconPositionController#processModelUpdateEvent retrieving an option drawer icon position at index %1", (long)n);
            nArray2 = nArray[n];
        } else {
            logDrawerFocusMain.log(100000, "OptionIconPositionController#processModelUpdateEvent no option drawer icon position available for index %1", (long)n);
        }
        if (nArray2 != null && nArray2.length == 2) {
            void var7_7 = nArray2[0];
            int n2 = nArray2[1];
            if (bl && this.leftRCTAActive) {
                n2 -= 156;
            }
            logDrawerFocusMain.log(10000000, "OptionIconPositionController#processModelUpdateEvent setting option drawer icon position to [%1, %2]", (long)var7_7, (long)n2);
            drawerIcon.setX((int)var7_7);
            drawerIcon.setY(n2);
        } else {
            logDrawerFocusMain.log(100000, "OptionIconPositionController#processModelUpdateEvent no valid option drawer icon position available");
        }
    }

    public void screenSet(IScreenData iScreenData, Screen screen) {
        this.updatePosition();
    }

    public void optionDrawerLocked(Boolean bl) {
    }
}

