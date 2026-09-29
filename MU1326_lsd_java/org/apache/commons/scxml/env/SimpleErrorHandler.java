/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler
implements ErrorHandler,
Serializable {
    private static final long serialVersionUID;
    private static final String MSG_PREFIX;
    private static final String MSG_POSTFIX;
    private Log log = LogFactory.getLog(super.getClass());

    @Override
    public void error(SAXParseException sAXParseException) {
        if (this.log.isErrorEnabled()) {
            this.log.error(new StringBuffer().append("SCXML SAX Parsing: ").append(sAXParseException.getMessage()).append(" Correct the SCXML document.").toString(), sAXParseException);
        }
    }

    @Override
    public void fatalError(SAXParseException sAXParseException) {
        if (this.log.isFatalEnabled()) {
            this.log.fatal(new StringBuffer().append("SCXML SAX Parsing: ").append(sAXParseException.getMessage()).append(" Correct the SCXML document.").toString(), sAXParseException);
        }
    }

    @Override
    public void warning(SAXParseException sAXParseException) {
        if (this.log.isWarnEnabled()) {
            this.log.warn(new StringBuffer().append("SCXML SAX Parsing: ").append(sAXParseException.getMessage()).append(" Correct the SCXML document.").toString(), sAXParseException);
        }
    }
}

