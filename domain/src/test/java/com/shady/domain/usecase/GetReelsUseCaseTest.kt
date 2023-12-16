package com.shady.domain.usecase

import com.shady.domain.repo.ReelsRepo
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetReelsUseCaseTest {
    private val repo: ReelsRepo = mockk()
    private val useCase: GetReelsUseCase = GetReelsUseCase(repo)

    @Test
    fun `call repo When call usa case`() = runTest {
        // Given
        coEvery { repo.getReelsFromRemote() } returns mockk()
        // When
        useCase.invoke()
        // Then
        coVerify { repo.getReelsFromRemote() }
    }
}