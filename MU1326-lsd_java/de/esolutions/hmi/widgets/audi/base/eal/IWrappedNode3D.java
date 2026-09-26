/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode3D;
import java.util.List;

public interface IWrappedNode3D {
    public static final int CLIPPING_TYPE_INHERIT_FROM_ANCESTOR;
    public static final int CLIPPING_TYPE_OVERRIDE_ANCESTOR;
    public static final int CLIPPING_TYPE_INHERIT_TO_CHILDREN;
    public static final int CLIPPING_TYPE_CHILDREN_OVERRIDE;

    default public void setPosition(float f2, float f3, float f4) {
    }

    default public void setRotationX(float f2) {
    }

    default public void setRotationY(float f2) {
    }

    default public void setRotationZ(float f2) {
    }

    default public float getRotationX() {
    }

    default public float getRotationY() {
    }

    default public float getRotationZ() {
    }

    default public void setScale(float f2, float f3, float f4) {
    }

    default public void setOpacity(float f2) {
    }

    default public float getOpacity() {
    }

    default public void setVisible(boolean bl) {
    }

    default public boolean isVisible() {
    }

    default public boolean isValid() {
    }

    default public INode3D getNode() {
    }

    default public void add(IWrappedNode3D iWrappedNode3D) {
    }

    default public void addByIndex(IWrappedNode3D iWrappedNode3D, int n) {
    }

    default public boolean remove(IWrappedNode3D iWrappedNode3D) {
    }

    default public void setParent(IWrappedNode3D iWrappedNode3D) {
    }

    default public int getEALChildCount() {
    }

    default public List getWrappedChildren() {
    }

    default public float getUnscaledWidth() {
    }

    default public float getUnscaledHeight() {
    }

    default public float getWidth() {
    }

    default public float getHeight() {
    }

    default public void setSize(float f2, float f3) {
    }

    default public void resetTransformation() {
    }

    default public void updateClipping() {
    }

    default public boolean hasClippingChild() {
    }

    default public void setHasClippingChild(boolean bl) {
    }

    default public void setClipping(boolean bl) {
    }

    default public float getOriginY() {
    }

    default public float getOriginX() {
    }

    default public IWrappedNode3D getParent() {
    }

    default public float getX() {
    }

    default public float getY() {
    }

    default public float getZ() {
    }

    default public void updateHasClippingChild() {
    }

    default public boolean isClipping() {
    }

    default public float getScaleX() {
    }

    default public float getScaleY() {
    }

    default public float getScaleZ() {
    }

    default public void setClippingRectangle(float f2, float f3, float f4, float f5) {
    }

    default public void useClippingRectangle(boolean bl) {
    }

    default public void setClippingInheritance(int n) {
    }

    default public int getClippingInheritance() {
    }

    default public void dispose() {
    }

    default public float getScreenClippingX() {
    }

    default public float getScreenClippingY() {
    }

    default public float getScreenClippingWidth() {
    }

    default public float getScreenClippingHeight() {
    }

    default public int getScreenWidth() {
    }

    default public int getScreenHeight() {
    }

    default public void setScreenSize(int n, int n2) {
    }

    default public void updateScreenSize() {
    }

    default public String getNodeName() {
    }

    default public boolean isInstance() {
    }

    default public boolean setNodeName(String string) {
    }

    default public void setNodeIndex(int n) {
    }

    default public void setShouldFlipBack(boolean bl) {
    }

    default public int getNodeIndex() {
    }

    default public boolean invalidateObject() {
    }

    default public boolean removeWrappedChild(IWrappedNode3D iWrappedNode3D) {
    }

    default public void ignoreOpacity(boolean bl) {
    }

    default public float getCurrentNodeScaleX() {
    }

    default public float getCurrentNodeScaleY() {
    }

    default public void setHorizontalFlip(boolean bl) {
    }

    default public boolean isHorizontallyFlipped() {
    }

    default public void setLanguageOrientation(boolean bl) {
    }

    default public void removeAllChildren() {
    }

    default public boolean setDestroyedFlag() {
    }
}

