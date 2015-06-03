package dayplan.model

import java.util.Date
import java.util.ArrayList
import java.util.HashMap

enum class TaskStatus(val score: Double = 0.0) {
    PLANNED: TaskStatus()
    ABANDONED: TaskStatus(0.33)
    WAITING: TaskStatus(0.66)
    COMPLETE: TaskStatus(1.0)
}

data class PomodoroTrack(val estimated: Int = 1, var complete: Int = 0) {
    fun oneMore() {
        this.complete++;
    }

    fun score(): Double {
        return complete.toDouble() / estimated.toDouble();
    }
}

data class Task(var title: String,
                var status: TaskStatus = TaskStatus.PLANNED,
                var dueToday: Boolean? = false) {

    private var pomodoroTrack: PomodoroTrack? = null;

    fun complete() {
        this.status = TaskStatus.COMPLETE;
    }

    fun abandone() {
        this.status = TaskStatus.ABANDONED;
    }

    fun waiting() {
        this.status = TaskStatus.WAITING;
    }

    fun setDueToday() {
        this.dueToday = true;
    }

    fun estimate(pomodoros: Int) {
        this.pomodoroTrack = PomodoroTrack(pomodoros)
    }

    fun completePomodoro() {
        this.pomodoroTrack?.oneMore();
    }

    fun score(): Double {
        return this.status.score + (this.pomodoroTrack?.score() ?: 0.0);
    }
}

data class Event(var title: String,
                 var dueDate: Date = Date())

data class Routine(val title: String, var completeQty: Int = 0, var plannedQty: Int = 1) {
    fun makeRep() {
        if (completeQty == plannedQty) {
            throw IllegalStateException("Routine ${title} is already complete");
        }

        this.completeQty++;
    }

    fun score(): Double {
        return this.completeQty.toDouble() / this.plannedQty.toDouble();
    }
}

data class Note(var text: String, val createdAt: Date = Date())

class DayPlan(val date: Date = Date()) {
    val tasks = ArrayList<Task>();

    fun addTask(task: Task) {
        tasks.add(task);
    }

    val events = HashMap<java.util.Date, Event>();

    fun addEvent(event: Event) {
        events.put(event.dueDate, event);
    }

    val routines = ArrayList<Routine>();
    fun addRoutine(routine: Routine) {
        routines.add(routine);
    }

    fun dayScore() : Int {
        var dayScore = 0.0;

        tasks.forEach{ dayScore += it.score()  }
        routines.forEach { dayScore += it.score() }

        return (dayScore * 100.0 / 3.0).toInt();
    }

    fun prettyPrint() {
        println("Day plan at ${date}, total score = ${dayScore()}%:\n==Tasks==\n${tasks}\n==Events==\n${events.values()}\n==Routines==\n${routines}");
    }
}

fun main(args: Array<String>) {
    val waterPlants = Task("Water plants")
    println(waterPlants)
    waterPlants.setDueToday();
    waterPlants.complete()
    println("After complete: ${waterPlants}")

    val writeArticle = Task("Write article")
    writeArticle.estimate(3);
    writeArticle.completePomodoro();
    writeArticle.completePomodoro();

    val meeting = Event("Status meeting")
    println(meeting)

    val eyesExercises = Routine("Eyes");
    eyesExercises.makeRep();

    val dayPlan = DayPlan()
    dayPlan.addTask(waterPlants)
    dayPlan.addTask(writeArticle)
    dayPlan.addEvent(meeting)
    dayPlan.addRoutine(eyesExercises)
    dayPlan.prettyPrint()
}