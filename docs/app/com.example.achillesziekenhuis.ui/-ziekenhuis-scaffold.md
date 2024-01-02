//[app](../../index.md)/[com.example.achillesziekenhuis.ui](index.md)/[ZiekenhuisScaffold](-ziekenhuis-scaffold.md)

# ZiekenhuisScaffold

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ZiekenhuisScaffold](-ziekenhuis-scaffold.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, canNavigateBack: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), navigateUp: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), currentScreenTitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), goHome: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), goToAbout: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), goToLogin: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), viewModel: [LoginViewModel](../com.example.achillesziekenhuis.ui.login/-login-view-model/index.md) = viewModel(factory = LoginViewModel.Factory), content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)([Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Simplified version of [Scaffold](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary.html) that is used throughout the app.
