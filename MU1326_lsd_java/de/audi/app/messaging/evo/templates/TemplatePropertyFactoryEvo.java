/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.app.messaging.core.templates.ITemplatePropertyFactory$NullFactory;
import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.Template;

public final class TemplatePropertyFactoryEvo
implements ITemplatePropertyFactory {
    private static final PropertyListCell PROPERTY_LIST_CELL = new PropertyListCell(-1263632642, new int[0]);
    private static final ITemplatePropertyFactory NULL_FACTORY = new ITemplatePropertyFactory$NullFactory();

    @Override
    public PropertyListCell create(Template template) {
        PropertyListCell propertyListCell = !template.isReadOnly() ? PROPERTY_LIST_CELL : NULL_FACTORY.create(template);
        return propertyListCell;
    }
}

