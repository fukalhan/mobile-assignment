package cz.quanti.rocketapp.rocketdata.data.rocket

import cz.quanti.rocketapp.rocketdata.model.rocket.Rocket
import java.time.LocalDate

internal fun RocketResponse.toRocket(): Rocket {
    return Rocket(
        this.id,
        this.name,
        LocalDate.parse(this.firstFlight)
    )
}
