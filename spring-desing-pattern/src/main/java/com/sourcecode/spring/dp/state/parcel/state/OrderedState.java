package com.sourcecode.spring.dp.state.parcel.state;

import com.sourcecode.spring.dp.state.parcel.ApplicationContextProvider;

import com.sourcecode.spring.dp.state.parcel.ParcelContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderedState implements ParcelState {

    @Override
    public void next(ParcelContext parcelContext) {
        parcelContext.setState(ApplicationContextProvider.getBean(ShippedState.class));
    }

    @Override
    public void previous(ParcelContext parcelContext) {
        System.out.println("ParcelContext is in its initial state.");
    }

    @Override
    public void printStatus() {
        System.out.println("ParcelContext ordered, not yet shipped.");
    }

    @Override
    public String getStateName() {
        return "ORDERED";
    }

}
