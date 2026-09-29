/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRenderer
implements IRenderer,
WidgetConstants,
IWidgetLogChannel {
    public abstract AbstractWidgetController getAbstractController() {
    }

    protected HMITerminalImpl getTerminal() {
        return (HMITerminalImpl)this.getAbstractController().getTerminal();
    }

    protected InitializationContext getInitContext() {
        return this.getAbstractController().getInitContext();
    }

    public IRenderer getParent() {
        return this.getControllersRenderer(this.getAbstractController().getParent());
    }

    public List getChildren() {
        List list = this.getAbstractController().getChildren();
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            IRenderer iRenderer = this.getControllersRenderer(abstractWidget);
            if (iRenderer == null) continue;
            arrayList.add(list);
        }
        return arrayList;
    }

    private IRenderer getControllersRenderer(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof AbstractWidgetController) {
            return ((AbstractWidgetController)abstractWidget).getRenderer();
        }
        return null;
    }

    public boolean isLTR() {
        boolean bl = true;
        if (this.getTerminal() != null && this.getTerminal().getFramework() != null && this.getTerminal().getFramework().getLanguageMgr() != null) {
            bl = this.getTerminal().getFramework().getLanguageMgr().isLeftToRightOrientation();
        }
        return bl;
    }
}

