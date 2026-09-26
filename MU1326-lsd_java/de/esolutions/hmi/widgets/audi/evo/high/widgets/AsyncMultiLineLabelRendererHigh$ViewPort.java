/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$1;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractPage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$UpdateInterval;

class AsyncMultiLineLabelRendererHigh$ViewPort {
    private int size = 0;
    private int height = 0;
    private IWrappedNode3DText[] textNodes;
    private int lineHeight = 0;
    private int fontHeight = 0;
    private int color;
    private String[] content;
    private int contentFirstLine = 128;
    private int hAlign;
    private int vAlign;
    private AsyncMultiLineLabelRendererHigh$UpdateInterval contentUpdates = new AsyncMultiLineLabelRendererHigh$UpdateInterval();
    private boolean contentDirty = true;
    private boolean displayDirty = true;
    private final /* synthetic */ AsyncMultiLineLabelRendererHigh this$0;

    private AsyncMultiLineLabelRendererHigh$ViewPort(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh) {
        this.this$0 = asyncMultiLineLabelRendererHigh;
    }

    public void reset() {
        this.contentUpdates.reset();
        this.content = null;
        this.contentDirty = true;
        this.displayDirty = true;
    }

    private int getAlignmentOffsetX(int n) {
        int n2 = 0;
        switch (this.hAlign) {
            case 1: {
                break;
            }
            case 2: {
                n2 = (AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getWidth() - n) / 2;
                break;
            }
            case 3: {
                n2 = AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getWidth() - n;
                break;
            }
        }
        return n2;
    }

    public void setAlignment(int n, int n2) {
        this.displayDirty |= this.hAlign != n || this.vAlign != n2;
        this.hAlign = n;
        this.vAlign = n2;
    }

    private int getAlignmentOffsetY() {
        int n = 0;
        switch (this.vAlign) {
            case 4: {
                break;
            }
            case 5: {
                int n2 = AsyncMultiLineLabelRendererHigh.access$200(this.this$0, AsyncMultiLineLabelRendererHigh.access$100(this.this$0));
                n = (AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getHeight() - n2) / 2;
                break;
            }
            case 6: {
                n = AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getHeight() - AsyncMultiLineLabelRendererHigh.access$200(this.this$0, AsyncMultiLineLabelRendererHigh.access$100(this.this$0));
                break;
            }
        }
        return n;
    }

    public void onLineChanged(int n) {
        this.contentUpdates.markUpdated(n);
    }

    public void fillContent(AsyncMultiLineLabelRendererHigh$AbstractPage asyncMultiLineLabelRendererHigh$AbstractPage) {
        if (asyncMultiLineLabelRendererHigh$AbstractPage.isEmpty() || this.size <= 0) {
            this.contentDirty = false;
            this.content = null;
            this.displayDirty = true;
            return;
        }
        if (!this.contentDirty && this.contentUpdates.containsUpdates(this.contentFirstLine, this.contentFirstLine + this.size + 2)) {
            this.contentUpdates.reset();
            this.contentDirty = true;
        }
        if (!this.contentDirty && this.content != null && this.content.length == this.size + 2) {
            return;
        }
        if (this.content == null || this.content.length != this.size + 2) {
            this.content = new String[this.size + 2];
        }
        int n = this.contentFirstLine;
        int n2 = 0;
        while (n < this.contentFirstLine + this.content.length) {
            String string = asyncMultiLineLabelRendererHigh$AbstractPage.getLine(n);
            this.content[n2] = string.length() == 0 ? null : string;
            ++n;
            ++n2;
        }
        this.contentDirty = false;
        this.displayDirty = true;
    }

    public void render(IWrappedNode3D iWrappedNode3D, RedrawContextHigh redrawContextHigh, AbstractRenderer abstractRenderer) {
        if (!this.displayDirty) {
            return;
        }
        if (this.size <= 0 || this.height <= 0 || this.lineHeight <= 0 || this.fontHeight <= 0) {
            return;
        }
        this.displayDirty = false;
        int n = this.size + 2;
        if (this.textNodes == null || this.textNodes.length < n) {
            this.destroy();
            this.textNodes = new IWrappedNode3DText[n];
        }
        int n2 = this.getAlignmentOffsetY() - this.lineHeight;
        boolean bl = true;
        for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
            if (i2 < n && this.content != null && this.content[i2] != null) {
                if (this.textNodes[i2] == null) {
                    this.textNodes[i2] = this.this$0.getEALManager().createText3D(iWrappedNode3D, EALManager.createNodeName("multiLineText", i2, abstractRenderer), this.content[i2], redrawContextHigh.getCurrentFont());
                }
                if (this.textNodes[i2] != null) {
                    this.textNodes[i2].setText(this.content[i2], redrawContextHigh.getCurrentFont(), AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getWidth(), this.this$0.getEALManager());
                    bl &= this.content[i2].length() == 0;
                    int n3 = this.getAlignmentOffsetX((int)this.textNodes[i2].getWidth());
                    this.textNodes[i2].setPosition(n3, n2 + this.fontHeight - 1, 0.0f);
                    this.textNodes[i2].getInterfaceText().setColor(this.color);
                    this.textNodes[i2].setVisible(true);
                }
            } else if (this.textNodes[i2] != null) {
                this.textNodes[i2].setVisible(false);
            }
            n2 += this.lineHeight;
        }
        if (bl) {
            IWidgetLogChannel.logChannel.log(-2137614336, "AsyncMultiLineLabelRenderer.ViewPort#render: no text displayed");
        }
    }

    public void destroy() {
        if (this.textNodes != null && this.this$0.getEALManager() != null) {
            for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
                this.this$0.getEALManager().destroy(this.textNodes[i2]);
            }
        }
        this.textNodes = null;
    }

    public void setHeights(int n, int n2) {
        boolean bl = false;
        if (this.height != n) {
            this.height = n;
            bl = true;
        }
        if (this.lineHeight != n2) {
            this.lineHeight = n2;
            bl = true;
        }
        if (bl) {
            this.displayDirty = true;
            this.size = n / n2 + 1;
        }
    }

    public void setFontHeight(int n) {
        this.displayDirty |= this.fontHeight != n;
        this.fontHeight = n;
    }

    public void setColor(int n) {
        this.displayDirty |= this.color != n;
        this.color = n;
    }

    public String toString() {
        return new StringBuffer().append("ViewPort[size:").append(this.size).append("]").toString();
    }

    public String getDisplayText() {
        if (this.content == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.content.length; ++i2) {
            stringBuffer.append(this.content[i2]).append('\n');
        }
        return stringBuffer.toString();
    }

    public void setFirstVisibleLine(int n) {
        int n2 = n - 1;
        this.contentDirty |= n2 != this.contentFirstLine;
        this.contentFirstLine = n2;
    }

    /* synthetic */ AsyncMultiLineLabelRendererHigh$ViewPort(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh, AsyncMultiLineLabelRendererHigh$1 asyncMultiLineLabelRendererHigh$1) {
        this(asyncMultiLineLabelRendererHigh);
    }
}

