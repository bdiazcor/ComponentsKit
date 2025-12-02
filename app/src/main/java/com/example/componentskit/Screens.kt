package com.example.componentskit

sealed class Screens (val name: String) {
    object HomeScreen: Screens("home")
    object TextScreen: Screens("text")
    object IconScreen: Screens("icon")
    object ButtonScreen: Screens("button")
    object TextFieldScreen: Screens("textfield")
}