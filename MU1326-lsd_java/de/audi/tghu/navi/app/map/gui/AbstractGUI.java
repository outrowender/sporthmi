/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.gui.EmptyMapPartialPopupHandler;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.Rect;

public abstract class AbstractGUI
implements GUIInterface {
    protected static final int CORNER_CUT_OFFSET;
    protected static final int PREVIEWMAP_INTELLIDEST_WIDTH;
    protected static final int PREVIEWMAP_INTELLIDEST_HEIGHT;
    protected static final int PREVIEWMAP_INTELLIDEST_VISIBLE_OFFSET_X;
    protected static final int PREVIEWMAP_INTELLIDEST_VISIBLE_OFFSET_Y;
    protected static final int PREVIEWMAP_INTELLIDEST_VISIBLE_WIDTH;
    protected static final int PREVIEWMAP_INTELLIDEST_VISIBLE_HEIGHT;
    protected static final int PREVIEWMAP_MMIKOMBI_WIDTH;
    protected static final int PREVIEWMAP_MMIKOMBI_HEIGHT;
    protected static final int PREVIEWMAP_MMIKOMBI_VISIBLE_OFFSET_X;
    protected static final int PREVIEWMAP_MMIKOMBI_VISIBLE_OFFSET_Y;
    protected static final int PREVIEWMAP_MMIKOMBI_VISIBLE_WIDTH;
    protected static final int PREVIEWMAP_MMIKOMBI_VISIBLE_HEIGHT;
    protected static final int MAPINMAP_WIDTH;
    protected static final int MAPINMAP_HEIGHT;
    protected static final int CROSSHAIR_OFFSET_Y_HIGH;
    protected LogChannel mGUILogChannel;
    protected final AbstractMap naviMap;
    protected final NavigationEnv env;
    protected IMapPartialPopupHandler partialPopup;

    public AbstractGUI(AbstractMap abstractMap, NavigationEnv navigationEnv, LogChannel logChannel) {
        this.naviMap = abstractMap;
        this.env = navigationEnv;
        this.mGUILogChannel = logChannel;
        this.partialPopup = new EmptyMapPartialPopupHandler(logChannel);
    }

    protected LogChannel getLogger() {
        return this.mGUILogChannel;
    }

    protected NavigationEnv getEnv() {
        return this.env;
    }

    protected IContext getActiveCtx() {
        return this.naviMap.getActiveContext();
    }

    protected AbstractMap getMap() {
        return this.naviMap;
    }

    protected abstract String getName() {
    }

    @Override
    public void stickN(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickN(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 0);
    }

    @Override
    public void stickNW(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickNW(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 315);
    }

    @Override
    public void stickW(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickW(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 270);
    }

    @Override
    public void stickSW(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickSW(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 225);
    }

    @Override
    public void stickS(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickS(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 180);
    }

    @Override
    public void stickSE(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickSE(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 135);
    }

    @Override
    public void stickE(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickE(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 90);
    }

    @Override
    public void stickNE(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickNE(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, 45);
    }

    @Override
    public void stickIdle(int n, int n2) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#stickIdle(%2)", (Object)this.getName(), (long)n);
        this.getActiveCtx().joystick(n, -1);
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#itemReleased(%2, %3)", (Object)this.getName(), (long)n, (long)n2);
        this.getActiveCtx().itemReleased(n, n2);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#itemFocused(%2, %3)", (Object)this.getName(), (long)n, (long)n2);
        this.getActiveCtx().itemFocused(n, n2);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getActiveCtx().itemSelected(n, n2, n3, n4);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogger().log(14808325, "AbstractGUI[%1]#keyPressed(%2) - keyID = %3", (Object)this.getName(), (long)n, (long)n2);
        this.getActiveCtx().keyPressed(n, n2);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.getLogger().log(14808325, "AbstractGUI[%1]#keyReleased(%2, %3)", (Object)this.getName(), (long)n, (long)n2);
        this.getActiveCtx().keyReleased(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLogger().log(14808325, "AbstractGUI[%1]#keyTyped(%2, %3)", (Object)this.getName(), (long)n, (long)n2);
        this.getActiveCtx().keyTyped(n, n2);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        if (n == 35522048) {
            this.decrementGesture(n2);
        } else {
            this.decrementDDS(n, n2, n3);
        }
    }

    private void decrementDDS(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = n2;
        if (n == 1545340416 && (n5 = this.getMagnificationValue(n)) - n2 < (n4 = this.getMagnificationMinimum(n))) {
            n6 = n5 - n4;
        }
        this.getLogger().log(-2137614336, "AbstractGUI[%1]#decrementDDS( %2", (Object)this.getName(), (Object)new Buffer().append(n).append(", ").append(n2).append(" ) - clippedSteps: ").append(n6).toString());
        if (n6 > 0) {
            this.getActiveCtx().increment(n, -n6);
        }
    }

    private void decrementGesture(int n) {
        this.mGUILogChannel.log(-2137614336, "AbstractGUI[%1]#decrementGesture( %2 )", (Object)this.getName(), (long)n);
        this.naviMap.getZoomHandler().incrementGesture(-n);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        if (n == 35522048) {
            this.incrementGesture(n2);
        } else {
            this.incrementDDS(n, n2, n3);
        }
    }

    private void incrementDDS(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = n2;
        if (n == 1545340416 && (n5 = this.getMagnificationValue(n)) + n2 > (n4 = this.getMagnificationMaximum(n))) {
            n6 = n4 - n5;
        }
        if (this.getLogger().isDebug()) {
            this.getLogger().log(-2137614336, "AbstractGUI[%1]#incrementDDS( %2", (Object)this.getName(), (Object)new Buffer().append(n).append(", ").append(n2).append(" ) - clippedSteps: ").append(n6).toString());
        }
        this.getActiveCtx().increment(n, n6);
    }

    private void incrementGesture(int n) {
        this.mGUILogChannel.log(-2137614336, "AbstractGUI[%1]#incrementGesture( %2 )", (Object)this.getName(), (long)n);
        this.naviMap.getActiveContext().incrementGesture(n);
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        this.getLogger().log(14808325, "AbstractGUI#touchPadPositionMoved( %1 ): start: %2, %3", (long)n, (long)n2, (long)n3);
        this.getActiveCtx().touchPadPositionMoved(n, n2, n3, n4, n5);
    }

    @Override
    public void touchPadReleased(int n, int n2, int n3) {
    }

    @Override
    public void touchPadPressed(int n, int n2, int n3) {
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        this.getActiveCtx().touchScreenMoved(n, n2, n3, n4, n5);
    }

    @Override
    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        this.getActiveCtx().touchScreenPressed(n, n2, n3);
    }

    @Override
    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
        this.getActiveCtx().touchScreenLongPressed(n, n2, n3);
    }

    @Override
    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        this.getActiveCtx().touchScreenReleased(n, n2, n3);
    }

    @Override
    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
        this.getActiveCtx().touchScreenDoubleClick(n, n2, n3);
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
        this.getActiveCtx().touchScreenPinch(n, f2, n2, n3);
    }

    @Override
    public void touchScreenRotate(int n, short s, int n2) {
        this.getActiveCtx().touchScreenRotate(n, s);
    }

    @Override
    public int getScreenWidthMapInMap() {
        return 293;
    }

    @Override
    public int getScreenHeightMapInMap() {
        return 323;
    }

    @Override
    public int getScreenWidthPreviewMap() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return 244;
        }
        return 260;
    }

    @Override
    public int getScreenHeightPreviewMap() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return 266;
        }
        return 318;
    }

    @Override
    public Rect getScreenSize() {
        return new Rect(0, 0, this.getScreenWidth(), this.getScreenHeight());
    }

    @Override
    public Rect getMapSize() {
        return new Rect(0, 0, this.getMapWidth(), this.getMapHeight());
    }

    @Override
    public int getVisibleWidthPreviewMap() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return PREVIEWMAP_MMIKOMBI_VISIBLE_WIDTH;
        }
        return 260;
    }

    @Override
    public int getVisibleHeightPreviewMap() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return PREVIEWMAP_MMIKOMBI_VISIBLE_HEIGHT;
        }
        return 318;
    }

    @Override
    public int getVisibleOffsetXPreviewMap() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return PREVIEWMAP_MMIKOMBI_VISIBLE_OFFSET_X;
        }
        return 0;
    }

    @Override
    public int getVisibleOffsetYPreviewMap() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return PREVIEWMAP_MMIKOMBI_VISIBLE_OFFSET_Y;
        }
        return 0;
    }

    @Override
    public int getOffsetCrosshairHeight() {
        return 55;
    }

    @Override
    public void showPreviewMap(boolean bl) {
        this.getLogger().log(14808325, "AbstractGUI#showPreviewMap( %1 )", bl);
        this.env.getChoiceModel(-1591867904).setValue(bl ? 1 : 0);
    }

    @Override
    public int getOffsetOfCarPosition() {
        return 0;
    }

    @Override
    public void setGridMaskVisible(boolean bl) {
    }

    @Override
    public void updateCarPosition() {
    }

    @Override
    public int getSBRSListModel() {
        return 1125910016;
    }

    @Override
    public IMapPartialPopupHandler getMapPartialPopupHandler() {
        return this.partialPopup;
    }

    @Override
    public void cleanup() {
    }

    static {
        PREVIEWMAP_MMIKOMBI_VISIBLE_OFFSET_X = CORNER_CUT_OFFSET = Util.isHURegionAsia() ? 15 : 0;
        PREVIEWMAP_MMIKOMBI_VISIBLE_OFFSET_Y = CORNER_CUT_OFFSET;
        PREVIEWMAP_MMIKOMBI_VISIBLE_WIDTH = 244 - CORNER_CUT_OFFSET;
        PREVIEWMAP_MMIKOMBI_VISIBLE_HEIGHT = 210 - CORNER_CUT_OFFSET;
    }
}

