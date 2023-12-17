package com.shady.reelsapp

import com.shady.domain.entity.ClipDomainModel
import com.shady.domain.entity.ReelsDomainModel
import com.shady.reelsapp.helper.FakeGetReelsException
import com.shady.reelsapp.helper.FakeGetReelsSuccess
import com.shady.reelsapp.helper.FakeGetReelsThrowable
import com.shady.reelsapp.presentation.mapper.ReelsPresentationMapper
import com.shady.reelsapp.presentation.model.ClipPresentationModel
import com.shady.reelsapp.presentation.model.ReelsIntent
import com.shady.reelsapp.presentation.model.ReelsPresentationModel
import com.shady.reelsapp.helper.ViewModelTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test


class ReelsViewModelTest : ViewModelTest() {
    private val mapper: ReelsPresentationMapper = ReelsPresentationMapper()

    @Test
    fun `get correct response WHEN success`() = runTest {
        // GIVEN
        // domain model
        val responseModelItem = ClipDomainModel("id", "text", "des", "thum")
        val responseModel = ReelsDomainModel(listOf(responseModelItem), "globalTitle")

        // presentation model
        val stateModelItem = ClipPresentationModel("id", "text", "des", "thum")
        val stateModel = ReelsPresentationModel(listOf(stateModelItem), "globalTitle")

        val fakeGetMealsSuccess = FakeGetReelsSuccess()
        val viewModel = ReelsViewModel(mealsUseCase = fakeGetMealsSuccess, mapper = mapper)
        fakeGetMealsSuccess.emit(responseModel)
        // WHEN
        viewModel.intentChannel.send(ReelsIntent.GetReels)
        // THEN
        Assert.assertEquals(stateModel, viewModel.reels.value?.reelsPresentationModel)
        Assert.assertEquals(false, viewModel.reels.value?.isLoading)
        Assert.assertEquals(null, viewModel.reels.value?.error)
    }

    @Test
    fun `get correct response WHEN Exception`() = runTest {
        // GIVEN
        val exception: Exception = Exception()
        val fakeGetMealsException = FakeGetReelsException()
        val viewModel = ReelsViewModel(mealsUseCase = fakeGetMealsException, mapper = mapper)
        fakeGetMealsException.setException(exception)
        // WHEN
        viewModel.intentChannel.send(ReelsIntent.GetReels)
        // THEN
        Assert.assertEquals(null, viewModel.reels.value?.reelsPresentationModel)
        Assert.assertEquals(false, viewModel.reels.value?.isLoading)
        Assert.assertEquals(exception, viewModel.reels.value?.error)
    }

    @Test
    fun `get correct response WHEN Throwable`() = runTest {
        // GIVEN
        val throwable = Throwable("error")
        val fakeGetMealsThrowable = FakeGetReelsThrowable()
        val viewModel = ReelsViewModel(mealsUseCase = fakeGetMealsThrowable, mapper = mapper)
        fakeGetMealsThrowable.setThrowable(throwable)
        // WHEN
        viewModel.intentChannel.send(ReelsIntent.GetReels)
        // THEN
        Assert.assertEquals(null, viewModel.reels.value?.reelsPresentationModel)
        Assert.assertEquals(false, viewModel.reels.value?.isLoading)
        Assert.assertEquals(throwable, viewModel.reels.value?.error)
    }
}