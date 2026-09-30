/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.OperationPanelController;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationPanelRendererHigh
extends AbstractRendererHigh {
    private final OperationPanelController controller;
    private IWrappedNode3D rootNode;
    private IWrappedNode3D background;
    private IWrappedNode3DImage cursor;
    private IWrappedNode3DImage spellerBackground;
    private IWrappedNode3DImage[] keys;
    private boolean resourcesLoaded = false;
    private int cursorposition = 0;
    boolean spellerAvailable = false;
    private static final int TUNER_MODE_EPG = 13;
    private static final int KEY_ID_SPELLER = 11;
    private static final int KEY_ID_TO_IMAGE_OFFSET = 12;
    private List keyIdImageMapping = Arrays.asList(new Object[]{new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5), new Integer(6), new Integer(7), new Integer(8), new Integer(9), new Integer(10)});
    private List spellerImageMapping = Arrays.asList(new Object[]{new Integer(20), new Integer(21), new Integer(22), new Integer(23), new Integer(24), new Integer(25), new Integer(26), new Integer(27), new Integer(28), new Integer(29)});
    private List additionalKeysImageMapping = Arrays.asList(new Object[]{new Integer(32), new Integer(33), new Integer(36), new Integer(38)});
    private Map keyIdBitmapIndexMap;
    private int alignment = 1;

    public OperationPanelRendererHigh(OperationPanelController operationPanelController) {
        this.controller = operationPanelController;
        this.initMap();
    }

    private void initMap() {
        this.keyIdBitmapIndexMap = new HashMap();
        this.mapBitmapIndexToKeyId(45, 26);
        this.mapBitmapIndexToKeyId(80, 27);
        this.mapBitmapIndexToKeyId(81, 28);
    }

    private void mapBitmapIndexToKeyId(int n, int n2) {
        this.keyIdBitmapIndexMap.put(new Integer(n), new Integer(n2));
    }

    private int getBitmapIndex(int n) {
        Integer n2 = (Integer)this.keyIdBitmapIndexMap.get(new Integer(n));
        if (n2 == null) {
            return -1;
        }
        return n2;
    }

    private void createNodes(RedrawContextHigh redrawContextHigh) {
        int n;
        int n2;
        if (this.rootNode == null) {
            this.rootNode = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("OperationPanelRootNode", this), this.controller.getWidth(), this.controller.getHeight());
        }
        if (this.background == null) {
            this.background = this.getEALManager().createNode3D(this.rootNode, "OperationPanelBackground", this.controller.getWidth(), this.controller.getHeight());
        }
        if (this.cursor == null) {
            this.cursor = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("OperationPanelCursor", this), this.getTextureDescription(this.controller.getIndexCursorImages(), true), 0, true, (Object)this);
        }
        int n3 = 0;
        if (this.keys == null) {
            this.keys = new IWrappedNode3DImage[50];
            n2 = this.controller.getPanelKeys().size();
            logOperationalPanel.log(10000000, "OperationPanelRendererHigh#createNodes panel keys: %1: ", (Object)this.controller.getPanelKeys());
            for (n = 0; n < n2; ++n) {
                Object object = this.controller.getPanelKeys().get(n);
                int n4 = (Integer)object;
                String string = StringUtilities.formatMessage("OperationPanelKey%1", new String[]{Integer.toString(n4)});
                IWrappedNode3DImage iWrappedNode3DImage = null;
                int n5 = 0;
                int n6 = this.getBitmapIndex(n4);
                if (n6 == -1) {
                    if (this.spellerImageMapping.contains(object)) {
                        n5 = 11;
                    } else if (n4 < 0) {
                        n5 = n4;
                    } else if (this.keyIdImageMapping.contains(object)) {
                        n5 = n4;
                    } else if (this.additionalKeysImageMapping.contains(object)) {
                        n5 = this.additionalKeysImageMapping.indexOf(object) + 12;
                    }
                    if (n5 == 0) {
                        this.controller.getPanelKeys().remove(n);
                        this.controller.getPanelKeysHandler().remove(n);
                        n2 = this.controller.getPanelKeys().size();
                        --n;
                        continue;
                    }
                    if (n5 == 11 && this.spellerAvailable) continue;
                    if (n5 == 11) {
                        this.spellerAvailable = true;
                    }
                    int n7 = 0;
                    n7 = n5 < 0 ? Math.abs(n5) + this.controller.getIndexAlignmentImages() : (this.controller.getTunerMode() != 13 || n5 > 4 ? n5 + this.controller.getIndexFunctionalKeysImages() : n5 + this.controller.getIndexFunctionalKeysOverlayImages());
                    iWrappedNode3DImage = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName(string, this), this.getTextureDescription(n7 - 1, true), 0, true, (Object)this);
                } else {
                    iWrappedNode3DImage = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName(string, this), this.getTextureDescription(n6, true), 0, true, (Object)this);
                }
                if (iWrappedNode3DImage == null) {
                    logOperationalPanel.log(100000, "OperationPanelRendererHigh#createNodes keyNode for key %1 could not created", (Object)string);
                    continue;
                }
                this.keys[n3] = iWrappedNode3DImage;
                ++n3;
            }
            this.controller.setRenderedKeys(n3 - 1);
        }
        if (this.background != null) {
            logOperationalPanel.log(10000000, "OperationPanelRendererHigh#createNodes background ");
            n2 = this.controller.getIndexBackgroundImages();
            this.createImage3D(n2, -1);
            for (n = 0; n < n3 - 1; ++n) {
                this.createImage3D(n2 + 1, n);
            }
            this.createImage3D(n2 + 2, -2);
        }
        if (this.spellerBackground == null) {
            this.spellerBackground = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("SpellerBackground", this), this.getTextureDescription(this.controller.getIndexSpellerBackgroundImages(), true), 0, true, (Object)this);
        }
        this.doLayout();
        this.updateCursorPosition();
        this.resourcesLoaded = true;
    }

    private IWrappedNode3DImage createImage3D(int n, int n2) {
        TextureDescription textureDescription = this.getTextureDescription(n, true);
        if (textureDescription == null) {
            logOperationalPanel.log(100000, "OperationPanelRendererHigh#createImage3D background image is missing ");
            return null;
        }
        IWrappedNode3DImage iWrappedNode3DImage = this.getEALManager().createImage3D(this.background, EALManager.createNodeName("OperationPanelBackground", n2, (AbstractRenderer)this), textureDescription, 0, true, (Object)this);
        return iWrappedNode3DImage;
    }

    public void render(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (!this.resourcesLoaded) {
            this.createNodes(redrawContextHigh);
            this.doLayout();
        }
        if (this.controller.getAlignment() != this.alignment) {
            this.alignment = this.controller.getAlignment();
            this.doLayout();
        }
        this.spellerBackground.setVisible(this.controller.isSpellerOpen());
        this.rootNode.setVisible(this.controller.isVisible());
        this.updateCursorPosition();
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
    }

    private void updateCursorPosition() {
        int n = 5;
        this.cursorposition = this.controller.getCursorposition();
        logOperationalPanel.log(10000000, "OperationPanelRendererHigh#updateCursorPosition cursorPos: %1", (long)this.cursorposition);
        if (this.keys == null) {
            return;
        }
        if (this.controller.getPanelKeys().size() - 1 > this.cursorposition && this.cursorposition >= 0) {
            IWrappedNode3DImage iWrappedNode3DImage = this.keys[this.cursorposition];
            if (iWrappedNode3DImage == null) {
                return;
            }
            this.cursor.setPosition(iWrappedNode3DImage.getX() - (float)n, iWrappedNode3DImage.getY() - (float)n, 0.0f);
        } else if (this.controller.getPanelKeys().size() > 0) {
            IWrappedNode3DImage iWrappedNode3DImage = this.keys[this.controller.getPanelKeys().size() - 1];
            this.cursor.setPosition(iWrappedNode3DImage.getX() - (float)n, iWrappedNode3DImage.getY() - (float)n, 0.0f);
        }
    }

    private void doLayout() {
        int n;
        int n2;
        int n3 = 0;
        int n4 = 0;
        if (this.background != null) {
            this.background.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
            List list = this.background.getWrappedChildren();
            if (list != null) {
                logOperationalPanel.log(10000000, "OperationPanelRendererHigh#doLayout childrensize: %1", (long)list.size());
                for (n2 = 0; n2 < list.size(); ++n2) {
                    IWrappedNode3D iWrappedNode3D = (IWrappedNode3D)list.get(n2);
                    if (n2 != 0) {
                        iWrappedNode3D.setPosition(n4, 0.0f, 0.0f);
                    } else {
                        n3 = (int)((iWrappedNode3D.getHeight() - (float)this.controller.getIconSize()) / 2.0f + (float)this.controller.getY());
                    }
                    n4 = (int)((float)n4 + iWrappedNode3D.getWidth());
                }
            }
        }
        if (this.spellerBackground != null) {
            this.spellerBackground.setPosition(this.controller.getSpeller().getX(), this.controller.getSpeller().getY() - 10, 0.0f);
        }
        if ((n = this.controller.getPanelKeys().size() - (this.spellerAvailable ? 9 : 0)) == 0) {
            return;
        }
        for (n2 = 0; n2 < n; ++n2) {
            if (this.keys[n2] == null && n2 != 0 && n2 != this.keys.length) {
                return;
            }
            if (this.controller.getAlignment() == 0 && n2 == 0) {
                this.keys[0].setVisible(false);
                this.keys[n - 1].setVisible(true);
                this.keys[n - 1].setPosition(this.calculateLeftOffset(n2, n4, n), n3, 0.0f);
                continue;
            }
            if (this.controller.getAlignment() == 1 && n2 == n - 1) {
                this.keys[n - 1].setVisible(false);
                this.keys[0].setVisible(true);
                this.keys[0].setPosition(this.calculateLeftOffset(0, n4, n), n3, 0.0f);
                continue;
            }
            this.keys[n2].setPosition(this.calculateLeftOffset(n2, n4, n), n3, 0.0f);
        }
    }

    private int calculateLeftOffset(int n, int n2, int n3) {
        int n4 = n + (this.controller.getAlignment() - 1);
        int n5 = n2 / n3 + this.controller.getIconGap() / 2 + this.controller.getIconGap() + (n4 - 1) * (this.controller.getIconSize() + this.controller.getIconGap());
        return n5 + this.controller.getX();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void disconnect() {
        this.resourcesLoaded = false;
        if (this.keys != null) {
            for (int i2 = 0; i2 < this.keys.length && this.keys[i2] != null; ++i2) {
                this.getEALManager().destroy(this.keys[i2]);
            }
            this.keys = null;
        }
        if (this.cursor != null) {
            this.getEALManager().destroy(this.cursor);
            this.cursor = null;
        }
        if (this.background != null) {
            List list = this.background.getWrappedChildren();
            while (!list.isEmpty()) {
                Object object = list.get(list.size() - 1);
                if (!(object instanceof IWrappedNode3D)) continue;
                this.getEALManager().destroy((IWrappedNode3D)object);
            }
            this.getEALManager().destroy(this.background);
            this.background = null;
        }
        if (this.spellerBackground != null) {
            this.getEALManager().destroy(this.spellerBackground);
            this.spellerBackground = null;
        }
        if (this.rootNode != null) {
            this.getEALManager().destroy(this.rootNode);
            this.rootNode = null;
        }
        this.spellerAvailable = false;
        super.disconnect();
    }
}

