package org.kar

import org.testng.annotations.Test
import com.google.common.collect.*
import static org.testng.Assert.assertEquals

/**
 * @author Kelly Robinson
 */
class GoogleCollectionsMultiMapTest
{
    private Random random = new Random()

    @Test
    public void testMultimap()
    {
        def list = []
        10.times {
            list << createObject()
        }
        List properties = ['value1', 'value2', 'value3']
        Multimap multimap = list.inject(LinkedListMultimap.create()) {Multimap map, object ->
            properties.each {
                map.put(it, object."$it")
            }
            map
        }
        properties.each {
            assertEquals (multimap.get(it), list."$it")
        }
    }

    Object createObject()
    {
        Expando expando = new Expando()
        expando.value1 =  random.nextInt(10) + 1
        expando.value2 =  random.nextInt(100) + 100
        expando.value3 =  random.nextInt(50) + 50
        return expando
    }
}
