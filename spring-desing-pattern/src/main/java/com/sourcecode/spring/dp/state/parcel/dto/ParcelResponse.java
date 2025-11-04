package com.sourcecode.spring.dp.state.parcel.dto;

import com.sourcecode.spring.dp.state.parcel.ParcelContext;
import lombok.Getter;

@Getter
public class ParcelResponse {
    private final String parcelId;
    private final String recipient;
    private final String currentState;

    public ParcelResponse(ParcelContext pkg) {
        this.parcelId = pkg.getParcelId();
        this.recipient = pkg.getRecipient();
        this.currentState = pkg.getCurrentState();
    }

}
