package org.kar

import org.unitils.UnitilsTestNG
import org.unitils.inject.annotation.TestedObject
import org.testng.annotations.*

/**
 * @author Kelly Robinson
 */
class GroovyMultimapTest extends UnitilsTestNG
{
    @TestedObject
    private GroovyMultimap map

    private final Random random = new Random()

    @DataProvider(name = "multimaps")
    public Object[][] createData()
    {
        def keys = ['a', 'b', 'c']
        [
                [keys, 10],
                [keys, 100],
                [keys, 1000],
                [keys, 10000]
        ]
    }

    @Test(dataProvider = "multimaps")
    public void testMultimap(List<String> keys, long numberOfValues)
    {
        long start = System.currentTimeMillis()
        keys.each { key ->
            numberOfValues.times {
                map.put((key), random.nextInt())
            }
        }
        long time = System.currentTimeMillis() - start
        println time
    }
}
