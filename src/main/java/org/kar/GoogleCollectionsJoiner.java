package org.kar;

import java.util.Map;
import static com.google.common.base.Joiner.*;
/**
 * Using static import in this 'helper' class to wrap the underlying Joiner and provide convenience defaults.
 * @author Kelly Robinson
 */
public class GoogleCollectionsJoiner
{
    private static final String SEP = ", ";
    private static final String MAP_SEP = ":";
    
    public String join(String separator, Object... toJoin)
    {
        return on(separator).join(toJoin);
    }

    public String join(String separator, String keyValueSeparator, Map map)
    {
        return on(separator).withKeyValueSeparator(keyValueSeparator).join(map);
    }

    public String join(Object... toJoin)
    {
        return join(SEP, toJoin);
    }

    public String join(Map map)
    {
        return join(SEP, MAP_SEP, map);
    }
}
