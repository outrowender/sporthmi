/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$AnimatedFloatProperty;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;

public class AbstractPlaceholderMenuController$Cursor
implements AnimationListener {
    private static final int CURSOR_ANIMATION_TARGET;
    private final int cursorAnimationType;
    private float relativePosition;
    private float startPosition;
    private float hddsOffset;
    private AbstractPlaceholderMenuController$PlaceholderItemEntry targetItemEntry;
    private AbstractAnimation cursorAnimation;
    private final boolean crop;
    private final boolean isSubCursor;
    private final AbstractPlaceholderMenuController$AnimatedFloatProperty cursorWidth = new AbstractPlaceholderMenuController$AnimatedFloatProperty(0.0f);
    private boolean targetWidthInitialized;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    public AbstractPlaceholderMenuController$Cursor(AbstractPlaceholderMenuController abstractPlaceholderMenuController, int n, boolean bl, boolean bl2) {
        this.this$0 = abstractPlaceholderMenuController;
        this.isSubCursor = bl2;
        this.cursorAnimationType = n;
        this.crop = bl;
    }

    public AbstractPlaceholderMenuController$PlaceholderItemEntry getTargetItemEntry() {
        return this.targetItemEntry;
    }

    public void setTargetItemEntry(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        if (!Util.equals(this.targetItemEntry, abstractPlaceholderMenuController$PlaceholderItemEntry)) {
            this.targetWidthInitialized = false;
        }
        this.targetItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry;
    }

    public void disconnect() {
        if (this.cursorAnimation != null && this.cursorAnimation.isAnimating()) {
            this.cursorAnimation.stopAnimation();
        }
        this.cursorAnimation = null;
        this.targetWidthInitialized = false;
        this.cursorWidth.setUnanimatedValue(0.0f);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Cursor [relativePosition=");
        buffer.append(this.relativePosition);
        buffer.append(", targetPosition=");
        buffer.append(this.targetItemEntry);
        buffer.append("]");
        return buffer.toString();
    }

    private AbstractAnimation getCursorAnimation() {
        if (this.cursorAnimation != null) {
            return this.cursorAnimation;
        }
        if (this.cursorAnimationType < 0) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(10000, "AbstractPlaceholderMenuController#getCursorAnimation cursorAnimationType not set");
            return null;
        }
        this.cursorAnimation = (AbstractAnimation)this.this$0.getAnimationController().getIAnimation(this.cursorAnimationType);
        this.cursorAnimation.addListener(this);
        return this.cursorAnimation;
    }

    protected void setTargetItemEntry(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, float f2, boolean bl) {
        float f3 = this.getCurrentPosition();
        if (!Util.equals(this.targetItemEntry, abstractPlaceholderMenuController$PlaceholderItemEntry) || f2 != this.hddsOffset) {
            this.targetWidthInitialized = false;
        }
        this.targetItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry;
        this.hddsOffset = f2;
        if (!bl || abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            if (this.cursorAnimation != null && this.cursorAnimation.isAnimating()) {
                this.cursorAnimation.stopAnimation();
            }
            if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
                this.this$0.setCompositesDirty(true);
                return;
            }
            this.startPosition = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition();
            this.relativePosition = 1.0f;
            this.this$0.setCompositesDirty(true);
            return;
        }
        this.startPosition = f3;
        this.restartAnimation();
    }

    private void restartAnimation() {
        AbstractAnimation abstractAnimation = this.getCursorAnimation();
        if (null == abstractAnimation) {
            return;
        }
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 31300, this.cursorAnimationType, false, this.this$0);
        }
        this.relativePosition = abstractAnimation.getProgress();
    }

    public void hddsSubticksChanged(float f2) {
        if (f2 == this.hddsOffset) {
            return;
        }
        this.startPosition = this.getCurrentPosition();
        this.hddsOffset = f2;
        this.targetWidthInitialized = false;
        this.restartAnimation();
    }

    public float getCurrentPosition() {
        AbstractPlaceholderMenuController$AnimatedFloatProperty abstractPlaceholderMenuController$AnimatedFloatProperty = this.isSubCursor ? this.this$0.getSubViewportPosition() : AbstractPlaceholderMenuController.access$900(this.this$0);
        float f2 = abstractPlaceholderMenuController$AnimatedFloatProperty.getCurrent();
        if (this.targetItemEntry == null) {
            return this.getCroppedPosition(this.startPosition);
        }
        this.relativePosition = Math.max(0.0f, Math.min(1.0f, this.relativePosition));
        return this.getCroppedPosition(this.startPosition + (this.targetItemEntry.getPosition() - f2 + this.hddsOffset - this.startPosition) * this.relativePosition);
    }

    public float getCurrentWidth() {
        this.cursorWidth.setProgress(this.relativePosition);
        return this.cursorWidth.getCurrent();
    }

    public boolean isCursorWidthInitialized() {
        return this.targetWidthInitialized;
    }

    public void setCursorWidthInitialized(boolean bl) {
        this.targetWidthInitialized = bl;
    }

    public void setTargetWidth(float f2) {
        if (this.cursorWidth.updateTarget(f2)) {
            this.this$0.setCompositesDirty(true);
        }
        this.targetWidthInitialized = true;
    }

    private float getCroppedPosition(float f2) {
        if (!this.crop) {
            return f2;
        }
        if (this.isSubCursor) {
            return Math.max(this.this$0.getMinSubCursorPosition(), Math.min(this.this$0.getMaxSubCursorPosition(), f2));
        }
        return Math.max(this.this$0.getMinCursorPosition(), Math.min(this.this$0.getMaxCursorPosition(), f2));
    }

    @Override
    public void animate(int n, float f2, int n2) {
        this.animate(n, f2);
    }

    public void animate(int n, float f2) {
        float f3 = this.cursorAnimation == null ? 1.0f : this.cursorAnimation.getProgress();
        this.relativePosition = f3;
        this.this$0.assignSlots();
        AbstractPlaceholderMenuController.access$1000(this.this$0);
        this.this$0.setCompositesDirty(true);
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        this.relativePosition = 1.0f;
        this.this$0.assignSlots();
        AbstractPlaceholderMenuController.access$1000(this.this$0);
        this.this$0.setCompositesDirty(true);
    }

    public boolean isVisible() {
        boolean bl;
        boolean bl2 = bl = this.targetItemEntry != null && this.targetItemEntry.isVisible();
        if (!bl) {
            return false;
        }
        float f2 = this.getCurrentPosition();
        if (this.isSubCursor) {
            return this.this$0.inSubViewport(f2);
        }
        return this.this$0.inViewport(f2, 1.0f);
    }

    public void invalidateTargetWidth() {
        this.targetWidthInitialized = false;
        this.this$0.setCompositesDirty(true);
    }

    public float getHddsOffset() {
        return this.hddsOffset;
    }

    public void setHddsOffset(float f2) {
        this.hddsOffset = f2;
    }

    static /* synthetic */ AbstractPlaceholderMenuController$PlaceholderItemEntry access$200(AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor) {
        return abstractPlaceholderMenuController$Cursor.targetItemEntry;
    }

    static /* synthetic */ AbstractAnimation access$300(AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor) {
        return abstractPlaceholderMenuController$Cursor.getCursorAnimation();
    }
}

