package com.sourcecode.spring.dp.state.parcel.state;

/*
ParcelContext Delivery System State Interface
Defines the methods for state transitions and status printing for a package.
 */

import com.sourcecode.spring.dp.state.parcel.ParcelContext;

public interface ParcelState {
    void next(ParcelContext pkg);
    void previous(ParcelContext pkg);
    void printStatus();
    String getStateName();
}
