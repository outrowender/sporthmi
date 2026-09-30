/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IINodeText;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IBaseWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;

public abstract class AbstractWrappedNode3DText
extends WrappedNode3D
implements IBaseWrappedNode3DText {
    private final INode3DText node;
    private IINodeText interfaceText;
    private String text;
    protected EALManager ealManager;

    protected AbstractWrappedNode3DText(INode3DText iNode3DText, IINodeText iINodeText, String string, int n, EALManager eALManager, boolean bl) {
        super(iNode3DText, iINodeText.getWidth(), iINodeText.getHeight(), false, n, bl);
        this.node = iNode3DText;
        this.interfaceText = iINodeText;
        this.text = string;
        this.ealManager = eALManager;
        this.shouldFlipBack = true;
        iNode3DText.rotateX(180.0f);
        this.setScale(1.0f, 1.0f, 1.0f);
    }

    public EALManager getEALManager() {
        return this.ealManager;
    }

    public IINodeText getInterfaceText() {
        if (this.interfaceText != null) {
            return this.interfaceText;
        }
        this.interfaceText = this.node.getInterfaceText();
        return this.interfaceText;
    }

    protected boolean shouldFlipBack() {
        return this.shouldFlipBack && !this.isLtr;
    }

    public INode3DText getTextNode() {
        return this.node;
    }

    public String getText() {
        return this.text;
    }

    protected final void storeText(String string) {
        this.text = string;
    }

    public void resetTransformation() {
        super.resetTransformation();
        this.node.rotateX(180.0f);
    }

    public void setVisible(boolean bl) {
        boolean bl2;
        this.visible = bl;
        boolean bl3 = bl2 = bl && this.text.length() > 0;
        if (this.node.isVisible() == bl2) {
            return;
        }
        this.node.setVisible(bl2);
    }

    public void dispose() {
        super.dispose();
        if (this.interfaceText != null) {
            this.interfaceText.dispose();
            this.interfaceText = null;
        }
    }
}

