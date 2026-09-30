/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DTextMultiSection;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TouchRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;

public class TouchRendererHighArabia
extends TouchRendererHigh {
    private final TouchControllerArabia controller;
    private int availableWidthForText;
    ITouchInputDataArabia inputData = null;
    private float cursorPosX = 0.0f;
    private int suggestionLength;
    protected static final int OFFSET_CURSOR_LEFT = 8;
    protected static final int DIRECTION_CURSOR_WIDTH = 6;

    public TouchRendererHighArabia(TouchControllerArabia touchControllerArabia) {
        super(touchControllerArabia);
        this.controller = touchControllerArabia;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n;
        boolean bl;
        this.setRedrawContext(redrawContextHigh);
        float f2 = this.controller.getSpellerOpenProgress();
        int n2 = 0;
        if (this.controller.getTopImageIndex() != -1) {
            n2 = this.getTextureHeight(this.controller.getTopImageIndex());
        }
        int n3 = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(this.getInheritedFont()).calculateBaselineY(this.controller.getTouchInputFieldHeight(), 5);
        n3 = (int)((float)n3 + ((float)(this.controller.getSpellerHeight() + 8) * f2 + (float)n2));
        int n4 = this.renderDescriptiveText(redrawContextHigh, n3);
        int n5 = this.controller.getX() + n4;
        float f3 = 1.0f - f2;
        float f4 = 0.0f;
        if (AbstractWidget.isScreenResolution1440()) {
            f4 = -4.0f;
        }
        float f5 = (float)(this.controller.getY() - 1) - f2 * (8.0f + f4);
        this.node.setPosition(n5 - 13, f5, 0.0f);
        this.setProperty("if_inputWidth", this.controller.getWidth() - n4);
        this.setProperty("if_inputHeight", this.controller.getTouchInputFieldHeight());
        this.setProperty("if_spellerWidth", this.controller.calculateSpellerWidth() - n4);
        this.setProperty("if_spellerHeight", this.controller.getTouchInputFieldHeight() + this.controller.getSpellerHeight() + 8);
        this.setProperty("if_languageIndicator", this.controller.getLanguageIndicatorIconIndex());
        this.node.setOpacity(this.controller.getRenderOpacity());
        float f6 = this.controller.getInfoLineProgress();
        f6 = Math.min(f6, f3);
        if (this.controller.isVisibleOnCurrentStage()) {
            this.setProperty("if_infoline", f6);
        }
        this.setProperty("if_infoIconPosX", 52.0f);
        this.setProperty("if_fieldActive", 0.0f);
        this.setProperty("if_spellerActive", f2);
        this.setProperty("if_height", this.getTerminal().getLayout().getIntegerConstant(12));
        int n6 = redrawContextHigh.getColor(0);
        int n7 = EALManager.createColorCode(n6);
        this.setColorProperty("if_iconColor", n7);
        n6 = redrawContextHigh.getColor(3);
        int n8 = redrawContextHigh.getColor(2);
        n7 = EALManager.createColorCode(this.controller.isEnabled() ? n6 : n8);
        this.setColorProperty("if_fieldColor", n7);
        this.inputData = (ITouchInputDataArabia)this.controller.getInputData();
        this.availableWidthForText = this.controller.getWidth() - this.offsetTextToRightBorder() - this.langIconIndicatorOffset() - n4;
        this.availableWidthForText -= 5;
        boolean bl2 = bl = this.availableWidthForText != this.getOldAvailableWidthForText();
        if (bl) {
            this.getEALManager().destroy(this.getTextNodeInfo());
            this.getEALManager().destroy(this.getTextNodeInitialText());
            this.setTextNodeInfo(null);
            this.setTextNodeInitialText(null);
            if (this.getTextClipping() != null) {
                float f7 = this.getTextClipping().getHeight();
                this.getTextClipping().useClippingRectangle(true);
                this.getTextClipping().setClippingRectangle(0.0f, 0.0f, this.availableWidthForText, f7);
            }
            this.setOldAvailableWidthForText(this.availableWidthForText);
        }
        n6 = this.controller.isEnabled() ? -1 : redrawContextHigh.getColor(2);
        this.setEalColorInput(EALManager.createColorCode(n6));
        this.calculateOptimalTextShortening(this.availableWidthForText, this.getFullTextToRender(), redrawContextHigh.getCurrentFont());
        if (this.getTextNode() == null) {
            this.createInputDataTextNode(this.availableWidthForText);
        }
        this.getTextClipping().setPosition(22.0f, 0.0f, 0.0f);
        if (this.getSuggestionBackground() == null) {
            this.setSuggestionBackground(this.createSuggestionBackground(this.getTextNode().getParent(), EALManager.createColorCode(redrawContextHigh.getColor(0))));
        }
        this.showSuggestionBackground(false);
        this.updateInputDataTextSections(redrawContextHigh);
        boolean bl3 = this.controller.isCursorVisible();
        boolean bl4 = this.controller.showIcon();
        float f8 = 22.0f;
        this.setProperty("if_cursorActive", this.controller.getCursorOpacity());
        this.cursorPosX = this.calculateTextCursorXPosition(redrawContextHigh.getCurrentFont());
        if (this.cursorPosX > (float)this.availableWidthForText - 0.0f) {
            n = (int)(this.cursorPosX - (float)this.availableWidthForText + 0.0f) + 10;
            this.getTextNode().setPosition(-n, n3, 0.0f);
            this.cursorPosX -= (float)n;
            this.suggestionX += (float)n;
        } else {
            this.getTextNode().setPosition(0.0f, n3, 0.0f);
        }
        this.setProperty("if_cursorPosX", this.cursorPosX);
        n = 0;
        n = this.isLTR() ? (this.inputData.isRTL() ? -1 : 1) : (this.inputData.isRTL() ? 1 : -1);
        this.setProperty("arab_CursorTailDirection", n);
        boolean bl5 = !this.isLTR() ? this.inputData.isDeleteDirectionFromRightToLeft() : !this.inputData.isDeleteDirectionFromRightToLeft();
        int n9 = n != 0 ? 6 : 0;
        float f9 = f8 = bl5 ? this.cursorPosX + (float)n4 + (float)n9 : this.cursorPosX + (float)n4 - 88.0f - (float)n9 - 13.0f;
        if (f8 + 88.0f >= (float)this.availableWidthForText) {
            f8 = this.availableWidthForText - 88 - n9;
            this.controller.setFingerTraceMaxOpacity(0.65f);
        } else if (this.isLTR() == this.inputData.isRTL() && (f8 <= 0.0f || bl4)) {
            f8 = bl4 ? 48.0f : (float)n9;
            this.controller.setFingerTraceMaxOpacity(0.65f);
        } else {
            this.controller.setFingerTraceMaxOpacity(1.0f);
        }
        this.updateSuggestionBackground(redrawContextHigh);
        if (!bl3) {
            float f10 = this.getTextNode().getX();
            this.getTextNode().setPosition(f10, n3, 0.0f);
            this.setProperty("if_cursorActive", 0.0f);
        }
        if (this.controller.getTopImageIndex() != -1) {
            this.cleanUpTopImage();
            this.createTopImage();
        } else {
            this.hideTopImage();
        }
        int n10 = n3 - this.getTopImageHeight();
        this.renderInitialTextAndIcon(redrawContextHigh, n10, bl4, f3, this.controller.getWidth() - n4);
        this.controller.setFingerTracePlatePosition((int)f8, (int)(f5 + (float)this.controller.getSpellerHeight() * f2));
        this.renderInfoLineText(redrawContextHigh, f6, this.controller.getWidth() - n4);
        if (f2 > 0.0f) {
            IWrappedNode3D iWrappedNode3D = redrawContextHigh.parentNodeSecondary;
            if (iWrappedNode3D == null) {
                iWrappedNode3D = redrawContextHigh.parentNode;
            }
            this.getEALManager().moveToParent(this.node, iWrappedNode3D);
        } else {
            this.getEALManager().moveToParent(this.node, redrawContextHigh.parentNode);
        }
    }

    protected float calculateTextCursorXPosition(IWrappedFont iWrappedFont) {
        float f2 = this.cursorPosX = this.controller.isCursorAtInitialPosition() ? 48.0f : 8.0f;
        if (this.getTextNode().getText().length() > 0) {
            boolean bl;
            String string = this.controller.getEnteredString() != null ? this.controller.getEnteredString() : this.controller.getInputData().getCurrentDisplayString();
            string = this.controller.getCurrentOrientationMark().concat(string);
            int n = this.getEALManager().getTextWidth(this.getTextNode().getText(), iWrappedFont);
            int n2 = this.controller.getCursorPosition() - 1 + this.controller.getCurrentOrientationMark().length();
            if (n2 < 0 || n2 >= string.length()) {
                logChannel.log(100000, "TouchRendererHighArabia#calculateTextCursorXPosition cursor position out of bounds, lastCharIndex=%1 textlength=%2", (long)n2, (long)string.length());
                return this.cursorPosX;
            }
            int n3 = string.charAt(n2);
            boolean bl2 = StringUtility.isArabicChar((char)n3) || this.inputData.isArabicSpecialChar((char)n3) || n3 == 32 && !this.isLTR();
            boolean bl3 = StringUtility.isLatinChar((char)n3) || Character.isDigit((char)n3) || n3 == 32 && this.isLTR();
            boolean bl4 = bl = !this.isLTR() && TouchControllerArabia.isArabicCharSetActivated() && (StringUtility.isLatinChar((char)n3) || Character.isDigit((char)n3) && this.inputData.isRTL()) || this.isLTR() && !TouchControllerArabia.isArabicCharSetActivated() && bl2;
            if (bl) {
                this.cursorPosX = n + 8;
                return this.cursorPosX;
            }
            int n4 = this.inputData.isRTL() && !bl3 || bl2 ? 0 : 1;
            this.cursorPosX = this.getTextNode().getOnScreenCharPosition(Math.max(n2, 0))[n4];
            if (StringUtility.isBlankChar((char)n3)) {
                n3 = 32;
            }
            this.cursorPosX = this.isLTR() ? this.cursorPosX + 8.0f : (float)n - this.cursorPosX + 8.0f;
            return this.cursorPosX;
        }
        return this.cursorPosX;
    }

    protected void showSuggestionBackground(boolean bl) {
        if (bl) {
            float f2 = this.getTerminal() != null ? (float)this.getTerminal().getLayout().getIntegerConstant(116) : 0.0f;
            float f3 = 12.0f - f2;
            this.suggestionBackground.setPosition(this.suggestionX, f3, 0.0f);
            this.suggestionBackground.setScale(this.suggestionW, this.suggestionH, 0.0f);
            bl &= this.controller.isSpellerClosed();
        }
        this.suggestionBackground.setVisible(bl);
    }

    private String removeTrailingSpace(String string) {
        if (string.length() > 1 && string.charAt(string.length() - 1) == ' ') {
            return string.substring(0, string.length() - 1);
        }
        if (" ".equals(string)) {
            return "";
        }
        return string;
    }

    protected void updateInputDataTextSections(RedrawContextHigh redrawContextHigh) {
        char c2;
        String string;
        String string2 = this.getAbbreviatedTextToRender();
        string2 = ((HMITerminalEAL)((Object)this.getTerminal())).getStringUtility(redrawContextHigh.getCurrentFont()).abbreviateText(string2, 1000, false, false);
        String string3 = this.removeTrailingSpace(string2.substring((string = string2.substring(0, this.endPosEnteredText + 1)).length()));
        if (string3.length() > 0) {
            c2 = this.isLTR() ? (char)' ' : '\uf2f2';
            string2 = StringUtility.concatenate(string, c2, string3);
        }
        c2 = string2.length() - 1;
        ITextLayout iTextLayout = this.textNode.getLayout();
        iTextLayout.setTextLayoutSectionNum(1L);
        ITextLayoutSection iTextLayoutSection = iTextLayout.getLayoutSection(0L);
        iTextLayoutSection.setStartEndIndex(0L, c2);
        iTextLayoutSection.setBasicFontGroup(redrawContextHigh.getCurrentFont().getSize(), c2);
        this.textNode.notifyLayoutChanged(false);
        redrawContextHigh.getCurrentFont().getFontGroup().activate();
        this.textNode.setText(string2);
        this.suggestionLength = string3.length();
        this.updateSuggestionBackground(redrawContextHigh);
    }

    private void updateSuggestionBackground(RedrawContextHigh redrawContextHigh) {
        int n = this.textNode.getText().length();
        if (this.suggestionLength == 0) {
            this.showSuggestionBackground(false);
        } else {
            int n2 = this.getEALManager().getTextWidth(this.textNode.getText(), redrawContextHigh.getCurrentFont());
            int n3 = n - this.suggestionLength;
            int n4 = n - 1;
            int[] nArray = this.getTextNode().getOnScreenCharPosition(n3);
            int[] nArray2 = this.getTextNode().getOnScreenCharPosition(n4);
            int n5 = Math.min(nArray[0], nArray2[0]);
            int n6 = Math.max(nArray2[1], nArray[1]);
            int n7 = n6 - n5;
            this.suggestionX = this.getTextNode().getX() + (float)(this.isLTR() ? n5 : n2 - n6);
            this.suggestionW = n7;
            this.showSuggestionBackground(true);
        }
    }

    protected void createInputDataTextNode(int n) {
        if (n < 0) {
            n *= -1;
        }
        IWrappedNode3D iWrappedNode3D = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("touchTextClipping", this), n, this.getControllerHeight() + this.controller.getSpellerHeight());
        iWrappedNode3D.setClippingInheritance(17);
        iWrappedNode3D.setClipping(true);
        this.setTextClipping(iWrappedNode3D);
        float f2 = iWrappedNode3D.getHeight();
        iWrappedNode3D.useClippingRectangle(true);
        iWrappedNode3D.setClippingRectangle(0.0f, 0.0f, n, f2);
        IWrappedNode3DTextMultiSection iWrappedNode3DTextMultiSection = this.getEALManager().createText3DMultiSection(iWrappedNode3D, EALManager.createNodeName("textNode", this), this.getAbbreviatedTextToRender(), this.getRedrawContext().getCurrentFont(), 1);
        this.setTextNode(iWrappedNode3DTextMultiSection);
        this.createInputDataTextSections(this.getRedrawContext().getCurrentFont().getSize());
    }

    protected String getFullTextToRender() {
        String string = super.getFullTextToRender();
        if (this.controller.suggestionsAvailable()) {
            return string;
        }
        int[] nArray = StringUtility.getTextContext(string);
        if (this.isLTR()) {
            if (this.inputData.isRTL() && nArray[0] == 1) {
                string = string.substring(0, nArray[1]) + string.substring(nArray[1]).replace(' ', '\u05f0');
            }
        } else if (!(this.inputData.isRTL() || nArray[0] != 2 && nArray[0] != 3)) {
            string = string.substring(0, nArray[1]) + string.substring(nArray[1]).replace(' ', '\uf2f2');
        }
        return string;
    }
}

