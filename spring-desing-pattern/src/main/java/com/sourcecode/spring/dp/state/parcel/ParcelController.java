package com.sourcecode.spring.dp.state.parcel;

import com.sourcecode.spring.dp.state.parcel.dto.CreateParcelRequest;
import com.sourcecode.spring.dp.state.parcel.dto.ParcelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    @PostMapping
    public ResponseEntity<ParcelResponse> createParcel(@RequestBody CreateParcelRequest request) {
        ParcelContext parcel = parcelService.createParcel(request.getRecipient());
        return ResponseEntity.ok(new ParcelResponse(parcel));
    }

    @PutMapping("/{parcelId}/next")
    public ResponseEntity<ParcelResponse> moveToNextState(@PathVariable String parcelId) {
        ParcelContext parcelContext = parcelService.moveToNextState(parcelId);
        if (parcelContext == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ParcelResponse(parcelContext));
    }

    @PutMapping("/{parcelId}/previous")
    public ResponseEntity<ParcelResponse> moveToPreviousState(@PathVariable String parcelId) {
        ParcelContext parcelContext = parcelService.moveToPreviousState(parcelId);
        if (parcelContext == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ParcelResponse(parcelContext));
    }

    @GetMapping("/{parcelId}")
    public ResponseEntity<ParcelResponse> getPackage(@PathVariable String parcelId) {
        ParcelContext parcelContext = parcelService.getParcel(parcelId);
        if (parcelContext == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ParcelResponse(parcelContext));
    }

    @GetMapping
    public ResponseEntity<List<ParcelResponse>> getAllParcels() {
        List<ParcelResponse> responses = parcelService.getAllParcels()
                .stream()
                .map(ParcelResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

}