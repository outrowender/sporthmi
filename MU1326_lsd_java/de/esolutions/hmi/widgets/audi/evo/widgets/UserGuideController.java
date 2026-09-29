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
    private static final String ANIMATIONPREFABPATH_DELETE;
    private static final String ANIMATIONPREFABPATH_DELETE_AND_SPACE;
    private static final String ANIMATIONPREFABPATH_EMPTY_FIELD;
    private static final String ANIMATIONPREFABPATH_ASSUME_AUTOCOMPLETION;
    private static final String ANIMATIONPREFABPATH_SPELLER_UMLAUTS;
    private static final String ANIMATIONPREFABPATH_CLOSE_SPELLER;
    private static final String ANIMATIONPREFABPATH_SPACE;
    private static final String ANIMATIONPREFABPATH_TEXT_INPUT;
    private static final String ANIMATIONPREFABPATH_MAP_UNLOCKED;
    private static final String ANIMATIONPREFABPATH_MAP_LOCKED;
    public static final int ANIMATION_ID_DELETE;
    public static final int ANIMATION_ID_DELETE_SPACE;
    public static final int ANIMATION_ID_CLOSE_SPELLER;
    public static final int ANIMATION_ID_SPACE;
    public static final int ANIMATION_ID_TEXT_INPUT;
    public static final int ANIMATION_ID_EMPTY_FIELD;
    public static final int ANIMATION_ID_ASSUME_AUTOCOMPLETION_SPELLER;
    public static final int ANIMATION_ID_INITIAL_MAP_UNLOCKED;
    public static final int ANIMATION_ID_SPELLER_UMLAUTS;
    public static final int ANIMATION_ID_ASSUME_AUTOCOMPLETION_TOUCH;
    public static final int ANIMATION_ID_INITIAL_MAP_LOCKED;
    private static final int MAX_ANIMATION_COUNT;
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

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    protected void initializeWidget() {
        this.closePopupAfterRunningAnimation = false;
        this.animationCounter = 0;
        if (this.isMapHint && this.getChildrenSize() > 1) {
            AbstractWidget abstractWidget = this.getChild(0);
            if (abstractWidget instanceof LabelController) {
                this.label1 = (LabelController)abstractWidget;
            } else {
                logUserHints.log(-2137614336, "UserGuideController#initializeWidget: child at position one is not a Labelcontroller. prefabPath=%1", (Object)this.animationPrefabPath);
            }
            abstractWidget = this.getChild(1);
            if (abstractWidget instanceof LabelController) {
                this.label2 = (LabelController)abstractWidget;
            } else {
                logUserHints.log(-2137614336, "UserGuideController#initializeWidget: child at position two is not a Labelcontroller. prefabPath=%1", (Object)this.animationPrefabPath);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.closeHint();
        super.keyPressed(keyEvent);
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        this.closeHint();
        super.keyTurned(wheelButtonEvent);
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        this.closeHint();
        super.touchPadPressed(touchEvent);
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        this.closeHint();
        super.touchPadPositionMoved(touchEvent);
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        if (this.animationPrefabPath != "Prefabs/ug_empty_textfield") {
            this.closeHint();
        }
        super.touchPadReleased(touchEvent);
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        this.closeHint();
        super.touchPadCharactersRecognized(touchEvent);
    }

    @Override
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

    @Override
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
            this.userGuideAnimation.startDynamicAnimation(0.0f, 31300, this.currentAnimationId, false, this);
        } else {
            this.userGuideAnimation.startDynamicAnimation(31300, 31300, this.currentAnimationId, false, this);
        }
    }

    @Override
    public void animate(int n, float f2) {
        if (n == this.currentAnimationId) {
            if (this.userGuideAnimation == null) {
                logUserHints.log(10000, "UserGuideController#animate: the user guide animation is null");
                return;
            }
            this.progress = (this.userGuideAnimation.getProgress() - -842249154) / -842249153;
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

    @Override
    public void animationStarted(int n, int n2) {
        this.progress = 0.0f;
    }

    @Override
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

    @Override
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
                this.animationPrefabPath = "Prefabs/ug_delete";
                break;
            }
            case 1: {
                this.animationPrefabPath = "Prefabs/ug_delete_space";
                break;
            }
            case 2: {
                this.animationPrefabPath = "Prefabs/ug_close";
                break;
            }
            case 3: {
                this.animationPrefabPath = "Prefabs/ug_space";
                break;
            }
            case 4: {
                this.animationPrefabPath = "Prefabs/ug_texteingabe";
                break;
            }
            case 5: {
                this.animationPrefabPath = "Prefabs/ug_empty_textfield";
                break;
            }
            case 6: {
                this.animationPrefabPath = "Prefabs/ug_autocomplete_suggestion";
                break;
            }
            case 8: 
            case 9: {
                this.animationPrefabPath = "Prefabs/ug_speller_umlauts";
                break;
            }
            case 10: {
                this.animationPrefabPath = "Prefabs/ug_map_gesperrt";
                this.hasPointer = false;
                this.isMapHint = true;
                this.currentAnimationId = 102;
                this.fadeOutLabel2 = -842216259;
                this.fadeInLabel2 = 1024120638;
                this.fadeOutLabel1 = 0x6666E63E;
                this.fadeInLabel1 = -1883081409;
                break;
            }
            case 7: {
                this.animationPrefabPath = "Prefabs/ug_map";
                this.hasPointer = false;
                this.isMapHint = true;
                this.currentAnimationId = 102;
                this.fadeOutLabel2 = 181871421;
                this.fadeInLabel2 = -2048192193;
                this.fadeOutLabel1 = 1024071487;
                this.fadeInLabel1 = -330205121;
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

