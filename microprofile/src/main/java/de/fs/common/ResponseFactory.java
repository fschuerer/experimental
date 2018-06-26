package de.fs.common;

import java.util.Collection;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author XLKAFR
 */
public class ResponseFactory {

    public static Response gone() {
        return Response.status(Response.Status.GONE).build();
    }

    public static <T> GenericEntity<Collection<T>> entity(Collection<T> wrapMe, Class<T> clazz) {
        GenericEntity<Collection<T>> list = new GenericEntity<Collection<T>>(wrapMe) {
        };
        return list;
    }
}
