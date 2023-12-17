package com.shady.data.repo

import com.shady.data.mapper.ReelDataMapper
import com.shady.data.remote.ApiService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ReelsRepoImplTest {
    private val apiService: ApiService = mockk()
    private val mapper: ReelDataMapper = mockk()
    private val repo: ReelsRepoImpl = ReelsRepoImpl(apiService, mapper)

    @Test
    fun `call apiService WHEN call the RepoImpl`() = runTest {
        // Given
        coEvery { apiService.getReels(any(), any(), any()) } returns mockk()
        coEvery { mapper.apply(any()) } returns mockk()
        // When
        repo.getReelsFromRemote()
        // Then
        coVerify { apiService.getReels(any(), any(), any()) }
    }
}