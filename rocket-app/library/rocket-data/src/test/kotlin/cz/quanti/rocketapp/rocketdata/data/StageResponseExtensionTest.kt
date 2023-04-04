package cz.quanti.rocketapp.rocketdata.data

import cz.quanti.rocketapp.rocketdata.data.rocketdetail.StageResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.toStage
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage
import io.kotest.matchers.shouldBe
import org.junit.Test

class StageResponseExtensionTest {

    @Test
    fun `should provide stage from stage response`() {
        val stageResponse = StageResponse(
            true,
            3,
            505.2,
            163.5
        )

        val stage = stageResponse.toStage()
        stage shouldBe Stage(
            true,
            3,
            505.2,
            163.5
        )
    }
}
