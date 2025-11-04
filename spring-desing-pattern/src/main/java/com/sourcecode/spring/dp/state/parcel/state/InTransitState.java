package com.sourcecode.spring.dp.state.parcel.state;

import com.sourcecode.spring.dp.state.parcel.ApplicationContextProvider;

import com.sourcecode.spring.dp.state.parcel.ParcelContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InTransitState implements ParcelState {

    @Override
    public void next(ParcelContext parcelContext) {
        parcelContext.setState(ApplicationContextProvider.getBean(OutForDeliveryState.class));
    }

    @Override
    public void previous(ParcelContext parcelContext) {
        parcelContext.setState(ApplicationContextProvider.getBean(ShippedState.class));
    }

    @Override
    public void printStatus() {
        System.out.println("ParcelContext is in transit.");
    }

    @Override
    public String getStateName() {
        return "IN_TRANSIT";
    }

}
