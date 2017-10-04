package br.com.digidev.messenger4j.send;

import com.google.gson.annotations.SerializedName;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public enum NotificationType {

    /**
     * Will emit a sound/vibration and a phone notification.
     */
    @SerializedName("REGULAR")
    REGULAR,

    /**
     * Will just emit a phone notification.
     */
    @SerializedName("SILENT_PUSH")
    SILENT_PUSH,

    /**
     * Will not emit either.
     */
    @SerializedName("NO_PUSH")
    NO_PUSH
}