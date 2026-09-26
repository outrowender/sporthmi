/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SpellerRendererEuropeHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;

public final class SpellerRendererEuropeHigh$SpellerLayoutContainer {
    private SpellerController$ISpellerItem item;
    private int size = -1;
    private int subBandSize = -1;
    private IWrappedNode3D nodeBig;
    private IWrappedNode3D nodeNormal;
    private IWrappedNode3D subItemNode;
    private final /* synthetic */ SpellerRendererEuropeHigh this$0;

    public SpellerRendererEuropeHigh$SpellerLayoutContainer(SpellerRendererEuropeHigh spellerRendererEuropeHigh) {
        this.this$0 = spellerRendererEuropeHigh;
    }

    public IWrappedNode3D getNodeBig() {
        return this.nodeBig;
    }

    public IWrappedNode3D getNodeNormal() {
        return this.nodeNormal;
    }

    public SpellerController$ISpellerItem getSpellerItem() {
        return this.item;
    }

    float getAbsoluteX() {
        float f2 = this.nodeNormal.getX();
        if (this.item instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)this.item).getParent() != null) {
            SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.this$0.layoutData.get(((SpellerController$SingleCharItem)this.item).getParent());
            f2 += spellerRendererEuropeHigh$SpellerLayoutContainer.subItemNode.getX();
        }
        return f2;
    }

    float getAbsoluteY() {
        float f2 = this.nodeNormal.getY();
        if (this.item instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)this.item).getParent() != null) {
            SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.this$0.layoutData.get(((SpellerController$SingleCharItem)this.item).getParent());
            f2 += spellerRendererEuropeHigh$SpellerLayoutContainer.subItemNode.getY();
        }
        return f2;
    }

    static /* synthetic */ IWrappedNode3D access$000(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        return spellerRendererEuropeHigh$SpellerLayoutContainer.nodeNormal;
    }

    static /* synthetic */ SpellerController$ISpellerItem access$102(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, SpellerController$ISpellerItem spellerController$ISpellerItem) {
        spellerRendererEuropeHigh$SpellerLayoutContainer.item = spellerController$ISpellerItem;
        return spellerRendererEuropeHigh$SpellerLayoutContainer.item;
    }

    static /* synthetic */ IWrappedNode3D access$002(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, IWrappedNode3D iWrappedNode3D) {
        spellerRendererEuropeHigh$SpellerLayoutContainer.nodeNormal = iWrappedNode3D;
        return spellerRendererEuropeHigh$SpellerLayoutContainer.nodeNormal;
    }

    static /* synthetic */ IWrappedNode3D access$202(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, IWrappedNode3D iWrappedNode3D) {
        spellerRendererEuropeHigh$SpellerLayoutContainer.nodeBig = iWrappedNode3D;
        return spellerRendererEuropeHigh$SpellerLayoutContainer.nodeBig;
    }

    static /* synthetic */ int access$302(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, int n) {
        spellerRendererEuropeHigh$SpellerLayoutContainer.size = n;
        return spellerRendererEuropeHigh$SpellerLayoutContainer.size;
    }

    static /* synthetic */ IWrappedNode3D access$402(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, IWrappedNode3D iWrappedNode3D) {
        spellerRendererEuropeHigh$SpellerLayoutContainer.subItemNode = iWrappedNode3D;
        return spellerRendererEuropeHigh$SpellerLayoutContainer.subItemNode;
    }

    static /* synthetic */ IWrappedNode3D access$200(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        return spellerRendererEuropeHigh$SpellerLayoutContainer.nodeBig;
    }

    static /* synthetic */ IWrappedNode3D access$400(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        return spellerRendererEuropeHigh$SpellerLayoutContainer.subItemNode;
    }

    static /* synthetic */ SpellerController$ISpellerItem access$100(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        return spellerRendererEuropeHigh$SpellerLayoutContainer.item;
    }

    static /* synthetic */ int access$300(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        return spellerRendererEuropeHigh$SpellerLayoutContainer.size;
    }

    static /* synthetic */ int access$502(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, int n) {
        spellerRendererEuropeHigh$SpellerLayoutContainer.subBandSize = n;
        return spellerRendererEuropeHigh$SpellerLayoutContainer.subBandSize;
    }

    static /* synthetic */ int access$500(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        return spellerRendererEuropeHigh$SpellerLayoutContainer.subBandSize;
    }
}

