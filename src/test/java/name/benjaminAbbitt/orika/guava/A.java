package name.benjaminAbbitt.orika.guava;

import com.google.common.base.Objects;

public class A {
    public A(String foo) {
        this.foo = foo;
    }

    private String foo;

    public String getFoo() {
        return foo;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("foo", foo)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(foo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final A other = (A) obj;
        return Objects.equal(this.foo, other.foo);
    }
}
