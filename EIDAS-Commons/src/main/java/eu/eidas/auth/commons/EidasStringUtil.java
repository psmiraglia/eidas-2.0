package eu.eidas.auth.commons;

import org.apache.commons.lang.StringUtils;

import javax.annotation.Nonnull;
import javax.xml.bind.DatatypeConverter;

public final class EidasStringUtil {

    /**
     * Decodes the given {@link DatatypeConverter} String into a byte array.
     *
     * @param base64String the BASE64 String to be decoded.
     * @return The decoded byte array.
     * @see DatatypeConverter#parseBase64Binary
     */
    @Nonnull
    public static byte[] decodeBytesFromBase64(@Nonnull String base64String) {
        return DatatypeConverter.parseBase64Binary(base64String);
    }

    /**
     * Decodes the given {@link DatatypeConverter} String into a byte array.
     *
     * @param base64String the BASE64 String to be decoded.
     * @return The decoded byte array.
     * @see DatatypeConverter#parseBase64Binary
     */
    @Nonnull
    public static String decodeStringFromBase64(@Nonnull String base64String) {
        return toString(decodeBytesFromBase64(base64String));
    }

    /**
     * {@link DatatypeConverter} encodes the given byte array into a BASE64 string.
     *
     * @param bytes the byte array to be encoded.
     * @return The Base64 String of the encoded bytes.
     * @see DatatypeConverter#printBase64Binary
     */
    @Nonnull
    public static String encodeToBase64(@Nonnull byte[] bytes) {
        if (bytes.length == 0) {
            return StringUtils.EMPTY;
        }
        return DatatypeConverter.printBase64Binary(bytes);
    }

    /**
     * {@link DatatypeConverter} encodes the given normal string into a BASE64 string.
     *
     * @param value the value to be encoded.
     * @return The Base64 String of the encoded bytes coming from the given string.
     * @see DatatypeConverter#printBase64Binary
     */
    @Nonnull
    public static String encodeToBase64(@Nonnull String value) {
        return encodeToBase64(getBytes(value));
    }

    /**
     * @param value input String
     * @return the corresponding array of bytes encoded in UTF-8
     */
    @Nonnull
    public static byte[] getBytes(@Nonnull String value) {
        return value.getBytes(Constants.UTF8);
    }

    /**
     * @param bytes input byte array
     * @return a String created from the given bytes, encoded in UTF-8
     */
    @Nonnull
    public static String toString(@Nonnull byte[] bytes) {
        return new String(bytes, Constants.UTF8);
    }

    private EidasStringUtil() {
    }
}
