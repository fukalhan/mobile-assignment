package cz.quanti.rocketapp.rocketdata.domain

import cz.quanti.rocketapp.rocketdata.model.Rocket
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.time.LocalDate

class GetRocketsUseCaseTest {

    @Test
    fun `should provide rockets from repository` () = runTest {
        val rocket = Rocket(
            id = "falcon1",
            name = "Falcon 1",
            firstFlight = LocalDate.parse("2006-03-24")
        )

        val repository = mockk<RocketRepository> {
            coEvery { getRockets() } returns listOf(rocket)
        }

        val useCase = GetRocketsUseCase(repository)
        val rockets = useCase.getRockets()

        rockets.first() shouldBe rocket
    }
}