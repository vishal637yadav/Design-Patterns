package com.sourcecode.spring.dp.state.parcel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParcelContextServiceTest {

    @Autowired
    private ParcelService parcelService;


    @Test
    void testPackageStateFlow() {
        ParcelContext parcelContext = parcelService.createParcel("John Doe");

        // Initial state
        assertEquals("ORDERED", parcelContext.getCurrentState());

        // Move through states
        parcelService.moveToNextState(parcelContext.getParcelId());
        assertEquals("SHIPPED", parcelContext.getCurrentState());

        parcelService.moveToNextState(parcelContext.getParcelId());
        assertEquals("IN_TRANSIT", parcelContext.getCurrentState());

        parcelService.moveToNextState(parcelContext.getParcelId());
        assertEquals("OUT_FOR_DELIVERY", parcelContext.getCurrentState());

        parcelService.moveToNextState(parcelContext.getParcelId());
        assertEquals("DELIVERED", parcelContext.getCurrentState());
    }

}