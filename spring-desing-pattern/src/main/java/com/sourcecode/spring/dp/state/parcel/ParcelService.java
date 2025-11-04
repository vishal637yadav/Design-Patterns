package com.sourcecode.spring.dp.state.parcel;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class ParcelService {

    private final Map<String, ParcelContext> parcelStore = new ConcurrentHashMap<>();

    private final ApplicationContext applicationContext;

    public ParcelContext createParcel(String recipient) {
        ParcelContext parcelContext = applicationContext.getBean(ParcelContext.class);
        parcelContext.setRecipient(recipient);
        parcelStore.put(parcelContext.getParcelId(), parcelContext);
        return parcelContext;
    }

    public ParcelContext moveToNextState(String parcelId) {
        ParcelContext parcelContext = parcelStore.get(parcelId);
        if (parcelContext != null) {
            parcelContext.nextState();
        }
        return parcelContext;
    }

    public ParcelContext moveToPreviousState(String parcelId) {
        ParcelContext parcelContext = parcelStore.get(parcelId);
        if (parcelContext != null) {
            parcelContext.previousState();
        }
        return parcelContext;
    }

    public ParcelContext getParcel(String parcelId) {
        return parcelStore.get(parcelId);
    }

    public List<ParcelContext> getAllParcels() {
        return new ArrayList<>(parcelStore.values());
    }
}
