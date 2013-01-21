package name.benjaminAbbitt.orika.guava;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

public class B {
    private Optional<String> foo;

    public B(Optional<String> foo) {
        this.foo = foo;
    }

    public Optional<String> getFoo() {
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
        final B other = (B) obj;
        return Objects.equal(this.foo, other.foo);
    }
}
