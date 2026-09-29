/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.Template;

public final class ITemplatePropertyFactory$NullFactory
implements ITemplatePropertyFactory {
    @Override
    public PropertyListCell create(Template template) {
        return PropertyListCell.EMPTY_CELL;
    }
}

