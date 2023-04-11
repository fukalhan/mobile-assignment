package cz.quanti.rocketapp.rocketdata.domain

import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetRocketDetailUseCaseTest {

    @Test
    fun `should provide rocket detail from repository`() = runTest {
        val rocketId = "falcon1"
        val rocketDetail = RocketDetail(
            rocketId,
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
            ),
            listOf("ImageUrl")
        )

        val repository = mockk<RocketRepository> {
            coEvery { getRocketDetail(rocketId) } returns rocketDetail
        }

        val useCase = GetRocketDetailUseCase(repository)
        val rocket = useCase.getRocketDetail(rocketId)

        rocket shouldBe rocketDetail
    }
}
