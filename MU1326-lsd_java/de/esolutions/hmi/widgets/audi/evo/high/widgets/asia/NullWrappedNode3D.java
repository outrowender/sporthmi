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
    @Override
    public IINodeText getInterfaceText() {
        return null;
    }

    @Override
    public INode3DText getTextNode() {
        return null;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public INode3DQuickDraw getQuickDrawNode() {
        return null;
    }

    @Override
    public void add(float f2, float f3) {
    }

    @Override
    public void setLineWidth(float f2) {
    }

    public void setLineColor(colorRGBAf colorRGBAf2) {
    }

    @Override
    public void clearArea() {
    }

    @Override
    public void setText(String string) {
    }

    @Override
    public ITextLayout getLayout() {
        return null;
    }

    @Override
    public void notifyLayoutChanged(boolean bl) {
    }

    @Override
    public int[] getOnScreenCharPosition(int n) {
        return new int[0];
    }

    @Override
    public void setText(String string, IWrappedFont iWrappedFont) {
    }

    @Override
    public void setText(String string, IWrappedFont iWrappedFont, int n, EALManager eALManager) {
    }

    public void setColor(colorRGBAf colorRGBAf2) {
    }

    @Override
    public IWrappedFont getFont() {
        return null;
    }

    @Override
    public int getAbbreviateWidth() {
        return 0;
    }

    @Override
    public IINodeImage getInterfaceImage() {
        return null;
    }

    @Override
    public INode3DImage getImageNode() {
        return null;
    }

    @Override
    public String getFilename() {
        return null;
    }

    public boolean setModulateColor(colorRGBAf colorRGBAf2) {
        return false;
    }

    @Override
    public boolean setTexture(IWrappedTexture iWrappedTexture, boolean bl, Object object) {
        return false;
    }

    @Override
    public boolean setMaterial(IMaterial iMaterial) {
        return false;
    }

    @Override
    public IWrappedTexture getTexture() {
        return null;
    }

    @Override
    public void mirrorX() {
    }

    @Override
    public void mirrorY() {
    }

    @Override
    public void mirrorXY() {
    }

    @Override
    public void releaseTexture() {
    }

    @Override
    public void setPosition(float f2, float f3, float f4) {
    }

    @Override
    public void setRotationX(float f2) {
    }

    @Override
    public void setRotationY(float f2) {
    }

    @Override
    public void setRotationZ(float f2) {
    }

    @Override
    public float getRotationX() {
        return 0.0f;
    }

    @Override
    public float getRotationY() {
        return 0.0f;
    }

    @Override
    public float getRotationZ() {
        return 0.0f;
    }

    @Override
    public void setScale(float f2, float f3, float f4) {
    }

    @Override
    public void setOpacity(float f2) {
    }

    @Override
    public float getOpacity() {
        return 0.0f;
    }

    @Override
    public void setVisible(boolean bl) {
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public INode3D getNode() {
        return null;
    }

    @Override
    public void add(IWrappedNode3D iWrappedNode3D) {
    }

    @Override
    public void addByIndex(IWrappedNode3D iWrappedNode3D, int n) {
    }

    @Override
    public boolean remove(IWrappedNode3D iWrappedNode3D) {
        return false;
    }

    @Override
    public void setParent(IWrappedNode3D iWrappedNode3D) {
    }

    @Override
    public int getEALChildCount() {
        return 0;
    }

    @Override
    public List getWrappedChildren() {
        return null;
    }

    @Override
    public float getUnscaledWidth() {
        return 0.0f;
    }

    @Override
    public float getUnscaledHeight() {
        return 0.0f;
    }

    @Override
    public float getWidth() {
        return 0.0f;
    }

    @Override
    public float getHeight() {
        return 0.0f;
    }

    @Override
    public void setSize(float f2, float f3) {
    }

    @Override
    public void resetTransformation() {
    }

    @Override
    public void updateClipping() {
    }

    @Override
    public boolean hasClippingChild() {
        return false;
    }

    @Override
    public void setHasClippingChild(boolean bl) {
    }

    @Override
    public void setClipping(boolean bl) {
    }

    @Override
    public float getOriginY() {
        return 0.0f;
    }

    @Override
    public float getOriginX() {
        return 0.0f;
    }

    @Override
    public IWrappedNode3D getParent() {
        return null;
    }

    @Override
    public float getX() {
        return 0.0f;
    }

    @Override
    public float getY() {
        return 0.0f;
    }

    @Override
    public float getZ() {
        return 0.0f;
    }

    @Override
    public void updateHasClippingChild() {
    }

    @Override
    public boolean isClipping() {
        return false;
    }

    @Override
    public float getScaleX() {
        return 0.0f;
    }

    @Override
    public float getScaleY() {
        return 0.0f;
    }

    @Override
    public float getScaleZ() {
        return 0.0f;
    }

    @Override
    public void setClippingRectangle(float f2, float f3, float f4, float f5) {
    }

    @Override
    public void useClippingRectangle(boolean bl) {
    }

    @Override
    public void setClippingInheritance(int n) {
    }

    @Override
    public int getClippingInheritance() {
        return 0;
    }

    @Override
    public void dispose() {
    }

    @Override
    public float getScreenClippingX() {
        return 0.0f;
    }

    @Override
    public float getScreenClippingY() {
        return 0.0f;
    }

    @Override
    public float getScreenClippingWidth() {
        return 0.0f;
    }

    @Override
    public float getScreenClippingHeight() {
        return 0.0f;
    }

    @Override
    public int getScreenWidth() {
        return 0;
    }

    @Override
    public int getScreenHeight() {
        return 0;
    }

    @Override
    public void setScreenSize(int n, int n2) {
    }

    @Override
    public void updateScreenSize() {
    }

    @Override
    public String getNodeName() {
        return null;
    }

    @Override
    public boolean isInstance() {
        return false;
    }

    @Override
    public boolean setNodeName(String string) {
        return false;
    }

    @Override
    public void setNodeIndex(int n) {
    }

    @Override
    public void setShouldFlipBack(boolean bl) {
    }

    @Override
    public int getNodeIndex() {
        return 0;
    }

    @Override
    public boolean invalidateObject() {
        return false;
    }

    @Override
    public boolean removeWrappedChild(IWrappedNode3D iWrappedNode3D) {
        return false;
    }

    @Override
    public void ignoreOpacity(boolean bl) {
    }

    @Override
    public float getCurrentNodeScaleX() {
        return 0.0f;
    }

    @Override
    public float getCurrentNodeScaleY() {
        return 0.0f;
    }

    @Override
    public void setHorizontalFlip(boolean bl) {
    }

    @Override
    public boolean isHorizontallyFlipped() {
        return false;
    }

    @Override
    public void setLanguageOrientation(boolean bl) {
    }

    @Override
    public void setLineColor(int n) {
    }

    @Override
    public void setColor(int n) {
    }

    @Override
    public boolean setModulateColor(int n) {
        return false;
    }

    @Override
    public void removeAllChildren() {
    }

    @Override
    public boolean setDestroyedFlag() {
        return true;
    }
}

