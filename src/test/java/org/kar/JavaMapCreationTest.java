package org.kar;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Kelly Robinson
 */
@Test
public class JavaMapCreationTest
{
    public void testMapCreationInline()
    {
        Map<String, String> javaMap = new LinkedHashMap<String, String>()
        {
            {
                put("a", "1");
                put("b", "2");
            }
        };
    }
}
