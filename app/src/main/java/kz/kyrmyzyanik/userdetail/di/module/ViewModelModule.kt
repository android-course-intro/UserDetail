package kz.kyrmyzyanik.userdetail.di.moduleimport androidx.lifecycle.ViewModelimport androidx.lifecycle.ViewModelProviderimport dagger.Bindsimport dagger.Moduleimport dagger.multibindings.IntoMapimport kz.kyrmyzyanik.userdetail.di.ViewModelFactory@Moduleinterface ViewModelModule {    @Binds    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory//    @Binds//    @IntoMap//    @ViewModelKey(SetupAddressViewModel::class)//    fun bindViewModel(viewModel: SetupAddressViewModel): ViewModel}