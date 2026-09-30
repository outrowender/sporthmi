/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.Mirrorable;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MirroredContainerController;
import java.util.ArrayList;

public class MirrorRendererHigh
extends CompositeRendererHigh {
    protected final MirroredContainerController controller;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$high$widgets$MirroredContainerController;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$LabelController;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$IconController;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$SharedTextureController;

    public MirrorRendererHigh(MirroredContainerController mirroredContainerController) {
        super(mirroredContainerController);
        this.controller = mirroredContainerController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        if (this.node == null) {
            System.err.println("MirroredRenderer ...Node is null");
            return;
        }
        boolean bl = this.checkMirrorEnabledProperties();
        this.applyMirror(bl);
        if (bl) {
            this.backmirrorParticularChildren();
        } else {
            this.removeInternalBackmirrorNodes();
        }
        this.node.setOpacity(this.controller.getRenderOpacity());
    }

    private void applyMirror(boolean bl) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(bl ? (float)(n + this.controller.getWidth()) : (float)n, n2, 1.0f);
        this.node.setScale(bl ? -1.0f : 1.0f, 1.0f, 1.0f);
    }

    private void backmirrorParticularChildren() {
        AbstractWidget abstractWidget;
        int n;
        ArrayList arrayList = new ArrayList();
        for (n = 0; n < this.controller.getChildren().size(); ++n) {
            abstractWidget = this.controller.getChild(n);
            if (!this.isBackMirrorCandidate(abstractWidget.getClass()) || this.isInternalMirroredNode(abstractWidget)) continue;
            arrayList.add(abstractWidget);
        }
        for (n = 0; n < arrayList.size(); ++n) {
            abstractWidget = (AbstractWidget)arrayList.get(n);
            this.backMirrorWidget(abstractWidget);
        }
    }

    private void backMirrorWidget(AbstractWidget abstractWidget) {
        if (!(abstractWidget instanceof AbstractWidgetController)) {
            return;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)abstractWidget;
        if (abstractWidgetController.getRenderer() instanceof Mirrorable) {
            Mirrorable mirrorable = (Mirrorable)((Object)abstractWidgetController.getRenderer());
            mirrorable.mirror(true);
            return;
        }
        AbstractWidget abstractWidget2 = abstractWidget.getParent();
        abstractWidget2.remove(abstractWidget);
        MirroredContainerController mirroredContainerController = new MirroredContainerController();
        MirrorRendererHigh mirrorRendererHigh = new MirrorRendererHigh(mirroredContainerController);
        mirroredContainerController.setRenderer(mirrorRendererHigh);
        mirroredContainerController.setInternalBackmirror(true);
        mirroredContainerController.setActive(true);
        mirroredContainerController.setMirrorEnabled(true);
        mirroredContainerController.setAutoDisableMirrorOnLTR(true);
        mirroredContainerController.setBounds(abstractWidget.getX(), abstractWidget.getY(), abstractWidget.getWidth(), abstractWidget.getHeight());
        abstractWidget.setBounds(0, 0, abstractWidget.getWidth(), abstractWidget.getHeight());
        mirroredContainerController.add(abstractWidget);
        abstractWidget2.add(mirroredContainerController);
    }

    private boolean isInternalMirroredNode(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof MirroredContainerController) {
            return ((MirroredContainerController)abstractWidget).isInternalBackmirror();
        }
        return false;
    }

    private void removeInternalBackmirrorNodes() {
        AbstractWidget abstractWidget;
        int n;
        ArrayList arrayList = new ArrayList();
        for (n = 0; n < this.controller.getChildren().size(); ++n) {
            abstractWidget = this.controller.getChild(n);
            if (!abstractWidget.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$high$widgets$MirroredContainerController == null ? MirrorRendererHigh.class$("de.esolutions.hmi.widgets.audi.evo.high.widgets.MirroredContainerController") : class$de$esolutions$hmi$widgets$audi$evo$high$widgets$MirroredContainerController)) continue;
            arrayList.add(abstractWidget);
        }
        for (n = 0; n < arrayList.size(); ++n) {
            abstractWidget = (MirroredContainerController)arrayList.get(n);
            this.removeInternalMirroredChild((MirroredContainerController)abstractWidget);
        }
    }

    private void removeInternalMirroredChild(MirroredContainerController mirroredContainerController) {
        if (!mirroredContainerController.isInternalBackmirror()) {
            return;
        }
        AbstractWidget abstractWidget = mirroredContainerController.getParent();
        abstractWidget.remove(mirroredContainerController);
        for (int i2 = 0; i2 < mirroredContainerController.getChildrenSize(); ++i2) {
            AbstractWidget abstractWidget2 = mirroredContainerController.getChild(i2);
            mirroredContainerController.remove(abstractWidget2);
            abstractWidget2.setBounds(mirroredContainerController.getX(), mirroredContainerController.getY(), mirroredContainerController.getWidth(), mirroredContainerController.getHeight());
            abstractWidget.add(abstractWidget2);
        }
    }

    private boolean isBackMirrorCandidate(Class clazz) {
        if (this.controller.getBackMirrorClassList() == null || this.controller.getBackMirrorClassList().isEmpty()) {
            return clazz.equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$LabelController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$LabelController = MirrorRendererHigh.class$("de.esolutions.hmi.widgets.audi.evo.widgets.LabelController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$LabelController) || clazz.equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$IconController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$IconController = MirrorRendererHigh.class$("de.esolutions.hmi.widgets.audi.evo.widgets.IconController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$IconController) || clazz.equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$SharedTextureController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$SharedTextureController = MirrorRendererHigh.class$("de.esolutions.hmi.widgets.audi.evo.widgets.SharedTextureController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$SharedTextureController);
        }
        for (int i2 = 0; i2 < this.controller.getBackMirrorClassList().size(); ++i2) {
            String string = this.controller.getBackMirrorClassList().get(i2).toString();
            if (!clazz.getName().equals(string)) continue;
            return true;
        }
        return false;
    }

    private boolean checkMirrorEnabledProperties() {
        if (!this.controller.isMirrorEnabled()) {
            return false;
        }
        boolean bl = this.isLTR();
        return !this.controller.isAutoDisableMirrorOnLTR() || !bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

