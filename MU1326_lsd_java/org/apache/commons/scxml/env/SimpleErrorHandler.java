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
    private static final long serialVersionUID = 1L;
    private static final String MSG_PREFIX = "SCXML SAX Parsing: ";
    private static final String MSG_POSTFIX = " Correct the SCXML document.";
    private Log log = LogFactory.getLog(this.getClass());

    public void error(SAXParseException sAXParseException) {
        if (this.log.isErrorEnabled()) {
            this.log.error(MSG_PREFIX + sAXParseException.getMessage() + MSG_POSTFIX, sAXParseException);
        }
    }

    public void fatalError(SAXParseException sAXParseException) {
        if (this.log.isFatalEnabled()) {
            this.log.fatal(MSG_PREFIX + sAXParseException.getMessage() + MSG_POSTFIX, sAXParseException);
        }
    }

    public void warning(SAXParseException sAXParseException) {
        if (this.log.isWarnEnabled()) {
            this.log.warn(MSG_PREFIX + sAXParseException.getMessage() + MSG_POSTFIX, sAXParseException);
        }
    }
}

