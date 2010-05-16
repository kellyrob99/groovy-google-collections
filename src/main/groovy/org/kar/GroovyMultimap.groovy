package org.kar

/**
 * @author Kelly Robinson
 */
class GroovyMultimap
{
    Map map = [:]

    /**
     * Simulate Multimap behaviour using a delegate map.
     * @param key
     * @param value
     * @return
     */
    public boolean put(Object key, Object value)
    {
        List list = map.get(key, [])
        list.add(value)
        map."$key" = list
    }

    public String toString()
    {
        return map.toMapString()
    }
}
