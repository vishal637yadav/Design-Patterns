package com.sourcecode.spring.dp.state.parcel.state;

import com.sourcecode.spring.dp.state.parcel.ApplicationContextProvider;

import com.sourcecode.spring.dp.state.parcel.ParcelContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DeliveredState implements ParcelState {

    @Override
    public void next(ParcelContext parcelContext) {
        System.out.println("ParcelContext already delivered. End of lifecycle.");
    }

    @Override
    public void previous(ParcelContext parcelContext) {
        parcelContext.setState(ApplicationContextProvider.getBean(OutForDeliveryState.class));
    }

    @Override
    public void printStatus() {
        System.out.println("ParcelContext successfully delivered.");
    }

    @Override
    public String getStateName() {
        return "DELIVERED";
    }

}
