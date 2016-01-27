package com.github.sebhoss.identifier.usecases;

/**
 * HTTP endpoints exposes by the service. Capture here in order to reuse across the application.
 */
@SuppressWarnings("nls")
final class HttpApi {

    /**
     * The <code>ROOT</code> endpoints exposes identifiers.
     */
    public static final String ROOT = "/";

    /**
     * The <code>SEQUENCES</code> endpoints exposes a sequence based identifiers.
     */
    public static final String SEQUENCES = "/sequences";

    /**
     * The <code>SEQUENCE</code> endpoints exposes a sequence based identifiers.
     */
    public static final String SEQUENCE = SEQUENCES + "/sequence";

    /**
     * The <code>SEQUENCE_BASE36</code> endpoints exposes a sequence based identifiers in Base36.
     */
    public static final String SEQUENCE_BASE36 = SEQUENCES + "/base36";

    /**
     * The <code>SEQUENCE_BASE62</code> endpoints exposes a sequence based identifiers in Base62.
     */
    public static final String SEQUENCE_BASE62 = SEQUENCES + "/base62";

    /**
     * The <code>SEQUENCE_BASE64</code> endpoints exposes a sequence based identifiers in Base64.
     */
    public static final String SEQUENCE_BASE64 = SEQUENCES + "/base64";

    /**
     * The <code>SEQUENCE_HASHID</code> endpoints exposes a sequence based identifiers as HashId.
     */
    public static final String SEQUENCE_HASHID = SEQUENCES + "/hashid";

    /**
     * The <code>TIMESTAMPS</code> endpoints exposes a timestamp based identifiers.
     */
    public static final String TIMESTAMPS = "/timestamps";

    /**
     * The <code>TIMESTAMP</code> endpoints exposes a timestamp based identifiers.
     */
    public static final String TIMESTAMP = TIMESTAMPS + "/timestamp";

    /**
     * The <code>TIMESTAMP_BASE36</code> endpoints exposes a timestamp based identifiers in Base36.
     */
    public static final String TIMESTAMP_BASE36 = TIMESTAMPS + "/base36";

    /**
     * The <code>TIMESTAMP_BASE62</code> endpoints exposes a timestamp based identifiers in Base62.
     */
    public static final String TIMESTAMP_BASE62 = TIMESTAMPS + "/base62";

    /**
     * The <code>TIMESTAMP_BASE64</code> endpoints exposes a timestamp based identifiers in Base64.
     */
    public static final String TIMESTAMP_BASE64 = TIMESTAMPS + "/base64";

    /**
     * The <code>TIMESTAMP_HASHID</code> endpoints exposes a timestamp based identifiers as HashId.
     */
    public static final String TIMESTAMP_HASHID = TIMESTAMPS + "/hashid";

    /**
     * The <code>UUIDS</code> endpoints exposes a UUID based identifiers.
     */
    public static final String UUIDS = "/uuids";

    /**
     * The <code>UUID</code> endpoints exposes a UUID based identifiers.
     */
    public static final String UUID = UUIDS + "/uuid";

    /**
     * The <code>UUID_BASE36</code> endpoints exposes a UUID based identifiers in Base36.
     */
    public static final String UUID_BASE36 = UUIDS + "/base36";

    /**
     * The <code>UUID_BASE62</code> endpoints exposes a UUID based identifiers in Base62.
     */
    public static final String UUID_BASE62 = UUIDS + "/base62";

    /**
     * The <code>UUID_BASE64</code> endpoints exposes a UUID based identifiers in Base64.
     */
    public static final String UUID_BASE64 = UUIDS + "/base64";

    /**
     * The <code>UUID_HASHID</code> endpoints exposes a UUID based identifiers as HashId.
     */
    public static final String UUID_HASHID = UUIDS + "/hashid";

    /**
     * The <code>SLACK</code> endpoints answers to Slack commands.
     */
    public static final String SLACK = "/slack";

}
