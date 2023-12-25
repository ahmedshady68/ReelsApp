package com.shady.reelsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.domain.usecase.GetReelsUseCaseParent
import com.shady.reelsapp.presentation.mapper.ReelsPresentationMapper
import com.shady.reelsapp.presentation.model.ReelsIntent
import com.shady.reelsapp.presentation.model.ReelsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReelsViewModel @Inject constructor(
    private val mealsUseCase: GetReelsUseCaseParent,
    private val mapper: ReelsPresentationMapper,
) : ViewModel() {

    val intentChannel = Channel<ReelsIntent>(Channel.UNLIMITED)

    private val _reels: MutableStateFlow<ReelsViewState?> =
        MutableStateFlow(ReelsViewState())
    val reels = _reels.asStateFlow()

    init {
        processReels()
    }

    private val exceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            viewModelScope.launch {
                _reels.emit(
                    reels.value?.copy(
                        reelsPresentationModel = null,
                        isLoading = false,
                        error = throwable
                    )
                )
            }
        }

    private fun processReels() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect {
                when (it) {
                    is ReelsIntent.GetReels -> reduceReels()
                }
            }
        }
    }

    private fun reduceReels() {
        viewModelScope.launch(exceptionHandler) {
            _reels.emit(
                reels.value?.copy(isLoading = true, error = null)
            )
            _reels.emit(
                try {
                    reels.value?.copy(
                        reelsPresentationModel = mapper.apply(mealsUseCase()),
                        isLoading = false,
                        error = null
                    )
                } catch (e: Exception) {
                    reels.value?.copy(reelsPresentationModel = null, isLoading = false, error = e)
                }
            )
        }
    }
}