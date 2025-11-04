package com.sourcecode.spring.dp.state.parcel.state;

import com.sourcecode.spring.dp.state.parcel.ApplicationContextProvider;

import com.sourcecode.spring.dp.state.parcel.ParcelContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OutForDeliveryState implements ParcelState {

    @Override
    public void next(ParcelContext parcelContext) {
        parcelContext.setState(ApplicationContextProvider.getBean(DeliveredState.class));
    }

    @Override
    public void previous(ParcelContext parcelContext) {
        parcelContext.setState(ApplicationContextProvider.getBean(InTransitState.class));
    }

    @Override
    public void printStatus() {
        System.out.println("ParcelContext is out for delivery.");
    }

    @Override
    public String getStateName() {
        return "OUT_FOR_DELIVERY";
    }
}
