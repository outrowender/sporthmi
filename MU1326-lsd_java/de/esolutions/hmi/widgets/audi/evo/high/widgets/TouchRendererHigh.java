/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.graphics.eal.FlagFontStyle;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DTextMultiSection;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ITouchRendererFontFlags;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;

public class TouchRendererHigh
extends AbstractKanziTemplateRenderer
implements ITouchRenderer {
    public static final String NODE_NAME_INPUT_FIELD;
    protected static final int EAL_MAX_TEXT_ELEMENT_WIDTH;
    protected static final int END_INDEX_OF_EMPTY_TEXT_SECTION;
    private static final int NUMBER_OF_TEXT_SECTIONS;
    protected static final int OFFSET_TEXT_LEFT;
    public static final int OFFSET_CURSOR_LEFT;
    private static final int OFFSET_INITIAL_TEXT_LEFT;
    protected static final int OFFSET_INITIAL_CURSOR_LEFT;
    public static final int OFFSET_FIELD_LEFT;
    public static int OffsetInfolineTextTop;
    public static final int OFFSET_INFOLINE_ICON_LEFT;
    public static final int OFFSET_INFOLINE_TEXT_LEFT;
    protected static final float SPACE_FOR_FINGERTRACE;
    public static final int OFFSET_TEXT_TO_RIGHT_BORDER;
    public static final int OFFSET_TEXT_TO_RIGHT_BORDER_SCALE_AND_STD;
    public static final int OFFSET_TEXT_TO_RIGHT_BORDER_SMALLSTAGE;
    private static final int FONT_INFOLINE;
    private static final int EXTRA_SPELLER_HEIGHT;
    private IWrappedNode3D textClipping;
    protected IWrappedNode3DTextMultiSection textNode;
    private IWrappedNode3DText textNodeInfo;
    private IWrappedNode3DText textNodeInitialText;
    private IWrappedNode3DText textNodeDescriptiveText;
    private IWrappedNode3DText textNodeTopImageText;
    private final int TOP_IMAGE_TEXT_LABEL_X_ICON_OFFSET;
    protected IWrappedNode3DImage suggestionBackground;
    private IWrappedNode3DImage topImage;
    private IWrappedNode3D topImageClipping;
    private TextureDescription topImageDescription;
    private int topImageHeight = -1;
    private int topImageCurrentIdx = -1;
    private final TouchController controller;
    private int ealColorInput;
    private final int numbersOfTextLayoutSections = this.getNumberOfTextLayoutSections();
    protected RedrawContextHigh rc;
    private boolean blinkCursorDirty = false;
    private boolean touchIndicatorIconDirty = false;
    private final int[][] inputDataTextSectionBounds = new int[this.numbersOfTextLayoutSections][2];
    private String abbreviatedTextToRender;
    protected int endPosEnteredText = 0;
    private String oldFullTextToRender = null;
    private int oldLeftPartLength = -1;
    private int oldAvailableWidthForText = 0;
    protected float suggestionX = 0.0f;
    protected final float SUGGESTIONY;
    protected float suggestionW = 0.0f;
    protected float suggestionH = 4162;

    public TouchRendererHigh(TouchController touchController) {
        this.TOP_IMAGE_TEXT_LABEL_X_ICON_OFFSET = 115;
        this.SUGGESTIONY = 16449;
        this.controller = touchController;
    }

    private void destroyTextNodes() {
        if (this.getEALManager() != null) {
            this.getEALManager().destroy(this.textNode);
            this.getEALManager().destroy(this.textNodeInfo);
            this.getEALManager().destroy(this.textNodeInitialText);
            this.getEALManager().destroy(this.textNodeDescriptiveText);
            this.getEALManager().destroy(this.suggestionBackground);
            this.getEALManager().destroy(this.textNodeTopImageText);
        }
        this.textNode = null;
        this.textNodeInfo = null;
        this.textNodeInitialText = null;
        this.textNodeDescriptiveText = null;
        this.suggestionBackground = null;
        this.textNodeTopImageText = null;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float f2;
        this.setRedrawContext(redrawContextHigh);
        float f3 = this.controller.getSpellerOpenProgress();
        int n = 0;
        if (this.controller.getTopImageIndex() != -1) {
            n = this.getTextureHeight(this.controller.getTopImageIndex());
        }
        int n2 = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(this.getInheritedFont()).calculateBaselineY(this.controller.getTouchInputFieldHeight(), 5);
        n2 = (int)((float)n2 + ((float)(this.controller.getSpellerHeight() + 8) * f3 + (float)n));
        int n3 = this.renderDescriptiveText(redrawContextHigh, n2);
        int n4 = this.controller.getX() + n3;
        float f4 = 1.0f - f3;
        float f5 = 0.0f;
        if (AbstractWidget.isScreenResolution1440()) {
            f5 = 32960;
        }
        float f6 = (float)(this.controller.getY() - 1) - f3 * (65 + f5);
        this.node.setPosition(n4 - 13, f6, 0.0f);
        this.setProperty("if_inputWidth", this.controller.getWidth() - n3);
        this.setProperty("if_inputHeight", this.controller.getTouchInputFieldHeight());
        this.setProperty("if_spellerWidth", this.controller.calculateSpellerWidth() - n3);
        this.setProperty("if_spellerHeight", this.controller.getTouchInputFieldHeight() + this.controller.getSpellerHeight() + 8);
        this.setProperty("if_languageIndicator", this.controller.getLanguageIndicatorIconIndex());
        this.node.setOpacity(this.controller.getRenderOpacity());
        float f7 = this.controller.getInfoLineProgress();
        f7 = Math.min(f7, f4);
        if (this.controller.isVisibleOnCurrentStage()) {
            this.setProperty("if_infoline", f7);
        }
        this.setProperty("if_infoIconPosX", 20546);
        this.setProperty("if_fieldActive", 0.0f);
        this.setProperty("if_spellerActive", f3);
        this.setProperty("if_height", this.getTerminal().getLayout().getIntegerConstant(12));
        int n5 = redrawContextHigh.getColor(0);
        int n6 = EALManager.createColorCode(n5);
        this.setColorProperty("if_iconColor", n6);
        n5 = redrawContextHigh.getColor(3);
        int n7 = redrawContextHigh.getColor(2);
        n6 = EALManager.createColorCode(this.controller.isEnabled() ? n5 : n7);
        this.setColorProperty("if_fieldColor", n6);
        int n8 = this.controller.getWidth() - this.offsetTextToRightBorder() - n3 - this.langIconIndicatorOffset();
        if (n8 != this.oldAvailableWidthForText) {
            this.getEALManager().destroy(this.textNodeInfo);
            this.getEALManager().destroy(this.textNodeInitialText);
            this.textNodeInfo = null;
            this.textNodeInitialText = null;
            if (this.textClipping != null) {
                float f8 = this.textClipping.getHeight();
                this.textClipping.useClippingRectangle(true);
                this.textClipping.setClippingRectangle(0.0f, 0.0f, n8, f8);
            }
            this.oldAvailableWidthForText = n8;
        }
        n5 = this.controller.isEnabled() && !this.controller.isAllInputLocked() ? -1 : redrawContextHigh.getColor(2);
        this.ealColorInput = EALManager.createColorCode(n5);
        this.calculateOptimalTextShortening(n8, this.getFullTextToRender(), redrawContextHigh.getCurrentFont());
        if (this.textNode == null) {
            this.createInputDataTextNode(n8);
        }
        if (this.suggestionBackground == null) {
            this.suggestionBackground = this.createSuggestionBackground(this.textNode.getParent(), EALManager.createColorCode(redrawContextHigh.getColor(0)));
        }
        this.updateInputDataTextSections(redrawContextHigh);
        boolean bl2 = this.controller.isCursorVisible();
        int n9 = 45121;
        if (bl2) {
            this.setProperty("if_cursorActive", this.controller.getCursorOpacity());
            f2 = this.calculateTextCursorXPosition(redrawContextHigh.getCurrentFont());
            if (f2 > (float)n8 - 0.0f) {
                int bl = (int)(f2 - (float)n8 + 0.0f);
                this.textNode.setPosition(-bl, n2, 0.0f);
                f2 -= (float)bl;
            } else {
                this.textNode.setPosition(0.0f, n2, 0.0f);
            }
            this.setProperty("if_cursorPosX", f2);
            n9 = (int)(f2 + (float)n3);
        } else {
            f2 = this.textNode.getX();
            this.textNode.setPosition(f2, n2, 0.0f);
            this.setProperty("if_cursorActive", 0.0f);
        }
        int n10 = n2;
        if (this.controller.getTopImageIndex() != -1) {
            this.cleanUpTopImage();
            this.createTopImage();
            n10 = (int)((float)n2 - this.topImageClipping.getHeight());
        } else {
            this.hideTopImage();
        }
        this.showSuggestionBackground(false);
        this.updateInputDataTextSections(redrawContextHigh);
        boolean bl = this.controller.showIcon();
        this.renderInitialTextAndIcon(redrawContextHigh, n10, bl, f4, this.controller.getWidth() - n3);
        this.controller.setFingerTracePlatePosition(n9, (int)(f6 + (float)this.controller.getSpellerHeight() * f3));
        this.renderInfoLineText(redrawContextHigh, f7, this.controller.getWidth() - n3);
        if (f3 > 0.0f) {
            IWrappedNode3D iWrappedNode3D = redrawContextHigh.parentNodeSecondary;
            if (iWrappedNode3D == null) {
                iWrappedNode3D = redrawContextHigh.parentNode;
            }
            this.getEALManager().moveToParent(this.node, iWrappedNode3D);
        } else {
            this.getEALManager().moveToParent(this.node, redrawContextHigh.parentNode);
        }
    }

    protected final void setRedrawContext(RedrawContextHigh redrawContextHigh) {
        this.rc = redrawContextHigh;
    }

    protected final RedrawContextHigh getRedrawContext() {
        return this.rc;
    }

    protected final void calculateOptimalTextShortening(int n, String string, IWrappedFont iWrappedFont) {
        String string2 = this.getTextPartLeftOfCursor();
        if (this.oldAvailableWidthForText >= n && string.equals(this.oldFullTextToRender) && string2.length() == this.oldLeftPartLength) {
            return;
        }
        this.oldLeftPartLength = string2.length();
        int n2 = this.getEALManager().getTextWidth(string, this.rc.getCurrentFont());
        String string3 = string;
        if (n2 > 1000) {
            String string4 = string.substring(string2.length());
            int n3 = n + 50;
            string2 = ((HMITerminalEAL)((Object)this.getTerminal())).getStringUtility(iWrappedFont).abbreviateText(string2, n3, true, false);
            string3 = StringUtility.concatenate(string2, string4);
        }
        this.oldFullTextToRender = string;
        this.endPosEnteredText = string2.length() - 1;
        this.abbreviatedTextToRender = string3;
    }

    protected String getTextPartLeftOfCursor() {
        return this.getTextWithOrientationMark(this.controller.getInputData().getCurrentText());
    }

    protected void createInputDataTextNode(int n) {
        this.textClipping = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("touchTextClipping", this), n, this.getControllerHeight() + this.controller.getSpellerHeight());
        this.textClipping.setPosition(45121, 0.0f, 0.0f);
        this.textClipping.setClippingInheritance(17);
        this.textClipping.setClipping(true);
        this.textNode = this.getEALManager().createText3DMultiSection(this.textClipping, EALManager.createNodeName("textNode", this), this.getAbbreviatedTextToRender(), this.rc.getCurrentFont(), 1);
        this.createInputDataTextSections(this.rc.getCurrentFont().getSize());
    }

    protected final IWrappedNode3D getTextClipping() {
        return this.textClipping;
    }

    protected final void setTextClipping(IWrappedNode3D iWrappedNode3D) {
        this.textClipping = iWrappedNode3D;
    }

    protected final int getOldAvailableWidthForText() {
        return this.oldAvailableWidthForText;
    }

    protected final void setOldAvailableWidthForText(int n) {
        this.oldAvailableWidthForText = n;
    }

    protected final IWrappedNode3DTextMultiSection getTextNode() {
        return this.textNode;
    }

    protected final void setTextNode(IWrappedNode3DTextMultiSection iWrappedNode3DTextMultiSection) {
        this.textNode = iWrappedNode3DTextMultiSection;
    }

    protected final IWrappedNode3DText getTextNodeInfo() {
        return this.textNodeInfo;
    }

    protected final void setTextNodeInfo(IWrappedNode3DText iWrappedNode3DText) {
        this.textNodeInfo = iWrappedNode3DText;
    }

    public IWrappedNode3DText getTextNodeInitialText() {
        return this.textNodeInitialText;
    }

    public void setTextNodeInitialText(IWrappedNode3DText iWrappedNode3DText) {
        this.textNodeInitialText = iWrappedNode3DText;
    }

    protected final int getEalColorInput() {
        return this.ealColorInput;
    }

    protected final void setEalColorInput(int n) {
        this.ealColorInput = n;
    }

    protected final IWrappedNode3DImage getSuggestionBackground() {
        return this.suggestionBackground;
    }

    protected final void setSuggestionBackground(IWrappedNode3DImage iWrappedNode3DImage) {
        this.suggestionBackground = iWrappedNode3DImage;
    }

    protected final void createInputDataTextSections(int n) {
        ITextLayout iTextLayout = this.textNode.getLayout();
        iTextLayout.setTextLayoutSectionNum(this.numbersOfTextLayoutSections);
        this.calculateSectionBounds();
        for (int i2 = 0; i2 < this.numbersOfTextLayoutSections; ++i2) {
            int n2 = this.inputDataTextSectionBounds[i2][0];
            int n3 = this.inputDataTextSectionBounds[i2][1];
            int n4 = this.getColorForTextSection(i2);
            ITextLayoutSection iTextLayoutSection = iTextLayout.getLayoutSection(i2);
            iTextLayoutSection.setColor(n4);
            iTextLayoutSection.setStyle(this.getFontStyle(i2));
            iTextLayoutSection.setBasicFontGroup(n, n3);
            iTextLayoutSection.setStartEndIndex(n2, n3);
        }
    }

    protected void updateInputDataTextSections(RedrawContextHigh redrawContextHigh) {
        this.calculateSectionBounds();
        String string = "";
        for (int i2 = 0; i2 < this.numbersOfTextLayoutSections; ++i2) {
            ITextLayoutSection iTextLayoutSection = this.textNode.getLayout().getLayoutSection(i2);
            int n = this.inputDataTextSectionBounds[i2][0];
            int n2 = this.inputDataTextSectionBounds[i2][1];
            int n3 = this.getColorForTextSection(i2);
            iTextLayoutSection.setColor(n3);
            iTextLayoutSection.setStyle(this.getFontStyle(i2));
            iTextLayoutSection.setStartEndIndex(n, n2);
            string = this.updateSections(i2, iTextLayoutSection, n, n2);
        }
        this.textNode.notifyLayoutChanged(false);
        redrawContextHigh.getCurrentFont().getFontGroup().activate();
        this.textNode.setText(string);
    }

    private String getOrientationMark(String string) {
        if (TouchControllerArabia.isLatinOnlyField() || this.controller.isLTR()) {
            return "\u200e";
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (!StringUtility.isArabicChar(string.charAt(i2))) continue;
            return "\u200f\u200e";
        }
        return "\u200e";
    }

    private String getTextWithOrientationMark(String string) {
        if (!TouchController.isArabia() || string == null || string.length() == 0) {
            return string;
        }
        String string2 = this.getOrientationMark(string);
        ((TouchControllerArabia)this.controller).setCurrentOrientationMark(string2);
        return string2.concat(string);
    }

    protected void showSuggestionBackground(boolean bl) {
        if (bl) {
            float f2 = this.getTerminal() != null ? (float)this.getTerminal().getLayout().getIntegerConstant(116) : 0.0f;
            int n = 16449 - f2;
            this.suggestionBackground.setPosition(this.suggestionX, n, 0.0f);
            this.suggestionBackground.setScale(this.suggestionW, this.suggestionH, 0.0f);
            bl &= this.controller.isSpellerClosed();
        }
        this.suggestionBackground.setVisible(bl);
    }

    protected String updateSections(int n, ITextLayoutSection iTextLayoutSection, int n2, int n3) {
        String string = this.getAbbreviatedTextToRender();
        if (string == null) {
            string = "";
        }
        if (n2 > 0 && n3 > 0 && n3 >= n2 && n2 <= string.length() && n3 <= string.length()) {
            String string2 = string.substring(0, n2);
            String string3 = string.substring(n2, string.length());
            if (string3.length() > 1 && string3.charAt(string3.length() - 1) == ' ') {
                string3 = string3.substring(0, string3.length() - 1);
            } else if (" ".equals(string3)) {
                string3 = "";
            }
            if (string3.length() > 0) {
                string = StringUtility.concatenate(string2, ' ', string3);
                iTextLayoutSection.setStartEndIndex(n2, n3 + 1);
                int n4 = this.getEALManager().getTextWidth(" ", this.rc.getCurrentFont());
                this.suggestionX = n4 + this.getEALManager().getTextWidth(string2, this.rc.getCurrentFont()) - 2;
                this.suggestionW = this.getEALManager().getTextWidth(string3, this.rc.getCurrentFont()) + 5;
                this.showSuggestionBackground(this.shouldShowSuggestionBackground());
            }
        } else {
            this.showSuggestionBackground(false);
        }
        return string;
    }

    protected boolean shouldShowSuggestionBackground() {
        return this.controller.isSpellerClosed();
    }

    private void calculateSectionBounds() {
        for (int i2 = 0; i2 < this.numbersOfTextLayoutSections; ++i2) {
            int n;
            int n2 = this.getIndexOfLastCharacterInTextSection(i2);
            if (n2 == -1) {
                this.inputDataTextSectionBounds[i2][1] = -1;
                this.inputDataTextSectionBounds[i2][0] = -1;
                continue;
            }
            this.inputDataTextSectionBounds[i2][0] = n = this.computeStartOfSection(i2);
            this.inputDataTextSectionBounds[i2][1] = n2;
        }
    }

    private int computeStartOfSection(int n) {
        for (int i2 = n - 1; i2 >= 0; --i2) {
            if (this.inputDataTextSectionBounds[i2][1] == -1) continue;
            return this.inputDataTextSectionBounds[i2][1] + 1;
        }
        return 0;
    }

    protected FlagFontStyle getFontStyle(int n) {
        return ITouchRendererFontFlags.FONT_STYLE_REGULAR;
    }

    protected int getColorForTextSection(int n) {
        return this.ealColorInput;
    }

    protected int getIndexOfLastCharacterInTextSection(int n) {
        if (n == 0) {
            return this.endPosEnteredText;
        }
        if (n == 1) {
            return this.getAbbreviatedTextToRender().length() - 1;
        }
        return -1;
    }

    protected int getNumberOfTextLayoutSections() {
        return 2;
    }

    protected String getFullTextToRender() {
        if (this.controller.suggestionsAvailable() && this.controller.isSpellerClosed()) {
            return this.getTextWithOrientationMark(this.controller.getCurrentSuggestion());
        }
        return this.getTextWithOrientationMark(this.controller.getInputData().getCurrentDisplayString());
    }

    protected float calculateTextCursorXPosition(IWrappedFont iWrappedFont) {
        int n = this.controller.isCursorAtInitialPosition() ? 16450 : 8257;
        String string = this.getAbbreviatedTextToRender();
        if (string != null && string.length() > 0) {
            int n2;
            int n3 = this.controller.getCursorPosition();
            int n4 = n2 = this.isCursorAtTheEndOfText(n3) ? 1 : 0;
            if (this.isSuggestionVisible()) {
                n3 = this.controller.getCursorPosition() - 1;
                n2 = 1;
            }
            n = (int)((float)(this.textNode.getOnScreenCharPosition(n3)[n2] + 10));
        }
        return n;
    }

    protected boolean isSuggestionVisible() {
        return this.suggestionBackground != null && this.suggestionBackground.isVisible();
    }

    protected boolean isCursorAtTheEndOfText(int n) {
        return this.controller.getInputData().getTextLength() == n;
    }

    protected final int renderDescriptiveText(RedrawContextHigh redrawContextHigh, int n) {
        String string = this.controller.getDescriptiveText();
        if (string != null) {
            String string2 = this.controller.getDescriptiveText2();
            int n2 = 0;
            if (string2 != null) {
                n2 = this.getEALManager().getTextWidth(string2, redrawContextHigh.getCurrentFont());
            }
            if (this.textNodeDescriptiveText == null) {
                this.textNodeDescriptiveText = this.getEALManager().createText3D(this.node, EALManager.createNodeName("touchTextNodeDescriptive", this), string, redrawContextHigh.getFont(0));
            }
            int n3 = this.controller.isEnabled() ? -1 : redrawContextHigh.getColor(2);
            int n4 = EALManager.createColorCode(n3);
            this.textNodeDescriptiveText.getInterfaceText().setColor(n4);
            int n5 = this.getEALManager().getTextWidth(string, redrawContextHigh.getCurrentFont());
            int n6 = Math.max(n5, n2) + 25;
            this.textNodeDescriptiveText.setPosition(22 - n6, n, 0.0f);
            return n6;
        }
        return 0;
    }

    protected final void renderInfoLineText(RedrawContextHigh redrawContextHigh, float f2, int n) {
        String string;
        IWrappedFont iWrappedFont = redrawContextHigh.getFont(1);
        if (this.textNodeInfo == null && f2 > 0.0f) {
            string = this.controller.getInfoText();
            string = this.abbreviateInfoLineText(iWrappedFont, string, n);
            this.textNodeInfo = this.getEALManager().createText3D(this.node, EALManager.createNodeName("touchTextNodeInfo", this), string, iWrappedFont);
            if (OffsetInfolineTextTop == -1) {
                OffsetInfolineTextTop = this.getTerminal().getLayout().getIntegerConstant(94);
            }
            this.textNodeInfo.setPosition(53314, this.controller.getTouchInputFieldHeight() + OffsetInfolineTextTop, 0.0f);
        }
        if (this.textNodeInfo != null) {
            this.textNodeInfo.setVisible(f2 > 0.0f);
            this.textNodeInfo.setOpacity(f2);
            string = this.controller.isSDSActive() && this.controller.getInfoTextSDS() != null ? this.controller.getInfoTextSDS() : this.controller.getInfoText();
            string = this.abbreviateInfoLineText(iWrappedFont, string, n);
            this.textNodeInfo.setText(string, iWrappedFont);
            this.textNodeInfo.getInterfaceText().setColor(this.getInfoLineColor());
        }
    }

    private int getInfoLineColor() {
        if (this.controller.isAllInputLocked()) {
            return EALManager.createColorCode(-1);
        }
        boolean bl = this.controller.isEnabled() || this.controller.isAllInputLocked();
        return EALManager.createColorCode(this.rc.getColor(bl ? 1 : 2));
    }

    private String abbreviateInfoLineText(IWrappedFont iWrappedFont, String string, int n) {
        int n2 = n - 104 - this.offsetTextToRightBorder();
        string = ((HMITerminalEAL)((Object)this.getTerminal())).getStringUtility(iWrappedFont).abbreviateText(string, n2, false, false);
        return string;
    }

    protected final void renderInitialTextAndIcon(RedrawContextHigh redrawContextHigh, int n, boolean bl, float f2, int n2) {
        int n3;
        String string = this.controller.getInitialText();
        if (string != null && string.length() > 0) {
            n3 = n2 - 65 - this.offsetTextToRightBorder() - this.langIconIndicatorOffset();
            string = ((HMITerminalEAL)((Object)this.getTerminal())).getStringUtility(redrawContextHigh.getCurrentFont()).abbreviateText(string, n3, false, true);
        }
        if (this.textNodeInitialText == null) {
            this.textNodeInitialText = this.getEALManager().createText3D(this.node, EALManager.createNodeName("touchTextNodeInitial", this), string, redrawContextHigh.getCurrentFont());
            this.textNodeInitialText.setPosition(33346, n, 0.0f);
        } else {
            this.textNodeInitialText.setText(string, redrawContextHigh.getCurrentFont());
        }
        if (this.textNodeInitialText != null) {
            n3 = redrawContextHigh.getColor(this.controller.isEnabled() ? 1 : 2);
            int n4 = EALManager.createColorCode(n3);
            this.textNodeInitialText.getInterfaceText().setColor(n4);
        }
        if (this.controller.isTouchpadKeypanelWithActiveStatus()) {
            if (this.textNodeInitialText != null) {
                this.textNodeInitialText.setPosition(33346, n, 0.0f);
            }
            if (bl) {
                this.setProperty("if_iconVisible", f2);
                if (this.textNodeInitialText != null) {
                    this.textNodeInitialText.setOpacity(f2);
                    this.textNodeInitialText.setVisible(true);
                }
            } else {
                this.setProperty("if_iconVisible", 0.0f);
                if (this.textNodeInitialText != null) {
                    this.textNodeInitialText.setVisible(false);
                }
            }
        } else {
            if (this.textNodeInitialText != null) {
                this.textNodeInitialText.setPosition(45121, n, 0.0f);
                this.textNodeInitialText.setOpacity(f2);
                this.textNodeInitialText.setVisible(bl);
            }
            this.setProperty("if_iconVisible", 0.0f);
        }
        this.setProperty("if_ddsArrowState", this.controller.showJumpDownToListArrow() ? 1.0f : 0.0f);
    }

    @Override
    public final void render(RedrawContext redrawContext) {
        if (this.dirty) {
            super.render(redrawContext);
        } else {
            if (this.blinkCursorDirty && this.controller.isCursorVisible()) {
                this.setProperty("if_cursorActive", this.controller.getCursorOpacity());
            }
            if (this.touchIndicatorIconDirty && this.controller.showIcon()) {
                if (this.controller.isTouchpadKeypanelWithActiveStatus()) {
                    this.setProperty("if_iconVisible", 1.0f);
                }
                if (this.textNodeInitialText != null) {
                    this.textNodeInitialText.setVisible(true);
                }
            }
        }
    }

    @Override
    public void disconnect() {
        this.destroyTextNodes();
        if (this.textClipping != null) {
            this.getEALManager().destroy(this.textClipping);
            this.textClipping = null;
        }
        if (this.topImageClipping != null) {
            this.getEALManager().destroy(this.topImageClipping);
            this.topImageClipping = null;
        }
        if (this.topImage != null) {
            this.getEALManager().destroy(this.topImage);
            this.topImage = null;
        }
        if (this.textNodeTopImageText != null) {
            this.getEALManager().destroy(this.textNodeTopImageText);
            this.textNodeTopImageText = null;
        }
        this.oldAvailableWidthForText = 0;
        this.oldFullTextToRender = null;
        this.oldLeftPartLength = -1;
        super.disconnect();
    }

    @Override
    protected final String getTemplateNodePath() {
        return "Prefabs/generic_inputField";
    }

    @Override
    protected final String getEALNodeName() {
        return "inputField";
    }

    @Override
    public final AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public final void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
    }

    @Override
    public void setCompositeDirty(int n) {
        if (n == 0) {
            this.blinkCursorDirty = true;
        } else if (n == 1) {
            this.touchIndicatorIconDirty = true;
        } else {
            super.setCompositeDirty(n);
        }
    }

    @Override
    public boolean areCompositesDirty() {
        return this.dirty || this.blinkCursorDirty || this.touchIndicatorIconDirty;
    }

    @Override
    public void setCompositesDirty(boolean bl) {
        super.setCompositesDirty(bl);
        this.blinkCursorDirty = bl;
        this.touchIndicatorIconDirty = bl;
    }

    protected final int langIconIndicatorOffset() {
        return this.controller.getLanguageIndicatorIconIndex() > 0 ? 45 : 0;
    }

    private boolean isScaleOrStdResolution() {
        return this.getTerminal().getFramework().getSysConst(522) == 1;
    }

    protected final int offsetTextToRightBorder() {
        int n = 0;
        switch (this.controller.getCurrentViewSize()) {
            case 2: {
                if (this.isScaleOrStdResolution()) {
                    n = 21;
                    break;
                }
                n = 21;
                break;
            }
            case 1: {
                n = 9;
                break;
            }
            default: {
                n = this.isScaleOrStdResolution() ? 21 : 21;
            }
        }
        return n;
    }

    protected String getAbbreviatedTextToRender() {
        if (this.abbreviatedTextToRender == null) {
            return this.getFullTextToRender();
        }
        return this.abbreviatedTextToRender;
    }

    public void setAbbreviatedTextToRender(String string) {
        this.abbreviatedTextToRender = string;
    }

    protected final IWrappedNode3DImage createSuggestionBackground(IWrappedNode3D iWrappedNode3D, int n) {
        IWrappedNode3DImage iWrappedNode3DImage = null;
        TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.white_pixel, false, this.getInitContext().getScreenID());
        iWrappedNode3DImage = this.getEALManager().createImage3D(iWrappedNode3D, new StringBuffer().append("Suggestion-Background").append(n).toString(), textureDescription, iWrappedNode3D.getNodeIndex() - 1, true, (Object)this);
        iWrappedNode3DImage.setModulateColor(n);
        return iWrappedNode3DImage;
    }

    protected final void createTopImage() {
        float f2;
        if (this.topImageDescription == null) {
            this.createTopImageDescription();
        }
        if (this.topImageClipping == null) {
            this.topImageClipping = this.getEALManager().createNode3D(this.node, "Top-Image-Clipping-Node", this.controller.getWidth(), this.getTopImageHeight());
        }
        if (this.topImage == null) {
            this.topImage = this.getEALManager().createImage3D(this.topImageClipping, "Top-Image", this.topImageDescription, 0, true, (Object)this);
            this.topImage.setVisible(true);
        }
        if ((f2 = (float)this.getTopImageHeight() * (1.0f - this.controller.getSpellerOpenProgress())) <= 0.0f) {
            this.topImageClipping.setVisible(false);
            return;
        }
        float f3 = this.node.getX();
        float f4 = this.node.getY();
        this.node.setPosition(f3, f4 + f2, 0.0f);
        this.topImageClipping.setPosition(20545, -f2, 0.0f);
        this.topImageClipping.setClippingRectangle(this.node.getX(), f4 - 16449, this.controller.getWidth(), f2 += (float)this.controller.getExtraClippingHeight());
        this.topImageClipping.useClippingRectangle(true);
        this.topImageClipping.setClipping(true);
        this.topImageClipping.setVisible(true);
        this.topImage.setVisible(true);
        String string = this.controller.getTopImageLabelText();
        if (string != null) {
            this.createTopImageTextLabel(this.topImageClipping, this.controller.getTopImageLabelText());
        } else {
            this.cleanUpTopImageTextLabel();
        }
    }

    protected void createTopImageTextLabel(IWrappedNode3D iWrappedNode3D, String string) {
        int n;
        int n2 = this.getEALManager().getTextWidth(string, this.rc.getCurrentFont());
        if (n2 > (n = this.controller.getWidth() - 115 - 13)) {
            string = ((HMITerminalImplMIB2High)this.getTerminal()).getStringUtility(this.rc.getCurrentFont()).abbreviateText(string, n, false, false);
        }
        if (this.textNodeTopImageText == null) {
            this.textNodeTopImageText = this.getEALManager().createText3D(iWrappedNode3D, EALManager.createNodeName("Text-Top-Image-Text", this), string, this.rc.getCurrentFont());
        } else {
            this.textNodeTopImageText.setText(string, this.rc.getCurrentFont());
        }
        int n3 = n - this.getEALManager().getTextWidth(string, this.rc.getCurrentFont()) + 13;
        int n4 = 10306;
        int n5 = this.rc.getColor(0);
        int n6 = EALManager.createColorCode(n5);
        this.textNodeTopImageText.setColor(n6);
        this.textNodeTopImageText.setPosition(n3, n4, 1.0f);
        this.textNodeTopImageText.setVisible(true);
    }

    protected final void cleanUpTopImage() {
        if (this.topImageCurrentIdx == this.controller.getTopImageIndex()) {
            return;
        }
        this.topImageCurrentIdx = this.controller.getTopImageIndex();
        if (this.topImage != null) {
            this.getEALManager().destroy(this.topImage);
            this.topImage = null;
        }
        if (this.topImageClipping != null) {
            this.getEALManager().destroy(this.topImageClipping);
            this.topImageClipping = null;
        }
        if (this.textNodeTopImageText != null) {
            this.getEALManager().destroy(this.textNodeTopImageText);
            this.textNodeTopImageText = null;
        }
        this.topImageDescription = null;
    }

    protected final void cleanUpTopImageTextLabel() {
        if (this.textNodeTopImageText != null) {
            this.getEALManager().destroy(this.textNodeTopImageText);
            this.textNodeTopImageText = null;
        }
    }

    protected final void hideTopImage() {
        if (this.topImage != null) {
            this.topImage.setVisible(false);
            float f2 = this.getTopImageHeight();
            float f3 = this.node.getX();
            float f4 = this.node.getY();
            this.node.setPosition(f3, f4 - f2, 0.0f);
            this.topImageHeight = 0;
        }
        if (this.textNodeTopImageText != null) {
            this.textNodeTopImageText.setVisible(false);
        }
    }

    private void createTopImageDescription() {
        this.topImageDescription = this.getEALManager().createTextureDescription(this.controller.getTopImageIndex(), false, this.getInitContext().getScreenID());
    }

    protected final int getControllerHeight() {
        int n = this.controller.getHeight();
        if (this.controller.getTopImageIndex() != -1) {
            if (this.topImageDescription == null) {
                this.createTopImageDescription();
            }
            n += this.getTopImageHeight();
        }
        return n;
    }

    protected int getTopImageHeight() {
        this.calculateTopImageSize();
        return this.topImageHeight;
    }

    private void calculateTopImageSize() {
        if (this.controller.getTopImageIndex() == -1) {
            this.topImageHeight = 0;
            return;
        }
        if (this.topImageDescription != null) {
            IWrappedTexture iWrappedTexture = this.topImageDescription.getTexture(this);
            if (iWrappedTexture == null) {
                this.topImageHeight = 0;
            } else {
                this.topImageHeight = iWrappedTexture.getHeight();
                iWrappedTexture.releaseTexture(true, this);
            }
        } else {
            this.topImageHeight = 0;
        }
    }

    @Override
    public int getTextureHeight(int n) {
        int n2 = 0;
        IWrappedTexture iWrappedTexture = this.getEALManager().createTextureDescription(n, false, this.getInitContext().getScreenID()).getTexture(this);
        if (iWrappedTexture == null) {
            return 0;
        }
        n2 = iWrappedTexture.getHeight();
        iWrappedTexture.releaseTexture(false, this);
        return n2;
    }

    @Override
    protected int getKzbConstant() {
        return 18;
    }

    static {
        OffsetInfolineTextTop = -1;
    }
}

