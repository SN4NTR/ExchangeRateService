package com.demo.app.exchangerate.dto;

import com.demo.app.exchangerate.dto.EuropeanCentralBankExchangeRateDto.CubeDto.DateCubeDto.CurrencyRateCubeDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.MIN;
import static java.util.Collections.emptyList;
import static java.util.Objects.nonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "Cube")
@Data
public class EuropeanCentralBankExchangeRateDto {

    private String subject;

    @JacksonXmlProperty(localName = "Cube")
    private CubeDto cube;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class CubeDto {

        @JacksonXmlProperty(localName = "Cube")
        private DateCubeDto dateCube;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Data
        public static class DateCubeDto {

            @JacksonXmlProperty(isAttribute = true)
            private String time;

            private List<CurrencyRateCubeDto> currencyRateCubes = new ArrayList<>();

            @JsonSetter(value = "Cube")
            public void setCurrencyRateCubes(CurrencyRateCubeDto currencyRateCubeDto) {
                this.currencyRateCubes.add(currencyRateCubeDto);
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            @Data
            public static class CurrencyRateCubeDto {

                @JacksonXmlProperty(isAttribute = true)
                private String currency;

                @JacksonXmlProperty(isAttribute = true)
                private String rate;

                public Float getRate() {
                    return Float.parseFloat(rate);
                }
            }
        }
    }

    public LocalDate getDate() {
        return nonNull(cube) && nonNull(cube.getDateCube())
                ? LocalDate.parse(cube.getDateCube().getTime())
                : MIN;
    }

    public List<CurrencyRateCubeDto> getCurrencyRates() {
        return nonNull(cube) && nonNull(cube.getDateCube()) && !cube.getDateCube().getCurrencyRateCubes().isEmpty()
                ? cube.getDateCube().getCurrencyRateCubes()
                : emptyList();
    }
}
