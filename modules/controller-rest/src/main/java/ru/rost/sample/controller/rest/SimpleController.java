package ru.rost.sample.controller.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.rost.sample.controller.rest.mappers.SimpleClassMapper;
import ru.rost.sample.rest.api.SimpleSampleApi;
import ru.rost.sample.rest.model.ModelsGetSimpleSampleResponse;
import ru.rost.sample.usecase.SimpleService;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SimpleController implements SimpleSampleApi {
    SimpleClassMapper simpleClassMapper = Mappers.getMapper(SimpleClassMapper.class);
    SimpleService service;

    @Override
    public ResponseEntity<ModelsGetSimpleSampleResponse> simpleSampleGetSimpleSample() {
        var sampleResponse = new ModelsGetSimpleSampleResponse();
        sampleResponse.setSample(simpleClassMapper.toDto(service.getAll()));
        return ResponseEntity.ok(
                sampleResponse
        );
    }
}
