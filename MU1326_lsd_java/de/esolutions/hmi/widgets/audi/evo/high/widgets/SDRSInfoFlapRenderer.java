/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.eal.StringUtilityEAL;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SDRSInfoFlap;

public class SDRSInfoFlapRenderer
extends AbstractRendererHigh {
    private static final int MAX_CENTER_WIDTH_G22;
    private static final int MAX_CENTER_WIDTH_G21;
    private static final int GAP_CENTER_RIGHT;
    private static final int GAP_OPTION_ICON;
    private static final int ICON_REQUIRED_SPACE;
    private static final int X_OFFSET_ICON;
    private static final int Y_OFFSET_TEXT;
    private static final int Y_OFFSET_ICON;
    public static final String PREFAB_NAME;
    public static final String PROPERTY_WIDTH;
    public static final String PROPERTY_CONTENT_OFFSET;
    public static final String PROPERTY_HARD_EDGE;
    private static final String CONTENT;
    private static final String CONTENT_CENTER;
    private static final String CONTENT_RIGHT;
    private static final int BITMAP_DYNAMIC_ROUTE_ICON;
    private SDRSInfoFlap controller;
    private static IWrappedNode3D contentNode;
    private static IWrappedNode3D contentCenterNode;
    private static IWrappedNode3D contentRightNode;
    private static IWrappedNode3DImage iconNode;
    private static IWrappedNode3DText textNode;
    private static IWrappedNode3DText textNodeSavedTime;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();
    private static boolean isSetUp;
    private static boolean isFirstRenderAfterConnect;
    private String currentText = "";
    private float value1;
    private float value2;
    private int targetValue1;
    private int targetValue2;

    private static float adjustValue(float f2, int n, float f3) {
        if (f2 < (float)n) {
            return Math.min((float)n, f2 + f3);
        }
        if (f2 > (float)n) {
            return Math.max((float)n, f2 - f3);
        }
        return f2;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (contentNode == null || textNodeSavedTime == null || textNode == null || iconNode == null) {
            mapOverlayLogCh.log(10000, "SDRSInfoFlapRenderer#applyProperties Nodes are null.");
            return;
        }
        float f2 = this.calculateContentOffset();
        float f3 = this.calculateRightPartWidth();
        float f4 = this.controller.getAnimationProgress();
        this.value1 = SDRSInfoFlapRenderer.adjustValue(this.value1, this.targetValue1, f4);
        this.value2 = SDRSInfoFlapRenderer.adjustValue(this.value2, this.targetValue2, f4);
        if (mapOverlayLogCh.isDebug()) {
            mapOverlayLogCh.log(-2137614336, "SDRSInfoFlapRenderer#applyProperties value1 = %1, targetValue1 = %2", (double)this.value1, (double)this.targetValue1, 0.0);
            mapOverlayLogCh.log(-2137614336, "SDRSInfoFlapRenderer#applyProperties value2 = %1, targetValue2 = %2", (double)this.value2, (double)this.targetValue2, 0.0);
        }
        if (this.value1 == (float)this.targetValue1 && this.value2 == (float)this.targetValue2) {
            this.controller.stopAnimation();
        }
        float f5 = this.value1 + this.value2;
        this.setProperty("gp_width", f3 + this.value2);
        this.setProperty("dynRoute_contentOffset", f2);
        this.setProperty("dynRoute_hardEdge", 0.0f);
        contentNode.setVisible(this.controller.shouldRender());
        contentNode.setPosition((float)this.controller.getX() - f5, this.controller.getY(), 0.0f);
        contentNode.setOpacity(this.controller.getRenderOpacity());
        iconNode.setPosition(4161, 12353, 0.0f);
        textNode.setPosition(18498, 1090, 0.0f);
        textNodeSavedTime.setPosition(0.0f, 1090, 0.0f);
    }

    private int calculateCenterPartWidth() {
        if (textNode == null) {
            return 0;
        }
        return (int)textNode.getWidth() + 15;
    }

    private int calculateContentOffset() {
        return (int)textNodeSavedTime.getWidth() + 41;
    }

    private int calculateRightPartWidth() {
        int n = 50;
        if (textNodeSavedTime == null) {
            return n;
        }
        int n2 = this.calculateContentOffset();
        return n += n2;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        isFirstRenderAfterConnect = true;
    }

    @Override
    public void disconnect() {
        contentNode.setVisible(false);
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    private INode3D getNode3D(String string) {
        EALManager eALManager = this.getEALManager();
        if (eALManager == null) {
            return null;
        }
        return eALManager.getShortcutNode3D(string);
    }

    private void mergeKZB() {
        InitializationContext initializationContext = this.getInitContext();
        if (initializationContext != null) {
            int n = initializationContext.getScreenID();
            EALManager eALManager = this.getEALManager();
            if (eALManager != null) {
                INode2D iNode2D = eALManager.mergeProject(17, -50, n);
                if (iNode2D == null) {
                    return;
                }
                iNode2D.dispose();
                mixedListLogChannel.log(-2137614336, "SDRSInfoFlapRenderer#mergeKZB Merging KZB success.");
                MixedListKZBMerger.kzbMerged = true;
            }
        }
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!AbstractWidget.framework.isTarget() && !MixedListRenderer.isKZBMerged()) {
            this.mergeKZB();
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (!isSetUp) {
            this.setUpNodes(redrawContextHigh);
            this.setUpInitialValues();
            isSetUp = true;
        }
        this.updateTextNodes(redrawContextHigh);
        this.updateTargetValues();
        if (isFirstRenderAfterConnect) {
            this.setUpInitialValues();
            isFirstRenderAfterConnect = false;
        }
        if (contentNode != null) {
            IWrappedNode3D iWrappedNode3D = contentNode.getParent();
            if (iWrappedNode3D != null) {
                iWrappedNode3D.remove(contentNode);
            } else {
                INode3D iNode3D = this.getNode3D("dynRouteBox");
                if (iNode3D != null) {
                    INode3D iNode3D2 = iNode3D.getParent();
                    if (iNode3D2 != null) {
                        iNode3D2.remove(iNode3D);
                        iNode3D2.dispose();
                    }
                    iNode3D.dispose();
                }
            }
            redrawContextHigh.parentNode.add(contentNode);
        }
        if (this.getAbstractController().shouldRender()) {
            this.applyProperties(redrawContextHigh);
        } else {
            contentNode.setVisible(this.controller.shouldRender());
        }
    }

    public SDRSInfoFlapRenderer(SDRSInfoFlap sDRSInfoFlap) {
        this.controller = sDRSInfoFlap;
    }

    public void setCurrentCenterWidth(float f2) {
        int n = this.calculateRightPartWidth();
        this.value2 = f2 * (float)n;
    }

    public void setKzbIDs(int[] nArray) {
    }

    protected boolean setProperty(String string, float f2) {
        return this.propertyCache.setProperty(contentNode, string, f2);
    }

    private void setUpInitialValues() {
        this.updateTargetValues();
        this.value1 = this.targetValue1;
        this.value2 = this.targetValue2;
    }

    private void setUpNodes(RedrawContextHigh redrawContextHigh) {
        Object object;
        if (contentNode == null && (object = this.getNode3D("dynRouteBox")) != null) {
            contentNode = new WrappedNode3D((INode3D)object, 31300, 51266, false, 0, this.isLTR());
        }
        contentNode.setVisible(false);
        if (contentCenterNode == null && (object = this.getNode3D("dynRouteBox_contentCenter")) != null) {
            contentCenterNode = new WrappedNode3D((INode3D)object, 64067, 51266, false, 0, this.isLTR());
        }
        if (contentRightNode == null && (object = this.getNode3D("dynRouteBox_contentRight")) != null) {
            contentRightNode = new WrappedNode3D((INode3D)object, 64067, 51266, false, 0, this.isLTR());
        }
        if (iconNode == null) {
            object = this.getTextureDescription(0, true);
            if (object == null) {
                mapOverlayLogCh.log(1078071040, "SDRSInfoFlapRenderer#setUpNodes textureDescription is null for BITMAP_DYNAMIC_ROUTE_ICON ");
            }
            iconNode = this.getEALManager().createImage3D(contentNode, "iconNode", (TextureDescription)object, 0, true, (Object)this);
        }
        int n = EALManager.createColorCode(redrawContextHigh.getColor(this.controller.getCurrentVisState()));
        if (textNode == null) {
            textNode = this.getEALManager().createText3D(contentCenterNode, "textNode", this.controller.getTextInfo(), redrawContextHigh.getCurrentFont());
            textNode.setColor(n);
        }
        if (textNodeSavedTime == null) {
            textNodeSavedTime = this.getEALManager().createText3D(contentRightNode, "textNodeSavedTime", this.controller.getTextSavedTime(), redrawContextHigh.getCurrentFont());
            textNodeSavedTime.setColor(n);
        }
    }

    private void updateTargetValues() {
        int[] nArray = this.controller.getTargetValues();
        int n = this.calculateRightPartWidth();
        int n2 = this.calculateCenterPartWidth();
        this.targetValue1 = nArray[0] * n;
        this.targetValue2 = nArray[1] * (n2 + 15);
    }

    private void updateTextNodes(RedrawContextHigh redrawContextHigh) {
        String string;
        if (textNode != null && !(string = this.controller.getTextInfo()).equals(this.currentText)) {
            int n;
            StringUtilityEAL stringUtilityEAL = (StringUtilityEAL)this.getTerminal().getStringUtility();
            stringUtilityEAL.setCurrentFont(redrawContextHigh.getCurrentFont());
            int n2 = stringUtilityEAL.getStringWidth(string);
            boolean bl = AbstractWidget.framework.getSysConst(522) == 1;
            int n3 = n = bl ? 290 : 520;
            if (n2 > n) {
                string = stringUtilityEAL.abbreviateTextEllipsis(string, n, false);
            }
            this.currentText = string;
            mapOverlayLogCh.log(-2137614336, "SDRSInfoFlapRenderer#updateTextNodes Update node's text: %1.", (Object)string);
            textNode.setText(string, redrawContextHigh.getCurrentFont());
        }
        if (textNodeSavedTime != null) {
            textNodeSavedTime.setText(this.controller.getTextSavedTime(), redrawContextHigh.getCurrentFont());
        }
    }

    static {
        isSetUp = false;
        isFirstRenderAfterConnect = false;
    }
}

