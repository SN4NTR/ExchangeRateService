package com.demo.app.core.web.converter;

import com.demo.app.exception.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Slf4j
public class XmlConverter {

    private static final ObjectMapper XML_OBJECT_MAPPER = new XmlMapper();

    public static <T> T fromXml(final String xml, final Class<T> tClass) {
        try {
            return XML_OBJECT_MAPPER.readValue(xml, tClass);
        } catch (Exception ex) {
            final String message = ex.getMessage();
            log.error(message);
            throw new ServiceException(message, ex);
        }
    }
}
