package name.benjaminAbbitt.orika.guava;

import com.google.common.base.Optional;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;


public class OptionalTest {
    private MapperFacade facade;


    @Before
    public void before() {
        MapperFactory factory = new DefaultMapperFactory.Builder().mapNulls(true).build();
        factory = GuavaOrikaConverter.getInstance().registerConverters(factory);
        facade = factory.getMapperFacade();
    }

    @Test
    public void testAToB() {
        String value = "foo";
        A a = new A(value);
        B b = facade.map(a, B.class);
        assertEquals(b, new B(Optional.of(value)));
    }

    @Ignore(value = "Test fails due to possible bug in Orika.")
    @Test
    public void testAToBNull() {
        String value = null;
        A a = new A(value);
        B b = facade.map(a, B.class);
        assertEquals(b, new B(Optional.<String>absent()));
    }

    @Test
    public void testBtoA() {
        String value = "foo";
        B b = new B(Optional.of(value));
        A a = facade.map(b, A.class);
        assertEquals(a, new A(value));
    }


    @Ignore(value = "Test fails due to possible bug in Orika.")
    @Test
    public void testBtoANull() {
        B b = new B(Optional.<String>absent());
        A a = facade.map(b, A.class);
        assertNull(a.getFoo());
    }

}
