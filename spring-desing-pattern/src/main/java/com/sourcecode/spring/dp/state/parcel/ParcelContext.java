package com.sourcecode.spring.dp.state.parcel;

import com.sourcecode.spring.dp.state.parcel.state.ParcelState;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class ParcelContext {

    // Getters and setters
    @Setter
    private ParcelState state;
    @Getter
    private String parcelId;
    @Setter
    @Getter
    private String recipient;

    public ParcelContext(@Qualifier("orderedState") ParcelState initialState) {
        this.state = initialState;
        this.parcelId = UUID.randomUUID().toString();
    }

    // State delegation methods
    public void nextState() {
        state.next(this);
    }

    public void previousState() {
        state.previous(this);
    }

    public void printStatus() {
        state.printStatus();
    }

    public String getCurrentState() {
        return state.getStateName();
    }

}