/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IDisplayListener;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.Preset;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IDisplayControllerWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.HMITerminalEvoImpl;

public class DisplayControllerEvo
extends AbstractWidgetController
implements IDisplayListener,
IDisplayControllerWidget {
    protected int[][] positionsOfDisplayables;
    protected int[][] maxOpacities;
    protected boolean[] maxOpacitiesSet;
    protected static LogChannel logDisplay = null;
    protected float backgroundOpacity = 1.0f;
    private int staticContext = -1;
    private int preparedContext;

    public DisplayControllerEvo() {
        if (logDisplay == null) {
            logDisplay = AbstractWidget.framework.getLogChannel("Fw.Display");
        }
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)initializationContext.getScreen();
        if (abstractScreenWidget != null && (abstractScreenWidget.getScreenType() == 4 || abstractScreenWidget.getScreenType() == 14)) {
            ((ChoiceModelGUI)this.model).itemSelected(-2, this.terminal.getTerminalID());
        }
        this.prepareContextSwitch();
    }

    private void prepareContextSwitch() {
        this.preparedContext = this.getTargetContextID();
        this.positionDisplayables();
        this.setOpacityOnBackgroundLayers(this.backgroundOpacity, true);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        logDisplay.log(10000000, "DisplayControllerEvo#processModelUpdateEvent");
        this.prepareAndSwitchToTargetContext();
    }

    protected int[] getExtents(int n) {
        logDisplay.log(100000000, "DisplayControllerEvo#getExtents displayableID = %1", (long)n);
        return hmiService.getDisplayManager().getExtends(n);
    }

    protected void positionDisplayables() {
        int[] nArray = hmiService.getDisplayManager().getDisplayables(this.getTargetContextID());
        if (nArray == null) {
            return;
        }
        if (this.positionsOfDisplayables != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                for (int i3 = 0; i3 < this.positionsOfDisplayables.length; ++i3) {
                    if (this.positionsOfDisplayables[i3][0] != nArray[i2]) continue;
                    if (this.positionsOfDisplayables[i3].length == 3) {
                        this.setPosition(this.positionsOfDisplayables[i3][0], this.positionsOfDisplayables[i3][1], this.positionsOfDisplayables[i3][2]);
                        continue;
                    }
                    logDisplay.log(10000000, "DisplayControllerEvo#positionDisplayables length of array != 3");
                }
            }
        } else {
            Layout layout = ((HMITerminalEvoImpl)this.getTerminal()).getLayout();
            for (int i4 = 0; i4 < nArray.length; ++i4) {
                int[] nArray2 = layout.getDisplayablePosition(nArray[i4]);
                this.setPosition(nArray[i4], nArray2[0], nArray2[1]);
            }
        }
    }

    protected void switchToTargetContext() {
        if (logDisplay.isDebug()) {
            logDisplay.log(10000000, "DisplayControllerEvo#switchToTargetContext context: %1", (long)this.getTargetContextID());
        }
        hmiService.getDisplayManager().switchContext(this.getTargetContextID(), this.terminal.getTerminalID(), this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setOpacity(int n, float f2) {
        if (this.maxOpacities != null) {
            float f3 = this.getMaxOpacity(n);
            int n2 = this.getMaxOpacityIndex(n);
            if (f3 < f2 && n2 < this.maxOpacitiesSet.length) {
                if (this.maxOpacitiesSet[n2]) return;
                if (10000000 <= logDisplay.getCurrentLogThreshold()) {
                    logDisplay.log(10000000, "DisplayControllerEvo#setOpacity maxOpacity for displayable %2 is %1 ", (Object)Float.toString(f3 * 100.0f), (long)n);
                }
                f2 = f3;
                this.maxOpacitiesSet[n2] = true;
            } else if (this.maxOpacitiesSet != null && n2 < this.maxOpacitiesSet.length && this.maxOpacitiesSet[n2]) {
                this.maxOpacitiesSet[n2] = false;
            }
        }
        if (10000000 <= logDisplay.getCurrentLogThreshold()) {
            logDisplay.log(10000000, "DisplayControllerEvo#setOpacity displayable: %2, opacity: %1", (Object)Float.toString(f2), (long)n);
        }
        hmiService.getDisplayManager().setOpacity(n, this.terminal.getTerminalID(), (int)(f2 * 100.0f));
    }

    private int getMaxOpacityIndex(int n) {
        int n2;
        for (n2 = 0; n2 < this.maxOpacities.length && n != this.maxOpacities[n2][0]; ++n2) {
        }
        return n2;
    }

    protected float getMaxOpacity(int n) {
        float f2 = 1.0f;
        if (this.maxOpacities != null) {
            for (int i2 = 0; i2 < this.maxOpacities.length; ++i2) {
                if (n != this.maxOpacities[i2][0]) continue;
                f2 = (float)this.maxOpacities[i2][1] / 100.0f;
                break;
            }
        }
        return f2;
    }

    public void setOpacityOnBackgroundLayers(float f2, boolean bl) {
        this.backgroundOpacity = f2;
        int n = bl ? this.getTargetContextID() : hmiService.getDisplayManager().getCurrentContextID(this.terminal.getTerminalID());
        logDisplay.log(10000000, "DisplayControllerEvo#setOpacityOnBackgroundLayers setting opacity on backgroundlayers for context: %1", (long)n);
        int[] nArray = hmiService.getDisplayManager().getDisplayables(n);
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (!this.isBackGroundLayer(nArray[i2])) continue;
                this.setOpacity(nArray[i2], f2);
            }
        }
    }

    public void setPositionOnBackgroundLayers(int n, int n2, boolean bl) {
        int n3 = bl ? this.getTargetContextID() : hmiService.getDisplayManager().getCurrentContextID(this.terminal.getTerminalID());
        logDisplay.log(10000000, "DisplayControllerEvo#setPositionOnBackgroundLayers setting position on backgroundlayers for context: %1", (long)n3);
        int[] nArray = hmiService.getDisplayManager().getDisplayables(n3);
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (!this.isBackGroundLayer(nArray[i2])) continue;
                this.setPosition(nArray[i2], n, n2);
            }
        }
    }

    private boolean isBackGroundLayer(int n) {
        boolean bl = n != IDisplayManager.displayableMapping[0];
        bl &= n != IDisplayManager.displayableMapping[15];
        if (framework.getKombiType() == 4) {
            bl &= n != IDisplayManager.displayableMapping[4];
        } else if (framework.getKombiType() == 3) {
            bl &= n == IDisplayManager.displayableMapping[3] || n == IDisplayManager.displayableMapping[18];
        }
        return bl;
    }

    public int getTargetContextID() {
        if (this.model != null) {
            return ((ChoiceModelGUI)this.model).getValue();
        }
        if (this.modelID != -1) {
            HMIModel hMIModel = hmiService.getModel(this.terminal.getTerminalID(), this.modelID);
            if (hMIModel != null) {
                logDisplay.log(10000000, "DisplayControllerEvo#getTargetContextID returning explictely fetched model !!!!! ID = %1", (long)this.modelID);
                return ((ChoiceModelGUI)((Object)hMIModel)).getValue();
            }
        } else if (this.staticContext != -1) {
            return this.staticContext;
        }
        logDisplay.log(10000000, "DisplayControllerEvo#getTargetContextID no model present and no static context set, returning CONTEXT.HMI");
        return 0;
    }

    public void setPosition(int n, int n2, int n3) {
        logDisplay.log(10000000, "DisplayControllerEvo#setPosition displayable: %1, xPos: %2, yPos %3", (long)n, (long)n2, (long)n3);
        hmiService.getDisplayManager().setPosition(n, this.terminal.getTerminalID(), n2, n3);
    }

    public void setDisplayablePositions(int[][] nArray) {
        this.positionsOfDisplayables = nArray;
    }

    public void disconnecting() {
        if (this.maxOpacitiesSet != null) {
            for (int i2 = 0; i2 < this.maxOpacitiesSet.length; ++i2) {
                this.maxOpacitiesSet[i2] = false;
            }
        }
        this.backgroundOpacity = 1.0f;
        super.disconnecting();
    }

    public void predisconnecting() {
        AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)this.initContext.getScreen();
        if (abstractScreenWidget != null && (abstractScreenWidget.getScreenType() == 4 || abstractScreenWidget.getScreenType() == 14) && this.model != null) {
            ((ChoiceModelGUI)this.model).itemSelected(-3, this.terminal.getTerminalID());
        }
        super.predisconnecting();
    }

    public void setMaxOpacities(int[][] nArray) {
        this.maxOpacities = nArray;
        if (nArray != null) {
            if (nArray.length > 0 && nArray[0].length == 2) {
                this.maxOpacitiesSet = new boolean[nArray.length];
            } else {
                this.maxOpacities = null;
                logDisplay.log(10000, "DisplayControllerEvo#setMaxOpacities maxOpacities doesn't have right dimensions");
            }
        }
    }

    public void activeContext(int n, int n2) {
        if (this.model != null) {
            logDisplay.log(10000000, "DisplayControllerEvo#activeContext activeContext: %1, terminal: %2", (long)n, (long)n2);
            ((ChoiceModelGUI)this.model).itemSelected(n, n2);
        }
    }

    public void setStaticContext(int n) {
        this.staticContext = n;
    }

    public IRenderer getRenderer() {
        return null;
    }

    public void prepareAndSwitchToTargetContext() {
        if (this.preparedContext != this.getTargetContextID()) {
            this.prepareContextSwitch();
        }
        this.switchToTargetContext();
    }

    public IPresetPopupData getPresetPopupData() {
        return new PresetPopupData(0, -19456, new Preset(1, this.modelID, 0, null, null, 99), null, null, -1, null);
    }
}

