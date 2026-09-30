/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IINodeText;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;

public class WrappedNode3DText
extends AbstractWrappedNode3DText
implements IWrappedNode3DText {
    private IWrappedFont font;
    private int abbreviateWidth;
    private int color;

    protected WrappedNode3DText(INode3DText iNode3DText, IINodeText iINodeText, String string, IWrappedFont iWrappedFont, int n, EALManager eALManager, boolean bl) {
        super(iNode3DText, iINodeText, string, n, eALManager, bl);
        this.font = iWrappedFont;
    }

    public INode3D getNode() {
        this.setScale(this.scaleX, this.scaleY, this.scaleZ);
        return super.getNode();
    }

    public void setText(String string, IWrappedFont iWrappedFont) {
        this.setText(string, iWrappedFont, 10000, null);
    }

    public void setText(String string, IWrappedFont iWrappedFont, int n, EALManager eALManager) {
        if (string == null) {
            string = "";
        }
        if (this.getText() != null && this.getText().equals(string) && this.font != null && this.font.equals(iWrappedFont) && this.abbreviateWidth == n) {
            return;
        }
        IINodeText iINodeText = this.getInterfaceText();
        iWrappedFont.getFontGroup().activate();
        ITextLayout iTextLayout = EALManager.FONT_LAYOUT_WORKAROUND ? new ITextLayout(iWrappedFont.getSize()) : iWrappedFont.getLayout();
        iTextLayout.setMaximumLineCount(1L);
        if (n == 10000) {
            iTextLayout.setMaximumSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
            iTextLayout.setTruncation(false);
        } else {
            iTextLayout.setMaximumSize(n, Integer.MAX_VALUE);
            iTextLayout.setTruncation(true);
        }
        this.getTextNode().getInterfaceText().setText(iTextLayout, string);
        if (EALManager.FONT_LAYOUT_WORKAROUND) {
            logChannel3DEngine.log(10000000, "WrappedNode3DText#setText: destroy text-layout %1", (Object)iTextLayout);
            if (!iTextLayout.destroy()) {
                logChannel3DEngine.log(10000, "WrappedNode3DText#setText: text-layout %1 could not be destroyed", (Object)iTextLayout, new Throwable("Dummy Throwable for Stacktrace"));
            }
            iTextLayout.dispose();
        }
        this.abbreviateWidth = n;
        this.storeText(string);
        this.font = iWrappedFont;
        if (string.length() > 0) {
            this.setSize(iINodeText.getWidth(), iINodeText.getHeight());
        } else {
            this.setSize(0.0f, iINodeText.getHeight());
        }
        this.setVisible(this.visible);
    }

    public void setColor(int n) {
        if (this.equalsColor(n)) {
            return;
        }
        this.storeColor(n);
        IINodeText iINodeText = this.getInterfaceText();
        iINodeText.setColor(n);
    }

    private void storeColor(int n) {
        this.color = n;
    }

    private boolean equalsColor(int n) {
        return this.color == n;
    }

    public float getOriginX() {
        return 0.0f;
    }

    public float getOriginY() {
        return 1.0f;
    }

    public IWrappedFont getFont() {
        return this.font;
    }

    public int getAbbreviateWidth() {
        return this.abbreviateWidth;
    }
}

