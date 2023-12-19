package com.example.demo.design_pattern.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class Visa {
    private String type;
    private Date asserted;
    private String value;
    private String source;
    private String by;
    private String[] conditions;

    Visa(final String type, final Date asserted, final String value, final String source, final String by, final String[] conditions) {
        this.type = type;
        this.asserted = asserted;
        this.value = value;
        this.source = source;
        this.by = by;
        this.conditions = conditions;
    }

    public static VisaBuilder builder() {
        return new VisaBuilder();
    }

    public static class VisaBuilder {
        private String type;
        private Date asserted;
        private String value;
        private String source;
        private String by;
        private String[] conditions;

        public VisaBuilder type(final String type) {
            this.type = type;
            return this;
        }

        public VisaBuilder asserted(final Date asserted) {
            this.asserted = asserted;
            return this;
        }

        public VisaBuilder value(final String value) {
            this.value = value;
            return this;
        }

        public VisaBuilder source(final String source) {
            this.source = source;
            return this;
        }

        public VisaBuilder by(final String by) {
            this.by = by;
            return this;
        }

        public VisaBuilder conditions(final String[] conditions) {
            this.conditions = conditions;
            return this;
        }

        public Visa build() {
            return new Visa(this.type, this.asserted, this.value, this.source, this.by, this.conditions);
        }
    }
}