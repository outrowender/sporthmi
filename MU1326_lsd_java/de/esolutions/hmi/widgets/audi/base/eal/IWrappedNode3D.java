/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode3D;
import java.util.List;

public interface IWrappedNode3D {
    public static final int CLIPPING_TYPE_INHERIT_FROM_ANCESTOR = 1;
    public static final int CLIPPING_TYPE_OVERRIDE_ANCESTOR = 2;
    public static final int CLIPPING_TYPE_INHERIT_TO_CHILDREN = 16;
    public static final int CLIPPING_TYPE_CHILDREN_OVERRIDE = 32;

    public void setPosition(float var1, float var2, float var3);

    public void setRotationX(float var1);

    public void setRotationY(float var1);

    public void setRotationZ(float var1);

    public float getRotationX();

    public float getRotationY();

    public float getRotationZ();

    public void setScale(float var1, float var2, float var3);

    public void setOpacity(float var1);

    public float getOpacity();

    public void setVisible(boolean var1);

    public boolean isVisible();

    public boolean isValid();

    public INode3D getNode();

    public void add(IWrappedNode3D var1);

    public void addByIndex(IWrappedNode3D var1, int var2);

    public boolean remove(IWrappedNode3D var1);

    public void setParent(IWrappedNode3D var1);

    public int getEALChildCount();

    public List getWrappedChildren();

    public float getUnscaledWidth();

    public float getUnscaledHeight();

    public float getWidth();

    public float getHeight();

    public void setSize(float var1, float var2);

    public void resetTransformation();

    public void updateClipping();

    public boolean hasClippingChild();

    public void setHasClippingChild(boolean var1);

    public void setClipping(boolean var1);

    public float getOriginY();

    public float getOriginX();

    public IWrappedNode3D getParent();

    public float getX();

    public float getY();

    public float getZ();

    public void updateHasClippingChild();

    public boolean isClipping();

    public float getScaleX();

    public float getScaleY();

    public float getScaleZ();

    public void setClippingRectangle(float var1, float var2, float var3, float var4);

    public void useClippingRectangle(boolean var1);

    public void setClippingInheritance(int var1);

    public int getClippingInheritance();

    public void dispose();

    public float getScreenClippingX();

    public float getScreenClippingY();

    public float getScreenClippingWidth();

    public float getScreenClippingHeight();

    public int getScreenWidth();

    public int getScreenHeight();

    public void setScreenSize(int var1, int var2);

    public void updateScreenSize();

    public String getNodeName();

    public boolean isInstance();

    public boolean setNodeName(String var1);

    public void setNodeIndex(int var1);

    public void setShouldFlipBack(boolean var1);

    public int getNodeIndex();

    public boolean invalidateObject();

    public boolean removeWrappedChild(IWrappedNode3D var1);

    public void ignoreOpacity(boolean var1);

    public float getCurrentNodeScaleX();

    public float getCurrentNodeScaleY();

    public void setHorizontalFlip(boolean var1);

    public boolean isHorizontallyFlipped();

    public void setLanguageOrientation(boolean var1);

    public void removeAllChildren();

    public boolean setDestroyedFlag();
}

