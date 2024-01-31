package com.mariomanhique.khodarevent.presentation.screens.home;

import com.mariomanhique.khodarevent.data.repository.KhodarEventsRepoImpl;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<KhodarEventsRepoImpl> repositoryProvider;

  public HomeViewModel_Factory(Provider<KhodarEventsRepoImpl> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<KhodarEventsRepoImpl> repositoryProvider) {
    return new HomeViewModel_Factory(repositoryProvider);
  }

  public static HomeViewModel newInstance(KhodarEventsRepoImpl repository) {
    return new HomeViewModel(repository);
  }
}
