package org.kar;

import com.google.common.collect.*;
import org.testng.annotations.*;
import org.unitils.inject.annotation.TestedObject;

import java.util.*;

/**
 * @author Kelly Robinson
 */
public class JavaGoogleCollectionsMultimapTest
{
     @TestedObject
     Multimap<Object, Object> map = LinkedListMultimap.create();

    private final Random random = new Random();

    @DataProvider(name = "multimaps")
    public Object[][] createData()
    {
        ArrayList<String> keys = Lists.newArrayList("a", "b", "c");
        return new Object[][]{
                {keys, 10},
                {keys, 100},
                {keys, 1000},
                {keys, 10000}
        };
    }

    @Test(dataProvider = "multimaps")
    public void testMultiMap(List<String> keys, long numberOfValues)
    {
        long start = System.currentTimeMillis();
        for (String key : keys)
        {
            for (int i = 0; i < numberOfValues; i++)
            {
                map.put(key, random.nextInt());
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }
}
