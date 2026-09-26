/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.log.LogChannel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractAnimationParameters {
    protected LogChannel logAnimation;

    public AbstractAnimationParameters(LogChannel logChannel) {
        this.logAnimation = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void readAnimationParametersFromFile(String string) {
        if (string == null) {
            string = this.getConfigFileName();
        }
        if (string == null) {
            this.logAnimation.log(-1601830656, "AnimationParameters#readAnimationParametersFromFile animationParametersFile could not be found!");
            return;
        }
        this.logAnimation.log(-2137614336, "AnimationParameters#readAnimationParametersFromFile animationParametersFile: %1 ", (Object)string);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(string));
            try {
                String string2 = bufferedReader.readLine();
                while (string2 != null) {
                    if (string2.trim().length() > 0 && !string2.startsWith("\\")) {
                        this.readAnimationParameters(string2);
                    }
                    string2 = bufferedReader.readLine();
                }
                this.logAnimation.log(-2137614336, "AnimationParameters#readAnimationParametersFromFile animationParameters read successfully!");
            }
            catch (IOException iOException) {
                this.logAnimation.log(-2137614336, "AnimationParameters#readAnimationParametersFromFile couldn't read parameters");
            }
            finally {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            this.logAnimation.log(-2137614336, "AnimationParameters#readAnimationParametersFromFile couldn't find parameters file");
        }
    }

    protected abstract String getConfigFileName() {
    }

    protected abstract void readAnimationParameters(String string) {
    }
}

