package org.kar;

import java.util.*;

/**
 * @author Kelly Robinson
 */
public class JavaMultimap
{
    private Map<Object, List<Object>> multimap = new LinkedHashMap<Object, List<Object>>();

    public boolean put(Object key, Object value)
    {
        List<Object> objects = multimap.get(key);
        objects = objects != null ? objects : new ArrayList<Object>();
        objects.add(value);
        multimap.put(key, objects);
        return true;
    }
}
