/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IMultilineTextFiledRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ViewPort;

public final class AnimatedState {
    public static final int[] MAX_VP_HEIGHTS = new int[]{310, 310};
    public static int layoutMaxVPHeight = MAX_VP_HEIGHTS[0];
    public static final int[] FOOTERS = new int[]{7, 7};
    public static int layoutFooterHeight = FOOTERS[0];
    public static final int SPELLER_HEIGHT;
    private int remainingHeigt = 0;
    private int spellerOffset = 0;
    private int header = 0;
    private int baseLineOffset = 0;
    public int currentLine = 0;
    private int availableLines = 0;
    private boolean isSpellerActive;
    private MultilineTextFieldController ctrl;
    private IMultilineTextFiledRenderer rndr;
    public ViewPort viewPort;
    public float spellerOpeningProgress;
    public int widgetH = 0;

    public AnimatedState(AnimatedState animatedState) {
        this.ctrl = animatedState.ctrl;
        this.rndr = animatedState.rndr;
        this.viewPort = new ViewPort(animatedState.viewPort);
        this.isSpellerActive = animatedState.isSpellerActive;
        this.spellerOpeningProgress = animatedState.spellerOpeningProgress;
        this.widgetH = animatedState.widgetH;
        this.spellerOffset = animatedState.spellerOffset;
        this.header = animatedState.header;
        this.baseLineOffset = animatedState.baseLineOffset;
        this.currentLine = animatedState.currentLine;
        this.availableLines = animatedState.availableLines;
    }

    public AnimatedState(MultilineTextFieldController multilineTextFieldController, IMultilineTextFiledRenderer iMultilineTextFiledRenderer, int n, int n2, boolean bl) {
        this.ctrl = multilineTextFieldController;
        this.rndr = iMultilineTextFiledRenderer;
        this.widgetH = 0;
        this.viewPort = new ViewPort(0, 0, this.ctrl.getWidth(), this.widgetH, 0, this.rndr);
        this.updateViewPortPosPriv(bl);
        this.updateCurrentLinePriv(n, n2);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.availableLines;
        n = 31 * n + this.baseLineOffset;
        n = 31 * n + this.currentLine;
        n = 31 * n + this.header;
        n = 31 * n + (this.isSpellerActive ? 1231 : 1237);
        n = 31 * n + this.remainingHeigt;
        n = 31 * n + this.spellerOffset;
        n = 31 * n + Float.floatToIntBits(this.spellerOpeningProgress);
        n = 31 * n + (this.viewPort == null ? 0 : this.viewPort.hashCode());
        n = 31 * n + this.widgetH;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof AnimatedState)) {
            return false;
        }
        AnimatedState animatedState = (AnimatedState)object;
        if (this.availableLines != animatedState.availableLines) {
            return false;
        }
        if (this.baseLineOffset != animatedState.baseLineOffset) {
            return false;
        }
        if (this.currentLine != animatedState.currentLine) {
            return false;
        }
        if (this.header != animatedState.header) {
            return false;
        }
        if (this.isSpellerActive != animatedState.isSpellerActive) {
            return false;
        }
        if (this.remainingHeigt != animatedState.remainingHeigt) {
            return false;
        }
        if (this.spellerOffset != animatedState.spellerOffset) {
            return false;
        }
        if (Float.floatToIntBits(this.spellerOpeningProgress) != Float.floatToIntBits(animatedState.spellerOpeningProgress)) {
            return false;
        }
        if (this.viewPort == null ? animatedState.viewPort != null : !this.viewPort.equals(animatedState.viewPort)) {
            return false;
        }
        return this.widgetH == animatedState.widgetH;
    }

    private void updateHeader() {
        this.remainingHeigt = layoutMaxVPHeight - this.spellerOffset;
        int n = this.remainingHeigt % this.rndr.getLineHeight();
        this.header = n - layoutFooterHeight;
    }

    private void updateViewPortPosPriv(boolean bl) {
        this.isSpellerActive = bl;
        this.spellerOpeningProgress = this.isSpellerActive ? 1.0f : 0.0f;
        this.spellerOffset = this.isSpellerActive ? 64 : 0;
        this.updateHeader();
        int n = 20;
        this.spellerOffset = this.isSpellerActive ? 64 + n : 0;
        int n2 = 0;
        if (AbstractWidget.isScreenResolution1440()) {
            n2 = -15;
        } else if (AbstractWidget.isScreenResolution800()) {
            n2 = 10;
            if (AbstractWidget.isVariantHigh()) {
                n2 = -22;
            }
        } else {
            n2 = -20;
        }
        this.viewPort.y = this.spellerOffset + this.header + n2;
    }

    private void updateCurrentLinePriv(int n, int n2) {
        this.updateHeader();
        this.currentLine = n;
        this.availableLines = n2;
        int n3 = this.remainingHeigt / this.rndr.getLineHeight();
        int n4 = Math.min(this.ctrl.maxNoVisibleLines, n3);
        boolean bl = n2 > n + 1 && n4 > 1;
        int n5 = bl ? n + 1 : n;
        int n6 = Math.max(n5, this.ctrl.minNoVisibleLines - 1);
        int n7 = Math.max(n6 - n4 + 1, 0);
        int n8 = Math.max(Math.min(n6 - n7 + 1, n2), this.ctrl.minNoVisibleLines);
        this.viewPort.updateVPYOffset(n7, n6, n8, n8 * this.rndr.getLineHeight() + layoutFooterHeight);
        this.widgetH = (int)(this.viewPort.h + this.viewPort.y);
    }

    public void updateCurrentLine(int n, int n2) {
        this.updateCurrentLinePriv(n, n2);
    }

    public void updateViewPortPos(boolean bl) {
        this.updateViewPortPosPriv(bl);
        this.updateCurrentLine(this.currentLine, this.availableLines);
    }

    public void udpate(int n, int n2, boolean bl) {
        this.updateViewPortPosPriv(bl);
        this.updateCurrentLine(n, n2);
    }
}

