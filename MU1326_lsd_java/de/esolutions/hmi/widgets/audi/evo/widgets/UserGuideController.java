/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;

public class UserGuideController
extends AbstractWidgetController
implements AnimationListener {
    private static final String ANIMATIONPREFABPATH_DELETE = "Prefabs/ug_delete";
    private static final String ANIMATIONPREFABPATH_DELETE_AND_SPACE = "Prefabs/ug_delete_space";
    private static final String ANIMATIONPREFABPATH_EMPTY_FIELD = "Prefabs/ug_empty_textfield";
    private static final String ANIMATIONPREFABPATH_ASSUME_AUTOCOMPLETION = "Prefabs/ug_autocomplete_suggestion";
    private static final String ANIMATIONPREFABPATH_SPELLER_UMLAUTS = "Prefabs/ug_speller_umlauts";
    private static final String ANIMATIONPREFABPATH_CLOSE_SPELLER = "Prefabs/ug_close";
    private static final String ANIMATIONPREFABPATH_SPACE = "Prefabs/ug_space";
    private static final String ANIMATIONPREFABPATH_TEXT_INPUT = "Prefabs/ug_texteingabe";
    private static final String ANIMATIONPREFABPATH_MAP_UNLOCKED = "Prefabs/ug_map";
    private static final String ANIMATIONPREFABPATH_MAP_LOCKED = "Prefabs/ug_map_gesperrt";
    public static final int ANIMATION_ID_DELETE = 0;
    public static final int ANIMATION_ID_DELETE_SPACE = 1;
    public static final int ANIMATION_ID_CLOSE_SPELLER = 2;
    public static final int ANIMATION_ID_SPACE = 3;
    public static final int ANIMATION_ID_TEXT_INPUT = 4;
    public static final int ANIMATION_ID_EMPTY_FIELD = 5;
    public static final int ANIMATION_ID_ASSUME_AUTOCOMPLETION_SPELLER = 6;
    public static final int ANIMATION_ID_INITIAL_MAP_UNLOCKED = 7;
    public static final int ANIMATION_ID_SPELLER_UMLAUTS = 8;
    public static final int ANIMATION_ID_ASSUME_AUTOCOMPLETION_TOUCH = 9;
    public static final int ANIMATION_ID_INITIAL_MAP_LOCKED = 10;
    private static final int MAX_ANIMATION_COUNT = 3;
    IRenderer renderer = null;
    private AbstractAnimation userGuideAnimation;
    private float progress;
    private String animationPrefabPath;
    private int separatorYPos = -1;
    private int animYPos = 0;
    private int animXPos = 0;
    private int animationCounter = 0;
    private boolean closePopupAfterRunningAnimation = false;
    private boolean hasPointer = true;
    private boolean isMapHint = false;
    private int currentAnimationId = 99;
    private LabelController label1;
    private LabelController label2;
    private float fadeOutLabel2;
    private float fadeInLabel2;
    private float fadeOutLabel1;
    private float fadeInLabel1;

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    protected void initializeWidget() {
        this.closePopupAfterRunningAnimation = false;
        this.animationCounter = 0;
        if (this.isMapHint && this.getChildrenSize() > 1) {
            AbstractWidget abstractWidget = this.getChild(0);
            if (abstractWidget instanceof LabelController) {
                this.label1 = (LabelController)abstractWidget;
            } else {
                logUserHints.log(10000000, "UserGuideController#initializeWidget: child at position one is not a Labelcontroller. prefabPath=%1", (Object)this.animationPrefabPath);
            }
            abstractWidget = this.getChild(1);
            if (abstractWidget instanceof LabelController) {
                this.label2 = (LabelController)abstractWidget;
            } else {
                logUserHints.log(10000000, "UserGuideController#initializeWidget: child at position two is not a Labelcontroller. prefabPath=%1", (Object)this.animationPrefabPath);
            }
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        this.closeHint();
        super.keyPressed(keyEvent);
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        this.closeHint();
        super.keyTurned(wheelButtonEvent);
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.closeHint();
        super.touchPadPressed(touchEvent);
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        this.closeHint();
        super.touchPadPositionMoved(touchEvent);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        if (this.animationPrefabPath != ANIMATIONPREFABPATH_EMPTY_FIELD) {
            this.closeHint();
        }
        super.touchPadReleased(touchEvent);
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        this.closeHint();
        super.touchPadCharactersRecognized(touchEvent);
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        this.closeHint();
        super.keyMoved(joystickEvent);
    }

    private void closeHint() {
        if (this.isInitialHint()) {
            return;
        }
        if (this.parent instanceof PartialPopupController) {
            if (this.animationCounter == 0 && this.userGuideAnimation != null && this.userGuideAnimation.isAnimating()) {
                this.closePopupAfterRunningAnimation = true;
            } else {
                this.terminal.getPartialPopupManagerEvo().hidePopup(((PartialPopupController)this.parent).getID());
            }
        }
    }

    public void disconnecting() {
        if (this.userGuideAnimation != null && this.userGuideAnimation.isAnimating()) {
            this.userGuideAnimation.stopAnimation();
        }
        this.userGuideAnimation = null;
        super.disconnecting();
    }

    public void startAnimation() {
        if (this.userGuideAnimation == null) {
            this.userGuideAnimation = (AbstractAnimation)this.getTerminal().getIAnimationController().getIAnimation(this.currentAnimationId);
            this.userGuideAnimation.addListener(this);
        }
        if (framework.getSysApp().isStandstill()) {
            this.userGuideAnimation.startDynamicAnimation(0.0f, 1000.0f, this.currentAnimationId, false, this);
        } else {
            this.userGuideAnimation.startDynamicAnimation(1000.0f, 1000.0f, this.currentAnimationId, false, this);
        }
    }

    public void animate(int n, float f2) {
        if (n == this.currentAnimationId) {
            if (this.userGuideAnimation == null) {
                logUserHints.log(10000, "UserGuideController#animate: the user guide animation is null");
                return;
            }
            this.progress = (this.userGuideAnimation.getProgress() - 0.2f) / 0.8f;
            this.progress = Math.min(1.0f, this.progress);
            this.progress = Math.max(0.0f, this.progress);
            if (this.label1 != null) {
                this.label1.setOnScreen(this.progress <= this.fadeOutLabel1 || this.progress >= this.fadeInLabel1);
            }
            if (this.label2 != null) {
                this.label2.setOnScreen(this.progress <= this.fadeOutLabel2 || this.progress >= this.fadeInLabel2);
            }
            this.setCompositesDirty(true);
        }
    }

    public void animationStarted(int n, int n2) {
        this.progress = 0.0f;
    }

    public void animationFinished(int n, int n2) {
        this.progress = 1.0f;
        if (this.closePopupAfterRunningAnimation) {
            this.terminal.getPartialPopupManagerEvo().hidePopup(((PartialPopupController)this.parent).getID());
            this.animationCounter = 0;
            this.closePopupAfterRunningAnimation = false;
            return;
        }
        ++this.animationCounter;
        if (this.animationCounter < 3) {
            this.startAnimation();
        } else {
            this.animationCounter = 0;
        }
    }

    public float getAnimProgress() {
        return this.progress;
    }

    public boolean hasPointer() {
        return this.hasPointer;
    }

    protected void forceRepaintInPartialPopup() {
        super.forceRepaintInPartialPopup();
        this.startAnimation();
    }

    public String getAnimationPrefabPath() {
        return this.animationPrefabPath;
    }

    public void setAnimationId(int n) {
        switch (n) {
            case 0: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_DELETE;
                break;
            }
            case 1: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_DELETE_AND_SPACE;
                break;
            }
            case 2: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_CLOSE_SPELLER;
                break;
            }
            case 3: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_SPACE;
                break;
            }
            case 4: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_TEXT_INPUT;
                break;
            }
            case 5: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_EMPTY_FIELD;
                break;
            }
            case 6: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_ASSUME_AUTOCOMPLETION;
                break;
            }
            case 8: 
            case 9: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_SPELLER_UMLAUTS;
                break;
            }
            case 10: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_MAP_LOCKED;
                this.hasPointer = false;
                this.isMapHint = true;
                this.currentAnimationId = 102;
                this.fadeOutLabel2 = -0.1f;
                this.fadeInLabel2 = 0.42f;
                this.fadeOutLabel1 = 0.45f;
                this.fadeInLabel1 = 0.96f;
                break;
            }
            case 7: {
                this.animationPrefabPath = ANIMATIONPREFABPATH_MAP_UNLOCKED;
                this.hasPointer = false;
                this.isMapHint = true;
                this.currentAnimationId = 102;
                this.fadeOutLabel2 = 0.04f;
                this.fadeInLabel2 = 0.57f;
                this.fadeOutLabel1 = 0.59f;
                this.fadeInLabel1 = 0.97f;
                break;
            }
        }
    }

    public boolean isTouchpadKeypanelWithActiveStatus() {
        if (this.terminal != null && this.terminal.getKbdService() != null) {
            return this.terminal.getKbdService().isTouchKeypanel();
        }
        return false;
    }

    public void setSeparatorYPosition(int n) {
        this.separatorYPos = n;
    }

    public int getSeparatorYPosition() {
        return this.separatorYPos;
    }

    public void setAnimationPosition(int n, int n2) {
        this.animXPos = n;
        this.animYPos = n2;
    }

    public int getAnimationYPos() {
        return this.animYPos;
    }

    public int getAnimationXPos() {
        return this.animXPos;
    }

    public boolean isInitialHint() {
        return this.separatorYPos != -1;
    }

    public boolean isMapHint() {
        return this.isMapHint;
    }

    public boolean isInitialSpellerHint() {
        return this.isInitialHint() && !this.isMapHint();
    }
}

