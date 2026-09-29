/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IINodeText;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutResult;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DTextMultiSection;

public class WrappedNode3DTextMultiSection
extends AbstractWrappedNode3DText
implements IWrappedNode3DTextMultiSection {
    private final ITextLayout layout;
    private boolean layoutChanged;

    protected WrappedNode3DTextMultiSection(INode3DText iNode3DText, IINodeText iINodeText, String string, IWrappedFont iWrappedFont, int n, EALManager eALManager, boolean bl) {
        super(iNode3DText, iINodeText, string, n, eALManager, bl);
        this.layout = iWrappedFont.createLayout();
        this.layoutChanged = false;
    }

    @Override
    public void setText(String string) {
        boolean bl;
        if (string == null) {
            string = "";
        }
        boolean bl2 = bl = this.layoutChanged || this.getText() == null || !this.getText().equals(string);
        if (bl) {
            super.storeText(string);
            super.getTextNode().setText(this.layout, string);
            this.layoutChanged = false;
            IINodeText iINodeText = this.getInterfaceText();
            if (string.length() > 0) {
                this.setSize(iINodeText.getWidth(), iINodeText.getHeight());
            } else {
                this.setSize(0.0f, iINodeText.getHeight());
            }
            this.setVisible(this.visible);
        }
    }

    @Override
    public ITextLayout getLayout() {
        return this.layout;
    }

    @Override
    public void notifyLayoutChanged(boolean bl) {
        this.layoutChanged = true;
        if (bl) {
            this.setText(this.getText());
        }
    }

    @Override
    public int[] getOnScreenCharPosition(int n) {
        int[] nArray = new int[2];
        ITextLayoutResult iTextLayoutResult = EALManager.getManager().layout(this.getLayout(), this.getText());
        if (iTextLayoutResult.getGlyphOfLine(0L, n) != null) {
            nArray[0] = (int)iTextLayoutResult.getGlyphOfLine(0L, n).getX();
            nArray[1] = (int)(iTextLayoutResult.getGlyphOfLine(0L, n).getX() + (float)iTextLayoutResult.getGlyphOfLine(0L, n).getWidth());
        }
        iTextLayoutResult.destroy();
        iTextLayoutResult.dispose();
        return nArray;
    }

    @Override
    public void dispose() {
        super.dispose();
        this.ealManager.destroy(this.layout);
    }
}

