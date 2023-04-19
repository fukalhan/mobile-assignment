package cz.quanti.rocketapp.rocketdetail.presentation

import cz.quanti.rocketapp.design.presentation.StringResources
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage
import cz.quanti.rocketapp.rocketdetail.R
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class RocketDetailExtensionTest {

    @Test
    fun `should provide rocket detail state from rocket detail`() {
        val stage = Stage(
            true,
            3,
            555.5,
            555.5
        )
        val rocketDetail = RocketDetail(
            "falcon1",
            "Falcon 1",
            "Description",
            40.3,
            200.1,
            500,
            stage,
            stage,
            listOf("ImageUrl")
        )
        val stringRes = mockk<StringResources> {
            every { getString(R.string.heightVal, round(40.3)) } returns "40.30m"
            every { getString(R.string.diameterVal, round(200.1)) } returns "200.10m"
            every { getString(R.string.massVal, 500) } returns "500t"
            every { getString(R.string.height) } returns "height"
            every { getString(R.string.diameter) } returns "diameter"
            every { getString(R.string.mass) } returns "mass"
            every { getString(R.string.reusable) } returns "reusable"
            every { getString(R.string.notReusable) } returns "not reusable"
            every { getString(R.string.enginesNum, stage.engines) } returns "3 engines"
            every { getString(R.string.fuelAmount, stage.fuelAmount) } returns "555.5 tons of fuel"
            every { getString(R.string.burnTime, stage.burnTime) } returns "555.5 seconds burn time"
        }

        rocketDetail.toRocketDetailState(stringRes).apply {
            this.name shouldBe "Falcon 1"
            this.overview shouldBe "Description"
            this.height shouldBe ParameterState("40.30m", "height")
            this.diameter shouldBe ParameterState("200.10m", "diameter")
            this.mass shouldBe ParameterState("500t", "mass")
            this.firstStage shouldBe stage.toStageState(stringRes)
            this.secondStage shouldBe stage.toStageState(stringRes)
            this.images shouldBe listOf("ImageUrl")
        }
    }
}
