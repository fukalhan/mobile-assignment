package cz.quanti.rocketapp.rocketdata.data

import cz.quanti.rocketapp.rocketdata.data.rocketdetail.DiameterResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.HeightResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.MassResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.RocketDetailResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.StageResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.toRocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage
import io.kotest.matchers.shouldBe
import org.junit.Test

class RocketDetailResponseExtensionTest {

    @Test
    fun `should provide rocket detail from rocket detail response`() {
        val rocketDetailResponse = RocketDetailResponse(
            "falcon1",
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

        val rocketDetail = rocketDetailResponse.toRocketDetail()
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
