package name.benjaminAbbitt.orika.guava;

import com.google.common.base.Optional;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;


public class OptionalGenericConverter extends BidirectionalConverter<Object, Optional<Object>>{

    @Override
    public Optional<Object> convertTo(Object source, Type<Optional<Object>> destinationType) {
        return Optional.fromNullable(source);
    }

    @Override
    public Object convertFrom(Optional<Object> source, Type<Object> destinationType) {
        return source.orNull();
    }

    @Override
    public boolean canConvert(Type<?> sourceType, Type<?> destinationType){
        boolean ret = destinationType.getRawType().equals(Optional.class) || sourceType.getRawType().equals(Optional.class);
        return ret;
    }
}
