package org.kar

import org.testng.annotations.Test
import org.unitils.inject.annotation.TestedObject
import static org.testng.Assert.*
import org.unitils.UnitilsTestNG

import com.google.common.collect.ImmutableMultimap

/**
 * Test the capabilities of google-collections joiner next to the Groovy collections built-in join function.
 * Google-collections wraps its value in '[' and ']' so we need to strip out those values when joining a List in order
 *  to compare with the Groovy equivalent.
 * @author Kelly Robinson
 */
public class GoogleCollectionsJoinerTest extends UnitilsTestNG
{
    @TestedObject
    private GoogleCollectionsJoiner joiner

    private String SEP = GoogleCollectionsJoiner.SEP

    @Test
    public void testJoin()
    {
        def toJoin = ['a', 'b', 'c']
        assertEquals(joiner.join(toJoin)[1..-2], toJoin.join(SEP))
    }

    @Test
    public void testJoinSingle()
    {
        def toJoin = ['a']
        assertEquals(joiner.join(toJoin)[1..-2], toJoin.join(SEP))
    }

    @Test
    public void testJoinEmpty()
    {
        assertEquals(joiner.join([]), '[]')
    }

    /**
     * Mimicking the toString() behaviour of Groovy since there is no join function for Groovy Maps.
     */
    @Test
    public void testMapJoin()
    {
        def toJoin = [1: 'a', 2: 'b', 3: 'c']
        //in this case the Joiner doesn't have the surrounding braces and Groovy does. Go figure.
        assertEquals(joiner.join(toJoin), toJoin.toMapString()[1..-2])
    }

    @Test
    public void testMultimapJoin()
    {
        def builder = new ImmutableMultimap.Builder<String, Integer>()
        def rand = new Random()
        def toJoin = ['a', 'b', 'c']
        toJoin.each {String key ->
            (rand.nextInt(10) + 1).times {
                builder.put(key, rand.nextInt(100) + 1)
            }
        }

        def build = builder.build()
        println build
        build.keySet().each {
            println joiner.join(build.get(it))
        }

    }
}
