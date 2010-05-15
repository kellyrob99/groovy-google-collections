package org.kar

import com.google.common.base.Predicate
import org.testng.annotations.Test
import org.unitils.UnitilsTestNG
import org.unitils.inject.annotation.TestedObject
import static org.testng.Assert.assertEquals

/**
 * @author Kelly Robinson
 */
class GoogleCollectionsFilterTest extends UnitilsTestNG
{
    @TestedObject
    private GoogleCollectionsFilter filter

    @Test
    public void testFilterByPredicate()
    {
        def toFilter = [1, 2, 3, 4, 5]
        def cl = {it < 3}
        def groovy = toFilter.findAll(cl)
        def google = filter.filterByPredicate(toFilter, cl as Predicate)
        assertEquals(groovy, [1, 2])
        assertEquals(google, groovy)
        assertEquals(filter.filterByPredicate(toFilter, GoogleCollectionsFilter.lessThanThreePredicate), google)
    }

    @Test
    public void testFilterByClass()
    {
        def toFilter = ['a', 1, 'b']
        def cl = {it instanceof Number}
        assertEquals(filter.filterByClass(toFilter, Number.class), toFilter.findAll(cl))

        assertEquals(filter.filterByPredicate(toFilter, cl as Predicate), filter.filterByClass(toFilter, Number.class))
        
        assertEquals(filter.filterByPredicate(toFilter, GoogleCollectionsFilter.numberPredicate), filter.filterByPredicate(toFilter, cl as Predicate))
    }

    @Test
    public void testFilterStringsToTypes()
    {
        def toFilter = ['a', '1', 'b', '2', '3', '.2']
        def cl = { String it ->
            try
            {
                it.toBigDecimal()
            }
            catch (e)
            {
                return false
            }
            true
        }
        def groovy = toFilter.findAll(cl)
        def google = filter.filterByPredicate(toFilter, GoogleCollectionsFilter.bigDecimalFromStringPredicate)
        assertEquals(groovy, google)

        assertEquals(groovy.collect {it.toBigDecimal()}.sum(), 6.2)
        assertEquals(google.collect {it.toBigDecimal()}.sum(), 6.2)
    }
}
