/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DVisibility;
import java.util.ArrayList;
import java.util.List;

public class WrappedNode3D
implements IWrappedNode3D,
IWidgetLogChannel {
    protected final INode3D node;
    private float rotX;
    private float rotY;
    private float rotZ;
    protected float posX;
    protected float posY;
    protected float posZ;
    protected float scaleX = 1.0f;
    protected float scaleY = 1.0f;
    protected float scaleZ = 1.0f;
    protected float unscaledWidth;
    protected float unscaledHeight;
    protected IWrappedNode3D parent;
    private int screenWidth;
    private int screenHeight;
    private boolean clipping;
    protected List children;
    private boolean hasClippingChild;
    protected boolean visible = true;
    private float opacity = 1.0f;
    private float clippingX;
    private float clippingY;
    private float clippingWidth;
    private float clippingHeight;
    private float screenClippingX;
    private float screenClippingY;
    private float screenClippingWidth;
    private float screenClippingHeight;
    private boolean useClippingRectangle;
    private int clippingInheritanceType = 34;
    private final boolean isInstance;
    private int nodeIndex;
    private float currentNodeScaleX = 1.0f;
    private float currentNodeScaleY = 1.0f;
    private float currentNodeScaleZ = 1.0f;
    protected boolean shouldFlipBack = false;
    protected boolean ignoreOpacity;
    private boolean flipHorizontally;
    protected boolean isLtr = true;
    private boolean destroyed;

    public WrappedNode3D(INode3D iNode3D, float f2, float f3, boolean bl, int n, boolean bl2) {
        this.node = iNode3D;
        this.isInstance = bl;
        this.unscaledWidth = f2;
        this.unscaledHeight = f3;
        this.nodeIndex = n;
        this.opacity = this.getEALOpacity();
        this.visible = iNode3D.isVisible();
        this.isLtr = bl2;
    }

    @Override
    public void setShouldFlipBack(boolean bl) {
        this.shouldFlipBack = bl;
        this.updateScaleAndTranslation();
    }

    @Override
    public boolean setDestroyedFlag() {
        if (this.destroyed) {
            if (logChannel3DEngine.isDebug()) {
                logChannel3DEngine.log(10000, "WrappedNode3D#destroy %1 already destroyed", (Object)this, new Throwable("already destroyed"));
            } else {
                logChannel3DEngine.log(10000, "WrappedNode3D#destroy %1 already destroyed", (Object)this);
            }
            return false;
        }
        this.destroyed = true;
        return true;
    }

    private float getEALOpacity() {
        if (this.node != null) {
            return this.node.getOpacityRecursive();
        }
        return 1.0f;
    }

    @Override
    public String getNodeName() {
        return this.node.getName();
    }

    @Override
    public void updateScreenSize() {
        if (this.parent != null) {
            this.setScreenSize(this.parent.getScreenWidth(), this.parent.getScreenHeight());
        }
    }

    @Override
    public void setScreenSize(int n, int n2) {
        if (n == this.screenWidth && n2 == this.screenHeight) {
            return;
        }
        this.screenWidth = n;
        this.screenHeight = n2;
        if (this.children != null) {
            for (int i2 = 0; i2 < this.children.size(); ++i2) {
                IWrappedNode3D iWrappedNode3D = (IWrappedNode3D)this.children.get(i2);
                iWrappedNode3D.updateScreenSize();
            }
        }
        this.updateClipping();
    }

    @Override
    public void setPosition(float f2, float f3, float f4) {
        this.posX = f2;
        this.posY = f3;
        this.posZ = f4;
        this.updateScaleAndTranslation();
    }

    protected void updateScaleAndTranslation() {
        this.storePosition();
        float f2 = this.shouldFlipBack() != this.isHorizontallyFlipped() ? -this.scaleX : this.scaleX;
        if (this.currentNodeScaleX == f2 && this.currentNodeScaleY == this.scaleY && this.currentNodeScaleZ == this.scaleZ) {
            return;
        }
        this.node.setScale(f2, this.scaleY, this.scaleZ);
        this.currentNodeScaleX = f2;
        this.currentNodeScaleY = this.scaleY;
        this.currentNodeScaleZ = this.scaleZ;
        this.updateClipping();
    }

    public void storePosition() {
        float f2;
        float f3;
        if (this.parent == null) {
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            f3 = this.parent.getOriginX();
            f2 = this.parent.getOriginY();
        }
        float f4 = this.posX + this.getOriginX() - f3;
        float f5 = this.posY + this.getOriginY() - f2;
        float f6 = this.posZ;
        float f7 = this.shouldFlipBack() != this.isHorizontallyFlipped() ? f4 + this.getWidth() : f4;
        if (!WrappedNode3D.hasTranslation(this.node, f7, f5, f6)) {
            this.node.setTranslation(f7, f5, f6);
        }
        this.updateClipping();
    }

    private static boolean hasTranslation(INode3D iNode3D, float f2, float f3, float f4) {
        if (iNode3D.getTranslationX() != f2) {
            return false;
        }
        if (iNode3D.getTranslationY() != f3) {
            return false;
        }
        return iNode3D.getTranslationZ() == f4;
    }

    @Override
    public float getOriginX() {
        return 0.0f;
    }

    @Override
    public float getOriginY() {
        return 0.0f;
    }

    @Override
    public void setRotationX(float f2) {
        if (this.rotX == f2) {
            return;
        }
        float f3 = f2 - this.rotX;
        if (f3 != 0.0f) {
            this.node.rotateX(f3);
        }
        this.rotX = f2;
    }

    @Override
    public void setRotationY(float f2) {
        if (this.rotY == f2) {
            return;
        }
        float f3 = f2 - this.rotY;
        if (f3 != 0.0f) {
            this.node.rotateY(f3);
        }
        this.rotY = f2;
    }

    @Override
    public void setRotationZ(float f2) {
        if (this.rotZ == f2) {
            return;
        }
        float f3 = f2 - this.rotZ;
        if (f3 != 0.0f) {
            this.node.rotateZ(f3);
        }
        this.rotZ = f2;
    }

    @Override
    public float getRotationX() {
        return this.rotX;
    }

    @Override
    public float getRotationY() {
        return this.rotY;
    }

    @Override
    public float getRotationZ() {
        return this.rotZ;
    }

    @Override
    public void setScale(float f2, float f3, float f4) {
        this.scaleX = f2;
        this.scaleY = f3;
        this.scaleZ = f4;
        this.updateScaleAndTranslation();
    }

    protected boolean shouldFlipBack() {
        return this.shouldFlipBack;
    }

    private void setOpacityForced(float f2) {
        this.opacity = f2;
        if (!this.ignoreOpacity) {
            this.node.setOpacity(f2, true);
        }
    }

    @Override
    public void setOpacity(float f2) {
        float f3 = this.getEALOpacity();
        if (f3 == f2) {
            return;
        }
        this.opacity = f2;
        if (!this.ignoreOpacity) {
            this.node.setOpacity(f2, true);
        }
    }

    @Override
    public float getOpacity() {
        return this.opacity;
    }

    @Override
    public void setVisible(boolean bl) {
        if (this.visible == bl) {
            return;
        }
        this.visible = bl;
        this.node.setVisible(bl);
        if (this.parent != null && this.parent instanceof WrappedNode3DVisibility) {
            ((WrappedNode3DVisibility)this.parent).updateVisibility();
        }
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public boolean isValid() {
        if (EALManager.IGNORE_INVALID_EAL_NODES) {
            return true;
        }
        return this.node.isValid();
    }

    @Override
    public INode3D getNode() {
        return this.node;
    }

    private void afterAdd(IWrappedNode3D iWrappedNode3D) {
        iWrappedNode3D.setParent(this);
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(iWrappedNode3D);
        if (iWrappedNode3D.isClipping() || iWrappedNode3D.hasClippingChild()) {
            this.setHasClippingChild(true);
            for (IWrappedNode3D iWrappedNode3D2 = this.parent; iWrappedNode3D2 != null && !iWrappedNode3D2.hasClippingChild(); iWrappedNode3D2 = iWrappedNode3D2.getParent()) {
                iWrappedNode3D2.setHasClippingChild(true);
            }
        }
        this.setOpacityForced(this.opacity);
    }

    @Override
    public void add(IWrappedNode3D iWrappedNode3D) {
        this.addByIndex(iWrappedNode3D, iWrappedNode3D.getNodeIndex());
    }

    @Override
    public void addByIndex(IWrappedNode3D iWrappedNode3D, int n) {
        if (iWrappedNode3D != null) {
            if (!this.assertNoAncestor(iWrappedNode3D)) {
                return;
            }
            iWrappedNode3D.setNodeIndex(n);
            if (this.node != null) {
                this.node.addByIndex(iWrappedNode3D.getNode(), n);
                this.afterAdd(iWrappedNode3D);
            }
        }
    }

    private boolean assertNoAncestor(IWrappedNode3D iWrappedNode3D) {
        if (!EALManager.CHECK_SCENEGRAPH_CONSISTENCY) {
            return true;
        }
        if (this == iWrappedNode3D) {
            logChannel3DEngine.log(10000, "EALManager#assertNoAncestor: try to add node to itself. Name: %1, node: %1", (Object)this.getNodeName(), (Object)this);
            logChannel3DEngine.log(10000, "EALManager#assertNoAncestor: stacktrace of failure (addToSelf):", new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            return false;
        }
        int n = 1;
        for (IWrappedNode3D iWrappedNode3D2 = this.parent; iWrappedNode3D2 != null; iWrappedNode3D2 = iWrappedNode3D2.getParent()) {
            if (iWrappedNode3D2 == iWrappedNode3D) {
                logChannel3DEngine.log(10000, "EALManager#assertNoAncestor: try to an ancestor node (level: %3) as child. child name: %1, child node: %2", (Object)iWrappedNode3D.getNodeName(), (Object)iWrappedNode3D, (long)n);
                logChannel3DEngine.log(10000, "EALManager#assertNoAncestor: this node name: %1, this node: %2", (Object)this.getNodeName(), (Object)this);
                logChannel3DEngine.log(10000, "EALManager#assertNoAncestor: stacktrace of failure (addAncestor):", new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public boolean remove(IWrappedNode3D iWrappedNode3D) {
        if (logChannel3DEngine.isDebug()) {
            logChannel3DEngine.log(-2137614336, "WrappedNode3D#remove: Removing '%1' from '%2'", (Object)iWrappedNode3D.getNode().getName(), (Object)this.node.getName());
        }
        if (!this.node.remove(iWrappedNode3D.getNode())) {
            logChannel3DEngine.log(-1601830656, "WrappedNode3D#remove: Could not remove '%1' from '%2'", (Object)iWrappedNode3D.getNode().getName(), (Object)this.node.getName());
            return false;
        }
        iWrappedNode3D.setParent(null);
        if (this.children != null) {
            this.children.remove(iWrappedNode3D);
        }
        if (iWrappedNode3D.isClipping() || iWrappedNode3D.hasClippingChild()) {
            for (IWrappedNode3D iWrappedNode3D2 = this; iWrappedNode3D2 != null; iWrappedNode3D2 = iWrappedNode3D2.getParent()) {
                iWrappedNode3D2.updateHasClippingChild();
                if (iWrappedNode3D2.hasClippingChild()) break;
            }
        }
        return true;
    }

    @Override
    public boolean removeWrappedChild(IWrappedNode3D iWrappedNode3D) {
        if (logChannel3DEngine.isDebug()) {
            logChannel3DEngine.log(-2137614336, "WrappedNode3D#removeWrappedChild: Removing '%1' from '%2'", (Object)iWrappedNode3D.getNode().getName(), (Object)this.node.getName());
        }
        iWrappedNode3D.setParent(null);
        if (this.children != null && !this.children.remove(iWrappedNode3D)) {
            logChannel3DEngine.log(-1601830656, "WrappedNode3D#removeWrappedChild: Node '%1' is not a child of '%2'", (Object)iWrappedNode3D.getNode().getName(), (Object)this.node.getName());
            return false;
        }
        if (iWrappedNode3D.isClipping() || iWrappedNode3D.hasClippingChild()) {
            for (IWrappedNode3D iWrappedNode3D2 = this; iWrappedNode3D2 != null; iWrappedNode3D2 = iWrappedNode3D2.getParent()) {
                iWrappedNode3D2.updateHasClippingChild();
                if (iWrappedNode3D2.hasClippingChild()) break;
            }
        }
        return true;
    }

    @Override
    public void removeAllChildren() {
        long l;
        if (this.node == null) {
            logChannel3DEngine.log(10000, "WrappedNode3D#removeAllChildren: node is null");
            return;
        }
        if (this.children != null) {
            boolean bl = false;
            while (!bl && this.children.size() > 0) {
                int n = this.children.size();
                IWrappedNode3D iWrappedNode3D = (IWrappedNode3D)this.children.get(0);
                this.remove(iWrappedNode3D);
                if (this.children.size() != n) continue;
                bl = true;
                logChannel3DEngine.log(10000, "WrappedNode3D#removeAllChildren: could not remove child %1 from %2", (Object)iWrappedNode3D, (Object)this);
                this.children.clear();
            }
        }
        if ((l = this.node.getChildCount()) > 0L) {
            logChannel3DEngine.log(10000, "WrappedNode3D#removeAllChildren: could not remove %2 child(ren) from %1", (Object)this, l);
            for (long i2 = 0L; i2 < l; ++i2) {
                INode3D iNode3D = this.node.getChildAtIndex(i2);
                if (iNode3D.isValid()) {
                    logChannel3DEngine.log(10000, "WrappedNode3D#removeAllChildren: child %1: %2", (Object)iNode3D.getName(), i2);
                } else {
                    logChannel3DEngine.log(10000, "WrappedNode3D#removeAllChildren: child %1 invalid", i2);
                }
                iNode3D.dispose();
            }
            if (!this.node.clear()) {
                logChannel3DEngine.log(10000, "WrappedNode3D#removeAllChildren: could not remove eal children from %1", (Object)this);
            }
        }
    }

    @Override
    public void setParent(IWrappedNode3D iWrappedNode3D) {
        if (this.parent == iWrappedNode3D) {
            return;
        }
        this.parent = iWrappedNode3D;
        this.updateScreenSize();
        this.storePosition();
    }

    @Override
    public int getEALChildCount() {
        return (int)this.node.getChildCount();
    }

    @Override
    public List getWrappedChildren() {
        return this.children;
    }

    @Override
    public float getWidth() {
        return Math.abs(this.unscaledWidth * this.scaleX);
    }

    @Override
    public float getHeight() {
        return this.unscaledHeight * this.scaleY;
    }

    @Override
    public float getUnscaledWidth() {
        return this.unscaledWidth;
    }

    @Override
    public float getUnscaledHeight() {
        return this.unscaledHeight;
    }

    @Override
    public void setSize(float f2, float f3) {
        if (this.unscaledWidth == f2 && this.unscaledHeight == f3) {
            return;
        }
        this.unscaledWidth = f2;
        this.unscaledHeight = f3;
        this.storePosition();
    }

    @Override
    public void setClipping(boolean bl) {
        if (this.clipping == bl) {
            return;
        }
        this.clipping = bl;
        if (bl) {
            this.clip();
            for (IWrappedNode3D iWrappedNode3D = this.parent; iWrappedNode3D != null && !iWrappedNode3D.hasClippingChild(); iWrappedNode3D = iWrappedNode3D.getParent()) {
                iWrappedNode3D.setHasClippingChild(true);
            }
        } else {
            this.unclip();
            for (IWrappedNode3D iWrappedNode3D = this; iWrappedNode3D != null; iWrappedNode3D = iWrappedNode3D.getParent()) {
                iWrappedNode3D.updateHasClippingChild();
                if (!iWrappedNode3D.hasClippingChild()) {
                    continue;
                }
                break;
            }
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void unclip() {
        this.screenClippingX = 0.0f;
        this.screenClippingY = 0.0f;
        this.screenClippingWidth = this.screenWidth;
        this.screenClippingHeight = this.screenHeight;
        this.updateClippingInheritance();
        float f2 = this.clipRound(WrappedNode3D.getScreenCoordinate(this.screenClippingX, this.screenWidth));
        int n = EALManager.isAnnotationsEnabled() ? 192 : (int)0.0f;
        float f3 = this.clipRound(1.0f - WrappedNode3D.getScreenCoordinate(this.screenClippingY + this.screenClippingHeight + n, this.screenHeight));
        float f4 = this.clipRound(WrappedNode3D.getScreenCoordinate(this.screenClippingWidth, this.screenWidth));
        float f5 = this.clipRound(WrappedNode3D.getScreenCoordinate(this.screenClippingHeight, this.screenHeight));
        this.node.clip(f2, f3, f4, f5);
        if (this.hasClippingChild) {
            for (int i2 = 0; i2 < this.children.size(); ++i2) {
                IWrappedNode3D iWrappedNode3D = (IWrappedNode3D)this.children.get(i2);
                iWrappedNode3D.updateClipping();
            }
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void clip() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        IWrappedNode3D iWrappedNode3D = this;
        if (this.useClippingRectangle) {
            f7 = this.clippingX;
            f6 = this.clippingY;
            f5 = this.clippingWidth;
            f4 = this.clippingHeight;
        } else {
            f7 = 0.0f;
            f6 = 0.0f;
            f5 = this.unscaledWidth;
            f4 = this.unscaledHeight;
        }
        while (iWrappedNode3D != null) {
            f3 = iWrappedNode3D.getCurrentNodeScaleX();
            f2 = iWrappedNode3D.getCurrentNodeScaleY();
            f7 *= f3;
            f6 *= f2;
            f5 *= f3;
            f4 *= f2;
            INode3D iNode3D = iWrappedNode3D.getNode();
            f7 += iNode3D.getTranslationX();
            f6 += iNode3D.getTranslationY();
            iWrappedNode3D = iWrappedNode3D.getParent();
        }
        f3 = Math.min(f7, f7 + f5);
        f2 = Math.min(f6, f6 + f4);
        this.screenClippingX = this.crop(f3, 0.0f, this.screenWidth);
        this.screenClippingY = this.crop(f2, 0.0f, this.screenHeight);
        this.screenClippingWidth = this.crop(f3 + Math.abs(f5), 0.0f, this.screenWidth) - this.screenClippingX;
        this.screenClippingHeight = this.crop(f2 + Math.abs(f4), 0.0f, this.screenHeight) - this.screenClippingY;
        this.updateClippingInheritance();
        if (this.screenWidth == 0 || this.screenHeight == 0) {
            if (this.parent == null) {
                logChannel3DEngine.log(-1601830656, "WrappedNode3D#clip: parent is still null and screen size is not set. screen width: %1, height: %2", (long)this.screenWidth, (long)this.screenHeight);
            } else {
                logChannel3DEngine.log(10000, "WrappedNode3D#clip: screen size is invalid. width: %2, height: %3, parent: %1", (Object)this.parent, (long)this.screenWidth, (long)this.screenHeight);
            }
            return;
        }
        int n = EALManager.isAnnotationsEnabled() ? 192 : (int)0.0f;
        float f8 = WrappedNode3D.getScreenCoordinate(this.screenClippingX, this.screenWidth);
        float f9 = 1.0f - WrappedNode3D.getScreenCoordinate(this.screenClippingY + this.screenClippingHeight + n, this.screenHeight);
        float f10 = WrappedNode3D.getScreenCoordinate(this.screenClippingWidth, this.screenWidth);
        float f11 = WrappedNode3D.getScreenCoordinate(this.screenClippingHeight, this.screenHeight);
        this.node.clip(f8, f9, f10, f11);
    }

    private float crop(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        if (f2 > f4) {
            return f4;
        }
        return f2;
    }

    private float clipRound(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return f2;
    }

    private void updateClippingInheritance() {
        if ((this.clippingInheritanceType & 1) != 0) {
            for (IWrappedNode3D iWrappedNode3D = this.getParent(); iWrappedNode3D != null; iWrappedNode3D = iWrappedNode3D.getParent()) {
                if (!iWrappedNode3D.isClipping() || (iWrappedNode3D.getClippingInheritance() & 0x10) == 0) continue;
                float f2 = this.screenClippingX + this.screenClippingWidth;
                float f3 = this.screenClippingY + this.screenClippingHeight;
                float f4 = iWrappedNode3D.getScreenClippingX();
                float f5 = iWrappedNode3D.getScreenClippingY();
                this.screenClippingX = Math.max(this.screenClippingX, f4);
                this.screenClippingY = Math.max(this.screenClippingY, f5);
                this.screenClippingWidth = Math.min(f2, f4 + iWrappedNode3D.getScreenClippingWidth()) - this.screenClippingX;
                if (this.screenClippingWidth <= 0.0f) {
                    this.screenClippingWidth = 0.0f;
                    this.screenClippingHeight = 0.0f;
                    return;
                }
                this.screenClippingHeight = Math.min(f3, f5 + iWrappedNode3D.getScreenClippingHeight()) - this.screenClippingY;
                if (this.screenClippingHeight <= 0.0f) {
                    this.screenClippingHeight = 0.0f;
                }
                return;
            }
        }
    }

    private static float getScreenCoordinate(float f2, float f3) {
        return f2 / f3;
    }

    @Override
    public IWrappedNode3D getParent() {
        return this.parent;
    }

    @Override
    public float getX() {
        return this.posX;
    }

    @Override
    public float getY() {
        return this.posY;
    }

    @Override
    public float getZ() {
        return this.posZ;
    }

    @Override
    public void updateClipping() {
        if (this.clipping) {
            this.clip();
        }
        if (!this.hasClippingChild) {
            return;
        }
        if (this.children != null) {
            for (int i2 = 0; i2 < this.children.size(); ++i2) {
                IWrappedNode3D iWrappedNode3D = (IWrappedNode3D)this.children.get(i2);
                iWrappedNode3D.updateClipping();
            }
        }
    }

    @Override
    public boolean hasClippingChild() {
        return this.hasClippingChild;
    }

    @Override
    public void setHasClippingChild(boolean bl) {
        this.hasClippingChild = true;
    }

    @Override
    public void updateHasClippingChild() {
        if (this.children == null) {
            this.hasClippingChild = false;
            return;
        }
        for (int i2 = 0; i2 < this.children.size(); ++i2) {
            IWrappedNode3D iWrappedNode3D = (IWrappedNode3D)this.children.get(i2);
            if (!iWrappedNode3D.hasClippingChild() && !iWrappedNode3D.isClipping()) continue;
            this.hasClippingChild = true;
            return;
        }
        this.hasClippingChild = false;
    }

    @Override
    public boolean isClipping() {
        return this.clipping;
    }

    @Override
    public void resetTransformation() {
        if (!this.node.resetTransformations()) {
            logChannel3DEngine.log(10000, "WrappedNode3D#resetTransformation: Could not reset transformation in node %1", (Object)this.node.getName());
        }
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.scaleZ = 1.0f;
        this.currentNodeScaleX = 1.0f;
        this.currentNodeScaleY = 1.0f;
        this.currentNodeScaleZ = 1.0f;
        this.posX = 0.0f;
        this.posY = 0.0f;
        this.posZ = 0.0f;
        this.rotX = 0.0f;
        this.rotY = 0.0f;
        this.rotZ = 0.0f;
        this.setVisible(true);
        this.setOpacity(1.0f);
        this.useClippingRectangle = false;
        this.clippingX = 0.0f;
        this.clippingY = 0.0f;
        this.clippingWidth = 0.0f;
        this.clippingHeight = 0.0f;
        this.clippingInheritanceType = 34;
        this.storePosition();
    }

    @Override
    public float getScaleX() {
        return this.scaleX;
    }

    @Override
    public float getScaleY() {
        return this.scaleY;
    }

    @Override
    public float getScaleZ() {
        return this.scaleZ;
    }

    @Override
    public void setClippingRectangle(float f2, float f3, float f4, float f5) {
        if (this.clippingX == f2 && this.clippingY == f3 && this.clippingWidth == f4 && this.clippingHeight == f5) {
            return;
        }
        this.clippingX = f2;
        this.clippingY = f3;
        this.clippingWidth = f4;
        this.clippingHeight = f5;
        this.updateClipping();
    }

    @Override
    public void useClippingRectangle(boolean bl) {
        this.useClippingRectangle = bl;
    }

    @Override
    public void dispose() {
    }

    public float getClippingX() {
        return this.clippingX;
    }

    public float getClippingY() {
        return this.clippingY;
    }

    public float getClippingWidth() {
        return this.clippingWidth;
    }

    public float getClippingHeight() {
        return this.clippingHeight;
    }

    public boolean isUseClippingRectangle() {
        return this.useClippingRectangle;
    }

    @Override
    public void setClippingInheritance(int n) {
        if (this.clippingInheritanceType == n) {
            return;
        }
        this.clippingInheritanceType = n;
        this.updateClipping();
    }

    @Override
    public int getClippingInheritance() {
        return this.clippingInheritanceType;
    }

    @Override
    public float getScreenClippingX() {
        return this.screenClippingX;
    }

    @Override
    public float getScreenClippingY() {
        return this.screenClippingY;
    }

    @Override
    public float getScreenClippingWidth() {
        return this.screenClippingWidth;
    }

    @Override
    public float getScreenClippingHeight() {
        return this.screenClippingHeight;
    }

    @Override
    public int getScreenHeight() {
        return this.screenHeight;
    }

    @Override
    public int getScreenWidth() {
        return this.screenWidth;
    }

    @Override
    public boolean isInstance() {
        return this.isInstance;
    }

    @Override
    public boolean setNodeName(String string) {
        return this.node.setName(string);
    }

    @Override
    public int getNodeIndex() {
        return this.nodeIndex;
    }

    @Override
    public void setNodeIndex(int n) {
        if (n == this.nodeIndex) {
            return;
        }
        this.nodeIndex = n;
        if (this.parent == null) {
            INode3D iNode3D = this.node.getParent();
            if (iNode3D.isValid()) {
                if (!iNode3D.remove(this.node)) {
                    logChannel3DEngine.log(10000, "WrappedNode3D#setNodeIndex could not remove node '%1' from parent '%2'", (Object)this, (Object)iNode3D.getName());
                }
                iNode3D.add(this.node, n);
            }
            iNode3D.dispose();
        } else {
            IWrappedNode3D iWrappedNode3D = this.parent;
            iWrappedNode3D.remove(this);
            iWrappedNode3D.add(this);
        }
    }

    @Override
    public boolean invalidateObject() {
        return this.node.invalidateObject();
    }

    public String toString() {
        String string = this.getNodeName();
        Buffer buffer = new Buffer(string.length() + 15);
        buffer.append("WrappedNode3D[");
        buffer.append(this.getNodeName());
        buffer.append(']');
        return buffer.toString();
    }

    @Override
    public float getCurrentNodeScaleX() {
        return this.currentNodeScaleX;
    }

    @Override
    public float getCurrentNodeScaleY() {
        return this.currentNodeScaleY;
    }

    @Override
    public void ignoreOpacity(boolean bl) {
        this.ignoreOpacity = bl;
    }

    @Override
    public void setHorizontalFlip(boolean bl) {
        if (this.flipHorizontally != bl) {
            this.flipHorizontally = bl;
            this.updateScaleAndTranslation();
        }
    }

    @Override
    public boolean isHorizontallyFlipped() {
        return this.flipHorizontally;
    }

    @Override
    public void setLanguageOrientation(boolean bl) {
        this.isLtr = bl;
        this.updateScaleAndTranslation();
    }
}

