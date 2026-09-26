/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MirrorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IDecoratorProvider;
import java.util.ArrayList;

public class MirroredContainerController
extends AbstractWidgetController
implements IDecoratorProvider {
    private boolean mirrorEnabled = true;
    private boolean autoDisableMirrorOnLTR = true;
    private ArrayList backMirrorClassList = new ArrayList();
    private MirrorRendererHigh renderer;
    private boolean isInternalBackmirror = false;
    private AbstractWidget menuDecoratorController = null;

    public void setRenderer(MirrorRendererHigh mirrorRendererHigh) {
        this.renderer = mirrorRendererHigh;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public boolean isInternalBackmirror() {
        return this.isInternalBackmirror;
    }

    public void add(AbstractWidget abstractWidget, int n) {
        logContainer.log(-2137614336, "MirroredContainerController#add(%1, %2) - Called", (Object)abstractWidget, (long)n);
        this.add(abstractWidget);
        switch (n) {
            case 2: {
                if (this.menuDecoratorController != null) {
                    logContainer.log(-1601830656, "MirroredContainerController#add() - The decorator widget has already been set successfully. Please validate, why another decorater was added.");
                    return;
                }
                this.menuDecoratorController = abstractWidget;
                break;
            }
            default: {
                logContainer.log(-1601830656, "MirroredContainerController#add() - The provided role is not used within the MirroredContainerController.");
            }
        }
    }

    public void setInternalBackmirror(boolean bl) {
        this.isInternalBackmirror = bl;
    }

    public boolean isMirrorEnabled() {
        return this.mirrorEnabled;
    }

    public void setMirrorEnabled(boolean bl) {
        this.mirrorEnabled = bl;
    }

    public ArrayList getBackMirrorClassList() {
        return this.backMirrorClassList;
    }

    public void setBackMirrorClassList(ArrayList arrayList) {
        this.backMirrorClassList = arrayList;
    }

    public boolean isAutoDisableMirrorOnLTR() {
        return this.autoDisableMirrorOnLTR;
    }

    public void setAutoDisableMirrorOnLTR(boolean bl) {
        this.autoDisableMirrorOnLTR = bl;
    }

    @Override
    public AbstractWidget getMenuDecorator() {
        return this.menuDecoratorController;
    }
}

