package cz.quanti.rocketapp.rocketdetail.presentation

import app.cash.turbine.test
import cz.quanti.rocketapp.design.presentation.StringResources
import cz.quanti.rocketapp.rocketdata.domain.GetRocketDetailUseCase
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import io.kotest.matchers.should
import io.kotest.matchers.types.beInstanceOf
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RocketDetailViewModelTest {

    @Test
    fun `should provide rocket detail from use case`() = runTest {
        val rocketId = "falcon1"
        val rocketDetail = mockk<RocketDetail>()

        val useCase = mockk<GetRocketDetailUseCase> {
            coEvery { getRocketDetail(rocketId) } returns rocketDetail
        }
        val stringRes = mockk<StringResources>()

        val viewModel = RocketDetailViewModel(useCase, stringRes)
        viewModel.initRocketDetail(rocketId)
        viewModel.rocketDetail.test {
            expectMostRecentItem() should beInstanceOf<RocketDetailState>()
        }
    }
}
