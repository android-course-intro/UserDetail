package kz.kyrmyzyanik.userdetail.di.moduleimport androidx.lifecycle.ViewModelimport androidx.lifecycle.ViewModelProviderimport dagger.Bindsimport dagger.Moduleimport dagger.multibindings.IntoMapimport kz.kyrmyzyanik.userdetail.di.ViewModelFactoryimport kz.kyrmyzyanik.userdetail.di.ViewModelKeyimport kz.kyrmyzyanik.userdetail.ui.login.LoginViewModel@Moduleinterface ViewModelModule {    @Binds    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory    @Binds    @IntoMap    @ViewModelKey(LoginViewModel::class)    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel}