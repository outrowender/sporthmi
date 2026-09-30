/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.PreferredDynamicHeight;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.AsyncLabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IAsyncMultiLineLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import java.util.ArrayList;
import java.util.List;

public class AsyncMultiLineLabelRendererHigh
extends AbstractRendererHigh
implements LabelRenderer,
Alignment,
PreferredDynamicHeight,
IAsyncMultiLineLabelRenderer {
    private static final double MINIMUM_ESTIMATION_CHANGE_RATIO = 0.1;
    private static final int MAX_COMPUTED_FRAME_SIZE = 1080;
    private static final int MIN_COMPUTED_FRAME_SIZE = 180;
    private AsyncLabelController controller;
    private AbstractPage noWrapPage;
    private AbstractPage autoWrapPage;
    private int autoWrapTargetWidth;
    private PageBuffer pageBuffer;
    private ViewPort viewPort;
    private IWrappedNode3D node;
    private int hAlign = 1;
    private int vAlign = 4;
    private int lineHeight = -1;
    private int autoWrap = -1;
    private int firstVisibleLine;
    private int cachedMaxLines;

    public AsyncMultiLineLabelRendererHigh(AsyncLabelController asyncLabelController) {
        this.controller = asyncLabelController;
        this.pageBuffer = new PageBuffer(4);
        this.cachedMaxLines = asyncLabelController.getMaxLines();
        this.resetPages();
    }

    private int computeFrameSize(int n) {
        int n2 = this.controller.getFrameSize();
        if (n2 > 0) {
            return n2;
        }
        int n3 = this.lineHeight > 0 && this.controller.getHeight() > 0 ? Math.max(1, this.controller.getHeight() / this.lineHeight) : 8;
        if (n == -1) {
            n3 += 6;
        }
        int n4 = n3 * 90;
        return Math.min(Math.max(n4, 180), 1080);
    }

    private AbstractPage getDisplayPage() {
        return this.autoWrapPage == null ? this.noWrapPage : this.autoWrapPage;
    }

    private boolean isControllerReady() {
        return this.controller.isConnectedSubtree() && this.controller.getWidth() > 0;
    }

    private StringUtility getStringUtility() {
        HMITerminalEAL hMITerminalEAL = (HMITerminalEAL)((Object)this.controller.getTerminalImpl());
        return hMITerminalEAL.getStringUtility(this.getInheritedFont());
    }

    private void createRootNode(RedrawContextHigh redrawContextHigh) {
        if (this.getDisplayPage().isEmpty()) {
            return;
        }
        if (this.node == null) {
            this.node = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("multilineLabel", this), 0.0f, 0.0f, redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
        }
    }

    private void resetAutoWrapPage(final int n, final boolean bl) {
        final int n2 = this.autoWrap;
        final boolean bl2 = this.autoWrap != -1;
        this.autoWrapTargetWidth = n;
        if (n != 0) {
            this.autoWrapPage = this.pageBuffer.get(n);
            if (this.autoWrapPage != null) {
                this.autoWrapPage.update();
                return;
            }
        }
        this.autoWrapPage = new AbstractPage(this.createTextIterator(n2), !bl2, this.controller.getMaxLines(), 0.1){
            private int targetWidth;
            {
                super(abstractTextFrameIterator, bl4, n4, d2);
                this.targetWidth = n;
            }

            protected void mergeFrame(String string) {
                string = string.replace('\r', ' ');
                if (this.targetWidth <= 0) {
                    this.targetWidth = AsyncMultiLineLabelRendererHigh.this.isControllerReady() ? AsyncMultiLineLabelRendererHigh.this.controller.getWidth() : n;
                    AsyncMultiLineLabelRendererHigh.this.autoWrapTargetWidth = this.targetWidth;
                }
                if (this.targetWidth > 0) {
                    AsyncMultiLineLabelRendererHigh.this.pageBuffer.put(this.targetWidth, this);
                }
                String[] stringArray = AsyncMultiLineLabelRendererHigh.this.getStringUtility().wrapText(string, this.targetWidth, this.targetWidth, n2);
                for (int i2 = 0; i2 < stringArray.length && !this.isFinished(); ++i2) {
                    this.addLine(AsyncMultiLineLabelRendererHigh.this.controller.getOrientaionHintedText(stringArray[i2]));
                }
            }

            protected boolean isReady() {
                return !bl || AsyncMultiLineLabelRendererHigh.this.isControllerReady();
            }

            protected int getMinLines() {
                return AsyncMultiLineLabelRendererHigh.this.controller.getMinLines();
            }

            protected void onLineChanged(int n3) {
                if (bl2) {
                    AsyncMultiLineLabelRendererHigh.this.viewPort.onLineChanged(n3);
                }
            }

            protected int getLineWidth(String string) {
                return AsyncMultiLineLabelRendererHigh.this.getEALManager().getTextWidth(string, AsyncMultiLineLabelRendererHigh.this.getInheritedFont());
            }
        };
        if (n != 0) {
            this.pageBuffer.put(n, this.autoWrapPage);
        }
    }

    private AbstractTextFrameIterator createTextIterator(final int n) {
        return new AbstractTextFrameIterator(this.controller.getText() == null ? "" : this.controller.getText()){

            protected int getFrameSize() {
                return AsyncMultiLineLabelRendererHigh.this.computeFrameSize(n);
            }
        };
    }

    private void resetPages() {
        logChannel.log(10000000, "AsyncMultiLineLabelRendererHigh#resetPages autoWrap=%1", (long)this.autoWrap);
        final boolean bl = this.autoWrap == -1;
        this.noWrapPage = new AbstractPage(this.createTextIterator(-1), !bl, this.controller.getMaxLines(), 0.1){

            protected void mergeFrame(String string) {
                string = string.replace('\r', ' ');
                List list = AsyncMultiLineLabelRendererHigh.this.getStringUtility().wrapOnLineBreak(string, '\n');
                for (int i2 = 0; i2 < list.size() && !this.isFinished(); ++i2) {
                    this.addLine(AsyncMultiLineLabelRendererHigh.this.controller.getOrientaionHintedText((String)list.get(i2)));
                }
            }

            protected boolean isReady() {
                return true;
            }

            protected int getMinLines() {
                return AsyncMultiLineLabelRendererHigh.this.controller.getMinLines();
            }

            protected void onLineChanged(int n) {
                if (bl) {
                    AsyncMultiLineLabelRendererHigh.this.viewPort.onLineChanged(n);
                }
            }

            protected int getLineWidth(String string) {
                return AsyncMultiLineLabelRendererHigh.this.getEALManager().getTextWidth(string, AsyncMultiLineLabelRendererHigh.this.getInheritedFont());
            }
        };
        if (this.autoWrap != -1) {
            this.resetAutoWrapPage(this.controller.getWidth(), true);
        } else {
            this.autoWrapPage = null;
        }
    }

    private int getHeight(AbstractPage abstractPage) {
        if (abstractPage.isAtStart() && !abstractPage.isFinished()) {
            abstractPage.update();
        }
        return (abstractPage.getEstimatedLineCount() - 1) * this.lineHeight + this.getFontHeight();
    }

    private void destroyNode() {
        this.viewPort.destroy();
        if (this.getEALManager() != null) {
            this.getEALManager().destroy(this.node);
        }
        this.node = null;
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.viewPort = new ViewPort();
        if (this.lineHeight == -1) {
            this.updateLineHeight();
        }
    }

    private void updateLineHeight() {
        int[] nArray = new int[]{23, 37, 37, 0, 35, 0, 0};
        int n = AbstractWidget.framework.getScreenRes();
        this.setLineHeight(nArray[n]);
    }

    public void disconnect() {
        super.disconnect();
        this.destroyNode();
        this.viewPort = null;
        this.firstVisibleLine = 0;
        this.pageBuffer.clear();
    }

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
        this.createRootNode(redrawContextHigh);
        if (this.node == null) {
            return;
        }
        if (!this.node.isValid()) {
            logChannel3DEngine.log(100000, "AsyncMultiLineLabelRendererHigh#renderViewPort() text node is invalid");
            return;
        }
        int n = redrawContextHigh.getColor(this.controller.getCurrentVisState());
        int n2 = EALManager.createColorCode(n);
        this.viewPort.setFontHeight(this.getFontHeight());
        this.viewPort.setAlignment(this.hAlign, this.vAlign);
        this.viewPort.setHeights(this.controller.getHeight(), this.lineHeight);
        this.viewPort.setColor(n2);
        this.viewPort.setFirstVisibleLine(this.firstVisibleLine);
        this.viewPort.fillContent(this.getDisplayPage());
        this.node.setVisible(true);
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.viewPort.render(this.node, redrawContextHigh, this);
    }

    public int getNumberOfRows(int n) {
        if (this.autoWrap == -1) {
            return this.noWrapPage.getEstimatedLineCount();
        }
        if (n != this.autoWrapTargetWidth) {
            this.resetAutoWrapPage(n, false);
            this.autoWrapPage.update();
        }
        return this.autoWrapPage.getEstimatedLineCount();
    }

    public int getPreferredWidth() {
        if (this.noWrapPage.isAtStart()) {
            this.noWrapPage.update();
        }
        return this.noWrapPage.getWidth();
    }

    public void setAutoWrap(int n) {
        if (n == this.autoWrap) {
            return;
        }
        this.autoWrap = n;
        this.resetPages();
    }

    public int getPreferredHeight() {
        return this.getHeight(this.noWrapPage);
    }

    public int getPreferredHeight(int n) {
        if (this.autoWrap == -1 || n <= 0) {
            return this.getPreferredHeight();
        }
        if (n != this.autoWrapTargetWidth) {
            this.resetAutoWrapPage(n, false);
            this.autoWrapPage.update();
        }
        return this.getHeight(this.autoWrapPage);
    }

    public boolean isHeightDependentFromWidth() {
        return this.autoWrap != -1;
    }

    public String calculateDisplayData(String string, boolean bl) {
        return string;
    }

    public String getText() {
        return this.viewPort.getDisplayText();
    }

    public void setAlignment(int n, int n2) {
        this.hAlign = n;
        this.vAlign = n2;
    }

    public void setFirstVisibleLine(int n) {
        if (n == this.firstVisibleLine) {
            return;
        }
        this.firstVisibleLine = n;
    }

    public int getPreferredLineHeight() {
        return this.lineHeight;
    }

    public int getFontHeight() {
        return EALManager.getFontHeightUppercase(this.getInheritedFont());
    }

    public int getBaseline() {
        return this.getFontHeight();
    }

    public boolean hasContent() {
        String string = this.controller.getText();
        return string != null && string.length() > 0;
    }

    public boolean isTextDescriptorSupported() {
        return false;
    }

    public void setLineHeight(int n) {
        logChannel.log(10000000, "AsyncMultiLineLabelRendererHigh#setLineHeight %1", (long)n);
        this.lineHeight = n;
    }

    public int getLineHeight() {
        return this.lineHeight;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public boolean isLineBreakingFinished() {
        if (this.controller.getText() == null) {
            return true;
        }
        return this.noWrapPage.isFinished() && (this.autoWrapPage == null || this.autoWrapPage.isFinished());
    }

    public void onTextChanged() {
        logChannel.log(10000000, "AsyncMultiLineLabelRendererHigh#onTextChanged ");
        this.viewPort.reset();
        this.pageBuffer.clear();
        this.resetPages();
        this.updateLineBreaking(true);
    }

    public boolean updateLineBreaking(boolean bl) {
        logChannel.log(10000000, "AsyncMultiLineLabelRendererHigh#updateLineBreaking initialFrameOnly=%1", bl);
        boolean bl2 = false;
        if (this.controller.getMaxLines() != this.cachedMaxLines) {
            this.cachedMaxLines = this.controller.getMaxLines();
            bl2 = true;
        }
        if (!bl2 && this.autoWrap != -1 && this.autoWrapTargetWidth != this.controller.getWidth()) {
            bl2 = true;
        }
        if (bl2) {
            this.resetPages();
        } else if (bl && !this.getDisplayPage().isAtStart()) {
            logChannel.log(10000000, "AsyncMultiLineLabelRendererHigh#updateLineBreaking: not updating text, since initial frame has already been processed");
            return false;
        }
        boolean bl3 = this.noWrapPage.isAtStart();
        int n = this.noWrapPage.getWidth();
        int n2 = this.noWrapPage.getEstimatedLineCount();
        this.noWrapPage.update();
        boolean bl4 = bl3 = this.noWrapPage.getWidth() != n || this.noWrapPage.getEstimatedLineCount() != n2;
        if (this.autoWrapPage != null) {
            n = this.autoWrapPage.getWidth();
            n2 = this.autoWrapPage.getEstimatedLineCount();
            this.autoWrapPage.update();
            bl3 |= this.autoWrapPage.isAtStart() || this.autoWrapPage.getWidth() != n || this.autoWrapPage.getEstimatedLineCount() != n2;
        }
        logChannel.log(10000000, "AsyncMultiLineLabelRendererHigh#updateLineBreaking result=%1", bl3);
        return bl3;
    }

    private class ViewPort {
        private int size = 0;
        private int height = 0;
        private IWrappedNode3DText[] textNodes;
        private int lineHeight = 0;
        private int fontHeight = 0;
        private int color;
        private String[] content;
        private int contentFirstLine = Integer.MIN_VALUE;
        private int hAlign;
        private int vAlign;
        private UpdateInterval contentUpdates = new UpdateInterval();
        private boolean contentDirty = true;
        private boolean displayDirty = true;

        private ViewPort() {
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
                    n2 = (AsyncMultiLineLabelRendererHigh.this.controller.getWidth() - n) / 2;
                    break;
                }
                case 3: {
                    n2 = AsyncMultiLineLabelRendererHigh.this.controller.getWidth() - n;
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
                    int n2 = AsyncMultiLineLabelRendererHigh.this.getHeight(AsyncMultiLineLabelRendererHigh.this.getDisplayPage());
                    n = (AsyncMultiLineLabelRendererHigh.this.controller.getHeight() - n2) / 2;
                    break;
                }
                case 6: {
                    n = AsyncMultiLineLabelRendererHigh.this.controller.getHeight() - AsyncMultiLineLabelRendererHigh.this.getHeight(AsyncMultiLineLabelRendererHigh.this.getDisplayPage());
                    break;
                }
            }
            return n;
        }

        public void onLineChanged(int n) {
            this.contentUpdates.markUpdated(n);
        }

        public void fillContent(AbstractPage abstractPage) {
            if (abstractPage.isEmpty() || this.size <= 0) {
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
                String string = abstractPage.getLine(n);
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
                        this.textNodes[i2] = AsyncMultiLineLabelRendererHigh.this.getEALManager().createText3D(iWrappedNode3D, EALManager.createNodeName("multiLineText", i2, abstractRenderer), this.content[i2], redrawContextHigh.getCurrentFont());
                    }
                    if (this.textNodes[i2] != null) {
                        this.textNodes[i2].setText(this.content[i2], redrawContextHigh.getCurrentFont(), AsyncMultiLineLabelRendererHigh.this.controller.getWidth(), AsyncMultiLineLabelRendererHigh.this.getEALManager());
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
                IWidgetLogChannel.logChannel.log(10000000, "AsyncMultiLineLabelRenderer.ViewPort#render: no text displayed");
            }
        }

        public void destroy() {
            if (this.textNodes != null && AsyncMultiLineLabelRendererHigh.this.getEALManager() != null) {
                for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
                    AsyncMultiLineLabelRendererHigh.this.getEALManager().destroy(this.textNodes[i2]);
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
    }

    private static class PageBuffer {
        private AbstractPage[] pages;
        private int[] widths;
        private int nextIndex;

        public PageBuffer(int n) {
            this.pages = new AbstractPage[n];
            this.widths = new int[n];
        }

        private int findIndex(int n) {
            for (int i2 = 0; i2 < this.widths.length; ++i2) {
                if (this.widths[i2] != n) continue;
                return i2;
            }
            return -1;
        }

        public void put(int n, AbstractPage abstractPage) {
            int n2 = this.findIndex(n);
            if (n2 < 0) {
                n2 = this.nextIndex;
                this.nextIndex = (n2 + 1) % this.widths.length;
            }
            this.pages[n2] = abstractPage;
            this.widths[n2] = n;
        }

        public AbstractPage get(int n) {
            int n2 = this.findIndex(n);
            return n2 < 0 ? null : this.pages[n2];
        }

        public void clear() {
            for (int i2 = 0; i2 < this.widths.length; ++i2) {
                this.pages[i2] = null;
                this.widths[i2] = 0;
            }
        }
    }

    private static abstract class AbstractPage {
        private AbstractTextFrameIterator iterator;
        private List lines;
        private LineCountEstimator estimator;
        private int maxLineWidth;
        private int maxLines;
        private int lineCount;
        private boolean finished;
        private boolean forgetContent;
        private StringBuffer tempFrame;
        private String lastFrameLine;
        private String lastLine;

        public AbstractPage(AbstractTextFrameIterator abstractTextFrameIterator, boolean bl, int n, double d2) {
            this.maxLines = n < 1 ? Integer.MAX_VALUE : n;
            this.iterator = abstractTextFrameIterator;
            this.tempFrame = new StringBuffer();
            this.lines = new ArrayList();
            this.estimator = new LineCountEstimator(abstractTextFrameIterator.getText().length(), d2);
            this.finished = !abstractTextFrameIterator.hasNext();
            this.forgetContent = bl;
            this.lastLine = "";
        }

        private static String addEllipsis(String string) {
            return new Buffer(string.length() + 1).append(string).append('\u2026').toString();
        }

        protected void addLine(String string) {
            if (this.finished) {
                return;
            }
            if (this.lineCount < this.maxLines) {
                if (!this.forgetContent) {
                    this.lines.add(string);
                }
                this.lastLine = string;
                this.maxLineWidth = Math.max(this.maxLineWidth, this.getLineWidth(string));
                ++this.lineCount;
                this.onLineChanged(this.lineCount - 1);
            } else {
                string = AbstractPage.addEllipsis(this.lastLine);
                int n = this.lineCount - 1;
                if (!this.lines.isEmpty()) {
                    this.lines.remove(n);
                    this.lines.add(string);
                }
                this.lastLine = string;
                this.maxLineWidth = Math.max(this.maxLineWidth, this.getLineWidth(string));
                this.onLineChanged(n);
                this.finished = true;
            }
            this.lastFrameLine = string;
        }

        public String getLine(int n) {
            if (n < 0 || n >= this.lines.size()) {
                return "";
            }
            return (String)this.lines.get(n);
        }

        public boolean isEmpty() {
            return this.lineCount == 0;
        }

        public boolean isFinished() {
            return this.finished;
        }

        public boolean isAtStart() {
            return this.iterator.isAtStart() && this.iterator.hasNext();
        }

        public void update() {
            if (this.finished || !this.isReady()) {
                return;
            }
            if (!this.iterator.hasNext()) {
                this.finished = true;
                return;
            }
            String string = this.iterator.next();
            if (this.lastFrameLine != null) {
                this.tempFrame.replace(0, this.tempFrame.length(), this.lastFrameLine).append(string);
                string = this.tempFrame.toString();
                this.lastFrameLine = null;
                --this.lineCount;
                if (!this.forgetContent) {
                    int n = this.lines.size() - 1;
                    this.lines.remove(n);
                    this.onLineChanged(n);
                }
            }
            this.mergeFrame(string);
            if (this.lastFrameLine != null && string.length() > 0 && string.charAt(string.length() - 1) == '\n') {
                this.lastFrameLine = null;
            }
            if (!this.finished && !this.iterator.hasNext()) {
                this.finished = true;
            }
            this.estimator.update(this.lineCount, this.finished ? this.iterator.getText().length() : this.iterator.getOffset());
        }

        public int getEstimatedLineCount() {
            return Math.max(this.getMinLines(), this.estimator.getEstimatedLineCount());
        }

        public int getWidth() {
            return this.maxLineWidth;
        }

        protected abstract boolean isReady();

        protected abstract void mergeFrame(String var1);

        protected abstract int getMinLines();

        protected abstract void onLineChanged(int var1);

        protected abstract int getLineWidth(String var1);
    }

    private static class UpdateInterval {
        private int start;
        private int end;

        public UpdateInterval() {
            this.reset();
        }

        public void reset() {
            this.start = Integer.MAX_VALUE;
            this.end = Integer.MIN_VALUE;
        }

        public void markUpdated(int n) {
            if (n < this.start) {
                this.start = n;
            }
            if (n >= this.end) {
                this.end = n == Integer.MAX_VALUE ? n : n + 1;
            }
        }

        public boolean containsUpdates(int n, int n2) {
            return n2 > this.start && n < this.end;
        }
    }

    private static class LineCountEstimator {
        private int totalCharCount;
        private int estimatedLineCount;
        private double minimumChangeRatio;

        public LineCountEstimator(int n, double d2) {
            this.totalCharCount = n;
            this.minimumChangeRatio = d2;
            this.estimatedLineCount = Math.max(1, n / 90);
        }

        public void update(int n, int n2) {
            if (n2 >= this.totalCharCount) {
                this.estimatedLineCount = n;
                return;
            }
            if (n < 3) {
                this.estimatedLineCount = Math.max(this.estimatedLineCount, n);
                return;
            }
            double d2 = (double)n2 / (double)n;
            int n3 = this.totalCharCount - n2;
            int n4 = (int)((double)n3 / d2);
            int n5 = n + n4;
            int n6 = (int)((double)this.estimatedLineCount * this.minimumChangeRatio);
            if (Math.abs(n5 - this.estimatedLineCount) < n6) {
                return;
            }
            this.estimatedLineCount = n5;
        }

        public int getEstimatedLineCount() {
            return this.estimatedLineCount;
        }
    }

    private static abstract class AbstractTextFrameIterator {
        private String text;
        private int offset;

        public AbstractTextFrameIterator(String string) {
            this.text = string;
        }

        public boolean isAtStart() {
            return this.offset == 0;
        }

        public boolean hasNext() {
            return this.offset < this.text.length();
        }

        public String next() {
            if (!this.hasNext()) {
                return null;
            }
            int n = (int)Math.min((long)this.text.length(), (long)this.offset + (long)this.getFrameSize());
            String string = this.text.substring(this.offset, n);
            this.offset = n;
            return string;
        }

        public String getText() {
            return this.text;
        }

        public int getOffset() {
            return this.offset;
        }

        protected abstract int getFrameSize();
    }
}

