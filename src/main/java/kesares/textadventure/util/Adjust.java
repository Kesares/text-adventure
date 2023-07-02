package kesares.textadventure.util;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Indicates that the construct will be adjusted at a later date
 * and methods might change parameters or return types.
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface Adjust {
}
