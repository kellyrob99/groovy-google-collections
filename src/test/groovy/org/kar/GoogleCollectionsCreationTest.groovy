package org.kar

import org.testng.annotations.Test
import com.google.common.collect.*
import static org.testng.Assert.assertEquals

/**
 * Comparison of Java built-in and google-collections syntax for creation of Collections.
 * @author Kelly Robinson
 */
public class GoogleCollectionsCreationTest
{
    @Test
    public void testCreateEmptyList()
    {
        List<String> groovyList = []
        List<String> javaList = new ArrayList<String>()
        List<String> googleList = Lists.newArrayList()  //can omit generics

        assertEquals(javaList, googleList)
        assertEquals(groovyList, javaList)
    }

    @Test
    public void testCreatePopulatedList()
    {
        List<String> groovyList = ["1", "2"]
        List<String> javaList = Arrays.asList("1", "2")
        List<String> googleList = Lists.newArrayList("1", "2")

        assertEquals(javaList, googleList)
        assertEquals(groovyList, javaList)
    }

    @Test
    public void testCreateImmutableList()
    {
        List<String> groovyList = ["1", "2"].asImmutable()
        List<String> javaList = Collections.unmodifiableList(Arrays.asList("1", "2"))
        List<String> googleList = ImmutableList.of("1", "2")

        assertEquals(javaList, googleList)
        assertEquals(groovyList, javaList)
    }

    @Test
    public void testCreateMap()
    {
        Map<String, String> groovyMap = [:]
        Map<String, String> javaMap = new LinkedHashMap<String, String>()
        Map<String, String> googleMap = Maps.newLinkedHashMap()

        assertEquals(javaMap, googleMap)
        assertEquals(groovyMap, javaMap)
    }

    @Test
    public void testCreateImmutableMap()
    {
        Map<String, String> groovyMap = ["a": "1", "b": "2"].asImmutable()

        Map<String, String> javaMap = new LinkedHashMap<String,String>()
        javaMap.put("a", "1")
        javaMap.put("b", "2")
        javaMap = Collections.unmodifiableMap(javaMap)

        Map<String, String> googleMap = ImmutableMap.of("a", "1", "b", "2")  //clunky syntax but it works

        assertEquals(javaMap, googleMap)
        assertEquals(groovyMap, javaMap)
    }

}
