package cz.quanti.rocketapp.rocketdata.data

import cz.quanti.rocketapp.rocketdata.data.rocket.RocketResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.DiameterResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.HeightResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.MassResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.RocketDetailResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.StageResponse
import cz.quanti.rocketapp.rocketdata.domain.RocketApiService
import cz.quanti.rocketapp.rocketdata.model.rocket.Rocket
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.time.LocalDate

class SpaceXRocketRepositoryTest {

    @Test
    fun `should provide rockets from api`() = runTest {
        val response = RocketResponse(
            "falcon1",
            "Falcon 1",
            "2006-03-24"
        )
        val api = mockk<RocketApiService> {
            coEvery { getRockets() } returns listOf(response)
        }

        val repo = SpaceXRocketRepository(api)
        val rockets = repo.getRockets()

        rockets.first() shouldBe Rocket("falcon1", "Falcon 1", LocalDate.parse(response.firstFlight))
    }

    @Test
    fun `should provide rocket detail from api`() = runTest {
        val rocketId = "falcon1"
        val rocketDetailResponse = RocketDetailResponse(
            rocketId,
            "Falcon 1",
            "Description",
            HeightResponse(40.3),
            DiameterResponse(200.1),
            MassResponse(500),
            StageResponse(
                true,
                3,
                505.2,
                163.5
            ),
            StageResponse(
                false,
                2,
                435.3,
                234.4
            )
        )

        val api = mockk<RocketApiService> {
            coEvery { getRocketDetail(rocketId) } returns rocketDetailResponse
        }

        val repo = SpaceXRocketRepository(api)
        val rocketDetail = repo.getRocketDetail(rocketId)

        rocketDetail shouldBe RocketDetail(
            "falcon1",
            "Falcon 1",
            "Description",
            40.3,
            200.1,
            500,
            Stage(
                true,
                3,
                505.2,
                163.5
            ),
            Stage(
                false,
                2,
                435.3,
                234.4
            )
        )
    }
}
