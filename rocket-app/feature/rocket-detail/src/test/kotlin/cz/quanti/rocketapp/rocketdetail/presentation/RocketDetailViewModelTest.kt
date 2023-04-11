package cz.quanti.rocketapp.rocketdetail.presentation

import app.cash.turbine.test
import cz.quanti.rocketapp.rocketdata.domain.GetRocketDetailUseCase
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RocketDetailViewModelTest {

    @Test
    fun `should provide rocket detail from use case`() = runTest {
        val rocketId = "falcon1"
        val stage = Stage(
            true,
            3,
            505.2,
            163.5
        )

        val rocketDetail = RocketDetail(
            rocketId,
            "Falcon 1",
            "Description",
            40.3,
            200.1,
            500,
            stage,
            stage,
            listOf("ImageUrl")
        )

        val useCase = mockk<GetRocketDetailUseCase> {
            coEvery { getRocketDetail(rocketId) } returns rocketDetail
        }

        val viewModel = RocketDetailViewModel(useCase)
        viewModel.initRocketDetail(rocketId)
        viewModel.rocketDetail.test {
            expectMostRecentItem() shouldBe RocketDetailState(
                "Falcon 1",
                "Description",
                ParameterState.HeightState(40.3),
                ParameterState.DiameterState(200.1),
                ParameterState.MassState(500),
                stage.toStageState(),
                stage.toStageState(),
                listOf("ImageUrl")
            )
        }
    }
}
