package dayplan.view

import javax.swing.*
import java.util.ResourceBundle
import net.miginfocom.swing.MigLayout
import java.text.MessageFormat
import java.util.Date
import com.jgoodies.binding.adapter.BasicComponentFactory
import dayplan.controller.DayPlanController
import dayplan.model.DayPlan
import java.awt.BorderLayout

fun message(key: String): String {
    return ResourceBundle.getBundle("message").getString(key);
}

fun format(key: String, vararg params: Any?): String {
    return MessageFormat.format(message(key), *params);
}

fun img(name: String) : ImageIcon {
    return ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/${name}.png"));
}

class PlanPanel : JPanel() {
    val planController = DayPlanController()
    val newEntryTextField = JTextField(message("newEntryText"))

    fun build() {
        setLayout(MigLayout("debug", "[][][]", "[][][][]"))

        add(BasicComponentFactory.createLabel(planController.todayModel))
        add(JLabel("Here must be pomodoro widget"))
        add(BasicComponentFactory.createLabel(planController.dayScoreModel), "wrap")

        add(newEntryTextField, "spanx 3, growx, wrap")

        planController.dayPlan = DayPlan()
    }
}

fun main(args: Array<String>) {
    val appFrame = JFrame(message("app.title"))
    val planPanel = PlanPanel()
    planPanel.build()

    val container = appFrame.getContentPane()
    container.setLayout(BorderLayout())
    container.add(planPanel, BorderLayout.CENTER)
    appFrame.setSize(800, 600)
    appFrame.setIconImage(img("app").getImage())
    appFrame.setLocationRelativeTo(null)

    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    appFrame.setVisible(true);
}