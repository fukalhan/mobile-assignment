package cz.quanti.rocketapp.rocketlist.presentation

import app.cash.turbine.test
import cz.quanti.rocketapp.rocketdata.domain.GetRocketsUseCase
import cz.quanti.rocketapp.rocketdata.model.Rocket
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.time.LocalDate

class RocketListViewModelTest {

    @Test
    fun `should provide rockets from usecase`() = runTest {
        val rocketId = "falcon1"
        val rocket = Rocket(
            id = rocketId,
            name = "Falcon 1",
            firstFlight = LocalDate.parse("2006-03-24")
        )
        val getRocketsUseCase = mockk<GetRocketsUseCase> {
            coEvery { getRockets() } returns listOf(rocket)
        }

        val viewModel = RocketListViewModel(getRocketsUseCase)
        viewModel.rockets.test {
            expectMostRecentItem().rockets.first() shouldBe RocketItemState(
                rocketId,
                "Falcon 1",
                "First flight: 24.03.2006"
            )
        }
        coVerify { getRocketsUseCase.getRockets() }
    }
}
