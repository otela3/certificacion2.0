package com.example.certificacion20.network;

import com.example.certificacion20.model.NovaResponse;
import retrofit2.http.GET;
import io.reactivex.rxjava3.core.Observable;

public interface NovaApiService {

    @GET("nova")
    Observable<NovaResponse> getNova();
}
