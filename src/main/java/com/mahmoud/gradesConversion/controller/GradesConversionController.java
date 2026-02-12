package com.mahmoud.gradesConversion.controller;

import com.mahmoud.gradesConversion.dto.RequestDto;
import com.mahmoud.gradesConversion.service.GradesConversionService;
import com.mahmoud.gradesConversion.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class GradesConversionController {
    private final GradesConversionService gradesConversionService;

    @PostMapping("/convert")
    public ResponseDto convert(
        @Valid @RequestBody RequestDto request
    ) {
        return gradesConversionService.convert(request);
    }
}
