/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.env.LogUtils;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public class SimpleSCXMLListener
implements SCXMLListener,
Serializable {
    private static final long serialVersionUID;
    private Log log = LogFactory.getLog(super.getClass());

    @Override
    public void onEntry(TransitionTarget transitionTarget) {
        if (this.log.isInfoEnabled()) {
            this.log.info(LogUtils.getTTPath(transitionTarget));
        }
    }

    @Override
    public void onExit(TransitionTarget transitionTarget) {
        if (this.log.isInfoEnabled()) {
            this.log.info(LogUtils.getTTPath(transitionTarget));
        }
    }

    @Override
    public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
        if (this.log.isInfoEnabled()) {
            this.log.info(LogUtils.transToString(transitionTarget, transitionTarget2, transition));
        }
    }
}

