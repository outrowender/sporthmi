/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController;

public class SelectionMenuController$Gap
implements AnimationListener {
    private static final float SUB_POS_OPEN;
    private static final float SUB_POS_CLOSE;
    private float subPos;
    private static final int ANIMATION_TYPE;
    private AbstractAnimation gapAanimation;
    private AbstractPlaceholderMenuController$PlaceholderItemEntry currentItemEntry;
    private AbstractPlaceholderMenuController$PlaceholderItemEntry nextItemEntry;
    private final /* synthetic */ SelectionMenuController this$0;

    protected SelectionMenuController$Gap(SelectionMenuController selectionMenuController) {
        this.this$0 = selectionMenuController;
    }

    protected AbstractAnimation getGapAnimation() {
        if (this.gapAanimation != null) {
            return this.gapAanimation;
        }
        this.gapAanimation = (AbstractAnimation)this.this$0.getAnimationController().getIAnimation(88);
        this.gapAanimation.addListener(this);
        return this.gapAanimation;
    }

    public void setMainItemEntry(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, boolean bl, boolean bl2, boolean bl3) {
        float f2;
        float f3;
        int n;
        SelectionMenuController.access$000().log(1078071040, "SelectionMenuController#setMainItemEntry current=%1, itemEntry=%2, animate=%3, open=%4", (Object)this.currentItemEntry, (Object)abstractPlaceholderMenuController$PlaceholderItemEntry, (Object)bl, (Object)bl2);
        boolean bl4 = abstractPlaceholderMenuController$PlaceholderItemEntry == null ? false : (!bl2 ? false : (n = this.this$0.getConnectedSubItems(abstractPlaceholderMenuController$PlaceholderItemEntry)) > 0);
        SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#setMainItemEntry targetSubistFocused=%1", bl4);
        float f4 = f3 = bl4 ? 1.0f : 0.0f;
        if (bl4) {
            if (this.this$0.subSelectionCursor.getTargetItemEntry() == null) {
                this.this$0.subFocusCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry.getFirstSubItem(), 0.0f, bl);
            } else {
                this.this$0.subFocusCursor.setTargetItemEntry(this.this$0.subSelectionCursor.getTargetItemEntry(), 0.0f, bl);
            }
        } else {
            this.this$0.subFocusCursor.setTargetItemEntry(null, 0.0f, false);
        }
        AbstractAnimation abstractAnimation = this.getGapAnimation();
        if (!bl) {
            if (abstractAnimation.isAnimating()) {
                abstractAnimation.stopAnimation();
            }
            SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#setMainItemEntry not animating -> setting currentItemEntry to %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
            this.currentItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry;
            SelectionMenuController.access$102(this.this$0, abstractPlaceholderMenuController$PlaceholderItemEntry);
            this.nextItemEntry = null;
            this.subPos = f3;
            SelectionMenuController.access$202(this.this$0, bl4);
            SelectionMenuController.access$302(this.this$0, false);
            this.updateAnimationValues(this.subPos);
            if (bl4) {
                this.this$0.joinSubCursor(false);
            }
            this.currentItemEntry = null;
            return;
        }
        if (this.currentItemEntry == null) {
            SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#setMainItemEntry currentItemEntry not set -> setting currentItemEntry to %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
            this.subPos = 0.0f;
            this.nextItemEntry = null;
            if (abstractAnimation.isAnimating()) {
                SelectionMenuController.access$000().log(-1601830656, "SelectionMenuController#setMainItemEntry currentItemEntry not set but animating");
                abstractAnimation.stopAnimation();
            }
            if (!bl2 || abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
                SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#setMainItemEntry already closed");
                SelectionMenuController.access$202(this.this$0, false);
                SelectionMenuController.access$102(this.this$0, null);
                return;
            }
            this.currentItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry;
            SelectionMenuController.access$102(this.this$0, abstractPlaceholderMenuController$PlaceholderItemEntry);
            SelectionMenuController.access$202(this.this$0, true);
            this.this$0.joinCursor(false);
            SelectionMenuController.access$000().log(1078071040, "SelectionMenuController#setMainItemEntry opening sublist");
            abstractAnimation.startDynamicAnimation(0.0f, 1.0f, 88, true, this.this$0);
            if (bl3) {
                SelectionMenuController.access$400(this.this$0).restartTimer();
            }
            return;
        }
        if (this.currentItemEntry.equals(abstractPlaceholderMenuController$PlaceholderItemEntry)) {
            f2 = f3;
            this.nextItemEntry = null;
        } else {
            f2 = 0.0f;
            this.nextItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry;
        }
        if (abstractAnimation.isAnimating()) {
            if (f2 == abstractAnimation.getTarget()) {
                SelectionMenuController.access$000().log(1078071040, "SelectionMenuController#setMainItemEntry keeping sublist animation target %1, current value %2", (Object)String.valueOf(f2), (Object)String.valueOf(abstractAnimation.getValue()));
            } else {
                SelectionMenuController.access$000().log(1078071040, "SelectionMenuController#setMainItemEntry changing sublist animation target from %1 to %2, current value %3", (double)abstractAnimation.getTarget(), (double)f2, (double)abstractAnimation.getValue());
                abstractAnimation.setTarget(f2);
            }
        } else {
            SelectionMenuController.access$000().log(1078071040, "SelectionMenuController#setMainItemEntry starting sublist animation from %1 to %2", (Object)String.valueOf(this.subPos), (Object)String.valueOf(f2));
            abstractAnimation.startDynamicAnimation(this.subPos, f2, 88, true, this.this$0);
            if (this.subPos == 1.0f && f2 == 0.0f) {
                SelectionMenuController.access$400(this.this$0).cancelTimer();
            }
        }
    }

    public float getSubPosition() {
        return this.subPos;
    }

    @Override
    public void animate(int n, float f2, int n2) {
        if (SelectionMenuController.access$000().isDebug()) {
            SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animate value=%1, type=%2", (Object)new Float(f2), (long)n);
        }
        this.updateAnimationValues(f2);
    }

    private void updateAnimationValues(float f2) {
        SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#updateAnimationValues value=%1", (double)f2);
        if (this.currentItemEntry == null) {
            SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#updateAnimationValues currentItemEntry is null");
            this.subPos = 0.0f;
        } else {
            this.subPos = f2;
        }
        this.this$0.updateSubPositions();
        this.this$0.adjustSubViewport(true);
        this.this$0.assignSubSlots();
        this.this$0.setCompositesDirty(true);
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animationFinished current=%1, target=%2", (Object)this.currentItemEntry, (Object)this.nextItemEntry);
        AbstractAnimation abstractAnimation = this.getGapAnimation();
        if (this.nextItemEntry == null) {
            float f2 = abstractAnimation.getTarget();
            SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animationFinished animation target: %1", (Object)String.valueOf(f2));
            if (f2 == 0.0f) {
                if (this.currentItemEntry != null && !this.currentItemEntry.isSelected()) {
                    SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animationFinished sublist closed, removing subitems");
                    SelectionMenuController.access$500(this.this$0, this.currentItemEntry);
                }
                SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animationFinished sublist closed and no nextItemEntry -> setting currentItemEntry to null");
                this.currentItemEntry = null;
                SelectionMenuController.access$102(this.this$0, null);
                SelectionMenuController.access$202(this.this$0, false);
                SelectionMenuController.access$302(this.this$0, false);
                this.updateAnimationValues(0.0f);
            } else {
                SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animationFinished sublist opened");
                this.updateAnimationValues(f2);
            }
        } else {
            if (this.currentItemEntry != null && !this.currentItemEntry.isSelected()) {
                SelectionMenuController.access$500(this.this$0, this.currentItemEntry);
            }
            int n3 = this.this$0.getConnectedSubItems(this.nextItemEntry);
            SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animationFinished sublist closed and nextItemEntry set -> setting currentItemEntry %1, subitems=%2", (Object)this.nextItemEntry, (long)n3);
            if (n3 > 0) {
                SelectionMenuController.access$000().log(-2137614336, "SelectionMenuController#Gap#animationFinished opening sublist");
                this.currentItemEntry = this.nextItemEntry;
                SelectionMenuController.access$102(this.this$0, this.currentItemEntry);
                this.nextItemEntry = null;
                SelectionMenuController.access$202(this.this$0, true);
                abstractAnimation.startDynamicAnimation(0.0f, 1.0f, 88, true, this.this$0);
            } else {
                this.nextItemEntry = null;
                this.currentItemEntry = null;
                SelectionMenuController.access$102(this.this$0, null);
                SelectionMenuController.access$202(this.this$0, false);
            }
        }
        this.this$0.setCompositesDirty(true);
    }

    static /* synthetic */ AbstractAnimation access$600(SelectionMenuController$Gap selectionMenuController$Gap) {
        return selectionMenuController$Gap.gapAanimation;
    }

    static /* synthetic */ AbstractAnimation access$602(SelectionMenuController$Gap selectionMenuController$Gap, AbstractAnimation abstractAnimation) {
        selectionMenuController$Gap.gapAanimation = abstractAnimation;
        return selectionMenuController$Gap.gapAanimation;
    }
}

