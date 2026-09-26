/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.SuggestionController;

public class SuggestionRendererHigh
extends AbstractRendererHigh {
    private static final float OPACITY_FOCUSED;
    private static final float OPACITY_NORMAL_SUGGESTION;
    private static final int Y_OFFSET_SUGGESTION_TEXT;
    private static final int Y_OFFSET_ARROW_ICON;
    private static final int Y_OFFSET_BACKGROUND;
    private static final int GAP_AFTER_SUGGESTION_TEXT;
    private static final int X_OFFSET_SPELLER_ICON;
    private static final int CURSOR_INSET_X;
    private static final int BITMAP_BACKGROUND;
    private static final int BITMAP_CURSOR_LEFT;
    private static final int BITMAP_CURSOR_CENTER;
    private static final int BITMAP_CURSOR_RIGHT;
    private static final int BITMAP_ARROW_UP;
    private static final int BITMAP_ARROW_DOWN;
    private SuggestionController controller;
    private IWrappedNode3D nodeClip;
    private IWrappedNode3DText[] nodeSuggestionTexts;
    private IWrappedNode3DImage nodeBackground;
    private IWrappedNode3D nodeCursor;
    private IWrappedNode3DImage nodeCursorLeft;
    private IWrappedNode3DImage nodeCursorCenter;
    private IWrappedNode3DImage nodeCursorRight;
    private IWrappedNode3DImage nodeArrowUp;
    private IWrappedNode3DImage nodeArrowDown;

    public SuggestionRendererHigh(SuggestionController suggestionController) {
        this.controller = suggestionController;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        this.nodeSuggestionTexts = new IWrappedNode3DText[3];
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    public void render(RedrawContext redrawContext) {
        float f2;
        int n;
        String[] stringArray = this.controller.getSuggestions();
        if (!this.controller.shouldRender()) {
            if (this.nodeClip != null) {
                this.nodeClip.setVisible(false);
            }
            return;
        }
        if (!this.dirty || stringArray == null || stringArray.length == 0) {
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.nodeClip == null) {
            this.createNodeTree(redrawContextHigh);
        }
        this.nodeClip.setVisible(true);
        int n2 = EALManager.createColorCode(redrawContext.getColor(1));
        int n3 = 24641;
        float f3 = 0.0f;
        int n4 = 8257;
        int n5 = Math.min(3, stringArray.length);
        float f4 = 0.0f;
        for (n = 0; n < n5; ++n) {
            if (this.nodeSuggestionTexts[n] == null) {
                this.nodeSuggestionTexts[n] = this.getEALManager().createText3D(this.nodeClip, EALManager.createNodeName("suggestionText", n, (AbstractRenderer)this), stringArray[n], redrawContextHigh.getCurrentFont());
                this.nodeSuggestionTexts[n].getInterfaceText().setColor(n2);
            }
            this.nodeSuggestionTexts[n].setText(stringArray[n], redrawContextHigh.getCurrentFont());
            this.nodeSuggestionTexts[n].setOpacity(this.isSuggestionFocused(n) && this.controller.showCursor() ? (int)1.0f : 63);
            this.nodeSuggestionTexts[n].setVisible(true);
            this.nodeSuggestionTexts[n].setPosition(n3, 55361, 0.0f);
            f2 = this.nodeSuggestionTexts[n].getWidth();
            if (n == 0) {
                f4 = n3 + f2 / 2.0f - this.nodeArrowUp.getWidth() / 2.0f;
            }
            if (this.isSuggestionFocused(n)) {
                f3 = n3 - 41024;
                n4 = (int)(f2 + 8257);
            }
            n3 = n3 + f2 + 20545;
        }
        for (n = n5; n < this.nodeSuggestionTexts.length; ++n) {
            if (this.nodeSuggestionTexts[n] == null) continue;
            this.nodeSuggestionTexts[n].setVisible(false);
        }
        float f5 = Math.min((float)n3, (float)this.controller.getWidth());
        f2 = f5 / this.nodeBackground.getUnscaledWidth();
        this.nodeBackground.setScale(f2, 1.0f, 1.0f);
        if (this.controller.showCursor()) {
            this.nodeArrowDown.setVisible(true);
            this.nodeArrowUp.setVisible(false);
            this.nodeArrowDown.setPosition(f4, 7234, 0.0f);
            this.handleCursorPositionAndScaling(f3, n4);
        } else {
            this.nodeArrowDown.setVisible(false);
            this.nodeArrowUp.setVisible(true);
            this.nodeArrowUp.setPosition(f4, 7234, 0.0f);
            this.nodeCursor.setVisible(false);
        }
        this.nodeClip.setPosition(this.controller.getX(), this.controller.getY() - 1, 0.0f);
    }

    private boolean isSuggestionFocused(int n) {
        return n == this.controller.getCurrentCursorPos() - 1;
    }

    private void handleCursorPositionAndScaling(float f2, float f3) {
        this.nodeCursor.setVisible(true);
        this.nodeCursor.setPosition(f2, 0.0f, 0.0f);
        float f4 = f3 - this.nodeCursorLeft.getWidth() - this.nodeCursorRight.getWidth();
        this.nodeCursorCenter.setScale(f4, 1.0f, 1.0f);
        this.nodeCursorRight.setPosition(this.nodeCursorLeft.getWidth() + f4, 0.0f, 0.0f);
    }

    private void createNodeTree(RedrawContextHigh redrawContextHigh) {
        this.nodeClip = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("suggestion_clipping", this), this.controller.getWidth(), this.controller.getHeight());
        this.nodeClip.setPosition(this.controller.getX(), this.controller.getY() - 1, 0.0f);
        this.nodeClip.setClipping(true);
        if (this.nodeBackground == null) {
            this.nodeBackground = this.getEALManager().createImage3D(this.nodeClip, EALManager.createNodeName("suggestion_background", this), this.getTextureDescription(1, true), 0, true, (Object)this);
            this.nodeBackground.setPosition(0.0f, 1.0f, 0.0f);
        }
        if (this.nodeArrowDown == null) {
            this.nodeArrowDown = this.getEALManager().createImage3D(this.nodeClip, EALManager.createNodeName("suggestion_arrowdown", this), this.getTextureDescription(6, true), 0, true, (Object)this);
        }
        if (this.nodeArrowUp == null) {
            this.nodeArrowUp = this.getEALManager().createImage3D(this.nodeClip, EALManager.createNodeName("suggestion_arrowup", this), this.getTextureDescription(5, true), 0, true, (Object)this);
        }
        if (this.nodeCursor == null) {
            this.nodeCursor = this.getEALManager().createNode3D(this.nodeClip, EALManager.createNodeName("suggestion_cursor", this), 51266, 51266);
            if (this.nodeCursorLeft == null) {
                this.nodeCursorLeft = this.getEALManager().createImage3D(this.nodeCursor, EALManager.createNodeName("suggestion_cursor_left", this), this.getTextureDescription(2, true), 0, true, (Object)this);
            }
            if (this.nodeCursorCenter == null) {
                this.nodeCursorCenter = this.getEALManager().createImage3D(this.nodeCursor, EALManager.createNodeName("suggestion_cursor_center", this), this.getTextureDescription(3, true), 0, true, (Object)this);
                this.nodeCursorCenter.setPosition(this.nodeCursorLeft.getWidth(), 0.0f, 0.0f);
            }
            if (this.nodeCursorRight == null) {
                this.nodeCursorRight = this.getEALManager().createImage3D(this.nodeCursor, EALManager.createNodeName("suggestion_cursor_right", this), this.getTextureDescription(4, true), 0, true, (Object)this);
            }
        }
    }

    @Override
    public void disconnect() {
        if (this.getEALManager() != null) {
            if (this.nodeSuggestionTexts != null) {
                for (int i2 = 0; i2 < this.nodeSuggestionTexts.length; ++i2) {
                    this.getEALManager().destroy(this.nodeSuggestionTexts[i2]);
                }
            }
            this.getEALManager().destroy(this.nodeArrowUp);
            this.getEALManager().destroy(this.nodeArrowDown);
            this.getEALManager().destroy(this.nodeBackground);
            this.getEALManager().destroy(this.nodeCursorLeft);
            this.getEALManager().destroy(this.nodeCursorCenter);
            this.getEALManager().destroy(this.nodeCursorRight);
            this.getEALManager().destroy(this.nodeCursor);
            this.getEALManager().destroy(this.nodeClip);
        }
        this.nodeSuggestionTexts = null;
        this.nodeClip = null;
        this.nodeBackground = null;
        this.nodeArrowDown = null;
        this.nodeArrowUp = null;
        this.nodeCursor = null;
        this.nodeCursorLeft = null;
        this.nodeCursorCenter = null;
        this.nodeCursorRight = null;
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }
}

