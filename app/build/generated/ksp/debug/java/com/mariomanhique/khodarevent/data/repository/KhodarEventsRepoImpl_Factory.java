package com.mariomanhique.khodarevent.data.repository;

import com.mariomanhique.khodarevent.network.KhodarEventsApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class KhodarEventsRepoImpl_Factory implements Factory<KhodarEventsRepoImpl> {
  private final Provider<KhodarEventsApi> apiProvider;

  public KhodarEventsRepoImpl_Factory(Provider<KhodarEventsApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public KhodarEventsRepoImpl get() {
    return newInstance(apiProvider.get());
  }

  public static KhodarEventsRepoImpl_Factory create(Provider<KhodarEventsApi> apiProvider) {
    return new KhodarEventsRepoImpl_Factory(apiProvider);
  }

  public static KhodarEventsRepoImpl newInstance(KhodarEventsApi api) {
    return new KhodarEventsRepoImpl(api);
  }
}
