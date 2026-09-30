/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.esolutions.graphics.eal.api.IINodeImage;
import de.esolutions.graphics.eal.api.IINodeText;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DImage;
import de.esolutions.graphics.eal.api.INode3DQuickDraw;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DTextMultiSection;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import java.util.List;

public final class NullWrappedNode3D
implements IWrappedNode3D,
IWrappedNode3DImage,
IWrappedNode3DText,
IWrappedNode3DTextMultiSection,
IWrappedNode3DQuickDraw {
    public IINodeText getInterfaceText() {
        return null;
    }

    public INode3DText getTextNode() {
        return null;
    }

    public String getText() {
        return null;
    }

    public INode3DQuickDraw getQuickDrawNode() {
        return null;
    }

    public void add(float f2, float f3) {
    }

    public void setLineWidth(float f2) {
    }

    public void setLineColor(colorRGBAf colorRGBAf2) {
    }

    public void clearArea() {
    }

    public void setText(String string) {
    }

    public ITextLayout getLayout() {
        return null;
    }

    public void notifyLayoutChanged(boolean bl) {
    }

    public int[] getOnScreenCharPosition(int n) {
        return new int[0];
    }

    public void setText(String string, IWrappedFont iWrappedFont) {
    }

    public void setText(String string, IWrappedFont iWrappedFont, int n, EALManager eALManager) {
    }

    public void setColor(colorRGBAf colorRGBAf2) {
    }

    public IWrappedFont getFont() {
        return null;
    }

    public int getAbbreviateWidth() {
        return 0;
    }

    public IINodeImage getInterfaceImage() {
        return null;
    }

    public INode3DImage getImageNode() {
        return null;
    }

    public String getFilename() {
        return null;
    }

    public boolean setModulateColor(colorRGBAf colorRGBAf2) {
        return false;
    }

    public boolean setTexture(IWrappedTexture iWrappedTexture, boolean bl, Object object) {
        return false;
    }

    public boolean setMaterial(IMaterial iMaterial) {
        return false;
    }

    public IWrappedTexture getTexture() {
        return null;
    }

    public void mirrorX() {
    }

    public void mirrorY() {
    }

    public void mirrorXY() {
    }

    public void releaseTexture() {
    }

    public void setPosition(float f2, float f3, float f4) {
    }

    public void setRotationX(float f2) {
    }

    public void setRotationY(float f2) {
    }

    public void setRotationZ(float f2) {
    }

    public float getRotationX() {
        return 0.0f;
    }

    public float getRotationY() {
        return 0.0f;
    }

    public float getRotationZ() {
        return 0.0f;
    }

    public void setScale(float f2, float f3, float f4) {
    }

    public void setOpacity(float f2) {
    }

    public float getOpacity() {
        return 0.0f;
    }

    public void setVisible(boolean bl) {
    }

    public boolean isVisible() {
        return false;
    }

    public boolean isValid() {
        return false;
    }

    public INode3D getNode() {
        return null;
    }

    public void add(IWrappedNode3D iWrappedNode3D) {
    }

    public void addByIndex(IWrappedNode3D iWrappedNode3D, int n) {
    }

    public boolean remove(IWrappedNode3D iWrappedNode3D) {
        return false;
    }

    public void setParent(IWrappedNode3D iWrappedNode3D) {
    }

    public int getEALChildCount() {
        return 0;
    }

    public List getWrappedChildren() {
        return null;
    }

    public float getUnscaledWidth() {
        return 0.0f;
    }

    public float getUnscaledHeight() {
        return 0.0f;
    }

    public float getWidth() {
        return 0.0f;
    }

    public float getHeight() {
        return 0.0f;
    }

    public void setSize(float f2, float f3) {
    }

    public void resetTransformation() {
    }

    public void updateClipping() {
    }

    public boolean hasClippingChild() {
        return false;
    }

    public void setHasClippingChild(boolean bl) {
    }

    public void setClipping(boolean bl) {
    }

    public float getOriginY() {
        return 0.0f;
    }

    public float getOriginX() {
        return 0.0f;
    }

    public IWrappedNode3D getParent() {
        return null;
    }

    public float getX() {
        return 0.0f;
    }

    public float getY() {
        return 0.0f;
    }

    public float getZ() {
        return 0.0f;
    }

    public void updateHasClippingChild() {
    }

    public boolean isClipping() {
        return false;
    }

    public float getScaleX() {
        return 0.0f;
    }

    public float getScaleY() {
        return 0.0f;
    }

    public float getScaleZ() {
        return 0.0f;
    }

    public void setClippingRectangle(float f2, float f3, float f4, float f5) {
    }

    public void useClippingRectangle(boolean bl) {
    }

    public void setClippingInheritance(int n) {
    }

    public int getClippingInheritance() {
        return 0;
    }

    public void dispose() {
    }

    public float getScreenClippingX() {
        return 0.0f;
    }

    public float getScreenClippingY() {
        return 0.0f;
    }

    public float getScreenClippingWidth() {
        return 0.0f;
    }

    public float getScreenClippingHeight() {
        return 0.0f;
    }

    public int getScreenWidth() {
        return 0;
    }

    public int getScreenHeight() {
        return 0;
    }

    public void setScreenSize(int n, int n2) {
    }

    public void updateScreenSize() {
    }

    public String getNodeName() {
        return null;
    }

    public boolean isInstance() {
        return false;
    }

    public boolean setNodeName(String string) {
        return false;
    }

    public void setNodeIndex(int n) {
    }

    public void setShouldFlipBack(boolean bl) {
    }

    public int getNodeIndex() {
        return 0;
    }

    public boolean invalidateObject() {
        return false;
    }

    public boolean removeWrappedChild(IWrappedNode3D iWrappedNode3D) {
        return false;
    }

    public void ignoreOpacity(boolean bl) {
    }

    public float getCurrentNodeScaleX() {
        return 0.0f;
    }

    public float getCurrentNodeScaleY() {
        return 0.0f;
    }

    public void setHorizontalFlip(boolean bl) {
    }

    public boolean isHorizontallyFlipped() {
        return false;
    }

    public void setLanguageOrientation(boolean bl) {
    }

    public void setLineColor(int n) {
    }

    public void setColor(int n) {
    }

    public boolean setModulateColor(int n) {
        return false;
    }

    public void removeAllChildren() {
    }

    public boolean setDestroyedFlag() {
        return true;
    }
}

