package org.chakarova.botanic.service.impl;

import org.chakarova.botanic.model.entity.Sample;
import org.chakarova.botanic.repository.SampleRepository;
import org.chakarova.botanic.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class SampleServiceImpl implements SampleService {
    private final SampleRepository sampleRepository;
    @Autowired
    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public List<Sample> generateSamplesList() {
        List<Sample>samples = new ArrayList<>();
        for (int i = 0; i <new Random().nextInt(6); i++) {
            Sample sample = new Sample();
            sample.setCollectedOn(Date.from(Instant.now()));
            sample.setDescription("sample description");
            samples.add(sample);
            //this.sampleRepository.saveAndFlush(sample);
        }
        return samples;
    }
}
