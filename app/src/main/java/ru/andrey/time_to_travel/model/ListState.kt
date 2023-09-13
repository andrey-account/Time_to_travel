package ru.andrey.time_to_travel.model

sealed interface ListState {
    object Loading : ListState
    object Error : ListState
    object Idle : ListState
}
