package com.example.componentskit

sealed class Screens (val name: String) {
    object HomeScreen: Screens("home")
    object TextScreen: Screens("text")
    object IconScreen: Screens("icon")
    object ButtonScreen: Screens("button")
    object TextFieldScreen: Screens("textfield")
    object CheckBoxScreen: Screens("checkbox")
    object SwitchScreen: Screens("switch")
    object RadioButtonScreen: Screens("radiobutton")
    object ImageScreen: Screens("image")
    object CardScreen: Screens("card")
    object LazyColumnScreen: Screens("lazycolumn")
    object Material3Screen: Screens("material3")
    object AlertDialogScreen: Screens("alertdialog")
    object ToastScreen: Screens("toast")
    object SnackbarScreen: Screens("snackbar")
}