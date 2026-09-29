/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IInfoLineRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfolineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.List;

public class InfoLineRendererHigh
extends AbstractKanziTemplateRenderer
implements IInfoLineRenderer {
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private static final int INFOLINE_FONT_INDEX;
    private static final int MAX_LINES;
    private InfolineController controller;
    private IWrappedNode3DText[] textNodeInfo;
    private int oldAvailableWithForText;
    private String oldText;
    private String[] cachedLines;
    private String cachedLinesText;
    private int cachedLinesWidth;
    private int autoWrap = -1;

    public InfoLineRendererHigh() {
    }

    public InfoLineRendererHigh(InfolineController infolineController) {
        this.controller = infolineController;
    }

    @Override
    public void setController(InfolineController infolineController) {
        this.controller = infolineController;
    }

    @Override
    public void setFonts(Object[] objectArray) {
        super.setFonts((IWrappedFont[])objectArray);
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        float f2 = this.getShowProgress();
        this.node.setOpacity(f2);
        int n = this.getTextMaxWidth(this.controller.getWidth());
        if (n != this.oldAvailableWithForText || !Util.equals(this.oldText, this.controller.getText())) {
            this.destroyTextNode();
        }
        this.renderInfoLineText(redrawContextHigh, f2);
        this.applyKzbProperties(redrawContextHigh);
    }

    private float getShowProgress() {
        return (float)this.controller.getHeight() / (float)this.getPreferredHeight();
    }

    private void applyKzbProperties(RedrawContextHigh redrawContextHigh) {
        this.setProperty("if_infoIconPosX", 20546);
        this.setProperty("if_width", this.controller.getWidth());
        this.setProperty("if_height", this.controller.getHeight());
        this.setProperty("if_separatorVisible", 1.0f);
        int n = redrawContextHigh.getColor(this.controller.isSettingsInfoline() ? 2 : 0);
        int n2 = EALManager.createColorCode(n);
        this.setColorProperty("if_iconColor", n2);
        int n3 = redrawContextHigh.getColor(3);
        int n4 = EALManager.createColorCode(n3);
        this.setColorProperty("if_fieldColor", n4);
    }

    private void renderInfoLineText(RedrawContextHigh redrawContextHigh, float f2) {
        int n;
        int n2;
        IWrappedFont iWrappedFont = this.getInfolineFont(redrawContextHigh);
        this.updateLineWrapping(this.controller.getWidth(), iWrappedFont);
        if (this.textNodeInfo == null) {
            this.textNodeInfo = new IWrappedNode3DText[this.cachedLines.length];
            n2 = this.getTextMaxWidth(this.controller.getWidth());
            String string = this.controller.getText();
            this.oldAvailableWithForText = n2;
            this.oldText = string;
            for (n = 0; n < this.cachedLines.length; ++n) {
                this.textNodeInfo[n] = this.getEALManager().createText3D(this.node, EALManager.createNodeName("infolineText", this), this.cachedLines[n], iWrappedFont);
                this.textNodeInfo[n].setText(this.cachedLines[n], iWrappedFont, this.oldAvailableWithForText, this.getEALManager());
            }
        }
        n2 = redrawContextHigh.getColor(this.controller.isEnabled() ? 1 : 2);
        int n3 = this.controller.getTerminalImpl().getLayout().getIntegerConstant(63);
        n = EALManager.getFontHeightUppercase(iWrappedFont);
        int n4 = n + (this.textNodeInfo.length - 1) * n3;
        int n5 = (this.controller.getPreferredHeight() - n4) / 2;
        n5 += n;
        int n6 = EALManager.createColorCode(n2);
        for (int i2 = 0; i2 < this.textNodeInfo.length; ++i2) {
            this.textNodeInfo[i2].getInterfaceText().setColor(n6);
            this.textNodeInfo[i2].setPosition(46658, n5, 0.0f);
            n5 += n3;
            this.textNodeInfo[i2].setVisible(f2 > 0.0f);
            this.textNodeInfo[i2].setOpacity(f2);
        }
    }

    private void updateLineWrapping(int n, IWrappedFont iWrappedFont) {
        String string = this.controller.getText();
        int n2 = this.getTextMaxWidth(n);
        if (this.cachedLines != null && this.cachedLinesWidth == n2 && Util.equals(string, this.cachedLinesText)) {
            return;
        }
        StringUtility stringUtility = ((HMITerminalImplMIB2High)this.getTerminal()).getStringUtility(iWrappedFont);
        if (this.autoWrap == -1) {
            this.cachedLinesText = string;
            this.cachedLinesWidth = n2;
            List list = stringUtility.wrapOnLineBreak(string, '\n');
            this.cachedLines = (String[])list.toArray(new String[list.size()]);
            this.cachedLines = this.applyMaxLines(this.cachedLines, n2, iWrappedFont);
        } else {
            this.cachedLinesText = string;
            this.cachedLinesWidth = n2;
            this.cachedLines = stringUtility.wrapText(string, n2, n2, this.autoWrap);
            this.cachedLines = this.applyMaxLines(this.cachedLines, n2, iWrappedFont);
        }
    }

    private String[] applyMaxLines(String[] stringArray, int n, IWrappedFont iWrappedFont) {
        String string;
        if (2 >= stringArray.length) {
            return stringArray;
        }
        String[] stringArray2 = new String[2];
        System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, 2);
        int n2 = 1;
        stringArray2[n2] = string = new Buffer(stringArray[n2].length() + 1).append(stringArray[n2]).append('\u2026').toString();
        return stringArray2;
    }

    private IWrappedFont getInfolineFont(RedrawContextHigh redrawContextHigh) {
        return redrawContextHigh.getFont(3);
    }

    private IWrappedFont getInheritedInfolineFont() {
        IWrappedFont[] iWrappedFontArray = this.getInheritedFonts();
        if (iWrappedFontArray == null || iWrappedFontArray.length == 0) {
            return null;
        }
        if (iWrappedFontArray.length < 3) {
            return iWrappedFontArray[0];
        }
        return iWrappedFontArray[3];
    }

    private int getTextMaxWidth(int n) {
        int n2 = 0;
        n2 = AbstractWidget.framework.getSysConst(522) == 1 ? (((MenuController)this.controller.getParent()).getLayout().isOptionsIconVisible() ? 13 : -3) : (this.controller.isShownOnSmallStage() ? 9 : 21);
        return n - 104 - n2;
    }

    @Override
    public void disconnect() {
        this.destroyTextNode();
        this.cachedLines = null;
        this.cachedLinesText = null;
        this.cachedLinesWidth = -1;
        super.disconnect();
    }

    private void destroyTextNode() {
        if (this.textNodeInfo != null) {
            for (int i2 = 0; i2 < this.textNodeInfo.length; ++i2) {
                this.getEALManager().destroy(this.textNodeInfo[i2]);
            }
        }
        this.textNodeInfo = null;
        this.oldAvailableWithForText = 0;
        this.oldText = null;
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/generic_infoline";
    }

    @Override
    protected String getEALNodeName() {
        return "infoline";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public int getPreferredHeight() {
        return this.getPreferredHeight(this.controller.getWidth());
    }

    @Override
    public int getPreferredHeight(int n) {
        String string = this.controller.getText();
        if (string == null) {
            return this.controller.getTerminalImpl().getLayout().getIntegerConstant(12);
        }
        this.updateLineWrapping(n, this.getInheritedInfolineFont());
        if (this.cachedLines.length <= 1) {
            return this.controller.getTerminalImpl().getLayout().getIntegerConstant(12);
        }
        return this.controller.getTerminalImpl().getLayout().getIntegerConstant(13);
    }

    @Override
    public int getAutoWrap() {
        return this.autoWrap;
    }

    @Override
    public void setAutoWrap(int n) {
        this.autoWrap = n;
    }

    @Override
    protected int getKzbConstant() {
        return 6;
    }
}

