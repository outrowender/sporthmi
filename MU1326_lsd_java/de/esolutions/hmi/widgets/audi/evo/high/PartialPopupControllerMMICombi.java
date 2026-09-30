/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.interapp.combi.bap.data.PartialPopupBAPContent;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerMMICombi;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PartialPopupRendererMMICombi;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class PartialPopupControllerMMICombi
extends AbstractPartialPopupController
implements AnimationListener {
    private int priority = 0;
    private int context = 0;
    private int initialCursorPosition = 0;
    private MenuItemController[] options;
    private int[] optionTypes;
    private LabelController[] titles;
    private int icon = 0;
    private int maximumDisplayTime = 0;
    private LogChannel logPPMMICombi = IWidgetLogChannel.logChannelPPMMICombi;
    private PartialPopupRendererMMICombi renderer;
    private AbstractAnimation showHideAnimation;
    private static final float ANIMATION_OPACITY_NONE = 0.0f;
    private static final float ANIMATION_OPACITY_FULL = 1.0f;
    private static final boolean USE_SMALL_STAGE_TEXT = true;
    private boolean hideOnOptionSelected = false;
    private boolean fireEventOnOptionSelected = false;

    public PartialPopupControllerMMICombi() {
    }

    public PartialPopupControllerMMICombi(int n) {
        super(n);
    }

    public HMIView[][] getReplacementWidgets() {
        return this.replacementWidgets;
    }

    public void hideNotScreenChangeSurvivingPopups() {
    }

    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    public void shiftHorizontal(int n) {
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(PartialPopupRendererMMICombi partialPopupRendererMMICombi) {
        this.renderer = partialPopupRendererMMICombi;
    }

    public int show(int n) {
        this.logPPMMICombi.log(1000000, "PartialPopupControllerMMICombi#show id: %1", (long)this.getID());
        if (!this.isEnabled()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(10000000, "PartialPopupControllerMMICombi#show not showing partial popup with ID %1 because it is disabled", (Object)this.getPopupName());
            return 2;
        }
        if (!this.isPopupActive()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(10000000, "PartialPopupControllerMMICombi#show not showing partial popup with ID %1 because it is inactive", (Object)this.getPopupName());
            return 2;
        }
        PartialPopupBAPContent partialPopupBAPContent = new PartialPopupBAPContent(this.priority, this.context, this.getTitleText());
        partialPopupBAPContent.setInitialCursorPosition(this.initialCursorPosition);
        partialPopupBAPContent.setIcon(this.icon);
        if (this.maximumDisplayTime == 0 && this.autoHideTime > 0) {
            this.maximumDisplayTime = this.autoHideTime / 1000;
        }
        partialPopupBAPContent.setMaximumDisplayTime(this.maximumDisplayTime);
        this.setSelectionOptions(partialPopupBAPContent);
        if (this.greyOutBackground) {
            this.startBackgroundAnimation(true);
            if (this.terminal != null && ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager() != null) {
                int n2 = this.getlayer() == 0 ? 1 : 0;
                ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().setDesaturationRequest(1.0f, n2);
            }
        }
        this.popupManager.popupVisible(this.popupID);
        return ((PartialPopupManagerMMICombi)this.popupManager).showPPViaBAP(this.getID(), partialPopupBAPContent);
    }

    private void setSelectionOptions(PartialPopupBAPContent partialPopupBAPContent) {
        if (this.options != null) {
            int n = 0;
            for (int i2 = 0; i2 < this.options.length; ++i2) {
                if (!this.options[i2].isVisible()) continue;
                if (n >= 4) {
                    this.logPPMMICombi.log(10000, "PartialPopupControllerMMICombi#show more than 4 options visible");
                    break;
                }
                this.setSelectionOption(partialPopupBAPContent, n, i2);
                ++n;
            }
        }
    }

    private String getTitleText() {
        String string = "";
        if (this.titles != null) {
            for (int i2 = 0; i2 < this.titles.length; ++i2) {
                if (!this.titles[i2].isVisible()) continue;
                string = this.titles[i2].getText();
                break;
            }
        }
        return string;
    }

    private void setSelectionOption(PartialPopupBAPContent partialPopupBAPContent, int n, int n2) {
        String string = null;
        int n3 = 0;
        if (this.optionTypes != null && this.optionTypes.length > n2) {
            n3 = this.optionTypes[n2];
            if (this.optionTypes[n2] == 255) {
                string = this.options[n2].getMainLabelText();
            }
        }
        switch (n) {
            case 0: {
                partialPopupBAPContent.setSelectionOption1(n2, n3, string);
                break;
            }
            case 1: {
                partialPopupBAPContent.setSelectionOption2(n2, n3, string);
                break;
            }
            case 2: {
                partialPopupBAPContent.setSelectionOption3(n2, n3, string);
                break;
            }
            case 3: {
                partialPopupBAPContent.setSelectionOption4(n2, n3, string);
                break;
            }
        }
    }

    public int hide(int n) {
        this.logPPMMICombi.log(1000000, "PartialPopupControllerMMICombi#hide id: %1", (long)this.getID());
        if (!this.isEnabled()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(10000000, "PartialPopupControllerMMICombi#hide not showing or hiding partial popup with ID %1 because it is disabled", (Object)this.getPopupName());
            return 2;
        }
        if (!this.isPopupActive()) {
            AbstractPartialPopupManager.LOGPOPUPS.log(10000000, "PartialPopupControllerMMICombi#hide not showing or hiding partial popup with ID %1 because it is inactive", (Object)this.getPopupName());
            return 2;
        }
        if (this.greyOutBackground) {
            if (this.terminal != null && ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager() != null) {
                int n2 = this.getlayer() == 0 ? 1 : 0;
                ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().setDesaturationRequest(0.0f, n2);
            }
            this.startBackgroundAnimation(false);
        }
        if (this.popupManager != null) {
            this.popupManager.popupHidden(this.popupID);
        }
        return ((PartialPopupManagerMMICombi)this.popupManager).hidePPViaBAP(this.getID());
    }

    public boolean isBgGreyOutDeactive() {
        return this.tempGrayOut && !this.greyOutBackground;
    }

    private void startBackgroundAnimation(boolean bl) {
        if (this.showHideAnimation == null) {
            this.showHideAnimation = (AbstractAnimation)this.terminal.getIAnimationController().getIAnimation(72);
            this.showHideAnimation.addListener(this);
        }
        if (this.showHideAnimation.isAnimating()) {
            if (bl) {
                this.showHideAnimation.setTarget(1.0f);
            } else {
                this.showHideAnimation.setTarget(0.0f);
            }
        } else if (bl) {
            this.showHideAnimation.startDynamicAnimation(0.0f, 1.0f, 72, false, this);
        } else {
            this.showHideAnimation.startDynamicAnimation(1.0f, 0.0f, 72, false, this);
        }
    }

    public void optionSelected(int n) {
        this.logPPMMICombi.log(10000000, "PartialPopupControllerMMICombi#option selected id: %1, option: %2", (long)this.getID(), (long)n);
        if (this.options != null && n >= 0 && n < this.options.length) {
            KeyEvent keyEvent = new KeyEvent(null, 10401, 17, this.terminal.getTerminalID());
            this.options[n].keyPressed(keyEvent);
            if (this.hideOnOptionSelected) {
                this.popupManager.hidePopup(this.popupID);
            }
            if (this.fireEventOnOptionSelected) {
                this.logPPMMICombi.log(10000000, "PartialPopupControllerMMICombi#option selected firing event");
                this.fireSMEvent(this.terminal.getTerminalID(), this.event);
            }
        }
    }

    public void setPriority(int n) {
        this.priority = n;
    }

    public void setContext(int n) {
        this.context = n;
    }

    public void setInitialCursorPosition(int n) {
        this.initialCursorPosition = n;
    }

    public void setTitles(LabelController[] labelControllerArray) {
        if (labelControllerArray != null) {
            for (int i2 = 0; i2 < labelControllerArray.length; ++i2) {
                if (labelControllerArray[i2] == null) continue;
                labelControllerArray[i2].setUseSmallStageText(true);
            }
        }
        this.titles = labelControllerArray;
    }

    public void setIcon(int n) {
        this.icon = n;
    }

    public void setMaximumDisplayTime(int n) {
        this.maximumDisplayTime = n;
    }

    public void setOptionTypes(int[] nArray) {
        this.optionTypes = nArray;
    }

    public void setOptions(MenuItemController[] menuItemControllerArray) {
        if (menuItemControllerArray != null) {
            for (int i2 = 0; i2 < menuItemControllerArray.length; ++i2) {
                if (menuItemControllerArray[i2] == null) continue;
                menuItemControllerArray[i2].setUseSmallStageTextForMainLabel(true);
            }
        }
        this.options = menuItemControllerArray;
    }

    protected void propagatePaint(RedrawContext redrawContext) {
    }

    public void setDynamicSize(boolean bl) {
    }

    public void setContentInset(int n) {
    }

    public void setBackgroundController(AbstractWidgetController abstractWidgetController) {
        super.add(abstractWidgetController);
    }

    public void setColorPalettes(int[][] nArray) {
    }

    public void activateBackgroundGrayOut() {
    }

    public void deactivateBackgroundGrayOut() {
    }

    public void animate(int n, float f2) {
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
    }

    public void setGreyOutBackground(boolean bl) {
    }

    public void setConsumeHKAppChange(int n) {
    }

    public void setConsumeHKReturn(int n) {
    }

    public void setConsumeDDSPress(int n) {
        if (n == 3 || n == 7) {
            this.fireEventOnOptionSelected = true;
        }
        if (n == 1 || n == 6 || n == 8 || n == 7) {
            this.hideOnOptionSelected = true;
        }
    }

    public void setConsumeKeyTurned(int n) {
    }

    public void setConsumeSKPress(int n) {
    }

    public void setConsumeTouchPad(int n) {
    }

    public void setConsumeGenericKeys(int n, int[] nArray) {
    }

    public void setConsumeJoystickNorth(int n) {
    }

    public void setConsumeJoystickEast(int n) {
    }

    public void setConsumeJoystickSouth(int n) {
    }

    public void setConsumeJoystickWest(int n) {
    }
}

