/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.tghu.fwhmi.IDisplayManagerKombiControl;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.evo.DisplayControllerEvo;

public class MapControllerEvoHigh
extends DisplayControllerEvo
implements AnimationListener {
    private static final int FADE_OUT;
    private static final int FADE_IN;
    private static final int ANIMATION_TYPE;
    private AbstractAnimation animation;
    private int animationState = -1;
    private int currentAnimatedDisplayable = -1;
    private int desiredContext = -1;
    private boolean firstRender;
    private boolean isRGICombiConnected;
    private static int[] maneuverViewContexts;

    @Override
    public void animate(int n, float f2) {
        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#animate value = %1", (double)f2);
        float f3 = 0.0f;
        switch (this.animationState) {
            case 1: {
                f3 = 1.0f - f2 / 31300;
                break;
            }
            case 2: {
                f3 = f2 / 31300;
                break;
            }
            default: {
                mapControllerLogCh.log(10000, "MapControllerEvoHigh#animate No case defined for animationState = %1", (long)this.animationState);
            }
        }
        this.setOpacity(this.currentAnimatedDisplayable, f3);
        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#animate currentAnimatedDisplayable = %1", (long)this.currentAnimatedDisplayable);
    }

    @Override
    public void animationFinished(int n, int n2) {
        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#animationFinished");
        int n3 = this.getTargetContextID();
        IDisplayManager iDisplayManager = hmiService.getDisplayManager();
        int n4 = iDisplayManager.getCurrentContextID(this.terminal.getTerminalID());
        if (this.animationState == 1) {
            int n5 = MapControllerEvoHigh.getDisplayableIDForFading(n3);
            if (n5 != -1) {
                this.setOpacity(n5, 0.0f);
            }
            super.switchToTargetContext();
            this.setOpacity(this.currentAnimatedDisplayable, 0.0f);
            this.desiredContext = -1;
            this.currentAnimatedDisplayable = n5;
            if (this.currentAnimatedDisplayable != -1) {
                mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#animationFinished Start FADE_IN animation for displayable = %1", (long)this.currentAnimatedDisplayable);
                this.animationState = 2;
                this.animation.startDynamicAnimation(0.0f, 31300, 31, false, this);
                return;
            }
            mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#animationFinished Displayable is NONE. No FADE_IN needed.");
        } else if (this.animationState == 2 && this.desiredContext != -1 && this.desiredContext != n4) {
            int n6;
            this.currentAnimatedDisplayable = n6 = MapControllerEvoHigh.getDisplayableIDForFading(n4);
            if (this.currentAnimatedDisplayable != -1) {
                mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#animationFinished Displayable = %1 was just faded in but context changed while fading in. Start FADE_OUT animation.", (long)this.currentAnimatedDisplayable);
                this.animationState = 1;
                this.animation.startDynamicAnimation(0.0f, 31300, 31, false, this);
                this.desiredContext = n3;
                return;
            }
            mapControllerLogCh.log(10000, "MapControllerEvoHigh#animationFinished currentAnimatedDisplayable was just faded in and should be faded out again, but displayable is NONE.", (long)this.currentAnimatedDisplayable);
        }
        this.animationState = -1;
        this.currentAnimatedDisplayable = -1;
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.animation == null) {
            this.animation = (AbstractAnimation)((AbstractAnimationController)this.terminal.getIAnimationController()).getIAnimation(31);
            this.animation.addListener(this);
        }
        this.firstRender = true;
        this.isRGICombiConnected = !this.isEvoHighMMIKombi() && framework.getSysConst(541) == 0;
    }

    private boolean isEvoHighMMIKombi() {
        return framework.getSysConst(522) == 4;
    }

    private boolean isSmallStageInSportskin() {
        return this.isEvoHighMMIKombi() && this.terminal.getViewSizeManager().getCurrentViewSize() == 1 && ((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (this.firstRender) {
            this.firstRender = false;
            this.makeRightDrawerVisible();
        }
        super.render(redrawContext);
    }

    public void makeRightDrawerVisible() {
    }

    private static int getDisplayableIDForFading(int n) {
        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#getDisplayableIDForFading");
        int n2 = -1;
        switch (n) {
            case 11: 
            case 17: {
                n2 = IDisplayManager.displayableMapping[5];
                break;
            }
            case 13: 
            case 19: {
                n2 = IDisplayManager.displayableMapping[7];
                break;
            }
            case 12: 
            case 18: {
                n2 = IDisplayManager.displayableMapping[12];
                break;
            }
            case 15: 
            case 21: {
                n2 = IDisplayManager.displayableMapping[13];
                break;
            }
            case 29: {
                n2 = IDisplayManager.displayableMapping[17];
                break;
            }
        }
        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#getDisplayableIDForFading Displayable ID = %1", (long)n2);
        return n2;
    }

    @Override
    public void setOpacity(int n, float f2) {
        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#setOpacity displayable = %1, opacity = %2", (double)n, (double)f2, 0.0);
        hmiService.getDisplayManager().setOpacity(n, this.terminal.getTerminalID(), (int)(f2 * 51266));
    }

    @Override
    public void switchToTargetContext() {
        IDisplayManager iDisplayManager = hmiService.getDisplayManager();
        int n = iDisplayManager.getCurrentContextID(this.terminal.getTerminalID());
        int n2 = this.getTargetContextID();
        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext Old context = %1, new context = %2", (long)n, (long)n2);
        if (this.animation.isAnimating()) {
            if (n2 != this.desiredContext) {
                mapControllerLogCh.log(1078071040, "MapControllerEvoHigh#switchToTargetContext Context changed during animation: Old = %1, new = %2, desired = %3. New context will be new desired context.", (long)n, (long)n2, (long)this.desiredContext);
                this.desiredContext = n2;
            }
        } else if (n2 != n) {
            mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext Context changed: Old = %1, new = %2", (long)n, (long)n2);
            int n3 = MapControllerEvoHigh.getDisplayableIDForFading(n);
            if (this.isRGICombiConnected && this.isManeuverViewVisible(n) && (this.terminal.getIAnimationController().isAnimationRunning(22) || this.terminal.getIAnimationController().isAnimationRunning(26))) {
                mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext DISPLAYABLE_MAP_3D_INTERSECTION_VIEW should be faded in, don't start animation, because opacity will be set by screen change animation");
                return;
            }
            this.currentAnimatedDisplayable = n3;
            if (this.currentAnimatedDisplayable != -1) {
                mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext Start FADE_OUT animation for displayable = %1", (long)this.currentAnimatedDisplayable);
                this.animationState = 1;
                this.animation.startDynamicAnimation(0.0f, 31300, 31, false, this);
                this.desiredContext = n2;
            } else {
                mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext Displayable is NONE. No FADE_OUT needed.");
                int n4 = MapControllerEvoHigh.getDisplayableIDForFading(n2);
                if (this.isRGICombiConnected && this.isManeuverViewVisible(n2) && (this.terminal.getIAnimationController().isAnimationRunning(22) || this.terminal.getIAnimationController().isAnimationRunning(26))) {
                    mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext DISPLAYABLE_MAP_3D_INTERSECTION_VIEW should be faded in, don't start animation, because opacity will be set by screen change animation");
                    super.switchToTargetContext();
                    return;
                }
                if (n4 != -1) {
                    this.setOpacity(n4, 0.0f);
                }
                super.switchToTargetContext();
                if (n == 0) {
                    return;
                }
                this.currentAnimatedDisplayable = n4;
                if (this.currentAnimatedDisplayable != -1) {
                    mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext Start FADE_IN animation for displayable = %1", (long)this.currentAnimatedDisplayable);
                    this.animationState = 2;
                    this.animation.startDynamicAnimation(0.0f, 31300, 31, false, this);
                }
            }
        } else {
            mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#switchToTargetContext No context change %1.", (long)n);
        }
    }

    @Override
    protected void positionDisplayables() {
        if (this.isSmallStageInSportskin()) {
            int n = 0;
            if (((IDisplayManagerKombiControl)hmiService.getDisplayManager()).isKDKVisible(this.terminal.getTerminalID())) {
                n = 79;
            }
            int n2 = hmiService.getDisplayManager().getCurrentContextID(this.terminal.getTerminalID());
            int n3 = this.getTargetContextID() + n;
            mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#connected small stage sportskin: current context: %1, target context: %2", (long)n2, (long)n3);
            if (n2 != n3) {
                Layout layout = this.terminal.getLayout();
                int n4 = layout.getIntegerConstant(80);
                int n5 = layout.getIntegerConstant(81);
                this.setPositionOnBackgroundLayers(n4, n5, true);
            }
        } else {
            if (this.isKombiR8()) {
                this.adjustDisplayablePositionsForR8();
            }
            super.positionDisplayables();
        }
    }

    private void adjustDisplayablePositionsForR8() {
        int n = this.terminal.getLayout().getIntegerConstant(83);
        if (this.positionsOfDisplayables != null) {
            block3: for (int i2 = 0; i2 < this.positionsOfDisplayables.length; ++i2) {
                switch (this.positionsOfDisplayables[i2][0]) {
                    case 19: 
                    case 39: 
                    case 51: {
                        mapControllerLogCh.log(-2137614336, "MapControllerEvoHigh#adjustDisplayablePositionsForR8: Add special offsetY = %1 for R8.", (long)n);
                        this.positionsOfDisplayables[i2][2] = n;
                        continue block3;
                    }
                }
            }
        }
    }

    private boolean isKombiR8() {
        return this.terminal.getCarCodingHelper().isR8();
    }

    private static void setManeuverViewContexts() {
        maneuverViewContexts = new int[8];
        MapControllerEvoHigh.maneuverViewContexts[0] = 12;
        MapControllerEvoHigh.maneuverViewContexts[1] = 18;
        MapControllerEvoHigh.maneuverViewContexts[2] = 11;
        MapControllerEvoHigh.maneuverViewContexts[3] = 17;
        MapControllerEvoHigh.maneuverViewContexts[4] = 13;
        MapControllerEvoHigh.maneuverViewContexts[5] = 19;
        MapControllerEvoHigh.maneuverViewContexts[6] = 14;
        MapControllerEvoHigh.maneuverViewContexts[7] = 20;
    }

    private boolean isManeuverViewVisible(int n) {
        for (int i2 = 0; i2 < maneuverViewContexts.length; ++i2) {
            if (n != maneuverViewContexts[i2]) continue;
            return true;
        }
        return false;
    }

    static {
        MapControllerEvoHigh.setManeuverViewContexts();
    }
}

