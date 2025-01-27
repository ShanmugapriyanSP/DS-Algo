package com.data.structures.algorithms.java.design.patterns.creational.builder;

public class BuilderPattern {

    private int value1;
    private int value2;

    private BuilderPattern(BuilderPatternBuilder builder) {
        this.value1 = builder.value1;
        this.value2 = builder.value2;
    }

    public static BuilderPatternBuilder getBuilder() {
        return new BuilderPatternBuilder();
    }

    public static class BuilderPatternBuilder {
        private int value1;
        private int value2;

        public BuilderPatternBuilder setValue1(int value1) {
            this.value1 = value1;
            return this;
        }

        public BuilderPatternBuilder setValue2(int value2) {
            this.value2 = value2;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }
}
