/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.env.SimpleErrorHandler;
import org.apache.commons.scxml.env.SimpleErrorReporter;
import org.apache.commons.scxml.env.SimpleSCXMLListener;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Tracer
implements ErrorHandler,
ErrorReporter,
SCXMLListener,
Serializable {
    private static final long serialVersionUID = 1L;
    private ErrorHandler errHandler = new SimpleErrorHandler();
    private ErrorReporter errReporter = new SimpleErrorReporter();
    private SCXMLListener scxmlListener = new SimpleSCXMLListener();

    public void warning(SAXParseException sAXParseException) throws SAXException {
        this.errHandler.warning(sAXParseException);
    }

    public void error(SAXParseException sAXParseException) throws SAXException {
        this.errHandler.error(sAXParseException);
    }

    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        this.errHandler.fatalError(sAXParseException);
    }

    public void onError(String string, String string2, Object object) {
        this.errReporter.onError(string, string2, object);
    }

    public void onEntry(TransitionTarget transitionTarget) {
        this.scxmlListener.onEntry(transitionTarget);
    }

    public void onExit(TransitionTarget transitionTarget) {
        this.scxmlListener.onExit(transitionTarget);
    }

    public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
        this.scxmlListener.onTransition(transitionTarget, transitionTarget2, transition);
    }
}

