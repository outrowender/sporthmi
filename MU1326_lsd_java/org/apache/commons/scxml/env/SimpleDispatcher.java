/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.EventDispatcher;

public final class SimpleDispatcher
implements EventDispatcher,
Serializable {
    private static final long serialVersionUID = 1L;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$EventDispatcher == null ? (class$org$apache$commons$scxml$EventDispatcher = SimpleDispatcher.class$("org.apache.commons.scxml.EventDispatcher")) : class$org$apache$commons$scxml$EventDispatcher);
    static /* synthetic */ Class class$org$apache$commons$scxml$EventDispatcher;

    public void cancel(String string) {
        if (this.log.isInfoEnabled()) {
            this.log.info(new StringBuffer().append("cancel( sendId: ").append(string).append(")").toString());
        }
    }

    public void send(String string, String string2, String string3, String string4, Map map, Object object, long l, List list) {
        if (this.log.isInfoEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("send ( sendId: ").append(string);
            stringBuffer.append(", target: ").append(string2);
            stringBuffer.append(", targetType: ").append(string3);
            stringBuffer.append(", event: ").append(string4);
            stringBuffer.append(", params: ").append(String.valueOf(map));
            stringBuffer.append(", hints: ").append(String.valueOf(object));
            stringBuffer.append(", delay: ").append(l);
            stringBuffer.append(')');
            this.log.info(stringBuffer.toString());
        }
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

