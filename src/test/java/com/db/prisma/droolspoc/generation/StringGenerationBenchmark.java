package com.db.prisma.droolspoc.generation;

import com.db.prisma.droolspoc.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

import java.util.UUID;

@Warmup(iterations = 3, batchSize = 2)
@Measurement(iterations = 5, batchSize = 2)
@Fork(2)
public class StringGenerationBenchmark {
    private static final int SIZE = 36;

    @Benchmark
    public String getStringFromUUID() {
        return UUID.randomUUID().toString();
    }

    @Benchmark
    public String getStringUtils() {
        return Utils.getRandomAlphanum(SIZE);
    }
    @Benchmark
    public String getStringApacheRSU() {
        return RandomStringUtils.randomAlphanumeric(SIZE);
    }
}
