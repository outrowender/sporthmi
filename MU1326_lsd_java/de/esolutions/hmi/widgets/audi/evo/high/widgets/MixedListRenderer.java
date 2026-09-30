/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListController2;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListItemController2;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import java.util.List;

public class MixedListRenderer
extends AbstractRendererHigh
implements IKanziTemplateRenderer,
MixedListConstants {
    private MixedListController2 controller;
    private INode3D[] nodes;
    private IWrappedNode3D[] wrappedNodes;
    private int screenWidth;
    private int screenHeight;
    private EALPropertyCache propertyCache = new EALPropertyCache();

    public MixedListRenderer(MixedListController2 mixedListController2) {
        this.controller = mixedListController2;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        INode3D iNode3D;
        IWrappedNode3D iWrappedNode3D = this.wrappedNodes[0];
        if (iWrappedNode3D == null) {
            mixedListLogChannel.log(10000, "MixedListRenderer#applyProperties Main node is null.");
            return;
        }
        mixedListAfterPaint.log(10000000, "MixedListRenderer#applyProperties");
        IWrappedNode3D iWrappedNode3D2 = iWrappedNode3D.getParent();
        IWrappedNode3D iWrappedNode3D3 = redrawContextHigh.parentNode;
        if (!Util.equals(iWrappedNode3D2, iWrappedNode3D3)) {
            if (iWrappedNode3D2 != null) {
                mixedListLogChannel.log(10000000, "MixedListRenderer#applyProperties oldParent = %1, newParent = %2", (Object)iWrappedNode3D2, (Object)iWrappedNode3D3);
                iWrappedNode3D2.remove(iWrappedNode3D);
            } else {
                INode3D iNode3D2 = iWrappedNode3D.getNode();
                iNode3D = iNode3D2.getParent();
                if (iNode3D != null) {
                    iNode3D.remove(iNode3D2);
                    iNode3D.dispose();
                }
            }
            iWrappedNode3D3.addByIndex(iWrappedNode3D, 100);
        }
        boolean bl = this.controller.shouldRender();
        bl &= this.controller.getW140_contentOpacity_0() == 0.0f;
        bl &= this.controller.getW140_contentOpacity_1() == 0.0f;
        bl &= this.controller.getW140_contentOpacity_2() == 0.0f;
        if (bl &= this.controller.getW140_contentOpacity_3() == 0.0f) {
            mixedListLogChannel.log(10000, "MixedListRenderer#applyProperties Invalid rendering state. Hide w140 node.");
        }
        iWrappedNode3D.setVisible(this.controller.shouldRender() && !bl);
        iWrappedNode3D.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setW140Opacity(this.controller.getRenderOpacity());
        iNode3D = iWrappedNode3D.getNode();
        int n = MixedListController2.getInnerWidth();
        this.setProperty(iNode3D, "w140_width", n);
        this.setProperty(iNode3D, "w140_overallHeight", this.controller.getW140_overallHeight());
        this.setProperty(iNode3D, "w140_height_0", this.controller.getW140_height_0());
        this.setProperty(iNode3D, "w140_height_1", this.controller.getW140_height_1());
        this.setProperty(iNode3D, "w140_height_2", this.controller.getW140_height_2());
        this.setProperty(iNode3D, "w140_height_3", this.controller.getW140_height_3());
        this.setProperty(iNode3D, "w140_pos_0", this.controller.getW140_pos_0());
        this.setProperty(iNode3D, "w140_pos_1", this.controller.getW140_pos_1());
        this.setProperty(iNode3D, "w140_pos_2", this.controller.getW140_pos_2());
        this.setProperty(iNode3D, "w140_pos_3", this.controller.getW140_pos_3());
        this.setProperty(iNode3D, "w140_contentOpacity_0", this.controller.getW140_contentOpacity_0());
        this.setProperty(iNode3D, "w140_contentOpacity_1", this.controller.getW140_contentOpacity_1());
        this.setProperty(iNode3D, "w140_contentOpacity_2", this.controller.getW140_contentOpacity_2());
        this.setProperty(iNode3D, "w140_contentOpacity_3", this.controller.getW140_contentOpacity_3());
        if (MixedListController2.isMMIKombi()) {
            this.setW140FooterVisibility(this.controller.getW140_footerVisibility());
        }
    }

    private static void printNode(INode3D iNode3D, String string, LogChannel logChannel, int n) {
        logChannel.log(n, string + iNode3D.getName());
        logChannel.log(n, string + " - opacity = " + iNode3D.getOpacity());
        Vec3f vec3f = iNode3D.getTranslation();
        logChannel.log(n, string + " - translation = [" + vec3f.X() + "," + vec3f.Y() + "," + vec3f.Z() + "]");
        logChannel.log(n, string + " - visible = " + iNode3D.isVisible());
        long l = iNode3D.getChildCount();
        int n2 = 0;
        while ((long)n2 < l) {
            INode3D iNode3D2 = iNode3D.getChildAtIndex(n2);
            if (iNode3D2 != null) {
                MixedListRenderer.printNode(iNode3D2, "  " + string, logChannel, n);
                iNode3D2.dispose();
            } else {
                logChannel.log(n, "MixedListRenderer#printNode Node is null");
            }
            ++n2;
        }
    }

    public static void printWrappedNode(IWrappedNode3D iWrappedNode3D, String string, LogChannel logChannel, int n) {
        logChannel.log(n, string + iWrappedNode3D.getNodeName());
        if (iWrappedNode3D instanceof WrappedNode3DText) {
            logChannel.log(n, string + "+ Text = " + ((WrappedNode3DText)iWrappedNode3D).getText());
        } else if (iWrappedNode3D instanceof WrappedNode3DImage) {
            logChannel.log(n, string + "+ Filename = " + ((WrappedNode3DImage)iWrappedNode3D).getFilename());
        }
        List list = iWrappedNode3D.getWrappedChildren();
        if (list != null) {
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                IWrappedNode3D iWrappedNode3D2 = (IWrappedNode3D)list.get(i2);
                MixedListRenderer.printWrappedNode(iWrappedNode3D2, "  " + string, logChannel, n);
                iWrappedNode3D2.dispose();
            }
        }
    }

    public static void printWidget(AbstractWidget abstractWidget, String string, LogChannel logChannel, int n) {
        logChannel.log(n, string + abstractWidget.getClassName() + " " + abstractWidget.toString());
        List list = abstractWidget.getChildren();
        if (list != null) {
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                MixedListRenderer.printWidget((AbstractWidget)list.get(i2), "  " + string, logChannel, n);
            }
        }
    }

    public void printWidgets(LogChannel logChannel, int n) {
        logChannel.log(n, "MixedListRenderer#printWidgets");
        MixedListRenderer.printWidget(this.controller, "", mixedListCallbackLogCh, 10000000);
    }

    public void connect(InitializationContext initializationContext) {
        INode3D iNode3D;
        this.initializeNodes();
        super.connect(initializationContext);
        if (AbstractWidget.framework.isSimulator() && (iNode3D = this.getEALManager().getShortcutNode3D("dynRouteBox")) != null) {
            IWidgetLogChannel.mixedListLogChannel.log(10000000, "MixedListRenderer#connect Set dynRouteBox invisible.");
            iNode3D.setVisible(false);
            iNode3D.dispose();
        }
    }

    private void destroyNodes() {
        IWrappedNode3D iWrappedNode3D;
        IWrappedNode3D iWrappedNode3D2;
        if (this.wrappedNodes != null && this.wrappedNodes[0] != null && (iWrappedNode3D2 = (iWrappedNode3D = this.wrappedNodes[0]).getParent()) != null) {
            iWrappedNode3D2.remove(iWrappedNode3D);
        }
    }

    public void shutDown() {
        this.propertyCache.clearAll();
        this.destroyNodes();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    private INode3D getNode3D(String string) {
        mixedListLogChannel.log(10000000, "MixedListRenderer#getNode3D kzbMerged = %1, eal = %2", MixedListKZBMerger.kzbMerged, (Object)this.getEALManager());
        EALManager eALManager = this.getEALManager();
        if (eALManager == null) {
            return null;
        }
        return eALManager.getShortcutNode3D(string);
    }

    private IProperty getProperty(INode iNode, String string) {
        IProperty iProperty = iNode.getProperty(string);
        if (!iProperty.isValid()) {
            iProperty.dispose();
            return null;
        }
        return iProperty;
    }

    private void initializeNodes() {
        if (!this.controller.isActive()) {
            return;
        }
        if (AbstractWidget.framework.isTarget()) {
            Layout layout = this.getTerminal().getLayout();
            this.screenWidth = layout.getDistance(1);
            this.screenHeight = layout.getDistance(2);
        } else {
            this.mergeKZB();
        }
        int n = 6;
        if (this.nodes == null) {
            this.nodes = new INode3D[n];
        }
        if (this.wrappedNodes == null) {
            this.wrappedNodes = new IWrappedNode3D[n];
        }
        if (this.nodes[0] == null) {
            this.nodes[0] = this.getNode3D("w140");
            if (this.nodes[0] != null) {
                this.wrappedNodes[0] = new WrappedNode3D(this.nodes[0], 1.0f, 1.0f, false, 0, this.isLTR());
            }
        }
        int n2 = this.controller.getWidth();
        int n3 = this.controller.getHeight();
        int[] nArray = new int[]{1, 2, 3, 4, 5};
        String[] stringArray = new String[]{"w140_content0", "w140_content1", "w140_content2", "w140_content3", "w140_footerContent"};
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n4 = nArray[i2];
            if (this.nodes[n4] != null) continue;
            this.nodes[n4] = this.getNode3D(stringArray[i2]);
            if (this.nodes[n4] != null) {
                this.wrappedNodes[n4] = new WrappedNode3D(this.nodes[n4], n2, n3, false, 0, this.isLTR());
                this.wrappedNodes[n4].setScreenSize(this.screenWidth, this.screenHeight);
                continue;
            }
            mixedListLogChannel.log(10000, "MixedListRenderer#render Node with index = %1 is not valid.", (long)n4);
        }
    }

    public static boolean isKZBMerged() {
        return MixedListKZBMerger.kzbMerged;
    }

    private void mergeKZB() {
        if (!MixedListRenderer.isKZBMerged()) {
            InitializationContext initializationContext = this.getInitContext();
            if (initializationContext != null) {
                int n = initializationContext.getScreenID();
                EALManager eALManager = this.getEALManager();
                if (eALManager != null) {
                    INode2D iNode2D = eALManager.mergeProject(17, -50, n);
                    if (iNode2D == null) {
                        mixedListLogChannel.log(10000, "MixedListController2#mergeKZB Merging KZB failed.");
                        return;
                    }
                    iNode2D.dispose();
                    Layout layout = this.getTerminal().getLayout();
                    this.screenWidth = layout.getDistance(1);
                    this.screenHeight = layout.getDistance(2);
                    mixedListLogChannel.log(10000000, "MixedListController2#mergeKZB Merging successful.");
                    MixedListKZBMerger.kzbMerged = true;
                } else {
                    mixedListLogChannel.log(10000, "MixedListController2#mergeKZB Merging KZB failed: EALManager is null.");
                }
            } else {
                mixedListLogChannel.log(10000, "MixedListController2#mergeKZB Merging KZB failed: InitializationContext is null.");
                if (!this.controller.isConnected()) {
                    mixedListLogChannel.log(10000, "MixedListController2#mergeKZB Controller is not connected.");
                }
            }
        }
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        if (!this.controller.isActive()) {
            abstractWidget.setVisible(false);
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.wrappedNodes != null) {
            if (abstractWidget instanceof MixedListItemController2) {
                MixedListItemController2 mixedListItemController2 = (MixedListItemController2)abstractWidget;
                int n = mixedListItemController2.getCurrentContentNode();
                if (1 <= n && n <= 4) {
                    IWrappedNode3D iWrappedNode3D = this.wrappedNodes[n];
                    if (iWrappedNode3D != null) {
                        redrawContextHigh.parentNode = iWrappedNode3D;
                    } else {
                        mixedListLogChannel.log(10000, "MixedListRenderer#prepareRedrawContextForChildren Parent for item at pos %1 could not be set. Desired parent node is null.", (long)mixedListItemController2.getCurrentPosition());
                        redrawContextHigh.parentNode = null;
                    }
                } else {
                    redrawContextHigh.parentNode = null;
                }
            } else if (abstractWidget instanceof LayoutContainerController && !(abstractWidget instanceof MixedListLayout)) {
                abstractWidget.setWidth(MixedListController2.getInnerWidth());
                abstractWidget.setHeight(32);
                if (this.wrappedNodes[5] != null) {
                    redrawContextHigh.parentNode = this.wrappedNodes[5];
                }
            }
        }
    }

    public void printProperties(LogChannel logChannel, int n) {
        logChannel.log(n, "MixedListRenderer#printProperties");
        logChannel.log(n, "shouldRender = %1", this.controller.shouldRender());
        logChannel.log(n, "opacity = %1", (double)this.controller.getRenderOpacity());
        logChannel.log(n, "height = %1", (double)this.controller.getW140_overallHeight());
        logChannel.log(n, "height0 = %1", (double)this.controller.getW140_height_0());
        logChannel.log(n, "height1 = %1", (double)this.controller.getW140_height_1());
        logChannel.log(n, "height2 = %1", (double)this.controller.getW140_height_2());
        logChannel.log(n, "height3 = %1", (double)this.controller.getW140_height_3());
        logChannel.log(n, "pos0 = %1", (double)this.controller.getW140_pos_0());
        logChannel.log(n, "pos1 = %1", (double)this.controller.getW140_pos_1());
        logChannel.log(n, "pos2 = %1", (double)this.controller.getW140_pos_2());
        logChannel.log(n, "pos3 = %1", (double)this.controller.getW140_pos_3());
        logChannel.log(n, "opacity0 = %1", (double)this.controller.getW140_contentOpacity_0());
        logChannel.log(n, "opacity1 = %1", (double)this.controller.getW140_contentOpacity_1());
        logChannel.log(n, "opacity2 = %1", (double)this.controller.getW140_contentOpacity_2());
        logChannel.log(n, "opacity3 = %1", (double)this.controller.getW140_contentOpacity_3());
        logChannel.log(n, "footer visibility = %1", this.controller.getW140_footerVisibility());
        String[] stringArray = new String[]{"w140_width", "w140_overallHeight", "w140_height_0", "w140_height_1", "w140_height_2", "w140_height_3", "w140_pos_0", "w140_pos_1", "w140_pos_2", "w140_pos_3", "w140_contentOpacity_0", "w140_contentOpacity_1", "w140_contentOpacity_2", "w140_contentOpacity_3", "w140_footerVisibility"};
        if (this.nodes != null && this.nodes[0] != null) {
            INode3D iNode3D = this.nodes[0];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                IProperty iProperty = this.getProperty(iNode3D, stringArray[i2]);
                if (iProperty != null) {
                    logChannel.log(n, stringArray[i2] + " = %1", (double)iProperty.getFloat());
                    iProperty.dispose();
                    continue;
                }
                logChannel.log(n, "Property is null");
            }
        }
    }

    void printNodes(LogChannel logChannel, int n) {
        logChannel.log(n, "MixedListRenderer#printNodes");
        if (this.nodes != null) {
            for (int i2 = 0; i2 < this.nodes.length; ++i2) {
                if (this.nodes[i2] != null) {
                    MixedListRenderer.printNode(this.nodes[i2], "", logChannel, n);
                    continue;
                }
                logChannel.log(n, "Node with index %1 is null", (long)i2);
            }
        }
    }

    void printWrappedNodes(LogChannel logChannel, int n) {
        logChannel.log(n, "MixedListRenderer#printWrappedNodes");
        if (this.wrappedNodes != null) {
            for (int i2 = 0; i2 < this.wrappedNodes.length; ++i2) {
                if (this.wrappedNodes[i2] != null) {
                    MixedListRenderer.printWrappedNode(this.wrappedNodes[i2], "", logChannel, n);
                    continue;
                }
                logChannel.log(n, "Wrapped Node with index %1 is null", (long)i2);
            }
        }
    }

    public void removeContent(int[] nArray) {
        if (this.wrappedNodes != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                IWrappedNode3D iWrappedNode3D = this.wrappedNodes[nArray[i2]];
                if (iWrappedNode3D == null) continue;
                if (mixedListLogChannel.isDebug() && iWrappedNode3D.getWrappedChildren() != null) {
                    mixedListLogChannel.log(10000000, "MixedListRenderer#removeContent The content node %2 has %1 wrapped node children.", (long)iWrappedNode3D.getWrappedChildren().size(), (long)nArray[i2]);
                }
                iWrappedNode3D.removeAllChildren();
            }
        }
    }

    public void render(RedrawContext redrawContext) {
        mixedListAfterPaint.log(10000000, "MixedListRenderer#render nodes = %1", (Object)this.nodes);
        if (!this.controller.isActive()) {
            return;
        }
        if (this.nodes != null) {
            this.initializeNodes();
            this.applyProperties((RedrawContextHigh)redrawContext);
        }
    }

    public void setFooterContentVisible(boolean bl) {
        if (this.wrappedNodes != null && this.wrappedNodes[5] != null) {
            this.wrappedNodes[5].setVisible(bl);
        }
    }

    public void setW140FooterVisibility(boolean bl) {
        this.setProperty(this.nodes[0], "w140_footerVisibility", bl ? 1.0f : 0.0f);
        this.wrappedNodes[5].setOpacity(bl ? 1.0f : 0.0f);
        INode3D iNode3D = this.nodes[0];
        int n = 0;
        while ((long)n < iNode3D.getChildCount()) {
            INode3D iNode3D2 = iNode3D.getChildAtIndex(n);
            if (iNode3D2 != null) {
                if (iNode3D2.isValid() && iNode3D2.getName().equals("w140_Footer")) {
                    iNode3D2.setOpacity(bl ? 1.0f : 0.0f);
                    iNode3D2.dispose();
                    break;
                }
                iNode3D2.dispose();
            }
            ++n;
        }
    }

    protected void setW140Opacity(float f2) {
        if (this.wrappedNodes != null && this.wrappedNodes[0] != null) {
            this.wrappedNodes[0].setOpacity(f2);
        }
    }

    public void setW140Visible(boolean bl) {
        if (this.nodes == null || this.nodes[0] == null) {
            this.initializeNodes();
        }
        if (this.nodes == null || this.nodes[0] == null) {
            return;
        }
        mixedListLogChannel.log(10000000, "MixedListRenderer#setW140Visible %1", bl);
        if (this.nodes[0].isVisible() != bl) {
            this.nodes[0].setVisible(bl);
        }
    }

    public void setKzbIDs(int[] nArray) {
    }

    protected void setProperty(INode iNode, String string, float f2) {
        this.propertyCache.setProperty(iNode, string, f2);
    }

    public void invalidate() {
        if (this.nodes != null && this.nodes[0] != null) {
            this.propertyCache.setPropertyWithoutChangeCheck(this.nodes[0], "gp_invalidate", true);
        }
    }
}

