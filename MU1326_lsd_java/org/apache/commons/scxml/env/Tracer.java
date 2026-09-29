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
import org.xml.sax.SAXParseException;

public class Tracer
implements ErrorHandler,
ErrorReporter,
SCXMLListener,
Serializable {
    private static final long serialVersionUID;
    private ErrorHandler errHandler = new SimpleErrorHandler();
    private ErrorReporter errReporter = new SimpleErrorReporter();
    private SCXMLListener scxmlListener = new SimpleSCXMLListener();

    @Override
    public void warning(SAXParseException sAXParseException) {
        this.errHandler.warning(sAXParseException);
    }

    @Override
    public void error(SAXParseException sAXParseException) {
        this.errHandler.error(sAXParseException);
    }

    @Override
    public void fatalError(SAXParseException sAXParseException) {
        this.errHandler.fatalError(sAXParseException);
    }

    @Override
    public void onError(String string, String string2, Object object) {
        this.errReporter.onError(string, string2, object);
    }

    @Override
    public void onEntry(TransitionTarget transitionTarget) {
        this.scxmlListener.onEntry(transitionTarget);
    }

    @Override
    public void onExit(TransitionTarget transitionTarget) {
        this.scxmlListener.onExit(transitionTarget);
    }

    @Override
    public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
        this.scxmlListener.onTransition(transitionTarget, transitionTarget2, transition);
    }
}

