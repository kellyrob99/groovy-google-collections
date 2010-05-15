package org.kar;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.*;
import static com.google.common.collect.Iterables.*;

/**
 * Using Collections2 and Iterables static method calls to provide collection filtering capabilities.
 * Houses Predicate implementations as well.    
 * @author Kelly Robinson
 */
public class GoogleCollectionsFilter
{
    public <T> Collection<T> filterByPredicate(Collection<T> unfiltered, Predicate<? super T> predicate)
    {
        return filter(unfiltered, predicate);
    }

    public <T> Collection<T> filterByClass(Iterable<?> unfiltered, Class<T> typ)
    {
        Iterable<T> iterable = filter(unfiltered, typ);
        List<T> filtered = Lists.newArrayList();
        for (T t : iterable)
        {
            filtered.add(t);
        }
        return filtered;
    }

    public static Predicate lessThanThreePredicate = new Predicate<Integer>()
    {
        public boolean apply(Integer input)
        {
            return input < 3;
        }
    };

    public static Predicate numberPredicate = new Predicate()
    {
        public boolean apply(Object input)
        {
            return input instanceof Number;
        }
    };

    public static Predicate<String> bigDecimalFromStringPredicate = new Predicate<String>()
    {
        public boolean apply(String input)
        {
            try
            {
                BigDecimal.valueOf(Double.valueOf(input));
            }
            catch (Exception e)
            {
                return false;
            }
            return true;
        }
    };
}
