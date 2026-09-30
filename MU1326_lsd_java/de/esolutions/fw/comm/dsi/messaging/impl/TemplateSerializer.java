/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.messaging.Template;

public class TemplateSerializer {
    public static void putOptionalTemplate(ISerializer iSerializer, Template template) throws SerializerException {
        boolean bl = template == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = template.getId();
            iSerializer.putInt32(n);
            String string = template.getBody();
            iSerializer.putOptionalString(string);
            boolean bl2 = template.isReadOnly();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalTemplateVarArray(ISerializer iSerializer, Template[] templateArray) throws SerializerException {
        boolean bl = templateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(templateArray.length);
            for (int i2 = 0; i2 < templateArray.length; ++i2) {
                TemplateSerializer.putOptionalTemplate(iSerializer, templateArray[i2]);
            }
        }
    }

    public static Template getOptionalTemplate(IDeserializer iDeserializer) throws SerializerException {
        Template template = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            int n;
            template = new Template();
            template.id = n = iDeserializer.getInt32();
            template.body = string = iDeserializer.getOptionalString();
            template.readOnly = bl2 = iDeserializer.getBool();
        }
        return template;
    }

    public static Template[] getOptionalTemplateVarArray(IDeserializer iDeserializer) throws SerializerException {
        Template[] templateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            templateArray = new Template[n];
            for (int i2 = 0; i2 < n; ++i2) {
                templateArray[i2] = TemplateSerializer.getOptionalTemplate(iDeserializer);
            }
        }
        return templateArray;
    }
}

