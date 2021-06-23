package com.dfsek.terra.config.loaders.config.sampler.templates.normalizer;

import com.dfsek.tectonic.annotations.Value;
import com.dfsek.terra.api.noise.NoiseSampler;
import com.dfsek.terra.noise.normalizer.ClampNormalizer;
import com.dfsek.terra.noise.normalizer.LinearNormalizer;

@SuppressWarnings({"unused", "FieldMayBeFinal"})
public class ClampNormalizerTemplate extends NormalizerTemplate<LinearNormalizer> {
    @Value("max")
    private double max;

    @Value("min")
    private double min;

    @Override
    public NoiseSampler apply(Long seed) {
        return new ClampNormalizer(function.apply(seed), min, max);
    }
}
