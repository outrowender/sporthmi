/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.StringUtilityEAL;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.NavMapInfoTextWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import java.util.List;

public class IconLabelRendererHigh
extends AbstractRendererHigh
implements IconRenderer,
Alignment {
    private static final int NODE_INDEX_FOREGROUND;
    private int alignmentVert = 4;
    private int alignmentHoriz = 1;
    private IconLabelController controller;
    private IWrappedNode3D node;
    private IWrappedNode3DImage imageNode;
    private IWrappedNode3DText textNode;
    private IWrappedNode3DText textNode2;
    private IWrappedNode3DQuickDraw debugFrame;
    private IconCell cell;
    private String text;
    private int fontReference = -1;
    private int fontSize = -1;
    private int textColor = -1;
    private int deltaX = -1;
    private int deltaY = -1;
    private int textPos_x = -1;
    private int textPos_y = -1;
    private int textPos2_x = -1;
    private int textPos2_y = -1;
    private int scaleMode = 0;
    private int autoscaleModification = 0;
    private float scaleY = 1.0f;
    private float scaleX = 1.0f;
    private boolean isCenterAligned = false;
    public boolean debug = false;
    public static boolean showBounds;

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.imageNode == null && (this.controller.getTexture() != null || this.controller.hasPlaceholderSettings())) {
            this.createImageNodeIfNotExisting();
        }
        this.createTextNodeIfNotExisting();
        AbstractWidgetController abstractWidgetController = this.getAbstractController();
        if (this.node != null && this.node.isValid()) {
            float[] fArray = IconRendererHigh.calculateScaling(abstractWidgetController.getWidth(), abstractWidgetController.getHeight(), this.node.getUnscaledWidth(), this.node.getUnscaledHeight(), this.scaleMode, this.scaleX, this.scaleY, this.autoscaleModification);
            float f2 = 0.0f;
            float f3 = 0.0f;
            if (!this.isCenterAligned) {
                float f4 = this.node.getUnscaledWidth() * fArray[0];
                float f5 = this.node.getUnscaledHeight() * fArray[1];
                f2 = IconRendererHigh.calculateNodeOffset(abstractWidgetController.getWidth(), f4, this.alignmentHoriz);
                f3 = IconRendererHigh.calculateNodeOffset(abstractWidgetController.getHeight(), f5, this.alignmentVert);
            } else {
                f2 = -(fArray[0] * this.node.getUnscaledWidth()) / 2.0f;
                f3 = -(fArray[1] * this.node.getUnscaledHeight()) / 2.0f;
            }
            this.node.setPosition((float)abstractWidgetController.getX() + f2, (float)abstractWidgetController.getY() + f3, 0.0f);
            this.node.setVisible(abstractWidgetController.shouldRender());
            this.node.setScale(fArray[0], fArray[1], 1.0f);
        } else {
            iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#applyProperties Node is not valid or null (%1).", this.node == null);
        }
        if (this.textNode != null) {
            this.textNode.setVisible(this.controller.getID() != -1 && this.controller.hasContent());
            iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#applyProperties for text = %2, valid = %1", this.textNode.isValid(), (Object)this.textNode.getText());
        } else if (this.text != null) {
            iconLabelLogCh.log(10000, "IconLabelRendererHigh#applyProperties Text node is null, but text = %1 is not.", (Object)this.text);
        }
        if (this.textNode2 != null) {
            this.textNode2.setVisible(this.controller.getID() != -1 && this.controller.hasContent());
        }
        if (iconLabelLogCh.isDebug()) {
            this.logPositions();
        }
    }

    private void logPositions() {
        if (iconLabelLogCh.isDebug()) {
            iconLabelLogCh.log(-2137614336, new StringBuffer().append("IconLabelRendererHigh#logPositions isCenterAligned = {%1} , controller.getX( = {%2}, controller.getY() = {%3}, controller.getWidth() = {").append(String.valueOf(this.controller.getWidth())).append("}, ").append("controller.getHeight() = {").append(String.valueOf(this.controller.getHeight())).append("}").toString(), (Object)String.valueOf(this.isCenterAligned), (Object)String.valueOf(this.controller.getX()), (Object)String.valueOf(this.controller.getY()));
            if (this.imageNode != null) {
                iconLabelLogCh.log(-2137614336, new StringBuffer().append("IconLabelRendererHigh#logPositions#imageNodeimageNode.getWidth() = {").append(String.valueOf(this.imageNode.getWidth())).append("} ").append(", imageNode.getHeight() = {").append(String.valueOf(this.imageNode.getHeight())).append("}").append(", imageNode.getScaleX() = {").append(String.valueOf(this.imageNode.getScaleX())).append("}, ").append(", imageNode.getX() = {").append(String.valueOf(this.imageNode.getX())).append("}, ").append(", imageNode.getY() = {").append(String.valueOf(this.imageNode.getY())).append("}").toString());
            }
            if (this.textNode != null) {
                iconLabelLogCh.log(-2137614336, new StringBuffer().append("IconLabelRendererHigh#logPositions#textNodetextNode.getWidth() = {").append(String.valueOf(this.textNode.getWidth())).append("} ").append(", textNode.getHeight() = {").append(String.valueOf(this.textNode.getHeight())).append("}").append(", textNode.getX() = {").append(String.valueOf(this.textNode.getX())).append("}, ").append(", textNode.getY() = {").append(String.valueOf(this.textNode.getY())).append("}").toString());
            }
            if (this.textNode2 != null) {
                iconLabelLogCh.log(-2137614336, new StringBuffer().append("IconLabelRendererHigh#logPositions#textNode2textNode2.getWidth() = {").append(String.valueOf(this.textNode2.getWidth())).append("} ").append(", textNode2.getHeight() = {").append(String.valueOf(this.textNode2.getHeight())).append("}").append(", textNode2.getX() = {").append(String.valueOf(this.textNode2.getX())).append("}, ").append(", textNode2.getY() = {").append(String.valueOf(this.textNode2.getY())).append("}").toString());
            }
        }
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
    }

    private void createTextNodeIfNotExisting() {
        if (this.textNode == null && this.controller.hasContent()) {
            int n = this.controller.getIconType();
            if (n == 1) {
                IconCell iconCell = this.controller.getIconCell();
                this.text = iconCell.getIconText();
                if (this.text != null) {
                    this.fontReference = iconCell.getFontReference();
                    this.fontSize = iconCell.getFontSizeType() == 1 ? this.getTerminal().getLayout().getMappedFontSize(iconCell.getFontSize(), 1) : iconCell.getFontSize();
                    this.textColor = this.getTextColorARGB(iconCell);
                    this.deltaX = iconCell.getDeltaX();
                    this.deltaY = iconCell.getDeltaY();
                    iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#render fontReference = %1, fontSize = %2", (long)this.fontReference, (long)this.fontSize);
                    iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#render textColor = %1", (long)this.textColor);
                    if (this.fontSize > 0) {
                        IWrappedFont iWrappedFont = (IWrappedFont)this.getTerminal().getFontLoader().getFont(this.fontReference, this.fontSize);
                        if (iWrappedFont != null) {
                            StringUtilityEAL stringUtilityEAL = (StringUtilityEAL)this.getTerminal().getStringUtility();
                            stringUtilityEAL.setCurrentFont(this.getInheritedFont());
                            List list = stringUtilityEAL.wrapOnLineBreak(this.text, '\n');
                            int n2 = list.size();
                            if (n2 == 1) {
                                this.createTextNodeSingleLine(iWrappedFont);
                            } else if (n2 > 1) {
                                this.createTextNodeTwoLines(iWrappedFont, list);
                            }
                        } else {
                            iconLabelLogCh.log(10000, "IconLabelRendererHigh#render Font is null.");
                        }
                    } else {
                        iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#render Font size is %1", (long)this.fontSize);
                    }
                } else if (this.controller.getID() != -1) {
                    iconLabelLogCh.log(10000, "IconLabelRendererHigh#render Text of icon %1 is null", (long)this.controller.getID());
                }
            } else if (n == 0) {
                // empty if block
            }
        }
    }

    private void createTextNodeSingleLine(IWrappedFont iWrappedFont) {
        this.textNode = this.getEALManager().createText3D(this.node, EALManager.createNodeName("iconLabel_text", this), this.text, iWrappedFont);
        if (this.textNode == null) {
            mapOverlayLogCh.log(10000, "IconLabelRendererHigh#render Error creating text node with text %1.", (Object)this.text);
            return;
        }
        mapOverlayLogCh.log(-2137614336, "IconLabelRendererHigh#render Text node created with text = %1", (Object)this.text);
        this.textPos_x = (this.getPreferredWidth() - (int)this.textNode.getWidth()) / 2 + this.deltaX;
        this.textPos_y = (this.getPreferredHeight() + EALManager.getFontHeightUppercase(iWrappedFont)) / 2 - 1 + this.deltaY;
        int n = EALManager.createColorCode(this.textColor);
        this.textNode.getInterfaceText().setColor(n);
        this.textNode.setPosition(this.textPos_x, this.textPos_y, 0.0f);
        this.textNode.setNodeIndex(1);
    }

    private void createTextNodeTwoLines(IWrappedFont iWrappedFont, List list) {
        if (list.size() > 2) {
            iconLabelLogCh.log(10000, "IconLabelRendererHigh#createTextNodeTwoLines Text with more than 2 line (%1) not supported.", (long)list.size());
        }
        this.textNode = this.getEALManager().createText3D(this.node, EALManager.createNodeName("iconLabel_text", this), (String)list.get(0), iWrappedFont);
        if (this.textNode == null) {
            mapOverlayLogCh.log(10000, "IconLabelRendererHigh#render Error creating text node with text %1.", (Object)this.text);
            return;
        }
        this.textNode2 = this.getEALManager().createText3D(this.node, EALManager.createNodeName("iconLabel_text2", this), (String)list.get(1), iWrappedFont);
        if (this.textNode2 == null) {
            mapOverlayLogCh.log(10000, "IconLabelRendererHigh#render Error creating text node with text %1.", (Object)this.text);
            return;
        }
        this.textPos_x = (this.getPreferredWidth() - (int)this.textNode.getWidth()) / 2 + this.deltaX;
        this.textPos2_x = (this.getPreferredWidth() - (int)this.textNode2.getWidth()) / 2 + this.deltaX;
        int n = 2;
        int n2 = EALManager.getFontHeightUppercase(iWrappedFont);
        int n3 = this.getPreferredHeight() / 2 - 1 + this.deltaY;
        this.textPos_y = n3 - n;
        this.textPos2_y = n3 + n + n2;
        int n4 = EALManager.createColorCode(this.textColor);
        this.textNode.getInterfaceText().setColor(n4);
        this.textNode2.getInterfaceText().setColor(n4);
        this.textNode.setPosition(this.textPos_x, this.textPos_y, 0.0f);
        this.textNode2.setPosition(this.textPos2_x, this.textPos2_y, 0.0f);
        this.textNode.setNodeIndex(1);
        this.textNode2.setNodeIndex(1);
    }

    private void destroyNodesImageAndText() {
        iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#destroyNodesImageAndText");
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            if (this.imageNode != null) {
                eALManager.destroy(this.imageNode);
            }
            if (this.textNode != null) {
                eALManager.destroy(this.textNode);
            }
            if (this.textNode2 != null) {
                eALManager.destroy(this.textNode2);
            }
        }
        this.imageNode = null;
        this.textNode = null;
        this.textNode2 = null;
        this.text = null;
    }

    protected void destroyNodes() {
        this.destroyNodesImageAndText();
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            if (this.debugFrame != null) {
                eALManager.destroy(this.debugFrame);
            }
            eALManager.destroy(this.node);
        }
        this.node = null;
    }

    @Override
    public void disconnect() {
        this.destroyNodes();
        this.cell = null;
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public int getPreferredWidth() {
        if (!NavMapInfoTextWidget.isTarget()) {
            TextureDescription textureDescription = this.getTextureDescription(0, true);
            if (textureDescription == null) {
                return 0;
            }
            IWrappedTexture iWrappedTexture = textureDescription.getTexture(this);
            if (iWrappedTexture != null) {
                int n = iWrappedTexture.getWidth();
                iWrappedTexture.releaseTexture(true, this);
                return n;
            }
        }
        return this.controller.getBitmapWidth();
    }

    @Override
    public int getPreferredHeight() {
        if (!NavMapInfoTextWidget.isTarget()) {
            TextureDescription textureDescription = this.getTextureDescription(0, true);
            if (textureDescription == null) {
                return 0;
            }
            IWrappedTexture iWrappedTexture = textureDescription.getTexture(this);
            if (iWrappedTexture != null) {
                int n = iWrappedTexture.getHeight();
                iWrappedTexture.releaseTexture(true, this);
                return n;
            }
        }
        return this.controller.getBitmapHeight();
    }

    private int getTextColorARGB(IconCell iconCell) {
        return iconCell.getTextColor() >>> 8 | iconCell.getTextColor() << 24;
    }

    public IconLabelRendererHigh(IconLabelController iconLabelController) {
        this.controller = iconLabelController;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.node != null) {
                this.node.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        IconCell iconCell = this.controller.getIconCell();
        if (!Util.equals(this.cell, iconCell) || this.controller.hasDataChanged(true) || !NavMapInfoTextWidget.isTarget()) {
            iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#render Content changed.");
            this.cell = iconCell;
            EALManager eALManager = ((HMITerminalEAL)((Object)this.getTerminal())).getEALManager();
            int n = redrawContext.getCalculatedNodeIndex(this.controller.getDepth());
            if (this.node == null) {
                this.node = eALManager.createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("iconCell", this.controller.getID(), (AbstractRenderer)this), this.getPreferredWidth(), this.getPreferredHeight(), n);
            } else {
                this.node.setNodeIndex(n);
                this.node.setSize(this.getPreferredWidth(), this.getPreferredHeight());
                this.node.setNodeName(EALManager.createNodeName("iconCell", this.controller.getID(), (AbstractRenderer)this));
            }
            this.destroyNodesImageAndText();
            this.createImageNodeIfNotExisting();
            if (showBounds) {
                int n2 = this.getPreferredWidth();
                int n3 = this.getPreferredHeight();
                if (this.debugFrame == null) {
                    this.debugFrame = eALManager.createQuickDrawNode3D(this.node, "QuickDebugNode", n2, n3, 0);
                    if (this.debugFrame == null) {
                        iconLabelLogCh.log(10000, "IconLabelRendererHigh#render Creating quick draw debug node failed.");
                    } else {
                        this.debugFrame.setLineWidth(2.0f);
                        int n4 = EALManager.createColorCode(-65281);
                        this.debugFrame.setLineColor(n4);
                        this.debugFrame.setPosition(0.0f, 0.0f, 0.0f);
                        this.debugFrame.setVisible(true);
                        this.debugFrame.add(1.0f, 1.0f);
                        this.debugFrame.add(n2 - 1, 1.0f);
                        this.debugFrame.add(n2 - 1, n3 - 1);
                        this.debugFrame.add(1.0f, n3 - 1);
                        this.debugFrame.add(1.0f, 1.0f);
                        this.debugFrame.getQuickDrawNode().addSeparator();
                    }
                } else {
                    this.debugFrame.setNodeIndex(5);
                }
            }
            this.createTextNodeIfNotExisting();
        } else {
            int n = this.cell == null ? -1 : this.cell.getResourceLocator().getResourceID();
            int n5 = iconCell == null ? -1 : iconCell.getResourceLocator().getResourceID();
            iconLabelLogCh.log(-2137614336, "IconLabelRendererHigh#render Content has not changed (old = %1, new = %2).", (long)n, (long)n5);
        }
        this.applyProperties(redrawContextHigh);
    }

    private void createImageNodeIfNotExisting() {
        IWrappedTexture iWrappedTexture;
        EALManager eALManager = ((HMITerminalEAL)((Object)this.getTerminal())).getEALManager();
        if (!NavMapInfoTextWidget.isTarget()) {
            if (this.imageNode == null) {
                this.imageNode = eALManager.createImage3D(this.node, EALManager.createNodeName("iconLabel-icon-debug", this), this.getTextureDescription(0, true), 0, true, (Object)this);
            }
        } else if (this.imageNode == null && (iWrappedTexture = this.controller.getTexture()) != null) {
            this.imageNode = eALManager.createImage3D(this.node, EALManager.createNodeName("iconLabel-icon", this), iWrappedTexture.getDescription(), 0, true, (Object)this);
        }
        this.node.setVisible(false);
        this.node.setSize(this.getPreferredWidth(), this.getPreferredHeight());
    }

    @Override
    public void setAlignment(int n, int n2) {
        this.alignmentVert = n2;
        this.alignmentHoriz = n;
    }

    public int getScaleMode() {
        return this.scaleMode;
    }

    @Override
    public void setScaleMode(int n) {
        this.scaleMode = n;
    }

    @Override
    public String getDiagnosisText() {
        return null;
    }

    @Override
    public void setScaleFactor(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
    }

    public int getAutoscaleModification() {
        return this.autoscaleModification;
    }

    @Override
    public void setAutoscaleModification(int n) {
        this.autoscaleModification = n;
    }

    @Override
    public void setRotationY(float f2) {
    }

    @Override
    public void setRotationZ(float f2) {
    }

    public void setCenterAligned(boolean bl) {
        this.isCenterAligned = bl;
    }

    static {
        showBounds = false;
    }
}

