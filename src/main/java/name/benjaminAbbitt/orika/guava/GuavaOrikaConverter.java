package name.benjaminAbbitt.orika.guava;

import com.google.common.base.Optional;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;

public class GuavaOrikaConverter {
    private static GuavaOrikaConverter ourInstance = new GuavaOrikaConverter();

    public static GuavaOrikaConverter getInstance() {
        return ourInstance;
    }

    private GuavaOrikaConverter() {

    }

    public MapperFactory registerConverters(MapperFactory mapperFactory){
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        //converterFactory.registerConverter(new PassThroughConverter(Optional.class));
        converterFactory.registerConverter(new OptionalGenericConverter());
        return mapperFactory;
    }
}