package dayplan.controller

import dayplan.model.DayPlan
import com.jgoodies.binding.PresentationModel
import com.jgoodies.binding.value.ValueModel
import com.jgoodies.binding.value.ValueHolder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import dayplan.view.format

class DayPlanController {

    val dateFormat = SimpleDateFormat("EEEE, dd.MM.yyyy");

    var dayPlan: DayPlan? = null
        set(planToShow) {

       todayModel.setValue(dateFormat.format(planToShow?.date))
       dayScoreModel.setValue(format("day.score", planToShow?.dayScore()))
    }

    val todayModel: ValueModel = ValueHolder(dateFormat.format(Date()))
    val dayScoreModel: ValueModel = ValueHolder()
}