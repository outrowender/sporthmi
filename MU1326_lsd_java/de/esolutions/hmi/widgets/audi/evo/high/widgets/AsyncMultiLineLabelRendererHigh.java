/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.PreferredDynamicHeight;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$1;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$2;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$3;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractPage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$PageBuffer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$ViewPort;
import de.esolutions.hmi.widgets.audi.evo.widgets.AsyncLabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IAsyncMultiLineLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;

public class AsyncMultiLineLabelRendererHigh
extends AbstractRendererHigh
implements LabelRenderer,
Alignment,
PreferredDynamicHeight,
IAsyncMultiLineLabelRenderer {
    private static final double MINIMUM_ESTIMATION_CHANGE_RATIO;
    private static final int MAX_COMPUTED_FRAME_SIZE;
    private static final int MIN_COMPUTED_FRAME_SIZE;
    private AsyncLabelController controller;
    private AsyncMultiLineLabelRendererHigh$AbstractPage noWrapPage;
    private AsyncMultiLineLabelRendererHigh$AbstractPage autoWrapPage;
    private int autoWrapTargetWidth;
    private AsyncMultiLineLabelRendererHigh$PageBuffer pageBuffer;
    private AsyncMultiLineLabelRendererHigh$ViewPort viewPort;
    private IWrappedNode3D node;
    private int hAlign = 1;
    private int vAlign = 4;
    private int lineHeight = -1;
    private int autoWrap = -1;
    private int firstVisibleLine;
    private int cachedMaxLines;

    public AsyncMultiLineLabelRendererHigh(AsyncLabelController asyncLabelController) {
        this.controller = asyncLabelController;
        this.pageBuffer = new AsyncMultiLineLabelRendererHigh$PageBuffer(4);
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

    private AsyncMultiLineLabelRendererHigh$AbstractPage getDisplayPage() {
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

    private void resetAutoWrapPage(int n, boolean bl) {
        int n2 = this.autoWrap;
        boolean bl2 = this.autoWrap != -1;
        this.autoWrapTargetWidth = n;
        if (n != 0) {
            this.autoWrapPage = this.pageBuffer.get(n);
            if (this.autoWrapPage != null) {
                this.autoWrapPage.update();
                return;
            }
        }
        this.autoWrapPage = new AsyncMultiLineLabelRendererHigh$1(this, this.createTextIterator(n2), !bl2, this.controller.getMaxLines(), 0.1, n, n2, bl, bl2);
        if (n != 0) {
            this.pageBuffer.put(n, this.autoWrapPage);
        }
    }

    private AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator createTextIterator(int n) {
        return new AsyncMultiLineLabelRendererHigh$2(this, this.controller.getText() == null ? "" : this.controller.getText(), n);
    }

    private void resetPages() {
        logChannel.log(-2137614336, "AsyncMultiLineLabelRendererHigh#resetPages autoWrap=%1", (long)this.autoWrap);
        boolean bl = this.autoWrap == -1;
        this.noWrapPage = new AsyncMultiLineLabelRendererHigh$3(this, this.createTextIterator(-1), !bl, this.controller.getMaxLines(), 0.1, bl);
        if (this.autoWrap != -1) {
            this.resetAutoWrapPage(this.controller.getWidth(), true);
        } else {
            this.autoWrapPage = null;
        }
    }

    private int getHeight(AsyncMultiLineLabelRendererHigh$AbstractPage asyncMultiLineLabelRendererHigh$AbstractPage) {
        if (asyncMultiLineLabelRendererHigh$AbstractPage.isAtStart() && !asyncMultiLineLabelRendererHigh$AbstractPage.isFinished()) {
            asyncMultiLineLabelRendererHigh$AbstractPage.update();
        }
        return (asyncMultiLineLabelRendererHigh$AbstractPage.getEstimatedLineCount() - 1) * this.lineHeight + this.getFontHeight();
    }

    private void destroyNode() {
        this.viewPort.destroy();
        if (this.getEALManager() != null) {
            this.getEALManager().destroy(this.node);
        }
        this.node = null;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.viewPort = new AsyncMultiLineLabelRendererHigh$ViewPort(this, null);
        if (this.lineHeight == -1) {
            this.updateLineHeight();
        }
    }

    private void updateLineHeight() {
        int[] nArray = new int[]{23, 37, 37, 0, 35, 0, 0};
        int n = AbstractWidget.framework.getScreenRes();
        this.setLineHeight(nArray[n]);
    }

    @Override
    public void disconnect() {
        super.disconnect();
        this.destroyNode();
        this.viewPort = null;
        this.firstVisibleLine = 0;
        this.pageBuffer.clear();
    }

    @Override
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
            logChannel3DEngine.log(-1601830656, "AsyncMultiLineLabelRendererHigh#renderViewPort() text node is invalid");
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

    @Override
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

    @Override
    public int getPreferredWidth() {
        if (this.noWrapPage.isAtStart()) {
            this.noWrapPage.update();
        }
        return this.noWrapPage.getWidth();
    }

    @Override
    public void setAutoWrap(int n) {
        if (n == this.autoWrap) {
            return;
        }
        this.autoWrap = n;
        this.resetPages();
    }

    @Override
    public int getPreferredHeight() {
        return this.getHeight(this.noWrapPage);
    }

    @Override
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

    @Override
    public boolean isHeightDependentFromWidth() {
        return this.autoWrap != -1;
    }

    @Override
    public String calculateDisplayData(String string, boolean bl) {
        return string;
    }

    @Override
    public String getText() {
        return this.viewPort.getDisplayText();
    }

    @Override
    public void setAlignment(int n, int n2) {
        this.hAlign = n;
        this.vAlign = n2;
    }

    @Override
    public void setFirstVisibleLine(int n) {
        if (n == this.firstVisibleLine) {
            return;
        }
        this.firstVisibleLine = n;
    }

    @Override
    public int getPreferredLineHeight() {
        return this.lineHeight;
    }

    @Override
    public int getFontHeight() {
        return EALManager.getFontHeightUppercase(this.getInheritedFont());
    }

    @Override
    public int getBaseline() {
        return this.getFontHeight();
    }

    @Override
    public boolean hasContent() {
        String string = this.controller.getText();
        return string != null && string.length() > 0;
    }

    @Override
    public boolean isTextDescriptorSupported() {
        return false;
    }

    @Override
    public void setLineHeight(int n) {
        logChannel.log(-2137614336, "AsyncMultiLineLabelRendererHigh#setLineHeight %1", (long)n);
        this.lineHeight = n;
    }

    @Override
    public int getLineHeight() {
        return this.lineHeight;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public boolean isLineBreakingFinished() {
        if (this.controller.getText() == null) {
            return true;
        }
        return this.noWrapPage.isFinished() && (this.autoWrapPage == null || this.autoWrapPage.isFinished());
    }

    @Override
    public void onTextChanged() {
        logChannel.log(-2137614336, "AsyncMultiLineLabelRendererHigh#onTextChanged ");
        this.viewPort.reset();
        this.pageBuffer.clear();
        this.resetPages();
        this.updateLineBreaking(true);
    }

    @Override
    public boolean updateLineBreaking(boolean bl) {
        logChannel.log(-2137614336, "AsyncMultiLineLabelRendererHigh#updateLineBreaking initialFrameOnly=%1", bl);
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
            logChannel.log(-2137614336, "AsyncMultiLineLabelRendererHigh#updateLineBreaking: not updating text, since initial frame has already been processed");
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
        logChannel.log(-2137614336, "AsyncMultiLineLabelRendererHigh#updateLineBreaking result=%1", bl3);
        return bl3;
    }

    static /* synthetic */ AsyncLabelController access$000(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh) {
        return asyncMultiLineLabelRendererHigh.controller;
    }

    static /* synthetic */ AsyncMultiLineLabelRendererHigh$AbstractPage access$100(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh) {
        return asyncMultiLineLabelRendererHigh.getDisplayPage();
    }

    static /* synthetic */ int access$200(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh, AsyncMultiLineLabelRendererHigh$AbstractPage abstractPage) {
        return asyncMultiLineLabelRendererHigh.getHeight(abstractPage);
    }

    static /* synthetic */ boolean access$300(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh) {
        return asyncMultiLineLabelRendererHigh.isControllerReady();
    }

    static /* synthetic */ int access$402(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh, int n) {
        asyncMultiLineLabelRendererHigh.autoWrapTargetWidth = n;
        return asyncMultiLineLabelRendererHigh.autoWrapTargetWidth;
    }

    static /* synthetic */ AsyncMultiLineLabelRendererHigh$PageBuffer access$500(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh) {
        return asyncMultiLineLabelRendererHigh.pageBuffer;
    }

    static /* synthetic */ StringUtility access$600(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh) {
        return asyncMultiLineLabelRendererHigh.getStringUtility();
    }

    static /* synthetic */ AsyncMultiLineLabelRendererHigh$ViewPort access$700(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh) {
        return asyncMultiLineLabelRendererHigh.viewPort;
    }

    static /* synthetic */ int access$800(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh, int n) {
        return asyncMultiLineLabelRendererHigh.computeFrameSize(n);
    }
}

