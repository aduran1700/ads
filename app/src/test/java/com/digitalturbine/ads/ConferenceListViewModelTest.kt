package com.digitalturbine.ads

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.digitalturbine.ads.data.model.ResponseState
import com.digitalturbine.ads.data.repository.AdRepository
import com.digitalturbine.ads.ui.adslist.AdListViewModel
import com.digitalturbine.ads.utils.TestConstants
import com.digitalturbine.ads.utils.TestUtils
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ConferenceListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @MockK
    lateinit var adRepository: AdRepository

    lateinit var SUT: AdListViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        TestUtils.setupRxjavaForOneThreadedTest()
        SUT = AdListViewModel(adRepository)
    }

    @Test
    fun `get ad list success`() {
        SUT.adResponse.observeForever {  }

        every { adRepository.getAds() } returns
                Single.just(TestConstants.adList)

        SUT.getAdListData()

        val value : ResponseState? = SUT.adResponse.value

        assertEquals(value, ResponseState.Success(TestConstants.adList))
        value as ResponseState.Success
        assertEquals(value.list.size, 4)
    }

    @Test
    fun `get ad list error`() {
        SUT.adResponse.observeForever {  }
        val errorMessage = "Error"

        every { adRepository.getAds() } returns
                Single.error(Throwable(errorMessage))

        SUT.getAdListData()

        val value : ResponseState? = SUT.adResponse.value

        assertEquals(value, ResponseState.Error(errorMessage))
        value as ResponseState.Error
        assertEquals(value.error, errorMessage)
    }

    @Test
    fun `get ad list empty`() {
        SUT.adResponse.observeForever {  }

        every { adRepository.getAds() } returns
                Single.just(emptyList())

        SUT.getAdListData()

        val value : ResponseState? = SUT.adResponse.value

        assertEquals(value, ResponseState.Empty)
    }
}